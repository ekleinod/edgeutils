
package de.edgesoft.edgeutils.jaxb;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLocalDateProperty;
import javafx.beans.property.SimpleLocalDateTimeProperty;
import javafx.beans.property.SimpleLocalTimeProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.edgesoft.edgeutils.commons.ModelClass;
import de.edgesoft.edgeutils.commons.RefType;
import de.edgesoft.edgeutils.javafx.SimpleBooleanPropertyAdapter;
import de.edgesoft.edgeutils.javafx.SimpleIntegerPropertyAdapter;
import de.edgesoft.edgeutils.javafx.SimpleLocalDatePropertyAdapter;
import de.edgesoft.edgeutils.javafx.SimpleLocalDateTimePropertyAdapter;
import de.edgesoft.edgeutils.javafx.SimpleLocalTimePropertyAdapter;
import de.edgesoft.edgeutils.javafx.SimpleStringPropertyAdapter;


/**
 * <p>Java class for Content complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Content">
 *   &lt;complexContent>
 *     &lt;extension base="{}ModelClass">
 *       &lt;sequence>
 *         &lt;element name="boolprop" type="{}BooleanProperty" minOccurs="0"/>
 *         &lt;element name="intprop" type="{}IntegerProperty" minOccurs="0"/>
 *         &lt;element name="dateprop" type="{}LocalDateProperty" minOccurs="0"/>
 *         &lt;element name="datetimeprop" type="{}LocalDateTimeProperty" minOccurs="0"/>
 *         &lt;element name="timeprop" type="{}LocalTimeProperty" minOccurs="0"/>
 *         &lt;element name="stringprop" type="{}StringProperty" minOccurs="0"/>
 *         &lt;element name="idelement" type="{}IDElement" minOccurs="0"/>
 *         &lt;element name="idrefelement" type="{}RefType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Content", propOrder = {
    "boolprop",
    "intprop",
    "dateprop",
    "datetimeprop",
    "timeprop",
    "stringprop",
    "idelement",
    "idrefelement"
})
public class Content
    extends ModelClass
{

    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(SimpleBooleanPropertyAdapter.class)
    @XmlSchemaType(name = "boolean")
    protected SimpleBooleanProperty boolprop;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(SimpleIntegerPropertyAdapter.class)
    @XmlSchemaType(name = "int")
    protected SimpleIntegerProperty intprop;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(SimpleLocalDatePropertyAdapter.class)
    @XmlSchemaType(name = "date")
    protected SimpleLocalDateProperty dateprop;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(SimpleLocalDateTimePropertyAdapter.class)
    @XmlSchemaType(name = "dateTime")
    protected SimpleLocalDateTimeProperty datetimeprop;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(SimpleLocalTimePropertyAdapter.class)
    @XmlSchemaType(name = "time")
    protected SimpleLocalTimeProperty timeprop;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(SimpleStringPropertyAdapter.class)
    protected SimpleStringProperty stringprop;
    protected IDElement idelement;
    protected RefType idrefelement;

    /**
     * Gets the value of the boolprop property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public SimpleBooleanProperty getBoolprop() {
        return boolprop;
    }

    /**
     * Sets the value of the boolprop property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoolprop(SimpleBooleanProperty value) {
        this.boolprop = value;
    }

    /**
     * Gets the value of the intprop property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public SimpleIntegerProperty getIntprop() {
        return intprop;
    }

    /**
     * Sets the value of the intprop property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntprop(SimpleIntegerProperty value) {
        this.intprop = value;
    }

    /**
     * Gets the value of the dateprop property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public SimpleLocalDateProperty getDateprop() {
        return dateprop;
    }

    /**
     * Sets the value of the dateprop property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateprop(SimpleLocalDateProperty value) {
        this.dateprop = value;
    }

    /**
     * Gets the value of the datetimeprop property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public SimpleLocalDateTimeProperty getDatetimeprop() {
        return datetimeprop;
    }

    /**
     * Sets the value of the datetimeprop property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatetimeprop(SimpleLocalDateTimeProperty value) {
        this.datetimeprop = value;
    }

    /**
     * Gets the value of the timeprop property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public SimpleLocalTimeProperty getTimeprop() {
        return timeprop;
    }

    /**
     * Sets the value of the timeprop property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeprop(SimpleLocalTimeProperty value) {
        this.timeprop = value;
    }

    /**
     * Gets the value of the stringprop property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public SimpleStringProperty getStringprop() {
        return stringprop;
    }

    /**
     * Sets the value of the stringprop property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStringprop(SimpleStringProperty value) {
        this.stringprop = value;
    }

    /**
     * Gets the value of the idelement property.
     * 
     * @return
     *     possible object is
     *     {@link IDElement }
     *     
     */
    public IDElement getIdelement() {
        return idelement;
    }

    /**
     * Sets the value of the idelement property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDElement }
     *     
     */
    public void setIdelement(IDElement value) {
        this.idelement = value;
    }

    /**
     * Gets the value of the idrefelement property.
     * 
     * @return
     *     possible object is
     *     {@link RefType }
     *     
     */
    public RefType getIdrefelement() {
        return idrefelement;
    }

    /**
     * Sets the value of the idrefelement property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefType }
     *     
     */
    public void setIdrefelement(RefType value) {
        this.idrefelement = value;
    }

}
