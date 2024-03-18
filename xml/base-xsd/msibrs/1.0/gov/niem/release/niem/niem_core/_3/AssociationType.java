
package gov.niem.release.niem.niem_core._3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.domains.jxdm._5.ActivitySubjectAssociationType;
import gov.niem.release.niem.domains.jxdm._5.OffenseLocationAssociationType;
import gov.niem.release.niem.domains.jxdm._5.OffenseVictimAssociationType;
import gov.niem.release.niem.domains.jxdm._5.SubjectVictimAssociationType;


/**
 * A data type for an association, connection, relationship, or involvement somehow linking people, things, and/or activities together.
 * 
 * <p>Java class for AssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/3.0/}AssociationType"&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssociationType", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
@XmlSeeAlso({
    ActivitySubjectAssociationType.class,
    OffenseLocationAssociationType.class,
    OffenseVictimAssociationType.class,
    SubjectVictimAssociationType.class,
    ActivityPersonAssociationType.class
})
public class AssociationType
    extends gov.niem.release.niem.structures._3.AssociationType
{


}
