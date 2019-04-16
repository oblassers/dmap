
package at.ac.tuwien.dmap.dmapbackend.re3data.dto.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for institutionTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="institutionTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="commercial"/>
 *     &lt;enumeration value="non-profit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "institutionTypes", namespace = "http://www.re3data.org/schema/2-2")
@XmlEnum
public enum InstitutionTypes {

    @XmlEnumValue("commercial")
    COMMERCIAL("commercial"),
    @XmlEnumValue("non-profit")
    NON_PROFIT("non-profit");
    private final String value;

    InstitutionTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InstitutionTypes fromValue(String v) {
        for (InstitutionTypes c: InstitutionTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
