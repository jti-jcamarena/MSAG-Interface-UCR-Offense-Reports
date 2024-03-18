
package gov.niem.release.niem.niem_core._3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.structures._3.ObjectType;


/**
 * A data type for an evaluation of the monetary worth of an item.
 * 
 * <p>Java class for ItemValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemValueType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}ItemValueAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}ItemValueDate" minOccurs="0"/&gt;
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
@XmlType(name = "ItemValueType", namespace = "http://release.niem.gov/niem/niem-core/3.0/", propOrder = {
    "itemValueAmount",
    "itemValueDate"
})
public class ItemValueType
    extends ObjectType
{

    @XmlElement(name = "ItemValueAmount", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected AmountType itemValueAmount;
    @XmlElement(name = "ItemValueDate", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected DateType itemValueDate;

    /**
     * Gets the value of the itemValueAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getItemValueAmount() {
        return itemValueAmount;
    }

    /**
     * Sets the value of the itemValueAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setItemValueAmount(AmountType value) {
        this.itemValueAmount = value;
    }

    /**
     * Gets the value of the itemValueDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getItemValueDate() {
        return itemValueDate;
    }

    /**
     * Sets the value of the itemValueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setItemValueDate(DateType value) {
        this.itemValueDate = value;
    }

}
