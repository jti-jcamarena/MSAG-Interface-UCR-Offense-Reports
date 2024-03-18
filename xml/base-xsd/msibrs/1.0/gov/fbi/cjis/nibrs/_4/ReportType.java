
package gov.fbi.cjis.nibrs._4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.domains.jxdm._5.ActivitySubjectAssociationType;
import gov.niem.release.niem.domains.jxdm._5.ArrestType;
import gov.niem.release.niem.domains.jxdm._5.ArresteeType;
import gov.niem.release.niem.domains.jxdm._5.EnforcementOfficialType;
import gov.niem.release.niem.domains.jxdm._5.OffenseLocationAssociationType;
import gov.niem.release.niem.domains.jxdm._5.OffenseType;
import gov.niem.release.niem.domains.jxdm._5.OffenseVictimAssociationType;
import gov.niem.release.niem.domains.jxdm._5.SubjectType;
import gov.niem.release.niem.domains.jxdm._5.SubjectVictimAssociationType;
import gov.niem.release.niem.domains.jxdm._5.VictimType;
import gov.niem.release.niem.niem_core._3.IncidentType;
import gov.niem.release.niem.niem_core._3.ItemType;
import gov.niem.release.niem.niem_core._3.LocationType;
import gov.niem.release.niem.niem_core._3.PersonType;
import gov.niem.release.niem.niem_core._3.SubstanceType;
import gov.niem.release.niem.structures._3.ObjectType;


/**
 * A data type for a CJIS report
 * 
 * <p>Java class for ReportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://fbi.gov/cjis/nibrs/4.2}ReportHeader"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}Incident" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}Offense" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}Location" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}Item" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}Substance" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}Person" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}EnforcementOfficial" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}Victim" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}Subject" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}Arrestee" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}Arrest" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}ArrestSubjectAssociation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}OffenseLocationAssociation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}OffenseVictimAssociation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}SubjectVictimAssociation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://fbi.gov/cjis/nibrs/4.2}ReportAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "ReportType", namespace = "http://fbi.gov/cjis/nibrs/4.2", propOrder = {
    "reportHeader",
    "incident",
    "offense",
    "location",
    "item",
    "substance",
    "person",
    "enforcementOfficial",
    "victim",
    "subject",
    "arrestee",
    "arrest",
    "arrestSubjectAssociation",
    "offenseLocationAssociation",
    "offenseVictimAssociation",
    "subjectVictimAssociation",
    "reportAugmentationPoint"
})
public class ReportType
    extends ObjectType
{

    @XmlElement(name = "ReportHeader", namespace = "http://fbi.gov/cjis/nibrs/4.2", required = true)
    protected ReportHeaderType reportHeader;
    @XmlElement(name = "Incident", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected IncidentType incident;
    @XmlElement(name = "Offense", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<OffenseType> offense;
    @XmlElement(name = "Location", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected List<LocationType> location;
    @XmlElement(name = "Item", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected List<ItemType> item;
    @XmlElement(name = "Substance", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected List<SubstanceType> substance;
    @XmlElement(name = "Person", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected List<PersonType> person;
    @XmlElement(name = "EnforcementOfficial", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<EnforcementOfficialType> enforcementOfficial;
    @XmlElement(name = "Victim", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<VictimType> victim;
    @XmlElement(name = "Subject", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<SubjectType> subject;
    @XmlElement(name = "Arrestee", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<ArresteeType> arrestee;
    @XmlElement(name = "Arrest", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<ArrestType> arrest;
    @XmlElement(name = "ArrestSubjectAssociation", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<ActivitySubjectAssociationType> arrestSubjectAssociation;
    @XmlElement(name = "OffenseLocationAssociation", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<OffenseLocationAssociationType> offenseLocationAssociation;
    @XmlElement(name = "OffenseVictimAssociation", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<OffenseVictimAssociationType> offenseVictimAssociation;
    @XmlElement(name = "SubjectVictimAssociation", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<SubjectVictimAssociationType> subjectVictimAssociation;
    @XmlElement(name = "ReportAugmentationPoint", namespace = "http://fbi.gov/cjis/nibrs/4.2")
    protected List<Object> reportAugmentationPoint;

    /**
     * Gets the value of the reportHeader property.
     * 
     * @return
     *     possible object is
     *     {@link ReportHeaderType }
     *     
     */
    public ReportHeaderType getReportHeader() {
        return reportHeader;
    }

    /**
     * Sets the value of the reportHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportHeaderType }
     *     
     */
    public void setReportHeader(ReportHeaderType value) {
        this.reportHeader = value;
    }

    /**
     * Gets the value of the incident property.
     * 
     * @return
     *     possible object is
     *     {@link IncidentType }
     *     
     */
    public IncidentType getIncident() {
        return incident;
    }

    /**
     * Sets the value of the incident property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncidentType }
     *     
     */
    public void setIncident(IncidentType value) {
        this.incident = value;
    }

    /**
     * Gets the value of the offense property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offense property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffense().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OffenseType }
     * 
     * 
     */
    public List<OffenseType> getOffense() {
        if (offense == null) {
            offense = new ArrayList<OffenseType>();
        }
        return this.offense;
    }

    /**
     * Gets the value of the location property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the location property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocationType }
     * 
     * 
     */
    public List<LocationType> getLocation() {
        if (location == null) {
            location = new ArrayList<LocationType>();
        }
        return this.location;
    }

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemType }
     * 
     * 
     */
    public List<ItemType> getItem() {
        if (item == null) {
            item = new ArrayList<ItemType>();
        }
        return this.item;
    }

    /**
     * Gets the value of the substance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the substance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubstance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubstanceType }
     * 
     * 
     */
    public List<SubstanceType> getSubstance() {
        if (substance == null) {
            substance = new ArrayList<SubstanceType>();
        }
        return this.substance;
    }

    /**
     * Gets the value of the person property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the person property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonType }
     * 
     * 
     */
    public List<PersonType> getPerson() {
        if (person == null) {
            person = new ArrayList<PersonType>();
        }
        return this.person;
    }

    /**
     * Gets the value of the enforcementOfficial property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enforcementOfficial property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnforcementOfficial().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EnforcementOfficialType }
     * 
     * 
     */
    public List<EnforcementOfficialType> getEnforcementOfficial() {
        if (enforcementOfficial == null) {
            enforcementOfficial = new ArrayList<EnforcementOfficialType>();
        }
        return this.enforcementOfficial;
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
     * Gets the value of the arrestee property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arrestee property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArrestee().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArresteeType }
     * 
     * 
     */
    public List<ArresteeType> getArrestee() {
        if (arrestee == null) {
            arrestee = new ArrayList<ArresteeType>();
        }
        return this.arrestee;
    }

    /**
     * Gets the value of the arrest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arrest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArrest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrestType }
     * 
     * 
     */
    public List<ArrestType> getArrest() {
        if (arrest == null) {
            arrest = new ArrayList<ArrestType>();
        }
        return this.arrest;
    }

    /**
     * Gets the value of the arrestSubjectAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arrestSubjectAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArrestSubjectAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActivitySubjectAssociationType }
     * 
     * 
     */
    public List<ActivitySubjectAssociationType> getArrestSubjectAssociation() {
        if (arrestSubjectAssociation == null) {
            arrestSubjectAssociation = new ArrayList<ActivitySubjectAssociationType>();
        }
        return this.arrestSubjectAssociation;
    }

    /**
     * Gets the value of the offenseLocationAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offenseLocationAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffenseLocationAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OffenseLocationAssociationType }
     * 
     * 
     */
    public List<OffenseLocationAssociationType> getOffenseLocationAssociation() {
        if (offenseLocationAssociation == null) {
            offenseLocationAssociation = new ArrayList<OffenseLocationAssociationType>();
        }
        return this.offenseLocationAssociation;
    }

    /**
     * Gets the value of the offenseVictimAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offenseVictimAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffenseVictimAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OffenseVictimAssociationType }
     * 
     * 
     */
    public List<OffenseVictimAssociationType> getOffenseVictimAssociation() {
        if (offenseVictimAssociation == null) {
            offenseVictimAssociation = new ArrayList<OffenseVictimAssociationType>();
        }
        return this.offenseVictimAssociation;
    }

    /**
     * Gets the value of the subjectVictimAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subjectVictimAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubjectVictimAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubjectVictimAssociationType }
     * 
     * 
     */
    public List<SubjectVictimAssociationType> getSubjectVictimAssociation() {
        if (subjectVictimAssociation == null) {
            subjectVictimAssociation = new ArrayList<SubjectVictimAssociationType>();
        }
        return this.subjectVictimAssociation;
    }

    /**
     * Gets the value of the reportAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reportAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReportAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getReportAugmentationPoint() {
        if (reportAugmentationPoint == null) {
            reportAugmentationPoint = new ArrayList<Object>();
        }
        return this.reportAugmentationPoint;
    }

}
