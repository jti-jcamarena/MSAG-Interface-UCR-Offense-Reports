
package gov.niem.release.niem.codes.fbi_ucr._3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrestCategoryCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ArrestCategoryCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="O"/&gt;
 *     &lt;enumeration value="S"/&gt;
 *     &lt;enumeration value="T"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ArrestCategoryCodeSimpleType", namespace = "http://release.niem.gov/niem/codes/fbi_ucr/3.2/")
@XmlEnum
public enum ArrestCategoryCodeSimpleType {


    /**
     * On-View Arrest
     * 
     */
    O,

    /**
     * Summoned/ Cited
     * 
     */
    S,

    /**
     * Taken Into Custody
     * 
     */
    T;

    public String value() {
        return name();
    }

    public static ArrestCategoryCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
