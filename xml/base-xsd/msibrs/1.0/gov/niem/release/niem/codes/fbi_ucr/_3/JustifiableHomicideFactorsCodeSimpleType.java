
package gov.niem.release.niem.codes.fbi_ucr._3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JustifiableHomicideFactorsCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JustifiableHomicideFactorsCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="A"/&gt;
 *     &lt;enumeration value="B"/&gt;
 *     &lt;enumeration value="C"/&gt;
 *     &lt;enumeration value="D"/&gt;
 *     &lt;enumeration value="E"/&gt;
 *     &lt;enumeration value="F"/&gt;
 *     &lt;enumeration value="G"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "JustifiableHomicideFactorsCodeSimpleType", namespace = "http://release.niem.gov/niem/codes/fbi_ucr/3.2/")
@XmlEnum
public enum JustifiableHomicideFactorsCodeSimpleType {


    /**
     * Criminal Attacked Police Officer and That Officer Killed Criminal
     * 
     */
    A,

    /**
     * Criminal Attacked Police Officer and Criminal Killed by Another Police Officer
     * 
     */
    B,

    /**
     * Criminal Attacked a Civilian
     * 
     */
    C,

    /**
     * Criminal Attempted Flight From a Crime
     * 
     */
    D,

    /**
     * Criminal Killed in Commission of a Crime
     * 
     */
    E,

    /**
     * Criminal Resisted Arrest
     * 
     */
    F,

    /**
     * Unable to Determine/Not Enough Information
     * 
     */
    G;

    public String value() {
        return name();
    }

    public static JustifiableHomicideFactorsCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
