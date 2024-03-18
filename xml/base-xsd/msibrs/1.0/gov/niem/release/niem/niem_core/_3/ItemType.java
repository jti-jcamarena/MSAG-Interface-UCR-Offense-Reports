
package gov.niem.release.niem.niem_core._3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.codes.fbi_ucr._3.PropertyCategoryCodeType;
import gov.niem.release.niem.structures._3.ObjectType;


/**
 * A data type for an article or thing.
 * 
 * <p>Java class for ItemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}ItemStatus" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}ItemValue" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}ItemCategory" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}ItemQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}ItemAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "ItemType", namespace = "http://release.niem.gov/niem/niem-core/3.0/", propOrder = {
    "itemStatus",
    "itemValue",
    "itemCategory",
    "itemQuantity",
    "itemAugmentationPoint"
})
@XmlSeeAlso({
    SubstanceType.class
})
public class ItemType
    extends ObjectType
{

    @XmlElement(name = "ItemStatus", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected StatusType itemStatus;
    @XmlElement(name = "ItemValue", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected ItemValueType itemValue;
    @XmlElementRef(name = "ItemCategory", namespace = "http://release.niem.gov/niem/niem-core/3.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> itemCategory;
    @XmlElement(name = "ItemQuantity", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected QuantityType itemQuantity;
    @XmlElement(name = "ItemAugmentationPoint", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected List<Object> itemAugmentationPoint;

    /**
     * Gets the value of the itemStatus property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getItemStatus() {
        return itemStatus;
    }

    /**
     * Sets the value of the itemStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setItemStatus(StatusType value) {
        this.itemStatus = value;
    }

    /**
     * Gets the value of the itemValue property.
     * 
     * @return
     *     possible object is
     *     {@link ItemValueType }
     *     
     */
    public ItemValueType getItemValue() {
        return itemValue;
    }

    /**
     * Sets the value of the itemValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemValueType }
     *     
     */
    public void setItemValue(ItemValueType value) {
        this.itemValue = value;
    }

    /**
     * Gets the value of the itemCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PropertyCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getItemCategory() {
        return itemCategory;
    }

    /**
     * Sets the value of the itemCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PropertyCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setItemCategory(JAXBElement<?> value) {
        this.itemCategory = value;
    }

    /**
     * Gets the value of the itemQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getItemQuantity() {
        return itemQuantity;
    }

    /**
     * Sets the value of the itemQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setItemQuantity(QuantityType value) {
        this.itemQuantity = value;
    }

    /**
     * Gets the value of the itemAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getItemAugmentationPoint() {
        if (itemAugmentationPoint == null) {
            itemAugmentationPoint = new ArrayList<Object>();
        }
        return this.itemAugmentationPoint;
    }

}
