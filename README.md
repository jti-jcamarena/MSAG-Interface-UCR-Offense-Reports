# MSAG-Interface-UCR-Offense-Reports

Mutually Exclusive
UCR Offense Code 09A MANSLAUGHTER_NONNEGLIGENT-MURDER cannot occur to 13C INTIMIDATION

UCR Offense Code 11A RAPE cannot occur to 11D FONDLING
UCR Offense Code 11A RAPE cannot occur to 36A INCEST
UCR Offense Code 11A RAPE cannot occur to 36B RAPE-STATUTORY

UCR Offense Code 11B SODOMY cannot occur to 36A INCEST
UCR Offense Code 11B SODOMY cannot occur to 36B RAPE-STATUTORY

UCR Offense Code 11C SEX_ASSAULT-OBJECT cannot occur to 11D FONDLING
UCR Offense Code 11C SEX_ASSAULT-OBJECT cannot occur to 36A INCEST
UCR Offense Code 11C SEX_ASSAULT-OBJECT cannot occur to 36B RAPE-STATUTORY

UCR Offense Code 11D FONDLING cannot occur to 11B SODOMY
UCR Offense Code 11D FONDLING cannot occur to 36A INCEST
UCR Offense Code 11D FONDLING cannot occur to 36B RAPE-STATUTORY

UCR Offense Code 13A AGGRAVATED_ASSAULT cannot occur to 09A MANSLAUGHTER_NONNEGLIGENT-MURDER
UCR Offense Code 13A AGGRAVATED_ASSAULT cannot occur to 09B MANSLAUGHTER_NEGLIGENT
UCR Offense Code 13A AGGRAVATED_ASSAULT cannot occur to 11A RAPE
UCR Offense Code 13A AGGRAVATED_ASSAULT cannot occur to 11B SODOMY
UCR Offense Code 13A AGGRAVATED_ASSAULT cannot occur to 11C SEX_ASSAULT-OBJECT
UCR Offense Code 13A AGGRAVATED_ASSAULT cannot occur to 13B ASSAULT-SIMPLE
UCR Offense Code 13A AGGRAVATED_ASSAULT cannot occur to 13C INTIMIDATION
UCR Offense Code 13A AGGRAVATED_ASSAULT cannot occur to 120 ROBBERY

UCR Offense Code 13B ASSAULT-SIMPLE cannot occur to 120 ROBBERY

UCR Offense Code 36A INCEST cannot occur to 11D FONDLING

UCR Offense Code 36B RAPE-STATUTORY cannot occur to 11D FONDLING

UCR Offense Code 120 ROBBERY cannot occur to 240 MOTOR_VEHICLE_THEFT

UCR Offense Code 240 MOTOR_VEHICLE_THEFT cannot occur to 120 ROBBERY

09B MANSLAUGHTER_NEGLIGENT rules
Offense 09B MANSLAUGHTER_NEGLIGENT does not allow the Type of Weapon/Force Involved to be 99 = Unknown
Aggravated Assault/Homicide Circumstances must contain data values permitted for the offenses. Victim: 1

09C JUSTIFIABLE_HOMICIDE rules
No other offense can be submitted with Justifiable Homicide 13A
No other offense can be submitted with Justifiable Homicide 200
No other offense can be submitted with Justifiable Homicide 220
No other offense can be submitted with Justifiable Homicide 240
No other offense can be submitted with Justifiable Homicide 290
Additional Justifiable Homicide Circumstances must be entered when Victim Connected to UCR Code is 09C = Justifiable Homicide.
Aggravated Assault/Homicide Circumstances can only contain 20 or 21 when Connected UCR Offense Code is 09C. Aggravated Assault/Homicide Circumstances 10
Aggravated Assault/Homicide Circumstances must contain data values permitted for the offenses. Victim: 1
When Offense code = 09C, at least one offender must contain values other than unknown for Age, Sex and Race. Offender sequence number 1 Age 20 25 Sex U Race U

36B RAPE-STATUTORY rules
Age of Victim should be under 18 when Victim Connected to UCR Offense Code is 36B = Statutory Rape. Age: 36

Combination of Property Loss + Property Description must be unique 20,20

Victim Injury Type must be specified when Victim Connected to UCR Offense Code is one of: 100, 11A, 11B, 11C, 11D, 120, 13A, 13B, 210, 64A, 64B

Type of Victim must have a value of S = Society/Public when Data Element 24 (Victim Connected to UCR Offense Code) contains a Crime Against Society: I

There should only be one victim and it should have a type of Society/Public when UCR Offense Code contains only crimes against society G

Type of Victim must have a value of S = Society/Public when Data Element 24 (Victim Connected to UCR Offense Code) contains a Crime Against Society: G

Suspected Drug Type must be entered when Type of Property Loss is 1 and Offense Code is 35A

Missing mandatory segment: each incident must have at least one victim
Missing mandatory segment: each Offense must have at least one Victim


Group A Offense UCR - crimes against Society
Victim Type G - Government
IMPORT_VIOLATIONS,G
EXPORT_VIOLATIONS,G
FEDERAL_LIQUOR_OFFENSES,G
FEDERAL_TOBACCO_OFFENSES,G
WILDLIFE_TRAFFICKING,G
FIREARM_ACT_VIOLATION,G
WEAPONS_OF_MASS_DESTRUCTION,G
EXPLOSIVES,G
Victim Type S - Society
CRUELTY_TO_ANIMALS,
DRUG-NARCOTIC_VIOLATIONS,
DRUG-EQUIPMENT_VIOLATIONS,
ESPIONAGE,
FUGITIVE-HARBORING_ESCAPEE-CONCEALING_FROM_ARREST,
FUGITIVE-FLIGHT_TO_AVOID_PROSECUTION,
FUGITIVE-FLIGHT_TO_AVOID_DEPORTATION,
BETTING-WAGERING,
GAMBLING-OPERATING_PROMOTING_ASSISTING,
GAMBLING-EQUIPMENT_VIOLATION,
IMMIGRATION-ILLEGAL_ENTRY_INTO_US,
IMMIGRATION-FALSE_CITIZENSHIP,
IMMIGRATION,SMUGGLING_ALIENS,
IMMIGRATION-RE_ENTRY_AFTER_DEPORTATION,
OBSCENE_MATERIAL-PORNOGRAPHY,
PROSTITUTION,
PROSTITUTION-ASSISTING_OR_PROMOTING,
PROSTITUTION-PURCHASING,
SEX_OFFENDER_REGISTRATION_VIOLATION,
TREASON,
WEAPON_LAW_VIOLATIONS,


//TODO UCR Group A Offenses review

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
//offensesMap.put("MONEY_LAUNDERING", "26H");//failed code 26H is not valid ; OffenseCodeType - The Enumeration constraint failed
//30
offensesMap.put("POCKET_PICKING", "23A");//tested grouped
offensesMap.put("PURSE_SNATCHING", "23B");//tested grouped
offensesMap.put("SHOPLIFTING", "23C");//tested grouped
offensesMap.put("LARCENY-FROM_BUILDING", "23D");//tested grouped
offensesMap.put("LARCENY-FROM_COIN_OPERATED_MACHINE", "23E");//tested grouped
//35
offensesMap.put("LARCENY-FROM_AUTO", "23F");//tested grouped
offensesMap.put("LARCENY-PARTS_FROM_VEHICLE", "23G");//tested grouped
offensesMap.put("LARCENY", "23H");//tested grouped
offensesMap.put("MOTOR_VEHICLE_THEFT", "240");//tested grouped
offensesMap.put("ROBBERY", "120");//tested grouped
//40
//TODO check item status dropdown
offensesMap.put("STOLEN_PROPERTY_OFFENSES", "280");//tested grouped

//crimes against society
offensesMap.put("CRUELTY_TO_ANIMALS", "720");//tested grouped

//offensesMap.put("IMMIGRATION-FALSE_CITIZENSHIP", "30B");//failed  The Enumeration constraint failed
//offensesMap.put("IMMIGRATION-ILLEGAL_ENTRY_INTO_US", "30A");//failed  The Enumeration constraint failed
//offensesMap.put("IMMIGRATION-SMUGGLING_ALIENS", "30C");//failed  The Enumeration constraint failed
//offensesMap.put("IMMIGRATION-RE_ENTRY_AFTER_DEPORTATION", "30D");//failed  The Enumeration constraint failed
offensesMap.put("OBSCENE_MATERIAL-PORNOGRAPHY", "370");//tested grouped
//45
offensesMap.put("PROSTITUTION", "40A");//tested grouped
offensesMap.put("PROSTITUTION-ASSISTING_OR_PROMOTING", "40B");//tested grouped
offensesMap.put("PROSTITUTION-PURCHASING", "40C");//tested grouped
//offensesMap.put("SEX_OFFENSER_REGISTRATION_VIOLATION", "360");//failed  The Enumeration constraint failed
//offensesMap.put("IMPORT_VIOLATIONS", "58A");//failed  The Enumeration constraint failed
//50
//offensesMap.put("EXPORT_VIOLATIONS", "58B");//failed  The Enumeration constraint failed
//offensesMap.put("FEDERAL_LIQUOR_OFFENSES", "61A");//failed  The Enumeration constraint failed
//offensesMap.put("FEDERAL_TOBACCO_OFFENSES", "61B");//failed  The Enumeration constraint failed
//offensesMap.put("WILDLIFE_TRAFFICKING", "620");//failed  The Enumeration constraint failed
//TODO check item status drop down
offensesMap.put("DRUG-NARCOTIC_VIOLATIONS", "35A");//tested grouped
//55
//TODO check item status drop down
offensesMap.put("DRUG-EQUIPMENT_VIOLATIONS", "35B");//tested grouped
//offensesMap.put("ESPIONAGE", "103");//failed  The Enumeration constraint failed
//offensesMap.put("FUGITIVE-HARBORING_ESCAPEE-CONCEALING_FROM_ARREST", "49A");//failed  The Enumeration constraint failed
//offensesMap.put("FUGITIVE-FLIGHT_TO_AVOID_PROSECUTION", "49B");//failed  The Enumeration constraint failed
//offensesMap.put("FUGITIVE-FLIGHT_TO_AVOID_DEPORTATION", "49C");//failed  The Enumeration constraint failed
//60
offensesMap.put("BETTING-WAGERING", "39A");//tested grouped
//TODO check item status drop down
offensesMap.put("GAMBLING-OPERATING_PROMOTING_ASSISTING", "39B");//tested grouped
//TODO check item status drop down
offensesMap.put("GAMBLING-EQUIPMENT_VIOLATION", "39C");//tested grouped
//TODO check item status drop down
offensesMap.put("SPORTS_TAMPERING", "39D");//tested grouped
//offensesMap.put("TREASON", "101");//failed  The Enumeration constraint failed
//65
offensesMap.put("WEAPON_LAW_VIOLATIONS", "520");//failed
//offensesMap.put("FIREARM_ACT_VIOLATION", "521");//failed  The Enumeration constraint failed
//offensesMap.put("WEAPONS_OF_MASS_DESTRUCTION", "522");//failed  The Enumeration constraint failed
//offensesMap.put("EXPLOSIVES", "526");//failed  The Enumeration constraint failed
//70
//GROUP B OFFENSES
//crimes against person, property, or society
//offensesMap.put("ALL_OTHER_OFFENSES", "90Z");//review listed as Group B failed  The Enumeration constraint failed
//
////crimes against society
//offensesMap.put("FAILURE TO APPEAR", "90K");//review listed as Group B failed  The Enumeration constraint failed
//offensesMap.put("CURFEW-LOITERING-VAGRANCY_VIOLATIONS", "90B");//review listed as Group B failed  The Enumeration constraint failed
//offensesMap.put("DISORDERLY_CONDUCT", "90C");//review listed as Group B failed  The Enumeration constraint failed
//offensesMap.put("DRIVING_UNDER_INFLUENCE", "90D");//review listed as Group B failed  The Enumeration constraint failed
//offensesMap.put("FAMILY_OFFENSES_NONVIOLENT", "90F");//review listed as Group B failed  The Enumeration constraint failed
//
//offensesMap.put("FEDERAL_RESOURCE_VIOLATIONS", "90L");//review listed as Group B failed  The Enumeration constraint failed
//offensesMap.put("LIQUOR_LAW_VIOLATIONS", "90G");//review listed as Group B failed  The Enumeration constraint failed
//offensesMap.put("PERJURY", "90M");//review listed as Group B failed  The Enumeration constraint failed
//offensesMap.put("TRESPASSING", "90J");//review listed as Group B failed  The Enumeration constraint failed




