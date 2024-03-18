
package gov.niem.release.niem.niem_core._3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.release.niem.proxy.xsd._3.Decimal;


/**
 * A data type for a number value.
 * 
 * <p>Java class for NumericType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NumericType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://release.niem.gov/niem/proxy/xsd/3.0/&gt;decimal"&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumericType", namespace = "http://release.niem.gov/niem/niem-core/3.0/")
@XmlSeeAlso({
    QuantityType.class
})
public class NumericType
    extends Decimal
{


}
