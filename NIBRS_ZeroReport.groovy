import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.temporal.TemporalAdjusters.*;
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

/**
 */


// ZoneId is set to local value, America/Los_Angeles, for testing; the validation applicaiton xcota will fail a filing if the datatime is ahead of the local time

String internalTesting = SystemProperty.getValue("nibrs.email.testing");
internalTesting = internalTesting == null || internalTesting.isEmpty() ? "true" : internalTesting;
String ucrstatEmailAddress = internalTesting == "true" ? SystemProperty.getValue("nibrs.email.inbox.test") : SystemProperty.getValue("nibrs.email.inbox");
logger.debug("internalTesting:${internalTesting}; ucrstatEmailAddress:${ucrstatEmailAddress}");
String ucrstatEmailAddressCC = SystemProperty.getValue("nibrs.email.inbox.cc");

LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Los_Angeles")).minusDays(1L);
LocalDate localDate = localDateTime.toLocalDate();
LocalDateTime localDateTimeStart = localDateTime.with(firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0).withNano(0);
LocalDateTime localDateTimeEnd = localDateTime.with(lastDayOfMonth()).withHour(23).withMinute(59).withSecond(58).withNano(999999999);
logger.debug("report date range: localDateTimeStart:${localDateTimeStart}; localDateTimeEnd:${localDateTimeEnd}");

DateTimeFormatter yearMonthFomatter = DateTimeFormatter.ofPattern("yyyy-MM");
String reportType = "ZeroReport";
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
String reportActionCategoryCode = "A";
String incidentNumber = "TEST";
LocalDateTime incidentDateTime = localDateTime;
boolean incidentReportDateIndicator = false;
LocalDate incidentExceptionalClearanceDate = LocalDate.now();

ArrayList<String> offenseUCRCodeGroupAB = new ArrayList<>(Arrays.asList("ALL_OTHER_OFFENSES,AGGRAVATED_ASSAULT,ARSON,ASSAULT-SIMPLE,BETTING-WAGERING,BRIBERY,BURGLARY-BREAKING_ENTERING,COUNTERFEIT-FORGERY,CRUELTY_TO_ANIMALS,DAMAGE-DESTRUCTION-VANDALISM_OF_PROPERTY,DRUG-EQUIPMENT_VIOLATIONS,DRUG-NARCOTIC_VIOLATIONS,EMBEZZLEMENT,ESPIONAGE,EXPLOSIVES,EXPORT_VIOLATIONS,EXTORTION-BLACKMAIL,FEDERAL_LIQUOR_OFFENSES,FEDERAL_TOBACCO_OFFENSES,FIREARM_ACT_VIOLATION,FONDLING,FRAUD-BY_WIRE,FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE,FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME,FRAUD-IMPERSONATION,FRAUD-WELFARE_FRAUD,FUGITIVE-FLIGHT_TO_AVOID_DEPORTATION,FUGITIVE-FLIGHT_TO_AVOID_PROSECUTION,FUGITIVE-HARBORING_ESCAPEE-CONCEALING_FROM_ARREST,GAMBLING-EQUIPMENT_VIOLATION,GAMBLING-OPERATING_PROMOTING_ASSISTING,HACKING-COMPUTER_INVASION,HUMAN_TRAFFICKING-COMMERCIAL_SEX_ACTS,HUMAN_TRAFFICKING-INVOLUNTARY_SERVITUDE,IDENTITY_THEFT,IMMIGRATION-FALSE_CITIZENSHIP,IMMIGRATION-ILLEGAL_ENTRY_INTO_US,IMMIGRATION-OTHER_IMMIGRATION_VIOLATIONS,IMMIGRATION-RE_ENTRY_AFTER_DEPORTATION,IMMIGRATION-SMUGGLING_ALIENS,IMPORT_VIOLATIONS,INCEST,INTIMIDATION,JUSTIFIABLE_HOMICIDE,KIDNAPPING-ABDUCTION,LARCENY,LARCENY-FROM_AUTO,LARCENY-FROM_BUILDING,LARCENY-FROM_COIN_OPERATED_MACHINE,LARCENY-PARTS_FROM_VEHICLE,MANSLAUGHTER_NEGLIGENT,MANSLAUGHTER_NONNEGLIGENT-MURDER,MONEY_LAUNDERING,MOTOR_VEHICLE_THEFT,OBSCENE_MATERIAL-PORNOGRAPHY,POCKET_PICKING,PROSTITUTION,PROSTITUTION-ASSISTING_OR_PROMOTING,PROSTITUTION-PURCHASING,PURSE_SNATCHING,RAPE,RAPE-STATUTORY,ROBBERY,SEX_ASSAULT-OBJECT,SEX_OFFENDER_REGISTRATION_VIOLATION,SHOPLIFTING,SODOMY,SPORTS_TAMPERING,STOLEN_PROPERTY_OFFENSES,TREASON,WEAPON_LAW_VIOLATIONS,WEAPONS_OF_MASS_DESTRUCTION,WILDLIFE_TRAFFICKING,FAILURE_TO_APPEAR,CURFEW-LOITERING-VAGRANCY_VIOLATIONS,DISORDERLY_CONDUCT,DRIVING_UNDER_INFLUENCE,FAMILY_OFFENSES-NONVIOLENT,FEDERAL_RESOURCE_VIOLATIONS,LIQUOR_LAW_VIOLATIONS,PERJURY,TRESPASSING,ALL_OTHER_OFFENSES".split(",")));

String nIBRSReportCategoryCode = "ZERO REPORT";

// Charges to submit
Where whereCharge = new Where();
whereCharge.addGreaterThanOrEquals("chargeDate", Timestamp.valueOf(localDateTimeStart));
whereCharge.addLessThanOrEquals("chargeDate", Timestamp.valueOf(localDateTimeEnd));
whereCharge.addIsNotNull("chargeAttributes");
whereCharge.addContainsAny("chargeAttributes", offenseUCRCodeGroupAB);
ArrayList<Charge> offenses = DomainObject.find(Charge.class, whereCharge);
ArrayList<Charge> offensesAll = DomainObject.find(Charge.class, whereCharge);
logger.debug("offenses to process: ${offenses.size()}");

ArrayList<String> toEmails = new ArrayList<>(Arrays.asList(ucrstatEmailAddress?.split(",")));
ArrayList<String> ccEmails = new ArrayList<>(Arrays.asList(ucrstatEmailAddressCC?.split(",")));
ArrayList<String> bccEmails = new ArrayList<>();

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


CtInterfaceTrackingDetail interfaceTrackingDetail = new CtInterfaceTrackingDetail();
interfaceTrackingDetail.ctInterfaceTracking = interfaceTracking;
interfaceTrackingDetail.recordId = "";
interfaceTrackingDetail.status = "";
interfaceTrackingDetail.statusDate = Timestamp.valueOf(localDateTime);
interfaceTrackingDetail.saveOrUpdate();
interfaceTracking.add(interfaceTrackingDetail);
interfaceTracking.saveOrUpdate();

Path reportPath = Files.createTempFile(rootDir.toPath(), "${reportFileNamePrefix}".toString(), reportFileNameSuffix);
File reportFile = reportPath.toFile();
PrintWriter fileWriter = new PrintWriter(reportFile);

if (offenses.isEmpty()){
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
} else {
    _outputMessage = "Zero Report not generated";
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

protected String getVictimCategoryCode(ArrayList ucrOffensesAgainsSocietyRequireVictimTypeS, Party victim, Charge offense, ArrayList ucrOffenseUCRCodeRequiredWhenVictimTypeIsG){
    String victimCategoryCode = victim.person.personType == "PERSON" ? "I" : "";
    victimCategoryCode = victim.person.personType == "BUSINESS" ? "B" : victimCategoryCode;
    victimCategoryCode = ucrOffensesAgainsSocietyRequireVictimTypeS.contains(getOffenseUCRCode(offense)) ? "S" : victimCategoryCode;
    victimCategoryCode = ucrOffenseUCRCodeRequiredWhenVictimTypeIsG.contains(getOffenseUCRCode(offense)) ? "G" : victimCategoryCode;
    return victimCategoryCode;
}

protected ArrayList<Charge> getVictimsXrefOffenses(Party victim, String chargeFilterXrefVictimCharge){
    return victim.collect(chargeFilterXrefVictimCharge)?.orderBy("id");
}

protected ArrayList<Party> getOffenseSubjects(ArrayList<Charge> offensesAll, String ucrOffense, String victimFilterXrefChargeVictim, Party ucrVictim){
    ArrayList<Party> ucrOffenseSubjects = new ArrayList();
    offensesAll.findAll({offense -> getOffenseUCRCode(offense) == ucrOffense && offense.collect(victimFilterXrefChargeVictim).findAll({thisVictim -> thisVictim == ucrVictim})})?.each({offense -> ucrOffenseSubjects.add(offense.associatedParty)});
    return ucrOffenseSubjects?.unique({party -> party});
}

protected ArrayList<Party> getOffenseSubjectVictims(ArrayList<Charge> offensesAll, String ucrOffense, String victimFilterXrefChargeVictim){
    ArrayList<Party> ucrOffenseVictims = new ArrayList();
    offensesAll.findAll({offense -> getOffenseUCRCode(offense) == ucrOffense})?.each({offense -> ucrOffenseVictims.addAll(offense.collect(victimFilterXrefChargeVictim))});
    return ucrOffenseVictims;
}








