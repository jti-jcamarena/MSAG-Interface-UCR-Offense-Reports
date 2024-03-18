
package gov.niem.release.niem.niem_core._3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.codes.fbi_ucr._3.InjuryCategoryCodeType;
import gov.niem.release.niem.structures._3.ObjectType;


/**
 * A data type for a form of harm or damage sustained by a person.
 * 
 * <p>Java class for InjuryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InjuryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}InjuryCategory" minOccurs="0"/&gt;
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
@XmlType(name = "InjuryType", namespace = "http://release.niem.gov/niem/niem-core/3.0/", propOrder = {
    "injuryCategory"
})
public class InjuryType
    extends ObjectType
{

    @XmlElementRef(name = "InjuryCategory", namespace = "http://release.niem.gov/niem/niem-core/3.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> injuryCategory;

    /**
     * Gets the value of the injuryCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link InjuryCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getInjuryCategory() {
        return injuryCategory;
    }

    /**
     * Sets the value of the injuryCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link InjuryCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setInjuryCategory(JAXBElement<?> value) {
        this.injuryCategory = value;
    }

}
