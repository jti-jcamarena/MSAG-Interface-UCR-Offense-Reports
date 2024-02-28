import com.sustain.DomainObject
import com.sustain.lookuplist.model.LookupItem
import com.sustain.expression.Where
import com.sustain.lookuplist.model.LookupList
import com.sustain.cases.model.Charge

import java.sql.Timestamp
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters;

ArrayList<String> offenseUCRCodeGroupA = new ArrayList<>(Arrays.asList("AGGRAVATED_ASSAULT,ARSON,ASSAULT-SIMPLE,BETTING-WAGERING,BRIBERY,BURGLARY-BREAKING_ENTERING,COUNTERFEIT-FORGERY,CRUELTY_TO_ANIMALS,DAMAGE-DESTRUCTION-VANDALISM_OF_PROPERTY,DRUG-EQUIPMENT_VIOLATIONS,DRUG-NARCOTIC_VIOLATIONS,EMBEZZLEMENT,ESPIONAGE,EXPLOSIVES,EXPORT_VIOLATIONS,EXTORTION-BLACKMAIL,FEDERAL_LIQUOR_OFFENSES,FEDERAL_TOBACCO_OFFENSES,FIREARM_ACT_VIOLATION,FONDLING,FRAUD-BY_WIRE,FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE,FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME,FRAUD-IMPERSONATION,FRAUD-WELFARE_FRAUD,FUGITIVE-FLIGHT_TO_AVOID_DEPORTATION,FUGITIVE-FLIGHT_TO_AVOID_PROSECUTION,FUGITIVE-HARBORING_ESCAPEE-CONCEALING_FROM_ARREST,GAMBLING-EQUIPMENT_VIOLATION,GAMBLING-OPERATING_PROMOTING_ASSISTING,HACKING-COMPUTER_INVASION,HUMAN_TRAFFICKING-COMMERCIAL_SEX_ACTS,HUMAN_TRAFFICKING-INVOLUNTARY_SERVITUDE,IDENTITY_THEFT,IMMIGRATION-FALSE_CITIZENSHIP,IMMIGRATION-ILLEGAL_ENTRY_INTO_US,IMMIGRATION-OTHER_IMMIGRATION_VIOLATIONS,IMMIGRATION-RE_ENTRY_AFTER_DEPORTATION,IMMIGRATION-SMUGGLING_ALIENS,IMPORT_VIOLATIONS,INCEST,INTIMIDATION,JUSTIFIABLE_HOMICIDE,KIDNAPPING-ABDUCTION,LARCENY,LARCENY-FROM_AUTO,LARCENY-FROM_BUILDING,LARCENY-FROM_COIN_OPERATED_MACHINE,LARCENY-PARTS_FROM_VEHICLE,MANSLAUGHTER_NEGLIGENT,MANSLAUGHTER_NONNEGLIGENT-MURDER,MONEY_LAUNDERING,MOTOR_VEHICLE_THEFT,OBSCENE_MATERIAL-PORNOGRAPHY,POCKET_PICKING,PROSTITUTION,PROSTITUTION-ASSISTING_OR_PROMOTING,PROSTITUTION-PURCHASING,PURSE_SNATCHING,RAPE,RAPE-STATUTORY,ROBBERY,SEX_ASSAULT-OBJECT,SEX_OFFENDER_REGISTRATION_VIOLATION,SHOPLIFTING,SODOMY,SPORTS_TAMPERING,STOLEN_PROPERTY_OFFENSES,TREASON,WEAPON_LAW_VIOLATIONS,WEAPONS_OF_MASS_DESTRUCTION,WILDLIFE_TRAFFICKING".split(",")));
def int report_year = _report_year == null ? 0 : Integer.parseInt(_report_year);
def int report_month = _report_month == null ? 0 : Month.valueOf(_report_month).getValue();
def LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Chicago")).withNano(0);
String incidentDateTimeFormatted = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
if (report_month != 0) {
    localDateTime = localDateTime.withMonth(report_month);
}
if (report_year != 0) {
    localDateTime = localDateTime.withYear(report_year);
}
def LocalDate localDate = localDateTime.toLocalDate();
def LocalDateTime localDateTimeStart = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0).withNano(0);
def LocalDateTime localDateTimeEnd = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(58).withNano(999999999);


Where whereCharge = new Where();
whereCharge.addGreaterThanOrEquals("chargeDate", Timestamp.valueOf(localDateTimeStart));
whereCharge.addLessThanOrEquals("chargeDate", Timestamp.valueOf(localDateTimeEnd));
whereCharge.addIsNull("chargeAttributes");
//whereCharge.addContainsAny("chargeAttributes", offenseUCRCodeGroupA);

def Where where = new Where()
        .addEquals("lookupList.name", "CHARGE_ATTRIBUTES")
        .addIsNull("activeTo");

def ArrayList<Charge> charges = DomainObject.find(Charge.class, "id", 432L, whereCharge);
def ArrayList<LookupItem> items = DomainObject.find(LookupItem.class, where);

def ArrayList<Charge> chargesToUpdate = new ArrayList<>();

for (Charge charge in charges) {
    def String sectionName = charge.statute.sectionName;
    def List<String> sectionNameTokenized = sectionName.replaceAll("\\W"," ").toUpperCase().tokenize();
    logger.debug("sectionNameTokenized:${sectionNameTokenized}");
    def String ucrOffense = "";
    for (String code in items.code) {
        def List<String> codeTokenized = Arrays.asList(code.toUpperCase().split("[_-]"));
        if (!Collections.disjoint(sectionNameTokenized, codeTokenized)) {
            HashSet<String> attributes = new HashSet<>();
            attributes.add(code);
            logger.debug("codeTokenized:${codeTokenized}");
            charge.setChargeAttributes(attributes);
            chargesToUpdate.add(charge);
            break;
        }
    }
}

DomainObject.saveOrUpdateAll(chargesToUpdate);