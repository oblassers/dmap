
package at.ac.tuwien.dmap.dmapbackend.re3data.dto.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for apiTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="apiTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FTP"/>
 *     &lt;enumeration value="NetCDF"/>
 *     &lt;enumeration value="OAI-PMH"/>
 *     &lt;enumeration value="OpenDAP"/>
 *     &lt;enumeration value="REST"/>
 *     &lt;enumeration value="SOAP"/>
 *     &lt;enumeration value="SPARQL"/>
 *     &lt;enumeration value="SWORD"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "apiTypes", namespace = "http://www.re3data.org/schema/2-2")
@XmlEnum
public enum ApiTypes {

    FTP("FTP"),
    @XmlEnumValue("NetCDF")
    NET_CDF("NetCDF"),
    @XmlEnumValue("OAI-PMH")
    OAI_PMH("OAI-PMH"),
    @XmlEnumValue("OpenDAP")
    OPEN_DAP("OpenDAP"),
    REST("REST"),
    SOAP("SOAP"),
    SPARQL("SPARQL"),
    SWORD("SWORD"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    ApiTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ApiTypes fromValue(String v) {
        for (ApiTypes c: ApiTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
