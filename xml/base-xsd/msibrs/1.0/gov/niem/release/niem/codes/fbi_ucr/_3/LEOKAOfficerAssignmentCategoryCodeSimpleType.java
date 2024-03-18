
package gov.niem.release.niem.codes.fbi_ucr._3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LEOKAOfficerAssignmentCategoryCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LEOKAOfficerAssignmentCategoryCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="F"/&gt;
 *     &lt;enumeration value="G"/&gt;
 *     &lt;enumeration value="H"/&gt;
 *     &lt;enumeration value="I"/&gt;
 *     &lt;enumeration value="J"/&gt;
 *     &lt;enumeration value="K"/&gt;
 *     &lt;enumeration value="L"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "LEOKAOfficerAssignmentCategoryCodeSimpleType", namespace = "http://release.niem.gov/niem/codes/fbi_ucr/3.2/")
@XmlEnum
public enum LEOKAOfficerAssignmentCategoryCodeSimpleType {


    /**
     * Two-Officer Vehicle - uniformed law enforcement officers
     * 
     */
    F,

    /**
     * One-Officer Vehicle (Alone) - uniformed law enforcement officers
     * 
     */
    G,

    /**
     * One-Officer Vehicle (Assisted) - uniformed law enforcement officers
     * 
     */
    H,

    /**
     * Detective or Special Assignment (Alone) - non-uniformed officers
     * 
     */
    I,

    /**
     * Detective or Special Assignment (Assisted) - non-uniformed officers
     * 
     */
    J,

    /**
     * Other (Alone) - law enforcement officers serving in other capacities (foot patrol, off duty, etc.)
     * 
     */
    K,

    /**
     * Other (Assisted) - law enforcement officers serving in other capacities (foot patrol, off duty, etc.)
     * 
     */
    L;

    public String value() {
        return name();
    }

    public static LEOKAOfficerAssignmentCategoryCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
