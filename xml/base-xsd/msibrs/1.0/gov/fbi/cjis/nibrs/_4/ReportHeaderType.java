
package gov.fbi.cjis.nibrs._4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.fbi.cjis.nibrs.nibrs_codes._4.NIBRSReportCategoryCodeType;
import gov.fbi.cjis.nibrs.nibrs_codes._4.ReportActionCategoryCodeType;
import gov.niem.release.niem.niem_core._3.DateType;
import gov.niem.release.niem.niem_core._3.OrganizationType;
import gov.niem.release.niem.structures._3.ObjectType;


/**
 * A data type for header information for the report.
 * 
 * <p>Java class for ReportHeaderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportHeaderType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://fbi.gov/cjis/nibrs/4.2}NIBRSReportCategoryCode"/&gt;
 *         &lt;element ref="{http://fbi.gov/cjis/nibrs/4.2}ReportActionCategoryCode"/&gt;
 *         &lt;element ref="{http://fbi.gov/cjis/nibrs/4.2}ReportDate"/&gt;
 *         &lt;element ref="{http://fbi.gov/cjis/nibrs/4.2}ReportingAgency"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportHeaderType", namespace = "http://fbi.gov/cjis/nibrs/4.2", propOrder = {
    "nibrsReportCategoryCode",
    "reportActionCategoryCode",
    "reportDate",
    "reportingAgency"
})
public class ReportHeaderType
    extends ObjectType
{

    @XmlElement(name = "NIBRSReportCategoryCode", namespace = "http://fbi.gov/cjis/nibrs/4.2", required = true, nillable = true)
    protected NIBRSReportCategoryCodeType nibrsReportCategoryCode;
    @XmlElement(name = "ReportActionCategoryCode", namespace = "http://fbi.gov/cjis/nibrs/4.2", required = true, nillable = true)
    protected ReportActionCategoryCodeType reportActionCategoryCode;
    @XmlElement(name = "ReportDate", namespace = "http://fbi.gov/cjis/nibrs/4.2", required = true)
    protected DateType reportDate;
    @XmlElement(name = "ReportingAgency", namespace = "http://fbi.gov/cjis/nibrs/4.2", required = true)
    protected OrganizationType reportingAgency;

    /**
     * Gets the value of the nibrsReportCategoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link NIBRSReportCategoryCodeType }
     *     
     */
    public NIBRSReportCategoryCodeType getNIBRSReportCategoryCode() {
        return nibrsReportCategoryCode;
    }

    /**
     * Sets the value of the nibrsReportCategoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link NIBRSReportCategoryCodeType }
     *     
     */
    public void setNIBRSReportCategoryCode(NIBRSReportCategoryCodeType value) {
        this.nibrsReportCategoryCode = value;
    }

    /**
     * Gets the value of the reportActionCategoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReportActionCategoryCodeType }
     *     
     */
    public ReportActionCategoryCodeType getReportActionCategoryCode() {
        return reportActionCategoryCode;
    }

    /**
     * Sets the value of the reportActionCategoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportActionCategoryCodeType }
     *     
     */
    public void setReportActionCategoryCode(ReportActionCategoryCodeType value) {
        this.reportActionCategoryCode = value;
    }

    /**
     * Gets the value of the reportDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getReportDate() {
        return reportDate;
    }

    /**
     * Sets the value of the reportDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setReportDate(DateType value) {
        this.reportDate = value;
    }

    /**
     * Gets the value of the reportingAgency property.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationType }
     *     
     */
    public OrganizationType getReportingAgency() {
        return reportingAgency;
    }

    /**
     * Sets the value of the reportingAgency property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationType }
     *     
     */
    public void setReportingAgency(OrganizationType value) {
        this.reportingAgency = value;
    }

}
