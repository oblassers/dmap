
package at.ac.tuwien.dmap.dmapbackend.re3data.dto.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for databaseLicenseNames.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="databaseLicenseNames">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Apache License 2.0"/>
 *     &lt;enumeration value="BSD"/>
 *     &lt;enumeration value="CC"/>
 *     &lt;enumeration value="CC0"/>
 *     &lt;enumeration value="Copyrights"/>
 *     &lt;enumeration value="ODC"/>
 *     &lt;enumeration value="Public Domain"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "databaseLicenseNames", namespace = "http://www.re3data.org/schema/2-2")
@XmlEnum
public enum DatabaseLicenseNames {

    @XmlEnumValue("Apache License 2.0")
    APACHE_LICENSE_2_0("Apache License 2.0"),
    BSD("BSD"),
    CC("CC"),
    @XmlEnumValue("CC0")
    CC_0("CC0"),
    @XmlEnumValue("Copyrights")
    COPYRIGHTS("Copyrights"),
    ODC("ODC"),
    @XmlEnumValue("Public Domain")
    PUBLIC_DOMAIN("Public Domain"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    DatabaseLicenseNames(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DatabaseLicenseNames fromValue(String v) {
        for (DatabaseLicenseNames c: DatabaseLicenseNames.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
