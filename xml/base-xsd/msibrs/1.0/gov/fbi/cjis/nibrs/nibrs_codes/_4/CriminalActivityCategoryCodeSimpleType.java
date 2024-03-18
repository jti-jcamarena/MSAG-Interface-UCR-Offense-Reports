
package gov.fbi.cjis.nibrs.nibrs_codes._4;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CriminalActivityCategoryCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CriminalActivityCategoryCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="A"/&gt;
 *     &lt;enumeration value="B"/&gt;
 *     &lt;enumeration value="C"/&gt;
 *     &lt;enumeration value="D"/&gt;
 *     &lt;enumeration value="E"/&gt;
 *     &lt;enumeration value="F"/&gt;
 *     &lt;enumeration value="G"/&gt;
 *     &lt;enumeration value="I"/&gt;
 *     &lt;enumeration value="J"/&gt;
 *     &lt;enumeration value="N"/&gt;
 *     &lt;enumeration value="O"/&gt;
 *     &lt;enumeration value="P"/&gt;
 *     &lt;enumeration value="S"/&gt;
 *     &lt;enumeration value="T"/&gt;
 *     &lt;enumeration value="U"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CriminalActivityCategoryCodeSimpleType", namespace = "http://fbi.gov/cjis/nibrs/nibrs-codes/4.2")
@XmlEnum
public enum CriminalActivityCategoryCodeSimpleType {


    /**
     * Simple/Gross Neglect
     * 
     */
    A,

    /**
     * Buying/Receiving
     * 
     */
    B,

    /**
     * Cultivating/Manufacturing/Publishing (i.e., production of any type)
     * 
     */
    C,

    /**
     * Distributing/Selling
     * 
     */
    D,

    /**
     * Exploiting Children
     * 
     */
    E,

    /**
     * Organized Abuse (Dog Fighting and Cock Fighting)
     * 
     */
    F,

    /**
     * Other Gang
     * 
     */
    G,

    /**
     * Intentional Abuse and Torture (tormenting, mutilating, maiming,poisoning, or abandonment)
     * 
     */
    I,

    /**
     * Juvenile Gang
     * 
     */
    J,

    /**
     * None/Unknown
     * 
     */
    N,

    /**
     * Operating/Promoting/Assisting
     * 
     */
    O,

    /**
     * Possessing/Concealing
     * 
     */
    P,

    /**
     * Animal Sexual Abuse (Bestiality)
     * 
     */
    S,

    /**
     * Transporting/Transmitting/Importing
     * 
     */
    T,

    /**
     * Using/Consuming
     * 
     */
    U;

    public String value() {
        return name();
    }

    public static CriminalActivityCategoryCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
