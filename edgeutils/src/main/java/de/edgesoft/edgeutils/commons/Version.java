
package de.edgesoft.edgeutils.commons;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.edgesoft.edgeutils.commons.ext.ModelClassExt;


/**
 * Implementing class is not inline, because otherwise generation outside of edgeutils would fail.
 * Therefore, this declaration is given in the `commons-only.xjb` bindings file.
 * 
 * <p>Java class for Version complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Version">
 *   &lt;complexContent>
 *     &lt;extension base="{}ModelClass">
 *       &lt;sequence>
 *         &lt;element name="major" type="{}IntGreaterEqualNull"/>
 *         &lt;element name="minor" type="{}IntGreaterEqualNull" minOccurs="0"/>
 *         &lt;element name="patch" type="{}IntGreaterEqualNull" minOccurs="0"/>
 *         &lt;element name="additional" type="{}Additional" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Version", propOrder = {
    "major",
    "minor",
    "patch",
    "additional"
})
public class Version
    extends ModelClassExt
{

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "integer")
    protected Integer major;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "integer")
    protected Integer minor;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "integer")
    protected Integer patch;
    protected Additional additional;

    /**
     * Gets the value of the major property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getMajor() {
        return major;
    }

    /**
     * Sets the value of the major property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMajor(Integer value) {
        this.major = value;
    }

    /**
     * Gets the value of the minor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getMinor() {
        return minor;
    }

    /**
     * Sets the value of the minor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinor(Integer value) {
        this.minor = value;
    }

    /**
     * Gets the value of the patch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getPatch() {
        return patch;
    }

    /**
     * Sets the value of the patch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatch(Integer value) {
        this.patch = value;
    }

    /**
     * Gets the value of the additional property.
     * 
     * @return
     *     possible object is
     *     {@link Additional }
     *     
     */
    public Additional getAdditional() {
        return additional;
    }

    /**
     * Sets the value of the additional property.
     * 
     * @param value
     *     allowed object is
     *     {@link Additional }
     *     
     */
    public void setAdditional(Additional value) {
        this.additional = value;
    }

}
