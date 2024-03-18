
package gov.niem.release.niem.codes.fbi_ucr._3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VictimCategoryCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VictimCategoryCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="B"/&gt;
 *     &lt;enumeration value="F"/&gt;
 *     &lt;enumeration value="G"/&gt;
 *     &lt;enumeration value="I"/&gt;
 *     &lt;enumeration value="L"/&gt;
 *     &lt;enumeration value="O"/&gt;
 *     &lt;enumeration value="R"/&gt;
 *     &lt;enumeration value="S"/&gt;
 *     &lt;enumeration value="U"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "VictimCategoryCodeSimpleType", namespace = "http://release.niem.gov/niem/codes/fbi_ucr/3.2/")
@XmlEnum
public enum VictimCategoryCodeSimpleType {


    /**
     * Business
     * 
     */
    B,

    /**
     * Financial Institution
     * 
     */
    F,

    /**
     * Government
     * 
     */
    G,

    /**
     * Individual
     * 
     */
    I,

    /**
     * Law Enforcement Officer
     * 
     */
    L,

    /**
     * Other
     * 
     */
    O,

    /**
     * Religious Organization
     * 
     */
    R,

    /**
     * Society/ Public
     * 
     */
    S,

    /**
     * Unknown
     * 
     */
    U;

    public String value() {
        return name();
    }

    public static VictimCategoryCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
