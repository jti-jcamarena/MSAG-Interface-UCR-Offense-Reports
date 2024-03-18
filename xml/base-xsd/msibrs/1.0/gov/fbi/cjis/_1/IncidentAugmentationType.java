
package gov.fbi.cjis._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.proxy.xsd._3.Boolean;
import gov.niem.release.niem.structures._3.AugmentationType;


/**
 * A data type that supplements nc:IncidentType.
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
 *         &lt;element ref="{http://fbi.gov/cjis/1.0}IncidentReportDateIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}OffenseCargoTheftIndicator" minOccurs="0"/&gt;
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
@XmlType(name = "IncidentAugmentationType", namespace = "http://fbi.gov/cjis/1.0", propOrder = {
    "incidentReportDateIndicator",
    "offenseCargoTheftIndicator"
})
public class IncidentAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "IncidentReportDateIndicator", namespace = "http://fbi.gov/cjis/1.0", nillable = true)
    protected Boolean incidentReportDateIndicator;
    @XmlElement(name = "OffenseCargoTheftIndicator", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected Boolean offenseCargoTheftIndicator;

    /**
     * Gets the value of the incidentReportDateIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIncidentReportDateIndicator() {
        return incidentReportDateIndicator;
    }

    /**
     * Sets the value of the incidentReportDateIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncidentReportDateIndicator(Boolean value) {
        this.incidentReportDateIndicator = value;
    }

    /**
     * Gets the value of the offenseCargoTheftIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getOffenseCargoTheftIndicator() {
        return offenseCargoTheftIndicator;
    }

    /**
     * Sets the value of the offenseCargoTheftIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOffenseCargoTheftIndicator(Boolean value) {
        this.offenseCargoTheftIndicator = value;
    }

}
