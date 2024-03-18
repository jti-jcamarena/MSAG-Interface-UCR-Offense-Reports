
package gov.niem.release.niem.codes.fbi_ndex._3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JuvenileDispositionCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JuvenileDispositionCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="H"/&gt;
 *     &lt;enumeration value="R"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "JuvenileDispositionCodeSimpleType", namespace = "http://release.niem.gov/niem/codes/fbi_ndex/3.1/")
@XmlEnum
public enum JuvenileDispositionCodeSimpleType {


    /**
     * Handled Within Department 
     * 
     */
    H,

    /**
     * Referred to Other Authorities
     * 
     */
    R;

    public String value() {
        return name();
    }

    public static JuvenileDispositionCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
