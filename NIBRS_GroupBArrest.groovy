import com.sustain.DomainObject
import com.sustain.cases.model.Case
import com.sustain.document.model.Document
import com.sustain.properties.model.SystemProperty
import com.sustain.util.StringUtils

import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.sql.Timestamp;
import java.nio.file.Path;
import java.io.FileWriter;
import java.io.PrintWriter;
import com.sustain.mail.Attachments;
import org.json.JSONArray;
import org.json.JSONObject;
import com.sustain.entities.custom.CtInterfaceTracking;
import com.sustain.entities.custom.CtInterfaceTrackingDetail;
import java.time.temporal.TemporalAdjusters;
import com.sustain.cases.model.Charge;
import com.sustain.cases.model.Party;
import com.sustain.expression.Where;
import com.sustain.document.model.Document;
import com.sustain.document.model.DocDef;
import com.sustain.lookuplist.model.LookupItem;

//*All Group B offense UCR codes are invalid for MS NIBRS, this workflow/business rule is deactivated

//offensesMap stores UCR offense label and code
def Map offensesMap = new HashMap();
//GROUP B OFFENSES
//crimes against person, property, or society
offensesMap.put("90Z", "ALL_OTHER_OFFENSES");//tested

//crimes against society
offensesMap.put("90C", "DISORDERLY_CONDUCT");//tested
offensesMap.put("90D", "DRIVING_UNDER_INFLUENCE");//tested
offensesMap.put("90F", "FAMILY_OFFENSES_NONVIOLENT");//tested
offensesMap.put("90G", "LIQUOR_LAW_VIOLATIONS");//tested
offensesMap.put("90J", "TRESPASSING");//tested

def String internalTesting = SystemProperty.getValue("nibrs.email.testing") ?: "true";
def String ucrstatEmailAddress = SystemProperty.getValue("nibrs.email.inbox") ?: "";
def String ucrstatEmailAddressCC = SystemProperty.getValue("nibrs.email.inbox.cc") ?: "";


def int report_year = _report_year == null ? 0 : Integer.parseInt(_report_year);
def int report_month = _report_month == null ? 0 : Month.valueOf(_report_month).getValue();
logger.debug("report year: ${report_year} report month: ${report_month}");

//pst:America/Los_Angeles, cst:America/Chicago
def LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Chicago")).withNano(0);
String incidentDateTimeFormatted = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
if (_overwrite_default_reporting_period == "true") {
    if (report_month != 0) {
        localDateTime = localDateTime.withMonth(report_month);
    }
    if (report_year != 0) {
        localDateTime = localDateTime.withYear(report_year);
    }
}

def LocalDate localDate = localDateTime.toLocalDate();
def LocalDate localDateLastDayOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());
def Timestamp nowTimestamp = Timestamp.valueOf(localDateTime);

def LocalDateTime localDateTimeStart = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0).withNano(0);

def LocalDateTime localDateTimeEnd = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(58).withNano(999999999);

def String batch = "${localDateTime.month}${localDateTime.year}";

_reportingPeriod = "${localDateTimeStart} : ${localDateTimeEnd}".toString();
_lastDayOfMonth = "lastDayOfTheMonth:${localDate == localDateLastDayOfMonth} - ${localDateLastDayOfMonth}".toString();
logger.debug("reporting period: ${_reportingPeriod}");

if (localDate == localDateLastDayOfMonth || internalTesting == "true") {
    def DateTimeFormatter yearMonthFomatter = DateTimeFormatter.ofPattern("yyyy-MM");
    def DateTimeFormatter yearMonthDayFomatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String reportType = "GroupBArrestReport";
    String rootPath = "\\\\edc-isilon-smb\\ags2docsuat\\NIBRS";
    LocalDate reportDate = LocalDate.now();
    String reportFileNamePrefix = "EAttorney_${reportType}_${reportDate.getMonth()}_${reportDate.getDayOfMonth()}_${reportDate.getYear()}_".toString();
    String reportFileNameSuffix = ".xml";
    File rootDir = new File(rootPath);
    String messageIdentifier = "TEST";

//ORI number must match this pattern [A-Z]{2}+[0-9]{7}+
    String oriPattern = "[A-Z]{2}+[0-9]{7}+";
    String submittingAgencyORINumber = SystemProperty.getValue("nibrs.ori.agency.submitting")?.matches(oriPattern) ? SystemProperty.getValue("nibrs.ori.agency.submitting") : "MS090017V";
    //default test value
    String owningAgencyORINumber = SystemProperty.getValue("nibrs.ori.agency.owning")?.matches(oriPattern) ? SystemProperty.getValue("nibrs.ori.agency.owning") : "MS090017V";

    logger.debug("submittingAgencyORINumber:${submittingAgencyORINumber}, owningAgencyORINumber:${owningAgencyORINumber}");
    String reportActionCategoryCode = "A";
    def ArrayList<String> offenseUCRCodeGroupB = offensesMap.values();

// Option selectec by user
    ArrayList<String> arresteeArmedWithCode = DomainObject.find(LookupItem.class, "lookupList.name", "ARRESTEE_ARMED_WITH_CODE").code;
// Option selectec by user
    ArrayList<String> arrestCategoryCode = DomainObject.find(LookupItem.class, "lookupList.name", "ARREST_CATEGORY_CODE").code;

    String nIBRSReportCategoryCode = "GROUP B ARREST REPORT";
    String personResidentCode = "R";

    int maxAgeRange = 25; //default value
    int minAgeRange = 20; //default value

// Charges to submit
    def Where whereCharge = new Where()
            .addGreaterThanOrEquals("chargeDate", Timestamp.valueOf(localDateTimeStart))
            .addLessThanOrEquals("chargeDate", Timestamp.valueOf(localDateTimeEnd))
            .addIsNotNull("chargeAttributes")
            .addContainsAny("chargeAttributes", offenseUCRCodeGroupB)

    if (_cse != null) {
        whereCharge.addEquals("associatedParty.case", _cse);
    }

    ArrayList<Charge> offenses = DomainObject.find(Charge.class, whereCharge)
    .findAll({Charge it -> (it.updateReason == null || it.updateReason.isEmpty() || it.updateReason != "NIBRS")});
    ArrayList<Charge> charesToUpdate = new ArrayList<>();


    offenses = offenses.unique({ it -> getOffenseUCRCode(it) });
    logger.debug("Loop offenses: ${offenses}");

    for (def Charge offense in offenses) {
        def Case cse = offense.associatedParty.case;
        def String caseCountry = cse.county ?: "";
        def String caseJudicialDistrictCode = com.sustain.rule.model.RuleDef.exec("NIBRS_DISTRICT", null, ["caseCounty": caseCountry]).getValue("judicialDistrict") ?: "";
        def String uuid = StringUtils.uuid();
        def Document reportDoc;
        Party subject = offense.associatedParty;
        OtherCaseNumber agencyNumber = subject.case.collect("otherCaseNumbers[type == 'AGENCY' && number != null]").find({ it -> it != null });
        String identificationID = agencyNumber != null && agencyNumber.number != null ? agencyNumber.number : "1234";
        String offenseUCRCode = getOffenseUCRCode(offense);

        Path reportPath = Files.createTempFile(rootDir.toPath(), "${cse.id}_${offense.id}_${offense.associatedParty.id}_${reportFileNamePrefix}_${offenseUCRCode}_".toString(), reportFileNameSuffix);
        File reportFile = reportPath.toFile();
        PrintWriter fileWriter = new PrintWriter(reportFile);

        try {
            if (!Files.exists(rootDir?.toPath())) {
                rootDir.mkdir();
            }

            fileWriter.println("""<nibrs:Submission xmlns:nibrs="http://fbi.gov/cjis/nibrs/4.2" 
xmlns:cjis="http://fbi.gov/cjis/1.0" 
xmlns:cjiscodes="http://fbi.gov/cjis/cjis-codes/1.0" 
xmlns:i="http://release.niem.gov/niem/appinfo/3.0/" 
xmlns:ucr="http://release.niem.gov/niem/codes/fbi_ucr/3.2/" 
xmlns:j="http://release.niem.gov/niem/domains/jxdm/5.2/" 
xmlns:term="http://release.niem.gov/niem/localTerminology/3.0/" 
xmlns:nc="http://release.niem.gov/niem/niem-core/3.0/" 
xmlns:niem-xsd="http://release.niem.gov/niem/proxy/xsd/3.0/" 
xmlns:s="http://release.niem.gov/niem/structures/3.0/" 
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
xmlns:xsd="http://www.w3.org/2001/XMLSchema" 
xmlns:nibrscodes="http://fbi.gov/cjis/nibrs/nibrs-codes/4.2" 
xmlns:msibrs="http://www.beyond2020.com/msibrs/1.0" 
xsi:schemaLocation="http://www.beyond2020.com/msibrs/1.0 ../base-xsd/msibrs/1.0/msibrs.xsd">""");


            fileWriter.println("<cjis:MessageMetadata>");
            //<!-- Message Timestamp -->
            fileWriter.println("<cjis:MessageDateTime>${localDateTime}</cjis:MessageDateTime>");
            //<!-- Message ID -->
            fileWriter.println("<cjis:MessageIdentification>");
            fileWriter.println("<nc:IdentificationID>${messageIdentifier}</nc:IdentificationID>");
            fileWriter.println("</cjis:MessageIdentification>");
            //<!-- NIBRS IEPD Version -->
            fileWriter.println("<cjis:MessageImplementationVersion>2019.2</cjis:MessageImplementationVersion>");
            fileWriter.println("<cjis:MessageSubmittingOrganization>");
            fileWriter.println("<j:OrganizationAugmentation>");
            fileWriter.println("<j:OrganizationORIIdentification>");
            //<!-- Submitting Agency ORI -->
            fileWriter.println("<nc:IdentificationID>${submittingAgencyORINumber}</nc:IdentificationID>");
            fileWriter.println("</j:OrganizationORIIdentification>");
            fileWriter.println("</j:OrganizationAugmentation>");
            fileWriter.println("</cjis:MessageSubmittingOrganization>");
            fileWriter.println("</cjis:MessageMetadata>");
            fileWriter.println("<nibrs:Report>");
            fileWriter.println("<nibrs:ReportHeader>");
            //<!-- Submission Type -->
            fileWriter.println("<nibrs:NIBRSReportCategoryCode>${nIBRSReportCategoryCode}</nibrs:NIBRSReportCategoryCode>");
            //<!-- Submission Action Type -->
            fileWriter.println("<nibrs:ReportActionCategoryCode>${reportActionCategoryCode}</nibrs:ReportActionCategoryCode>");
            //<!-- Year/Month Of Report -->
            fileWriter.println("<nibrs:ReportDate>");
            fileWriter.println("<nc:YearMonthDate>${localDate.format(yearMonthFomatter)}</nc:YearMonthDate>");
            fileWriter.println("</nibrs:ReportDate>");
            fileWriter.println("<nibrs:ReportingAgency>");
            fileWriter.println("<j:OrganizationAugmentation>");
            fileWriter.println("<j:OrganizationORIIdentification>");
            //<!-- Element 1, ORI Code, Owning Agency ORI -->
            fileWriter.println("<nc:IdentificationID>${owningAgencyORINumber}</nc:IdentificationID>");
            fileWriter.println("</j:OrganizationORIIdentification>");
            fileWriter.println("</j:OrganizationAugmentation>");
            fileWriter.println("</nibrs:ReportingAgency>");
            fileWriter.println("</nibrs:ReportHeader>");

            fileWriter.println("<nc:Person s:id='" + "PersonArrestee${subject.id}_${uuid}" + "'>");
            //<!-- Element 26, Age of Victim (only one would be included per victim)-->
            fileWriter.println("<nc:PersonAgeMeasure>");
            if (getAge(subject) != null) {
                fileWriter.println("<nc:MeasureIntegerValue>${getAge(subject)}</nc:MeasureIntegerValue>");
            } else {
                fileWriter.println("<nc:MeasureIntegerRange>");
                fileWriter.println("<nc:RangeMaximumIntegerValue>${maxAgeRange}</nc:RangeMaximumIntegerValue>");
                fileWriter.println("<nc:RangeMinimumIntegerValue>${minAgeRange}</nc:RangeMinimumIntegerValue>");
                fileWriter.println("</nc:MeasureIntegerRange>");
            }
            fileWriter.println("</nc:PersonAgeMeasure>");
            //<!-- Element 29, Ethnicity of Victim -->
            fileWriter.println("<j:PersonEthnicityCode>${getEthnicity(subject)}</j:PersonEthnicityCode>");
            //<!-- Element 28, Race of Victim -->
            fileWriter.println("<j:PersonRaceNDExCode>${getRace(subject)}</j:PersonRaceNDExCode>");
            //<!-- Element 30, Resident Status -->
            fileWriter.println("<j:PersonResidentCode>${personResidentCode}</j:PersonResidentCode>");
            //<!-- Element 27, Sex of Victim -->
            fileWriter.println("<j:PersonSexCode>${getGenderCode(subject)}</j:PersonSexCode>");
            fileWriter.println("</nc:Person>");

            fileWriter.println("<j:Arrestee s:id='" + "Arrestee1_${uuid}" + "'>");
            fileWriter.println("<nc:RoleOfPerson s:ref='" + "PersonArrestee${subject.id}_${uuid}" + "'/>");
            //<!-- Element 40, Arrestee Sequence Number -->
            fileWriter.println("<j:ArrestSequenceID>${offenses.indexOf(offense) + 1}</j:ArrestSequenceID>");
            //<!-- Element 46, Arrestee Was Armed With -->
            fileWriter.println("<j:ArresteeArmedWithCode>${offense.cf_armedWithCode != null ? offense.cf_armedWithCode : arresteeArmedWithCode[0]}</j:ArresteeArmedWithCode>");
            //<!-- Element 52, Disposition of Arrestee Under 18 -->
            //<!--<j:ArresteeJuvenileDispositionCode>H</j:ArresteeJuvenileDispositionCode>-->
            fileWriter.println("</j:Arrestee>");
            fileWriter.println("<j:Arrest s:id='" + "Arrest1_${uuid}" + "'>");
            //<!-- Element 41, Arrest Transaction Number -->
            fileWriter.println("<nc:ActivityIdentification>");
            fileWriter.println("<nc:IdentificationID>${identificationID}</nc:IdentificationID>");
            fileWriter.println("</nc:ActivityIdentification>");
            //<!-- Element 42, Arrest Date -->
            fileWriter.println("<nc:ActivityDate>");
            fileWriter.println("<nc:Date>${localDate.format(yearMonthDayFomatter)}</nc:Date>");
            fileWriter.println("</nc:ActivityDate>");
            //<!-- Element 45, UCR Arrest Offense Code -->
            fileWriter.println("<j:ArrestCharge>");
            fileWriter.println("<nibrs:ChargeUCRCode>${offense.statute.sectionCode}</nibrs:ChargeUCRCode>");
            fileWriter.println("</j:ArrestCharge>");
            //<!-- Element 43, Type Of Arrest -->
            fileWriter.println("<j:ArrestCategoryCode>${offense.cf_arrestCategoryCode != null ? offense.cf_arrestCategoryCode : arrestCategoryCode[0]}</j:ArrestCategoryCode>");
            fileWriter.println("</j:Arrest>");
            //<!-- Associations ==================================== -->
            fileWriter.println("<j:ArrestSubjectAssociation>");
            fileWriter.println("<nc:Activity s:ref='" + "Arrest1_${uuid}" + "'/>");
            fileWriter.println("<j:Subject s:ref='" + "Arrestee1_${uuid}" + "'/>");
            fileWriter.println("</j:ArrestSubjectAssociation>");

            fileWriter.println("</nibrs:Report>");
            fileWriter.println("</nibrs:Submission>");

            fileWriter.flush();
            fileWriter.close();

            reportDoc = createDocument(reportFile, cse, offenses, batch, caseJudicialDistrictCode);
            addDocumentToDocuments(cse, reportDoc);
            offense.setUpdateReason("NIBRS");
            charesToUpdate.add(offense);
            _fileOut = reportFile;
            Files.deleteIfExists(reportPath);
        } catch (Exception ex) {
            logger.debug("ex: ${ex.getMessage()}");
        } finally {
            logger.debug("finally")

        }
    }
    logger.debug("saving charges ${charesToUpdate.size()}")
    DomainObject.saveOrUpdateAll(charesToUpdate);
}

protected Document createDocument(File fileAttachment, Case cse, List<Charge> charges, String batch, String caseJudicialDistrictCode) {
    Document reportDocument = new Document();
    reportDocument.case = cse;
    reportDocument.docDef = DomainObject.find(DocDef.class, "shortName", "NIBRSA").find({ it -> it != null });
    reportDocument.memo = charges.id.join("_");
    reportDocument.reviewStatus = "PRIVILEGED";
    reportDocument.batchSource = "NIBRSB";
    reportDocument.batch = batch;
    reportDocument.filedByText = caseJudicialDistrictCode;
    reportDocument.saveOrUpdate();
    reportDocument.store(fileAttachment);
    return reportDocument;
}

protected void addDocumentToDocuments(Case cse, Document document) {
    cse.add(document, "documents");
    cse.saveOrUpdate();
}

protected String getOffenseUCRCode(Charge offense) {
    String code = offense.collect("chargeAttributes").find({ it -> it != null });
    return code != null ? code : "";
}

protected Integer getAge(Party party) {
    def age = party.person.collect("profiles[dateOfBirth != null].age").find({ it -> it != null });
    return age;
}

protected String getGenderCode(Party party) {
    def gender = party.person.collect("profiles[gender != null].gender").find({ it -> it != null });
    if (gender == null || !["MALE", "FEMALE"].contains(gender)) {
        gender = "M";
    } else if (gender == "MALE") {
        gender = "M";
    } else if (gender == "FEMALE") {
        gender = "F";
    }
    return gender;
}

protected String getEthnicity(Party party) {
    def ethnicity = party.person.collect("profiles[ethnicity != null].ethnicity").find({ it -> it != null });
    if (ethnicity == null) {
        ethnicity = "N";
    } else if (ethnicity == "HISPANIC") {
        ethnicity = "H";
    } else {
        ethnicity = "N";
    }
    return ethnicity;
}

protected String getRace(Party party) {
    def race = party.person.collect("profiles[ethnicity != null].ethnicity").find({ it -> it != null });
    if (race == null || !["WHITE", "BLACK", "AMERICANINDIAN", "ASIAN", "NATIVEHAWAIIAN"].contains(race)) {
        race = "W";
    } else if (race == "WHITE") {
        race = "W";
    } else if (race == "BLACK") {
        race = "B";
    } else if (race == "AMERICANINDIAN") {
        race = "I";
    } else if (race == "ASIAN") {
        race = "A";
    } else if (race == "NATIVEHAWAIIAN") {
        race = "P";
    }
    return race;
}




