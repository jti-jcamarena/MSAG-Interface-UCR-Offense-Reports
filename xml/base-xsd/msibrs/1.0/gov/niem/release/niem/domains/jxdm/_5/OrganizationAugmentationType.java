
package gov.niem.release.niem.domains.jxdm._5;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.niem_core._3.IdentificationType;
import gov.niem.release.niem.structures._3.AugmentationType;


/**
 * A data type for additional information about an organization.
 * 
 * <p>Java class for OrganizationAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganizationAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}OrganizationIdentification" minOccurs="0"/&gt;
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
@XmlType(name = "OrganizationAugmentationType", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", propOrder = {
    "organizationIdentification"
})
public class OrganizationAugmentationType
    extends AugmentationType
{

    @XmlElementRef(name = "OrganizationIdentification", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> organizationIdentification;

    /**
     * Gets the value of the organizationIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getOrganizationIdentification() {
        return organizationIdentification;
    }

    /**
     * Sets the value of the organizationIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setOrganizationIdentification(JAXBElement<?> value) {
        this.organizationIdentification = value;
    }

}
