
package gov.niem.release.niem.localterminology._3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SourceText" type="{http://release.niem.gov/niem/localTerminology/3.0/}NonemptyStringSimpleType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="term" use="required" type="{http://release.niem.gov/niem/localTerminology/3.0/}NonemptyStringSimpleType" /&gt;
 *       &lt;attribute name="literal" type="{http://release.niem.gov/niem/localTerminology/3.0/}NonemptyStringSimpleType" /&gt;
 *       &lt;attribute name="definition" type="{http://release.niem.gov/niem/localTerminology/3.0/}NonemptyStringSimpleType" /&gt;
 *       &lt;attribute name="sourceURIs"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction&gt;
 *             &lt;simpleType&gt;
 *               &lt;list itemType="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *             &lt;/simpleType&gt;
 *             &lt;minLength value="1"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sourceText"
})
@XmlRootElement(name = "LocalTerm", namespace = "http://release.niem.gov/niem/localTerminology/3.0/")
public class LocalTerm {

    @XmlElement(name = "SourceText", namespace = "http://release.niem.gov/niem/localTerminology/3.0/")
    protected List<String> sourceText;
    @XmlAttribute(name = "term", required = true)
    protected String term;
    @XmlAttribute(name = "literal")
    protected String literal;
    @XmlAttribute(name = "definition")
    protected String definition;
    @XmlAttribute(name = "sourceURIs")
    protected List<String> sourceURIs;

    /**
     * Gets the value of the sourceText property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sourceText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSourceText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSourceText() {
        if (sourceText == null) {
            sourceText = new ArrayList<String>();
        }
        return this.sourceText;
    }

    /**
     * Gets the value of the term property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerm() {
        return term;
    }

    /**
     * Sets the value of the term property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerm(String value) {
        this.term = value;
    }

    /**
     * Gets the value of the literal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLiteral() {
        return literal;
    }

    /**
     * Sets the value of the literal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLiteral(String value) {
        this.literal = value;
    }

    /**
     * Gets the value of the definition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * Sets the value of the definition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefinition(String value) {
        this.definition = value;
    }

    /**
     * Gets the value of the sourceURIs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sourceURIs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSourceURIs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSourceURIs() {
        if (sourceURIs == null) {
            sourceURIs = new ArrayList<String>();
        }
        return this.sourceURIs;
    }

}
