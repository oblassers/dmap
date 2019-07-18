
package at.ac.tuwien.dmap.dmapbackend.fits.dto.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for identificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="identificationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identity" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}tool" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element ref="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}version" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element ref="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}externalIdentifier" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="format" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="mimetype" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="toolname" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="toolversion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="status" type="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}statusType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "identificationType", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output", propOrder = {
    "identity"
})
public class IdentificationType {

    @XmlElement(name = "identity", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    protected List<IdentificationType.Identity> identity;
    @XmlAttribute(name = "status")
    protected StatusType status;

    /**
     * Gets the value of the identity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the identity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdentity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentificationType.Identity }
     * 
     * 
     */
    public List<IdentificationType.Identity> getIdentity() {
        if (identity == null) {
            identity = new ArrayList<IdentificationType.Identity>();
        }
        return this.identity;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setStatus(StatusType value) {
        this.status = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}tool" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element ref="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}version" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element ref="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}externalIdentifier" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="format" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="mimetype" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="toolname" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="toolversion" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "tool",
        "version",
        "externalIdentifier"
    })
    @XmlRootElement(name = "identity", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    public static class Identity {

        @XmlElement(namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
        protected List<Tool> tool;
        @XmlElement(namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
        protected List<Version> version;
        @XmlElement(namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
        protected List<ExternalIdentifier> externalIdentifier;
        @XmlAttribute(name = "format")
        protected String format;
        @XmlAttribute(name = "mimetype")
        protected String mimetype;
        @XmlAttribute(name = "toolname")
        protected String toolname;
        @XmlAttribute(name = "toolversion")
        protected String toolversion;

        /**
         * Gets the value of the tool property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the tool property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTool().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Tool }
         * 
         * 
         */
        public List<Tool> getTool() {
            if (tool == null) {
                tool = new ArrayList<Tool>();
            }
            return this.tool;
        }

        /**
         * Gets the value of the version property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the version property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getVersion().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Version }
         * 
         * 
         */
        public List<Version> getVersion() {
            if (version == null) {
                version = new ArrayList<Version>();
            }
            return this.version;
        }

        /**
         * Gets the value of the externalIdentifier property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the externalIdentifier property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getExternalIdentifier().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExternalIdentifier }
         * 
         * 
         */
        public List<ExternalIdentifier> getExternalIdentifier() {
            if (externalIdentifier == null) {
                externalIdentifier = new ArrayList<ExternalIdentifier>();
            }
            return this.externalIdentifier;
        }

        /**
         * Gets the value of the format property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFormat() {
            return format;
        }

        /**
         * Sets the value of the format property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFormat(String value) {
            this.format = value;
        }

        /**
         * Gets the value of the mimetype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMimetype() {
            return mimetype;
        }

        /**
         * Sets the value of the mimetype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMimetype(String value) {
            this.mimetype = value;
        }

        /**
         * Gets the value of the toolname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getToolname() {
            return toolname;
        }

        /**
         * Sets the value of the toolname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setToolname(String value) {
            this.toolname = value;
        }

        /**
         * Gets the value of the toolversion property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getToolversion() {
            return toolversion;
        }

        /**
         * Sets the value of the toolversion property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setToolversion(String value) {
            this.toolversion = value;
        }

    }

}
