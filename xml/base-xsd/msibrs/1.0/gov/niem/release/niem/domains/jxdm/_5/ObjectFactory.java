
package gov.niem.release.niem.domains.jxdm._5;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import gov.niem.release.niem.codes.fbi_ncic._3.SEXCodeType;
import gov.niem.release.niem.codes.fbi_ndex._3.BiasMotivationCodeType;
import gov.niem.release.niem.codes.fbi_ndex._3.JuvenileDispositionCodeType;
import gov.niem.release.niem.codes.fbi_ndex._3.RACCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.AggravatedAssaultHomicideFactorsCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.ArrestCategoryCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.ArresteeWeaponCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.DrugCategoryCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.DrugMeasurementCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.EthnicityCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.ForceCategoryCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.IncidentExceptionalClearanceCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.IncidentFactorCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.InjuryCategoryCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.JustifiableHomicideFactorsCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.LEOKAActivityCategoryCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.LEOKAOfficerAssignmentCategoryCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.MethodOfEntryCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.MultipleArresteeSegmentsCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.OffenseCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.PropertyCategoryCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.ResidentCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.VictimCategoryCodeType;
import gov.niem.release.niem.niem_core._3.DateType;
import gov.niem.release.niem.niem_core._3.IdentificationType;
import gov.niem.release.niem.niem_core._3.InjuryType;
import gov.niem.release.niem.niem_core._3.QuantityType;
import gov.niem.release.niem.niem_core._3.TextType;
import gov.niem.release.niem.proxy.xsd._3.Boolean;
import gov.niem.release.niem.proxy.xsd._3.String;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gov.niem.release.niem.domains.jxdm._5 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _VictimToSubjectRelationship_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "VictimToSubjectRelationship");
    private final static QName _ChargeUCR_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ChargeUCR");
    private final static QName _CriminalActivityCategory_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "CriminalActivityCategory");
    private final static QName _OffenseDesignation_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "OffenseDesignation");
    private final static QName _SubjectAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "SubjectAugmentationPoint");
    private final static QName _Arrest_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "Arrest");
    private final static QName _ArrestCategory_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ArrestCategory");
    private final static QName _ArrestCategoryCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ArrestCategoryCode");
    private final static QName _ArrestCharge_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ArrestCharge");
    private final static QName _ArrestSequenceID_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ArrestSequenceID");
    private final static QName _ArrestSubject_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ArrestSubject");
    private final static QName _ArrestSubjectAssociation_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ArrestSubjectAssociation");
    private final static QName _ArrestSubjectCount_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ArrestSubjectCount");
    private final static QName _ArrestSubjectCountCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ArrestSubjectCountCode");
    private final static QName _Arrestee_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "Arrestee");
    private final static QName _ArresteeArmedWith_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ArresteeArmedWith");
    private final static QName _ArresteeArmedWithCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ArresteeArmedWithCode");
    private final static QName _ArresteeClearanceIndicator_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ArresteeClearanceIndicator");
    private final static QName _ArresteeJuvenileDisposition_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ArresteeJuvenileDisposition");
    private final static QName _ArresteeJuvenileDispositionCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ArresteeJuvenileDispositionCode");
    private final static QName _ChargeUCRCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ChargeUCRCode");
    private final static QName _DrugCategoryCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "DrugCategoryCode");
    private final static QName _EnforcementOfficial_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "EnforcementOfficial");
    private final static QName _EnforcementOfficialActivityCategory_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "EnforcementOfficialActivityCategory");
    private final static QName _EnforcementOfficialActivityCategoryCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "EnforcementOfficialActivityCategoryCode");
    private final static QName _EnforcementOfficialAssignmentCategory_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "EnforcementOfficialAssignmentCategory");
    private final static QName _EnforcementOfficialAssignmentCategoryCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "EnforcementOfficialAssignmentCategoryCode");
    private final static QName _EnforcementOfficialUnit_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "EnforcementOfficialUnit");
    private final static QName _ForceCategory_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ForceCategory");
    private final static QName _ForceCategoryCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ForceCategoryCode");
    private final static QName _IncidentAugmentation_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "IncidentAugmentation");
    private final static QName _IncidentExceptionalClearance_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "IncidentExceptionalClearance");
    private final static QName _IncidentExceptionalClearanceCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "IncidentExceptionalClearanceCode");
    private final static QName _IncidentExceptionalClearanceDate_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "IncidentExceptionalClearanceDate");
    private final static QName _InjuryCategoryCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "InjuryCategoryCode");
    private final static QName _ItemCategoryNIBRSPropertyCategoryCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ItemCategoryNIBRSPropertyCategoryCode");
    private final static QName _Offense_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "Offense");
    private final static QName _OffenseAttemptedIndicator_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "OffenseAttemptedIndicator");
    private final static QName _OffenseCargoTheftIndicator_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "OffenseCargoTheftIndicator");
    private final static QName _OffenseEntryPoint_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "OffenseEntryPoint");
    private final static QName _OffenseFactor_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "OffenseFactor");
    private final static QName _OffenseFactorBiasMotivation_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "OffenseFactorBiasMotivation");
    private final static QName _OffenseFactorBiasMotivationCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "OffenseFactorBiasMotivationCode");
    private final static QName _OffenseFactorCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "OffenseFactorCode");
    private final static QName _OffenseFactorDesignation_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "OffenseFactorDesignation");
    private final static QName _OffenseForce_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "OffenseForce");
    private final static QName _OffenseLocationAssociation_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "OffenseLocationAssociation");
    private final static QName _OffenseLocationAssociationAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "OffenseLocationAssociationAugmentationPoint");
    private final static QName _OffenseStructuresEnteredQuantity_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "OffenseStructuresEnteredQuantity");
    private final static QName _OffenseVictimAssociation_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "OffenseVictimAssociation");
    private final static QName _OffenseAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "OffenseAugmentationPoint");
    private final static QName _OrganizationAugmentation_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "OrganizationAugmentation");
    private final static QName _OrganizationIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "OrganizationIdentification");
    private final static QName _OrganizationORIIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "OrganizationORIIdentification");
    private final static QName _PassagePointMethod_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "PassagePointMethod");
    private final static QName _PassagePointMethodCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "PassagePointMethodCode");
    private final static QName _PersonEthnicityCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "PersonEthnicityCode");
    private final static QName _PersonRaceNDExCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "PersonRaceNDExCode");
    private final static QName _PersonResidentCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "PersonResidentCode");
    private final static QName _PersonSexCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "PersonSexCode");
    private final static QName _Subject_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "Subject");
    private final static QName _SubjectArmedWith_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "SubjectArmedWith");
    private final static QName _SubjectArmedWithCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "SubjectArmedWithCode");
    private final static QName _SubjectSequenceNumberText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "SubjectSequenceNumberText");
    private final static QName _SubjectVictimAssociation_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "SubjectVictimAssociation");
    private final static QName _SubstanceUnitCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "SubstanceUnitCode");
    private final static QName _Victim_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "Victim");
    private final static QName _VictimAggravatedAssaultHomicideFactor_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "VictimAggravatedAssaultHomicideFactor");
    private final static QName _VictimAggravatedAssaultHomicideFactorCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "VictimAggravatedAssaultHomicideFactorCode");
    private final static QName _VictimCategory_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "VictimCategory");
    private final static QName _VictimCategoryCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "VictimCategoryCode");
    private final static QName _VictimInjury_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "VictimInjury");
    private final static QName _VictimJustifiableHomicideFactor_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "VictimJustifiableHomicideFactor");
    private final static QName _VictimJustifiableHomicideFactorCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "VictimJustifiableHomicideFactorCode");
    private final static QName _VictimSequenceNumberText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "VictimSequenceNumberText");
    private final static QName _VictimAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "VictimAugmentationPoint");
    private final static QName _ArresteeAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ArresteeAugmentationPoint");
    private final static QName _ArrestAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/5.2/", "ArrestAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gov.niem.release.niem.domains.jxdm._5
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ArrestType }
     * 
     */
    public ArrestType createArrestType() {
        return new ArrestType();
    }

    /**
     * Create an instance of {@link ChargeType }
     * 
     */
    public ChargeType createChargeType() {
        return new ChargeType();
    }

    /**
     * Create an instance of {@link SubjectType }
     * 
     */
    public SubjectType createSubjectType() {
        return new SubjectType();
    }

    /**
     * Create an instance of {@link ActivitySubjectAssociationType }
     * 
     */
    public ActivitySubjectAssociationType createActivitySubjectAssociationType() {
        return new ActivitySubjectAssociationType();
    }

    /**
     * Create an instance of {@link ArresteeType }
     * 
     */
    public ArresteeType createArresteeType() {
        return new ArresteeType();
    }

    /**
     * Create an instance of {@link EnforcementOfficialType }
     * 
     */
    public EnforcementOfficialType createEnforcementOfficialType() {
        return new EnforcementOfficialType();
    }

    /**
     * Create an instance of {@link EnforcementUnitType }
     * 
     */
    public EnforcementUnitType createEnforcementUnitType() {
        return new EnforcementUnitType();
    }

    /**
     * Create an instance of {@link IncidentAugmentationType }
     * 
     */
    public IncidentAugmentationType createIncidentAugmentationType() {
        return new IncidentAugmentationType();
    }

    /**
     * Create an instance of {@link OffenseType }
     * 
     */
    public OffenseType createOffenseType() {
        return new OffenseType();
    }

    /**
     * Create an instance of {@link PassagePointType }
     * 
     */
    public PassagePointType createPassagePointType() {
        return new PassagePointType();
    }

    /**
     * Create an instance of {@link OffenseFactorType }
     * 
     */
    public OffenseFactorType createOffenseFactorType() {
        return new OffenseFactorType();
    }

    /**
     * Create an instance of {@link ForceType }
     * 
     */
    public ForceType createForceType() {
        return new ForceType();
    }

    /**
     * Create an instance of {@link OffenseLocationAssociationType }
     * 
     */
    public OffenseLocationAssociationType createOffenseLocationAssociationType() {
        return new OffenseLocationAssociationType();
    }

    /**
     * Create an instance of {@link OffenseVictimAssociationType }
     * 
     */
    public OffenseVictimAssociationType createOffenseVictimAssociationType() {
        return new OffenseVictimAssociationType();
    }

    /**
     * Create an instance of {@link OrganizationAugmentationType }
     * 
     */
    public OrganizationAugmentationType createOrganizationAugmentationType() {
        return new OrganizationAugmentationType();
    }

    /**
     * Create an instance of {@link SubjectVictimAssociationType }
     * 
     */
    public SubjectVictimAssociationType createSubjectVictimAssociationType() {
        return new SubjectVictimAssociationType();
    }

    /**
     * Create an instance of {@link VictimType }
     * 
     */
    public VictimType createVictimType() {
        return new VictimType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "VictimToSubjectRelationship")
    public JAXBElement<Object> createVictimToSubjectRelationship(Object value) {
        return new JAXBElement<Object>(_VictimToSubjectRelationship_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ChargeUCR")
    public JAXBElement<Object> createChargeUCR(Object value) {
        return new JAXBElement<Object>(_ChargeUCR_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "CriminalActivityCategory")
    public JAXBElement<Object> createCriminalActivityCategory(Object value) {
        return new JAXBElement<Object>(_CriminalActivityCategory_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "OffenseDesignation")
    public JAXBElement<Object> createOffenseDesignation(Object value) {
        return new JAXBElement<Object>(_OffenseDesignation_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "SubjectAugmentationPoint")
    public JAXBElement<Object> createSubjectAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_SubjectAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrestType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrestType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "Arrest")
    public JAXBElement<ArrestType> createArrest(ArrestType value) {
        return new JAXBElement<ArrestType>(_Arrest_QNAME, ArrestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ArrestCategory")
    public JAXBElement<Object> createArrestCategory(Object value) {
        return new JAXBElement<Object>(_ArrestCategory_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrestCategoryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrestCategoryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ArrestCategoryCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "ArrestCategory")
    public JAXBElement<ArrestCategoryCodeType> createArrestCategoryCode(ArrestCategoryCodeType value) {
        return new JAXBElement<ArrestCategoryCodeType>(_ArrestCategoryCode_QNAME, ArrestCategoryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ArrestCharge")
    public JAXBElement<ChargeType> createArrestCharge(ChargeType value) {
        return new JAXBElement<ChargeType>(_ArrestCharge_QNAME, ChargeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ArrestSequenceID")
    public JAXBElement<String> createArrestSequenceID(String value) {
        return new JAXBElement<String>(_ArrestSequenceID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubjectType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SubjectType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ArrestSubject")
    public JAXBElement<SubjectType> createArrestSubject(SubjectType value) {
        return new JAXBElement<SubjectType>(_ArrestSubject_QNAME, SubjectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivitySubjectAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ActivitySubjectAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ArrestSubjectAssociation")
    public JAXBElement<ActivitySubjectAssociationType> createArrestSubjectAssociation(ActivitySubjectAssociationType value) {
        return new JAXBElement<ActivitySubjectAssociationType>(_ArrestSubjectAssociation_QNAME, ActivitySubjectAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ArrestSubjectCount")
    public JAXBElement<Object> createArrestSubjectCount(Object value) {
        return new JAXBElement<Object>(_ArrestSubjectCount_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultipleArresteeSegmentsCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultipleArresteeSegmentsCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ArrestSubjectCountCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "ArrestSubjectCount")
    public JAXBElement<MultipleArresteeSegmentsCodeType> createArrestSubjectCountCode(MultipleArresteeSegmentsCodeType value) {
        return new JAXBElement<MultipleArresteeSegmentsCodeType>(_ArrestSubjectCountCode_QNAME, MultipleArresteeSegmentsCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArresteeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArresteeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "Arrestee")
    public JAXBElement<ArresteeType> createArrestee(ArresteeType value) {
        return new JAXBElement<ArresteeType>(_Arrestee_QNAME, ArresteeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ArresteeArmedWith")
    public JAXBElement<Object> createArresteeArmedWith(Object value) {
        return new JAXBElement<Object>(_ArresteeArmedWith_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArresteeWeaponCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArresteeWeaponCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ArresteeArmedWithCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "ArresteeArmedWith")
    public JAXBElement<ArresteeWeaponCodeType> createArresteeArmedWithCode(ArresteeWeaponCodeType value) {
        return new JAXBElement<ArresteeWeaponCodeType>(_ArresteeArmedWithCode_QNAME, ArresteeWeaponCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ArresteeClearanceIndicator")
    public JAXBElement<Boolean> createArresteeClearanceIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_ArresteeClearanceIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ArresteeJuvenileDisposition")
    public JAXBElement<Object> createArresteeJuvenileDisposition(Object value) {
        return new JAXBElement<Object>(_ArresteeJuvenileDisposition_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JuvenileDispositionCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JuvenileDispositionCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ArresteeJuvenileDispositionCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "ArresteeJuvenileDisposition")
    public JAXBElement<JuvenileDispositionCodeType> createArresteeJuvenileDispositionCode(JuvenileDispositionCodeType value) {
        return new JAXBElement<JuvenileDispositionCodeType>(_ArresteeJuvenileDispositionCode_QNAME, JuvenileDispositionCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OffenseCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OffenseCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ChargeUCRCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "ChargeUCR")
    public JAXBElement<OffenseCodeType> createChargeUCRCode(OffenseCodeType value) {
        return new JAXBElement<OffenseCodeType>(_ChargeUCRCode_QNAME, OffenseCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DrugCategoryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DrugCategoryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "DrugCategoryCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "SubstanceCategory")
    public JAXBElement<DrugCategoryCodeType> createDrugCategoryCode(DrugCategoryCodeType value) {
        return new JAXBElement<DrugCategoryCodeType>(_DrugCategoryCode_QNAME, DrugCategoryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnforcementOfficialType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EnforcementOfficialType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "EnforcementOfficial")
    public JAXBElement<EnforcementOfficialType> createEnforcementOfficial(EnforcementOfficialType value) {
        return new JAXBElement<EnforcementOfficialType>(_EnforcementOfficial_QNAME, EnforcementOfficialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "EnforcementOfficialActivityCategory")
    public JAXBElement<Object> createEnforcementOfficialActivityCategory(Object value) {
        return new JAXBElement<Object>(_EnforcementOfficialActivityCategory_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LEOKAActivityCategoryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LEOKAActivityCategoryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "EnforcementOfficialActivityCategoryCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "EnforcementOfficialActivityCategory")
    public JAXBElement<LEOKAActivityCategoryCodeType> createEnforcementOfficialActivityCategoryCode(LEOKAActivityCategoryCodeType value) {
        return new JAXBElement<LEOKAActivityCategoryCodeType>(_EnforcementOfficialActivityCategoryCode_QNAME, LEOKAActivityCategoryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "EnforcementOfficialAssignmentCategory")
    public JAXBElement<Object> createEnforcementOfficialAssignmentCategory(Object value) {
        return new JAXBElement<Object>(_EnforcementOfficialAssignmentCategory_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LEOKAOfficerAssignmentCategoryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LEOKAOfficerAssignmentCategoryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "EnforcementOfficialAssignmentCategoryCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "EnforcementOfficialAssignmentCategory")
    public JAXBElement<LEOKAOfficerAssignmentCategoryCodeType> createEnforcementOfficialAssignmentCategoryCode(LEOKAOfficerAssignmentCategoryCodeType value) {
        return new JAXBElement<LEOKAOfficerAssignmentCategoryCodeType>(_EnforcementOfficialAssignmentCategoryCode_QNAME, LEOKAOfficerAssignmentCategoryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnforcementUnitType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EnforcementUnitType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "EnforcementOfficialUnit")
    public JAXBElement<EnforcementUnitType> createEnforcementOfficialUnit(EnforcementUnitType value) {
        return new JAXBElement<EnforcementUnitType>(_EnforcementOfficialUnit_QNAME, EnforcementUnitType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ForceCategory")
    public JAXBElement<Object> createForceCategory(Object value) {
        return new JAXBElement<Object>(_ForceCategory_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ForceCategoryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ForceCategoryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ForceCategoryCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "ForceCategory")
    public JAXBElement<ForceCategoryCodeType> createForceCategoryCode(ForceCategoryCodeType value) {
        return new JAXBElement<ForceCategoryCodeType>(_ForceCategoryCode_QNAME, ForceCategoryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncidentAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IncidentAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "IncidentAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "IncidentAugmentationPoint")
    public JAXBElement<IncidentAugmentationType> createIncidentAugmentation(IncidentAugmentationType value) {
        return new JAXBElement<IncidentAugmentationType>(_IncidentAugmentation_QNAME, IncidentAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "IncidentExceptionalClearance")
    public JAXBElement<Object> createIncidentExceptionalClearance(Object value) {
        return new JAXBElement<Object>(_IncidentExceptionalClearance_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncidentExceptionalClearanceCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IncidentExceptionalClearanceCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "IncidentExceptionalClearanceCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "IncidentExceptionalClearance")
    public JAXBElement<IncidentExceptionalClearanceCodeType> createIncidentExceptionalClearanceCode(IncidentExceptionalClearanceCodeType value) {
        return new JAXBElement<IncidentExceptionalClearanceCodeType>(_IncidentExceptionalClearanceCode_QNAME, IncidentExceptionalClearanceCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "IncidentExceptionalClearanceDate")
    public JAXBElement<DateType> createIncidentExceptionalClearanceDate(DateType value) {
        return new JAXBElement<DateType>(_IncidentExceptionalClearanceDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InjuryCategoryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InjuryCategoryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "InjuryCategoryCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "InjuryCategory")
    public JAXBElement<InjuryCategoryCodeType> createInjuryCategoryCode(InjuryCategoryCodeType value) {
        return new JAXBElement<InjuryCategoryCodeType>(_InjuryCategoryCode_QNAME, InjuryCategoryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PropertyCategoryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PropertyCategoryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ItemCategoryNIBRSPropertyCategoryCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "ItemCategory")
    public JAXBElement<PropertyCategoryCodeType> createItemCategoryNIBRSPropertyCategoryCode(PropertyCategoryCodeType value) {
        return new JAXBElement<PropertyCategoryCodeType>(_ItemCategoryNIBRSPropertyCategoryCode_QNAME, PropertyCategoryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OffenseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OffenseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "Offense")
    public JAXBElement<OffenseType> createOffense(OffenseType value) {
        return new JAXBElement<OffenseType>(_Offense_QNAME, OffenseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "OffenseAttemptedIndicator")
    public JAXBElement<Boolean> createOffenseAttemptedIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_OffenseAttemptedIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "OffenseCargoTheftIndicator")
    public JAXBElement<Boolean> createOffenseCargoTheftIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_OffenseCargoTheftIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PassagePointType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PassagePointType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "OffenseEntryPoint")
    public JAXBElement<PassagePointType> createOffenseEntryPoint(PassagePointType value) {
        return new JAXBElement<PassagePointType>(_OffenseEntryPoint_QNAME, PassagePointType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OffenseFactorType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OffenseFactorType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "OffenseFactor")
    public JAXBElement<OffenseFactorType> createOffenseFactor(OffenseFactorType value) {
        return new JAXBElement<OffenseFactorType>(_OffenseFactor_QNAME, OffenseFactorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "OffenseFactorBiasMotivation")
    public JAXBElement<Object> createOffenseFactorBiasMotivation(Object value) {
        return new JAXBElement<Object>(_OffenseFactorBiasMotivation_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BiasMotivationCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BiasMotivationCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "OffenseFactorBiasMotivationCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "OffenseFactorBiasMotivation")
    public JAXBElement<BiasMotivationCodeType> createOffenseFactorBiasMotivationCode(BiasMotivationCodeType value) {
        return new JAXBElement<BiasMotivationCodeType>(_OffenseFactorBiasMotivationCode_QNAME, BiasMotivationCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncidentFactorCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IncidentFactorCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "OffenseFactorCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "OffenseFactorDesignation")
    public JAXBElement<IncidentFactorCodeType> createOffenseFactorCode(IncidentFactorCodeType value) {
        return new JAXBElement<IncidentFactorCodeType>(_OffenseFactorCode_QNAME, IncidentFactorCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "OffenseFactorDesignation")
    public JAXBElement<Object> createOffenseFactorDesignation(Object value) {
        return new JAXBElement<Object>(_OffenseFactorDesignation_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ForceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ForceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "OffenseForce")
    public JAXBElement<ForceType> createOffenseForce(ForceType value) {
        return new JAXBElement<ForceType>(_OffenseForce_QNAME, ForceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OffenseLocationAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OffenseLocationAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "OffenseLocationAssociation")
    public JAXBElement<OffenseLocationAssociationType> createOffenseLocationAssociation(OffenseLocationAssociationType value) {
        return new JAXBElement<OffenseLocationAssociationType>(_OffenseLocationAssociation_QNAME, OffenseLocationAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "OffenseLocationAssociationAugmentationPoint")
    public JAXBElement<Object> createOffenseLocationAssociationAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_OffenseLocationAssociationAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuantityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QuantityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "OffenseStructuresEnteredQuantity")
    public JAXBElement<QuantityType> createOffenseStructuresEnteredQuantity(QuantityType value) {
        return new JAXBElement<QuantityType>(_OffenseStructuresEnteredQuantity_QNAME, QuantityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OffenseVictimAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OffenseVictimAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "OffenseVictimAssociation")
    public JAXBElement<OffenseVictimAssociationType> createOffenseVictimAssociation(OffenseVictimAssociationType value) {
        return new JAXBElement<OffenseVictimAssociationType>(_OffenseVictimAssociation_QNAME, OffenseVictimAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "OffenseAugmentationPoint")
    public JAXBElement<Object> createOffenseAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_OffenseAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "OrganizationAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "OrganizationAugmentationPoint")
    public JAXBElement<OrganizationAugmentationType> createOrganizationAugmentation(OrganizationAugmentationType value) {
        return new JAXBElement<OrganizationAugmentationType>(_OrganizationAugmentation_QNAME, OrganizationAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "OrganizationIdentification")
    public JAXBElement<Object> createOrganizationIdentification(Object value) {
        return new JAXBElement<Object>(_OrganizationIdentification_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "OrganizationORIIdentification", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "OrganizationIdentification")
    public JAXBElement<IdentificationType> createOrganizationORIIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_OrganizationORIIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "PassagePointMethod")
    public JAXBElement<Object> createPassagePointMethod(Object value) {
        return new JAXBElement<Object>(_PassagePointMethod_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MethodOfEntryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MethodOfEntryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "PassagePointMethodCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "PassagePointMethod")
    public JAXBElement<MethodOfEntryCodeType> createPassagePointMethodCode(MethodOfEntryCodeType value) {
        return new JAXBElement<MethodOfEntryCodeType>(_PassagePointMethodCode_QNAME, MethodOfEntryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EthnicityCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EthnicityCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "PersonEthnicityCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "PersonEthnicity")
    public JAXBElement<EthnicityCodeType> createPersonEthnicityCode(EthnicityCodeType value) {
        return new JAXBElement<EthnicityCodeType>(_PersonEthnicityCode_QNAME, EthnicityCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RACCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RACCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "PersonRaceNDExCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "PersonRace")
    public JAXBElement<RACCodeType> createPersonRaceNDExCode(RACCodeType value) {
        return new JAXBElement<RACCodeType>(_PersonRaceNDExCode_QNAME, RACCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResidentCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResidentCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "PersonResidentCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "PersonResident")
    public JAXBElement<ResidentCodeType> createPersonResidentCode(ResidentCodeType value) {
        return new JAXBElement<ResidentCodeType>(_PersonResidentCode_QNAME, ResidentCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SEXCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SEXCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "PersonSexCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "PersonSex")
    public JAXBElement<SEXCodeType> createPersonSexCode(SEXCodeType value) {
        return new JAXBElement<SEXCodeType>(_PersonSexCode_QNAME, SEXCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubjectType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SubjectType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "Subject")
    public JAXBElement<SubjectType> createSubject(SubjectType value) {
        return new JAXBElement<SubjectType>(_Subject_QNAME, SubjectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "SubjectArmedWith")
    public JAXBElement<Object> createSubjectArmedWith(Object value) {
        return new JAXBElement<Object>(_SubjectArmedWith_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArresteeWeaponCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArresteeWeaponCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "SubjectArmedWithCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "SubjectArmedWith")
    public JAXBElement<ArresteeWeaponCodeType> createSubjectArmedWithCode(ArresteeWeaponCodeType value) {
        return new JAXBElement<ArresteeWeaponCodeType>(_SubjectArmedWithCode_QNAME, ArresteeWeaponCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "SubjectSequenceNumberText")
    public JAXBElement<TextType> createSubjectSequenceNumberText(TextType value) {
        return new JAXBElement<TextType>(_SubjectSequenceNumberText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubjectVictimAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SubjectVictimAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "SubjectVictimAssociation")
    public JAXBElement<SubjectVictimAssociationType> createSubjectVictimAssociation(SubjectVictimAssociationType value) {
        return new JAXBElement<SubjectVictimAssociationType>(_SubjectVictimAssociation_QNAME, SubjectVictimAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DrugMeasurementCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DrugMeasurementCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "SubstanceUnitCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "MeasureUnit")
    public JAXBElement<DrugMeasurementCodeType> createSubstanceUnitCode(DrugMeasurementCodeType value) {
        return new JAXBElement<DrugMeasurementCodeType>(_SubstanceUnitCode_QNAME, DrugMeasurementCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VictimType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VictimType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "Victim")
    public JAXBElement<VictimType> createVictim(VictimType value) {
        return new JAXBElement<VictimType>(_Victim_QNAME, VictimType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "VictimAggravatedAssaultHomicideFactor")
    public JAXBElement<Object> createVictimAggravatedAssaultHomicideFactor(Object value) {
        return new JAXBElement<Object>(_VictimAggravatedAssaultHomicideFactor_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AggravatedAssaultHomicideFactorsCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AggravatedAssaultHomicideFactorsCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "VictimAggravatedAssaultHomicideFactorCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "VictimAggravatedAssaultHomicideFactor")
    public JAXBElement<AggravatedAssaultHomicideFactorsCodeType> createVictimAggravatedAssaultHomicideFactorCode(AggravatedAssaultHomicideFactorsCodeType value) {
        return new JAXBElement<AggravatedAssaultHomicideFactorsCodeType>(_VictimAggravatedAssaultHomicideFactorCode_QNAME, AggravatedAssaultHomicideFactorsCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "VictimCategory")
    public JAXBElement<Object> createVictimCategory(Object value) {
        return new JAXBElement<Object>(_VictimCategory_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VictimCategoryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VictimCategoryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "VictimCategoryCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "VictimCategory")
    public JAXBElement<VictimCategoryCodeType> createVictimCategoryCode(VictimCategoryCodeType value) {
        return new JAXBElement<VictimCategoryCodeType>(_VictimCategoryCode_QNAME, VictimCategoryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InjuryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InjuryType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "VictimInjury")
    public JAXBElement<InjuryType> createVictimInjury(InjuryType value) {
        return new JAXBElement<InjuryType>(_VictimInjury_QNAME, InjuryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "VictimJustifiableHomicideFactor")
    public JAXBElement<Object> createVictimJustifiableHomicideFactor(Object value) {
        return new JAXBElement<Object>(_VictimJustifiableHomicideFactor_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JustifiableHomicideFactorsCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JustifiableHomicideFactorsCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "VictimJustifiableHomicideFactorCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "VictimJustifiableHomicideFactor")
    public JAXBElement<JustifiableHomicideFactorsCodeType> createVictimJustifiableHomicideFactorCode(JustifiableHomicideFactorsCodeType value) {
        return new JAXBElement<JustifiableHomicideFactorsCodeType>(_VictimJustifiableHomicideFactorCode_QNAME, JustifiableHomicideFactorsCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "VictimSequenceNumberText")
    public JAXBElement<TextType> createVictimSequenceNumberText(TextType value) {
        return new JAXBElement<TextType>(_VictimSequenceNumberText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "VictimAugmentationPoint")
    public JAXBElement<Object> createVictimAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_VictimAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ArresteeAugmentationPoint")
    public JAXBElement<Object> createArresteeAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_ArresteeAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", name = "ArrestAugmentationPoint")
    public JAXBElement<Object> createArrestAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_ArrestAugmentationPoint_QNAME, Object.class, null, value);
    }

}
