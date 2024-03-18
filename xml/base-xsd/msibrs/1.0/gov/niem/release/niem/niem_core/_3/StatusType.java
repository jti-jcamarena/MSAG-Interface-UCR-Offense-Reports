
package gov.niem.release.niem.niem_core._3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.fbi.cjis.cjis_codes._1.ItemStatusCodeType;
import gov.niem.release.niem.structures._3.ObjectType;


/**
 * A data type for a state of something or someone.
 * 
 * <p>Java class for StatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatusType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}StatusDesignator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}StatusDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}StatusAugmentationPoint" minOccurs="0"/&gt;
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
@XmlType(name = "StatusType", namespace = "http://release.niem.gov/niem/niem-core/3.0/", propOrder = {
    "statusDesignator",
    "statusDescriptionText",
    "statusAugmentationPoint"
})
public class StatusType
    extends ObjectType
{

    @XmlElementRef(name = "StatusDesignator", namespace = "http://release.niem.gov/niem/niem-core/3.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> statusDesignator;
    @XmlElement(name = "StatusDescriptionText", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected TextType statusDescriptionText;
    @XmlElement(name = "StatusAugmentationPoint", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected Object statusAugmentationPoint;

    /**
     * Gets the value of the statusDesignator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ItemStatusCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getStatusDesignator() {
        return statusDesignator;
    }

    /**
     * Sets the value of the statusDesignator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ItemStatusCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setStatusDesignator(JAXBElement<?> value) {
        this.statusDesignator = value;
    }

    /**
     * Gets the value of the statusDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getStatusDescriptionText() {
        return statusDescriptionText;
    }

    /**
     * Sets the value of the statusDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setStatusDescriptionText(TextType value) {
        this.statusDescriptionText = value;
    }

    /**
     * Gets the value of the statusAugmentationPoint property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getStatusAugmentationPoint() {
        return statusAugmentationPoint;
    }

    /**
     * Sets the value of the statusAugmentationPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setStatusAugmentationPoint(Object value) {
        this.statusAugmentationPoint = value;
    }

}
