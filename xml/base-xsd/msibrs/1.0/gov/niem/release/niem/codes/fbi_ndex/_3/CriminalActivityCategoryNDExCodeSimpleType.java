
package gov.niem.release.niem.codes.fbi_ndex._3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CriminalActivityCategoryNDExCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CriminalActivityCategoryNDExCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="Assisting"/&gt;
 *     &lt;enumeration value="Buying"/&gt;
 *     &lt;enumeration value="Buying_Receiving"/&gt;
 *     &lt;enumeration value="Concealing"/&gt;
 *     &lt;enumeration value="Consuming"/&gt;
 *     &lt;enumeration value="Cultivating"/&gt;
 *     &lt;enumeration value="Cultivating_Manufacturing_Publishing"/&gt;
 *     &lt;enumeration value="Distributing"/&gt;
 *     &lt;enumeration value="Distributing_Selling"/&gt;
 *     &lt;enumeration value="Exploiting Children"/&gt;
 *     &lt;enumeration value="Importing"/&gt;
 *     &lt;enumeration value="Manufacturing"/&gt;
 *     &lt;enumeration value="None"/&gt;
 *     &lt;enumeration value="Operating"/&gt;
 *     &lt;enumeration value="Operating_Promoting_Assisting"/&gt;
 *     &lt;enumeration value="Possessing"/&gt;
 *     &lt;enumeration value="Possessing_Concealing"/&gt;
 *     &lt;enumeration value="Promoting"/&gt;
 *     &lt;enumeration value="Publishing"/&gt;
 *     &lt;enumeration value="Receiving"/&gt;
 *     &lt;enumeration value="Selling"/&gt;
 *     &lt;enumeration value="Transmitting"/&gt;
 *     &lt;enumeration value="Transporting"/&gt;
 *     &lt;enumeration value="Transporting_Transmitting_Importing"/&gt;
 *     &lt;enumeration value="Unknown"/&gt;
 *     &lt;enumeration value="Using"/&gt;
 *     &lt;enumeration value="Using_Consuming"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CriminalActivityCategoryNDExCodeSimpleType", namespace = "http://release.niem.gov/niem/codes/fbi_ndex/3.1/")
@XmlEnum
public enum CriminalActivityCategoryNDExCodeSimpleType {


    /**
     * Assisting
     * 
     */
    @XmlEnumValue("Assisting")
    ASSISTING("Assisting"),

    /**
     * Buying
     * 
     */
    @XmlEnumValue("Buying")
    BUYING("Buying"),

    /**
     * Buying_Receiving
     * 
     */
    @XmlEnumValue("Buying_Receiving")
    BUYING_RECEIVING("Buying_Receiving"),

    /**
     * Concealing
     * 
     */
    @XmlEnumValue("Concealing")
    CONCEALING("Concealing"),

    /**
     * Consuming
     * 
     */
    @XmlEnumValue("Consuming")
    CONSUMING("Consuming"),

    /**
     * Cultivating
     * 
     */
    @XmlEnumValue("Cultivating")
    CULTIVATING("Cultivating"),

    /**
     * Cultivating_Manufacturing_Publishing
     * 
     */
    @XmlEnumValue("Cultivating_Manufacturing_Publishing")
    CULTIVATING_MANUFACTURING_PUBLISHING("Cultivating_Manufacturing_Publishing"),

    /**
     * Distributing
     * 
     */
    @XmlEnumValue("Distributing")
    DISTRIBUTING("Distributing"),

    /**
     * Distributing_Selling
     * 
     */
    @XmlEnumValue("Distributing_Selling")
    DISTRIBUTING_SELLING("Distributing_Selling"),

    /**
     * Exploiting Children
     * 
     */
    @XmlEnumValue("Exploiting Children")
    EXPLOITING_CHILDREN("Exploiting Children"),

    /**
     * Importing
     * 
     */
    @XmlEnumValue("Importing")
    IMPORTING("Importing"),

    /**
     * Manufacturing
     * 
     */
    @XmlEnumValue("Manufacturing")
    MANUFACTURING("Manufacturing"),

    /**
     * None
     * 
     */
    @XmlEnumValue("None")
    NONE("None"),

    /**
     * Operating
     * 
     */
    @XmlEnumValue("Operating")
    OPERATING("Operating"),

    /**
     * Operating_Promoting_Assisting
     * 
     */
    @XmlEnumValue("Operating_Promoting_Assisting")
    OPERATING_PROMOTING_ASSISTING("Operating_Promoting_Assisting"),

    /**
     * Possessing
     * 
     */
    @XmlEnumValue("Possessing")
    POSSESSING("Possessing"),

    /**
     * Possessing_Concealing
     * 
     */
    @XmlEnumValue("Possessing_Concealing")
    POSSESSING_CONCEALING("Possessing_Concealing"),

    /**
     * Promoting
     * 
     */
    @XmlEnumValue("Promoting")
    PROMOTING("Promoting"),

    /**
     * Publishing
     * 
     */
    @XmlEnumValue("Publishing")
    PUBLISHING("Publishing"),

    /**
     * Receiving
     * 
     */
    @XmlEnumValue("Receiving")
    RECEIVING("Receiving"),

    /**
     * Selling
     * 
     */
    @XmlEnumValue("Selling")
    SELLING("Selling"),

    /**
     * Transmitting
     * 
     */
    @XmlEnumValue("Transmitting")
    TRANSMITTING("Transmitting"),

    /**
     * Transporting
     * 
     */
    @XmlEnumValue("Transporting")
    TRANSPORTING("Transporting"),

    /**
     * Transporting_Transmitting_Importing
     * 
     */
    @XmlEnumValue("Transporting_Transmitting_Importing")
    TRANSPORTING_TRANSMITTING_IMPORTING("Transporting_Transmitting_Importing"),

    /**
     * Unknown
     * 
     */
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),

    /**
     * Using
     * 
     */
    @XmlEnumValue("Using")
    USING("Using"),

    /**
     * Using_Consuming
     * 
     */
    @XmlEnumValue("Using_Consuming")
    USING_CONSUMING("Using_Consuming");
    private final String value;

    CriminalActivityCategoryNDExCodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CriminalActivityCategoryNDExCodeSimpleType fromValue(String v) {
        for (CriminalActivityCategoryNDExCodeSimpleType c: CriminalActivityCategoryNDExCodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
