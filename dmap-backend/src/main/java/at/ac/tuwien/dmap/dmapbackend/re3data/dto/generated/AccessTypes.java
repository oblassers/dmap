
package at.ac.tuwien.dmap.dmapbackend.re3data.dto.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for accessTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="accessTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="open"/>
 *     &lt;enumeration value="restricted"/>
 *     &lt;enumeration value="closed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "accessTypes", namespace = "http://www.re3data.org/schema/2-2")
@XmlEnum
public enum AccessTypes {

    @XmlEnumValue("open")
    OPEN("open"),
    @XmlEnumValue("restricted")
    RESTRICTED("restricted"),
    @XmlEnumValue("closed")
    CLOSED("closed");
    private final String value;

    AccessTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AccessTypes fromValue(String v) {
        for (AccessTypes c: AccessTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
