
package at.ac.tuwien.dmap.dmapbackend.re3data.dto.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pidSystems.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="pidSystems">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ARK"/>
 *     &lt;enumeration value="DOI"/>
 *     &lt;enumeration value="hdl"/>
 *     &lt;enumeration value="PURL"/>
 *     &lt;enumeration value="URN"/>
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "pidSystems", namespace = "http://www.re3data.org/schema/2-2")
@XmlEnum
public enum PidSystems {

    ARK("ARK"),
    DOI("DOI"),
    @XmlEnumValue("hdl")
    HDL("hdl"),
    PURL("PURL"),
    URN("URN"),
    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("none")
    NONE("none");
    private final String value;

    PidSystems(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PidSystems fromValue(String v) {
        for (PidSystems c: PidSystems.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
