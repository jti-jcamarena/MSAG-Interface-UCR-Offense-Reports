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
import java.util.Collections;

//Person offenses:
def ArrayList<String> personUCROffenses =
        Arrays.asList("RAPE-STATUTORY,JUSTIFIABLE_HOMICIDE,HUMAN_TRAFFICKING-INVOLUNTARY_SERVITUDE,HUMAN_TRAFFICKING-COMMERCIAL_SEX_ACTS,SODOMY,RAPE,ASSAULT-SIMPLE,FONDLING,INCEST,MANSLAUGHTER_NONNEGLIGENT-MURDER,SEX_ASSAULT-OBJECT,KIDNAPPING-ABDUCTION,AGGRAVATED_ASSAULT,INTIMIDATION,MANSLAUGHTER_NEGLIGENT".split(","));

//Property offenses:
def ArrayList<String> propertyUCROffenses =
        Arrays.asList("EMBEZZLEMENT,LARCENY-FROM_AUTO,COUNTERFEIT-FORGERY,LARCENY,BURGLARY-BREAKING_ENTERING,DAMAGE-DESTRUCTION-VANDALISM_OF_PROPERTY,FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME,SHOPLIFTING,IDENTITY_THEFT,ARSON,FRAUD-WELFARE_FRAUD,ROBBERY,FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE,STOLEN_PROPERTY_OFFENSES,FRAUD-BY_WIRE,LARCENY-FROM_BUILDING,BRIBERY,FRAUD-IMPERSONATION,EXTORTION-BLACKMAIL,HACKING-COMPUTER_INVASION,LARCENY-PARTS_FROM_VEHICLE,MOTOR_VEHICLE_THEFT,POCKET_PICKING,PURSE_SNATCHING,LARCENY-FROM_COIN_OPERATED_MACHINE".split(","));

//Society offenses:
def ArrayList<String> societyUCROffenses =
        Arrays.asList("BETTING-WAGERING,PROSTITUTION,WEAPON_LAW_VIOLATIONS,OBSCENE_MATERIAL-PORNOGRAPHY,GAMBLING-EQUIPMENT_VIOLATION,DRUG-NARCOTIC_VIOLATIONS,SPORTS_TAMPERING,GAMBLING-OPERATING_PROMOTING_ASSISTING,DRUG-EQUIPMENT_VIOLATIONS,PROSTITUTION-ASSISTING_OR_PROMOTING,CRUELTY_TO_ANIMALS,PROSTITUTION-PURCHASING".split(","));

ArrayList<String> offenseUCRCodeGroupA = new ArrayList();
offenseUCRCodeGroupA.addAll(personUCROffenses);
offenseUCRCodeGroupA.addAll(propertyUCROffenses);
offenseUCRCodeGroupA.addAll(societyUCROffenses);

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
whereCharge.addIsNull("associatedParty.mFCU_ASR_Results");

def Where where = new Where()
        .addEquals("lookupList.name", "CHARGE_ATTRIBUTES")
        .addIsNull("activeTo");

def ArrayList<Charge> charges = DomainObject.find(Charge.class, whereCharge);
def ArrayList<LookupItem> items = DomainObject.find(LookupItem.class, where);
logger.debug("items:${items.code}");
def ArrayList<Charge> chargesToUpdate = new ArrayList<>();
logger.debug("charges:${charges.size()}");

for (Charge charge in charges) {
    def String sectionName = charge.statute.sectionName;
    def List<String> sectionNameTokenized = sectionName.replaceAll("\\W", " ").toUpperCase().tokenize().unique({ it -> it });
    def String ucrOffense = "";


/*    if (!charge.getChargeAttributes().isEmpty()){
        charge.setChargeAttributes(new HashSet<>());
        chargesToUpdate.add(charge);
    }*/

    for (String code in items.code) {
        def ArrayList<String> codeTokenized = Arrays.asList(code.toUpperCase().split("[_-]").toUnique({ it -> it }));
        def ArrayList<String> codeTokenizedRetainAll = Arrays.asList(code.toUpperCase().split("[_-]").toUnique({ it -> it }));
        codeTokenizedRetainAll.retainAll(sectionNameTokenized);

        if (codeTokenized.size() == codeTokenizedRetainAll.size() || codeTokenized.size() > 1 && codeTokenizedRetainAll.size() > 1) {
//            logger.debug("retainall 1: ${sectionNameTokenized} ${codeTokenized}");
            HashSet<String> attributes = new HashSet<>();
            attributes.add(code);
            //logger.debug("sectionNameTokenized:${sectionNameTokenized}");
//            logger.debug("codeTokenized:${codeTokenized}; sectionNameTokenized:${sectionNameTokenized}");
            charge.setChargeAttributes(attributes);
            chargesToUpdate.add(charge);
            break;
        }
    }
}

DomainObject.saveOrUpdateAll(chargesToUpdate);