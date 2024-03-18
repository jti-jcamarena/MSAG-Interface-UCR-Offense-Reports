
package gov.fbi.cjis.cjis_codes._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ItemStatusCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ItemStatusCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="BAIT"/&gt;
 *     &lt;enumeration value="BURNED"/&gt;
 *     &lt;enumeration value="CARGO"/&gt;
 *     &lt;enumeration value="CONTRABAND"/&gt;
 *     &lt;enumeration value="COUNTERFEITED"/&gt;
 *     &lt;enumeration value="CULTIVATED"/&gt;
 *     &lt;enumeration value="DAMAGED"/&gt;
 *     &lt;enumeration value="DESTROYED"/&gt;
 *     &lt;enumeration value="DESTROYED_DAMAGED_VANDALIZED"/&gt;
 *     &lt;enumeration value="FOUND"/&gt;
 *     &lt;enumeration value="LOST"/&gt;
 *     &lt;enumeration value="RECOVERED"/&gt;
 *     &lt;enumeration value="RETURNED"/&gt;
 *     &lt;enumeration value="SEIZED"/&gt;
 *     &lt;enumeration value="STOLEN"/&gt;
 *     &lt;enumeration value="STOLEN_BRIBED"/&gt;
 *     &lt;enumeration value="STOLEN_DEFRAUDED"/&gt;
 *     &lt;enumeration value="STOLEN_EMBEZZLED"/&gt;
 *     &lt;enumeration value="STOLEN_EXTORTED"/&gt;
 *     &lt;enumeration value="STOLEN_RANSOMED"/&gt;
 *     &lt;enumeration value="STOLEN_ROBBED"/&gt;
 *     &lt;enumeration value="VANDALIZED"/&gt;
 *     &lt;enumeration value="NONE"/&gt;
 *     &lt;enumeration value="UNKNOWN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ItemStatusCodeSimpleType", namespace = "http://fbi.gov/cjis/cjis-codes/1.0")
@XmlEnum
public enum ItemStatusCodeSimpleType {


    /**
     * Bait
     * 
     */
    BAIT,

    /**
     * Burned
     * 
     */
    BURNED,

    /**
     * Cargo
     * 
     */
    CARGO,

    /**
     * Contraband
     * 
     */
    CONTRABAND,

    /**
     * Counterfeited, includes forged
     * 
     */
    COUNTERFEITED,

    /**
     * Cultivated
     * 
     */
    CULTIVATED,

    /**
     * Damaged
     * 
     */
    DAMAGED,

    /**
     * Destroyed
     * 
     */
    DESTROYED,

    /**
     * Destroyed_Damaged_Vandalized
     * 
     */
    DESTROYED_DAMAGED_VANDALIZED,

    /**
     * Found
     * 
     */
    FOUND,

    /**
     * Lost
     * 
     */
    LOST,

    /**
     * Recovered  (To impound property previously stolen)
     * 
     */
    RECOVERED,

    /**
     * Returned
     * 
     */
    RETURNED,

    /**
     * Seized (To impound property not previously stolen)
     * 
     */
    SEIZED,

    /**
     * Stolen
     * 
     */
    STOLEN,

    /**
     * Stolen_Bribed
     * 
     */
    STOLEN_BRIBED,

    /**
     * Stolen_Defrauded
     * 
     */
    STOLEN_DEFRAUDED,

    /**
     * Stolen_Embezzled
     * 
     */
    STOLEN_EMBEZZLED,

    /**
     * Stolen_Extorted
     * 
     */
    STOLEN_EXTORTED,

    /**
     * Stolen_Ransomed
     * 
     */
    STOLEN_RANSOMED,

    /**
     * Stolen_Robbed
     * 
     */
    STOLEN_ROBBED,

    /**
     * Vandalized
     * 
     */
    VANDALIZED,

    /**
     * None
     * 
     */
    NONE,

    /**
     * Unknown
     * 
     */
    UNKNOWN;

    public String value() {
        return name();
    }

    public static ItemStatusCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
