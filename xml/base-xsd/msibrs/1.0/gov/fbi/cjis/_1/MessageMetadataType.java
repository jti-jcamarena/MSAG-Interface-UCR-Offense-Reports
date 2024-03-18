
package gov.fbi.cjis._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.niem_core._3.IdentificationType;
import gov.niem.release.niem.niem_core._3.OrganizationType;
import gov.niem.release.niem.niem_core._3.TextType;
import gov.niem.release.niem.proxy.xsd._3.DateTime;
import gov.niem.release.niem.structures._3.MetadataType;


/**
 * A data type for Metadata for a message.
 * 
 * <p>Java class for MessageMetadataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MessageMetadataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}MetadataType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://fbi.gov/cjis/1.0}MessageDateTime"/&gt;
 *         &lt;element ref="{http://fbi.gov/cjis/1.0}MessageIdentification"/&gt;
 *         &lt;element ref="{http://fbi.gov/cjis/1.0}MessageImplementationVersion"/&gt;
 *         &lt;element ref="{http://fbi.gov/cjis/1.0}MessageSubmittingOrganization"/&gt;
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
@XmlType(name = "MessageMetadataType", namespace = "http://fbi.gov/cjis/1.0", propOrder = {
    "messageDateTime",
    "messageIdentification",
    "messageImplementationVersion",
    "messageSubmittingOrganization"
})
public class MessageMetadataType
    extends MetadataType
{

    @XmlElement(name = "MessageDateTime", namespace = "http://fbi.gov/cjis/1.0", required = true)
    protected DateTime messageDateTime;
    @XmlElement(name = "MessageIdentification", namespace = "http://fbi.gov/cjis/1.0", required = true)
    protected IdentificationType messageIdentification;
    @XmlElement(name = "MessageImplementationVersion", namespace = "http://fbi.gov/cjis/1.0", required = true)
    protected TextType messageImplementationVersion;
    @XmlElement(name = "MessageSubmittingOrganization", namespace = "http://fbi.gov/cjis/1.0", required = true)
    protected OrganizationType messageSubmittingOrganization;

    /**
     * Gets the value of the messageDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getMessageDateTime() {
        return messageDateTime;
    }

    /**
     * Sets the value of the messageDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setMessageDateTime(DateTime value) {
        this.messageDateTime = value;
    }

    /**
     * Gets the value of the messageIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getMessageIdentification() {
        return messageIdentification;
    }

    /**
     * Sets the value of the messageIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setMessageIdentification(IdentificationType value) {
        this.messageIdentification = value;
    }

    /**
     * Gets the value of the messageImplementationVersion property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getMessageImplementationVersion() {
        return messageImplementationVersion;
    }

    /**
     * Sets the value of the messageImplementationVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setMessageImplementationVersion(TextType value) {
        this.messageImplementationVersion = value;
    }

    /**
     * Gets the value of the messageSubmittingOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationType }
     *     
     */
    public OrganizationType getMessageSubmittingOrganization() {
        return messageSubmittingOrganization;
    }

    /**
     * Sets the value of the messageSubmittingOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationType }
     *     
     */
    public void setMessageSubmittingOrganization(OrganizationType value) {
        this.messageSubmittingOrganization = value;
    }

}
