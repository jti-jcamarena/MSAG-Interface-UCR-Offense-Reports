
package gov.niem.release.niem.niem_core._3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.proxy.xsd._3.Integer;
import gov.niem.release.niem.structures._3.ObjectType;


/**
 * A data type for a range of integer values.
 * 
 * <p>Java class for IntegerRangeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IntegerRangeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}RangeMaximumIntegerValue" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}RangeMinimumIntegerValue" minOccurs="0"/&gt;
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
@XmlType(name = "IntegerRangeType", namespace = "http://release.niem.gov/niem/niem-core/3.0/", propOrder = {
    "rangeMaximumIntegerValue",
    "rangeMinimumIntegerValue"
})
public class IntegerRangeType
    extends ObjectType
{

    @XmlElement(name = "RangeMaximumIntegerValue", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected Integer rangeMaximumIntegerValue;
    @XmlElement(name = "RangeMinimumIntegerValue", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected Integer rangeMinimumIntegerValue;

    /**
     * Gets the value of the rangeMaximumIntegerValue property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRangeMaximumIntegerValue() {
        return rangeMaximumIntegerValue;
    }

    /**
     * Sets the value of the rangeMaximumIntegerValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRangeMaximumIntegerValue(Integer value) {
        this.rangeMaximumIntegerValue = value;
    }

    /**
     * Gets the value of the rangeMinimumIntegerValue property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRangeMinimumIntegerValue() {
        return rangeMinimumIntegerValue;
    }

    /**
     * Sets the value of the rangeMinimumIntegerValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRangeMinimumIntegerValue(Integer value) {
        this.rangeMinimumIntegerValue = value;
    }

}
