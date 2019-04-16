
package at.ac.tuwien.dmap.dmapbackend.re3data.dto.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataAccessRestrictions.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="dataAccessRestrictions">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="feeRequired"/>
 *     &lt;enumeration value="institutional membership"/>
 *     &lt;enumeration value="registration"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "dataAccessRestrictions", namespace = "http://www.re3data.org/schema/2-2")
@XmlEnum
public enum DataAccessRestrictions {

    @XmlEnumValue("feeRequired")
    FEE_REQUIRED("feeRequired"),
    @XmlEnumValue("institutional membership")
    INSTITUTIONAL_MEMBERSHIP("institutional membership"),
    @XmlEnumValue("registration")
    REGISTRATION("registration"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    DataAccessRestrictions(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DataAccessRestrictions fromValue(String v) {
        for (DataAccessRestrictions c: DataAccessRestrictions.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
