
package gov.niem.release.niem.domains.jxdm._5;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.codes.fbi_ndex._3.JuvenileDispositionCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.ArresteeWeaponCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.MultipleArresteeSegmentsCodeType;
import gov.niem.release.niem.proxy.xsd._3.Boolean;
import gov.niem.release.niem.proxy.xsd._3.String;


/**
 * A data type for a person who is arrested for a violation of a criminal statute, ordinance or rule.
 * 
 * <p>Java class for ArresteeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArresteeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/domains/jxdm/5.2/}SubjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}ArrestSequenceID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}ArresteeClearanceIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}ArresteeArmedWith" maxOccurs="2" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}ArresteeJuvenileDisposition" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}ArrestSubjectCount" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}ArresteeAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "ArresteeType", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", propOrder = {
    "arrestSequenceID",
    "arresteeClearanceIndicator",
    "arresteeArmedWith",
    "arresteeJuvenileDisposition",
    "arrestSubjectCount",
    "arresteeAugmentationPoint"
})
public class ArresteeType
    extends SubjectType
{

    @XmlElement(name = "ArrestSequenceID", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected String arrestSequenceID;
    @XmlElement(name = "ArresteeClearanceIndicator", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected Boolean arresteeClearanceIndicator;
    @XmlElementRef(name = "ArresteeArmedWith", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> arresteeArmedWith;
    @XmlElementRef(name = "ArresteeJuvenileDisposition", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> arresteeJuvenileDisposition;
    @XmlElementRef(name = "ArrestSubjectCount", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> arrestSubjectCount;
    @XmlElement(name = "ArresteeAugmentationPoint", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<Object> arresteeAugmentationPoint;

    /**
     * Gets the value of the arrestSequenceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrestSequenceID() {
        return arrestSequenceID;
    }

    /**
     * Sets the value of the arrestSequenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrestSequenceID(String value) {
        this.arrestSequenceID = value;
    }

    /**
     * Gets the value of the arresteeClearanceIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getArresteeClearanceIndicator() {
        return arresteeClearanceIndicator;
    }

    /**
     * Sets the value of the arresteeClearanceIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setArresteeClearanceIndicator(Boolean value) {
        this.arresteeClearanceIndicator = value;
    }

    /**
     * Gets the value of the arresteeArmedWith property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arresteeArmedWith property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArresteeArmedWith().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ArresteeWeaponCodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getArresteeArmedWith() {
        if (arresteeArmedWith == null) {
            arresteeArmedWith = new ArrayList<JAXBElement<?>>();
        }
        return this.arresteeArmedWith;
    }

    /**
     * Gets the value of the arresteeJuvenileDisposition property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link JuvenileDispositionCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getArresteeJuvenileDisposition() {
        return arresteeJuvenileDisposition;
    }

    /**
     * Sets the value of the arresteeJuvenileDisposition property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link JuvenileDispositionCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setArresteeJuvenileDisposition(JAXBElement<?> value) {
        this.arresteeJuvenileDisposition = value;
    }

    /**
     * Gets the value of the arrestSubjectCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MultipleArresteeSegmentsCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getArrestSubjectCount() {
        return arrestSubjectCount;
    }

    /**
     * Sets the value of the arrestSubjectCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MultipleArresteeSegmentsCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setArrestSubjectCount(JAXBElement<?> value) {
        this.arrestSubjectCount = value;
    }

    /**
     * Gets the value of the arresteeAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arresteeAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArresteeAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getArresteeAugmentationPoint() {
        if (arresteeAugmentationPoint == null) {
            arresteeAugmentationPoint = new ArrayList<Object>();
        }
        return this.arresteeAugmentationPoint;
    }

}
