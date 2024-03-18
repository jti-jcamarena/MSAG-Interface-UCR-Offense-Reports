
package gov.niem.release.niem.niem_core._3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.codes.fbi_ucr._3.DrugCategoryCodeType;


/**
 * A data type for the matter or substance of which something consists.
 * 
 * <p>Java class for SubstanceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubstanceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/3.0/}ItemType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}SubstanceCategory" maxOccurs="3" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}SubstanceQuantityMeasure" maxOccurs="3" minOccurs="0"/&gt;
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
@XmlType(name = "SubstanceType", namespace = "http://release.niem.gov/niem/niem-core/3.0/", propOrder = {
    "substanceCategory",
    "substanceQuantityMeasure"
})
public class SubstanceType
    extends ItemType
{

    @XmlElementRef(name = "SubstanceCategory", namespace = "http://release.niem.gov/niem/niem-core/3.0/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> substanceCategory;
    @XmlElement(name = "SubstanceQuantityMeasure", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected List<MeasureType> substanceQuantityMeasure;

    /**
     * Gets the value of the substanceCategory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the substanceCategory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubstanceCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link DrugCategoryCodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getSubstanceCategory() {
        if (substanceCategory == null) {
            substanceCategory = new ArrayList<JAXBElement<?>>();
        }
        return this.substanceCategory;
    }

    /**
     * Gets the value of the substanceQuantityMeasure property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the substanceQuantityMeasure property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubstanceQuantityMeasure().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MeasureType }
     * 
     * 
     */
    public List<MeasureType> getSubstanceQuantityMeasure() {
        if (substanceQuantityMeasure == null) {
            substanceQuantityMeasure = new ArrayList<MeasureType>();
        }
        return this.substanceQuantityMeasure;
    }

}
