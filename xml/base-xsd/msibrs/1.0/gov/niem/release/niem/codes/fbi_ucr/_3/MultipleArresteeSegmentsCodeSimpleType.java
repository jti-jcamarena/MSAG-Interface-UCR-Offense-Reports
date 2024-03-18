
package gov.niem.release.niem.codes.fbi_ucr._3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MultipleArresteeSegmentsCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MultipleArresteeSegmentsCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="C"/&gt;
 *     &lt;enumeration value="M"/&gt;
 *     &lt;enumeration value="N"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MultipleArresteeSegmentsCodeSimpleType", namespace = "http://release.niem.gov/niem/codes/fbi_ucr/3.2/")
@XmlEnum
public enum MultipleArresteeSegmentsCodeSimpleType {


    /**
     * Count Arrestee
     * 
     */
    C,

    /**
     * Multiple
     * 
     */
    M,

    /**
     * Not Applicable
     * 
     */
    N;

    public String value() {
        return name();
    }

    public static MultipleArresteeSegmentsCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
