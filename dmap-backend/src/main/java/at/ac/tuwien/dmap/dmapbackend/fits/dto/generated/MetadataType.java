
package at.ac.tuwien.dmap.dmapbackend.fits.dto.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for metadataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="metadataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="audio" type="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}technicalMetadata" minOccurs="0"/>
 *         &lt;element name="container" type="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}technicalMetadata" minOccurs="0"/>
 *         &lt;element name="document" type="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}technicalMetadata" minOccurs="0"/>
 *         &lt;element name="image" type="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}technicalMetadata" minOccurs="0"/>
 *         &lt;element name="text" type="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}technicalMetadata" minOccurs="0"/>
 *         &lt;element name="video" type="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}technicalMetadata" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metadataType", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output", propOrder = {
    "audio",
    "container",
    "document",
    "image",
    "text",
    "video"
})
public class MetadataType {

    @XmlElement(namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    protected TechnicalMetadata audio;
    @XmlElement(namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    protected TechnicalMetadata container;
    @XmlElement(namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    protected TechnicalMetadata document;
    @XmlElement(namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    protected TechnicalMetadata image;
    @XmlElement(namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    protected TechnicalMetadata text;
    @XmlElement(namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    protected TechnicalMetadata video;

    /**
     * Gets the value of the audio property.
     * 
     * @return
     *     possible object is
     *     {@link TechnicalMetadata }
     *     
     */
    public TechnicalMetadata getAudio() {
        return audio;
    }

    /**
     * Sets the value of the audio property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechnicalMetadata }
     *     
     */
    public void setAudio(TechnicalMetadata value) {
        this.audio = value;
    }

    /**
     * Gets the value of the container property.
     * 
     * @return
     *     possible object is
     *     {@link TechnicalMetadata }
     *     
     */
    public TechnicalMetadata getContainer() {
        return container;
    }

    /**
     * Sets the value of the container property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechnicalMetadata }
     *     
     */
    public void setContainer(TechnicalMetadata value) {
        this.container = value;
    }

    /**
     * Gets the value of the document property.
     * 
     * @return
     *     possible object is
     *     {@link TechnicalMetadata }
     *     
     */
    public TechnicalMetadata getDocument() {
        return document;
    }

    /**
     * Sets the value of the document property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechnicalMetadata }
     *     
     */
    public void setDocument(TechnicalMetadata value) {
        this.document = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link TechnicalMetadata }
     *     
     */
    public TechnicalMetadata getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechnicalMetadata }
     *     
     */
    public void setImage(TechnicalMetadata value) {
        this.image = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link TechnicalMetadata }
     *     
     */
    public TechnicalMetadata getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechnicalMetadata }
     *     
     */
    public void setText(TechnicalMetadata value) {
        this.text = value;
    }

    /**
     * Gets the value of the video property.
     * 
     * @return
     *     possible object is
     *     {@link TechnicalMetadata }
     *     
     */
    public TechnicalMetadata getVideo() {
        return video;
    }

    /**
     * Sets the value of the video property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechnicalMetadata }
     *     
     */
    public void setVideo(TechnicalMetadata value) {
        this.video = value;
    }

}
