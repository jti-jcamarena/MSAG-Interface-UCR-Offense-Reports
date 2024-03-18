
package gov.niem.release.niem.codes.fbi_ndex._3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RACCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RACCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="A"/&gt;
 *     &lt;enumeration value="B"/&gt;
 *     &lt;enumeration value="I"/&gt;
 *     &lt;enumeration value="P"/&gt;
 *     &lt;enumeration value="U"/&gt;
 *     &lt;enumeration value="W"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RACCodeSimpleType", namespace = "http://release.niem.gov/niem/codes/fbi_ndex/3.1/")
@XmlEnum
public enum RACCodeSimpleType {


    /**
     * ASIAN:  A person having origins in any of the original peoples of the Far East, Southeast Asia, or the Indian subcontinent including, for example, Cambodia, China, India, Japan, Korea, Malaysia, Pakistan, the Philippine Islands, Thailand, and Vietnam.
     * 
     */
    A,

    /**
     * BLACK:  A person having origins in any of the black racial groups of Africa.
     * 
     */
    B,

    /**
     * AMERICAN INDIAN or ALASKAN NATIVE:  A person having origins in any of the original peoples of the Americas and maintaining cultural identification through tribal affiliations or community recognition.
     * 
     */
    I,

    /**
     * NATIVE HAWAIIAN or OTHER PACIFIC ISLANDER:  A person having origins in any of the original peoples of Hawaii, Guam, Samoa, or other Pacific Islands.  The term "Native Hawaiian" does not include individuals who are native to the State of Hawaii by virtue of being born there.  However, the following Pacific Islander groups are included:  Carolinian, Fijian, Kosraean, Melanesian, Micronesian, Northern Mariana Islander, Palauan, Papua New Guinean, Ponapean (Pohnpelan), Polynesian, Solomon Islander, Tahitian, Tarawa Islander, Tokelauan, Tongan, Trukese (Chuukese), and Yapese.
     * 
     */
    P,

    /**
     * UNKNOWN
     * 
     */
    U,

    /**
     * WHITE:  A person having origins in any of the original peoples of Europe, North Africa, or Middle East.
     * 
     */
    W;

    public String value() {
        return name();
    }

    public static RACCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
