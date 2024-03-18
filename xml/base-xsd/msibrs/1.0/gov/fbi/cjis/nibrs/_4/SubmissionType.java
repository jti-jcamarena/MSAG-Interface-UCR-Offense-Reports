
package gov.fbi.cjis.nibrs._4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.fbi.cjis._1.MessageMetadataType;
import gov.niem.release.niem.structures._3.ObjectType;


/**
 * The root element for a NIBRS exchange
 * 
 * <p>Java class for SubmissionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubmissionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://fbi.gov/cjis/1.0}MessageMetadata"/&gt;
 *         &lt;element ref="{http://fbi.gov/cjis/nibrs/4.2}Report" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "SubmissionType", namespace = "http://fbi.gov/cjis/nibrs/4.2", propOrder = {
    "messageMetadata",
    "report"
})
public class SubmissionType
    extends ObjectType
{

    @XmlElement(name = "MessageMetadata", namespace = "http://fbi.gov/cjis/1.0", required = true)
    protected MessageMetadataType messageMetadata;
    @XmlElement(name = "Report", namespace = "http://fbi.gov/cjis/nibrs/4.2", required = true)
    protected List<ReportType> report;

    /**
     * Gets the value of the messageMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link MessageMetadataType }
     *     
     */
    public MessageMetadataType getMessageMetadata() {
        return messageMetadata;
    }

    /**
     * Sets the value of the messageMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageMetadataType }
     *     
     */
    public void setMessageMetadata(MessageMetadataType value) {
        this.messageMetadata = value;
    }

    /**
     * Gets the value of the report property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the report property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReportType }
     * 
     * 
     */
    public List<ReportType> getReport() {
        if (report == null) {
            report = new ArrayList<ReportType>();
        }
        return this.report;
    }

}
