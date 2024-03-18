
package gov.fbi.cjis.nibrs.nibrs_codes._4;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportActionCategoryCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportActionCategoryCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="A"/&gt;
 *     &lt;enumeration value="I"/&gt;
 *     &lt;enumeration value="D"/&gt;
 *     &lt;enumeration value="R"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ReportActionCategoryCodeSimpleType", namespace = "http://fbi.gov/cjis/nibrs/nibrs-codes/4.2")
@XmlEnum
public enum ReportActionCategoryCodeSimpleType {


    /**
     * Add Report
     * 
     */
    A,

    /**
     * Incident Report
     * 
     */
    I,

    /**
     * Delete
     * 
     */
    D,

    /**
     * Replace
     * 
     */
    R;

    public String value() {
        return name();
    }

    public static ReportActionCategoryCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
