
package gov.fbi.cjis._1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.codes.fbi_ucr._3.ArresteeWeaponCodeType;
import gov.niem.release.niem.structures._3.AugmentationType;


/**
 * Augmentation for j:SubjectAugmenationPoint
 * 
 * <p>Java class for SubjectAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubjectAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/5.2/}SubjectArmedWith"/&gt;
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
@XmlType(name = "SubjectAugmentationType", namespace = "http://fbi.gov/cjis/1.0", propOrder = {
    "subjectArmedWith"
})
public class SubjectAugmentationType
    extends AugmentationType
{

    @XmlElementRef(name = "SubjectArmedWith", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/", type = JAXBElement.class)
    protected JAXBElement<?> subjectArmedWith;

    /**
     * Gets the value of the subjectArmedWith property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArresteeWeaponCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getSubjectArmedWith() {
        return subjectArmedWith;
    }

    /**
     * Sets the value of the subjectArmedWith property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArresteeWeaponCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setSubjectArmedWith(JAXBElement<?> value) {
        this.subjectArmedWith = value;
    }

}
