
package at.ac.tuwien.dmap.dmapbackend.fits.dto.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for statusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="statusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SINGLE_RESULT"/>
 *     &lt;enumeration value="CONFLICT"/>
 *     &lt;enumeration value="PARTIAL"/>
 *     &lt;enumeration value="UNKNOWN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "statusType", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
@XmlEnum
public enum StatusType {

    SINGLE_RESULT,
    CONFLICT,
    PARTIAL,
    UNKNOWN;

    public String value() {
        return name();
    }

    public static StatusType fromValue(String v) {
        return valueOf(v);
    }

}
