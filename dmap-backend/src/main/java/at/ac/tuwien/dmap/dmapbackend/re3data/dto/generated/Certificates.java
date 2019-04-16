
package at.ac.tuwien.dmap.dmapbackend.re3data.dto.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for certificates.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="certificates">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CLARIN certificate B"/>
 *     &lt;enumeration value="DIN 31644"/>
 *     &lt;enumeration value="DINI Certificate"/>
 *     &lt;enumeration value="DRAMBORA"/>
 *     &lt;enumeration value="DSA"/>
 *     &lt;enumeration value="ISO 16363"/>
 *     &lt;enumeration value="ISO 16919"/>
 *     &lt;enumeration value="RatSWD"/>
 *     &lt;enumeration value="TRAC"/>
 *     &lt;enumeration value="Trusted Digital Repository"/>
 *     &lt;enumeration value="WDS"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "certificates", namespace = "http://www.re3data.org/schema/2-2")
@XmlEnum
public enum Certificates {

    @XmlEnumValue("CLARIN certificate B")
    CLARIN_CERTIFICATE_B("CLARIN certificate B"),
    @XmlEnumValue("DIN 31644")
    DIN_31644("DIN 31644"),
    @XmlEnumValue("DINI Certificate")
    DINI_CERTIFICATE("DINI Certificate"),
    DRAMBORA("DRAMBORA"),
    DSA("DSA"),
    @XmlEnumValue("ISO 16363")
    ISO_16363("ISO 16363"),
    @XmlEnumValue("ISO 16919")
    ISO_16919("ISO 16919"),
    @XmlEnumValue("RatSWD")
    RAT_SWD("RatSWD"),
    TRAC("TRAC"),
    @XmlEnumValue("Trusted Digital Repository")
    TRUSTED_DIGITAL_REPOSITORY("Trusted Digital Repository"),
    WDS("WDS"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    Certificates(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Certificates fromValue(String v) {
        for (Certificates c: Certificates.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
