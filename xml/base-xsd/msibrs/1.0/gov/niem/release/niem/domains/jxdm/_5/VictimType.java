
package gov.niem.release.niem.domains.jxdm._5;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.codes.fbi_ucr._3.AggravatedAssaultHomicideFactorsCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.JustifiableHomicideFactorsCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.VictimCategoryCodeType;
import gov.niem.release.niem.niem_core._3.InjuryType;
import gov.niem.release.niem.niem_core._3.PersonType;
import gov.niem.release.niem.niem_core._3.TextType;
import gov.niem.release.niem.structures._3.ObjectType;


/**
 * A data type for a person who suffers injury, loss, or death as a result of an incident.
 * 
 * <p>Java class for VictimType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VictimType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}RoleOfPerson" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}VictimSequenceNumberText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}VictimInjury" maxOccurs="5" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}VictimCategory" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}VictimAggravatedAssaultHomicideFactor" maxOccurs="2" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}VictimJustifiableHomicideFactor" maxOccurs="2" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}VictimAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "VictimType", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", propOrder = {
    "roleOfPerson",
    "victimSequenceNumberText",
    "victimInjury",
    "victimCategory",
    "victimAggravatedAssaultHomicideFactor",
    "victimJustifiableHomicideFactor",
    "victimAugmentationPoint"
})
public class VictimType
    extends ObjectType
{

    @XmlElement(name = "RoleOfPerson", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected List<PersonType> roleOfPerson;
    @XmlElement(name = "VictimSequenceNumberText", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected TextType victimSequenceNumberText;
    @XmlElement(name = "VictimInjury", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<InjuryType> victimInjury;
    @XmlElementRef(name = "VictimCategory", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> victimCategory;
    @XmlElementRef(name = "VictimAggravatedAssaultHomicideFactor", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> victimAggravatedAssaultHomicideFactor;
    @XmlElementRef(name = "VictimJustifiableHomicideFactor", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> victimJustifiableHomicideFactor;
    @XmlElement(name = "VictimAugmentationPoint", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
    protected List<Object> victimAugmentationPoint;

    /**
     * Gets the value of the roleOfPerson property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roleOfPerson property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoleOfPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonType }
     * 
     * 
     */
    public List<PersonType> getRoleOfPerson() {
        if (roleOfPerson == null) {
            roleOfPerson = new ArrayList<PersonType>();
        }
        return this.roleOfPerson;
    }

    /**
     * Gets the value of the victimSequenceNumberText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getVictimSequenceNumberText() {
        return victimSequenceNumberText;
    }

    /**
     * Sets the value of the victimSequenceNumberText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setVictimSequenceNumberText(TextType value) {
        this.victimSequenceNumberText = value;
    }

    /**
     * Gets the value of the victimInjury property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the victimInjury property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVictimInjury().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InjuryType }
     * 
     * 
     */
    public List<InjuryType> getVictimInjury() {
        if (victimInjury == null) {
            victimInjury = new ArrayList<InjuryType>();
        }
        return this.victimInjury;
    }

    /**
     * Gets the value of the victimCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link VictimCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getVictimCategory() {
        return victimCategory;
    }

    /**
     * Sets the value of the victimCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link VictimCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setVictimCategory(JAXBElement<?> value) {
        this.victimCategory = value;
    }

    /**
     * Gets the value of the victimAggravatedAssaultHomicideFactor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the victimAggravatedAssaultHomicideFactor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVictimAggravatedAssaultHomicideFactor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link AggravatedAssaultHomicideFactorsCodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getVictimAggravatedAssaultHomicideFactor() {
        if (victimAggravatedAssaultHomicideFactor == null) {
            victimAggravatedAssaultHomicideFactor = new ArrayList<JAXBElement<?>>();
        }
        return this.victimAggravatedAssaultHomicideFactor;
    }

    /**
     * Gets the value of the victimJustifiableHomicideFactor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the victimJustifiableHomicideFactor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVictimJustifiableHomicideFactor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link JustifiableHomicideFactorsCodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getVictimJustifiableHomicideFactor() {
        if (victimJustifiableHomicideFactor == null) {
            victimJustifiableHomicideFactor = new ArrayList<JAXBElement<?>>();
        }
        return this.victimJustifiableHomicideFactor;
    }

    /**
     * Gets the value of the victimAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the victimAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVictimAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getVictimAugmentationPoint() {
        if (victimAugmentationPoint == null) {
            victimAugmentationPoint = new ArrayList<Object>();
        }
        return this.victimAugmentationPoint;
    }

}
