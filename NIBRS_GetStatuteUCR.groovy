import com.sustain.cases.model.Statute

//offensesMap stores UCR offense label and code
def Map offensesMap = new HashMap();

//GROUP A OFFENSES
//crimes against person
offensesMap.put("13A", "AGGRAVATED_ASSAULT");//tested grouped
offensesMap.put("13B", "ASSAULT-SIMPLE");//tested grouped
offensesMap.put("09C", "JUSTIFIABLE_HOMICIDE");//tested grouped
offensesMap.put("09A", "MANSLAUGHTER_NONNEGLIGENT-MURDER");//tested grouped
offensesMap.put("13C", "INTIMIDATION");//tested grouped
//5
offensesMap.put("09B", "MANSLAUGHTER_NEGLIGENT");//tested grouped
offensesMap.put("64A", "HUMAN_TRAFFICKING-COMMERCIAL_SEX_ACTS");//tested grouped
offensesMap.put("64B", "HUMAN_TRAFFICKING-INVOLUNTARY_SERVITUDE");//tested grouped
offensesMap.put("100", "KIDNAPPING-ABDUCTION");//tested grouped
offensesMap.put("11A", "RAPE");//tested grouped
//10
offensesMap.put("11B", "SODOMY");//tested grouped
offensesMap.put("11C", "SEX_ASSAULT-OBJECT");//tested grouped
offensesMap.put("11D", "FONDLING");//tested grouped
offensesMap.put("36A", "INCEST");//tested grouped
offensesMap.put("36B", "RAPE-STATUTORY");//tested grouped
//15
//crimes against property
offensesMap.put("200", "ARSON");//tested grouped
offensesMap.put("510", "BRIBERY");//tested grouped
offensesMap.put("220", "BURGLARY-BREAKING_ENTERING");//tested grouped
offensesMap.put("250", "COUNTERFEIT-FORGERY");//tested grouped
offensesMap.put("290", "DAMAGE-DESTRUCTION-VANDALISM_OF_PROPERTY");//tested grouped
//20
offensesMap.put("270", "EMBEZZLEMENT");//tested grouped
offensesMap.put("210", "EXTORTION-BLACKMAIL");//tested grouped
offensesMap.put("26A", "FRAUD-FALSE_PRETENSES-SWINDLE-CONFIDENCE_GAME");//tested grouped
offensesMap.put("26B", "FRAUD-CREDIT_CARD-AUTOMATIC_TELLER_MACHINE");//tested grouped
offensesMap.put("26C", "FRAUD-IMPERSONATION");//tested grouped
//25
offensesMap.put("26D", "FRAUD-WELFARE_FRAUD");//tested grouped
offensesMap.put("26E", "FRAUD-BY_WIRE");//tested grouped
offensesMap.put("26F", "IDENTITY_THEFT");//tested grouped
offensesMap.put("26G", "HACKING-COMPUTER_INVASION");//tested grouped
offensesMap.put("23A", "POCKET_PICKING");//tested grouped
//30
offensesMap.put("23B", "PURSE_SNATCHING");//tested grouped
offensesMap.put("23C", "SHOPLIFTING");//tested grouped
offensesMap.put("23D", "LARCENY-FROM_BUILDING");//tested grouped
offensesMap.put("23E", "LARCENY-FROM_COIN_OPERATED_MACHINE");//tested grouped
offensesMap.put("23F", "LARCENY-FROM_AUTO");//tested grouped
//35
offensesMap.put("23G", "LARCENY-PARTS_FROM_VEHICLE");//tested grouped
offensesMap.put("23H", "LARCENY");//tested grouped
offensesMap.put("240", "MOTOR_VEHICLE_THEFT");//tested grouped
offensesMap.put("120", "ROBBERY");//tested grouped
offensesMap.put("280", "STOLEN_PROPERTY_OFFENSES");//tested grouped
//40
//crimes against society
offensesMap.put("720", "CRUELTY_TO_ANIMALS");//tested grouped
offensesMap.put("370", "OBSCENE_MATERIAL-PORNOGRAPHY");//tested grouped
offensesMap.put("40A", "PROSTITUTION");//tested grouped
offensesMap.put("40B", "PROSTITUTION-ASSISTING_OR_PROMOTING");//tested grouped
offensesMap.put("40C", "PROSTITUTION-PURCHASING");//tested grouped
//45
offensesMap.put("35A", "DRUG-NARCOTIC_VIOLATIONS");//tested grouped
offensesMap.put("35B", "DRUG-EQUIPMENT_VIOLATIONS");//tested grouped
offensesMap.put("39A", "BETTING-WAGERING");//tested grouped
offensesMap.put("39B", "GAMBLING-OPERATING_PROMOTING_ASSISTING");//tested grouped
offensesMap.put("39C", "GAMBLING-EQUIPMENT_VIOLATION");//tested grouped
//50
offensesMap.put("39D", "SPORTS_TAMPERING");//tested grouped
offensesMap.put("520", "WEAPON_LAW_VIOLATIONS");//tested grouped
//Group B
offensesMap.put("90C", "DISORDERLY_CONDUCT");//tested grouped
offensesMap.put("90D", "DRIVING_UNDER_INFLUENCE");//tested grouped
offensesMap.put("90F", "FAMILY_OFFENSES-NONVIOLENT");//tested grouped
offensesMap.put("90G", "LIQUOR_LAW_VIOLATIONS");//tested grouped
offensesMap.put("90J", "TRESPASSING");//tested grouped
offensesMap.put("90Z", "ALL_OTHER_OFFENSES");//tested grouped

def Statute statute = _statute;
def String ucrOffenses = offensesMap.get(statute.sectionCode) ?: "";
if (!ucrOffenses.isEmpty()){
    _output = ucrOffenses;
} else {
    _output = "";
}