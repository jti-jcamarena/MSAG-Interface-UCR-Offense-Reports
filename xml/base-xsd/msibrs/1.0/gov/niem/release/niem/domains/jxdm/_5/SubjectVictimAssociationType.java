
package gov.niem.release.niem.domains.jxdm._5;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.fbi.cjis.nibrs.nibrs_codes._4.VictimToSubjectRelationshipCodeType;
import gov.niem.release.niem.niem_core._3.AssociationType;


/**
 * A data type for a relationship between a subject and a victim.
 * 
 * <p>Java class for SubjectVictimAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubjectVictimAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/3.0/}AssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}Subject" maxOccurs="10" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}Victim" maxOccurs="10" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}VictimToSubjectRelationship" maxOccurs="10" minOccurs="0"/&gt;
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
@XmlType(name = "SubjectVictimAssociationType", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", propOrder = {
    "subject",
    "victim",
    "victimToSubjectRelationship"
})
public class SubjectVictimAssociationType
    extends AssociationType
{

    @XmlElement(name = "Subject", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<SubjectType> subject;
    @XmlElement(name = "Victim", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<VictimType> victim;
    @XmlElementRef(name = "VictimToSubjectRelationship", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> victimToSubjectRelationship;

    /**
     * Gets the value of the subject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubjectType }
     * 
     * 
     */
    public List<SubjectType> getSubject() {
        if (subject == null) {
            subject = new ArrayList<SubjectType>();
        }
        return this.subject;
    }

    /**
     * Gets the value of the victim property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the victim property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVictim().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VictimType }
     * 
     * 
     */
    public List<VictimType> getVictim() {
        if (victim == null) {
            victim = new ArrayList<VictimType>();
        }
        return this.victim;
    }

    /**
     * Gets the value of the victimToSubjectRelationship property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the victimToSubjectRelationship property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVictimToSubjectRelationship().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link VictimToSubjectRelationshipCodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getVictimToSubjectRelationship() {
        if (victimToSubjectRelationship == null) {
            victimToSubjectRelationship = new ArrayList<JAXBElement<?>>();
        }
        return this.victimToSubjectRelationship;
    }

}
