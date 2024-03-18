
package gov.niem.release.niem.codes.fbi_ucr._3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IncidentExceptionalClearanceCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IncidentExceptionalClearanceCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="A"/&gt;
 *     &lt;enumeration value="B"/&gt;
 *     &lt;enumeration value="C"/&gt;
 *     &lt;enumeration value="D"/&gt;
 *     &lt;enumeration value="E"/&gt;
 *     &lt;enumeration value="N"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IncidentExceptionalClearanceCodeSimpleType", namespace = "http://release.niem.gov/niem/codes/fbi_ucr/3.2/")
@XmlEnum
public enum IncidentExceptionalClearanceCodeSimpleType {


    /**
     * Death of Offender
     * 
     */
    A,

    /**
     * Prosecution Declined (by the prosecutor for other than lack of probable cause)
     * 
     */
    B,

    /**
     * In Custody of Other Jurisdiction
     * 
     */
    C,

    /**
     * Victim Refused to Cooperate (in the prosecution)
     * 
     */
    D,

    /**
     * Juvenile/No Custody (the handling of a juvenile without taking him/her into custody, but rather by oral or written notice given to the parents or legal guardian in a case involving a minor offense, such as a petty larceny)
     * 
     */
    E,

    /**
     * Not Applicable (not cleared exceptionally)
     * 
     */
    N;

    public String value() {
        return name();
    }

    public static IncidentExceptionalClearanceCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
