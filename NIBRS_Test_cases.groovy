import com.sustain.DomainObject;
import com.sustain.cases.model.Case;
import com.sustain.cases.model.Party;
import com.sustain.expression.Where;

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

//for (String partyType in distinctChargedParties){
//    logger.debug(partyType)
//}