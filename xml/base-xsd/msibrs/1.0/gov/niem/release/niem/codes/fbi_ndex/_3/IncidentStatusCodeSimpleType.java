
package gov.niem.release.niem.codes.fbi_ndex._3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IncidentStatusCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IncidentStatusCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="ACTIVE"/&gt;
 *     &lt;enumeration value="ADMINISTRATIVELY CLOSED"/&gt;
 *     &lt;enumeration value="CLEARED BY ARREST"/&gt;
 *     &lt;enumeration value="CLEARED BY EXCEPTIONAL MEANS"/&gt;
 *     &lt;enumeration value="CLOSED"/&gt;
 *     &lt;enumeration value="COLD"/&gt;
 *     &lt;enumeration value="INACTIVE"/&gt;
 *     &lt;enumeration value="OPEN"/&gt;
 *     &lt;enumeration value="PENDING"/&gt;
 *     &lt;enumeration value="RE_OPENED"/&gt;
 *     &lt;enumeration value="UNFOUNDED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IncidentStatusCodeSimpleType", namespace = "http://release.niem.gov/niem/codes/fbi_ndex/3.1/")
@XmlEnum
public enum IncidentStatusCodeSimpleType {


    /**
     * Active
     * 
     */
    ACTIVE("ACTIVE"),

    /**
     * Administratively Closed
     * 
     */
    @XmlEnumValue("ADMINISTRATIVELY CLOSED")
    ADMINISTRATIVELY_CLOSED("ADMINISTRATIVELY CLOSED"),

    /**
     * Cleared by Arrest
     * 
     */
    @XmlEnumValue("CLEARED BY ARREST")
    CLEARED_BY_ARREST("CLEARED BY ARREST"),

    /**
     * Cleared by Exceptional Means
     * 
     */
    @XmlEnumValue("CLEARED BY EXCEPTIONAL MEANS")
    CLEARED_BY_EXCEPTIONAL_MEANS("CLEARED BY EXCEPTIONAL MEANS"),

    /**
     * Closed
     * 
     */
    CLOSED("CLOSED"),

    /**
     * Cold
     * 
     */
    COLD("COLD"),

    /**
     * Inactive
     * 
     */
    INACTIVE("INACTIVE"),

    /**
     * Open
     * 
     */
    OPEN("OPEN"),

    /**
     * Pending
     * 
     */
    PENDING("PENDING"),

    /**
     * Re_opened
     * 
     */
    RE_OPENED("RE_OPENED"),

    /**
     * Unfounded
     * 
     */
    UNFOUNDED("UNFOUNDED");
    private final String value;

    IncidentStatusCodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IncidentStatusCodeSimpleType fromValue(String v) {
        for (IncidentStatusCodeSimpleType c: IncidentStatusCodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
