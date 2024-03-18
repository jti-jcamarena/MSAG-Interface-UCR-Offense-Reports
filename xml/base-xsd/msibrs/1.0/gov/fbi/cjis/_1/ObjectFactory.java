
package gov.fbi.cjis._1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import gov.fbi.cjis.cjis_codes._1.ItemStatusCodeType;
import gov.niem.release.niem.niem_core._3.IdentificationType;
import gov.niem.release.niem.niem_core._3.OrganizationType;
import gov.niem.release.niem.niem_core._3.TextType;
import gov.niem.release.niem.proxy.xsd._3.Boolean;
import gov.niem.release.niem.proxy.xsd._3.DateTime;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gov.fbi.cjis._1 package. 
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

    private final static QName _DirectReportingCityIdentification_QNAME = new QName("http://fbi.gov/cjis/1.0", "DirectReportingCityIdentification");
    private final static QName _IncidentAugmentation_QNAME = new QName("http://fbi.gov/cjis/1.0", "IncidentAugmentation");
    private final static QName _IncidentReportDateIndicator_QNAME = new QName("http://fbi.gov/cjis/1.0", "IncidentReportDateIndicator");
    private final static QName _ItemStatusCode_QNAME = new QName("http://fbi.gov/cjis/1.0", "ItemStatusCode");
    private final static QName _MessageMetadata_QNAME = new QName("http://fbi.gov/cjis/1.0", "MessageMetadata");
    private final static QName _MessageDateTime_QNAME = new QName("http://fbi.gov/cjis/1.0", "MessageDateTime");
    private final static QName _MessageIdentification_QNAME = new QName("http://fbi.gov/cjis/1.0", "MessageIdentification");
    private final static QName _MessageImplementationVersion_QNAME = new QName("http://fbi.gov/cjis/1.0", "MessageImplementationVersion");
    private final static QName _MessageSubmittingOrganization_QNAME = new QName("http://fbi.gov/cjis/1.0", "MessageSubmittingOrganization");
    private final static QName _OrganizationAugmentation_QNAME = new QName("http://fbi.gov/cjis/1.0", "OrganizationAugmentation");
    private final static QName _SubjectAugmentation_QNAME = new QName("http://fbi.gov/cjis/1.0", "SubjectAugmentation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gov.fbi.cjis._1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IncidentAugmentationType }
     * 
     */
    public IncidentAugmentationType createIncidentAugmentationType() {
        return new IncidentAugmentationType();
    }

    /**
     * Create an instance of {@link MessageMetadataType }
     * 
     */
    public MessageMetadataType createMessageMetadataType() {
        return new MessageMetadataType();
    }

    /**
     * Create an instance of {@link OrganizationAugmentationType }
     * 
     */
    public OrganizationAugmentationType createOrganizationAugmentationType() {
        return new OrganizationAugmentationType();
    }

    /**
     * Create an instance of {@link SubjectAugmentationType }
     * 
     */
    public SubjectAugmentationType createSubjectAugmentationType() {
        return new SubjectAugmentationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/1.0", name = "DirectReportingCityIdentification")
    public JAXBElement<IdentificationType> createDirectReportingCityIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_DirectReportingCityIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncidentAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IncidentAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/1.0", name = "IncidentAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "IncidentAugmentationPoint")
    public JAXBElement<IncidentAugmentationType> createIncidentAugmentation(IncidentAugmentationType value) {
        return new JAXBElement<IncidentAugmentationType>(_IncidentAugmentation_QNAME, IncidentAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/1.0", name = "IncidentReportDateIndicator")
    public JAXBElement<Boolean> createIncidentReportDateIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_IncidentReportDateIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemStatusCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ItemStatusCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/1.0", name = "ItemStatusCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "StatusDesignator")
    public JAXBElement<ItemStatusCodeType> createItemStatusCode(ItemStatusCodeType value) {
        return new JAXBElement<ItemStatusCodeType>(_ItemStatusCode_QNAME, ItemStatusCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageMetadataType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MessageMetadataType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/1.0", name = "MessageMetadata")
    public JAXBElement<MessageMetadataType> createMessageMetadata(MessageMetadataType value) {
        return new JAXBElement<MessageMetadataType>(_MessageMetadata_QNAME, MessageMetadataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/1.0", name = "MessageDateTime")
    public JAXBElement<DateTime> createMessageDateTime(DateTime value) {
        return new JAXBElement<DateTime>(_MessageDateTime_QNAME, DateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/1.0", name = "MessageIdentification")
    public JAXBElement<IdentificationType> createMessageIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_MessageIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/1.0", name = "MessageImplementationVersion")
    public JAXBElement<TextType> createMessageImplementationVersion(TextType value) {
        return new JAXBElement<TextType>(_MessageImplementationVersion_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/1.0", name = "MessageSubmittingOrganization")
    public JAXBElement<OrganizationType> createMessageSubmittingOrganization(OrganizationType value) {
        return new JAXBElement<OrganizationType>(_MessageSubmittingOrganization_QNAME, OrganizationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/1.0", name = "OrganizationAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "OrganizationAugmentationPoint")
    public JAXBElement<OrganizationAugmentationType> createOrganizationAugmentation(OrganizationAugmentationType value) {
        return new JAXBElement<OrganizationAugmentationType>(_OrganizationAugmentation_QNAME, OrganizationAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SubjectAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/1.0", name = "SubjectAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "SubjectAugmentationPoint")
    public JAXBElement<SubjectAugmentationType> createSubjectAugmentation(SubjectAugmentationType value) {
        return new JAXBElement<SubjectAugmentationType>(_SubjectAugmentation_QNAME, SubjectAugmentationType.class, null, value);
    }

}
