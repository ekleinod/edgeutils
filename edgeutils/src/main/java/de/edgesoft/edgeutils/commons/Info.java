
package de.edgesoft.edgeutils.commons;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import de.edgesoft.edgeutils.commons.ext.VersionExt;


/**
 * <p>Java class for Info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Info">
 *   &lt;complexContent>
 *     &lt;extension base="{}TimestampType">
 *       &lt;sequence>
 *         &lt;element name="docversion" type="{}Version" minOccurs="0"/>
 *         &lt;element name="appversion" type="{}Version"/>
 *         &lt;element name="creator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Info", propOrder = {
    "docversion",
    "appversion",
    "creator"
})
public class Info
    extends TimestampType
{

    @XmlElement(type = VersionExt.class)
    protected VersionExt docversion;
    @XmlElement(required = true, type = VersionExt.class)
    protected VersionExt appversion;
    protected String creator;

    /**
     * Gets the value of the docversion property.
     * 
     * @return
     *     possible object is
     *     {@link Version }
     *     
     */
    public Version getDocversion() {
        return docversion;
    }

    /**
     * Sets the value of the docversion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Version }
     *     
     */
    public void setDocversion(Version value) {
        this.docversion = ((VersionExt) value);
    }

    /**
     * Gets the value of the appversion property.
     * 
     * @return
     *     possible object is
     *     {@link Version }
     *     
     */
    public Version getAppversion() {
        return appversion;
    }

    /**
     * Sets the value of the appversion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Version }
     *     
     */
    public void setAppversion(Version value) {
        this.appversion = ((VersionExt) value);
    }

    /**
     * Gets the value of the creator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Sets the value of the creator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreator(String value) {
        this.creator = value;
    }

}
