import com.sustain.DomainObject
import com.sustain.lookuplist.model.LookupItem
import com.sustain.expression.Where
import com.sustain.lookuplist.model.LookupList
import com.sustain.cases.model.Charge
import com.sustain.properties.model.SystemProperty

import java.sql.Timestamp
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters;
import java.util.Collections;
import com.sustain.cases.model.Party;

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

def String internalTesting = SystemProperty.getValue("nibrs.email.testing") ?: "true";

def int report_year = _report_year == null ? 0 : Integer.parseInt(_report_year);
def int report_month = _report_month == null ? 0 : Month.valueOf(_report_month).getValue();
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
def LocalDateTime localDateTimeStart = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0).withNano(0);
def LocalDateTime localDateTimeEnd = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(58).withNano(999999999);

if (localDate == localDateLastDayOfMonth || internalTesting == "true") {

    Where whereCharge = new Where()
            .addGreaterThanOrEquals("chargeDate", Timestamp.valueOf(localDateTimeStart))
            .addLessThanOrEquals("chargeDate", Timestamp.valueOf(localDateTimeEnd))
            .addIsNull("chargeAttributes")
            .addIsNull("associatedParty.mFCU_ASR_Results")
    //.addEquals("associatedParty", Party.get(32524L))

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


//    if (!charge.getChargeAttributes().isEmpty()){
//        charge.setChargeAttributes(new HashSet<>());
//        chargesToUpdate.add(charge);
//    }

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




    Where whereCharge2 = new Where()
            .addGreaterThanOrEquals("chargeDate", Timestamp.valueOf(localDateTimeStart))
            .addLessThanOrEquals("chargeDate", Timestamp.valueOf(localDateTimeEnd))
            .addIsNotNull("chargeAttributes")
            .addIsNull("associatedParty.mFCU_ASR_Results")
    //.addEquals("associatedParty", Party.get(32524L))

    def ArrayList<Charge> ucrCharges = DomainObject.find(Charge.class, whereCharge2);
    def ArrayList<Party> subjects = ucrCharges.associatedParty.unique({ Party it -> it });
    def ArrayList<Charge> chargesUpdateByXref = new ArrayList();


    for (Party subject in subjects) {
        ArrayList<Charge> subjectUcrOffenses = DomainObject.find(Charge.class, "associatedParty", subject, whereCharge2).findAll({ Charge it -> personUCROffenses.contains(getOffenseUCRCode(it)) || propertyUCROffenses.contains(getOffenseUCRCode(it)) });
        Charge firstChargeToXref = subjectUcrOffenses.sort({ Charge it -> it.chargeNumber }).find({ Charge it -> it.associatedParty.case.collect("crossReferences[lentity.toString() == 'com.sustain.cases.model.Charge' && rentity.toString() == 'com.sustain.cases.model.Charge'].lid").find({ id -> id == it.id }) != null || it.id != null });
        ArrayList<Charge> chargesToXref = subjectUcrOffenses.findAll({ Charge it -> it != firstChargeToXref });
        for (Charge charge in chargesToXref) {
            firstChargeToXref.addCrossReference(charge, "REL");
            chargesUpdateByXref.add(firstChargeToXref);
        }
    }

    DomainObject.saveOrUpdateAll(chargesUpdateByXref);
}

protected String getOffenseUCRCode(Charge offense) {
    String code = offense.collect("chargeAttributes").find({ it -> it != null });
    return code != null ? code?.trim() : "";
}



