
package gov.niem.release.niem.niem_core._3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * A data type for an occurrence or an event that may require a response.
 * 
 * <p>Java class for IncidentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IncidentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/3.0/}ActivityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}IncidentAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "IncidentType", namespace = "http://release.niem.gov/niem/niem-core/3.0/", propOrder = {
    "incidentAugmentationPoint"
})
public class IncidentType
    extends ActivityType
{

    @XmlElementRef(name = "IncidentAugmentationPoint", namespace = "http://release.niem.gov/niem/niem-core/3.0/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> incidentAugmentationPoint;

    /**
     * Gets the value of the incidentAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the incidentAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncidentAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link gov.fbi.cjis._1.IncidentAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link gov.niem.release.niem.domains.jxdm._5.IncidentAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getIncidentAugmentationPoint() {
        if (incidentAugmentationPoint == null) {
            incidentAugmentationPoint = new ArrayList<JAXBElement<?>>();
        }
        return this.incidentAugmentationPoint;
    }

}
