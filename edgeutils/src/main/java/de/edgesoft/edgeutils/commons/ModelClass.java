
package de.edgesoft.edgeutils.commons;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import de.edgesoft.edgeutils.commons.ext.VersionExt;


/**
 * <p>Java class for ModelClass complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModelClass">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModelClass")
@XmlSeeAlso({
    AbstractModelClass.class,
    IDType.class,
    RefType.class,
    VersionExt.class,
    TimestampType.class
})
public abstract class ModelClass {


}
