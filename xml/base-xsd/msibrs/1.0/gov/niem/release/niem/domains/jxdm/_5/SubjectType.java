
package gov.niem.release.niem.domains.jxdm._5;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.niem_core._3.PersonType;
import gov.niem.release.niem.niem_core._3.TextType;
import gov.niem.release.niem.structures._3.ObjectType;


/**
 * A data type for a person or organization that is involved or suspected of being involved in a violation of a criminal statute, ordinance or rule.
 * 
 * <p>Java class for SubjectType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubjectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}RoleOfPerson" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}SubjectSequenceNumberText" minOccurs="0"/&gt;
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
@XmlType(name = "SubjectType", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", propOrder = {
    "roleOfPerson",
    "subjectSequenceNumberText"
})
@XmlSeeAlso({
    ArresteeType.class
})
public class SubjectType
    extends ObjectType
{

    @XmlElement(name = "RoleOfPerson", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected List<PersonType> roleOfPerson;
    @XmlElement(name = "SubjectSequenceNumberText", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected TextType subjectSequenceNumberText;

    /**
     * Gets the value of the roleOfPerson property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roleOfPerson property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoleOfPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonType }
     * 
     * 
     */
    public List<PersonType> getRoleOfPerson() {
        if (roleOfPerson == null) {
            roleOfPerson = new ArrayList<PersonType>();
        }
        return this.roleOfPerson;
    }

    /**
     * Gets the value of the subjectSequenceNumberText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getSubjectSequenceNumberText() {
        return subjectSequenceNumberText;
    }

    /**
     * Sets the value of the subjectSequenceNumberText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setSubjectSequenceNumberText(TextType value) {
        this.subjectSequenceNumberText = value;
    }

}
