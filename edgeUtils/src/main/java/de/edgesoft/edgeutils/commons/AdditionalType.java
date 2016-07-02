
package de.edgesoft.edgeutils.commons;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for AdditionalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdditionalType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>IntGreaterEqualNull">
 *       &lt;attribute name="type" use="required" type="{}AdditionalTypeType" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdditionalType", propOrder = {
    "value"
})
public class AdditionalType {

    @XmlValue
    @XmlJavaTypeAdapter(Adapter3 .class)
    protected Integer value;
    @XmlAttribute(name = "type", required = true)
    protected AdditionalTypeType type;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalTypeType }
     *     
     */
    public AdditionalTypeType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalTypeType }
     *     
     */
    public void setType(AdditionalTypeType value) {
        this.type = value;
    }

}
