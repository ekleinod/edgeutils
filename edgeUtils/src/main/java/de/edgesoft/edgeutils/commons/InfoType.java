
package de.edgesoft.edgeutils.commons;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import de.edgesoft.edgeutils.commons.ext.VersionTypeExt;


/**
 * <p>Java class for InfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfoType">
 *   &lt;complexContent>
 *     &lt;extension base="{}TimestampType">
 *       &lt;sequence>
 *         &lt;element name="docversion" type="{}VersionType" minOccurs="0"/>
 *         &lt;element name="appversion" type="{}VersionType"/>
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
@XmlType(name = "InfoType", propOrder = {
    "docversion",
    "appversion",
    "creator"
})
public class InfoType
    extends TimestampType
{

    @XmlElement(type = VersionTypeExt.class)
    protected VersionTypeExt docversion;
    @XmlElement(required = true, type = VersionTypeExt.class)
    protected VersionTypeExt appversion;
    protected String creator;

    /**
     * Gets the value of the docversion property.
     * 
     * @return
     *     possible object is
     *     {@link VersionType }
     *     
     */
    public VersionType getDocversion() {
        return docversion;
    }

    /**
     * Sets the value of the docversion property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionType }
     *     
     */
    public void setDocversion(VersionType value) {
        this.docversion = ((VersionTypeExt) value);
    }

    /**
     * Gets the value of the appversion property.
     * 
     * @return
     *     possible object is
     *     {@link VersionType }
     *     
     */
    public VersionType getAppversion() {
        return appversion;
    }

    /**
     * Sets the value of the appversion property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionType }
     *     
     */
    public void setAppversion(VersionType value) {
        this.appversion = ((VersionTypeExt) value);
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
