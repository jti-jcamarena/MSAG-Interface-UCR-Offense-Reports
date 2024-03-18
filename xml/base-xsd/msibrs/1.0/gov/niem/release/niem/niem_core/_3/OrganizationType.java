
package gov.niem.release.niem.niem_core._3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.domains.jxdm._5.EnforcementUnitType;
import gov.niem.release.niem.structures._3.ObjectType;


/**
 * A data type for a body of people organized for a particular purpose.
 * 
 * <p>Java class for OrganizationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganizationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}OrganizationAugmentationPoint" minOccurs="0"/&gt;
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
@XmlType(name = "OrganizationType", namespace = "http://release.niem.gov/niem/niem-core/3.0/", propOrder = {
    "organizationAugmentationPoint"
})
@XmlSeeAlso({
    EnforcementUnitType.class
})
public class OrganizationType
    extends ObjectType
{

    @XmlElementRef(name = "OrganizationAugmentationPoint", namespace = "http://release.niem.gov/niem/niem-core/3.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> organizationAugmentationPoint;

    /**
     * Gets the value of the organizationAugmentationPoint property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link gov.niem.release.niem.domains.jxdm._5.OrganizationAugmentationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link gov.fbi.cjis._1.OrganizationAugmentationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getOrganizationAugmentationPoint() {
        return organizationAugmentationPoint;
    }

    /**
     * Sets the value of the organizationAugmentationPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link gov.niem.release.niem.domains.jxdm._5.OrganizationAugmentationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link gov.fbi.cjis._1.OrganizationAugmentationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setOrganizationAugmentationPoint(JAXBElement<?> value) {
        this.organizationAugmentationPoint = value;
    }

}
