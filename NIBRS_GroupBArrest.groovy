import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
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


/*
*https://journaltech.sharepoint.com/:x:/s/MississippiAG/EegY8NK6owBEmQV-Z29xNh4BvLjC4KmD0-CsZNgnbsQu1w?e=grZ56N
*
*ZoneId is set to local value, America/Los_Angeles, for testing; the validation applicaiton xcota will fail a filing if the datatime is ahead of the local *time
*/

String internalTesting = SystemProperty.getValue("nibrs.email.testing");
internalTesting = internalTesting == null || internalTesting.isEmpty() ? "true" : internalTesting;
String ucrstatEmailAddress = internalTesting == "true" ? SystemProperty.getValue("nibrs.email.inbox.test") : SystemProperty.getValue("nibrs.email.inbox");
logger.debug("internalTesting:${internalTesting}; ucrstatEmailAddress:${ucrstatEmailAddress}");
String ucrstatEmailAddressCC = SystemProperty.getValue("nibrs.email.inbox.cc");



LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
LocalDate localDate = LocalDate.now();
LocalDate localDateLastDayOfMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());


LocalDateTime localDateTimeStart = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0).withNano(0);
LocalDateTime localDateTimeEnd = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(58).withNano(999999999);
DateTimeFormatter yearMonthFomatter = DateTimeFormatter.ofPattern("yyyy-MM");
DateTimeFormatter yearMonthDayFomatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

if (localDate == localDateLastDayOfMonth || _testing == true){

    String reportType = "GroupBArrestReport";
    String rootPath = "\\\\edc-isilon-smb\\ags2docsuat\\NIBRS";
    LocalDate reportDate = LocalDate.now();
    String reportFileNamePrefix = "EAttorney_${reportType}_${reportDate.getMonth()}_${reportDate.getDayOfMonth()}_${reportDate.getYear()}_".toString();
    String reportFileNameSuffix;
// when testing, set extensionto txt, outlook may prevent opening xml file
    if (internalTesting == "true") {
        reportFileNameSuffix = ".xml.txt";
    } else {
        reportFileNameSuffix = ".xml";
    }
    File rootDir = new File(rootPath);

// Interface tracking
    CtInterfaceTracking interfaceTracking = new CtInterfaceTracking();
    interfaceTracking.executionDate = Timestamp.valueOf(localDateTime);
    interfaceTracking.interfaceName = "NIBRSGAIR";
    interfaceTracking.result = "";
    interfaceTracking.saveOrUpdate();
    logger.debug("interfaceTracking: ${interfaceTracking.interfaceName }; ${interfaceTracking.executionDate}");

/*
Path reportPath = Files.createTempFile(rootDir.toPath(), reportFileNamePrefix, reportFileNameSuffix);
File reportFile = reportPath.toFile();
PrintWriter fileWriter = new PrintWriter(reportFile);
*/
    String messageIdentifier = "TEST";

//ORI number must match this pattern [A-Z]{2}+[0-9]{7}+
    String oriPattern = "[A-Z]{2}+[0-9]{7}+";
    String submittingAgencyORINumber = "AB1234567";
    String owningAgencyORINumber = "AC1234567";
    logger.debug("submittingAgencyORINumber:${submittingAgencyORINumber}, owningAgencyORINumber:${owningAgencyORINumber}");
    String reportActionCategoryCode = "A";
    String incidentNumber = "TEST";
    LocalDateTime incidentDateTime = localDateTime;
    boolean incidentReportDateIndicator = false;
    ArrayList<String> incidentExceptionalClearanceCode = Arrays.asList("A","B","C","D","E","N");
//TEST required when incidentExceptionalClearanceCode == A - E
    LocalDate incidentExceptionalClearanceDate = LocalDate.now();

    ArrayList<String> offenseUCRCodeGroupB = Arrays.asList("FAILURE_TO_APPEAR,CURFEW-LOITERING-VAGRANCY_VIOLATIONS,DISORDERLY_CONDUCT,DRIVING_UNDER_INFLUENCE,FAMILY_OFFENSES-NONVIOLENT,FEDERAL_RESOURCE_VIOLATIONS,LIQUOR_LAW_VIOLATIONS,PERJURY,TRESPASSING,ALL_OTHER_OFFENSES".split(","));

// Option selectec by user
    ArrayList<String> judicialDistrictCode = DomainObject.find(LookupItem.class, "lookupList.name", "JUDICIAL_DISTRICT_CODE").code;
// Option selectec by user
    ArrayList<String> arresteeArmedWithCode = DomainObject.find(LookupItem.class, "lookupList.name", "ARRESTEE_ARMED_WITH_CODE").code;
// Option selectec by user
    ArrayList<String> arrestCategoryCode = DomainObject.find(LookupItem.class, "lookupList.name", "ARREST_CATEGORY_CODE").code;

    String nIBRSReportCategoryCode = "GROUP B ARREST REPORT";
    String personResidentCode = "R";

    int maxAgeRange = 50; //default value
    int minAgeRange = 20; //default value


// Charges to submit
    Where whereCharge = new Where();
    whereCharge.addGreaterThanOrEquals("chargeDate", Timestamp.valueOf(localDateTimeStart));
    whereCharge.addLessThanOrEquals("chargeDate", Timestamp.valueOf(localDateTimeEnd));
    whereCharge.addIsNotNull("chargeAttributes");
    whereCharge.addContainsAny("chargeAttributes", offenseUCRCodeGroupB);
// arrest report requires known sex code, M or F
    whereCharge.addContainsAny("associatedParty.person.profiles.gender", ["M","F"]);
    if (_cse != null){
        whereCharge.addEquals("associatedParty.case", _cse);
    }
    ArrayList<Charge> offenses = DomainObject.find(Charge.class, whereCharge);
    ArrayList<Charge> offensesAll = DomainObject.find(Charge.class, whereCharge);
//logger.debug("offenses:${offenses.size()}");

    offenses = offenses.unique({it -> getOffenseUCRCode(it)});

    ArrayList<String> toEmails = new ArrayList<>(Arrays.asList(ucrstatEmailAddress?.split(",")));
    ArrayList<String> ccEmails = new ArrayList<>(Arrays.asList(ucrstatEmailAddressCC?.split(",")));
    ArrayList<String> bccEmails = Arrays.asList("");

// For test submissions, e-mail subject must say Test Data
    String emailSubject = "Test Data : ${reportType}";
    String emailBody = "${reportType} generated on: ${localDate}";
    Attachments attachments;
    File[] attachmentFiles;


    if (submittingAgencyORINumber.matches(oriPattern) == false){
        throw new Exception("SubmittingAgencyORINumber failed validation");
    }
    if (owningAgencyORINumber.matches(oriPattern) == false){
        throw new Exception("OwningAgencyORINumber failed validation");
    }
    if (offenses.isEmpty()){
        throw new Exception("Offenses failed validation; empty");
    }

    for (offense in offenses){
        Party subject = offense.associatedParty;
        OtherCaseNumber agencyNumber = subject.case.collect("otherCaseNumbers[type == 'AGENCY' && number != null]").find({it -> it != null});
        String identificationID = agencyNumber!= null && agencyNumber.number != null? agencyNumber.number : "1234";
        String offenseUCRCode = getOffenseUCRCode(offense);

        CtInterfaceTrackingDetail interfaceTrackingDetail = new CtInterfaceTrackingDetail();
        interfaceTrackingDetail.ctInterfaceTracking = interfaceTracking;
        interfaceTrackingDetail.recordId = "";
        interfaceTrackingDetail.status = "";
        interfaceTrackingDetail.statusDate = Timestamp.valueOf(localDateTime);
        interfaceTrackingDetail.saveOrUpdate();
        interfaceTracking.add(interfaceTrackingDetail);
        interfaceTracking.saveOrUpdate();

        Path reportPath = Files.createTempFile(rootDir.toPath(), "${reportFileNamePrefix}_${offenseUCRCode}_".toString(), reportFileNameSuffix);
        File reportFile = reportPath.toFile();
        PrintWriter fileWriter = new PrintWriter(reportFile);

        try{
            if (!Files.exists(rootDir?.toPath())){
                rootDir.mkdir();
            }
            fileWriter.println("""<?xml version="1.0" encoding="UTF-8"?>
<nibrs:Submission xmlns:nibrs="http://fbi.gov/cjis/nibrs/2019.2"
	xmlns:cjis="http://fbi.gov/cjis/2.1" 
	xmlns:s="http://release.niem.gov/niem/structures/3.0/"
	xmlns:j="http://release.niem.gov/niem/domains/jxdm/5.2/" 
	xmlns:nc="http://release.niem.gov/niem/niem-core/3.0/">""");
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

            //loop through offenses for offense location
            //for (offense in offenses){
            //<!-- Element 9, Location Type -->
            fileWriter.println("<nc:Location s:id='" + "Location${offense.id}" + "'>");
            fileWriter.println("<nibrs:LocationCategoryCode>50</nibrs:LocationCategoryCode>");
            fileWriter.println("<nc:LocationLocale>");
            fileWriter.println("<cjis:JudicialDistrictCode>${offense.cf_judicialDistrictCode != null ? offense.cf_judicialDistrictCode : judicialDistrictCode[0]}</cjis:JudicialDistrictCode>");
            logger.debug("OPTION:<cjis:JudicialDistrictCode>${offense.cf_judicialDistrictCode != null ? offense.cf_judicialDistrictCode : judicialDistrictCode[0]}");
            fileWriter.println("</nc:LocationLocale>");
            fileWriter.println("</nc:Location>");


            fileWriter.println("<nc:Person s:id='" + "PersonArrestee${subject.id}" + "'>");
            //<!-- Element 26, Age of Victim (only one would be included per victim)-->
            fileWriter.println("<nc:PersonAgeMeasure>");
            if (getAge(subject) != null){
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

            fileWriter.println("<j:Arrestee s:id='" + "Arrestee1" + "'>");
            fileWriter.println("<nc:RoleOfPerson s:ref='" + "PersonArrestee${subject.id}" + "'/>");
            //<!-- Element 40, Arrestee Sequence Number -->
            fileWriter.println("<j:ArrestSequenceID>1</j:ArrestSequenceID>");
            //<!-- Element 46, Arrestee Was Armed With -->
            fileWriter.println("<j:ArresteeArmedWithCode>${offense.cf_armedWithCode != null ? offense.cf_armedWithCode : arresteeArmedWithCode[0]}</j:ArresteeArmedWithCode>");
            logger.debug("OPTION:<j:ArresteeArmedWithCode>${offense.cf_armedWithCode != null ? offense.cf_armedWithCode : arresteeArmedWithCode[0]}");
            //<!-- Element 52, Disposition of Arrestee Under 18 -->
            //<!--<j:ArresteeJuvenileDispositionCode>H</j:ArresteeJuvenileDispositionCode>-->
            fileWriter.println("</j:Arrestee>");
            fileWriter.println("<j:Arrest s:id='" + "Arrest1" + "'>");
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
            fileWriter.println("<nibrs:ChargeUCRCode>${offenseUCRCode}</nibrs:ChargeUCRCode>");
            fileWriter.println("</j:ArrestCharge>");
            //<!-- Element 43, Type Of Arrest -->
            fileWriter.println("<j:ArrestCategoryCode>${offense.cf_arrestCategoryCode != null ? offense.cf_arrestCategoryCode : arrestCategoryCode[0]}</j:ArrestCategoryCode>");
            logger.debug("OPTION:<j:ArrestCategoryCode>${offense.cf_arrestCategoryCode != null ? offense.cf_arrestCategoryCode : arrestCategoryCode[0]}");
            fileWriter.println("</j:Arrest>");
            //<!-- Associations ==================================== -->
            fileWriter.println("<j:ArrestSubjectAssociation>");
            fileWriter.println("<nc:Activity s:ref='" + "Arrest1" + "'/>");
            fileWriter.println("<j:Subject s:ref='" + "Arrestee1" + "'/>");
            fileWriter.println("</j:ArrestSubjectAssociation>");

            fileWriter.println("</nibrs:Report>");
            fileWriter.println("</nibrs:Submission>");

            fileWriter.flush();
            fileWriter.close();
            attachmentFiles = new ArrayList<>(Arrays.asList(reportFile)).toArray(File[]);
            attachments = new Attachments(attachmentFiles);
            mailManager.sendMailToAll(toEmails, ccEmails, bccEmails, emailSubject, emailBody, attachments);
            _fileOut = reportFile;
            Files.deleteIfExists(reportPath);
        } catch (Exception ex){
            logger.debug("ex: ${ex.getMessage()}");
        }
    }

}
/*************************************************************************************************************************/
/*
for (f in new File(rootPath).listFiles()){
  logger.debug(f.toString());
  Files.deleteIfExists(f.toPath());
}
*/


protected String getOffenseUCRCode(Charge offense){
    String code = offense.collect("chargeAttributes").find({it -> it != null});
    return code != null ? code : "";
}

protected Integer getAge(Party party){
    def age = party.person.collect("profiles[dateOfBirth != null].age").find({it -> it != null});
    return age;
}

protected String getGenderCode(Party party){
    def gender = party.person.collect("profiles[gender != null].gender").find({it -> it != null});
    if (gender == null || !["MALE","FEMALE"].contains(gender)){
        gender = "U";
    } else if (gender == "MALE") {
        gender = "M";
    } else if (gender == "FEMALE") {
        gender = "F";
    }
    return gender;
}

protected String getEthnicity(Party party){
    def ethnicity = party.person.collect("profiles[ethnicity != null].ethnicity").find({it -> it != null});
    if (ethnicity == null){
        ethnicity = "U";
    } else if ( ethnicity == "HISPANIC"){
        ethnicity = "H";
    } else {
        ethnicity = "N";
    }
    return ethnicity;
}

protected String getRace(Party party){
    def race = party.person.collect("profiles[ethnicity != null].ethnicity").find({it -> it != null});
    if (race == null || !["WHITE","BLACK","AMERICANINDIAN","ASIAN","NATIVEHAWAIIAN"].contains(race)){
        race = "U";
    } else if ( race == "WHITE"){
        race = "W";
    } else if ( race == "BLACK"){
        race = "B";
    } else if ( race == "AMERICANINDIAN"){
        race = "I";
    } else if ( race == "ASIAN"){
        race = "A";
    } else if ( race == "NATIVEHAWAIIAN"){
        race = "P";
    }
    return race;
}




