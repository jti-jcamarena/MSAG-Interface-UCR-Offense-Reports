
package gov.niem.release.niem.domains.jxdm._5;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.codes.fbi_ucr._3.LEOKAActivityCategoryCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.LEOKAOfficerAssignmentCategoryCodeType;
import gov.niem.release.niem.niem_core._3.PersonType;
import gov.niem.release.niem.structures._3.ObjectType;


/**
 * A data type for a person involved in the enforcement of law.
 * 
 * <p>Java class for EnforcementOfficialType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EnforcementOfficialType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}RoleOfPerson" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}EnforcementOfficialActivityCategory" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}EnforcementOfficialAssignmentCategory" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}EnforcementOfficialUnit" minOccurs="0"/&gt;
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
@XmlType(name = "EnforcementOfficialType", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", propOrder = {
    "roleOfPerson",
    "enforcementOfficialActivityCategory",
    "enforcementOfficialAssignmentCategory",
    "enforcementOfficialUnit"
})
public class EnforcementOfficialType
    extends ObjectType
{

    @XmlElement(name = "RoleOfPerson", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected PersonType roleOfPerson;
    @XmlElementRef(name = "EnforcementOfficialActivityCategory", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> enforcementOfficialActivityCategory;
    @XmlElementRef(name = "EnforcementOfficialAssignmentCategory", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> enforcementOfficialAssignmentCategory;
    @XmlElement(name = "EnforcementOfficialUnit", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected EnforcementUnitType enforcementOfficialUnit;

    /**
     * Gets the value of the roleOfPerson property.
     * 
     * @return
     *     possible object is
     *     {@link PersonType }
     *     
     */
    public PersonType getRoleOfPerson() {
        return roleOfPerson;
    }

    /**
     * Sets the value of the roleOfPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonType }
     *     
     */
    public void setRoleOfPerson(PersonType value) {
        this.roleOfPerson = value;
    }

    /**
     * Gets the value of the enforcementOfficialActivityCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LEOKAActivityCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getEnforcementOfficialActivityCategory() {
        return enforcementOfficialActivityCategory;
    }

    /**
     * Sets the value of the enforcementOfficialActivityCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LEOKAActivityCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setEnforcementOfficialActivityCategory(JAXBElement<?> value) {
        this.enforcementOfficialActivityCategory = value;
    }

    /**
     * Gets the value of the enforcementOfficialAssignmentCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LEOKAOfficerAssignmentCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getEnforcementOfficialAssignmentCategory() {
        return enforcementOfficialAssignmentCategory;
    }

    /**
     * Sets the value of the enforcementOfficialAssignmentCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LEOKAOfficerAssignmentCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setEnforcementOfficialAssignmentCategory(JAXBElement<?> value) {
        this.enforcementOfficialAssignmentCategory = value;
    }

    /**
     * Gets the value of the enforcementOfficialUnit property.
     * 
     * @return
     *     possible object is
     *     {@link EnforcementUnitType }
     *     
     */
    public EnforcementUnitType getEnforcementOfficialUnit() {
        return enforcementOfficialUnit;
    }

    /**
     * Sets the value of the enforcementOfficialUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnforcementUnitType }
     *     
     */
    public void setEnforcementOfficialUnit(EnforcementUnitType value) {
        this.enforcementOfficialUnit = value;
    }

}
