
package gov.fbi.cjis.nibrs.nibrs_codes._4;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VictimToSubjectRelationshipCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VictimToSubjectRelationshipCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="Accomplice"/&gt;
 *     &lt;enumeration value="Acquaintance"/&gt;
 *     &lt;enumeration value="Authority Figure"/&gt;
 *     &lt;enumeration value="Babysittee"/&gt;
 *     &lt;enumeration value="Babysitter"/&gt;
 *     &lt;enumeration value="Boyfriend_Girlfriend"/&gt;
 *     &lt;enumeration value="Caregiver"/&gt;
 *     &lt;enumeration value="Child of Boyfriend_Girlfriend"/&gt;
 *     &lt;enumeration value="Client"/&gt;
 *     &lt;enumeration value="Cohabitant"/&gt;
 *     &lt;enumeration value="Delivery Person"/&gt;
 *     &lt;enumeration value="Employee"/&gt;
 *     &lt;enumeration value="Employer"/&gt;
 *     &lt;enumeration value="Ex_Relationship"/&gt;
 *     &lt;enumeration value="Ex_Spouse"/&gt;
 *     &lt;enumeration value="Family Member"/&gt;
 *     &lt;enumeration value="Family Member_Aunt"/&gt;
 *     &lt;enumeration value="Family Member_Child"/&gt;
 *     &lt;enumeration value="Family Member_Cousin"/&gt;
 *     &lt;enumeration value="Family Member_Foster Child"/&gt;
 *     &lt;enumeration value="Family Member_Foster Parent"/&gt;
 *     &lt;enumeration value="Family Member_Grandchild"/&gt;
 *     &lt;enumeration value="Family Member_Grandparent"/&gt;
 *     &lt;enumeration value="Family Member_In-Law"/&gt;
 *     &lt;enumeration value="Family Member_Nephew"/&gt;
 *     &lt;enumeration value="Family Member_Niece"/&gt;
 *     &lt;enumeration value="Family Member_Parent"/&gt;
 *     &lt;enumeration value="Family Member_Sibling"/&gt;
 *     &lt;enumeration value="Family Member_Spouse"/&gt;
 *     &lt;enumeration value="Family Member_Spouse_Common Law"/&gt;
 *     &lt;enumeration value="Family Member_Stepchild"/&gt;
 *     &lt;enumeration value="Family Member_Stepparent"/&gt;
 *     &lt;enumeration value="Family Member_Stepsibling"/&gt;
 *     &lt;enumeration value="Family Member_Uncle"/&gt;
 *     &lt;enumeration value="Former Employee"/&gt;
 *     &lt;enumeration value="Former Employer"/&gt;
 *     &lt;enumeration value="Friend"/&gt;
 *     &lt;enumeration value="Guardian"/&gt;
 *     &lt;enumeration value="Homosexual relationship"/&gt;
 *     &lt;enumeration value="Neighbor"/&gt;
 *     &lt;enumeration value="NonFamily_Otherwise Known"/&gt;
 *     &lt;enumeration value="Patient"/&gt;
 *     &lt;enumeration value="Relationship Unknown"/&gt;
 *     &lt;enumeration value="Stranger"/&gt;
 *     &lt;enumeration value="Student"/&gt;
 *     &lt;enumeration value="Teacher"/&gt;
 *     &lt;enumeration value="Victim Was Offender"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "VictimToSubjectRelationshipCodeSimpleType", namespace = "http://fbi.gov/cjis/nibrs/nibrs-codes/4.2")
@XmlEnum
public enum VictimToSubjectRelationshipCodeSimpleType {


    /**
     * Accomplice
     * 
     */
    @XmlEnumValue("Accomplice")
    ACCOMPLICE("Accomplice"),

    /**
     * Acquaintance
     * 
     */
    @XmlEnumValue("Acquaintance")
    ACQUAINTANCE("Acquaintance"),

    /**
     * Authority Figure
     * 
     */
    @XmlEnumValue("Authority Figure")
    AUTHORITY_FIGURE("Authority Figure"),

    /**
     * Babysittee
     * 
     */
    @XmlEnumValue("Babysittee")
    BABYSITTEE("Babysittee"),

    /**
     * Babysitter
     * 
     */
    @XmlEnumValue("Babysitter")
    BABYSITTER("Babysitter"),

    /**
     * Boyfriend/Girlfriend
     * 
     */
    @XmlEnumValue("Boyfriend_Girlfriend")
    BOYFRIEND_GIRLFRIEND("Boyfriend_Girlfriend"),

    /**
     * Caregiver
     * 
     */
    @XmlEnumValue("Caregiver")
    CAREGIVER("Caregiver"),

    /**
     * Child of Boyfriend_Girlfriend
     * 
     */
    @XmlEnumValue("Child of Boyfriend_Girlfriend")
    CHILD_OF_BOYFRIEND_GIRLFRIEND("Child of Boyfriend_Girlfriend"),

    /**
     * Client
     * 
     */
    @XmlEnumValue("Client")
    CLIENT("Client"),

    /**
     * Cohabitant
     * 
     */
    @XmlEnumValue("Cohabitant")
    COHABITANT("Cohabitant"),

    /**
     * Delivery Person
     * 
     */
    @XmlEnumValue("Delivery Person")
    DELIVERY_PERSON("Delivery Person"),

    /**
     * Employee
     * 
     */
    @XmlEnumValue("Employee")
    EMPLOYEE("Employee"),

    /**
     * Employer
     * 
     */
    @XmlEnumValue("Employer")
    EMPLOYER("Employer"),

    /**
     * Ex-Relationship (Ex-Boyfriend/Ex-Girlfriend)
     * 
     */
    @XmlEnumValue("Ex_Relationship")
    EX_RELATIONSHIP("Ex_Relationship"),

    /**
     * Ex_Spouse
     * 
     */
    @XmlEnumValue("Ex_Spouse")
    EX_SPOUSE("Ex_Spouse"),

    /**
     * Family Member
     * 
     */
    @XmlEnumValue("Family Member")
    FAMILY_MEMBER("Family Member"),

    /**
     * Aunt
     * 
     */
    @XmlEnumValue("Family Member_Aunt")
    FAMILY_MEMBER_AUNT("Family Member_Aunt"),

    /**
     * Child
     * 
     */
    @XmlEnumValue("Family Member_Child")
    FAMILY_MEMBER_CHILD("Family Member_Child"),

    /**
     * Cousin
     * 
     */
    @XmlEnumValue("Family Member_Cousin")
    FAMILY_MEMBER_COUSIN("Family Member_Cousin"),

    /**
     * Family Member_Foster Child
     * 
     */
    @XmlEnumValue("Family Member_Foster Child")
    FAMILY_MEMBER_FOSTER_CHILD("Family Member_Foster Child"),

    /**
     * Family Member_Foster Parent
     * 
     */
    @XmlEnumValue("Family Member_Foster Parent")
    FAMILY_MEMBER_FOSTER_PARENT("Family Member_Foster Parent"),

    /**
     * Grandchild
     * 
     */
    @XmlEnumValue("Family Member_Grandchild")
    FAMILY_MEMBER_GRANDCHILD("Family Member_Grandchild"),

    /**
     * Grandparent
     * 
     */
    @XmlEnumValue("Family Member_Grandparent")
    FAMILY_MEMBER_GRANDPARENT("Family Member_Grandparent"),

    /**
     * In-Law
     * 
     */
    @XmlEnumValue("Family Member_In-Law")
    FAMILY_MEMBER_IN_LAW("Family Member_In-Law"),

    /**
     * Nephew
     * 
     */
    @XmlEnumValue("Family Member_Nephew")
    FAMILY_MEMBER_NEPHEW("Family Member_Nephew"),

    /**
     * Niece
     * 
     */
    @XmlEnumValue("Family Member_Niece")
    FAMILY_MEMBER_NIECE("Family Member_Niece"),

    /**
     * Parent
     * 
     */
    @XmlEnumValue("Family Member_Parent")
    FAMILY_MEMBER_PARENT("Family Member_Parent"),

    /**
     * Sibling
     * 
     */
    @XmlEnumValue("Family Member_Sibling")
    FAMILY_MEMBER_SIBLING("Family Member_Sibling"),

    /**
     * Family Member_Spouse 
     * 
     */
    @XmlEnumValue("Family Member_Spouse")
    FAMILY_MEMBER_SPOUSE("Family Member_Spouse"),

    /**
     * Spouse_Common Law
     * 
     */
    @XmlEnumValue("Family Member_Spouse_Common Law")
    FAMILY_MEMBER_SPOUSE_COMMON_LAW("Family Member_Spouse_Common Law"),

    /**
     * Stepchild
     * 
     */
    @XmlEnumValue("Family Member_Stepchild")
    FAMILY_MEMBER_STEPCHILD("Family Member_Stepchild"),

    /**
     * Stepparent
     * 
     */
    @XmlEnumValue("Family Member_Stepparent")
    FAMILY_MEMBER_STEPPARENT("Family Member_Stepparent"),

    /**
     * Stepsibling
     * 
     */
    @XmlEnumValue("Family Member_Stepsibling")
    FAMILY_MEMBER_STEPSIBLING("Family Member_Stepsibling"),

    /**
     * Uncle
     * 
     */
    @XmlEnumValue("Family Member_Uncle")
    FAMILY_MEMBER_UNCLE("Family Member_Uncle"),

    /**
     * Former Employee
     * 
     */
    @XmlEnumValue("Former Employee")
    FORMER_EMPLOYEE("Former Employee"),

    /**
     * Former Employer
     * 
     */
    @XmlEnumValue("Former Employer")
    FORMER_EMPLOYER("Former Employer"),

    /**
     * Friend
     * 
     */
    @XmlEnumValue("Friend")
    FRIEND("Friend"),

    /**
     * Guardian
     * 
     */
    @XmlEnumValue("Guardian")
    GUARDIAN("Guardian"),

    /**
     * Homosexual relationship
     * 
     */
    @XmlEnumValue("Homosexual relationship")
    HOMOSEXUAL_RELATIONSHIP("Homosexual relationship"),

    /**
     * Neighbor
     * 
     */
    @XmlEnumValue("Neighbor")
    NEIGHBOR("Neighbor"),

    /**
     * NonFamily_Otherwise Known
     * 
     */
    @XmlEnumValue("NonFamily_Otherwise Known")
    NON_FAMILY_OTHERWISE_KNOWN("NonFamily_Otherwise Known"),

    /**
     * Patient
     * 
     */
    @XmlEnumValue("Patient")
    PATIENT("Patient"),

    /**
     * Relationship Unknown 
     * 
     */
    @XmlEnumValue("Relationship Unknown")
    RELATIONSHIP_UNKNOWN("Relationship Unknown"),

    /**
     * Stranger
     * 
     */
    @XmlEnumValue("Stranger")
    STRANGER("Stranger"),

    /**
     * Student
     * 
     */
    @XmlEnumValue("Student")
    STUDENT("Student"),

    /**
     * Teacher
     * 
     */
    @XmlEnumValue("Teacher")
    TEACHER("Teacher"),

    /**
     * Victim Was Offender
     * 
     */
    @XmlEnumValue("Victim Was Offender")
    VICTIM_WAS_OFFENDER("Victim Was Offender");
    private final String value;

    VictimToSubjectRelationshipCodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VictimToSubjectRelationshipCodeSimpleType fromValue(String v) {
        for (VictimToSubjectRelationshipCodeSimpleType c: VictimToSubjectRelationshipCodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
