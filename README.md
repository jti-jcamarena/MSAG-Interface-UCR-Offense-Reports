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




