
package at.ac.tuwien.dmap.dmapbackend.re3data.dto.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for responsibilityTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="responsibilityTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="funding"/>
 *     &lt;enumeration value="general"/>
 *     &lt;enumeration value="sponsoring"/>
 *     &lt;enumeration value="technical"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "responsibilityTypes", namespace = "http://www.re3data.org/schema/2-2")
@XmlEnum
public enum ResponsibilityTypes {

    @XmlEnumValue("funding")
    FUNDING("funding"),
    @XmlEnumValue("general")
    GENERAL("general"),
    @XmlEnumValue("sponsoring")
    SPONSORING("sponsoring"),
    @XmlEnumValue("technical")
    TECHNICAL("technical");
    private final String value;

    ResponsibilityTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResponsibilityTypes fromValue(String v) {
        for (ResponsibilityTypes c: ResponsibilityTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
