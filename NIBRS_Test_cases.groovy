import com.sustain.DomainObject;
import com.sustain.cases.model.Case;
import com.sustain.cases.model.Party;
import com.sustain.expression.Where;
import com.sustain.cases.model.Charge
import com.sustain.util.RichList;
import com.sustain.entities.custom.MFCU_ASR_Result;
/*
def Where where = new Where()
        //.addContainsAny("parties.partyType", ["VICTIM","DEFENDANT"])
        .addIsNotNull("parties.charges")

def ArrayList<Long> testCasesIds = DomainObject.find(Case.class, where, sel("id"), maxResult(100));

//def HashSet<Long> distinctChargedParties = new HashSet(DomainObject.find(Case.class, where, sel("parties.partyType")));

logger.debug(testCasesIds.size());

for (Long id in testCasesIds){
    Case cse = Case.get(id);
    logger.debug("https://eattorney-uat.ago.ms.gov/cms/case?id=${id}")
    for (Party party in cse.collect("parties")){
        logger.debug("case:${party.case} partyType:${party.partyType} hasCharges:${!party.collect("charges").isEmpty()}")

    }
}
*/
/*
Party firstParty = Party.get(32540L);
Party secondParty = Party.get(32805L);
List<Charge> chargesToSave = new ArrayList();


for (Charge charge in firstParty.collect("charges")){
    //Set<String> attributes = charge.getChargeAttributes();
    Charge newCharge = new Charge();
    newCharge.setAssociatedParty(secondParty);
    newCharge.setChargeNumber(charge.chargeNumber);
    newCharge.setStatute(charge.statute);
    newCharge.setStatus(charge.status);
    //newCharge.setChargeAttributes(attributes);
    newCharge.setChargeDate(charge.chargeDate);
    secondParty.add(newCharge);
    chargesToSave.add(newCharge);
}

for (Charge charge in secondParty.collect("charges")){
    charge.setChargeDate(new Date());
    chargesToSave.add(charge);
}

DomainObject.saveOrUpdateAll(chargesToSave);
DomainObject.saveOrUpdate(secondParty);
*/

//DomainObject.deleteAll(DomainObject.find(Document.class, "case.id", 20490L, "case.caseNumber", "23-44"), true);
DomainObject.deleteAll(DomainObject.find(Document.class, "docDef.shortName", "NIBRSA"), true);

logger.debug(DomainObject.find(Party.class, "partyType", "VIC", "status", "ACTIVE", "case.id", 20490L, "person.id", 35291L).size());

//DomainObject.deleteAll(DomainObject.find(Party.class, "partyType", "VIC", "status", "ACTIVE", "case.id", 20490L, "person.id", 35291L), true);

//DomainObject.deleteAll(DomainObject.find(MFCU_ASR_Result.class), true);

