
package de.edgesoft.edgeutils.commons;

import javax.xml.bind.annotation.XmlRegistry;
import de.edgesoft.edgeutils.commons.ext.VersionTypeExt;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.edgesoft.edgeutils.commons package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.edgesoft.edgeutils.commons
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RefType }
     * 
     */
    public RefType createRefType() {
        return new RefType();
    }

    /**
     * Create an instance of {@link AdditionalType }
     * 
     */
    public AdditionalType createAdditionalType() {
        return new AdditionalType();
    }

    /**
     * Create an instance of {@link TimestampType }
     * 
     */
    public TimestampType createTimestampType() {
        return new TimestampType();
    }

    /**
     * Create an instance of {@link InfoType }
     * 
     */
    public InfoType createInfoType() {
        return new InfoType();
    }

    /**
     * Create an instance of {@link VersionType }
     * 
     */
    public VersionType createVersionType() {
        return new VersionTypeExt();
    }

}
