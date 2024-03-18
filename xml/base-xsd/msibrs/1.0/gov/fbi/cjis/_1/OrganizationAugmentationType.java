
package gov.fbi.cjis._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.niem_core._3.IdentificationType;
import gov.niem.release.niem.structures._3.AugmentationType;


/**
 * A data type that supplements nc:OrganizationType.
 * 
 * <p>Java class for OrganizationAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganizationAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://fbi.gov/cjis/1.0}DirectReportingCityIdentification" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "OrganizationAugmentationType", namespace = "http://fbi.gov/cjis/1.0", propOrder = {
    "directReportingCityIdentification"
})
public class OrganizationAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "DirectReportingCityIdentification", namespace = "http://fbi.gov/cjis/1.0", nillable = true)
    protected List<IdentificationType> directReportingCityIdentification;

    /**
     * Gets the value of the directReportingCityIdentification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the directReportingCityIdentification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDirectReportingCityIdentification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentificationType }
     * 
     * 
     */
    public List<IdentificationType> getDirectReportingCityIdentification() {
        if (directReportingCityIdentification == null) {
            directReportingCityIdentification = new ArrayList<IdentificationType>();
        }
        return this.directReportingCityIdentification;
    }

}
