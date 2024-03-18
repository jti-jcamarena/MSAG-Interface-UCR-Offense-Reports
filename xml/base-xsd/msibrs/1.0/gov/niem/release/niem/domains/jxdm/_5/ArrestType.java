
package gov.niem.release.niem.domains.jxdm._5;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.codes.fbi_ucr._3.ArrestCategoryCodeType;
import gov.niem.release.niem.niem_core._3.ActivityType;


/**
 * A data type for the apprehension of a subject by a peace official.
 * 
 * <p>Java class for ArrestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/3.0/}ActivityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}ArrestCharge" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}ArrestCategory" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}ArrestAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "ArrestType", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", propOrder = {
    "arrestCharge",
    "arrestCategory",
    "arrestAugmentationPoint"
})
public class ArrestType
    extends ActivityType
{

    @XmlElement(name = "ArrestCharge", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected ChargeType arrestCharge;
    @XmlElementRef(name = "ArrestCategory", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> arrestCategory;
    @XmlElement(name = "ArrestAugmentationPoint", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<Object> arrestAugmentationPoint;

    /**
     * Gets the value of the arrestCharge property.
     * 
     * @return
     *     possible object is
     *     {@link ChargeType }
     *     
     */
    public ChargeType getArrestCharge() {
        return arrestCharge;
    }

    /**
     * Sets the value of the arrestCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeType }
     *     
     */
    public void setArrestCharge(ChargeType value) {
        this.arrestCharge = value;
    }

    /**
     * Gets the value of the arrestCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrestCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getArrestCategory() {
        return arrestCategory;
    }

    /**
     * Sets the value of the arrestCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrestCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setArrestCategory(JAXBElement<?> value) {
        this.arrestCategory = value;
    }

    /**
     * Gets the value of the arrestAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arrestAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArrestAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getArrestAugmentationPoint() {
        if (arrestAugmentationPoint == null) {
            arrestAugmentationPoint = new ArrayList<Object>();
        }
        return this.arrestAugmentationPoint;
    }

}
