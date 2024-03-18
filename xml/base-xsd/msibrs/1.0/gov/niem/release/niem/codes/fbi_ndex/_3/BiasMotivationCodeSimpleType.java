
package gov.niem.release.niem.codes.fbi_ndex._3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BiasMotivationCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BiasMotivationCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="ANTIAMERICAN INDIAN_ ALASKAN NATIVE"/&gt;
 *     &lt;enumeration value="ANTIARAB"/&gt;
 *     &lt;enumeration value="ANTIASIAN"/&gt;
 *     &lt;enumeration value="ANTIATHEIST_AGNOSTIC"/&gt;
 *     &lt;enumeration value="ANTIBISEXUAL"/&gt;
 *     &lt;enumeration value="ANTIBLACK_AFRICAN AMERICAN"/&gt;
 *     &lt;enumeration value="ANTIBUDDHIST"/&gt;
 *     &lt;enumeration value="ANTICATHOLIC"/&gt;
 *     &lt;enumeration value="ANTIEASTERNORTHODOX"/&gt;
 *     &lt;enumeration value="ANTIFEMALE"/&gt;
 *     &lt;enumeration value="ANTIFEMALE HOMOSEXUAL"/&gt;
 *     &lt;enumeration value="ANTIGENDER_NONCONFORMING"/&gt;
 *     &lt;enumeration value="ANTIHETEROSEXUAL"/&gt;
 *     &lt;enumeration value="ANTIHINDU"/&gt;
 *     &lt;enumeration value="ANTIHISPANIC_LATINO"/&gt;
 *     &lt;enumeration value="ANTIHOMOSEXUAL"/&gt;
 *     &lt;enumeration value="ANTIISLAMIC"/&gt;
 *     &lt;enumeration value="ANTIJEHOVAHWITNESS"/&gt;
 *     &lt;enumeration value="ANTIJEWISH"/&gt;
 *     &lt;enumeration value="ANTIMALE"/&gt;
 *     &lt;enumeration value="ANTIMALE HOMOSEXUAL"/&gt;
 *     &lt;enumeration value="ANTIMENTAL DISABILITY"/&gt;
 *     &lt;enumeration value="ANTIMORMON"/&gt;
 *     &lt;enumeration value="ANTIMULTIRACIAL GROUP"/&gt;
 *     &lt;enumeration value="ANTIMULTIRELIGIOUS GROUP"/&gt;
 *     &lt;enumeration value="ANTINATIVEHAWAIIAN_OTHERPACIFICISLANDER"/&gt;
 *     &lt;enumeration value="ANTIOTHER CHRISTIAN"/&gt;
 *     &lt;enumeration value="ANTIOTHER ETHNICITY_NATIONAL ORIGIN"/&gt;
 *     &lt;enumeration value="ANTIOTHER RELIGION"/&gt;
 *     &lt;enumeration value="ANTIPHYSICAL DISABILITY"/&gt;
 *     &lt;enumeration value="ANTIPROTESTANT"/&gt;
 *     &lt;enumeration value="ANTISIKH"/&gt;
 *     &lt;enumeration value="ANTITRANSGENDER"/&gt;
 *     &lt;enumeration value="ANTIWHITE"/&gt;
 *     &lt;enumeration value="NONE"/&gt;
 *     &lt;enumeration value="UNKNOWN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "BiasMotivationCodeSimpleType", namespace = "http://release.niem.gov/niem/codes/fbi_ndex/3.1/")
@XmlEnum
public enum BiasMotivationCodeSimpleType {


    /**
     * Anti-American Indian or Alaskan Native_race ethnicity bias
     * 
     */
    @XmlEnumValue("ANTIAMERICAN INDIAN_ ALASKAN NATIVE")
    ANTIAMERICAN_INDIAN_ALASKAN_NATIVE("ANTIAMERICAN INDIAN_ ALASKAN NATIVE"),

    /**
     * Anti-Arab_race ethnicity bias
     * 
     */
    ANTIARAB("ANTIARAB"),

    /**
     * Anti-Asian_race ethnicity bias
     * 
     */
    ANTIASIAN("ANTIASIAN"),

    /**
     * Anti-Atheist or Agnostic_religious bias
     * 
     */
    ANTIATHEIST_AGNOSTIC("ANTIATHEIST_AGNOSTIC"),

    /**
     * Anti-Bisexual
     * 
     */
    ANTIBISEXUAL("ANTIBISEXUAL"),

    /**
     * Anti-Black or African American_race ethnicity bias
     * 
     */
    @XmlEnumValue("ANTIBLACK_AFRICAN AMERICAN")
    ANTIBLACK_AFRICAN_AMERICAN("ANTIBLACK_AFRICAN AMERICAN"),

    /**
     * Anti-Buddhist_religious bias
     * 
     */
    ANTIBUDDHIST("ANTIBUDDHIST"),

    /**
     * Anti-Catholic religion_religious bias
     * 
     */
    ANTICATHOLIC("ANTICATHOLIC"),

    /**
     * Anti-Eastern Orthodox (Russian, Greek, Other)_religious bias
     * 
     */
    ANTIEASTERNORTHODOX("ANTIEASTERNORTHODOX"),

    /**
     * Anti-Female_gender bias
     * 
     */
    ANTIFEMALE("ANTIFEMALE"),

    /**
     * Anti-Female Homosexual (Lesbian) _sexual orientation bias
     * 
     */
    @XmlEnumValue("ANTIFEMALE HOMOSEXUAL")
    ANTIFEMALE_HOMOSEXUAL("ANTIFEMALE HOMOSEXUAL"),

    /**
     * Anti-Gender Non-Conforming
     * 
     */
    ANTIGENDER_NONCONFORMING("ANTIGENDER_NONCONFORMING"),

    /**
     * Anti-Heterosexual _sexual orientation bias
     * 
     */
    ANTIHETEROSEXUAL("ANTIHETEROSEXUAL"),

    /**
     * Anti-Hindu_religious bias
     * 
     */
    ANTIHINDU("ANTIHINDU"),

    /**
     * Anti-Hispanic or Latino_race ethnicity bias
     * 
     */
    ANTIHISPANIC_LATINO("ANTIHISPANIC_LATINO"),

    /**
     * Anti-Homosexual, e.g., Lesbian, Gay, Bisexual, and transgender (mixed group), _sexual orientation bias
     * 
     */
    ANTIHOMOSEXUAL("ANTIHOMOSEXUAL"),

    /**
     * Anti-Islamic, includes muslim_religious bias
     * 
     */
    ANTIISLAMIC("ANTIISLAMIC"),

    /**
     * Anti-Jehovah's Witness_religious bias
     * 
     */
    ANTIJEHOVAHWITNESS("ANTIJEHOVAHWITNESS"),

    /**
     * Anti-Jewish_religious bias
     * 
     */
    ANTIJEWISH("ANTIJEWISH"),

    /**
     * Anti-Male_gender bias
     * 
     */
    ANTIMALE("ANTIMALE"),

    /**
     * Anti-Male Homosexual (Gay) _sexual orientation bias
     * 
     */
    @XmlEnumValue("ANTIMALE HOMOSEXUAL")
    ANTIMALE_HOMOSEXUAL("ANTIMALE HOMOSEXUAL"),

    /**
     * Anti-Mental Disability_disability bias
     * 
     */
    @XmlEnumValue("ANTIMENTAL DISABILITY")
    ANTIMENTAL_DISABILITY("ANTIMENTAL DISABILITY"),

    /**
     * Anti-Mormon_religious bias
     * 
     */
    ANTIMORMON("ANTIMORMON"),

    /**
     * Anti-Multi-Racial Group, e.g., Arab and Asian and American Indian and White and etc._race ethnicity bias
     * 
     */
    @XmlEnumValue("ANTIMULTIRACIAL GROUP")
    ANTIMULTIRACIAL_GROUP("ANTIMULTIRACIAL GROUP"),

    /**
     * Anti-Multi-Religious Group, e.g., Catholic and Mormon and Islamic and etc._religious bias
     * 
     */
    @XmlEnumValue("ANTIMULTIRELIGIOUS GROUP")
    ANTIMULTIRELIGIOUS_GROUP("ANTIMULTIRELIGIOUS GROUP"),

    /**
     * Anti-Native Hawaiian or Other Pacific Islander_race ethnicity bias
     * 
     */
    ANTINATIVEHAWAIIAN_OTHERPACIFICISLANDER("ANTINATIVEHAWAIIAN_OTHERPACIFICISLANDER"),

    /**
     * Anti-Other Christian_religious bias
     * 
     */
    @XmlEnumValue("ANTIOTHER CHRISTIAN")
    ANTIOTHER_CHRISTIAN("ANTIOTHER CHRISTIAN"),

    /**
     * Anti-Other Race, Ethnicity, Ancestry, or National Origin_race ethnicity bias
     * 
     */
    @XmlEnumValue("ANTIOTHER ETHNICITY_NATIONAL ORIGIN")
    ANTIOTHER_ETHNICITY_NATIONAL_ORIGIN("ANTIOTHER ETHNICITY_NATIONAL ORIGIN"),

    /**
     * Anti-Other Religion_religious bias
     * 
     */
    @XmlEnumValue("ANTIOTHER RELIGION")
    ANTIOTHER_RELIGION("ANTIOTHER RELIGION"),

    /**
     * Anti-Physical Disability_disability bias
     * 
     */
    @XmlEnumValue("ANTIPHYSICAL DISABILITY")
    ANTIPHYSICAL_DISABILITY("ANTIPHYSICAL DISABILITY"),

    /**
     * Anti-Protestant_religious bias
     * 
     */
    ANTIPROTESTANT("ANTIPROTESTANT"),

    /**
     * Anti-Sikh_religious bias
     * 
     */
    ANTISIKH("ANTISIKH"),

    /**
     * Anti-Transgender_gender identity
     * 
     */
    ANTITRANSGENDER("ANTITRANSGENDER"),

    /**
     * Anti-White_race ethnicity bias
     * 
     */
    ANTIWHITE("ANTIWHITE"),

    /**
     * None (no bias)
     * 
     */
    NONE("NONE"),

    /**
     * Unknown (offender's motivation not known)
     * 
     */
    UNKNOWN("UNKNOWN");
    private final String value;

    BiasMotivationCodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BiasMotivationCodeSimpleType fromValue(String v) {
        for (BiasMotivationCodeSimpleType c: BiasMotivationCodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
