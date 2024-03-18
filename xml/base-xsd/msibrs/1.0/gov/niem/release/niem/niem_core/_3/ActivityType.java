
package gov.niem.release.niem.niem_core._3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.domains.jxdm._5.ArrestType;
import gov.niem.release.niem.domains.jxdm._5.ForceType;
import gov.niem.release.niem.domains.jxdm._5.OffenseType;
import gov.niem.release.niem.domains.jxdm._5.PassagePointType;
import gov.niem.release.niem.structures._3.ObjectType;


/**
 * A data type for a single or set of related actions, events, or process steps.
 * 
 * <p>Java class for ActivityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActivityType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}ActivityIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}ActivityDateRepresentation" minOccurs="0"/&gt;
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
@XmlType(name = "ActivityType", namespace = "http://release.niem.gov/niem/niem-core/3.0/", propOrder = {
    "activityIdentification",
    "activityDateRepresentation"
})
@XmlSeeAlso({
    ArrestType.class,
    OffenseType.class,
    PassagePointType.class,
    ForceType.class,
    IncidentType.class
})
public class ActivityType
    extends ObjectType
{

    @XmlElement(name = "ActivityIdentification", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected IdentificationType activityIdentification;
    @XmlElementRef(name = "ActivityDateRepresentation", namespace = "http://release.niem.gov/niem/niem-core/3.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> activityDateRepresentation;

    /**
     * Gets the value of the activityIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getActivityIdentification() {
        return activityIdentification;
    }

    /**
     * Sets the value of the activityIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setActivityIdentification(IdentificationType value) {
        this.activityIdentification = value;
    }

    /**
     * Gets the value of the activityDateRepresentation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DateType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getActivityDateRepresentation() {
        return activityDateRepresentation;
    }

    /**
     * Sets the value of the activityDateRepresentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DateType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setActivityDateRepresentation(JAXBElement<?> value) {
        this.activityDateRepresentation = value;
    }

}
