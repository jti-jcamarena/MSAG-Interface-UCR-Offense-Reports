
package gov.fbi.cjis.nibrs._4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import gov.fbi.cjis.nibrs.nibrs_codes._4.CriminalActivityCategoryCodeType;
import gov.fbi.cjis.nibrs.nibrs_codes._4.LocationCategoryCodeType;
import gov.fbi.cjis.nibrs.nibrs_codes._4.NIBRSReportCategoryCodeType;
import gov.fbi.cjis.nibrs.nibrs_codes._4.OffenseCodeType;
import gov.fbi.cjis.nibrs.nibrs_codes._4.ReportActionCategoryCodeType;
import gov.fbi.cjis.nibrs.nibrs_codes._4.VictimToSubjectRelationshipCodeType;
import gov.niem.release.niem.niem_core._3.DateType;
import gov.niem.release.niem.niem_core._3.OrganizationType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gov.fbi.cjis.nibrs._4 package. 
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

    private final static QName _VictimToSubjectRelationshipCode_QNAME = new QName("http://fbi.gov/cjis/nibrs/4.2", "VictimToSubjectRelationshipCode");
    private final static QName _ChargeUCRCode_QNAME = new QName("http://fbi.gov/cjis/nibrs/4.2", "ChargeUCRCode");
    private final static QName _CriminalActivityCategoryCode_QNAME = new QName("http://fbi.gov/cjis/nibrs/4.2", "CriminalActivityCategoryCode");
    private final static QName _LocationCategoryCode_QNAME = new QName("http://fbi.gov/cjis/nibrs/4.2", "LocationCategoryCode");
    private final static QName _NIBRSReportCategoryCode_QNAME = new QName("http://fbi.gov/cjis/nibrs/4.2", "NIBRSReportCategoryCode");
    private final static QName _OffenseUCRCode_QNAME = new QName("http://fbi.gov/cjis/nibrs/4.2", "OffenseUCRCode");
    private final static QName _Report_QNAME = new QName("http://fbi.gov/cjis/nibrs/4.2", "Report");
    private final static QName _ReportActionCategoryCode_QNAME = new QName("http://fbi.gov/cjis/nibrs/4.2", "ReportActionCategoryCode");
    private final static QName _ReportDate_QNAME = new QName("http://fbi.gov/cjis/nibrs/4.2", "ReportDate");
    private final static QName _ReportingAgency_QNAME = new QName("http://fbi.gov/cjis/nibrs/4.2", "ReportingAgency");
    private final static QName _ReportHeader_QNAME = new QName("http://fbi.gov/cjis/nibrs/4.2", "ReportHeader");
    private final static QName _Submission_QNAME = new QName("http://fbi.gov/cjis/nibrs/4.2", "Submission");
    private final static QName _ReportAugmentationPoint_QNAME = new QName("http://fbi.gov/cjis/nibrs/4.2", "ReportAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gov.fbi.cjis.nibrs._4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReportType }
     * 
     */
    public ReportType createReportType() {
        return new ReportType();
    }

    /**
     * Create an instance of {@link ReportHeaderType }
     * 
     */
    public ReportHeaderType createReportHeaderType() {
        return new ReportHeaderType();
    }

    /**
     * Create an instance of {@link SubmissionType }
     * 
     */
    public SubmissionType createSubmissionType() {
        return new SubmissionType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VictimToSubjectRelationshipCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VictimToSubjectRelationshipCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/nibrs/4.2", name = "VictimToSubjectRelationshipCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "VictimToSubjectRelationship")
    public JAXBElement<VictimToSubjectRelationshipCodeType> createVictimToSubjectRelationshipCode(VictimToSubjectRelationshipCodeType value) {
        return new JAXBElement<VictimToSubjectRelationshipCodeType>(_VictimToSubjectRelationshipCode_QNAME, VictimToSubjectRelationshipCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OffenseCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OffenseCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/nibrs/4.2", name = "ChargeUCRCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "ChargeUCR")
    public JAXBElement<OffenseCodeType> createChargeUCRCode(OffenseCodeType value) {
        return new JAXBElement<OffenseCodeType>(_ChargeUCRCode_QNAME, OffenseCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriminalActivityCategoryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CriminalActivityCategoryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/nibrs/4.2", name = "CriminalActivityCategoryCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "CriminalActivityCategory")
    public JAXBElement<CriminalActivityCategoryCodeType> createCriminalActivityCategoryCode(CriminalActivityCategoryCodeType value) {
        return new JAXBElement<CriminalActivityCategoryCodeType>(_CriminalActivityCategoryCode_QNAME, CriminalActivityCategoryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationCategoryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LocationCategoryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/nibrs/4.2", name = "LocationCategoryCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/3.0/", substitutionHeadName = "LocationCategory")
    public JAXBElement<LocationCategoryCodeType> createLocationCategoryCode(LocationCategoryCodeType value) {
        return new JAXBElement<LocationCategoryCodeType>(_LocationCategoryCode_QNAME, LocationCategoryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NIBRSReportCategoryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NIBRSReportCategoryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/nibrs/4.2", name = "NIBRSReportCategoryCode")
    public JAXBElement<NIBRSReportCategoryCodeType> createNIBRSReportCategoryCode(NIBRSReportCategoryCodeType value) {
        return new JAXBElement<NIBRSReportCategoryCodeType>(_NIBRSReportCategoryCode_QNAME, NIBRSReportCategoryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OffenseCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OffenseCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/nibrs/4.2", name = "OffenseUCRCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", substitutionHeadName = "OffenseDesignation")
    public JAXBElement<OffenseCodeType> createOffenseUCRCode(OffenseCodeType value) {
        return new JAXBElement<OffenseCodeType>(_OffenseUCRCode_QNAME, OffenseCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReportType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/nibrs/4.2", name = "Report")
    public JAXBElement<ReportType> createReport(ReportType value) {
        return new JAXBElement<ReportType>(_Report_QNAME, ReportType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportActionCategoryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReportActionCategoryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/nibrs/4.2", name = "ReportActionCategoryCode")
    public JAXBElement<ReportActionCategoryCodeType> createReportActionCategoryCode(ReportActionCategoryCodeType value) {
        return new JAXBElement<ReportActionCategoryCodeType>(_ReportActionCategoryCode_QNAME, ReportActionCategoryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/nibrs/4.2", name = "ReportDate")
    public JAXBElement<DateType> createReportDate(DateType value) {
        return new JAXBElement<DateType>(_ReportDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/nibrs/4.2", name = "ReportingAgency")
    public JAXBElement<OrganizationType> createReportingAgency(OrganizationType value) {
        return new JAXBElement<OrganizationType>(_ReportingAgency_QNAME, OrganizationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportHeaderType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReportHeaderType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/nibrs/4.2", name = "ReportHeader")
    public JAXBElement<ReportHeaderType> createReportHeader(ReportHeaderType value) {
        return new JAXBElement<ReportHeaderType>(_ReportHeader_QNAME, ReportHeaderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmissionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SubmissionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/nibrs/4.2", name = "Submission")
    public JAXBElement<SubmissionType> createSubmission(SubmissionType value) {
        return new JAXBElement<SubmissionType>(_Submission_QNAME, SubmissionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://fbi.gov/cjis/nibrs/4.2", name = "ReportAugmentationPoint")
    public JAXBElement<Object> createReportAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_ReportAugmentationPoint_QNAME, Object.class, null, value);
    }

}
