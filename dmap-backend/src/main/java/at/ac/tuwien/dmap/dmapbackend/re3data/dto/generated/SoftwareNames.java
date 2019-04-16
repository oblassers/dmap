
package at.ac.tuwien.dmap.dmapbackend.re3data.dto.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for softwareNames.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="softwareNames">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CKAN"/>
 *     &lt;enumeration value="DataVerse"/>
 *     &lt;enumeration value="DigitalCommons"/>
 *     &lt;enumeration value="dLibra"/>
 *     &lt;enumeration value="DSpace"/>
 *     &lt;enumeration value="EPrints"/>
 *     &lt;enumeration value="eSciDoc"/>
 *     &lt;enumeration value="Fedora"/>
 *     &lt;enumeration value="MySQL"/>
 *     &lt;enumeration value="Nesstar"/>
 *     &lt;enumeration value="Opus"/>
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "softwareNames", namespace = "http://www.re3data.org/schema/2-2")
@XmlEnum
public enum SoftwareNames {

    CKAN("CKAN"),
    @XmlEnumValue("DataVerse")
    DATA_VERSE("DataVerse"),
    @XmlEnumValue("DigitalCommons")
    DIGITAL_COMMONS("DigitalCommons"),
    @XmlEnumValue("dLibra")
    D_LIBRA("dLibra"),
    @XmlEnumValue("DSpace")
    D_SPACE("DSpace"),
    @XmlEnumValue("EPrints")
    E_PRINTS("EPrints"),
    @XmlEnumValue("eSciDoc")
    E_SCI_DOC("eSciDoc"),
    @XmlEnumValue("Fedora")
    FEDORA("Fedora"),
    @XmlEnumValue("MySQL")
    MY_SQL("MySQL"),
    @XmlEnumValue("Nesstar")
    NESSTAR("Nesstar"),
    @XmlEnumValue("Opus")
    OPUS("Opus"),
    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("unknown")
    UNKNOWN("unknown");
    private final String value;

    SoftwareNames(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SoftwareNames fromValue(String v) {
        for (SoftwareNames c: SoftwareNames.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
