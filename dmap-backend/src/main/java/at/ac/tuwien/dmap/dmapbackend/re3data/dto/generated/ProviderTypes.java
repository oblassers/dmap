
package at.ac.tuwien.dmap.dmapbackend.re3data.dto.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for providerTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="providerTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="dataProvider"/>
 *     &lt;enumeration value="serviceProvider"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "providerTypes", namespace = "http://www.re3data.org/schema/2-2")
@XmlEnum
public enum ProviderTypes {

    @XmlEnumValue("dataProvider")
    DATA_PROVIDER("dataProvider"),
    @XmlEnumValue("serviceProvider")
    SERVICE_PROVIDER("serviceProvider");
    private final String value;

    ProviderTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProviderTypes fromValue(String v) {
        for (ProviderTypes c: ProviderTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
