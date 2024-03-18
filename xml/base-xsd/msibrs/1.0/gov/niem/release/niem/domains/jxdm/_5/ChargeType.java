
package gov.niem.release.niem.domains.jxdm._5;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.structures._3.ObjectType;


/**
 * A data type for a formal allegation that a specific person has committed a specific offense.
 * 
 * <p>Java class for ChargeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChargeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}ChargeUCR" minOccurs="0"/&gt;
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
@XmlType(name = "ChargeType", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", propOrder = {
    "chargeUCR"
})
public class ChargeType
    extends ObjectType
{

    @XmlElementRef(name = "ChargeUCR", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> chargeUCR;

    /**
     * Gets the value of the chargeUCR property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link gov.niem.release.niem.codes.fbi_ucr._3.OffenseCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link gov.fbi.cjis.nibrs.nibrs_codes._4.OffenseCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getChargeUCR() {
        return chargeUCR;
    }

    /**
     * Sets the value of the chargeUCR property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link gov.niem.release.niem.codes.fbi_ucr._3.OffenseCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link gov.fbi.cjis.nibrs.nibrs_codes._4.OffenseCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setChargeUCR(JAXBElement<?> value) {
        this.chargeUCR = value;
    }

}
