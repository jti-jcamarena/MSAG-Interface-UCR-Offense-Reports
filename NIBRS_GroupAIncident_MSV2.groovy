import com.sustain.util.RichList;
import com.sustain.properties.model.SystemProperty;
import com.sustain.cases.model.Case;
import com.sustain.document.model.Document;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.sql.Timestamp;
import java.nio.file.Path;
import com.sustain.cases.model.Charge;
import java.io.FileWriter;
import java.io.PrintWriter;
import com.sustain.mail.Attachments;
import org.json.JSONArray;
import org.json.JSONObject;
import com.sustain.entities.custom.CtInterfaceTracking;
import com.sustain.entities.custom.CtInterfaceTrackingDetail;
import java.time.temporal.TemporalAdjusters;
import java.util.Collections;
import com.sustain.expression.Where;
import com.sustain.DomainObject;
import com.sustain.cases.model.Party;
import com.sustain.person.model.Person;

// *lastUpdated:02/20/2024

def Long defaultPersonId = 35291L;

//Person offenses:
def ArrayList<String> personUCROffenses =
        Arrays.asList("RAPE,JUSTIFIABLE_HOMICIDE,HUMAN_TRAFFICKING-INVOLUNTARY_SERVITUDE,HUMAN_TRAFFICKING-COMMERCIAL_SEX_ACTS,SODOMY,RAPE-STATUTORY,ASSAULT-SIMPLE,FONDLING,INCEST,MANSLAUGHTER_NONNEGLIGENT-MURDER,SEX_ASSAULT-OBJECT,KIDNAPPING-ABDUCTION,AGGRAVATED_ASSAULT,INTIMIDATION,MANSLAUGHTER_NEGLIGENT".split(","));

//Property offenses:
def ArrayList<String> propertyUCROffenses =
        Arrays.asList("EMBEZZLEMENT,LARCENY-FROM_AUTO,COUNTERFEIT-FORGERY,LARCENY,BURGLARY-BREAKING_ENTERING,DAMAGE-DESTRUCTION-VANDALISM_OF_PROPERTY,FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME,SHOPLIFTING,IDENTITY_THEFT,ARSON,FRAUD-WELFARE_FRAUD,ROBBERY,FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE,STOLEN_PROPERTY_OFFENSES,FRAUD-BY_WIRE,LARCENY-FROM_BUILDING,BRIBERY,FRAUD-IMPERSONATION,EXTORTION-BLACKMAIL,HACKING-COMPUTER_INVASION,LARCENY-PARTS_FROM_VEHICLE,MOTOR_VEHICLE_THEFT,POCKET_PICKING,PURSE_SNATCHING,LARCENY-FROM_COIN_OPERATED_MACHINE".split(","));

def ArrayList<String> personAndPropertyUCROffenses = new ArrayList();
personAndPropertyUCROffenses.addAll(personUCROffenses);
personAndPropertyUCROffenses.addAll(propertyUCROffenses);

//Society offenses:
def ArrayList<String> societyUCROffenses =
        Arrays.asList("BETTING-WAGERING,PROSTITUTION,WEAPON_LAW_VIOLATIONS,OBSCENE_MATERIAL-PORNOGRAPHY,GAMBLING-EQUIPMENT_VIOLATION,DRUG-NARCOTIC_VIOLATIONS,SPORTS_TAMPERING,GAMBLING-OPERATING_PROMOTING_ASSISTING,DRUG-EQUIPMENT_VIOLATIONS,PROSTITUTION-ASSISTING_OR_PROMOTING,CRUELTY_TO_ANIMALS,PROSTITUTION-PURCHASING".split(","));

ArrayList<String> offenseUCRCodeGroupA = new ArrayList();
offenseUCRCodeGroupA.addAll(personUCROffenses);
offenseUCRCodeGroupA.addAll(propertyUCROffenses);
offenseUCRCodeGroupA.addAll(societyUCROffenses);

//ArrayList<String> offenseUCRCodeGroupA = new ArrayList<>(Arrays.asList("AGGRAVATED_ASSAULT,ARSON,ASSAULT-SIMPLE,BETTING-WAGERING,BRIBERY,BURGLARY-BREAKING_ENTERING,COUNTERFEIT-FORGERY,CRUELTY_TO_ANIMALS,DAMAGE-DESTRUCTION-VANDALISM_OF_PROPERTY,DRUG-EQUIPMENT_VIOLATIONS,DRUG-NARCOTIC_VIOLATIONS,EMBEZZLEMENT,ESPIONAGE,EXPLOSIVES,EXPORT_VIOLATIONS,EXTORTION-BLACKMAIL,FEDERAL_LIQUOR_OFFENSES,FEDERAL_TOBACCO_OFFENSES,FIREARM_ACT_VIOLATION,FONDLING,FRAUD-BY_WIRE,FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE,FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME,FRAUD-IMPERSONATION,FRAUD-WELFARE_FRAUD,FUGITIVE-FLIGHT_TO_AVOID_DEPORTATION,FUGITIVE-FLIGHT_TO_AVOID_PROSECUTION,FUGITIVE-HARBORING_ESCAPEE-CONCEALING_FROM_ARREST,GAMBLING-EQUIPMENT_VIOLATION,GAMBLING-OPERATING_PROMOTING_ASSISTING,HACKING-COMPUTER_INVASION,HUMAN_TRAFFICKING-COMMERCIAL_SEX_ACTS,HUMAN_TRAFFICKING-INVOLUNTARY_SERVITUDE,IDENTITY_THEFT,IMMIGRATION-FALSE_CITIZENSHIP,IMMIGRATION-ILLEGAL_ENTRY_INTO_US,IMMIGRATION-OTHER_IMMIGRATION_VIOLATIONS,IMMIGRATION-RE_ENTRY_AFTER_DEPORTATION,IMMIGRATION-SMUGGLING_ALIENS,IMPORT_VIOLATIONS,INCEST,INTIMIDATION,JUSTIFIABLE_HOMICIDE,KIDNAPPING-ABDUCTION,LARCENY,LARCENY-FROM_AUTO,LARCENY-FROM_BUILDING,LARCENY-FROM_COIN_OPERATED_MACHINE,LARCENY-PARTS_FROM_VEHICLE,MANSLAUGHTER_NEGLIGENT,MANSLAUGHTER_NONNEGLIGENT-MURDER,MONEY_LAUNDERING,MOTOR_VEHICLE_THEFT,OBSCENE_MATERIAL-PORNOGRAPHY,POCKET_PICKING,PROSTITUTION,PROSTITUTION-ASSISTING_OR_PROMOTING,PROSTITUTION-PURCHASING,PURSE_SNATCHING,RAPE,RAPE-STATUTORY,ROBBERY,SEX_ASSAULT-OBJECT,SEX_OFFENDER_REGISTRATION_VIOLATION,SHOPLIFTING,SODOMY,SPORTS_TAMPERING,STOLEN_PROPERTY_OFFENSES,TREASON,WEAPON_LAW_VIOLATIONS,WEAPONS_OF_MASS_DESTRUCTION,WILDLIFE_TRAFFICKING".split(",")));

//Victim Injury Type must be specified when Victim Connected to UCR Offense Code is one of: 100, 11A, 11B, 11C, 11D, 120, 13A, 13B, 210, 64A, 64B
def ArrayList<String> victimInjuryTypeRequiredUCR =
        Arrays.asList("KIDNAPPING-ABDUCTION,RAPE,SODOMY,SEX_ASSAULT-OBJECT,FONDLING,ROBBERY,AGGRAVATED_ASSAULT,ASSAULT-SIMPLE,EXTORTION-BLACKMAIL,HUMAN_TRAFFICKING-COMMERCIAL_SEX_ACTS,HUMAN_TRAFFICKING-INVOLUNTARY_SERVITUDE".split(","));

//UCR Offenses which are grouped as crimes against society, required S - Society for victimCategory
def ArrayList<String> victimCategoryCodeSocietyRequiredUCR =
        Arrays.asList("CRUELTY_TO_ANIMALS,DRUG-NARCOTIC_VIOLATIONS,DRUG-EQUIPMENT_VIOLATIONS,ESPIONAGE,FUGITIVE-HARBORING_ESCAPEE-CONCEALING_FROM_ARREST,FUGITIVE-FLIGHT_TO_AVOID_PROSECUTION,FUGITIVE-FLIGHT_TO_AVOID_DEPORTATION,BETTING-WAGERING,GAMBLING-OPERATING_PROMOTING_ASSISTING,GAMBLING-EQUIPMENT_VIOLATION,IMMIGRATION-ILLEGAL_ENTRY_INTO_US,IMMIGRATION-FALSE_CITIZENSHIP,IMMIGRATION,SMUGGLING_ALIENS,IMMIGRATION-RE_ENTRY_AFTER_DEPORTATION,OBSCENE_MATERIAL-PORNOGRAPHY,PROSTITUTION,PROSTITUTION-ASSISTING_OR_PROMOTING,PROSTITUTION-PURCHASING,SEX_OFFENDER_REGISTRATION_VIOLATION,TREASON,WEAPON_LAW_VIOLATIONS".split(","));


//UCR Offenses which are grouped as crimes against society, but required G - Government for victimCategory
def ArrayList<String> victimCategoryCodeGovernmentRequiredUCR =
        Arrays.asList("MONEY_LAUNDERING,FIREARM_ACT_VIOLATION,WEAPONS_OF_MASS_DESTRUCTION,EXPLOSIVES,IMPORT_VIOLATIONS,EXPORT_VIOLATIONS,FEDERAL_LIQUOR_OFFENSES,FEDERAL_TOBACCO_OFFENSES,WILDLIFE_TRAFFICKING".split(","));

//"DRUG-NARCOTIC_VIOLATIONS,DRUG-EQUIPMENT_VIOLATIONS"
def ArrayList<String> substanceRelatedUCR = Arrays.asList("DRUG-NARCOTIC_VIOLATIONS".split(","));

//offensesMap stores UCR offense label and code
def Map offensesMap = new HashMap();

//GROUP A OFFENSES
//crimes against person
offensesMap.put("AGGRAVATED_ASSAULT", "13A");//tested grouped
offensesMap.put("ASSAULT-SIMPLE", "13B");//tested grouped
offensesMap.put("JUSTIFIABLE_HOMICIDE", "09C");//tested grouped
offensesMap.put("MANSLAUGHTER_NONNEGLIGENT-MURDER", "09A");//tested grouped
offensesMap.put("INTIMIDATION", "13C");//tested grouped
//5
offensesMap.put("MANSLAUGHTER_NEGLIGENT", "09B");//tested grouped
offensesMap.put("HUMAN_TRAFFICKING-COMMERCIAL_SEX_ACTS", "64A");//tested grouped
offensesMap.put("HUMAN_TRAFFICKING-INVOLUNTARY_SERVITUDE", "64B");//tested grouped
offensesMap.put("KIDNAPPING-ABDUCTION", "100");//tested grouped
offensesMap.put("RAPE", "11A");//tested grouped
//10
offensesMap.put("SODOMY", "11B");//tested grouped
offensesMap.put("SEX_ASSAULT-OBJECT", "11C");//tested grouped
offensesMap.put("FONDLING", "11D");//tested grouped
offensesMap.put("INCEST", "36A");//tested grouped
offensesMap.put("RAPE-STATUTORY", "36B");//tested grouped
//15
//crimes against property
offensesMap.put("ARSON", "200");//tested grouped
offensesMap.put("BRIBERY", "510");//tested grouped
offensesMap.put("BURGLARY-BREAKING_ENTERING", "220");//tested grouped
offensesMap.put("COUNTERFEIT-FORGERY", "250");//tested grouped
offensesMap.put("DAMAGE-DESTRUCTION-VANDALISM_OF_PROPERTY", "290");//tested grouped
//20
offensesMap.put("EMBEZZLEMENT", "270");//tested grouped
offensesMap.put("EXTORTION-BLACKMAIL", "210");//tested grouped
offensesMap.put("FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME", "26A");//tested grouped
offensesMap.put("FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE", "26B");//tested grouped
offensesMap.put("FRAUD-IMPERSONATION", "26C");//tested grouped
//25
offensesMap.put("FRAUD-WELFARE_FRAUD", "26D");//tested grouped
offensesMap.put("FRAUD-BY_WIRE", "26E");//tested grouped
offensesMap.put("IDENTITY_THEFT", "26F");//tested grouped
offensesMap.put("HACKING-COMPUTER_INVASION", "26G");//tested grouped
offensesMap.put("POCKET_PICKING", "23A");//tested grouped
//30
offensesMap.put("PURSE_SNATCHING", "23B");//tested grouped
offensesMap.put("SHOPLIFTING", "23C");//tested grouped
offensesMap.put("LARCENY-FROM_BUILDING", "23D");//tested grouped
offensesMap.put("LARCENY-FROM_COIN_OPERATED_MACHINE", "23E");//tested grouped
offensesMap.put("LARCENY-FROM_AUTO", "23F");//tested grouped
//35
offensesMap.put("LARCENY-PARTS_FROM_VEHICLE", "23G");//tested grouped
offensesMap.put("LARCENY", "23H");//tested grouped
offensesMap.put("MOTOR_VEHICLE_THEFT", "240");//tested grouped
offensesMap.put("ROBBERY", "120");//tested grouped
offensesMap.put("STOLEN_PROPERTY_OFFENSES", "280");//tested grouped
//40
//crimes against society
offensesMap.put("CRUELTY_TO_ANIMALS", "720");//tested grouped
offensesMap.put("OBSCENE_MATERIAL-PORNOGRAPHY", "370");//tested grouped
offensesMap.put("PROSTITUTION", "40A");//tested grouped
offensesMap.put("PROSTITUTION-ASSISTING_OR_PROMOTING", "40B");//tested grouped
offensesMap.put("PROSTITUTION-PURCHASING", "40C");//tested grouped
//45
offensesMap.put("DRUG-NARCOTIC_VIOLATIONS", "35A");//tested grouped
offensesMap.put("DRUG-EQUIPMENT_VIOLATIONS", "35B");//tested grouped
offensesMap.put("BETTING-WAGERING", "39A");//tested grouped
offensesMap.put("GAMBLING-OPERATING_PROMOTING_ASSISTING", "39B");//tested grouped
offensesMap.put("GAMBLING-EQUIPMENT_VIOLATION", "39C");//tested grouped
//50
offensesMap.put("SPORTS_TAMPERING", "39D");//tested grouped
offensesMap.put("WEAPON_LAW_VIOLATIONS", "520");//tested grouped

def String internalTesting = SystemProperty.getValue("nibrs.email.testing") ?: "true";
def String ucrstatEmailAddress = SystemProperty.getValue("nibrs.email.inbox") ?: "";
def String ucrstatEmailAddressCC = SystemProperty.getValue("nibrs.email.inbox.cc") ?: "";

def int report_year = _report_year == null ? 0 : Integer.parseInt(_report_year);
def int report_month = _report_month == null ? 0 : Month.valueOf(_report_month).getValue();
logger.debug("report year: ${report_year} report month: ${report_month}");


//pst:America/Los_Angeles, cst:America/Chicago
def LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Chicago")).withNano(0);
String incidentDateTimeFormatted = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
if (report_month != 0) {
    localDateTime = localDateTime.withMonth(report_month);
}
if (report_year != 0) {
    localDateTime = localDateTime.withYear(report_year);
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
def String interfaceName = "NIBRS_GroupAIncident";

if (localDate == localDateLastDayOfMonth || internalTesting == "true") {

    def DateTimeFormatter yearMonthFomatter = DateTimeFormatter.ofPattern("yyyy-MM");
    def String reportType = "GroupAIncidentReport";
    def String rootPath = "\\\\edc-isilon-smb\\ags2docsuat\\NIBRS";
    def LocalDate reportDate = LocalDate.now();
    def String reportFileNamePrefix = "EAttorney_${reportType}_${reportDate.getMonth()}_${reportDate.getDayOfMonth()}_${reportDate.getYear()}_".toString();
    def String reportFileNameSuffix = ".xml";

    def File rootDir = new File(rootPath);

    //TODO Interface Tracking with detail
    def CtInterfaceTracking interfaceTracking = new CtInterfaceTracking();
    interfaceTracking.setExecutionDate(nowTimestamp);
    interfaceTracking.setInterfaceName(interfaceName);
    interfaceTracking.setResult("");
    def ArrayList<CtInterfaceTrackingDetail> interfaceTrackingDetails = new ArrayList<>();

    String messageIdentifier = "EATTORNEY";

//ORI number must match this pattern [A-Z]{2}+[0-9]{7}+
    String oriPattern = "[A-Z]{2}+[0-9]{7}+";
    String submittingAgencyORINumber = SystemProperty.getValue("nibrs.ori.agency.submitting")?.matches(oriPattern) ? SystemProperty.getValue("nibrs.ori.agency.submitting") : "MS090017V";
    //default test value
    String owningAgencyORINumber = SystemProperty.getValue("nibrs.ori.agency.owning")?.matches(oriPattern) ? SystemProperty.getValue("nibrs.ori.agency.owning") : "MS090017V";
    //default test value
    String reportActionCategoryCode = "I";


    boolean incidentReportDateIndicator = false;
    ArrayList<String> incidentExceptionalClearanceCode = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "N"));

    LocalDate incidentExceptionalClearanceDate = LocalDate.now();
    String locationCategoryCode = "25"; //default value
    String offenseFactorCode = "N"; //default value
    String offenseFactorBiasMotivationCode = "NONE"; //default value
    String itemCategoryNIBRSPropertyCategoryCode = "08"; //default value
    String itemValueAmount = "1"; //default value
    String itemQuantityLoss = "00"; //default value

    String statutoryRapeUCR = "RAPE-STATUTORY";
    String weaponsOfMassDestruction = "WEAPONS_OF_MASS_DESTRUCTION";

    int maxAgeRange = 25; //default value
    int minAgeRange = 20; //default value

    boolean offenseAttemptedIndicator = false;

// When Criminal Activity/Gang Information in gangInfomation: J,G,N, one of the following URC codes is required
    ArrayList<String> offenseUCRCodeRequiredWhenGangInformationCode = new ArrayList<>(Arrays.asList("AGGRAVATED_ASSAULT,ASSAULT-SIMPLE,FONDLING,INTIMIDATION,KIDNAPPING-ABDUCTION,MANSLAUGHTER_NEGLIGENT,MANSLAUGHTER_NONNEGLIGENT-MURDER,RAPE,ROBBERY,SEX_ASSAULT-OBJECT,SODOMY".split(",")));

    String criminalActivityCategoryCode;


// The following UCR Codes requires the property entity
    ArrayList<String> offenseUCRCodeRequiresProperty = new ArrayList<>(Arrays.asList("ARSON,BAD_CHECKS,BETTING-WAGERING,BRIBERY,BURGLARY-BREAKING_ENTERING,COUNTERFEIT-FORGERY,DAMAGE-DESTRUCTION-VANDALISM_OF_PROPERTY,DRUG-EQUIPMENT_VIOLATIONS,DRUG-NARCOTIC_VIOLATIONS,EMBEZZLEMENT,EXPLOSIVES,EXPORT_VIOLATIONS,EXTORTION-BLACKMAIL FEDERAL_LIQUOR_OFFENSES,FEDERAL_TOBACCO_OFFENSES,FIREARM_ACT_VIOLATION,FRAUD-BY_WIRE,FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE,FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME,FRAUD-IMPERSONATION,FRAUD-WELFARE_FRAUD,GAMBLING-EQUIPMENT_VIOLATION,GAMBLING-OPERATING_PROMOTING_ASSISTING,HACKING-COMPUTER_INVASION,IDENTITY_THEFT,IMPORT_VIOLATIONS,KIDNAPPING-ABDUCTION,LARCENY,LARCENY-FROM_AUTO,LARCENY-FROM_BUILDING,LARCENY-FROM_COIN_OPERATED_MACHINE,LARCENY-PARTS_FROM_VEHICLE,MONEY_LAUNDERING,MOTOR_VEHICLE_THEFT,POCKET_PICKING,PURSE_SNATCHING,ROBBERY,SHOPLIFTING,SPORTS_TAMPERING,STOLEN_PROPERTY_OFFENSES,WEAPONS_OF_MASS_DESTRUCTION".split(",")));

// When Weapon/Force Involved, one of the following URC codes is required
    ArrayList<String> offenseUCRCodeRequiredWhenForceCategoryPresent = new ArrayList<>(Arrays.asList("AGGRAVATED_ASSAULT,ASSAULT-SIMPLE,EXPLOSIVES,EXTORTION-BLACKMAIL,FIREARM_ACT_VIOLATION,FONDLING,HUMAN_TRAFFICKING-COMMERCIAL_SEX_ACTS,HUMAN_TRAFFICKING-INVOLUNTARY_SERVITUDE,JUSTIFIABLE_HOMICIDE,KIDNAPPING-ABDUCTION,MANSLAUGHTER_NEGLIGENT,MANSLAUGHTER_NONNEGLIGENT-MURDER,RAPE,ROBBERY,SEX_ASSAULT-OBJECT,SODOMY,WEAPON_LAW_VIOLATIONS,WEAPONS_OF_MASS_DESTRUCTION".split(",")));

// When ItemStatusCode is NONE or SEIZED, one of the following URC codes is required
    ArrayList<String> offenseUCRCodeRequiredWhenPropertyNoneSeized = new ArrayList<>(Arrays.asList("DRUG-EQUIPMENT_VIOLATIONS,DRUG-NARCOTIC_VIOLATIONS,EXPLOSIVES,FEDERAL_LIQUOR_OFFENSES,FEDERAL_TOBACCO_OFFENSES,FIREARM_ACT_VIOLATION,IMPORT_VIOLATIONS,WEAPONS_OF_MASS_DESTRUCTION,WILDLIFE_TRAFFICKING".split(",")));

// Criminal Activity/Gang Information is submitted, one of the following URC codes is required
    ArrayList<String> offenseUCRCodeRequiredWhenCriminalActivityOrGangInformationPresent = new ArrayList<>(Arrays.asList("COUNTERFEIT-FORGERY,STOLEN_PROPERTY_OFFENSES,IMMIGRATION-SMUGGLING_ALIENS,DRUG-NARCOTIC_VIOLATIONS,DRUG-EQUIPMENT_VIOLATIONS,GAMBLING-EQUIPMENT_VIOLATION,OBSCENE_MATERIAL-PORNOGRAPHY,FUGITIVE-HARBORING_ESCAPEE-CONCEALING_FROM_ARREST,WEAPON_LAW_VIOLATIONS,FIREARM_ACT_VIOLATION,WEAPONS_OF_MASS_DESTRUCTION,EXPLOSIVES,IMPORT_VIOLATIONS,EXPORT_VIOLATIONS,FEDERAL_LIQUOR_OFFENSES,FEDERAL_TOBACCO_OFFENSES,WILDLIFE_TRAFFICKING,CRUELTY_TO_ANIMALS".split(",")));

// When Criminal Activity/Gang Information is one of the following values, UCR offense must be one of offenseUCRCodeRequiredWhenCriminalActivityOrGangInformationSubSet
    ArrayList<String> criminalActivityCategoryCodesSubset = new ArrayList<>(Arrays.asList("B,C,D,E,O,P,T,U".split(",")));

    ArrayList<String> offenseUCRCodeRequiredWhenCriminalActivityOrGangInformationSubSet = new ArrayList<>(Arrays.asList("COUNTERFEIT-FORGERY,DRUG-EQUIPMENT_VIOLATIONS,DRUG-NARCOTIC_VIOLATIONS,EXPLOSIVES,EXPORT_VIOLATIONS,FEDERAL_LIQUOR_OFFENSES,FEDERAL_TOBACCO_OFFENSES,FIREARM_ACT_VIOLATION,FUGITIVE-HARBORING_ESCAPEE-CONCEALING_FROM_ARREST,GAMBLING-EQUIPMENT_VIOLATION,IMMIGRATION-SMUGGLING_ALIENS,IMPORT_VIOLATIONS,OBSCENE_MATERIAL-PORNOGRAPHY,STOLEN_PROPERTY_OFFENSES,WEAPON_LAW_VIOLATIONS,WEAPONS_OF_MASS_DESTRUCTION,WILDLIFE_TRAFFICKING".split(",")));

    ArrayList<String> criminalActivityCategoryCodesSubsetAnimalsCruelty = new ArrayList<>(Arrays.asList("A,F,I,S".split(",")));

    ArrayList<String> offenseUCRCodeRequiredWhenCriminalActivityOrGangInformationSubSetAnimalsCruelty = new ArrayList<>(Arrays.asList("CRUELTY_TO_ANIMALS".split(",")));

// When BURGLARY-BREAKING_ENTERING, force is required F,N
    ArrayList<String> offenseUCRCodeAreRequireForce = new ArrayList<>(Arrays.asList("BURGLARY-BREAKING_ENTERING".split(",")));
    ArrayList<String> passagePointMethodCode = new ArrayList<>(Arrays.asList("F,N".split(",")));

// Charges to submit
    Where whereCharge = new Where();
    whereCharge.addGreaterThanOrEquals("chargeDate", Timestamp.valueOf(localDateTimeStart));
    whereCharge.addLessThanOrEquals("chargeDate", Timestamp.valueOf(localDateTimeEnd));
    whereCharge.addIsNotNull("chargeAttributes");
    whereCharge.addContainsAny("chargeAttributes", offenseUCRCodeGroupA)
    whereCharge.addIsNull("associatedParty.mFCU_ASR_Results")

    whereCharge.addEquals("associatedParty", Party.get(32524L))

    //whereCharge.addEquals("id",764L)

    if (_cse != null) {
        whereCharge.addEquals("associatedParty.case", _cse);
    }
    if (internalTesting == "false") {
        whereCharge.addEquals("updateReason", "NIBRS");
    }

    ArrayList<Charge> offenses = DomainObject.find(Charge.class, whereCharge)
            .findAll({ Charge it ->
                it.collect("xrefs[entityType=='Charge' and refType=='REL'].ref").isEmpty() ||
                        it.associatedParty.case.collect("crossReferences[lentity.toString() == 'com.sustain.cases.model.Charge' && rentity.toString() == 'com.sustain.cases.model.Charge'].lid").find({ id -> id == it.id }) != null
            });

    logger.debug("Cases: ${offenses.associatedParty.case.unique({ it -> it.id })}");
    logger.debug("Charges: ${offenses.size()}");

    String victimFilterXrefChargeVictim = "xrefs[refType == 'VICTIMOF' && entityType=='Party'].ref[id != null]";
    String victimFilterXrefChargeVictimById = "xrefs[refType == 'VICTIMOF' && entityType=='Party'].ref[id != null && id == #p1]";

    ArrayList<String> toEmails = new ArrayList<>(Arrays.asList(ucrstatEmailAddress?.split(",")));
    ArrayList<String> ccEmails = new ArrayList<>(Arrays.asList(ucrstatEmailAddressCC?.split(",")));
    ArrayList<String> bccEmails = new ArrayList<>();

// For test submissions, e-mail subject must say Test Data
    String emailSubject = "Test Data : ${reportType}";
    String emailBody = "${reportType} generated on: ${localDate}";
    Attachments attachments;
    File[] attachmentFiles;

    if (offenses.isEmpty()) {
        throw new Exception("Offenses failed validation; empty");
    }
    def ArrayList<Charge> processedRelatedOffenses = new ArrayList<>();
    for (def Charge offense in offenses) {
        logger.debug("offense loop: ${offense}");
        processedRelatedOffenses.add(offense);
        Case cse = offense.associatedParty.case;
        String caseCounty = cse.county;

        ArrayList<Charge> relatedCharges = new ArrayList<Charge>();
        relatedCharges.add(offense);
        relatedCharges.addAll(offense.collect("xrefs[entityType=='Charge' and refType=='REL'].ref"));

        String caseJudicialDistrictCode = com.sustain.rule.model.RuleDef.exec("NIBRS_DISTRICT", null, ["caseCounty": caseCounty]).getValue("judicialDistrict") ?: "";

        String offenseUCRCode = getOffenseUCRCode(offense);
//        def ArrayList<Party> offenseVictims = getOffenseVictims(offense, victimFilterXrefChargeVictim);
        def ArrayList<Party> offenseVictims = getOffenseVictims(relatedCharges, victimFilterXrefChargeVictim);

//        logger.debug("offense victims xref: " + offense.collect(victimFilterXrefChargeVictim));
//        logger.debug("offense victims default: ${offenseVictims}");

//        for (def Party victim in offenseVictims) {
        Path reportPath = Files.createTempFile(rootDir.toPath(), "${cse.id}_${offense.id}_x${relatedCharges.size()}_${reportFileNamePrefix}_${offenseUCRCode}_".toString(), reportFileNameSuffix);
        File reportFile = reportPath.toFile();
        PrintWriter fileWriter = new PrintWriter(reportFile);
        HashSet<Party> offenseSubjects = new HashSet(getOffenseSubjects(offense));
        ArrayList<Party> offenseSubjectsArrayList = new ArrayList(offenseSubjects);
        def Document reportDoc;

        try {
            if (!Files.exists(rootDir?.toPath())) {
                rootDir.mkdir();
            }

            fileWriter.println("""<nibrs:Submission xmlns:nibrs="http://fbi.gov/cjis/nibrs/4.2" xmlns:cjis="http://fbi.gov/cjis/1.0" xmlns:cjiscodes="http://fbi.gov/cjis/cjis-codes/1.0" xmlns:i="http://release.niem.gov/niem/appinfo/3.0/" xmlns:ucr="http://release.niem.gov/niem/codes/fbi_ucr/3.2/" xmlns:j="http://release.niem.gov/niem/domains/jxdm/5.2/" xmlns:term="http://release.niem.gov/niem/localTerminology/3.0/" xmlns:nc="http://release.niem.gov/niem/niem-core/3.0/" xmlns:niem-xsd="http://release.niem.gov/niem/proxy/xsd/3.0/" xmlns:s="http://release.niem.gov/niem/structures/3.0/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:nibrscodes="http://fbi.gov/cjis/nibrs/nibrs-codes/4.2" xmlns:msibrs="http://www.beyond2020.com/msibrs/1.0" xsi:schemaLocation="http://www.beyond2020.com/msibrs/1.0 ../base-xsd/msibrs/1.0/msibrs.xsd">""");
            fileWriter.println("<cjis:MessageMetadata>");
            //<!-- Message Timestamp -->
            fileWriter.println("<cjis:MessageDateTime>${incidentDateTimeFormatted}</cjis:MessageDateTime>");
            //<!-- Message ID -->
            fileWriter.println("<cjis:MessageIdentification>");
            fileWriter.println("<nc:IdentificationID>${cse}-${offense}</nc:IdentificationID>");
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
            fileWriter.println("<nibrs:NIBRSReportCategoryCode>GROUP A INCIDENT REPORT</nibrs:NIBRSReportCategoryCode>");
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
            fileWriter.println("<nc:Incident>");
            fileWriter.println("<nc:ActivityIdentification>");
            //<!-- Element 2, Incident Number -->
            fileWriter.println("<nc:IdentificationID>${offense.id}</nc:IdentificationID>");
            fileWriter.println("</nc:ActivityIdentification>");
            fileWriter.println("<nc:ActivityDate>");
            //<!-- Element 3, Incident Date and Hour 2016-02-19T10:00:00 -->
            fileWriter.println("<nc:DateTime>${incidentDateTimeFormatted}</nc:DateTime>");
            //<!-- Element 3, Incident Date if Hour is Unknown 2016-02-19 -->
            //<!-- <nc:Date>2016-02-19</nc:Date> -->
            fileWriter.println("</nc:ActivityDate>");
            fileWriter.println("<cjis:IncidentAugmentation>");
            //<!-- Element 3, IncidentReportDateIndicator is true to designate that the ActivityDate is the Report Date rather than the Incident Date -->
            fileWriter.println("<cjis:IncidentReportDateIndicator>${incidentReportDateIndicator}</cjis:IncidentReportDateIndicator>");
            // <!-- Element 2A, Cargo Theft Indicator: True/False-->

            if (Collections.disjoint(Arrays.asList("ROBBERY,EXTORTION-BLACKMAIL,BURGLARY-BREAKING_ENTERING,LARCENY-FROM_BUILDING,LARCENY-FROM_AUTO,LARCENY,MOTOR_VEHICLE_THEFT,FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME,FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE,FRAUD-IMPERSONATION,FRAUD-BY_WIRE,IDENTITY_THEFT,HACKING-COMPUTER_INVASION,BRIBERY,EMBEZZLEMENT".split(",")), getUCROffenses(relatedCharges)) == false) {
                fileWriter.println("<j:OffenseCargoTheftIndicator>true</j:OffenseCargoTheftIndicator>");
            }
            fileWriter.println("</cjis:IncidentAugmentation>");
            fileWriter.println("<j:IncidentAugmentation>");
            //<!-- Element 4, Cleared Exceptionally -->
            String incidentExceptionalClearanceCodeValue = offense.cf_indicentExceptionalClear != null && !offense.cf_indicentExceptionalClear.isEmpty() ? offense.cf_indicentExceptionalClear : incidentExceptionalClearanceCode[5];
            if (["JUSTIFIABLE_HOMICIDE"].contains(getOffenseUCRCode(offense))) {
                incidentExceptionalClearanceCodeValue = "N";
            }
            fileWriter.println("<j:IncidentExceptionalClearanceCode>${incidentExceptionalClearanceCodeValue}</j:IncidentExceptionalClearanceCode>");

            //<!-- Element 5, Exceptional Clearance Date -->
            if (incidentExceptionalClearanceCodeValue != "N") {
                //(offense.cf_indicentExceptionalClear != null && offense.cf_indicentExceptionalClear != "N" || incidentExceptionalClearanceCode[5] != "N"){
                fileWriter.println("<j:IncidentExceptionalClearanceDate>");
                fileWriter.println("<nc:Date>${incidentExceptionalClearanceDate}</nc:Date>");
                fileWriter.println("</j:IncidentExceptionalClearanceDate>");
            }
            fileWriter.println("</j:IncidentAugmentation>");
            fileWriter.println("</nc:Incident>");

//These filters prevent charges which are mutually exclusive from being reported in a incident report
            relatedCharges = getRelatedChargesLimitedByJustifiableHomicide(relatedCharges);
            relatedCharges = getRelatedChargesLimitedByAggravatedAssault(relatedCharges);
            relatedCharges = getRelatedChargesLimitedBySimpleAssault(relatedCharges);
            relatedCharges = getRelatedChargesLimitedByIntimidation(relatedCharges);
            relatedCharges = getRelatedChargeLimitedByUniqueOffenseUCRCode(relatedCharges);
            relatedCharges = getRelatedChargesLimitedByRobbery(relatedCharges);
            relatedCharges = getRelatedChargesLimit10(relatedCharges);

            if (Collections.disjoint(getUCROffenses(relatedCharges), personAndPropertyUCROffenses) == false &&
                    Collections.disjoint(getUCROffenses(relatedCharges), societyUCROffenses) == false) {
                relatedCharges = getRelatedChargesLimitedByExcludingListCharges(relatedCharges, societyUCROffenses);
            }
            for (def Charge relatedOffense in relatedCharges) {

                relatedOffense.setUpdateReason("NIBRS");
                relatedOffense.setCf_judicialDistrictCode(caseJudicialDistrictCode);


                fileWriter.println("<j:Offense s:id='" + "Offense${relatedOffense.id}" + "'>");
                //<!-- Element 6, Offense Code -->
                String relatedOffenseUCRCode = getOffenseUCRCode(relatedOffense);
                fileWriter.println("<nibrs:OffenseUCRCode>${offensesMap.get(relatedOffenseUCRCode)}</nibrs:OffenseUCRCode><!-- ${relatedOffenseUCRCode} -->");
                //<!-- Element 12, Type Criminal Activity/Gang Information -->
                criminalActivityCategoryCode = offenseUCRCodeRequiredWhenGangInformationCode.contains(relatedOffenseUCRCode) ? "N" : "";

                criminalActivityCategoryCode = criminalActivityCategoryCode.isEmpty() && offenseUCRCodeRequiredWhenCriminalActivityOrGangInformationSubSet.contains(relatedOffenseUCRCode) ? criminalActivityCategoryCodesSubset[0] : criminalActivityCategoryCode;

                criminalActivityCategoryCode = offenseUCRCodeRequiredWhenCriminalActivityOrGangInformationSubSetAnimalsCruelty.contains(relatedOffenseUCRCode) ? criminalActivityCategoryCodesSubsetAnimalsCruelty[0] : criminalActivityCategoryCode;

                criminalActivityCategoryCode = criminalActivityCategoryCode.isEmpty() && offenseUCRCodeRequiredWhenCriminalActivityOrGangInformationPresent.contains(relatedOffenseUCRCode) ? "A" : criminalActivityCategoryCode;

                criminalActivityCategoryCode = relatedOffenseUCRCode == weaponsOfMassDestruction ? "T" : criminalActivityCategoryCode;

                if (!criminalActivityCategoryCode.isEmpty() && Collections.disjoint(offenseUCRCodeRequiredWhenCriminalActivityOrGangInformationPresent, getUCROffenses(relatedCharges)) == false) {
                    fileWriter.println("<nibrs:CriminalActivityCategoryCode>${relatedOffense.cf_criminalActivityCategory != null ? relatedOffense.cf_criminalActivityCategory : criminalActivityCategoryCode}</nibrs:CriminalActivityCategoryCode>");
                }
                //<!-- Element 8A, Bias Motivation -->
                fileWriter.println("<j:OffenseFactorBiasMotivationCode>${relatedOffense.cf_offenseFactorBiasMotiv != null ? relatedOffense.cf_offenseFactorBiasMotiv : offenseFactorBiasMotivationCode}</j:OffenseFactorBiasMotivationCode>");
                //<!-- Element 8, Offender(s) Suspected Of Using -->
                fileWriter.println("<j:OffenseFactor>");
                fileWriter.println("<j:OffenseFactorCode>${relatedOffense.cf_offenseFactor != null ? relatedOffense.cf_offenseFactor : offenseFactorCode}</j:OffenseFactorCode>");
                fileWriter.println("</j:OffenseFactor>");
                if (offenseUCRCodeAreRequireForce.contains(relatedOffenseUCRCode)) {
                    //<!-- Element 11, Method Of Entry -->
                    fileWriter.println("<j:OffenseEntryPoint>");
                    fileWriter.println("<j:PassagePointMethodCode>${relatedOffense.cf_passagePointMethod != null ? relatedOffense.cf_passagePointMethod : passagePointMethodCode[1]}</j:PassagePointMethodCode>");
                    fileWriter.println("</j:OffenseEntryPoint>");
                }
                //<!-- Element 13, Type Weapon/Force Involved -->
                if (offenseUCRCodeRequiredWhenForceCategoryPresent.contains(relatedOffenseUCRCode)) {
                    //TODO forceCategoryCode review relatedOffense.cf_forceCategory
                    String forceCategoryCode = getForceCategoryCode(relatedOffense);
//                    logger.debug("forceCategoryCode:${forceCategoryCode}")
                    fileWriter.println("<j:OffenseForce>");
                    fileWriter.println("<j:ForceCategoryCode>${forceCategoryCode}</j:ForceCategoryCode>");
                    fileWriter.println("</j:OffenseForce>");
                }
                //<!-- Element 7, Attempted/Completed -->
                offenseAttemptedIndicator = isAttempted(relatedOffense) ? true : offenseAttemptedIndicator;
                fileWriter.println("<j:OffenseAttemptedIndicator>${isAttempted(relatedOffense)}</j:OffenseAttemptedIndicator>");
                fileWriter.println("</j:Offense>");
            }

            //loop through offenses for offense location
            //for (offense in offenses){
            //<!-- Element 9, Location Type -->
            fileWriter.println("<nc:Location s:id='" + "Location${offense.id}" + "'>");
            fileWriter.println("<nibrs:LocationCategoryCode>${offense.cf_locationCategory != null ? offense.cf_locationCategory : locationCategoryCode}</nibrs:LocationCategoryCode>");
//              fileWriter.println("<nc:LocationLocale>");
//                    fileWriter.println("<cjis:JudicialDistrictCode>${caseJudicialDistrictCode != null ? caseJudicialDistrictCode : judicialDistrictCode[0]}</cjis:JudicialDistrictCode>");
//              fileWriter.println("</nc:LocationLocale>");
            fileWriter.println("</nc:Location>");
            //}

            for (def Charge relatedOffense in getChargeListUniqueByItemStatus(relatedCharges.findAll({ Charge it -> offenseUCRCodeRequiresProperty.contains(getOffenseUCRCode(it)) }))) {
                String offenseUCRCodeRelatedOffense = getOffenseUCRCode(relatedOffense);

                //<!-- Begin Property -->
                if (Collections.disjoint(substanceRelatedUCR, getUCROffenses(relatedCharges)) && (offenseUCRCodeRequiresProperty.contains(getOffenseUCRCode(relatedOffense)) || offenseUCRCodeRequiredWhenPropertyNoneSeized.contains(getOffenseUCRCode(relatedOffense)))) {
                    fileWriter.println("<nc:Item>");
                    //<!-- Element 14, Type Property Loss/etc  -->

                    //fileWriter.println("<nc:ItemStatus>");
                    fileWriter.println("<nc:ItemStatus s:id='" + "ItemStatus${relatedOffense.id}" + "'>");
                    fileWriter.println("<cjis:ItemStatusCode>${getItemStatus(relatedOffense)}</cjis:ItemStatusCode>");
                    fileWriter.println("</nc:ItemStatus>");

                    itemCategoryNIBRSPropertyCategoryCode = getItemCategoryCode(relatedOffense);
                    if (getItemStatus(relatedOffense) != "NONE" && !isAttempted(relatedOffense)) {
                        //<!-- Element 16, Value of Property in US Dollars -->
                        if (!Arrays.asList("09,22,48,65,66".split(",")).contains(itemCategoryNIBRSPropertyCategoryCode)) {
                            fileWriter.println("<nc:ItemValue>");
                            fileWriter.println("<nc:ItemValueAmount>");
                            fileWriter.println("<nc:Amount>${relatedOffense.cf_itemValue != null ? relatedOffense.cf_itemValue : itemValueAmount}</nc:Amount>");
                            fileWriter.println("</nc:ItemValueAmount>");
                            fileWriter.println("</nc:ItemValue>");
                        }
                        //<!-- Element 15, Property Description -->
                        fileWriter.println("<j:ItemCategoryNIBRSPropertyCategoryCode>${itemCategoryNIBRSPropertyCategoryCode}</j:ItemCategoryNIBRSPropertyCategoryCode>");
                        //<!-- Element 18, Number of Stolen Motor Vehicles, if Status is Stolen -->
                        fileWriter.println("<nc:ItemQuantity>${getItemQuantity(relatedOffense)}</nc:ItemQuantity>");
                    }
                    fileWriter.println("</nc:Item>");
                }
            }

            for (def Charge relatedOffense in getChargeListUniqueBySubstanceData(relatedCharges.findAll({ Charge it -> substanceRelatedUCR.contains(getOffenseUCRCode(it)) }))) {
                if (!Collections.disjoint(substanceRelatedUCR, getUCROffenses(relatedCharges))) {
                    fileWriter.println("<nc:Substance>");
                    //<!-- Element 14, Type Property Loss/etc  Substituted for nc:ItemStatus -->
                    fileWriter.println("<nc:ItemStatus>");
                    fileWriter.println("<cjis:ItemStatusCode>SEIZED</cjis:ItemStatusCode>");
                    fileWriter.println("</nc:ItemStatus>");
                    //<!-- Element 16, Value of Property in US Dollars -->
                    if (getOffenseUCRCode(relatedOffense) == "DRUG-NARCOTIC_VIOLATIONS" && relatedCharges.size() > 1 || getOffenseUCRCode(relatedOffense) != "DRUG-NARCOTIC_VIOLATIONS") {
                        fileWriter.println("<nc:ItemValue>");
                        fileWriter.println("<nc:ItemValueAmount>");
                        fileWriter.println("<nc:Amount>12000</nc:Amount>");
                        fileWriter.println("</nc:ItemValueAmount>");
                        //<!-- Element 17, Date Recovered -->
//                        fileWriter.println("<!--<nc:ItemValueDate>");
//                        fileWriter.println("<nc:Date>2024-02-09</nc:Date>");
//                        fileWriter.println("</nc:ItemValueDate>-->");
                        fileWriter.println("</nc:ItemValue>");
                    }
                    //<!-- Element 15, Property Description -->
                    fileWriter.println("<j:ItemCategoryNIBRSPropertyCategoryCode>10</j:ItemCategoryNIBRSPropertyCategoryCode>");
                    //<!-- Element 20, Suspected Involved Drug Type -->
                    fileWriter.println("<j:DrugCategoryCode>E</j:DrugCategoryCode>");
                    fileWriter.println("<nc:SubstanceQuantityMeasure>");
                    //<!-- Element 21/22, Estimated Quantity/Fraction -->
                    fileWriter.println("<nc:MeasureDecimalValue>1.5</nc:MeasureDecimalValue>");
                    fileWriter.println("<j:SubstanceUnitCode>OZ</j:SubstanceUnitCode>");
                    fileWriter.println("</nc:SubstanceQuantityMeasure>");
                    fileWriter.println("</nc:Substance>");
                }
            }


            for (victim in offenseVictims) {
                def List<String> victimURCOffenses = getUCROffenses(relatedCharges.findAll({ Charge it -> !it.collect(victimFilterXrefChargeVictimById, victim.id).isEmpty() }));

                def boolean isStatutoryRape = victimURCOffenses.contains("RAPE-STATUTORY") ?: false;
                fileWriter.println("<nc:Person s:id='" + "PersonVictim${victim.id}" + "'>");
                if (Collections.disjoint(victimCategoryCodeSocietyRequiredUCR, getUCROffenses(relatedCharges)) == true) {
                    //<!-- Element 26, Age of Victim (only one would be included per victim)-->
                    fileWriter.println("<nc:PersonAgeMeasure>");
                    if (getAge(victim) != null && !isStatutoryRape) {
                        fileWriter.println("<nc:MeasureIntegerValue>${getAge(victim)}</nc:MeasureIntegerValue>");
                    } else {
                        fileWriter.println("<nc:MeasureIntegerRange>");
                        fileWriter.println("<nc:RangeMaximumIntegerValue>${isStatutoryRape ? 17 : maxAgeRange}</nc:RangeMaximumIntegerValue>");
                        fileWriter.println("<nc:RangeMinimumIntegerValue>${isStatutoryRape ? 12 : minAgeRange}</nc:RangeMinimumIntegerValue>");
                        fileWriter.println("</nc:MeasureIntegerRange>");
                    }

                    fileWriter.println("</nc:PersonAgeMeasure>");
                    //<!-- Element 29, Ethnicity of Victim -->
                    fileWriter.println("<j:PersonEthnicityCode>${getEthnicity(victim, offense)}</j:PersonEthnicityCode>");
                    //<!-- Element 28, Race of Victim -->
                    fileWriter.println("<j:PersonRaceNDExCode>${getRace(victim, offense)}</j:PersonRaceNDExCode>");
                    //<!-- Element 30, Resident Status -->
                    fileWriter.println("<j:PersonResidentCode>R</j:PersonResidentCode>");
                    //<!-- Element 27, Sex of Victim -->
                    fileWriter.println("<j:PersonSexCode>${getGenderCode(victim, offense)}</j:PersonSexCode>");
                }
                fileWriter.println("</nc:Person>");
            }


            for (def Party subject in offenseSubjects) {
                fileWriter.println("<nc:Person s:id='" + "PersonSubject${subject.id}" + "'>");


                //<!-- Element 37, Age of Subject (only one would be included per subject) -->
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
                //<!-- Element 39A, Ethnicity of Subject -->
                fileWriter.println("<j:PersonEthnicityCode>${getEthnicity(subject, offense)}</j:PersonEthnicityCode>");
                //<!-- Element 39, Race of Subject -->
                fileWriter.println("<j:PersonRaceNDExCode>${getRace(subject, offense)}</j:PersonRaceNDExCode>");
                //<!-- Element 38, Sex of Subject -->
                fileWriter.println("<j:PersonSexCode>${getGenderCode(subject, offense)}</j:PersonSexCode>");
                fileWriter.println("</nc:Person>");
            }


            for (victim in offenseVictims) {
                def List<String> victimURCOffenses = getUCROffenses(relatedCharges.findAll({ Charge it -> !it.collect(victimFilterXrefChargeVictimById, victim.id).isEmpty() }))
//                logger.debug("victimURCOffenses:${victimURCOffenses}");
                fileWriter.println("<j:Victim s:id='" + "Victim${victim.id}" + "'>");
                fileWriter.println("<nc:RoleOfPerson s:ref='" + "PersonVictim${victim.id}" + "'/>");
                //<!-- Element 23, Victim Sequence Number -->
//                fileWriter.println("<j:VictimSequenceNumberText>${offenseVictimsArrayList.indexOf(victim) + 1}</j:VictimSequenceNumberText>");
                fileWriter.println("<j:VictimSequenceNumberText>${offenseVictims.indexOf(victim) + 1}</j:VictimSequenceNumberText>");

                //TODO review victim injury type when victim related offense meets criteria

                def ArrayList<String> victimOffenseUCRCodes = getVictimOffenseUCRCodes(relatedCharges, victim, victimFilterXrefChargeVictimById)

                if (!Collections.disjoint(victimOffenseUCRCodes, victimInjuryTypeRequiredUCR)) {
                    //  <!-- Element 33, Type Injury -->
                    fileWriter.println("<j:VictimInjury>");
                    fileWriter.println("<j:InjuryCategoryCode>N</j:InjuryCategoryCode>");
                    fileWriter.println("</j:VictimInjury>");
                }
                //<!-- Element 25, Type of Victim -->
//TODO is there a better way to determine victimCategoryCode?
                String victimCategoryCode = "I";
                if (Collections.disjoint(victimCategoryCodeSocietyRequiredUCR, getUCROffenses(relatedCharges)) == false) {
                    victimCategoryCode = "S";
                }

                if (Collections.disjoint(victimCategoryCodeGovernmentRequiredUCR, getUCROffenses(relatedCharges)) == false) {
                    victimCategoryCode = "G";
                }

                fileWriter.println("<j:VictimCategoryCode>${victimCategoryCode}</j:VictimCategoryCode>");

//                if (["09A", "09B", "09C", "13A"].contains(offensesMap.get(getOffenseUCRCode(offense)))) {
                if(Collections.disjoint(victimOffenseUCRCodes, ["AGGRAVATED_ASSAULT", "MANSLAUGHTER_NONNEGLIGENT-MURDER","MANSLAUGHTER_NEGLIGENT","JUSTIFIABLE_HOMICIDE"]) == false){
                    def String victimAggravatedAssaultHomicideFactorCode = "";
                    if (!Collections.disjoint(victimURCOffenses, ["AGGRAVATED_ASSAULT", "MANSLAUGHTER_NONNEGLIGENT-MURDER"])) {
                        victimAggravatedAssaultHomicideFactorCode = "10";
                    } else if (!Collections.disjoint(victimURCOffenses, ["MANSLAUGHTER_NEGLIGENT"])) {
                        victimAggravatedAssaultHomicideFactorCode = "34";
                    } else if (!Collections.disjoint(victimURCOffenses, ["JUSTIFIABLE_HOMICIDE"])) {
                        victimAggravatedAssaultHomicideFactorCode = "20";
                    }

                    if (!victimAggravatedAssaultHomicideFactorCode.isEmpty()) {
                        //<!-- Element 31, Aggravated Assault/Homicide Circumstances -->
                        fileWriter.println("<j:VictimAggravatedAssaultHomicideFactorCode>${victimAggravatedAssaultHomicideFactorCode}</j:VictimAggravatedAssaultHomicideFactorCode>");
                    }
                }

//                if (["09C"].contains(offensesMap.get(getOffenseUCRCode(offense)))) {
                if(Collections.disjoint(victimOffenseUCRCodes, ["JUSTIFIABLE_HOMICIDE"]) == false){
                    String victimJustifiableHomicideFactorCode = "C";
                    //<!-- Element 32, Additional Justifiable Homicide Circumstances -->
                    fileWriter.println("<j:VictimJustifiableHomicideFactorCode>${victimJustifiableHomicideFactorCode}</j:VictimJustifiableHomicideFactorCode>");
                }
                fileWriter.println("</j:Victim>");
            }

            for (subject in offenseSubjects) {
                fileWriter.println("<j:Subject s:id='" + "Subject${subject.id}" + "'>");
                fileWriter.println("<nc:RoleOfPerson s:ref='" + "PersonSubject${subject.id}" + "'/>");
                //<!-- Element 36, Offender Sequence Number -->
                fileWriter.println("<j:SubjectSequenceNumberText>${offenseSubjectsArrayList.indexOf(subject) + 1}</j:SubjectSequenceNumberText>");
                fileWriter.println("</j:Subject>");
            }

            //<!-- Associations  -->

            //<!-- Offense Location Association -->
            for (relatedOffense in relatedCharges) {
                fileWriter.println("<j:OffenseLocationAssociation>");
                fileWriter.println("<j:Offense s:ref='" + "Offense${relatedOffense.id}" + "'/>");
                fileWriter.println("<nc:Location s:ref='" + "Location${offense.id}" + "'/>");
                fileWriter.println("</j:OffenseLocationAssociation>");
            }

            //<!-- Element 24, Victim Connected to UCR Offense Code -->
            for (def Charge relatedOffense in relatedCharges) {
                for (def Party victim in relatedOffense.collect(victimFilterXrefChargeVictim)) {
                    fileWriter.println("<j:OffenseVictimAssociation>");
                    fileWriter.println("<j:Offense s:ref='" + "Offense${relatedOffense.id}" + "'/>");
                    fileWriter.println("<j:Victim s:ref='" + "Victim${victim.id}" + "'/>");
                    fileWriter.println("</j:OffenseVictimAssociation>");
                }
            }

            //<!--Element 34, Offender Number(s) to be related -->
            if (Collections.disjoint(personAndPropertyUCROffenses, getUCROffenses(relatedCharges)) == false) {
                for (def Party subject in offenseSubjects) {
                    for (victim in offenseVictims) {
                        def List<String> victimURCOffenses = getUCROffenses(relatedCharges.findAll({ Charge it -> !it.collect(victimFilterXrefChargeVictimById, victim.id).isEmpty() }));
                        fileWriter.println("<j:SubjectVictimAssociation s:id='" + "SubjectVictimAssocSP${subject.id}${victim.id}" + "'>");
                        fileWriter.println("<j:Subject s:ref='" + "Subject${subject.id}" + "'/>");
                        fileWriter.println("<j:Victim s:ref='" + "Victim${victim.id}" + "'/>");
                        //<!-- Element 35, Relationship(s) of Victim To Offender -->
                        String victimToSubjectRelationshipCode = "Acquaintance";
                        if (Collections.disjoint(victimURCOffenses, ["INCEST"]) == false) {
                            victimToSubjectRelationshipCode = "Family Member";
                        }
                        fileWriter.println("<nibrs:VictimToSubjectRelationshipCode>${victimToSubjectRelationshipCode}</nibrs:VictimToSubjectRelationshipCode>");
                        fileWriter.println("</j:SubjectVictimAssociation>");
                    }
                }
            }


            fileWriter.println("</nibrs:Report>");
            fileWriter.println("</nibrs:Submission>");
            fileWriter.flush();
            fileWriter.close();

            attachmentFiles = new ArrayList<>(Arrays.asList(reportFile)).toArray(File[]);
            attachments = new Attachments(attachmentFiles);

            reportDoc = createDocument(reportFile, cse, offenses, batch, caseJudicialDistrictCode);
            addDocumentToDocuments(cse, reportDoc);

            if (_sendEmail == true) {
                mailManager.sendMailToAll(toEmails, ccEmails, bccEmails, emailSubject, emailBody, attachments);
            }
            _fileOut = reportFile;
            Files.deleteIfExists(reportPath);
        } catch (Exception exception) {
            logger.debug("exception:${exception.getMessage()}")
            interfaceTracking.setResult("FAIL");
            interfaceTrackingDetails.add(createTrackingDetail(interfaceTracking, nowTimestamp, "", "", "", exception.getMessage()));
        } finally {
            logger.debug("finally:")
            !interfaceTracking.result?.isEmpty() ?: interfaceTracking.setResult("SUCCESS");
            DomainObject.saveOrUpdate(cse);
            DomainObject.saveOrUpdateAll(processedRelatedOffenses);
            DomainObject.saveOrUpdate(interfaceTracking);
            DomainObject.saveOrUpdateAll(interfaceTrackingDetails);
        }
//        }
    }

}

protected CtInterfaceTrackingDetail createTrackingDetail(CtInterfaceTracking interfaceTracking, Timestamp timestamp, String recordId, String status, String memo, String exception) {
    CtInterfaceTrackingDetail interfaceTrackingDetail = new CtInterfaceTrackingDetail();
    interfaceTrackingDetail.setCtInterfaceTracking(interfaceTracking);
    interfaceTrackingDetail.setRecordId(recordId);
    interfaceTrackingDetail.setStatus(status);
    interfaceTrackingDetail.setStatusDate(timestamp);
    interfaceTrackingDetail.setMemo(memo);
    interfaceTrackingDetail.setException(exception);
    interfaceTracking.add(interfaceTrackingDetail);
    return interfaceTrackingDetail;
}

protected String getOffenseUCRCode(Charge offense) {
    String code = offense.collect("chargeAttributes").find({ it -> it != null });
    return code != null ? code?.trim() : "";
}

protected ArrayList<String> getVictimOffenseUCRCodes(ArrayList<Charge> relatedCharges, Party victim, String victimFilterXrefChargeVictimById) {
    def ArrayList<String> victimOffenseUCRCodes = new ArrayList();
    relatedCharges.findAll({ Charge it -> it.collect(victimFilterXrefChargeVictimById, victim.id) }).each({ Charge it -> victimOffenseUCRCodes.add(getOffenseUCRCode(it)) });
    return victimOffenseUCRCodes;
}

protected ArrayList<Party> getOffenseSubjects(Charge offense) {
    ArrayList<Party> ucrOffenseSubjects = new ArrayList();
    ucrOffenseSubjects.add(offense.associatedParty);
    return ucrOffenseSubjects;
}

protected Party createOffenseVictim(Case cse) {
    def Party offenseVictim = new Party()
    offenseVictim.setCase(cse);
    offenseVictim.setPartyType("VIC");
    offenseVictim.setStatus("ACTIVE")
    offenseVictim.setPerson(Person.get(35291L));
    DomainObject.saveOrUpdate(offenseVictim);
    cse.add(offenseVictim, "parties");
    return offenseVictim;
}

protected ArrayList<Party> getOffenseVictims(ArrayList<Charge> offenses, String victimFilterXrefChargeVictim) {
    def ArrayList<Party> ucrOffenseVictims = new ArrayList();
    for (Charge offense in offenses) {
        def Case cse = offense.associatedParty.case;

        def RichList<Party> ucrOffenseVictimsList = offense.collect(victimFilterXrefChargeVictim);
        if (!ucrOffenseVictimsList.isEmpty()) {
            ucrOffenseVictims.addAll(ucrOffenseVictimsList);
        } else {
            def Party defaultParty = DomainObject.find(Party.class, "partyType", "VIC", "status", "ACTIVE","case.id", cse.id, "person.id", 35291L).find({Party it -> it != null});
            def Party offenseVictim = defaultParty != null ? defaultParty : createOffenseVictim(cse);
            ucrOffenseVictims.add(offenseVictim);
            offense.addCrossReference(offenseVictim, "VICTIMOF")
        }
    }
    return ucrOffenseVictims?.unique({ Party it -> it })?.sort({ a, b -> a.id <=> b.id });
}

protected Integer getAge(Party party) {
    def Integer age = party.person.collect("profiles[dateOfBirth != null].age").find({ it -> it != null });
    return age;
}

protected String getGenderCode(Party party, Charge thisOffense) {
    def String gender = party.person.collect("profiles[gender != null].gender").find({ it -> it != null });
    if ((gender == null || !["MALE", "FEMALE"].contains(gender)) && isExceptionalClearanceAtoE(thisOffense) == false) {
        gender = "U";
    } else if (gender == "FEMALE") {
        gender = "F";
    } else {
        gender = "M";
    }
    return gender;
}

protected String getEthnicity(Party party, Charge thisOffense) {
    def String ethnicity = party.person.collect("profiles[ethnicity != null].ethnicity").find({ it -> it != null });
    if (ethnicity == null && isExceptionalClearanceAtoE(thisOffense) == false) {
        ethnicity = "U";
    } else if (ethnicity == "HISPANIC") {
        ethnicity = "H";
    } else {
        ethnicity = "N";
    }
    return ethnicity;
}

protected String getRace(Party party, Charge thisOffense) {
    def String race = party.person.collect("profiles[ethnicity != null].ethnicity").find({ it -> it != null });
    if (isExceptionalClearanceAtoE(thisOffense) == false && (race == null || !["WHITE", "BLACK", "AMERICANINDIAN", "ASIAN", "NATIVEHAWAIIAN"].contains(race))) {
        race = "U";
    } else if (race == "BLACK") {
        race = "B";
    } else if (race == "AMERICANINDIAN") {
        race = "I";
    } else if (race == "ASIAN") {
        race = "A";
    } else if (race == "NATIVEHAWAIIAN") {
        race = "P";
    } else {
        race = "W";
    }
    return race;
}

protected String getItemCategoryCode(Charge thisOffense) {
    def String itemCategory = thisOffense.cf_itemCategory ?: "08";
    if (Arrays.asList("MOTOR_VEHICLE_THEFT".split(",")).contains(getOffenseUCRCode(thisOffense))) {
        itemCategory = "03";
    } else if (Arrays.asList("LARCENY-FROM_BUILDING,LARCENY-FROM_COIN_OPERATED_MACHINE,LARCENY-FROM_AUTO,LARCENY-PARTS_FROM_VEHICLE,LARCENY".split(",")).contains(getOffenseUCRCode(thisOffense))) {
        itemCategory = "08";
    } else if (Arrays.asList("ARSON".split(",")).contains(getOffenseUCRCode(thisOffense))) {
        itemCategory = "29";
    }
    return itemCategory;
}

protected String getItemStatus(Charge thisOffense) {
    def String itemStatus = thisOffense.cf_itemStatus == null || isAttempted(thisOffense) ? "NONE" : thisOffense.cf_itemStatus;
//logger.debug("assign1 itemStatus:${itemStatus}");
    if (Arrays.asList("BRIBERY,BURGLARY-BREAKING_ENTERING,KIDNAPPING-ABDUCTION,ROBBERY".split(",")).contains(getOffenseUCRCode(thisOffense))) {
        //Item Status Code must be NONE, RECOVERED, STOLEN or UNKNOWN
//        logger.debug("assign2 itemStatus:${itemStatus}");
        itemStatus = isAttempted(thisOffense) ? "NONE" : "STOLEN";
    }

    if (Arrays.asList("COUNTERFEIT-FORGERY,EXPORT_VIOLATIONS".split(",")).contains(getOffenseUCRCode(thisOffense))) {
        itemStatus = isAttempted(thisOffense) ? "NONE" : "COUNTERFEITED";
//        logger.debug("assign3 itemStatus:${itemStatus}");
    }

    if (Arrays.asList("DAMAGE-DESTRUCTION-VANDALISM_OF_PROPERTY".split(",")).contains(getOffenseUCRCode(thisOffense))) {
        itemStatus = isAttempted(thisOffense) ? "NONE" : "DESTROYED_DAMAGED_VANDALIZED";
//        logger.debug("assign4 itemStatus:${itemStatus}");
    }

    if (Arrays.asList("EMBEZZLEMENT,EXTORTION-BLACKMAIL,FRAUD-BY_WIRE,FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE,FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME,FRAUD-IMPERSONATION,FRAUD-WELFARE_FRAUD,HACKING-COMPUTER_INVASION,IDENTITY_THEFT LARCENY,LARCENY-FROM_AUTO LARCENY-FROM_BUILDING,LARCENY-FROM_COIN_OPERATED_MACHINE,LARCENY-PARTS_FROM_VEHICLE,MONEY_LAUNDERING,MOTOR_VEHICLE_THEFT,POCKET_PICKING,PURSE_SNATCHING,ROBBERY,SHOPLIFTING".split(",")).contains(getOffenseUCRCode(thisOffense))) {
        //Offense Attempted = 'false' then the Item Status Code (Property Loss Type) must be RECOVERED or STOLEN
//        logger.debug("assign5 itemStatus:${itemStatus}");
        itemStatus = isAttempted(thisOffense) ? "NONE" : "STOLEN";
    }

    if (Arrays.asList("EMBEZZLEMENT,EXTORTION-BLACKMAIL,FRAUD-BY_WIRE,FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE,FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME,FRAUD-IMPERSONATION,FRAUD-WELFARE_FRAUD,HACKING-COMPUTER_INVASION IDENTITY_THEFT,LARCENY,LARCENY-FROM_AUTO,LARCENY-FROM_BUILDING,LARCENY-FROM_COIN_OPERATED_MACHINE,LARCENY-PARTS_FROM_VEHICLE,MONEY_LAUNDERING,MOTOR_VEHICLE_THEFT,POCKET_PICKING,PURSE_SNATCHING,ROBBERY,SHOPLIFTING".split(",")).contains(getOffenseUCRCode(thisOffense))) {
        //Offense Attempted = 'false' then the Item Status Code (Property Loss Type) must be RECOVERED or STOLEN
//        logger.debug("assign6 itemStatus:${itemStatus}");
        itemStatus = isAttempted(thisOffense) ? "NONE" : "STOLEN";
    }

    if (!isAttempted(thisOffense) && Arrays.asList("BETTING-WAGERING,GAMBLING-OPERATING_PROMOTING_ASSISTING,GAMBLING-EQUIPMENT_VIOLATION,SPORTS_TAMPERING".split(",")).contains(getOffenseUCRCode(thisOffense))) {
        itemStatus = isAttempted(thisOffense) ? "NONE" : "SEIZED";
//        logger.debug("assign7 itemStatus:${itemStatus}");
    }

    // Offense Attempted = 'false' then the Item Status Code (Property Loss Type) must be NONE, RECOVERED, STOLEN or UNKNOWN
    if (Arrays.asList("BRIBERY,BURGLARY-BREAKING_ENTERING,KIDNAPPING-ABDUCTION".split(",")).contains(getOffenseUCRCode(thisOffense))) {
        itemStatus = isAttempted(thisOffense) ? "NONE" : "STOLEN";
//        logger.debug("assign8 itemStatus:${itemStatus}");
    }

    //Offense Attempted = 'false' then the Item Status Code (Property Loss Type) must be RECOVERED or STOLEN
    if (Arrays.asList("EMBEZZLEMENT,EXTORTION-BLACKMAIL,FRAUD-BY_WIRE,FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE,FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME,FRAUD-IMPERSONATION,FRAUD-WELFARE_FRAUD,HACKING-COMPUTER_INVASION,IDENTITY_THEFT,LARCENY,LARCENY-FROM_AUTO,LARCENY-FROM_BUILDING,LARCENY-FROM_COIN_OPERATED_MACHINE,LARCENY-PARTS_FROM_VEHICLE,MONEY_LAUNDERING,MOTOR_VEHICLE_THEFT,POCKET_PICKING,PURSE_SNATCHING,ROBBERY SHOPLIFTING".split(",")).contains(getOffenseUCRCode(thisOffense))) {
        itemStatus = isAttempted(thisOffense) ? "NONE" : "STOLEN";
//        logger.debug("assign9 itemStatus:${itemStatus}");
    }

    if (Arrays.asList("ARSON".split(",")).contains(getOffenseUCRCode(thisOffense))) {
        itemStatus = isAttempted(thisOffense) ? "NONE" : "BURNED";
//        logger.debug("assign10 itemStatus:${itemStatus}");
    }
    thisOffense.cf_itemStatus = itemStatus;
//    logger.debug("assign11 itemStatus:${itemStatus}");
    return itemStatus;
}

protected ArrayList<Charge> getChargeListUniqueBySubstanceData(ArrayList<Charge> thisChargeList) {
    def ArrayList<Charge> newChargeList = new ArrayList();
    newChargeList.addAll(thisChargeList);
    return newChargeList.unique({ Charge it -> "${it.cf_drugCategoryCode} ${it.cf_substanceUnitCode}" });
}

protected ArrayList<Charge> getChargeListUniqueByItemStatus(ArrayList<Charge> thisChargeList) {
    def ArrayList<Charge> newChargeList = new ArrayList();
    newChargeList.addAll(thisChargeList);
    return newChargeList.unique({ it -> "" + getItemStatus(it) + getItemCategoryCode(it) });
}

protected boolean isAttempted(Charge thisOffense) {
    boolean isAttempt = false;
    if (thisOffense.inchoateType == null || thisOffense.inchoateType != "ATTEMPT") {
        isAttempt = false;
    } else {
        isAttempt = true;
    }
    return isAttempt;
}

protected List<Charge> getRelatedChargesLimitedByJustifiableHomicide(ArrayList<Charge> theseCharges) {
    ArrayList<Charge> theseChargesFiltered = new ArrayList();
    Charge justifiableCharge = theseCharges.find({ it -> getOffenseUCRCode(it) == "JUSTIFIABLE_HOMICIDE" });
    if (justifiableCharge != null) {
        theseChargesFiltered.add(justifiableCharge);
        return theseChargesFiltered;
    } else {
        return theseCharges;
    }
}

protected List<Charge> getRelatedChargesLimitedByAggravatedAssault(ArrayList<Charge> theseCharges) {
    ArrayList<Charge> theseChargesFiltered = new ArrayList();
    ArrayList<String> restrictedCharges = Arrays.asList("ASSAULT-SIMPLE,FONDLING,INTIMIDATION,MANSLAUGHTER_NEGLIGENT,MANSLAUGHTER_NONNEGLIGENT-MURDER,RAPE,ROBBERY,SEX_ASSAULT-OBJECT,SODOMY".split(","));
    Charge testCharge = theseCharges.find({ it -> getOffenseUCRCode(it) == "AGGRAVATED_ASSAULT" });
    if (testCharge != null && !theseCharges.findAll({ it -> restrictedCharges.contains(getOffenseUCRCode(it)) }).isEmpty()) {
        theseChargesFiltered.add(testCharge);
        theseChargesFiltered.addAll(theseCharges.findAll({ it -> !restrictedCharges.contains(getOffenseUCRCode(it)) }));
        return theseChargesFiltered;
    } else {
        return theseCharges;
    }
}

///
protected List<Charge> getRelatedChargesLimitedByRobbery(ArrayList<Charge> theseCharges) {
    ArrayList<Charge> theseChargesFiltered = new ArrayList();
    ArrayList<String> restrictedCharges = Arrays.asList("LARCENY,LARCENY-FROM_AUTO,LARCENY-FROM_BUILDING,LARCENY-FROM_COIN_OPERATED_MACHINE,LARCENY-PARTS_FROM_VEHICLE,MOTOR_VEHICLE_THEFT,POCKET_PICKING,PURSE_SNATCHING,SHOPLIFTING".split(","));
    Charge testCharge = theseCharges.find({ it -> getOffenseUCRCode(it) == "ROBBERY" });
    if (testCharge != null && !theseCharges.findAll({ it -> restrictedCharges.contains(getOffenseUCRCode(it)) }).isEmpty()) {
        theseChargesFiltered.add(testCharge);
        theseChargesFiltered.addAll(theseCharges.findAll({ it -> !restrictedCharges.contains(getOffenseUCRCode(it)) }));
        return theseChargesFiltered;
    } else {
        return theseCharges;
    }
}

protected List<Charge> getRelatedChargesLimitedBySimpleAssault(ArrayList<Charge> theseCharges) {
    ArrayList<Charge> theseChargesFiltered = new ArrayList();
    ArrayList<String> restrictedCharges = Arrays.asList("AGGRAVATED_ASSAULT,FONDLING,INTIMIDATION,MANSLAUGHTER_NEGLIGENT,MANSLAUGHTER_NONNEGLIGENT-MURDER,RAPE ROBBERY,SEX_ASSAULT-OBJECT,SODOMY".split(","));
    Charge testCharge = theseCharges.find({ it -> getOffenseUCRCode(it) == "ASSAULT-SIMPLE" });
    if (testCharge != null && !theseCharges.findAll({ it -> restrictedCharges.contains(getOffenseUCRCode(it)) }).isEmpty()) {
        theseChargesFiltered.add(testCharge);
        theseChargesFiltered.addAll(theseCharges.findAll({ it -> !restrictedCharges.contains(getOffenseUCRCode(it)) }));
        return theseChargesFiltered;
    } else {
        return theseCharges;
    }
}

protected List<Charge> getRelatedChargesLimitedByIntimidation(ArrayList<Charge> theseCharges) {
    ArrayList<Charge> theseChargesFiltered = new ArrayList();
    ArrayList<String> restrictedCharges = Arrays.asList("AGGRAVATED_ASSAULT,ASSAULT-SIMPLE,FONDLING,MANSLAUGHTER_NEGLIGENT,MANSLAUGHTER_NONNEGLIGENT-MURDER,RAPE,ROBBERY,SEX_ASSAULT-OBJECT,SODOMY".split(","));
    Charge testCharge = theseCharges.find({ it -> getOffenseUCRCode(it) == "INTIMIDATION" });
    if (testCharge != null && !theseCharges.findAll({ it -> restrictedCharges.contains(getOffenseUCRCode(it)) }).isEmpty()) {
        theseChargesFiltered.add(testCharge);
        theseChargesFiltered.addAll(theseCharges.findAll({ it -> !restrictedCharges.contains(getOffenseUCRCode(it)) }));
        return theseChargesFiltered;
    } else {
        return theseCharges;
    }
}

protected List<Charge> getRelatedChargeLimitedByUniqueOffenseUCRCode(ArrayList<Charge> theseCharges) {
    return theseCharges.unique({ it -> getOffenseUCRCode(it) });
}

protected List<Charge> getRelatedChargesLimitedByExcludingListCharges(ArrayList<Charge> theseCharges, ArrayList<String> excludeCharges) {
    ArrayList<Charge> theseChargesFiltered = new ArrayList();
    if (!theseCharges.findAll({ it -> !excludeCharges.contains(getOffenseUCRCode(it)) }).isEmpty()) {
        theseChargesFiltered.addAll(theseCharges.findAll({ it -> !excludeCharges.contains(getOffenseUCRCode(it)) }));
        return theseChargesFiltered;
    } else return theseCharges;
}

protected List<Charge> getRelatedChargesLimit10(ArrayList<Charge> theseCharges) {
    theseCharges.unique({ it -> getOffenseUCRCode(it) });
    if (theseCharges.size() > 10) {
        return theseCharges.subList(0, 9);
    } else return theseCharges;
}


protected String getItemQuantity(Charge thisOffense) {
    String itemQuantity = isAttempted(thisOffense) ? "00" : "01";
    itemQuantity = thisOffense.cf_itemQuantity != null && thisOffense.cf_itemQuantity?.matches("\\d{2}") ? thisOffense.cf_itemQuantity : itemQuantity;
    itemQuantity = isAttempted(thisOffense) == false && (!itemQuantity?.matches("\\d{2}") || itemQuantity == "00") ? "01" : itemQuantity;
    return itemQuantity;
}

protected boolean isExceptionalClearanceAtoE(Charge thisOffense) {
    if (thisOffense.cf_indicentExceptionalClear?.matches("[A-E]")) {
        return true;
    } else {
        return false;
    }
}

protected Document createDocument(File fileAttachment, Case cse, List<Charge> charges, String batch, String caseJudicialDistrictCode) {
    Document reportDocument = new Document();
    reportDocument.case = cse;
    reportDocument.docDef = DomainObject.find(DocDef.class, "shortName", "NIBRSA").find({ it -> it != null });
    reportDocument.memo = charges.id.join("_");
    reportDocument.reviewStatus = "PRIVILEGED";
    reportDocument.batchSource = "NIBRSA";
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

protected List<String> getUCROffenses(List<Charge> offenses) {
    List<String> ucrOffenses = new ArrayList();
    offenses.each({ Charge it -> ucrOffenses.add(it.collect("chargeAttributes")?.find({ attr -> attr != null })) });
    return ucrOffenses;
}

protected String getForceCategoryCode(Charge thisOffense) {
    def String forceCategoryCode = thisOffense.cf_forceCategory != null ? thisOffense.cf_forceCategory : "99";

// AGGRAVATED_ASSAULT when Weapon/Force is used, one of the following URC codes is required
    ArrayList<String> offenseUCRCodeRequiredWhenFireArmsWeapons = new ArrayList<>(Arrays.asList("AGGRAVATED_ASSAULT".split(",")));
    ArrayList<String> forceCategoryCodeFireArmsWeapons = new ArrayList<>(Arrays.asList("11,12,13,14,15".split(",")));
// ASSAULT-SIMPLE when Weapon/Force is used, one of the following URC codes is required
    ArrayList<String> offenseUCRCodeRequiredWhenNonFireArmsWeapons = new ArrayList<>(Arrays.asList("ASSAULT-SIMPLE".split(",")));
    ArrayList<String> forceCategoryCodeNonFireArmsWeapons = new ArrayList<>(Arrays.asList("40,90,95,99".split(",")));

    ArrayList<String> forceCategoryCodeWeaponViolations = new ArrayList<>(Arrays.asList("35,50,60,65,70,85".split(",")));

    //Homicide Offenses
    def ArrayList<String> homicideOffenses = Arrays.asList("MANSLAUGHTER_NONNEGLIGENT-MURDER,MANSLAUGHTER_NEGLIGENT,JUSTIFIABLE_HOMICIDE".split(","));

    if (offenseUCRCodeRequiredWhenFireArmsWeapons.contains(getOffenseUCRCode(thisOffense)) &&
            !forceCategoryCodeFireArmsWeapons.contains(forceCategoryCode)) {
        forceCategoryCode = "11";
    } else if (offenseUCRCodeRequiredWhenNonFireArmsWeapons.contains(getOffenseUCRCode(thisOffense)) &&
            !forceCategoryCodeNonFireArmsWeapons.contains(forceCategoryCode)) {
        forceCategoryCode = "40";
    } else if (homicideOffenses.contains(getOffenseUCRCode(thisOffense)) &&
            forceCategoryCode == "99") {
        forceCategoryCode = "30";
    } else if (getOffenseUCRCode(thisOffense) == "WEAPON_LAW_VIOLATIONS" &&
            !forceCategoryCodeWeaponViolations.contains(forceCategoryCode)) {
        forceCategoryCode = "35";
    }
    thisOffense.cf_forceCategory = forceCategoryCode;
    return forceCategoryCode;
}