
package de.edgesoft.edgeutils.commons;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import de.edgesoft.edgeutils.commons.ext.ModelClassExt;


/**
 * Connection of idref to IDType is not inline, because otherwise generation outside of edgeutils would fail.
 * Therefore, this connection is made in the `commons-only.xjb` bindings file.
 * 
 * <p>Java class for RefType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RefType">
 *   &lt;complexContent>
 *     &lt;extension base="{}ModelClass">
 *       &lt;attribute name="idref" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RefType")
public class RefType
    extends ModelClassExt
{

    @XmlAttribute(name = "idref", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected IDType idref;

    /**
     * Gets the value of the idref property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public IDType getIdref() {
        return idref;
    }

    /**
     * Sets the value of the idref property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setIdref(IDType value) {
        this.idref = value;
    }

}
