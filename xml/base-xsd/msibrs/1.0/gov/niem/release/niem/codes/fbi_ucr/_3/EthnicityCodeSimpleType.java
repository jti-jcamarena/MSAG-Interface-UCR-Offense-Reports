
package gov.niem.release.niem.codes.fbi_ucr._3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EthnicityCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EthnicityCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="H"/&gt;
 *     &lt;enumeration value="N"/&gt;
 *     &lt;enumeration value="U"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EthnicityCodeSimpleType", namespace = "http://release.niem.gov/niem/codes/fbi_ucr/3.2/")
@XmlEnum
public enum EthnicityCodeSimpleType {


    /**
     * Hispanic or Latino
     * 
     */
    H,

    /**
     * Not Hispanic or Latino
     * 
     */
    N,

    /**
     * Unknown
     * 
     */
    U;

    public String value() {
        return name();
    }

    public static EthnicityCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
