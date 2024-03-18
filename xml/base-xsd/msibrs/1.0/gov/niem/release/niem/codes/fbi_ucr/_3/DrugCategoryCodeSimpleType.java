
package gov.niem.release.niem.codes.fbi_ucr._3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DrugCategoryCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DrugCategoryCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="A"/&gt;
 *     &lt;enumeration value="B"/&gt;
 *     &lt;enumeration value="C"/&gt;
 *     &lt;enumeration value="D"/&gt;
 *     &lt;enumeration value="E"/&gt;
 *     &lt;enumeration value="F"/&gt;
 *     &lt;enumeration value="G"/&gt;
 *     &lt;enumeration value="H"/&gt;
 *     &lt;enumeration value="I"/&gt;
 *     &lt;enumeration value="J"/&gt;
 *     &lt;enumeration value="K"/&gt;
 *     &lt;enumeration value="L"/&gt;
 *     &lt;enumeration value="M"/&gt;
 *     &lt;enumeration value="N"/&gt;
 *     &lt;enumeration value="O"/&gt;
 *     &lt;enumeration value="P"/&gt;
 *     &lt;enumeration value="U"/&gt;
 *     &lt;enumeration value="X"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DrugCategoryCodeSimpleType", namespace = "http://release.niem.gov/niem/codes/fbi_ucr/3.2/")
@XmlEnum
public enum DrugCategoryCodeSimpleType {


    /**
     * crack cocaine
     * 
     */
    A,

    /**
     * cocaine
     * 
     */
    B,

    /**
     * hashish
     * 
     */
    C,

    /**
     * heroin
     * 
     */
    D,

    /**
     * marijuana
     * 
     */
    E,

    /**
     * morphine
     * 
     */
    F,

    /**
     * opium
     * 
     */
    G,

    /**
     * other narcotics
     * 
     */
    H,

    /**
     * LSD
     * 
     */
    I,

    /**
     * PCP
     * 
     */
    J,

    /**
     * other hallucingens
     * 
     */
    K,

    /**
     * amphetamines/ methamphetamines
     * 
     */
    L,

    /**
     * other stimulants
     * 
     */
    M,

    /**
     * barbiturates
     * 
     */
    N,

    /**
     * other depressants
     * 
     */
    O,

    /**
     * other drugs
     * 
     */
    P,

    /**
     * unknown drug type
     * 
     */
    U,

    /**
     * over 3 drug types
     * 
     */
    X;

    public String value() {
        return name();
    }

    public static DrugCategoryCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
