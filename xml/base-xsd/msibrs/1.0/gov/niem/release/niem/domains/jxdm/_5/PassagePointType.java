
package gov.niem.release.niem.domains.jxdm._5;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.codes.fbi_ucr._3.MethodOfEntryCodeType;
import gov.niem.release.niem.niem_core._3.ActivityType;


/**
 * A data type for a point of entry or a point of exit to a location or structure.
 * 
 * <p>Java class for PassagePointType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PassagePointType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/3.0/}ActivityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}PassagePointMethod" minOccurs="0"/&gt;
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
@XmlType(name = "PassagePointType", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", propOrder = {
    "passagePointMethod"
})
public class PassagePointType
    extends ActivityType
{

    @XmlElementRef(name = "PassagePointMethod", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> passagePointMethod;

    /**
     * Gets the value of the passagePointMethod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MethodOfEntryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getPassagePointMethod() {
        return passagePointMethod;
    }

    /**
     * Sets the value of the passagePointMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MethodOfEntryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setPassagePointMethod(JAXBElement<?> value) {
        this.passagePointMethod = value;
    }

}
