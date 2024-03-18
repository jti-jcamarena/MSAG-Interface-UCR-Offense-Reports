
package gov.niem.release.niem.structures._3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import gov.fbi.cjis.nibrs._4.ReportHeaderType;
import gov.fbi.cjis.nibrs._4.ReportType;
import gov.fbi.cjis.nibrs._4.SubmissionType;
import gov.niem.release.niem.domains.jxdm._5.ChargeType;
import gov.niem.release.niem.domains.jxdm._5.EnforcementOfficialType;
import gov.niem.release.niem.domains.jxdm._5.OffenseFactorType;
import gov.niem.release.niem.domains.jxdm._5.SubjectType;
import gov.niem.release.niem.domains.jxdm._5.VictimType;
import gov.niem.release.niem.niem_core._3.ActivityType;
import gov.niem.release.niem.niem_core._3.AmountType;
import gov.niem.release.niem.niem_core._3.DateType;
import gov.niem.release.niem.niem_core._3.IdentificationType;
import gov.niem.release.niem.niem_core._3.InjuryType;
import gov.niem.release.niem.niem_core._3.IntegerRangeType;
import gov.niem.release.niem.niem_core._3.ItemType;
import gov.niem.release.niem.niem_core._3.ItemValueType;
import gov.niem.release.niem.niem_core._3.LocationType;
import gov.niem.release.niem.niem_core._3.MeasureType;
import gov.niem.release.niem.niem_core._3.OrganizationType;
import gov.niem.release.niem.niem_core._3.PersonType;
import gov.niem.release.niem.niem_core._3.StatusType;


/**
 * <p>Java class for ObjectType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObjectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/structures/3.0/}ObjectAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://release.niem.gov/niem/structures/3.0/}id"/&gt;
 *       &lt;attribute ref="{http://release.niem.gov/niem/structures/3.0/}ref"/&gt;
 *       &lt;attribute ref="{http://release.niem.gov/niem/structures/3.0/}metadata"/&gt;
 *       &lt;attribute ref="{http://release.niem.gov/niem/structures/3.0/}relationshipMetadata"/&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObjectType", namespace = "http://release.niem.gov/niem/structures/3.0/", propOrder = {
    "objectAugmentationPoint"
})
@XmlSeeAlso({
    ReportType.class,
    DateType.class,
    ReportHeaderType.class,
    SubmissionType.class,
    IdentificationType.class,
    ChargeType.class,
    SubjectType.class,
    EnforcementOfficialType.class,
    OrganizationType.class,
    OffenseFactorType.class,
    VictimType.class,
    InjuryType.class,
    ActivityType.class,
    StatusType.class,
    ItemValueType.class,
    AmountType.class,
    LocationType.class,
    IntegerRangeType.class,
    PersonType.class,
    MeasureType.class,
    ItemType.class
})
public abstract class ObjectType {

    @XmlElement(name = "ObjectAugmentationPoint", namespace = "http://release.niem.gov/niem/structures/3.0/")
    protected List<Object> objectAugmentationPoint;
    @XmlAttribute(name = "id", namespace = "http://release.niem.gov/niem/structures/3.0/")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "ref", namespace = "http://release.niem.gov/niem/structures/3.0/")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object ref;
    @XmlAttribute(name = "metadata", namespace = "http://release.niem.gov/niem/structures/3.0/")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected List<Object> metadata;
    @XmlAttribute(name = "relationshipMetadata", namespace = "http://release.niem.gov/niem/structures/3.0/")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected List<Object> relationshipMetadata;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the objectAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objectAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjectAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getObjectAugmentationPoint() {
        if (objectAugmentationPoint == null) {
            objectAugmentationPoint = new ArrayList<Object>();
        }
        return this.objectAugmentationPoint;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the ref property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setRef(Object value) {
        this.ref = value;
    }

    /**
     * Gets the value of the metadata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metadata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetadata().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getMetadata() {
        if (metadata == null) {
            metadata = new ArrayList<Object>();
        }
        return this.metadata;
    }

    /**
     * Gets the value of the relationshipMetadata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relationshipMetadata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelationshipMetadata().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getRelationshipMetadata() {
        if (relationshipMetadata == null) {
            relationshipMetadata = new ArrayList<Object>();
        }
        return this.relationshipMetadata;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
