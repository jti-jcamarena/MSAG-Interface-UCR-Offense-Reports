
package gov.niem.release.niem.codes.fbi_ucr._3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DrugMeasurementCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DrugMeasurementCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="DU"/&gt;
 *     &lt;enumeration value="FO"/&gt;
 *     &lt;enumeration value="GL"/&gt;
 *     &lt;enumeration value="GM"/&gt;
 *     &lt;enumeration value="KG"/&gt;
 *     &lt;enumeration value="LB"/&gt;
 *     &lt;enumeration value="LT"/&gt;
 *     &lt;enumeration value="ML"/&gt;
 *     &lt;enumeration value="NP"/&gt;
 *     &lt;enumeration value="OZ"/&gt;
 *     &lt;enumeration value="XX"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DrugMeasurementCodeSimpleType", namespace = "http://release.niem.gov/niem/codes/fbi_ucr/3.2/")
@XmlEnum
public enum DrugMeasurementCodeSimpleType {


    /**
     * Dosage Units/ Items
     * 
     */
    DU,

    /**
     * Fluid Ounce
     * 
     */
    FO,

    /**
     * Gallon
     * 
     */
    GL,

    /**
     * Gram
     * 
     */
    GM,

    /**
     * Kilogram
     * 
     */
    KG,

    /**
     * Pound
     * 
     */
    LB,

    /**
     * Liter
     * 
     */
    LT,

    /**
     * Milliliter
     * 
     */
    ML,

    /**
     * Number of Plants
     * 
     */
    NP,

    /**
     * Ounce
     * 
     */
    OZ,

    /**
     * Not Reported
     * 
     */
    XX;

    public String value() {
        return name();
    }

    public static DrugMeasurementCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
