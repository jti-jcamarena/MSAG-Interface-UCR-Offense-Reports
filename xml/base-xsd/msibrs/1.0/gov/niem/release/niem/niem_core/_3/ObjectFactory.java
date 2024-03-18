
package gov.niem.release.niem.niem_core._3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import gov.niem.release.niem.proxy.xsd._3.Date;
import gov.niem.release.niem.proxy.xsd._3.DateTime;
import gov.niem.release.niem.proxy.xsd._3.Decimal;
import gov.niem.release.niem.proxy.xsd._3.GYearMonth;
import gov.niem.release.niem.proxy.xsd._3.Integer;
import gov.niem.release.niem.proxy.xsd._3.String;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gov.niem.release.niem.niem_core._3 package. 
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

    private final static QName _LocationCategory_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "LocationCategory");
    private final static QName _IncidentAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "IncidentAugmentationPoint");
    private final static QName _StatusDesignator_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "StatusDesignator");
    private final static QName _OrganizationAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "OrganizationAugmentationPoint");
    private final static QName _SubstanceCategory_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "SubstanceCategory");
    private final static QName _InjuryCategory_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "InjuryCategory");
    private final static QName _ItemCategory_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "ItemCategory");
    private final static QName _PersonEthnicity_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "PersonEthnicity");
    private final static QName _PersonRace_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "PersonRace");
    private final static QName _PersonResident_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "PersonResident");
    private final static QName _PersonSex_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "PersonSex");
    private final static QName _MeasureUnit_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "MeasureUnit");
    private final static QName _Activity_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "Activity");
    private final static QName _ActivityDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "ActivityDate");
    private final static QName _ActivityDateRepresentation_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "ActivityDateRepresentation");
    private final static QName _ActivityIdentification_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "ActivityIdentification");
    private final static QName _Amount_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "Amount");
    private final static QName _Date_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "Date");
    private final static QName _DateRepresentation_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "DateRepresentation");
    private final static QName _DateTime_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "DateTime");
    private final static QName _IdentificationID_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "IdentificationID");
    private final static QName _Incident_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "Incident");
    private final static QName _Item_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "Item");
    private final static QName _ItemQuantity_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "ItemQuantity");
    private final static QName _ItemStatus_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "ItemStatus");
    private final static QName _ItemValue_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "ItemValue");
    private final static QName _ItemValueAmount_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "ItemValueAmount");
    private final static QName _ItemValueDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "ItemValueDate");
    private final static QName _Location_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "Location");
    private final static QName _MeasureDecimalValue_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "MeasureDecimalValue");
    private final static QName _MeasurePoint_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "MeasurePoint");
    private final static QName _MeasureValue_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "MeasureValue");
    private final static QName _MeasureIntegerRange_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "MeasureIntegerRange");
    private final static QName _MeasureRange_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "MeasureRange");
    private final static QName _MeasureIntegerValue_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "MeasureIntegerValue");
    private final static QName _MeasureValueList_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "MeasureValueList");
    private final static QName _MeasureValueText_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "MeasureValueText");
    private final static QName _Person_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "Person");
    private final static QName _PersonAgeMeasure_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "PersonAgeMeasure");
    private final static QName _PersonAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "PersonAugmentationPoint");
    private final static QName _RangeMaximumIntegerValue_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "RangeMaximumIntegerValue");
    private final static QName _RangeMinimumIntegerValue_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "RangeMinimumIntegerValue");
    private final static QName _RoleOf_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "RoleOf");
    private final static QName _RoleOfPerson_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "RoleOfPerson");
    private final static QName _StatusAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "StatusAugmentationPoint");
    private final static QName _StatusDescriptionText_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "StatusDescriptionText");
    private final static QName _Substance_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "Substance");
    private final static QName _SubstanceQuantityMeasure_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "SubstanceQuantityMeasure");
    private final static QName _YearMonthDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "YearMonthDate");
    private final static QName _ItemAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/niem-core/3.0/", "ItemAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gov.niem.release.niem.niem_core._3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DateType }
     * 
     */
    public DateType createDateType() {
        return new DateType();
    }

    /**
     * Create an instance of {@link OrganizationType }
     * 
     */
    public OrganizationType createOrganizationType() {
        return new OrganizationType();
    }

    /**
     * Create an instance of {@link IdentificationType }
     * 
     */
    public IdentificationType createIdentificationType() {
        return new IdentificationType();
    }

    /**
     * Create an instance of {@link TextType }
     * 
     */
    public TextType createTextType() {
        return new TextType();
    }

    /**
     * Create an instance of {@link QuantityType }
     * 
     */
    public QuantityType createQuantityType() {
        return new QuantityType();
    }

    /**
     * Create an instance of {@link InjuryType }
     * 
     */
    public InjuryType createInjuryType() {
        return new InjuryType();
    }

    /**
     * Create an instance of {@link ActivityType }
     * 
     */
    public ActivityType createActivityType() {
        return new ActivityType();
    }

    /**
     * Create an instance of {@link IncidentType }
     * 
     */
    public IncidentType createIncidentType() {
        return new IncidentType();
    }

    /**
     * Create an instance of {@link ItemType }
     * 
     */
    public ItemType createItemType() {
        return new ItemType();
    }

    /**
     * Create an instance of {@link StatusType }
     * 
     */
    public StatusType createStatusType() {
        return new StatusType();
    }

    /**
     * Create an instance of {@link ItemValueType }
     * 
     */
    public ItemValueType createItemValueType() {
        return new ItemValueType();
    }

    /**
     * Create an instance of {@link AmountType }
     * 
     */
    public AmountType createAmountType() {
        return new AmountType();
    }

    /**
     * Create an instance of {@link LocationType }
     * 
     */
    public LocationType createLocationType() {
        return new LocationType();
    }

    /**
     * Create an instance of {@link IntegerRangeType }
     * 
     */
    public IntegerRangeType createIntegerRangeType() {
        return new IntegerRangeType();
    }

    /**
     * Create an instance of {@link PersonType }
     * 
     */
    public PersonType createPersonType() {
        return new PersonType();
    }

    /**
     * Create an instance of {@link MeasureType }
     * 
     */
    public MeasureType createMeasureType() {
        return new MeasureType();
    }

    /**
     * Create an instance of {@link SubstanceType }
     * 
     */
    public SubstanceType createSubstanceType() {
        return new SubstanceType();
    }

    /**
     * Create an instance of {@link ActivityPersonAssociationType }
     * 
     */
    public ActivityPersonAssociationType createActivityPersonAssociationType() {
        return new ActivityPersonAssociationType();
    }

    /**
     * Create an instance of {@link AssociationType }
     * 
     */
    public AssociationType createAssociationType() {
        return new AssociationType();
    }

    /**
     * Create an instance of {@link NumericType }
     * 
     */
    public NumericType createNumericType() {
        return new NumericType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "LocationCategory")
    public JAXBElement<Object> createLocationCategory(Object value) {
        return new JAXBElement<Object>(_LocationCategory_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "IncidentAugmentationPoint")
    public JAXBElement<Object> createIncidentAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_IncidentAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "StatusDesignator")
    public JAXBElement<Object> createStatusDesignator(Object value) {
        return new JAXBElement<Object>(_StatusDesignator_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "OrganizationAugmentationPoint")
    public JAXBElement<Object> createOrganizationAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_OrganizationAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "SubstanceCategory")
    public JAXBElement<Object> createSubstanceCategory(Object value) {
        return new JAXBElement<Object>(_SubstanceCategory_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "InjuryCategory")
    public JAXBElement<Object> createInjuryCategory(Object value) {
        return new JAXBElement<Object>(_InjuryCategory_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "ItemCategory")
    public JAXBElement<Object> createItemCategory(Object value) {
        return new JAXBElement<Object>(_ItemCategory_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "PersonEthnicity")
    public JAXBElement<Object> createPersonEthnicity(Object value) {
        return new JAXBElement<Object>(_PersonEthnicity_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "PersonRace")
    public JAXBElement<Object> createPersonRace(Object value) {
        return new JAXBElement<Object>(_PersonRace_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "PersonResident")
    public JAXBElement<Object> createPersonResident(Object value) {
        return new JAXBElement<Object>(_PersonResident_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "PersonSex")
    public JAXBElement<Object> createPersonSex(Object value) {
        return new JAXBElement<Object>(_PersonSex_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "MeasureUnit")
    public JAXBElement<Object> createMeasureUnit(Object value) {
        return new JAXBElement<Object>(_MeasureUnit_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ActivityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "Activity")
    public JAXBElement<ActivityType> createActivity(ActivityType value) {
        return new JAXBElement<ActivityType>(_Activity_QNAME, ActivityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "ActivityDate", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "ActivityDateRepresentation")
    public JAXBElement<DateType> createActivityDate(DateType value) {
        return new JAXBElement<DateType>(_ActivityDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "ActivityDateRepresentation")
    public JAXBElement<Object> createActivityDateRepresentation(Object value) {
        return new JAXBElement<Object>(_ActivityDateRepresentation_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "ActivityIdentification")
    public JAXBElement<IdentificationType> createActivityIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_ActivityIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Decimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Decimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "Amount")
    public JAXBElement<Decimal> createAmount(Decimal value) {
        return new JAXBElement<Decimal>(_Amount_QNAME, Decimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Date }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Date }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "Date", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "DateRepresentation")
    public JAXBElement<Date> createDate(Date value) {
        return new JAXBElement<Date>(_Date_QNAME, Date.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "DateRepresentation")
    public JAXBElement<Object> createDateRepresentation(Object value) {
        return new JAXBElement<Object>(_DateRepresentation_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "DateTime", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "DateRepresentation")
    public JAXBElement<DateTime> createDateTime(DateTime value) {
        return new JAXBElement<DateTime>(_DateTime_QNAME, DateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "IdentificationID")
    public JAXBElement<String> createIdentificationID(String value) {
        return new JAXBElement<String>(_IdentificationID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncidentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IncidentType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "Incident")
    public JAXBElement<IncidentType> createIncident(IncidentType value) {
        return new JAXBElement<IncidentType>(_Incident_QNAME, IncidentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ItemType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "Item")
    public JAXBElement<ItemType> createItem(ItemType value) {
        return new JAXBElement<ItemType>(_Item_QNAME, ItemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuantityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QuantityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "ItemQuantity")
    public JAXBElement<QuantityType> createItemQuantity(QuantityType value) {
        return new JAXBElement<QuantityType>(_ItemQuantity_QNAME, QuantityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatusType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "ItemStatus")
    public JAXBElement<StatusType> createItemStatus(StatusType value) {
        return new JAXBElement<StatusType>(_ItemStatus_QNAME, StatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemValueType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ItemValueType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "ItemValue")
    public JAXBElement<ItemValueType> createItemValue(ItemValueType value) {
        return new JAXBElement<ItemValueType>(_ItemValue_QNAME, ItemValueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "ItemValueAmount")
    public JAXBElement<AmountType> createItemValueAmount(AmountType value) {
        return new JAXBElement<AmountType>(_ItemValueAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "ItemValueDate")
    public JAXBElement<DateType> createItemValueDate(DateType value) {
        return new JAXBElement<DateType>(_ItemValueDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "Location")
    public JAXBElement<LocationType> createLocation(LocationType value) {
        return new JAXBElement<LocationType>(_Location_QNAME, LocationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Decimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Decimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "MeasureDecimalValue", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "MeasurePoint")
    public JAXBElement<Decimal> createMeasureDecimalValue(Decimal value) {
        return new JAXBElement<Decimal>(_MeasureDecimalValue_QNAME, Decimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "MeasurePoint", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "MeasureValue")
    public JAXBElement<Object> createMeasurePoint(Object value) {
        return new JAXBElement<Object>(_MeasurePoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "MeasureValue")
    public JAXBElement<Object> createMeasureValue(Object value) {
        return new JAXBElement<Object>(_MeasureValue_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntegerRangeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IntegerRangeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "MeasureIntegerRange", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "MeasureRange")
    public JAXBElement<IntegerRangeType> createMeasureIntegerRange(IntegerRangeType value) {
        return new JAXBElement<IntegerRangeType>(_MeasureIntegerRange_QNAME, IntegerRangeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "MeasureRange", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "MeasureValue")
    public JAXBElement<Object> createMeasureRange(Object value) {
        return new JAXBElement<Object>(_MeasureRange_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "MeasureIntegerValue", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "MeasurePoint")
    public JAXBElement<Integer> createMeasureIntegerValue(Integer value) {
        return new JAXBElement<Integer>(_MeasureIntegerValue_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "MeasureValueList", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "MeasureValue")
    public JAXBElement<Object> createMeasureValueList(Object value) {
        return new JAXBElement<Object>(_MeasureValueList_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "MeasureValueText", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "MeasureValue")
    public JAXBElement<TextType> createMeasureValueText(TextType value) {
        return new JAXBElement<TextType>(_MeasureValueText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "Person")
    public JAXBElement<PersonType> createPerson(PersonType value) {
        return new JAXBElement<PersonType>(_Person_QNAME, PersonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "PersonAgeMeasure")
    public JAXBElement<MeasureType> createPersonAgeMeasure(MeasureType value) {
        return new JAXBElement<MeasureType>(_PersonAgeMeasure_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "PersonAugmentationPoint")
    public JAXBElement<Object> createPersonAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_PersonAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "RangeMaximumIntegerValue")
    public JAXBElement<Integer> createRangeMaximumIntegerValue(Integer value) {
        return new JAXBElement<Integer>(_RangeMaximumIntegerValue_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "RangeMinimumIntegerValue")
    public JAXBElement<Integer> createRangeMinimumIntegerValue(Integer value) {
        return new JAXBElement<Integer>(_RangeMinimumIntegerValue_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "RoleOf")
    public JAXBElement<Object> createRoleOf(Object value) {
        return new JAXBElement<Object>(_RoleOf_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "RoleOfPerson", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "RoleOf")
    public JAXBElement<PersonType> createRoleOfPerson(PersonType value) {
        return new JAXBElement<PersonType>(_RoleOfPerson_QNAME, PersonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "StatusAugmentationPoint")
    public JAXBElement<Object> createStatusAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_StatusAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "StatusDescriptionText")
    public JAXBElement<TextType> createStatusDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_StatusDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubstanceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SubstanceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "Substance")
    public JAXBElement<SubstanceType> createSubstance(SubstanceType value) {
        return new JAXBElement<SubstanceType>(_Substance_QNAME, SubstanceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "SubstanceQuantityMeasure")
    public JAXBElement<MeasureType> createSubstanceQuantityMeasure(MeasureType value) {
        return new JAXBElement<MeasureType>(_SubstanceQuantityMeasure_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GYearMonth }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GYearMonth }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "YearMonthDate", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "DateRepresentation")
    public JAXBElement<GYearMonth> createYearMonthDate(GYearMonth value) {
        return new JAXBElement<GYearMonth>(_YearMonthDate_QNAME, GYearMonth.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/3.0/", name = "ItemAugmentationPoint")
    public JAXBElement<Object> createItemAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_ItemAugmentationPoint_QNAME, Object.class, null, value);
    }

}
