
package gov.niem.release.niem.niem_core._3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.codes.fbi_ncic._3.SEXCodeType;
import gov.niem.release.niem.codes.fbi_ndex._3.RACCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.EthnicityCodeType;
import gov.niem.release.niem.codes.fbi_ucr._3.ResidentCodeType;
import gov.niem.release.niem.structures._3.ObjectType;


/**
 * A data type for a human being.
 * 
 * <p>Java class for PersonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}PersonAgeMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}PersonEthnicity" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}PersonRace" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}PersonResident" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}PersonSex" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/3.0/}PersonAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "PersonType", namespace = "http://release.niem.gov/niem/niem-core/3.0/", propOrder = {
    "personAgeMeasure",
    "personEthnicity",
    "personRace",
    "personResident",
    "personSex",
    "personAugmentationPoint"
})
public class PersonType
    extends ObjectType
{

    @XmlElement(name = "PersonAgeMeasure", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected MeasureType personAgeMeasure;
    @XmlElementRef(name = "PersonEthnicity", namespace = "http://release.niem.gov/niem/niem-core/3.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> personEthnicity;
    @XmlElementRef(name = "PersonRace", namespace = "http://release.niem.gov/niem/niem-core/3.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> personRace;
    @XmlElementRef(name = "PersonResident", namespace = "http://release.niem.gov/niem/niem-core/3.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> personResident;
    @XmlElementRef(name = "PersonSex", namespace = "http://release.niem.gov/niem/niem-core/3.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> personSex;
    @XmlElement(name = "PersonAugmentationPoint", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
    protected List<Object> personAugmentationPoint;

    /**
     * Gets the value of the personAgeMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getPersonAgeMeasure() {
        return personAgeMeasure;
    }

    /**
     * Sets the value of the personAgeMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setPersonAgeMeasure(MeasureType value) {
        this.personAgeMeasure = value;
    }

    /**
     * Gets the value of the personEthnicity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link EthnicityCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getPersonEthnicity() {
        return personEthnicity;
    }

    /**
     * Sets the value of the personEthnicity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link EthnicityCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setPersonEthnicity(JAXBElement<?> value) {
        this.personEthnicity = value;
    }

    /**
     * Gets the value of the personRace property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RACCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getPersonRace() {
        return personRace;
    }

    /**
     * Sets the value of the personRace property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RACCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setPersonRace(JAXBElement<?> value) {
        this.personRace = value;
    }

    /**
     * Gets the value of the personResident property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ResidentCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getPersonResident() {
        return personResident;
    }

    /**
     * Sets the value of the personResident property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ResidentCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setPersonResident(JAXBElement<?> value) {
        this.personResident = value;
    }

    /**
     * Gets the value of the personSex property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SEXCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getPersonSex() {
        return personSex;
    }

    /**
     * Sets the value of the personSex property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SEXCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setPersonSex(JAXBElement<?> value) {
        this.personSex = value;
    }

    /**
     * Gets the value of the personAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getPersonAugmentationPoint() {
        if (personAugmentationPoint == null) {
            personAugmentationPoint = new ArrayList<Object>();
        }
        return this.personAugmentationPoint;
    }

}
