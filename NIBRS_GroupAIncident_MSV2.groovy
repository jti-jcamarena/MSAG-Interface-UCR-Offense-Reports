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
import java.util.Collections;

/**
 lastUpdated:01/18/2024 10:04
 *Need an ORI number for this agency and lea's
 *https://journaltech.sharepoint.com/:x:/s/MississippiAG/EegY8NK6owBEmQV-Z29xNh4BvLjC4KmD0-CsZNgnbsQu1w?e=grZ56N
 *
 *The UCR Code must be unique within the Incident Report.
 *
 *Any subjects/defendants and victims must all be related to each other, so it's necessary to limit each report by victim so that any included are subjects *correctly associated.
 *
 *Each Offense Segment with a valid UCR Offense code, must have an Offense Victim Association
 *
 *The Location type is required for each offense.
 *
 *When submitting a Group A Incident Report to be ingested into the NIBRS system, Incident, Offense, Victim, and Subject must be provided.
 */


// ZoneId is set to local value, America/Los_Angeles, for testing; the validation applicaiton xcota will fail a filing if the datatime is ahead of the local time

Map offensesMap = new HashMap();
//GROUP A OFFENSES
//crimes against person
offensesMap.put("AGGRAVATED_ASSAULT", "13A");//tested
offensesMap.put("ASSAULT-SIMPLE", "13B");//tested
offensesMap.put("JUSTIFIABLE_HOMICIDE", "09C");//tested
offensesMap.put("MANSLAUGHTER_NONNEGLIGENT-MURDER", "09A");//tested
offensesMap.put("INTIMIDATION", "13C");//tested

offensesMap.put("MANSLAUGHTER_NEGLIGENT", "09B");//tested
offensesMap.put("HUMAN_TRAFFICKING-COMMERCIAL_SEX_ACTS", "64A");//tested
offensesMap.put("HUMAN_TRAFFICKING-INVOLUNTARY_SERVITUDE", "64B");//tested
offensesMap.put("KIDNAPPING-ABDUCTION", "100");//tested
offensesMap.put("RAPE", "11A");//tested

offensesMap.put("SODOMY", "11B");//tested
offensesMap.put("SEX_ASSAULT-OBJECT", "11C");//tested
offensesMap.put("FONDLING", "11D");//tested
offensesMap.put("INCEST", "36A");//tested
offensesMap.put("RAPE-STATUTORY", "36B");//FAILED

//crimes against property
offensesMap.put("ARSON", "200");//tested
offensesMap.put("BRIBERY", "510");//tested
offensesMap.put("BURGLARY-BREAKING_ENTERING", "220");//tested
offensesMap.put("COUNTERFEIT-FORGERY", "250");//tested
offensesMap.put("DAMAGE-DESTRUCTION-VANDALISM_OF_PROPERTY", "290");//tested

offensesMap.put("EMBEZZLEMENT", "270");//failed
offensesMap.put("EXTORTION-BLACKMAIL", "210");//failed
offensesMap.put("FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME", "26A");//tested
offensesMap.put("FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE", "26B");//tested
offensesMap.put("FRAUD-IMPERSONATION", "26C");//tested

offensesMap.put("FRAUD-WELFARE_FRAUD", "26D");//tested
offensesMap.put("FRAUD-BY_WIRE", "26E");//tested
offensesMap.put("IDENTITY_THEFT", "26F");//tested
offensesMap.put("HACKING-COMPUTER_INVASION", "26G");//tested
offensesMap.put("MONEY_LAUNDERING", "26H");//failed code 26H is not valid ; OffenseCodeType - The Enumeration constraint failed

offensesMap.put("POCKET_PICKING", "23A");//tested
offensesMap.put("PURSE_SNATCHING", "23B");//tested
offensesMap.put("SHOPLIFTING", "23C");//tested
offensesMap.put("LARCENY-FROM_BUILDING", "23D");//tested
offensesMap.put("LARCENY-FROM_COIN_OPERATED_MACHINE", "23E");//tested

offensesMap.put("LARCENY-FROM_AUTO", "23F");//tested
offensesMap.put("LARCENY-PARTS_FROM_VEHICLE", "23G");//tested
offensesMap.put("LARCENY", "23H");//tested
offensesMap.put("MOTOR_VEHICLE_THEFT", "240");//tested
offensesMap.put("ROBBERY", "120");//tested
offensesMap.put("STOLEN_PROPERTY_OFFENSES", "280");//tested

//crimes against society
offensesMap.put("CRUELTY_TO_ANIMALS", "720");//tested

offensesMap.put("IMMIGRATION-FALSE_CITIZENSHIP", "30B");//failed  The Enumeration constraint failed
offensesMap.put("IMMIGRATION-ILLEGAL_ENTRY_INTO_US", "30A");//failed  The Enumeration constraint failed
offensesMap.put("IMMIGRATION-SMUGGLING_ALIENS", "30C");//failed  The Enumeration constraint failed
offensesMap.put("IMMIGRATION-RE_ENTRY_AFTER_DEPORTATION", "30D");//failed  The Enumeration constraint failed
offensesMap.put("OBSCENE_MATERIAL-PORNOGRAPHY", "370");//tested

offensesMap.put("PROSTITUTION", "40A");//tested
offensesMap.put("PROSTITUTION-ASSISTING_OR_PROMOTING", "40B");//tested
offensesMap.put("PROSTITUTION-PURCHASING", "40C");//tested
offensesMap.put("SEX_OFFENSER_REGISTRATION_VIOLATION", "360");//failed  The Enumeration constraint failed
offensesMap.put("IMPORT_VIOLATIONS", "58A");//failed  The Enumeration constraint failed

offensesMap.put("EXPORT_VIOLATIONS", "58B");//failed  The Enumeration constraint failed
offensesMap.put("FEDERAL_LIQUOR_OFFENSES", "61A");//failed  The Enumeration constraint failed
offensesMap.put("FEDERAL_TOBACCO_OFFENSES", "61B");//failed  The Enumeration constraint failed
offensesMap.put("WILDLIFE_TRAFFICKING", "620");//failed  The Enumeration constraint failed
offensesMap.put("DRUG-NARCOTIC_VIOLATIONS", "35A");//failed

offensesMap.put("DRUG-EQUIPMENT_VIOLATIONS", "35B");//failed
offensesMap.put("ESPIONAGE", "103");//failed  The Enumeration constraint failed
offensesMap.put("FUGITIVE-HARBORING_ESCAPEE-CONCEALING_FROM_ARREST", "49A");//failed  The Enumeration constraint failed
offensesMap.put("FUGITIVE-FLIGHT_TO_AVOID_PROSECUTION", "49B");//failed  The Enumeration constraint failed
offensesMap.put("FUGITIVE-FLIGHT_TO_AVOID_DEPORTATION", "49C");//failed  The Enumeration constraint failed

offensesMap.put("BETTING-WAGERING", "39A");//tested
offensesMap.put("GAMBLING-OPERATING_PROMOTING_ASSISTING", "39B");//tested
offensesMap.put("GAMBLING-EQUIPMENT_VIOLATION", "39C");//tested
offensesMap.put("SPORTS_TAMPERING", "39D");//tested
offensesMap.put("TREASON", "101");//failed  The Enumeration constraint failed

offensesMap.put("WEAPON_LAW_VIOLATIONS", "520");//failed
offensesMap.put("FIREARM_ACT_VIOLATION", "521");//failed  The Enumeration constraint failed
offensesMap.put("WEAPONS_OF_MASS_DESTRUCTION", "522");//failed  The Enumeration constraint failed
offensesMap.put("EXPLOSIVES", "526");//failed  The Enumeration constraint failed

//GROUP A OFFENSES
//crimes against person, property, or society
offensesMap.put("ALL_OTHER_OFFENSES", "90Z");//review listed as Group B

//crimes against society
offensesMap.put("FAILURE TO APPEAR", "90K");//review listed as Group B
offensesMap.put("CURFEW-LOITERING-VAGRANCY_VIOLATIONS", "90B");//review listed as Group B
offensesMap.put("DISORDERLY_CONDUCT", "90C");//review listed as Group B
offensesMap.put("DRIVING_UNDER_INFLUENCE", "90D");//review listed as Group B
offensesMap.put("FAMILY_OFFENSES_NONVIOLENT", "90F");//review listed as Group B

offensesMap.put("FEDERAL_RESOURCE_VIOLATIONS", "90L");//review listed as Group B
offensesMap.put("LIQUOR_LAW_VIOLATIONS", "90G");//review listed as Group B
offensesMap.put("PERJURY", "90M");//review listed as Group B
offensesMap.put("TRESPASSING", "90J");//review listed as Group B


String internalTesting = SystemProperty.getValue("nibrs.email.testing");
internalTesting = internalTesting == null || internalTesting.isEmpty() ? "true" : internalTesting;
String ucrstatEmailAddress = internalTesting == "true" ? SystemProperty.getValue("nibrs.email.inbox.test") : SystemProperty.getValue("nibrs.email.inbox");
internalTesting != "true" ?: logger.debug("internalTesting:${internalTesting}; ucrstatEmailAddress:${ucrstatEmailAddress}");
String ucrstatEmailAddressCC = SystemProperty.getValue("nibrs.email.inbox.cc")?: "";

//pst:America/Los_Angeles, cst:America/Chicago
LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Chicago")).withNano(0);
LocalDate localDate = LocalDate.now();
LocalDate localDateLastDayOfMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());

LocalDateTime localDateTimeStart = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0).withNano(0);
LocalDateTime localDateTimeEnd = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(58).withNano(999999999);

_reportingPeriod = "${localDateTimeStart} : ${localDateTimeEnd}".toString();
_lastDayOfMonth = "lastDayOfTheMonth:${localDate == localDateLastDayOfMonth} - ${localDateLastDayOfMonth}".toString();

if (localDate == localDateLastDayOfMonth || internalTesting == "true"){

    DateTimeFormatter yearMonthFomatter = DateTimeFormatter.ofPattern("yyyy-MM");
    String reportType = "GroupAIncidentReport";
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
    internalTesting != "true" ?: logger.debug("interfaceTracking: ${interfaceTracking.interfaceName }; ${interfaceTracking.executionDate}");

/*
Path reportPath = Files.createTempFile(rootDir.toPath(), reportFileNamePrefix, reportFileNameSuffix);
File reportFile = reportPath.toFile();
PrintWriter fileWriter = new PrintWriter(reportFile);
*/
    String messageIdentifier = "EATTORNEY";

//ORI number must match this pattern [A-Z]{2}+[0-9]{7}+
    String oriPattern = "[A-Z]{2}+[0-9]{7}+";
    String submittingAgencyORINumber = SystemProperty.getValue("nibrs.ori.agency.submitting")?.matches(oriPattern) ? SystemProperty.getValue("nibrs.ori.agency.submitting") : "MS090017V"; //default test value
    String owningAgencyORINumber = SystemProperty.getValue("nibrs.ori.agency.owning")?.matches(oriPattern) ? SystemProperty.getValue("nibrs.ori.agency.owning") : "MS090017V"; //default test value
    internalTesting != "true" ?: logger.debug("submittingAgencyORINumber:${submittingAgencyORINumber}");
    internalTesting != "true" ?: logger.debug("owningAgencyORINumber:${owningAgencyORINumber}");


    String reportActionCategoryCode = "I";
    String incidentNumber = "EATTORNEY";
    LocalDateTime incidentDateTime = localDateTime;
    boolean incidentReportDateIndicator = false;
    ArrayList<String> incidentExceptionalClearanceCode = new ArrayList<>(Arrays.asList("A","B","C","D","E","N"));
//TEST required when incidentExceptionalClearanceCode == A - E
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
    ArrayList<String> offenseAttemptedIndicatorReqFalse = new ArrayList<>(Arrays.asList("NONE","RECOVERED","BURNED"));

// When Criminal Activity/Gang Information in gangInfomation: J,G,N, one of the following URC codes is required
    ArrayList<String> offenseUCRCodeRequiredWhenGangInformationCode = new ArrayList<>(Arrays.asList("AGGRAVATED_ASSAULT,ASSAULT-SIMPLE,FONDLING,INTIMIDATION,KIDNAPPING-ABDUCTION,MANSLAUGHTER_NEGLIGENT,MANSLAUGHTER_NONNEGLIGENT-MURDER,RAPE,ROBBERY,SEX_ASSAULT-OBJECT,SODOMY".split(",")));

    String criminalActivityCategoryCode;

    ArrayList<String> offenseUCRCodeGroupA = new ArrayList<>(Arrays.asList("ALL_OTHER_OFFENSES,AGGRAVATED_ASSAULT,ARSON,ASSAULT-SIMPLE,BETTING-WAGERING,BRIBERY,BURGLARY-BREAKING_ENTERING,COUNTERFEIT-FORGERY,CRUELTY_TO_ANIMALS,DAMAGE-DESTRUCTION-VANDALISM_OF_PROPERTY,DRUG-EQUIPMENT_VIOLATIONS,DRUG-NARCOTIC_VIOLATIONS,EMBEZZLEMENT,ESPIONAGE,EXPLOSIVES,EXPORT_VIOLATIONS,EXTORTION-BLACKMAIL,FEDERAL_LIQUOR_OFFENSES,FEDERAL_TOBACCO_OFFENSES,FIREARM_ACT_VIOLATION,FONDLING,FRAUD-BY_WIRE,FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE,FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME,FRAUD-IMPERSONATION,FRAUD-WELFARE_FRAUD,FUGITIVE-FLIGHT_TO_AVOID_DEPORTATION,FUGITIVE-FLIGHT_TO_AVOID_PROSECUTION,FUGITIVE-HARBORING_ESCAPEE-CONCEALING_FROM_ARREST,GAMBLING-EQUIPMENT_VIOLATION,GAMBLING-OPERATING_PROMOTING_ASSISTING,HACKING-COMPUTER_INVASION,HUMAN_TRAFFICKING-COMMERCIAL_SEX_ACTS,HUMAN_TRAFFICKING-INVOLUNTARY_SERVITUDE,IDENTITY_THEFT,IMMIGRATION-FALSE_CITIZENSHIP,IMMIGRATION-ILLEGAL_ENTRY_INTO_US,IMMIGRATION-OTHER_IMMIGRATION_VIOLATIONS,IMMIGRATION-RE_ENTRY_AFTER_DEPORTATION,IMMIGRATION-SMUGGLING_ALIENS,IMPORT_VIOLATIONS,INCEST,INTIMIDATION,JUSTIFIABLE_HOMICIDE,KIDNAPPING-ABDUCTION,LARCENY,LARCENY-FROM_AUTO,LARCENY-FROM_BUILDING,LARCENY-FROM_COIN_OPERATED_MACHINE,LARCENY-PARTS_FROM_VEHICLE,MANSLAUGHTER_NEGLIGENT,MANSLAUGHTER_NONNEGLIGENT-MURDER,MONEY_LAUNDERING,MOTOR_VEHICLE_THEFT,OBSCENE_MATERIAL-PORNOGRAPHY,POCKET_PICKING,PROSTITUTION,PROSTITUTION-ASSISTING_OR_PROMOTING,PROSTITUTION-PURCHASING,PURSE_SNATCHING,RAPE,RAPE-STATUTORY,ROBBERY,SEX_ASSAULT-OBJECT,SEX_OFFENDER_REGISTRATION_VIOLATION,SHOPLIFTING,SODOMY,SPORTS_TAMPERING,STOLEN_PROPERTY_OFFENSES,TREASON,WEAPON_LAW_VIOLATIONS,WEAPONS_OF_MASS_DESTRUCTION,WILDLIFE_TRAFFICKING".split(",")));

//Victim type must be G - Government
    ArrayList<String> offenseUCRCodeRequiredWhenVictimTypeG = Arrays.asList("DRUG-EQUIPMENT_VIOLATIONS,DRUG-NARCOTIC_VIOLATIONS,EXPLOSIVES,FEDERAL_LIQUOR_OFFENSES,FEDERAL_TOBACCO_OFFENSES,FIREARM_ACT_VIOLATION,IMPORT_VIOLATIONS,WEAPONS_OF_MASS_DESTRUCTION,WILDLIFE_TRAFFICKING,ALL_OTHER_OFFENSES,EXPORT_VIOLATIONS,MONEY_LAUNDERING".split(","));



// When victim type is S, one of the following URC codes is required
    ArrayList<String> offenseUCRCodeAreCrimesAgainsSocietyRequireVictimTypeS = new ArrayList<>(Arrays.asList("ALL_OTHER_OFFENSES,BETTING-WAGERING,CRUELTY_TO_ANIMALS,CURFEW-LOITERING-VAGRANCY_VIOLATIONS,DISORDERLY_CONDUCT,DRIVING_UNDER_INFLUENCE,DRUG-EQUIPMENT_VIOLATIONS,DRUG-NARCOTIC_VIOLATIONS,DRUNKENNESS,ESPIONAGE,FAILURE_TO_APPEAR,FAMILY_OFFENSES-NONVIOLENT,FEDERAL_RESOURCE_VIOLATIONS,FUGITIVE-FLIGHT_TO_AVOID_DEPORTATION,FUGITIVE-FLIGHT_TO_AVOID_PROSECUTION,FUGITIVE-HARBORING_ESCAPEE-CONCEALING_FROM_ARREST,GAMBLING-EQUIPMENT_VIOLATION,GAMBLING-OPERATING_PROMOTING_ASSISTING,IMMIGRATION-FALSE_CITIZENSHIP,IMMIGRATION-ILLEGAL_ENTRY_INTO_US,IMMIGRATION-OTHER_IMMIGRATION_VIOLATIONS,IMMIGRATION-RE_ENTRY_AFTER_DEPORTATION,IMMIGRATION-SMUGGLING_ALIENS,LIQUOR_LAW_VIOLATIONS,OBSCENE_MATERIAL-PORNOGRAPHY,PEEPING_TOM,PERJURY,PROSTITUTION,PROSTITUTION-ASSISTING_OR_PROMOTING,PROSTITUTION-PURCHASING,SEX_OFFENDER_REGISTRATION_VIOLATION,SPORTS_TAMPERING,TREASON,TRESPASSING,WEAPON_LAW_VIOLATIONS".split(",")));



    ArrayList<String> offenseUCRCodeRequiredWhenWeaponInvolved = new ArrayList<>(Arrays.asList("JUSTIFIABLE_HOMICIDE,MANSLAUGHTER_NEGLIGENT,MANSLAUGHTER_NONNEGLIGENT-MURDER".split(",")));

// AGGRAVATED_ASSAULT when Weapon/Force is used, one of the following URC codes is required
    ArrayList<String> offenseUCRCodeRequiredWhenFireArmsWeapons = new ArrayList<>(Arrays.asList("AGGRAVATED_ASSAULT".split(",")));

// ASSAULT-SIMPLE when Weapon/Force is used, one of the following URC codes is required
    ArrayList<String> offenseUCRCodeRequiredWhenNonFireArmsWeapons = new ArrayList<>(Arrays.asList("ASSAULT-SIMPLE".split(",")));

// When property loss type NONE, RECOVERED, STOLEN, UNKNOWN is used, one of the following URC codes is required
    ArrayList<String> offenseUCRCodeRequiredWhenPropertyLossTypeNoneRecoveredStolenUnknown = new ArrayList<>(Arrays.asList("BRIBERY,BURGLARY-BREAKING_ENTERING,KIDNAPPING-ABDUCTION".split(",")));

// The following UCR Codes requires the property entity
    ArrayList<String> offenseUCRCodeRequiresProperty = new ArrayList<>(Arrays.asList("ALL_OTHER_OFFENSES,ARSON,BAD_CHECKS,BETTING-WAGERING,BRIBERY,BURGLARY-BREAKING_ENTERING,COUNTERFEIT-FORGERY,DAMAGE-DESTRUCTION-VANDALISM_OF_PROPERTY,DRUG-EQUIPMENT_VIOLATIONS,DRUG-NARCOTIC_VIOLATIONS,EMBEZZLEMENT,EXPLOSIVES,EXPORT_VIOLATIONS,EXTORTION-BLACKMAIL FEDERAL_LIQUOR_OFFENSES,FEDERAL_TOBACCO_OFFENSES,FIREARM_ACT_VIOLATION,FRAUD-BY_WIRE,FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE,FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME,FRAUD-IMPERSONATION,FRAUD-WELFARE_FRAUD,GAMBLING-EQUIPMENT_VIOLATION,GAMBLING-OPERATING_PROMOTING_ASSISTING,HACKING-COMPUTER_INVASION,IDENTITY_THEFT,IMPORT_VIOLATIONS,KIDNAPPING-ABDUCTION,LARCENY,LARCENY-FROM_AUTO,LARCENY-FROM_BUILDING,LARCENY-FROM_COIN_OPERATED_MACHINE,LARCENY-PARTS_FROM_VEHICLE,MONEY_LAUNDERING,MOTOR_VEHICLE_THEFT,POCKET_PICKING,PURSE_SNATCHING,ROBBERY,SHOPLIFTING,SPORTS_TAMPERING,STOLEN_PROPERTY_OFFENSES,WEAPONS_OF_MASS_DESTRUCTION".split(",")));


// When Weapon/Force Involved, one of the following URC codes is required
    ArrayList<String> offenseUCRCodeRequiredWhenForceCategoryPresent = new ArrayList<>(Arrays.asList("AGGRAVATED_ASSAULT,ASSAULT-SIMPLE,EXPLOSIVES,EXTORTION-BLACKMAIL,FIREARM_ACT_VIOLATION,FONDLING,HUMAN_TRAFFICKING-COMMERCIAL_SEX_ACTS,HUMAN_TRAFFICKING-INVOLUNTARY_SERVITUDE,JUSTIFIABLE_HOMICIDE,KIDNAPPING-ABDUCTION,MANSLAUGHTER_NEGLIGENT,MANSLAUGHTER_NONNEGLIGENT-MURDER,RAPE,ROBBERY,SEX_ASSAULT-OBJECT,SODOMY,WEAPON_LAW_VIOLATIONS,WEAPONS_OF_MASS_DESTRUCTION".split(",")));

    ArrayList<String> judicialDistrictCode = new ArrayList<>(Arrays.asList("MISSISSIPPI_NORTHERN","MISSISSIPPI_SOUTHERN".split(",")));

    ArrayList<String> criminalActivity = new ArrayList<>(Arrays.asList("A,B,C,D,F,E,I,O,P,S,T,U".split(",")));

    ArrayList<String> gangInformation = new ArrayList<>(Arrays.asList("J,G,N".split(",")));

// When ItemStatusCode is NONE or SEIZED, one of the following URC codes is required
    ArrayList<String> offenseUCRCodeRequiredWhenPropertyNoneSeized = new ArrayList<>(Arrays.asList("DRUG-EQUIPMENT_VIOLATIONS,DRUG-NARCOTIC_VIOLATIONS,EXPLOSIVES,FEDERAL_LIQUOR_OFFENSES,FEDERAL_TOBACCO_OFFENSES,FIREARM_ACT_VIOLATION,IMPORT_VIOLATIONS,WEAPONS_OF_MASS_DESTRUCTION,WILDLIFE_TRAFFICKING".split(","))); //removed item : WILDLIFE_TRAFFICKING

// When ItemStatusCode is BURNED, one of the following URC codes is required
    ArrayList<String> offenseUCRCodeRequiredWhenPropertyBurned = new ArrayList<>(Arrays.asList("ARSON".split(",")));

// When ItemStatusCode is STOLEN and the Offense Attempted = 'false', one of the following URC codes is required
    ArrayList<String> offenseUCRCodeRequiredWhenPropertyLossTypeStolen = new ArrayList<>(Arrays.asList("BRIBERY,BURGLARY-BREAKING_ENTERING,EMBEZZLEMENT,EXTORTION-BLACKMAIL,FRAUD-BY_WIRE,FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE,FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME,FRAUD-IMPERSONATION,FRAUD-WELFARE_FRAUD,HACKING-COMPUTER_INVASION,IDENTITY_THEFT,KIDNAPPING-ABDUCTION,LARCENY,LARCENY-FROM_AUTO,LARCENY-FROM_BUILDING,LARCENY-FROM_COIN_OPERATED_MACHINE,LARCENY-PARTS_FROM_VEHICLE,MONEY_LAUNDERING,MOTOR_VEHICLE_THEFT,POCKET_PICKING,PURSE_SNATCHING,ROBBERY,SHOPLIFTING".split(",")));

// When ItemStatusCode is Seized and the Offense Attempted = 'false', one of the following URC codes is required
    ArrayList<String> offenseUCRCodeRequiredWhenPropertyLossTypeSeized = new ArrayList<>(Arrays.asList("BETTING-WAGERING,COUNTERFEIT-FORGERY,DRUG-EQUIPMENT_VIOLATIONS,DRUG-NARCOTIC_VIOLATIONS,EXPLOSIVES,EXPORT_VIOLATIONS,FEDERAL_LIQUOR_OFFENSES,FEDERAL_TOBACCO_OFFENSES,FIREARM_ACT_VIOLATION,GAMBLING-EQUIPMENT_VIOLATION,GAMBLING-OPERATING_PROMOTING_ASSISTING,IMPORT_VIOLATIONS,SPORTS_TAMPERING,WEAPONS_OF_MASS_DESTRUCTION,WILDLIFE_TRAFFICKING".split(",")));

// Criminal Activity/Gang Information is submitted, one of the following URC codes is required
    ArrayList<String> offenseUCRCodeRequiredWhenCriminalActivityOrGangInformationPresent = new ArrayList<>(Arrays.asList("COUNTERFEIT-FORGERY,STOLEN_PROPERTY_OFFENSES,IMMIGRATION-SMUGGLING_ALIENS,DRUG-NARCOTIC_VIOLATIONS,DRUG-EQUIPMENT_VIOLATIONS,GAMBLING-EQUIPMENT_VIOLATION,OBSCENE_MATERIAL-PORNOGRAPHY,FUGITIVE-HARBORING_ESCAPEE-CONCEALING_FROM_ARREST,WEAPON_LAW_VIOLATIONS,FIREARM_ACT_VIOLATION,WEAPONS_OF_MASS_DESTRUCTION,EXPLOSIVES,IMPORT_VIOLATIONS,EXPORT_VIOLATIONS,FEDERAL_LIQUOR_OFFENSES,FEDERAL_TOBACCO_OFFENSES,WILDLIFE_TRAFFICKING,CRUELTY_TO_ANIMALS".split(",")));


// When Criminal Activity/Gang Information is one of the following values, UCR offense must be one of offenseUCRCodeRequiredWhenCriminalActivityOrGangInformationSubSet
    ArrayList<String> criminalActivityCategoryCodesSubset = new ArrayList<>(Arrays.asList("B,C,D,E,O,P,T,U".split(",")));

    ArrayList<String> offenseUCRCodeRequiredWhenCriminalActivityOrGangInformationSubSet = new ArrayList<>(Arrays.asList("COUNTERFEIT-FORGERY,DRUG-EQUIPMENT_VIOLATIONS,DRUG-NARCOTIC_VIOLATIONS,EXPLOSIVES,EXPORT_VIOLATIONS,FEDERAL_LIQUOR_OFFENSES,FEDERAL_TOBACCO_OFFENSES,FIREARM_ACT_VIOLATION,FUGITIVE-HARBORING_ESCAPEE-CONCEALING_FROM_ARREST,GAMBLING-EQUIPMENT_VIOLATION,IMMIGRATION-SMUGGLING_ALIENS,IMPORT_VIOLATIONS,OBSCENE_MATERIAL-PORNOGRAPHY,STOLEN_PROPERTY_OFFENSES,WEAPON_LAW_VIOLATIONS,WEAPONS_OF_MASS_DESTRUCTION,WILDLIFE_TRAFFICKING".split(",")));

//
    ArrayList<String> criminalActivityCategoryCodesSubsetAnimalsCruelty = new ArrayList<>(Arrays.asList("A,F,I,S".split(",")));

    ArrayList<String> offenseUCRCodeRequiredWhenCriminalActivityOrGangInformationSubSetAnimalsCruelty = new ArrayList<>(Arrays.asList("CRUELTY_TO_ANIMALS".split(",")));

//
    ArrayList<String> itemStatusCodesSubSet = new ArrayList<>(Arrays.asList("RECOVERED,STOLEN".split(",")));

// When victim type is G, UCR offense must be one of following
    ArrayList<String> offenseUCRCodeRequiredWhenVictimTypeIsG = new ArrayList<>(Arrays.asList("ALL_OTHER_OFFENSES,EXPLOSIVES,EXPORT_VIOLATIONS,FEDERAL_LIQUOR_OFFENSES,FEDERAL_TOBACCO_OFFENSES,FIREARM_ACT_VIOLATION,IMPORT_VIOLATIONS,MONEY_LAUNDERING,WEAPONS_OF_MASS_DESTRUCTION,WILDLIFE_TRAFFICKING".split(",")));

    ArrayList<String> offenseUCRCodeRequiredWhenPropertyRecoveredStolen = new ArrayList<>(Arrays.asList("EMBEZZLEMENT,EXTORTION-BLACKMAIL,FRAUD-BY_WIRE,FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE,FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME,FRAUD-IMPERSONATION,FRAUD-WELFARE_FRAUD,HACKING-COMPUTER_INVASION,IDENTITY_THEFT,LARCENY,LARCENY-FROM_AUTO,LARCENY-FROM_BUILDING,LARCENY-FROM_COIN_OPERATED_MACHINE,LARCENY-PARTS_FROM_VEHICLE,MONEY_LAUNDERING,MOTOR_VEHICLE_THEFT,POCKET_PICKING,PURSE_SNATCHING,ROBBERY,SHOPLIFTING".split(",")));

// When UCR is DAMAGE-DESTRUCTION-VANDALISM_OF_PROPERTY, item status must be DESTROYED_DAMAGED_VANDALIZED
    ArrayList<String> offenseUCRCodeRequiredWhenPropertyDamagedOrDestroyed = new ArrayList<>(Arrays.asList("DAMAGE-DESTRUCTION-VANDALISM_OF_PROPERTY".split(",")));



// When offense is one of the following URC codes is required, victim type is can't be S
    ArrayList<String> crimesAgainsProperty = Arrays.asList("ALL_OTHER_OFFENSES,ARSON,BAD_CHECKS,BRIBERY,BURGLARY-BREAKING_ENTERING,COUNTERFEIT-FORGERY,DAMAGE-DESTRUCTION-VANDALISM_OF_PROPERTY,EMBEZZLEMENT,EXTORTION-BLACKMAIL,FRAUD-BY_WIRE,FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE,FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME FRAUD-IMPERSONATION,FRAUD-WELFARE_FRAUD,HACKING-COMPUTER_INVASION,IDENTITY_THEFT,LARCENY,LARCENY-FROM_AUTO,LARCENY-FROM_BUILDING LARCENY-FROM_COIN_OPERATED_MACHINE,LARCENY-PARTS_FROM_VEHICLE,MOTOR_VEHICLE_THEFT,POCKET_PICKING,PURSE_SNATCHING,ROBBERY,SHOPLIFTING,STOLEN_PROPERTY_OFFENSES".split(","));


// When BURGLARY-BREAKING_ENTERING, force is required F,N
    ArrayList<String> offenseUCRCodeAreRequireForce = new ArrayList<>(Arrays.asList("BURGLARY-BREAKING_ENTERING".split(",")));
    ArrayList<String> passagePointMethodCode = new ArrayList<>(Arrays.asList("F,N".split(",")));

// Type of Victim
    ArrayList<String> victimCategoryCodes = new ArrayList<>(Arrays.asList("B,F,G,I,L,O,R,S,U".split(",")));


// A Victim Age, Sex, Race, Resident, and Ethnicity can only be provided when the Victim Type is (I,L).
    ArrayList<String> victimCategoryCodesRequireDemographics = new ArrayList<>(Arrays.asList("I,L".split(",")));

// Filtered Group A Offenses
    ArrayList<String> offenseUCRCodeGroupAFiltered = offenseUCRCodeGroupA;
//offenseUCRCodeGroupAFiltered.removeAll(offenseUCRCodeRequiredWhenForceCategoryPresent);


// Charges to submit
    Where whereCharge = new Where();
    whereCharge.addGreaterThanOrEquals("chargeDate", Timestamp.valueOf(localDateTimeStart));
    whereCharge.addLessThanOrEquals("chargeDate", Timestamp.valueOf(localDateTimeEnd));
    whereCharge.addIsNotNull("chargeAttributes");
    whereCharge.addContainsAny("chargeAttributes", offenseUCRCodeGroupA);

    if (_cse != null){
        whereCharge.addEquals("associatedParty.case", _cse);
    }
    if (internalTesting == "false"){
        whereCharge.addEquals("updateReason", "NIBRS");
    }

    ArrayList<Charge> offensesAll = DomainObject.find(Charge.class, whereCharge)
            .findAll({it ->
                it.collect("xrefs[entityType=='Charge' and refType=='REL'].ref").isEmpty() && !offenseUCRCodeAreCrimesAgainsSocietyRequireVictimTypeS.contains(getOffenseUCRCode(it)) || offenseUCRCodeAreCrimesAgainsSocietyRequireVictimTypeS.contains(getOffenseUCRCode(it)) ||
                        it.id == it.associatedParty.case.collect("crossReferences[lentity.toString() == 'com.sustain.cases.model.Charge' && rentity.toString() == 'com.sustain.cases.model.Charge'].lid").find({id -> id != null}) || !it.associatedParty.case.collect("crossReferences[lentity.toString() == 'com.sustain.cases.model.Charge' && rentity.toString() == 'com.sustain.cases.model.Charge'].lid").findAll({id -> id == it.id}).isEmpty()
            });

    ArrayList<Charge> offenses = offensesAll;
    internalTesting != "true" ?: logger.debug("offensesAll size: ${offensesAll.size()}; parties:${offensesAll.associatedParty}");


//throw new Exception("TESTING");

    offensesAll.each({it ->
        internalTesting != "true" ?: logger.debug(!it.collect("xrefs[entityType=='Charge' and refType=='REL'].ref").isEmpty() ? "each offense: " +it.id + " " +  it.collect("xrefs[entityType=='Charge' and refType=='REL'].ref") : "each offense: " + it.id);
    });

    internalTesting != "true" ?: logger.debug("offenses size: " + offenses.findAll({it ->
        it.collect("xrefs[entityType=='Charge' and refType=='REL'].ref").isEmpty() ||
                it.id == it.associatedParty.case.collect("crossReferences[lentity.toString() == 'com.sustain.cases.model.Charge' && rentity.toString() == 'com.sustain.cases.model.Charge'].lid").find({id -> id != null})
    }).size());

//throw new Exception("TESTING");
//ArrayList<Case> cases = offenses.associatedParty.case;
//cases.each({it -> it.collect("parties")})


//HashSet<Party> offenseVictims = new HashSet();
    String victimFilterXrefChargeVictim = "xrefs[refType == 'VICTIMOF' && entityType=='Party'].ref";
    String chargeFilterXrefVictimCharge = "xrefs[refType == 'VICTIMOF' && entityType=='Charge'].ref";
    String chargeFilter = "charges[chargeDate >= #p1 && chargeDate <= #p2]";
//offenses.each({offense -> offenseVictims.addAll(offense.collect(victimFilterXrefChargeVictim))});
//ArrayList<Party> offenseVictimsArrayList = new ArrayList(offenseVictims);


//offenses = offenses.unique({it -> getOffenseUCRCode(it)});


/*
internalTesting != "true" ?: logger.debug("offenseUCRCodeGroupA: ${offenseUCRCodeGroupA.size()}");
internalTesting != "true" ?: logger.debug("offenseUCRCodeRequiresProperty: ${offenseUCRCodeRequiresProperty.size()}");
internalTesting != "true" ?: logger.debug("offenseUCRCodeRequiredWhenPropertyLossTypeStolen: ${offenseUCRCodeRequiredWhenPropertyLossTypeStolen.size()}");
internalTesting != "true" ?: logger.debug("offenseUCRCodeRequiredWhenPropertyLossTypeSeized: ${offenseUCRCodeRequiredWhenPropertyLossTypeSeized.size()}");
*/
    ArrayList<String> toEmails = new ArrayList<>(Arrays.asList(ucrstatEmailAddress?.split(",")));
    ArrayList<String> ccEmails = new ArrayList<>(Arrays.asList(ucrstatEmailAddressCC?.split(",")));
    ArrayList<String> bccEmails = new ArrayList<>();

// For test submissions, e-mail subject must say Test Data
    String emailSubject = "Test Data : ${reportType}";
    String emailBody = "${reportType} generated on: ${localDate}";
    Attachments attachments;
    File[] attachmentFiles;

/*
if (submittingAgencyORINumber.matches(oriPattern) == false){
  throw new Exception("SubmittingAgencyORINumber failed validation");
}
if (owningAgencyORINumber.matches(oriPattern) == false){
  throw new Exception("OwningAgencyORINumber failed validation");
}
*/
    if (offenses.isEmpty()){
        throw new Exception("Offenses failed validation; empty");
    }

/*************************************************************************************************************************/
/*
internalTesting != "true" ?: logger.debug("offenses:${offenses}; offenseSubjects:${offenseSubjects}; offenseVictims:${offenseVictims}");
JSONArray ucrs = new JSONArray();
offenses.each({it ->
  JSONArray ucrSubjects = new JSONArray();
  offenseSubjects.findAll({party -> party.collect("charges").findAll({charge -> getOffenseUCRCode(charge) == getOffenseUCRCode(it)})}).each({party ->
    ArrayList<Charge> chargeXrefVictims = new ArrayList();

    party.collect("charges").findAll({charge -> getOffenseUCRCode(charge) == getOffenseUCRCode(it)}).each({charge -> chargeXrefVictims.addAll(charge.collect(victimFilterXrefChargeVictim))});

    JSONArray ucrVictims = new JSONArray();

    chargeXrefVictims.each({victim ->
      JSONObject ucrVictim = new JSONObject();
      ucrVictim.put("id",victim.id);
      ucrVictims.put(ucrVictim);
    });

    JSONObject ucrSubject = new JSONObject();
    ucrSubject.put("id",party.id);
    ucrSubject.put("vicitms",ucrVictims);
  	ucrSubjects.put(ucrSubject);
  });

  JSONObject ucrobject = new JSONObject();
  ucrobject.put("ucr",getOffenseUCRCode(it));
  ucrobject.put("date", localDate);
  ucrobject.put("location","loc");
  ucrobject.put("subjects", ucrSubjects)
  ucrs.put(ucrobject);
});

internalTesting != "true" ?: logger.debug(ucrs);
//internalTesting != "true" ?: logger.debug("query: " + ucrs.query("ucr:"));
//throw new Exception("TESTING");
*/
/*************************************************************************************************************************/
    internalTesting != "true" ?: logger.debug("Offense defendants: ${offenses.associatedParty}");
    //throw new Exception("TESTING");
    for (offense in offenses){
        Case cse = offense.associatedParty.case;
        String caseCounty = cse.county;
        //String caseJudicialDistrictCode = DomainObject.find(LookupItem.class, "lookupList.name", "COUNTY", "code", caseCounty)?.find({it -> it != null})?.description;


        ArrayList<Charge> relatedCharges = new ArrayList<Charge>();
        relatedCharges.add(offense);
        relatedCharges.addAll(offense.collect("xrefs[entityType=='Charge' and refType=='REL'].ref"));
        internalTesting != "true" ?: logger.debug("filter 0: relatedCharges:${relatedCharges.size()}");

        String caseJudicialDistrictCode = com.sustain.rule.model.RuleDef.exec("NIBRS_DISTRICT", null, ["caseCounty": caseCounty] ).getValue("judicialDistrict");

        internalTesting != "true" ?: logger.debug("caseJudicialDistrictCode:${caseJudicialDistrictCode}");
        String offenseUCRCode = getOffenseUCRCode(offense);
        HashSet<Party> offenseVictims = getOffenseSubjectVictims(offensesAll, offenseUCRCode, victimFilterXrefChargeVictim)
                .findAll({it ->
                    (offenseUCRCode == statutoryRapeUCR && getAge(it) < 18) || offenseUCRCode != statutoryRapeUCR
                });

        ArrayList<Party> offenseVictimsArrayList = new ArrayList(offenseVictims);
        //internalTesting != "true" ?: logger.debug("offenseVictims: " + offenseVictims);

        for (victim in offenseVictims){
            CtInterfaceTrackingDetail interfaceTrackingDetail = new CtInterfaceTrackingDetail();
            interfaceTrackingDetail.ctInterfaceTracking = interfaceTracking;
            interfaceTrackingDetail.recordId = "";
            interfaceTrackingDetail.status = "";
            interfaceTrackingDetail.statusDate = Timestamp.valueOf(localDateTime);
            interfaceTrackingDetail.saveOrUpdate();
            interfaceTracking.add(interfaceTrackingDetail);
            interfaceTracking.saveOrUpdate();

            Path reportPath = Files.createTempFile(rootDir.toPath(), "${cse.id}_${offense.id}_${reportFileNamePrefix}_${offenseUCRCode}_".toString(), reportFileNameSuffix);
            File reportFile = reportPath.toFile();
            PrintWriter fileWriter = new PrintWriter(reportFile);

            //HashSet<Party> offenseSubjects = new HashSet(getOffenseSubjects(offensesAll, offenseUCRCode, victimFilterXrefChargeVictim, victim));
            HashSet<Party> offenseSubjects = new HashSet(getOffenseSubjects(offense));
            ArrayList<Party> offenseSubjectsArrayList = new ArrayList(offenseSubjects);
            internalTesting != "true" ?: logger.debug("offensesAll:${offensesAll}; offenseUCRCode:${offenseUCRCode}; victimFilterXrefChargeVictim:${victimFilterXrefChargeVictim}; victim:${victim}");
            internalTesting != "true" ?: logger.debug("offenseSubjects: " + offenseSubjects.size());

            //throw new Exception("TESTING");
            if (offenseSubjects.isEmpty()){
                throw new Exception("OffenseSubjects failed validation; empty");
            }
            if (offenseVictims.isEmpty()){
                throw new Exception("OffenseVictims failed validation; empty");
            }
            //throw new Exception("TESTING");
            try{
                if (!Files.exists(rootDir?.toPath())){
                    rootDir.mkdir();
                }
                internalTesting != "true" ?: logger.debug("<nibrs:Submission>");
                fileWriter.println("""<nibrs:Submission xmlns:nibrs="http://fbi.gov/cjis/nibrs/4.2" xmlns:cjis="http://fbi.gov/cjis/1.0" xmlns:cjiscodes="http://fbi.gov/cjis/cjis-codes/1.0" xmlns:i="http://release.niem.gov/niem/appinfo/3.0/" xmlns:ucr="http://release.niem.gov/niem/codes/fbi_ucr/3.2/" xmlns:j="http://release.niem.gov/niem/domains/jxdm/5.2/" xmlns:term="http://release.niem.gov/niem/localTerminology/3.0/" xmlns:nc="http://release.niem.gov/niem/niem-core/3.0/" xmlns:niem-xsd="http://release.niem.gov/niem/proxy/xsd/3.0/" xmlns:s="http://release.niem.gov/niem/structures/3.0/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:nibrscodes="http://fbi.gov/cjis/nibrs/nibrs-codes/4.2" xmlns:msibrs="http://www.beyond2020.com/msibrs/1.0" xsi:schemaLocation="http://www.beyond2020.com/msibrs/1.0 ../base-xsd/msibrs/1.0/msibrs.xsd">""");

                fileWriter.println("<cjis:MessageMetadata>");
                //<!-- Message Timestamp -->
                fileWriter.println("<cjis:MessageDateTime>${localDateTime}</cjis:MessageDateTime>");
                //<!-- Message ID -->
                fileWriter.println("<cjis:MessageIdentification>");
                fileWriter.println("<nc:IdentificationID>${cse}-${offense}-${victim}</nc:IdentificationID>");
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
                fileWriter.println("<nc:IdentificationID>${offense.id}-${victim.id}</nc:IdentificationID>");
                fileWriter.println("</nc:ActivityIdentification>");
                fileWriter.println("<nc:ActivityDate>");
                //<!-- Element 3, Incident Date and Hour 2016-02-19T10:00:00 -->
                fileWriter.println("<nc:DateTime>${incidentDateTime}</nc:DateTime>");
                //<!-- Element 3, Incident Date if Hour is Unknown 2016-02-19 -->
                //<!-- <nc:Date>2016-02-19</nc:Date> -->
                fileWriter.println("</nc:ActivityDate>");
                fileWriter.println("<cjis:IncidentAugmentation>");
                //<!-- Element 3, IncidentReportDateIndicator is true to designate that the ActivityDate is the Report Date rather than the Incident Date -->
                fileWriter.println("<cjis:IncidentReportDateIndicator>${incidentReportDateIndicator}</cjis:IncidentReportDateIndicator>");
                // <!-- Element 2A, Cargo Theft Indicator: True/False-->

                internalTesting != "true" ?: logger.debug("TESTING: offenses:${getUCROffenses(relatedCharges)}: " + "disjoint: " + Collections.disjoint(getUCROffenses(relatedCharges),["BURGLARY-BREAKING_ENTERING"]));

                //getOffenseUCRCode(offense)


                if (Collections.disjoint(Arrays.asList("ROBBERY,EXTORTION-BLACKMAIL,BURGLARY-BREAKING_ENTERING,LARCENY-FROM_BUILDING,LARCENY-FROM_AUTO,LARCENY,MOTOR_VEHICLE_THEFT,FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME,FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE,FRAUD-IMPERSONATION,FRAUD-BY_WIRE,IDENTITY_THEFT,HACKING-COMPUTER_INVASION,BRIBERY,EMBEZZLEMENT".split(",")), getUCROffenses(relatedCharges)) == false){
                    fileWriter.println("<j:OffenseCargoTheftIndicator>true</j:OffenseCargoTheftIndicator>");
                }
                fileWriter.println("</cjis:IncidentAugmentation>");
                fileWriter.println("<j:IncidentAugmentation>");
                //<!-- Element 4, Cleared Exceptionally -->
                String incidentExceptionalClearanceCodeValue = offense.cf_indicentExceptionalClear != null && !offense.cf_indicentExceptionalClear.isEmpty() ? offense.cf_indicentExceptionalClear : incidentExceptionalClearanceCode[5];
                if (["JUSTIFIABLE_HOMICIDE"].contains(getOffenseUCRCode(offense))){
                    incidentExceptionalClearanceCodeValue = "N";
                }
                fileWriter.println("<j:IncidentExceptionalClearanceCode>${incidentExceptionalClearanceCodeValue}</j:IncidentExceptionalClearanceCode>");

                //internalTesting != "true" ?: logger.debug("OPTION:<j:IncidentExceptionalClearanceCode>${offense.cf_indicentExceptionalClear != null ? offense.cf_indicentExceptionalClear : incidentExceptionalClearanceCode[5]}");

                internalTesting != "true" ?: logger.debug("OPTION:<j:IncidentExceptionalClearanceCode>${incidentExceptionalClearanceCodeValue}");

                //<!-- Element 5, Exceptional Clearance Date -->
                if(incidentExceptionalClearanceCodeValue != "N" ){
                    //(offense.cf_indicentExceptionalClear != null && offense.cf_indicentExceptionalClear != "N" || incidentExceptionalClearanceCode[5] != "N"){
                    fileWriter.println("<j:IncidentExceptionalClearanceDate>");
                    fileWriter.println("<nc:Date>${incidentExceptionalClearanceDate}</nc:Date>");
                    fileWriter.println("</j:IncidentExceptionalClearanceDate>");
                }
                fileWriter.println("</j:IncidentAugmentation>");
                fileWriter.println("</nc:Incident>");
                //!it.collect("xrefs[entityType=='Charge' and refType=='REL'].ref").isEmpty()
                //loop through offenses for the day
                /*ArrayList<Charge> relatedCharges = new ArrayList<Charge>();
                relatedCharges.add(offense);
                relatedCharges.addAll(offense.collect("xrefs[entityType=='Charge' and refType=='REL'].ref"));
                internalTesting != "true" ?: logger.debug("filter 0: relatedCharges:${relatedCharges.size()}");*/

                /*if(!offense.collect("xrefs[entityType=='Charge' and refType=='REL'].ref").isEmpty()){
                //relatedCharges.addAll(offense.collect("xrefs[entityType=='Charge' and refType=='REL'].ref"));
                  relatedCharges.addAll(getRelatedChargesLimitedBySocietyOffensesCriteria(offense, offenseUCRCodeAreCrimesAgainsSocietyRequireVictimTypeS));
                }*/

                internalTesting != "true" ?: logger.debug("filter 1: relatedCharges:${relatedCharges.size()}");
                relatedCharges = getRelatedChargesLimitedByJustifiableHomicide(relatedCharges);
                internalTesting != "true" ?: logger.debug("filter 2: relatedCharges:${relatedCharges.size()}");
                relatedCharges = getRelatedChargesLimitedByAggravatedAssault(relatedCharges);
                internalTesting != "true" ?: logger.debug("filter 3: relatedCharges:${relatedCharges.size()}");
                relatedCharges = getRelatedChargesLimitedBySimpleAssault(relatedCharges);
                internalTesting != "true" ?: logger.debug("filter 4: relatedCharges:${relatedCharges.size()}");
                relatedCharges = getRelatedChargesLimitedByIntimidation(relatedCharges);
                internalTesting != "true" ?: logger.debug("filter 5: relatedCharges:${relatedCharges.size()}");
                relatedCharges = getRelatedChargeLimitedByUniqueOffenseUCRCode(relatedCharges);
                internalTesting != "true" ?: logger.debug("filter 6: relatedCharges:${relatedCharges.size()}");
                relatedCharges = getRelatedChargesLimitedByExcludingListCharges(relatedCharges, offenseUCRCodeAreCrimesAgainsSocietyRequireVictimTypeS);
                internalTesting != "true" ?: logger.debug("filter 7: relatedCharges:${relatedCharges.size()}");
                relatedCharges = getRelatedChargesLimitedByRobbery(relatedCharges);
                internalTesting != "true" ?: logger.debug("filter 8: relatedCharges:${relatedCharges.size()}");
                relatedCharges = getRelatedChargesLimitedByExcludingListCharges(relatedCharges, offenseUCRCodeRequiredWhenVictimTypeG);
                internalTesting != "true" ?: logger.debug("filter 9: relatedCharges:${relatedCharges.size()}");
                relatedCharges = getRelatedChargesLimit10(relatedCharges);

                internalTesting != "true" ?: logger.debug("filter 10: relatedCharges:${relatedCharges.size()}");
                relatedCharges.each({it -> internalTesting != "true" ?: logger.debug("each ucr: " + getOffenseUCRCode(it))})
                //throw new Exception("TESTING");


                for (relatedOffense in relatedCharges){
                    if(relatedOffense.updateReason != "NIBRS"){
                        relatedOffense.updateReason = "NIBRS";
                        relatedOffense.saveOrUpdate();
                    }
                    if (relatedOffense.cf_judicialDistrictCode == null || relatedOffense.cf_judicialDistrictCode != caseJudicialDistrictCode){
                        relatedOffense.cf_judicialDistrictCode = caseJudicialDistrictCode;
                        relatedOffense.saveOrUpdate();
                    }
                    fileWriter.println("<j:Offense s:id='" + "Offense${relatedOffense.id}" +  "'>");
                    //<!-- Element 6, Offense Code -->
                    String relatedOffenseUCRCode = getOffenseUCRCode(relatedOffense);
                    internalTesting != "true" ?: logger.debug("nibrs:OffenseUCRCode:${offensesMap.get(relatedOffenseUCRCode)}");
                    fileWriter.println("<nibrs:OffenseUCRCode>${offensesMap.get(relatedOffenseUCRCode)}</nibrs:OffenseUCRCode>");
                    //<!-- Element 12, Type Criminal Activity/Gang Information -->


                    criminalActivityCategoryCode = offenseUCRCodeRequiredWhenGangInformationCode.contains(relatedOffenseUCRCode) ? "N" : "";

                    criminalActivityCategoryCode = criminalActivityCategoryCode.isEmpty() && offenseUCRCodeRequiredWhenCriminalActivityOrGangInformationSubSet.contains(relatedOffenseUCRCode) ? criminalActivityCategoryCodesSubset[0] : criminalActivityCategoryCode;

                    criminalActivityCategoryCode = offenseUCRCodeRequiredWhenCriminalActivityOrGangInformationSubSetAnimalsCruelty.contains(relatedOffenseUCRCode) ? criminalActivityCategoryCodesSubsetAnimalsCruelty[0]: criminalActivityCategoryCode;

                    criminalActivityCategoryCode = criminalActivityCategoryCode.isEmpty() && offenseUCRCodeRequiredWhenCriminalActivityOrGangInformationPresent.contains(relatedOffenseUCRCode) ? "A" : criminalActivityCategoryCode;

                    criminalActivityCategoryCode = relatedOffenseUCRCode == weaponsOfMassDestruction ? "T" : criminalActivityCategoryCode;
                    //internalTesting != "true" ?: logger.debug("criminalActivityCategoryCode:${criminalActivityCategoryCode}");
                    //internalTesting != "true" ?: logger.debug("condition: !criminalActivityCategoryCode.isEmpty():${!criminalActivityCategoryCode.isEmpty()}; contains:${offenseUCRCodeRequiredWhenCriminalActivityOrGangInformationPresent.contains(offenseUCRCode)}");
                    //if (!criminalActivityCategoryCode.isEmpty() && offenseUCRCodeRequiredWhenCriminalActivityOrGangInformationPresent.contains(relatedOffenseUCRCode)){
                    if (!criminalActivityCategoryCode.isEmpty() && Collections.disjoint( offenseUCRCodeRequiredWhenCriminalActivityOrGangInformationPresent, getUCROffenses(relatedCharges)) == false){
                        internalTesting != "true" ?: logger.debug("OPTION:<nibrs:CriminalActivityCategoryCode>${relatedOffense.cf_criminalActivityCategory != null ? relatedOffense.cf_criminalActivityCategory :criminalActivityCategoryCode}");
                        fileWriter.println("<nibrs:CriminalActivityCategoryCode>${relatedOffense.cf_criminalActivityCategory != null ? relatedOffense.cf_criminalActivityCategory :criminalActivityCategoryCode}</nibrs:CriminalActivityCategoryCode>");
                    }
                    //<!-- Element 8A, Bias Motivation -->
                    fileWriter.println("<j:OffenseFactorBiasMotivationCode>${relatedOffense.cf_offenseFactorBiasMotiv != null ? relatedOffense.cf_offenseFactorBiasMotiv : offenseFactorBiasMotivationCode}</j:OffenseFactorBiasMotivationCode>");
                    internalTesting != "true" ?: logger.debug("OPTION:<j:OffenseFactorBiasMotivationCode>${relatedOffense.cf_offenseFactorBiasMotiv != null ? relatedOffense.cf_offenseFactorBiasMotiv : offenseFactorBiasMotivationCode}");
                    //<!-- Element 8, Offender(s) Suspected Of Using -->
                    fileWriter.println("<j:OffenseFactor>");
                    fileWriter.println("<j:OffenseFactorCode>${relatedOffense.cf_offenseFactor != null ? relatedOffense.cf_offenseFactor : offenseFactorCode}</j:OffenseFactorCode>");
                    internalTesting != "true" ?: logger.debug("OPTION:<j:OffenseFactorCode>${relatedOffense.cf_offenseFactor != null ? relatedOffense.cf_offenseFactor : offenseFactorCode}");
                    fileWriter.println("</j:OffenseFactor>");
                    if (offenseUCRCodeAreRequireForce.contains(relatedOffenseUCRCode)){
                        //<!-- Element 11, Method Of Entry -->
                        fileWriter.println("<j:OffenseEntryPoint>");
                        fileWriter.println("<j:PassagePointMethodCode>${relatedOffense.cf_passagePointMethod != null ? relatedOffense.cf_passagePointMethod : passagePointMethodCode[1]}</j:PassagePointMethodCode>");
                        internalTesting != "true" ?: logger.debug("OPTION:<j:PassagePointMethodCode>${relatedOffense.cf_passagePointMethod != null ? relatedOffense.cf_passagePointMethod : passagePointMethodCode[1]}");
                        fileWriter.println("</j:OffenseEntryPoint>");
                    }
                    //<!-- Element 13, Type Weapon/Force Involved -->
                    if (offenseUCRCodeRequiredWhenForceCategoryPresent.contains(relatedOffenseUCRCode)){
                        String forceCategoryCode = offenseUCRCodeRequiredWhenFireArmsWeapons.contains(relatedOffenseUCRCode) ? "11" : "";

                        forceCategoryCode = offenseUCRCodeRequiredWhenNonFireArmsWeapons.contains(relatedOffenseUCRCode) ? "40" : forceCategoryCode;

                        forceCategoryCode = forceCategoryCode == "" ? "99" : forceCategoryCode;

                        forceCategoryCode = offenseUCRCodeRequiredWhenWeaponInvolved.contains(relatedOffenseUCRCode) ? "95" : forceCategoryCode;

                        fileWriter.println("<j:OffenseForce>");
                        fileWriter.println("<j:ForceCategoryCode>${relatedOffense.cf_forceCategory != null ? relatedOffense.cf_forceCategory : forceCategoryCode}</j:ForceCategoryCode>");
                        internalTesting != "true" ?: logger.debug("OPTION:<j:ForceCategoryCode>${relatedOffense.cf_forceCategory != null ? relatedOffense.cf_forceCategory : forceCategoryCode}");
                        fileWriter.println("</j:OffenseForce>");
                    }
                    //<!-- Element 7, Attempted/Completed -->
                    /* if(offense.cf_itemStatus != null && !offenseAttemptedIndicatorReqFalse.contains(offense.cf_itemStatus)){
                       offenseAttemptedIndicator = true;
                     }*/
                    internalTesting != "true" ?: logger.debug("Attempt on offense relatedOffense.inchoateType: ${relatedOffense.inchoateType}; offense:${relatedOffenseUCRCode}");
                    offenseAttemptedIndicator = isAttempted(relatedOffense) ? true : offenseAttemptedIndicator;
                    internalTesting != "true" ?: logger.debug("Attempt on offense offenseAttemptedIndicator: ${isAttempted(relatedOffense)}; offense:${relatedOffenseUCRCode}");
                    fileWriter.println("<j:OffenseAttemptedIndicator>${isAttempted(relatedOffense)}</j:OffenseAttemptedIndicator>");
                    fileWriter.println("</j:Offense>");
                }

                //loop through offenses for offense location
                //for (offense in offenses){
                //<!-- Element 9, Location Type -->
                fileWriter.println("<nc:Location s:id='" + "Location${offense.id}" + "'>");
                fileWriter.println("<nibrs:LocationCategoryCode>${offense.cf_locationCategory != null ? offense.cf_locationCategory : locationCategoryCode}</nibrs:LocationCategoryCode>");
                internalTesting != "true" ?: logger.debug("OPTION:<nibrs:LocationCategoryCode>${offense.cf_locationCategory != null ? offense.cf_locationCategory : locationCategoryCode}");
                /*fileWriter.println("<nc:LocationLocale>");
                    fileWriter.println("<cjis:JudicialDistrictCode>${caseJudicialDistrictCode != null ? caseJudicialDistrictCode : judicialDistrictCode[0]}</cjis:JudicialDistrictCode>");
      internalTesting != "true" ?: logger.debug("OPTION:<cjis:JudicialDistrictCode>${caseJudicialDistrictCode != null ? caseJudicialDistrictCode : judicialDistrictCode[0]}");
                fileWriter.println("</nc:LocationLocale>");*/
                fileWriter.println("</nc:Location>");
                //}

                relatedCharges.each({it ->
                    internalTesting != "true" ?: logger.debug("loop related charges: UCR:${getOffenseUCRCode(it)}; itemStatus:" + getItemStatus(it));
                });

                /*internalTesting != "true" ?: logger.debug("getChargeListUniqueByItemStatus: " + getChargeListUniqueByItemStatus(relatedCharges.findAll({it -> offenseUCRCodeRequiresProperty.contains(getOffenseUCRCode(it))})).size());
              for (relatedOffense in getChargeListUniqueByItemStatus(relatedCharges.findAll({it -> offenseUCRCodeRequiresProperty.contains(getOffenseUCRCode(it))}))){
                internalTesting != "true" ?: logger.debug("inside loop: offenseUCRCodeRelatedOffense:${getOffenseUCRCode(relatedOffense)}");
              }
                throw new Exception("testing")*/

                //for (relatedOffense in getChargeListUniqueByItemStatus(relatedCharges.findAll({it -> offenseUCRCodeRequiresProperty.contains(getOffenseUCRCode(it))}))){
                 for (relatedOffense in relatedCharges){
                    internalTesting != "true" ?: logger.debug("inside loop: " + getItemStatus(relatedOffense));
                    String offenseUCRCodeRelatedOffense = getOffenseUCRCode(relatedOffense);
                    internalTesting != "true" ?: logger.debug("offenseUCRCodeRelatedOffense:${getOffenseUCRCode(relatedOffense)}");

                    //<!-- Begin Property -->
                    internalTesting != "true" ?: logger.debug("ITEM: offense:${offenseUCRCodeRelatedOffense} contiditons:1:${offenseUCRCodeRequiresProperty.contains(getOffenseUCRCode(relatedOffense))}; 2:${offenseUCRCodeRequiredWhenPropertyNoneSeized.contains(getOffenseUCRCode(relatedOffense))}");
                    //throw new Exception("TESTING");
                    if (offenseUCRCodeRequiresProperty.contains(getOffenseUCRCode(relatedOffense)) || offenseUCRCodeRequiredWhenPropertyNoneSeized.contains(getOffenseUCRCode(relatedOffense))){
                        fileWriter.println("<nc:Item>");
                        //<!-- Element 14, Type Property Loss/etc  -->

                        internalTesting != "true" ?: logger.debug("property: offenseUCRCodeRelatedOffense:${offenseUCRCodeRelatedOffense}; attempted:${relatedOffense.inchoateType}");
                        //fileWriter.println("<nc:ItemStatus>");
                        fileWriter.println("<nc:ItemStatus s:id='" + "ItemStatus${relatedOffense.id}" +  "'>");
                        //fileWriter.println("<cjis:ItemStatusCode>${offense.cf_itemStatus != null && offense.inchoateType != "ATTEMPT" ? offense.cf_itemStatus : itemStatusCode}</cjis:ItemStatusCode>");
                        //internalTesting != "true" ?: logger.debug("OPTION:<cjis:ItemStatusCode>${offense.cf_itemStatus != null ? offense.cf_itemStatus : itemStatusCode}");
                        fileWriter.println("<cjis:ItemStatusCode>${getItemStatus(relatedOffense)}</cjis:ItemStatusCode>");
                        internalTesting != "true" ?: logger.debug("OPTION:<cjis:ItemStatusCode>${getItemStatus(relatedOffense)}");
                        fileWriter.println("</nc:ItemStatus>");

                        itemCategoryNIBRSPropertyCategoryCode = relatedOffense.cf_itemCategory != null ? relatedOffense.cf_itemCategory : itemCategoryNIBRSPropertyCategoryCode;
                        if (getItemStatus(relatedOffense) != "NONE" && !isAttempted(relatedOffense)){
                            //<!-- Element 16, Value of Property in US Dollars -->
                            internalTesting != "true" ?: logger.debug("ItemDescription condition is true")
                            if (!Arrays.asList("09,22,48,65,66".split(",")).contains(itemCategoryNIBRSPropertyCategoryCode)){
                                fileWriter.println("<nc:ItemValue>");
                                fileWriter.println("<nc:ItemValueAmount>");
                                fileWriter.println("<nc:Amount>${relatedOffense.cf_itemValue !=  null ? relatedOffense.cf_itemValue : itemValueAmount}</nc:Amount>");
                                fileWriter.println("</nc:ItemValueAmount>");
                                fileWriter.println("</nc:ItemValue>");
                            }
                            //<!-- Element 15, Property Description -->
                            fileWriter.println("<j:ItemCategoryNIBRSPropertyCategoryCode>${itemCategoryNIBRSPropertyCategoryCode}</j:ItemCategoryNIBRSPropertyCategoryCode>");
                            internalTesting != "true" ?: logger.debug("OPTION:<j:ItemCategoryNIBRSPropertyCategoryCode>${itemCategoryNIBRSPropertyCategoryCode}");
                            //<!-- Element 18, Number of Stolen Motor Vehicles, if Status is Stolen -->
                            fileWriter.println("<nc:ItemQuantity>${getItemQuantity(relatedOffense)}</nc:ItemQuantity>");
                        }
                        fileWriter.println("</nc:Item>");
                    }
                }


/*
		fileWriter.println("<nc:Substance>");
			fileWriter.println("<nc:ItemStatus>");
				fileWriter.println("<cjis:ItemStatusCode>SEIZED</cjis:ItemStatusCode>");
			fileWriter.println("</nc:ItemStatus>");
			//<!-- Element 15, Property Description -->
			fileWriter.println("<j:ItemCategoryNIBRSPropertyCategoryCode>10</j:ItemCategoryNIBRSPropertyCategoryCode>");
			//<!-- Element 20, Suspected Involved Drug Type -->
			fileWriter.println("<j:DrugCategoryCode>H</j:DrugCategoryCode>");
			fileWriter.println("<nc:SubstanceQuantityMeasure>");
				//<!-- Element 21/22, Estimated Quantity/Fraction -->
				fileWriter.println("<nc:MeasureDecimalValue>1.5</nc:MeasureDecimalValue>");
				fileWriter.println("<j:SubstanceUnitCode>GM</j:SubstanceUnitCode>");
			fileWriter.println("</nc:SubstanceQuantityMeasure>");
		fileWriter.println("</nc:Substance>");
  //<!--End Property--> ${}
  */

                //for (victim in offenseVictims){
                //offense = getVictimsXrefOffenses(victim, chargeFilterXrefVictimCharge).find({it -> offenseUCRCodeAreCrimesAgainsSocietyRequireVictimTypeS.contains(it) || it.statute != null});
                fileWriter.println("<nc:Person s:id='" + "PersonVictim${victim.id}" + "'>");
                internalTesting != "true" ?: logger.debug("contains crimeAgainsSociety: " + offenseUCRCodeAreCrimesAgainsSocietyRequireVictimTypeS.contains(getOffenseUCRCode(relatedCharges.first())))
                if (/*victimCategoryCodesRequireDemographics.contains(getVictimCategoryCode(offenseUCRCodeAreCrimesAgainsSocietyRequireVictimTypeS, victim, offense, offenseUCRCodeRequiredWhenVictimTypeIsG))*/
                        offenseUCRCodeAreCrimesAgainsSocietyRequireVictimTypeS.contains(getOffenseUCRCode(relatedCharges.first())) == false
                                &&
                                offenseUCRCodeRequiredWhenVictimTypeG.contains(getOffenseUCRCode(relatedCharges.first())) == false
                ){
                    internalTesting != "true" ?: logger.debug("Person Demographics");
                    //internalTesting != "true" ?: logger.debug("subject info: ${victim} ${victim.title} age: ${getAge(victim)} gender: ${getGenderCode(victim)} eth: ${getEthnicity(victim)}");
                    //throw new Exception("TESTING");
                    //<!-- Element 26, Age of Victim (only one would be included per victim)-->
                    fileWriter.println("<nc:PersonAgeMeasure>");
                    if (getAge(victim) != null){
                        fileWriter.println("<nc:MeasureIntegerValue>${getAge(victim)}</nc:MeasureIntegerValue>");
                    } else {
                        fileWriter.println("<nc:MeasureIntegerRange>");
                        fileWriter.println("<nc:RangeMaximumIntegerValue>${maxAgeRange}</nc:RangeMaximumIntegerValue>");
                        fileWriter.println("<nc:RangeMinimumIntegerValue>${minAgeRange}</nc:RangeMinimumIntegerValue>");
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
                //}

                offenseSubjects.each({it -> internalTesting != "true" ?: logger.debug("offenseSubject:${it}")});

                for (subject in offenseSubjects){
                    fileWriter.println("<nc:Person s:id='" + "PersonSubject${subject.id}" + "'>");


                    //<!-- Element 37, Age of Subject (only one would be included per subject) -->
                    fileWriter.println("<nc:PersonAgeMeasure>");

                    //internalTesting != "true" ?: logger.debug("subject info: ${subject} ${subject.title} age: ${getAge(subject)} gender: ${getGenderCode(subject)} eth: ${getEthnicity(subject)}");

                    if (getAge(subject) != null){
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


                //for (victim in offenseVictims){
                //offense = getVictimsXrefOffenses(victim, chargeFilterXrefVictimCharge).find({charge -> charge.id != null});
                fileWriter.println("<j:Victim s:id='" + "Victim${victim.id}" + "'>");
                fileWriter.println("<nc:RoleOfPerson s:ref='" + "PersonVictim${victim.id}" + "'/>");
                //<!-- Element 23, Victim Sequence Number -->
                fileWriter.println("<j:VictimSequenceNumberText>${offenseVictimsArrayList.indexOf(victim) +1}</j:VictimSequenceNumberText>");
                if (["100", "11A", "11B", "11C", "11D", "120", "13A", "13B", "210", "64A", "64B"].contains(offensesMap.get(getOffenseUCRCode(offense)))){
                    //  <!-- Element 33, Type Injury -->
                    fileWriter.println("<j:VictimInjury>");
                    fileWriter.println("<j:InjuryCategoryCode>N</j:InjuryCategoryCode>");
                    fileWriter.println("</j:VictimInjury>");
                }
                //<!-- Element 25, Type of Victim -->
                //String victimCategoryCode = getVictimCategoryCode(offenseUCRCodeAreCrimesAgainsSocietyRequireVictimTypeS, victim, offenses, offenseUCRCodeRequiredWhenVictimTypeIsG);

                String victimCategoryCode = offenseUCRCodeAreCrimesAgainsSocietyRequireVictimTypeS.contains(getOffenseUCRCode(relatedCharges.first())) == false ? "I" : "S";

                victimCategoryCode = offenseUCRCodeRequiredWhenVictimTypeG.contains(getOffenseUCRCode(relatedCharges.first())) == true ? "G" : victimCategoryCode;

                fileWriter.println("<j:VictimCategoryCode>${victimCategoryCode}</j:VictimCategoryCode>");
                if (["09A","09B","09C","13A"].contains(offensesMap.get(getOffenseUCRCode(offense)))){
                    String victimAggravatedAssaultHomicideFactorCode = "";
                    if (["09A", "13A"].contains(offensesMap.get(getOffenseUCRCode(offense)))){
                        victimAggravatedAssaultHomicideFactorCode = "10";
                    } else if (["09B"].contains(offensesMap.get(getOffenseUCRCode(offense)))){
                        victimAggravatedAssaultHomicideFactorCode = "34";
                    } else if (["09C"].contains(offensesMap.get(getOffenseUCRCode(offense)))){
                        victimAggravatedAssaultHomicideFactorCode = "20";
                    } else {
                        victimAggravatedAssaultHomicideFactorCode = "";
                    }
                    if (!victimAggravatedAssaultHomicideFactorCode.isEmpty()){
                        //<!-- Element 31, Aggravated Assault/Homicide Circumstances -->
                        fileWriter.println("<j:VictimAggravatedAssaultHomicideFactorCode>${victimAggravatedAssaultHomicideFactorCode}</j:VictimAggravatedAssaultHomicideFactorCode>");
                    }
                }
                if (["09C"].contains(offensesMap.get(getOffenseUCRCode(offense)))){
                    String victimJustifiableHomicideFactorCode = "C";
                    //<!-- Element 32, Additional Justifiable Homicide Circumstances -->
                    fileWriter.println("<j:VictimJustifiableHomicideFactorCode>${victimJustifiableHomicideFactorCode}</j:VictimJustifiableHomicideFactorCode>");
                }
                fileWriter.println("</j:Victim>");
                //}

                for (subject in offenseSubjects){
                    fileWriter.println("<j:Subject s:id='" + "Subject${subject.id}" + "'>");
                    fileWriter.println("<nc:RoleOfPerson s:ref='" + "PersonSubject${subject.id}" + "'/>");
                    //<!-- Element 36, Offender Sequence Number -->
                    fileWriter.println("<j:SubjectSequenceNumberText>${offenseSubjectsArrayList.indexOf(subject) +1}</j:SubjectSequenceNumberText>");
                    fileWriter.println("</j:Subject>");
                }

                //<!-- Associations  -->

                //<!-- Offense Location Association -->
                for (relatedOffense in relatedCharges){
                    fileWriter.println("<j:OffenseLocationAssociation>");
                    fileWriter.println("<j:Offense s:ref='" + "Offense${relatedOffense.id}" + "'/>");
                    fileWriter.println("<nc:Location s:ref='" + "Location${offense.id}" + "'/>");
                    fileWriter.println("</j:OffenseLocationAssociation>");
                }

                //<!-- Element 24, Victim Connected to UCR Offense Code -->
                for (relatedOffense in relatedCharges){
                    //for (victim in offense.collect(victimFilterXrefChargeVictim)){
                    fileWriter.println("<j:OffenseVictimAssociation>");
                    fileWriter.println("<j:Offense s:ref='" + "Offense${relatedOffense.id}" + "'/>");
                    fileWriter.println("<j:Victim s:ref='" + "Victim${victim.id}" + "'/>");
                    fileWriter.println("</j:OffenseVictimAssociation>");
                    //}
                }

                //<!--Element 34, Offender Number(s) to be related -->

                for (subject in offenseSubjects){
                    //if (victimCategoryCodesRequireDemographics.contains(getVictimCategoryCode(offenseUCRCodeAreCrimesAgainsSocietyRequireVictimTypeS, victim, offense, offenseUCRCodeRequiredWhenVictimTypeIsG))){
                    internalTesting != "true" ?: logger.debug("Check victimCategoryCode:${victimCategoryCode}")
                    if (victimCategoryCode == "I"){
                        fileWriter.println("<j:SubjectVictimAssociation s:id='" + "SubjectVictimAssocSP${subject.id}${victim.id}" + "'>");
                        fileWriter.println("<j:Subject s:ref='" + "Subject${subject.id}" + "'/>");
                        fileWriter.println("<j:Victim s:ref='" + "Victim${victim.id}" + "'/>");
                        //<!-- Element 35, Relationship(s) of Victim To Offender -->
                        String victimToSubjectRelationshipCode = "Acquaintance";
                        if (getOffenseUCRCode(offense) == "INCEST"){
                            victimToSubjectRelationshipCode = "Family Member";
                        }
                        fileWriter.println("<nibrs:VictimToSubjectRelationshipCode>${victimToSubjectRelationshipCode}</nibrs:VictimToSubjectRelationshipCode>");
                        fileWriter.println("</j:SubjectVictimAssociation>");
                    }
                    //}
                }

                // testing
                /*
                  for (relatedOffense in relatedCharges){
                    relatedVictims = relatedOffense.collect(victimFilterXrefChargeVictim);
                    for (relatedVictims in relatedVictims){
                    if (victimCategoryCodesRequireDemographics.contains(getVictimCategoryCode(offenseUCRCodeAreCrimesAgainsSocietyRequireVictimTypeS, relatedVictims, relatedOffense, offenseUCRCodeRequiredWhenVictimTypeIsG))){
                    fileWriter.println("<j:SubjectVictimAssociation s:id='" + "SubjectVictimAssocSP${relatedOffense.associatedParty.id}${relatedVictims.id}" + "'>");
                          fileWriter.println("<j:Subject s:ref='" + "Subject${relatedOffense.associatedParty.id}" + "'/>");
                          fileWriter.println("<j:Victim s:ref='" + "Victim${relatedVictims.id}" + "'/>");
                          //<!-- Element 35, Relationship(s) of Victim To Offender -->
                          fileWriter.println("<nibrs:VictimToSubjectRelationshipCode>Acquaintance</nibrs:VictimToSubjectRelationshipCode>");
                      fileWriter.println("</j:SubjectVictimAssociation>");
                    }
                  }
                }
                */



                fileWriter.println("</nibrs:Report>");
                fileWriter.println("</nibrs:Submission>");
                internalTesting != "true" ?: logger.debug("</nibrs:Submission>");
                fileWriter.flush();
                fileWriter.close();

                attachmentFiles = new ArrayList<>(Arrays.asList(reportFile)).toArray(File[]);
                attachments = new Attachments(attachmentFiles);

                if (_saveReportToCase == true){
                    internalTesting != "true" ?: logger.debug("createDocument: ${reportFile}; ${cse} ${offenses}");
                    Document reportDoc = createDocument(reportFile, cse, offenses);
                    internalTesting != "true" ?: logger.debug("addDocumentToDocuments: ${cse} ${reportDoc}");
                    addDocumentToDocuments(cse, reportDoc);
                }

                if (_sendEmail == true){
                    mailManager.sendMailToAll(toEmails, ccEmails, bccEmails, emailSubject, emailBody, attachments);
                }
                _fileOut = reportFile;
                Files.deleteIfExists(reportPath);
            } catch (Exception ex){
                internalTesting != "true" ?: logger.debug("ex: ${ex.getMessage()}");
            }
        }
    }

}
/*************************************************************************************************************************/
/*
for (f in new File(rootPath).listFiles()){
  internalTesting != "true" ?: logger.debug(f.toString());
  Files.deleteIfExists(f.toPath());
}
*/


protected String getOffenseUCRCode(Charge offense){
    String code = offense.collect("chargeAttributes").find({it -> it != null});
    return code != null ? code?.trim() : "";
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

/*protected ArrayList<Party> getOffenseSubjects(ArrayList<Charge> offensesAll, String ucrOffense, String victimFilterXrefChargeVictim, Party ucrVictim){
  ArrayList<Party> ucrOffenseSubjects = new ArrayList();
  offensesAll.findAll({offense -> getOffenseUCRCode(offense) == ucrOffense && offense.collect(victimFilterXrefChargeVictim).findAll({thisVictim -> thisVictim == ucrVictim})})?.each({offense -> ucrOffenseSubjects.add(offense.associatedParty)});
  return ucrOffenseSubjects?.unique({party -> party});
}*/
protected ArrayList<Party> getOffenseSubjects(Charge offense){
    ArrayList<Party> ucrOffenseSubjects = new ArrayList();
    ucrOffenseSubjects.add(offense.associatedParty);
    return ucrOffenseSubjects;
}

protected ArrayList<Party> getOffenseSubjectVictims(ArrayList<Charge> offensesAll, String ucrOffense, String victimFilterXrefChargeVictim){
    ArrayList<Party> ucrOffenseVictims = new ArrayList();
    offensesAll.findAll({offense -> getOffenseUCRCode(offense) == ucrOffense})?.each({offense -> ucrOffenseVictims.addAll(offense.collect(victimFilterXrefChargeVictim))});
    return ucrOffenseVictims;
}

protected Integer getAge(Party party){
    def age = party.person.collect("profiles[dateOfBirth != null].age").find({it -> it != null});
    return age;
}

protected String getGenderCode(Party party, Charge thisOffense){
    def gender = party.person.collect("profiles[gender != null].gender").find({it -> it != null});
    if ((gender == null || !["MALE","FEMALE"].contains(gender)) && isExceptionalClearanceAtoE(thisOffense) == false){
        gender = "U";
    } else if (gender == "FEMALE") {
        gender = "F";
    } else {
        gender = "M";
    }
    return gender;
}

protected String getEthnicity(Party party, Charge thisOffense){
    def ethnicity = party.person.collect("profiles[ethnicity != null].ethnicity").find({it -> it != null});
    if (ethnicity == null && isExceptionalClearanceAtoE(thisOffense) == false){
        ethnicity = "U";
    } else if ( ethnicity == "HISPANIC"){
        ethnicity = "H";
    } else {
        ethnicity = "N";
    }
    return ethnicity;
}

protected String getRace(Party party, Charge thisOffense){
    def race = party.person.collect("profiles[ethnicity != null].ethnicity").find({it -> it != null});
    if (isExceptionalClearanceAtoE(thisOffense) == false && (race == null || !["WHITE","BLACK","AMERICANINDIAN","ASIAN","NATIVEHAWAIIAN"].contains(race))){
        race = "U";
    } else if ( race == "BLACK"){
        race = "B";
    } else if ( race == "AMERICANINDIAN"){
        race = "I";
    } else if ( race == "ASIAN"){
        race = "A";
    } else if ( race == "NATIVEHAWAIIAN"){
        race = "P";
    } else {
        race = "W";
    }
    return race;
}

protected String getItemStatus(Charge thisOffense){
    String itemStatus = thisOffense.cf_itemStatus == null || isAttempted(thisOffense) ? "NONE" : thisOffense.cf_itemStatus;
    //itemStatus = "ROBBERY" == getOffenseUCRCode(thisOffense) && isAttempted(thisOffense) ? "RECOVERED" : thisOffense.cf_itemStatus;
    //itemStatus = "ROBBERY" == getOffenseUCRCode(thisOffense) && !isAttempted(thisOffense) ? "STOLEN" : thisOffense.cf_itemStatus;

    if (Arrays.asList("BRIBERY,BURGLARY-BREAKING_ENTERING,KIDNAPPING-ABDUCTION,ROBBERY".split(",")).contains(getOffenseUCRCode(thisOffense))){
        //Item Status Code must be NONE, RECOVERED, STOLEN or UNKNOWN
        itemStatus = isAttempted(thisOffense) ? "NONE" : "STOLEN";
    }

    if (Arrays.asList("COUNTERFEIT-FORGERY,EXPORT_VIOLATIONS".split(",")).contains(getOffenseUCRCode(thisOffense))){
        itemStatus = isAttempted(thisOffense) ? "NONE" : "COUNTERFEITED";
    }

    if (Arrays.asList("DAMAGE-DESTRUCTION-VANDALISM_OF_PROPERTY".split(",")).contains(getOffenseUCRCode(thisOffense))){
        itemStatus = isAttempted(thisOffense) ? "NONE" : "DESTROYED_DAMAGED_VANDALIZED";
    }

    if (Arrays.asList("EMBEZZLEMENT,EXTORTION-BLACKMAIL,FRAUD-BY_WIRE,FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE,FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME,FRAUD-IMPERSONATION,FRAUD-WELFARE_FRAUD,HACKING-COMPUTER_INVASION,IDENTITY_THEFT LARCENY,LARCENY-FROM_AUTO LARCENY-FROM_BUILDING,LARCENY-FROM_COIN_OPERATED_MACHINE,LARCENY-PARTS_FROM_VEHICLE,MONEY_LAUNDERING,MOTOR_VEHICLE_THEFT,POCKET_PICKING,PURSE_SNATCHING,ROBBERY,SHOPLIFTING".split(",")).contains(getOffenseUCRCode(thisOffense))){
        //Offense Attempted = 'false' then the Item Status Code (Property Loss Type) must be RECOVERED or STOLEN
        itemStatus = isAttempted(thisOffense) ? "NONE" : "STOLEN";
    }

    if (Arrays.asList("EMBEZZLEMENT,EXTORTION-BLACKMAIL,FRAUD-BY_WIRE,FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE,FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME,FRAUD-IMPERSONATION,FRAUD-WELFARE_FRAUD,HACKING-COMPUTER_INVASION IDENTITY_THEFT,LARCENY,LARCENY-FROM_AUTO,LARCENY-FROM_BUILDING,LARCENY-FROM_COIN_OPERATED_MACHINE,LARCENY-PARTS_FROM_VEHICLE,MONEY_LAUNDERING,MOTOR_VEHICLE_THEFT,POCKET_PICKING,PURSE_SNATCHING,ROBBERY,SHOPLIFTING".split(",")).contains(getOffenseUCRCode(thisOffense))){
        //Offense Attempted = 'false' then the Item Status Code (Property Loss Type) must be RECOVERED or STOLEN
        itemStatus = isAttempted(thisOffense) ? "NONE" : "STOLEN";
    }

    if (!isAttempted(thisOffense) && Arrays.asList("BETTING-WAGERING,GAMBLING-OPERATING_PROMOTING_ASSISTING,GAMBLING-EQUIPMENT_VIOLATION,SPORTS_TAMPERING".split(",")).contains(getOffenseUCRCode(thisOffense))){
        itemStatus = isAttempted(thisOffense) ? "NONE" : "SEIZED";
    }

    // Offense Attempted = 'false' then the Item Status Code (Property Loss Type) must be NONE, RECOVERED, STOLEN or UNKNOWN
    if (Arrays.asList("BRIBERY,BURGLARY-BREAKING_ENTERING,KIDNAPPING-ABDUCTION".split(",")).contains(getOffenseUCRCode(thisOffense))){
        itemStatus = isAttempted(thisOffense) ? "NONE" : "STOLEN";
    }

    //Offense Attempted = 'false' then the Item Status Code (Property Loss Type) must be RECOVERED or STOLEN
    if (Arrays.asList("EMBEZZLEMENT,EXTORTION-BLACKMAIL,FRAUD-BY_WIRE,FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE,FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME,FRAUD-IMPERSONATION,FRAUD-WELFARE_FRAUD,HACKING-COMPUTER_INVASION,IDENTITY_THEFT,LARCENY,LARCENY-FROM_AUTO,LARCENY-FROM_BUILDING,LARCENY-FROM_COIN_OPERATED_MACHINE,LARCENY-PARTS_FROM_VEHICLE,MONEY_LAUNDERING,MOTOR_VEHICLE_THEFT,POCKET_PICKING,PURSE_SNATCHING,ROBBERY SHOPLIFTING".split(",")).contains(getOffenseUCRCode(thisOffense))){
        itemStatus = isAttempted(thisOffense) ? "NONE" : "STOLEN";
    }

    //itemStatus = itemStatus == null ? "NONE" : itemStatus;
    return itemStatus;
}

protected ArrayList<Charge> getChargeListUniqueByItemStatus(ArrayList<Charge> thisChargeList){
    ArrayList<Charge> newChargeList = new ArrayList();
    newChargeList.addAll(thisChargeList);
    return newChargeList.unique({it -> getItemStatus(it)});
}

protected boolean isAttempted(Charge thisOffense){
    boolean isAttempt = false;
    if (thisOffense.inchoateType == null || thisOffense.inchoateType != "ATTEMPT"){
        isAttempt = false;
    } else {
        isAttempt = true;
    }
    return isAttempt;
}

protected List<Charge> getRelatedChargesLimitedBySocietyOffensesCriteria(Charge thisOffense, ArrayList<String> offenseUCRCodeAreCrimesAgainsSocietyRequireVictimTypeS){
    ArrayList<Charge> limitedRelatedCharges = new ArrayList();
    if (offenseUCRCodeAreCrimesAgainsSocietyRequireVictimTypeS.contains(getOffenseUCRCode(thisOffense))){
        return limitedRelatedCharges;
    } else {
        limitedRelatedCharges.addAll(thisOffense.collect("xrefs[entityType=='Charge' and refType=='REL'].ref").findAll({it -> !offenseUCRCodeAreCrimesAgainsSocietyRequireVictimTypeS.contains(getOffenseUCRCode(it))}));
        return limitedRelatedCharges;
    }
}

protected List<Charge> getRelatedChargesLimitedByJustifiableHomicide(ArrayList<Charge> theseCharges){
    ArrayList<Charge> theseChargesFiltered = new ArrayList();
    Charge justifiableCharge = theseCharges.find({it -> getOffenseUCRCode(it) == "JUSTIFIABLE_HOMICIDE"});
    if (justifiableCharge != null){
        theseChargesFiltered.add(justifiableCharge);
        return theseChargesFiltered;
    } else{
        return theseCharges;
    }
}

protected List<Charge> getRelatedChargesLimitedByAggravatedAssault(ArrayList<Charge> theseCharges){
    ArrayList<Charge> theseChargesFiltered = new ArrayList();
    ArrayList<String> restrictedCharges = Arrays.asList("ASSAULT-SIMPLE,FONDLING,INTIMIDATION,MANSLAUGHTER_NEGLIGENT,MANSLAUGHTER_NONNEGLIGENT-MURDER,RAPE,ROBBERY,SEX_ASSAULT-OBJECT,SODOMY".split(","));
    Charge testCharge = theseCharges.find({it -> getOffenseUCRCode(it) == "AGGRAVATED_ASSAULT"});
    if (testCharge != null && !theseCharges.findAll({it -> restrictedCharges.contains(getOffenseUCRCode(it))}).isEmpty()){
        theseChargesFiltered.add(testCharge);
        theseChargesFiltered.addAll(theseCharges.findAll({it -> !restrictedCharges.contains(getOffenseUCRCode(it))}));
        return theseChargesFiltered;
    } else{
        return theseCharges;
    }
}

///
protected List<Charge> getRelatedChargesLimitedByRobbery(ArrayList<Charge> theseCharges){
    ArrayList<Charge> theseChargesFiltered = new ArrayList();
    ArrayList<String> restrictedCharges = Arrays.asList("LARCENY,LARCENY-FROM_AUTO,LARCENY-FROM_BUILDING,LARCENY-FROM_COIN_OPERATED_MACHINE,LARCENY-PARTS_FROM_VEHICLE,MOTOR_VEHICLE_THEFT,POCKET_PICKING,PURSE_SNATCHING,SHOPLIFTING".split(","));
    Charge testCharge = theseCharges.find({it -> getOffenseUCRCode(it) == "ROBBERY"});
    if (testCharge != null && !theseCharges.findAll({it -> restrictedCharges.contains(getOffenseUCRCode(it))}).isEmpty()){
        theseChargesFiltered.add(testCharge);
        theseChargesFiltered.addAll(theseCharges.findAll({it -> !restrictedCharges.contains(getOffenseUCRCode(it))}));
        return theseChargesFiltered;
    } else{
        return theseCharges;
    }
}

protected List<Charge> getRelatedChargesLimitedBySimpleAssault(ArrayList<Charge> theseCharges){
    ArrayList<Charge> theseChargesFiltered = new ArrayList();
    ArrayList<String> restrictedCharges = Arrays.asList("AGGRAVATED_ASSAULT,FONDLING,INTIMIDATION,MANSLAUGHTER_NEGLIGENT,MANSLAUGHTER_NONNEGLIGENT-MURDER,RAPE ROBBERY,SEX_ASSAULT-OBJECT,SODOMY".split(","));
    Charge testCharge = theseCharges.find({it -> getOffenseUCRCode(it) == "ASSAULT-SIMPLE"});
    if (testCharge != null && !theseCharges.findAll({it -> restrictedCharges.contains(getOffenseUCRCode(it))}).isEmpty()){
        theseChargesFiltered.add(testCharge);
        theseChargesFiltered.addAll(theseCharges.findAll({it -> !restrictedCharges.contains(getOffenseUCRCode(it))}));
        return theseChargesFiltered;
    } else{
        return theseCharges;
    }
}

protected List<Charge> getRelatedChargesLimitedByIntimidation(ArrayList<Charge> theseCharges){
    ArrayList<Charge> theseChargesFiltered = new ArrayList();
    ArrayList<String> restrictedCharges = Arrays.asList("AGGRAVATED_ASSAULT,ASSAULT-SIMPLE,FONDLING,MANSLAUGHTER_NEGLIGENT,MANSLAUGHTER_NONNEGLIGENT-MURDER,RAPE,ROBBERY,SEX_ASSAULT-OBJECT,SODOMY".split(","));
    Charge testCharge = theseCharges.find({it -> getOffenseUCRCode(it) == "INTIMIDATION"});
    if (testCharge != null && !theseCharges.findAll({it -> restrictedCharges.contains(getOffenseUCRCode(it))}).isEmpty()){
        theseChargesFiltered.add(testCharge);
        theseChargesFiltered.addAll(theseCharges.findAll({it -> !restrictedCharges.contains(getOffenseUCRCode(it))}));
        return theseChargesFiltered;
    } else{
        return theseCharges;
    }
}

protected List<Charge> getRelatedChargeLimitedByUniqueOffenseUCRCode(ArrayList<Charge> theseCharges){
    return theseCharges.unique({it -> getOffenseUCRCode(it)});
}

protected List<Charge> getRelatedChargesLimitedByExcludingListCharges(ArrayList<Charge> theseCharges, ArrayList<String> excludeCharges){
    ArrayList<Charge> theseChargesFiltered = new ArrayList();
    if (!theseCharges.findAll({it -> !excludeCharges.contains(getOffenseUCRCode(it))}).isEmpty()){
        theseChargesFiltered.addAll(theseCharges.findAll({it -> !excludeCharges.contains(getOffenseUCRCode(it))}));
        return theseChargesFiltered;
    } else return theseCharges;
}

protected List<Charge> getRelatedChargesLimitedByExcludingCrimesAgainsSociety(ArrayList<Charge> theseCharges, ArrayList<String> crimesAgainstSociety){
    ArrayList<Charge> theseChargesFiltered = new ArrayList();
    if (!theseCharges.findAll({it -> !crimesAgainstSociety.contains(getOffenseUCRCode(it))}).isEmpty() && theseCharges.findAll({it -> crimesAgainstSociety.contains(getOffenseUCRCode(it))}).isEmpty()){
        theseChargesFiltered.addAll(theseCharges.find({it -> !crimesAgainstSociety.contains(getOffenseUCRCode(it))}))
    } else {
        theseChargesFiltered.addAll(theseCharges);
    }
    return theseChargesFiltered;
}


protected List<Charge> getRelatedChargesLimitedByExcludingCrimesAgainsGovernment(ArrayList<Charge> theseCharges, ArrayList<String> crimesAgainstGovernment){
    ArrayList<Charge> theseChargesFiltered = new ArrayList();
    if (!theseCharges.findAll({it -> crimesAgainstGovernment.contains(getOffenseUCRCode(it))}).isEmpty()){
        theseChargesFiltered.addAll(theseCharges.find({it -> !crimesAgainstGovernment.contains(getOffenseUCRCode(it))}))
    } else {
        theseChargesFiltered.addAll(theseCharges);
    }
    return theseChargesFiltered;
}

protected List<Charge> getRelatedChargesLimit10(ArrayList<Charge> theseCharges){
    theseCharges.unique({it -> getOffenseUCRCode(it)});
    if (theseCharges.size() > 10){
        return theseCharges.subList(0,9);
    } else return theseCharges;
}




protected String getItemQuantity(Charge thisOffense){
    String itemQuantity = isAttempted(thisOffense) ? "00" : "01";
    itemQuantity = thisOffense.cf_itemQuantity != null && thisOffense.cf_itemQuantity?.matches("\\d{2}") ? thisOffense.cf_itemQuantity : itemQuantity;
    itemQuantity = isAttempted(thisOffense) == false && (!itemQuantity?.matches("\\d{2}") || itemQuantity == "00") ? "01" : itemQuantity;
    return itemQuantity;
}

protected boolean isExceptionalClearanceAtoE(Charge thisOffense){
    if (thisOffense.cf_indicentExceptionalClear.matches("[A-E]")){
        return true;
    } else {
        return false;
    }
}

protected Document createDocument(File fileAttachment, Case cse, List<Charge> charges){
    Document reportDocument = new Document();
    reportDocument.case = cse;
    reportDocument.docDef = DomainObject.find(DocDef.class, "shortName", "NIBRSA").find({it -> it != null});
    reportDocument.memo = charges.id.join("_");
    reportDocument.reviewStatus = "PRIVILEGED";
    reportDocument.saveOrUpdate();
    reportDocument.store(fileAttachment);
    return reportDocument;
}

protected void addDocumentToDocuments(Case cse, Document document){
    cse.add(document, "documents");
    cse.saveOrUpdate();
}

protected List<String> getUCROffenses(List offenses){
    List<String> ucrOffenses = new ArrayList();
    offenses.each({it -> ucrOffenses.add(it.collect("chargeAttributes")?.find({attr -> attr != null}))});
    return ucrOffenses;
}




