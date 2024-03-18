
package gov.niem.release.niem.domains.jxdm._5;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.codes.fbi_ucr._3.IncidentExceptionalClearanceCodeType;
import gov.niem.release.niem.niem_core._3.DateType;
import gov.niem.release.niem.structures._3.AugmentationType;


/**
 * A data type for additional information about an incident.
 * 
 * <p>Java class for IncidentAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IncidentAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}IncidentExceptionalClearance" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}IncidentExceptionalClearanceDate" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "IncidentAugmentationType", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", propOrder = {
    "incidentExceptionalClearance",
    "incidentExceptionalClearanceDate"
})
public class IncidentAugmentationType
    extends AugmentationType
{

    @XmlElementRef(name = "IncidentExceptionalClearance", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> incidentExceptionalClearance;
    @XmlElement(name = "IncidentExceptionalClearanceDate", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<DateType> incidentExceptionalClearanceDate;

    /**
     * Gets the value of the incidentExceptionalClearance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the incidentExceptionalClearance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncidentExceptionalClearance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link IncidentExceptionalClearanceCodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getIncidentExceptionalClearance() {
        if (incidentExceptionalClearance == null) {
            incidentExceptionalClearance = new ArrayList<JAXBElement<?>>();
        }
        return this.incidentExceptionalClearance;
    }

    /**
     * Gets the value of the incidentExceptionalClearanceDate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the incidentExceptionalClearanceDate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncidentExceptionalClearanceDate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DateType }
     * 
     * 
     */
    public List<DateType> getIncidentExceptionalClearanceDate() {
        if (incidentExceptionalClearanceDate == null) {
            incidentExceptionalClearanceDate = new ArrayList<DateType>();
        }
        return this.incidentExceptionalClearanceDate;
    }

}
