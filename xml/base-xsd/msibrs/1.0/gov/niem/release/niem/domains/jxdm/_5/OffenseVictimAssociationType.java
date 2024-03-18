
package gov.niem.release.niem.domains.jxdm._5;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.niem_core._3.AssociationType;


/**
 * A data type for a relationship between an offense that was committed and an entity that was adversely affected by that offense.
 * 
 * <p>Java class for OffenseVictimAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OffenseVictimAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/3.0/}AssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}Offense" maxOccurs="10" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}Victim" maxOccurs="10" minOccurs="0"/&gt;
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
@XmlType(name = "OffenseVictimAssociationType", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", propOrder = {
    "offense",
    "victim"
})
public class OffenseVictimAssociationType
    extends AssociationType
{

    @XmlElement(name = "Offense", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<OffenseType> offense;
    @XmlElement(name = "Victim", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<VictimType> victim;

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

}
