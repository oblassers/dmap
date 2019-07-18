
package at.ac.tuwien.dmap.dmapbackend.fits.dto.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="identification" type="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}identificationType" minOccurs="0"/>
 *         &lt;element name="fileinfo" type="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}fileInfoType" minOccurs="0"/>
 *         &lt;element name="filestatus" type="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}fileStatusType" minOccurs="0"/>
 *         &lt;element name="metadata" type="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}metadataType" minOccurs="0"/>
 *         &lt;element name="toolOutput" type="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}toolOutputType" minOccurs="0"/>
 *         &lt;element name="statistics" type="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}statisticsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="timestamp" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "identification",
    "fileinfo",
    "filestatus",
    "metadata",
    "toolOutput",
    "statistics"
})
@XmlRootElement(name = "fits", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
public class Fits {

    @XmlElement(namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    protected IdentificationType identification;
    @XmlElement(namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    protected FileInfoType fileinfo;
    @XmlElement(namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    protected FileStatusType filestatus;
    @XmlElement(namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    protected MetadataType metadata;
    @XmlElement(namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    protected ToolOutputType toolOutput;
    @XmlElement(namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    protected StatisticsType statistics;
    @XmlAttribute(name = "version")
    protected String version;
    @XmlAttribute(name = "timestamp")
    protected String timestamp;

    /**
     * Gets the value of the identification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getIdentification() {
        return identification;
    }

    /**
     * Sets the value of the identification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setIdentification(IdentificationType value) {
        this.identification = value;
    }

    /**
     * Gets the value of the fileinfo property.
     * 
     * @return
     *     possible object is
     *     {@link FileInfoType }
     *     
     */
    public FileInfoType getFileinfo() {
        return fileinfo;
    }

    /**
     * Sets the value of the fileinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileInfoType }
     *     
     */
    public void setFileinfo(FileInfoType value) {
        this.fileinfo = value;
    }

    /**
     * Gets the value of the filestatus property.
     * 
     * @return
     *     possible object is
     *     {@link FileStatusType }
     *     
     */
    public FileStatusType getFilestatus() {
        return filestatus;
    }

    /**
     * Sets the value of the filestatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileStatusType }
     *     
     */
    public void setFilestatus(FileStatusType value) {
        this.filestatus = value;
    }

    /**
     * Gets the value of the metadata property.
     * 
     * @return
     *     possible object is
     *     {@link MetadataType }
     *     
     */
    public MetadataType getMetadata() {
        return metadata;
    }

    /**
     * Sets the value of the metadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataType }
     *     
     */
    public void setMetadata(MetadataType value) {
        this.metadata = value;
    }

    /**
     * Gets the value of the toolOutput property.
     * 
     * @return
     *     possible object is
     *     {@link ToolOutputType }
     *     
     */
    public ToolOutputType getToolOutput() {
        return toolOutput;
    }

    /**
     * Sets the value of the toolOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToolOutputType }
     *     
     */
    public void setToolOutput(ToolOutputType value) {
        this.toolOutput = value;
    }

    /**
     * Gets the value of the statistics property.
     * 
     * @return
     *     possible object is
     *     {@link StatisticsType }
     *     
     */
    public StatisticsType getStatistics() {
        return statistics;
    }

    /**
     * Sets the value of the statistics property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatisticsType }
     *     
     */
    public void setStatistics(StatisticsType value) {
        this.statistics = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimestamp(String value) {
        this.timestamp = value;
    }

}
