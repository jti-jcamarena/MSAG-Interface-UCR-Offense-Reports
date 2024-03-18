
package gov.niem.release.niem.codes.fbi_ncic._3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SEXCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SEXCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="F"/&gt;
 *     &lt;enumeration value="M"/&gt;
 *     &lt;enumeration value="U"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SEXCodeSimpleType", namespace = "http://release.niem.gov/niem/codes/fbi_ncic/3.2/")
@XmlEnum
public enum SEXCodeSimpleType {


    /**
     * Female
     * 
     */
    F,

    /**
     * Male
     * 
     */
    M,

    /**
     * Unknown - For Unidentified Only
     * 
     */
    U;

    public String value() {
        return name();
    }

    public static SEXCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
