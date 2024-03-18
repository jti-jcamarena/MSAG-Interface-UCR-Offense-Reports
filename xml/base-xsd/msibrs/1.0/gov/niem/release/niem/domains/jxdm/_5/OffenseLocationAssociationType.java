
package gov.niem.release.niem.domains.jxdm._5;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.niem_core._3.AssociationType;
import gov.niem.release.niem.niem_core._3.LocationType;


/**
 * A data type for a relationship between an offense and a location at which the offense occurred.
 * 
 * <p>Java class for OffenseLocationAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OffenseLocationAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/3.0/}AssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}Offense" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}Location" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}OffenseLocationAssociationAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "OffenseLocationAssociationType", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", propOrder = {
    "offense",
    "location",
    "offenseLocationAssociationAugmentationPoint"
})
public class OffenseLocationAssociationType
    extends AssociationType
{

    @XmlElement(name = "Offense", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected OffenseType offense;
    @XmlElement(name = "Location", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected LocationType location;
    @XmlElement(name = "OffenseLocationAssociationAugmentationPoint", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<Object> offenseLocationAssociationAugmentationPoint;

    /**
     * Gets the value of the offense property.
     * 
     * @return
     *     possible object is
     *     {@link OffenseType }
     *     
     */
    public OffenseType getOffense() {
        return offense;
    }

    /**
     * Sets the value of the offense property.
     * 
     * @param value
     *     allowed object is
     *     {@link OffenseType }
     *     
     */
    public void setOffense(OffenseType value) {
        this.offense = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setLocation(LocationType value) {
        this.location = value;
    }

    /**
     * Gets the value of the offenseLocationAssociationAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offenseLocationAssociationAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffenseLocationAssociationAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getOffenseLocationAssociationAugmentationPoint() {
        if (offenseLocationAssociationAugmentationPoint == null) {
            offenseLocationAssociationAugmentationPoint = new ArrayList<Object>();
        }
        return this.offenseLocationAssociationAugmentationPoint;
    }

}
