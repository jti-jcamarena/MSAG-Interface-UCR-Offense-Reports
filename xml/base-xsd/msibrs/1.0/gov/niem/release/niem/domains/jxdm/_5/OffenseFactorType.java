
package gov.niem.release.niem.domains.jxdm._5;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.codes.fbi_ucr._3.IncidentFactorCodeType;
import gov.niem.release.niem.structures._3.ObjectType;


/**
 * A data type for a set of details about a circumstance or factor that has an effect on an offense.
 * 
 * <p>Java class for OffenseFactorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OffenseFactorType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}OffenseFactorDesignation" minOccurs="0"/&gt;
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
@XmlType(name = "OffenseFactorType", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", propOrder = {
    "offenseFactorDesignation"
})
public class OffenseFactorType
    extends ObjectType
{

    @XmlElementRef(name = "OffenseFactorDesignation", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> offenseFactorDesignation;

    /**
     * Gets the value of the offenseFactorDesignation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IncidentFactorCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getOffenseFactorDesignation() {
        return offenseFactorDesignation;
    }

    /**
     * Sets the value of the offenseFactorDesignation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IncidentFactorCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setOffenseFactorDesignation(JAXBElement<?> value) {
        this.offenseFactorDesignation = value;
    }

}
