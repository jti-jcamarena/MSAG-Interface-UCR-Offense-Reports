
package gov.niem.release.niem.domains.jxdm._5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.niem_core._3.OrganizationType;


/**
 * A data type for a unit of an agency responsible for enforcing the law and maintaining peace.
 * 
 * <p>Java class for EnforcementUnitType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EnforcementUnitType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/3.0/}OrganizationType"&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnforcementUnitType", namespace = "http://release.niem.gov/niem/domains/jxdm/5.2/")
public class EnforcementUnitType
    extends OrganizationType
{


}
