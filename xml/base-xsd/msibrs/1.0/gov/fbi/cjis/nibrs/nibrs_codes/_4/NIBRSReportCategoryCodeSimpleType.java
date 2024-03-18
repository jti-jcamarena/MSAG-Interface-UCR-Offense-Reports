
package gov.fbi.cjis.nibrs.nibrs_codes._4;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NIBRSReportCategoryCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NIBRSReportCategoryCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="GROUP A INCIDENT REPORT"/&gt;
 *     &lt;enumeration value="GROUP B ARREST REPORT"/&gt;
 *     &lt;enumeration value="ZERO REPORT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "NIBRSReportCategoryCodeSimpleType", namespace = "http://fbi.gov/cjis/nibrs/nibrs-codes/4.2")
@XmlEnum
public enum NIBRSReportCategoryCodeSimpleType {


    /**
     * Group A Incident Report
     * 
     */
    @XmlEnumValue("GROUP A INCIDENT REPORT")
    GROUP_A_INCIDENT_REPORT("GROUP A INCIDENT REPORT"),

    /**
     * Group B Arrest Report
     * 
     */
    @XmlEnumValue("GROUP B ARREST REPORT")
    GROUP_B_ARREST_REPORT("GROUP B ARREST REPORT"),

    /**
     * Zero Report
     * 
     */
    @XmlEnumValue("ZERO REPORT")
    ZERO_REPORT("ZERO REPORT");
    private final String value;

    NIBRSReportCategoryCodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NIBRSReportCategoryCodeSimpleType fromValue(String v) {
        for (NIBRSReportCategoryCodeSimpleType c: NIBRSReportCategoryCodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
