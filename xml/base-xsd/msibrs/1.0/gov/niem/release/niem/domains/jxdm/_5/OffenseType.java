
package gov.niem.release.niem.domains.jxdm._5;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.fbi.cjis.nibrs.nibrs_codes._4.CriminalActivityCategoryCodeType;
import gov.fbi.cjis.nibrs.nibrs_codes._4.OffenseCodeType;
import gov.niem.release.niem.codes.fbi_ndex._3.BiasMotivationCodeType;
import gov.niem.release.niem.niem_core._3.ActivityType;
import gov.niem.release.niem.niem_core._3.QuantityType;
import gov.niem.release.niem.proxy.xsd._3.Boolean;


/**
 * A data type for an alleged violation of a statute, ordinance, or rule.
 * 
 * <p>Java class for OffenseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OffenseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/3.0/}ActivityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}OffenseDesignation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}CriminalActivityCategory" maxOccurs="3" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}OffenseFactorBiasMotivation" maxOccurs="5" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}OffenseStructuresEnteredQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}OffenseFactor" maxOccurs="3" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}OffenseEntryPoint" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}OffenseForce" maxOccurs="3" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}OffenseAttemptedIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}OffenseAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "OffenseType", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", propOrder = {
    "offenseDesignation",
    "criminalActivityCategory",
    "offenseFactorBiasMotivation",
    "offenseStructuresEnteredQuantity",
    "offenseFactor",
    "offenseEntryPoint",
    "offenseForce",
    "offenseAttemptedIndicator",
    "offenseAugmentationPoint"
})
public class OffenseType
    extends ActivityType
{

    @XmlElementRef(name = "OffenseDesignation", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> offenseDesignation;
    @XmlElementRef(name = "CriminalActivityCategory", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> criminalActivityCategory;
    @XmlElementRef(name = "OffenseFactorBiasMotivation", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> offenseFactorBiasMotivation;
    @XmlElement(name = "OffenseStructuresEnteredQuantity", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected QuantityType offenseStructuresEnteredQuantity;
    @XmlElement(name = "OffenseFactor", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<OffenseFactorType> offenseFactor;
    @XmlElement(name = "OffenseEntryPoint", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected PassagePointType offenseEntryPoint;
    @XmlElement(name = "OffenseForce", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<ForceType> offenseForce;
    @XmlElement(name = "OffenseAttemptedIndicator", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected Boolean offenseAttemptedIndicator;
    @XmlElement(name = "OffenseAugmentationPoint", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<Object> offenseAugmentationPoint;

    /**
     * Gets the value of the offenseDesignation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OffenseCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getOffenseDesignation() {
        return offenseDesignation;
    }

    /**
     * Sets the value of the offenseDesignation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OffenseCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setOffenseDesignation(JAXBElement<?> value) {
        this.offenseDesignation = value;
    }

    /**
     * Gets the value of the criminalActivityCategory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the criminalActivityCategory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCriminalActivityCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link CriminalActivityCategoryCodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getCriminalActivityCategory() {
        if (criminalActivityCategory == null) {
            criminalActivityCategory = new ArrayList<JAXBElement<?>>();
        }
        return this.criminalActivityCategory;
    }

    /**
     * Gets the value of the offenseFactorBiasMotivation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offenseFactorBiasMotivation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffenseFactorBiasMotivation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link BiasMotivationCodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getOffenseFactorBiasMotivation() {
        if (offenseFactorBiasMotivation == null) {
            offenseFactorBiasMotivation = new ArrayList<JAXBElement<?>>();
        }
        return this.offenseFactorBiasMotivation;
    }

    /**
     * Gets the value of the offenseStructuresEnteredQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getOffenseStructuresEnteredQuantity() {
        return offenseStructuresEnteredQuantity;
    }

    /**
     * Sets the value of the offenseStructuresEnteredQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setOffenseStructuresEnteredQuantity(QuantityType value) {
        this.offenseStructuresEnteredQuantity = value;
    }

    /**
     * Gets the value of the offenseFactor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offenseFactor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffenseFactor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OffenseFactorType }
     * 
     * 
     */
    public List<OffenseFactorType> getOffenseFactor() {
        if (offenseFactor == null) {
            offenseFactor = new ArrayList<OffenseFactorType>();
        }
        return this.offenseFactor;
    }

    /**
     * Gets the value of the offenseEntryPoint property.
     * 
     * @return
     *     possible object is
     *     {@link PassagePointType }
     *     
     */
    public PassagePointType getOffenseEntryPoint() {
        return offenseEntryPoint;
    }

    /**
     * Sets the value of the offenseEntryPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link PassagePointType }
     *     
     */
    public void setOffenseEntryPoint(PassagePointType value) {
        this.offenseEntryPoint = value;
    }

    /**
     * Gets the value of the offenseForce property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offenseForce property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffenseForce().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ForceType }
     * 
     * 
     */
    public List<ForceType> getOffenseForce() {
        if (offenseForce == null) {
            offenseForce = new ArrayList<ForceType>();
        }
        return this.offenseForce;
    }

    /**
     * Gets the value of the offenseAttemptedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getOffenseAttemptedIndicator() {
        return offenseAttemptedIndicator;
    }

    /**
     * Sets the value of the offenseAttemptedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOffenseAttemptedIndicator(Boolean value) {
        this.offenseAttemptedIndicator = value;
    }

    /**
     * Gets the value of the offenseAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offenseAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffenseAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getOffenseAugmentationPoint() {
        if (offenseAugmentationPoint == null) {
            offenseAugmentationPoint = new ArrayList<Object>();
        }
        return this.offenseAugmentationPoint;
    }

}
