import com.sustain.DomainObject;
import com.sustain.cases.model.Case
import com.sustain.cases.model.CaseCrossReference;
import com.sustain.cases.model.Party;
import com.sustain.expression.Where;
import com.sustain.cases.model.Statute
import com.sustain.cases.model.Charge
import com.sustain.util.RichList;
import com.sustain.entities.custom.MFCU_ASR_Result;
import com.sustain.document.model.Document
import com.sustain.lookuplist.model.LookupItem

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
//GROUP B OFFENSES
//crimes against person, property, or society
offensesMap.put("ALL_OTHER_OFFENSES", "90Z");//tested

//crimes against society
offensesMap.put("DISORDERLY_CONDUCT", "90C");//tested
offensesMap.put("DRIVING_UNDER_INFLUENCE", "90D");//tested
offensesMap.put("FAMILY_OFFENSES_NONVIOLENT", "90F");//tested
offensesMap.put("LIQUOR_LAW_VIOLATIONS", "90G");//tested
offensesMap.put("TRESPASSING", "90J");//tested

def Where where = new Where()
        .addEquals("lookupList.name", "CHARGE_ATTRIBUTES")
        .addIsNull("activeTo");
    def ArrayList<LookupItem> items = DomainObject.find(LookupItem.class, where);
    logger.debug("items size:${items.size()}");
    logger.debug("items:${items.code}");

//def Party partyToCharge = Party.get(33056L);
//def Date chargeDate = new Date();
//def String chargeStatus = "ACT";
//def int chargeNumber = 1;
//def List<Charge> chargesToSave = new ArrayList();
//for (String code in items.code){
//    def Statute statute = DomainObject.find(Statute.class, "sectionCode", (String)offensesMap.get(code)).find({Statute it -> it.sectionCode != null && !it.sectionCode.isEmpty()});
//    logger.debug("code:${code} statute: ${statute}");
//    if (statute != null) {
//        def Charge newCharge = new Charge();
//        newCharge.setAssociatedParty(partyToCharge);
//        newCharge.setChargeNumber(chargeNumber.toString());
//        newCharge.setStatute(statute);
//        newCharge.setStatus(chargeStatus);
//        newCharge.setChargeDate(chargeDate);
//        partyToCharge.add(newCharge);
//        chargesToSave.add(newCharge);
//        chargeNumber++;
//    }
//}
//
//DomainObject.saveOrUpdateAll(chargesToSave);
//DomainObject.saveOrUpdate(partyToCharge);



def ArrayList<Document> documents = DomainObject.find(Document.class, "docDef.shortName", "NIBRSA", "case.id", 20490L);

DomainObject.deleteAll(documents, true);

def ArrayList<CaseCrossReference> crossReferences = DomainObject.find(CaseCrossReference.class, "associatedCase.id", 20490L);
DomainObject.deleteAll(crossReferences, true);


def ArrayList<Charge> charges = DomainObject.find(Charge.class, "updateReason", "NIBRS", "associatedParty.case.id", 20490L);

ArrayList<Charge> chargesToUpdate = new ArrayList<>();
charges.each {Charge it ->
    it.updateReason = "";
    chargesToUpdate.add(it);
}

DomainObject.saveOrUpdateAll(chargesToUpdate);


