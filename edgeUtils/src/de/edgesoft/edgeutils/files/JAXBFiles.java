package de.edgesoft.edgeutils.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import de.edgesoft.edgeutils.EdgeUtilsException;


/**
 * Class providing jaxb file operations.
 * 
 * ## Legal stuff
 * 
 * Copyright 2010-2014 Ekkart Kleinod <ekleinod@edgesoft.de>
 * 
 * This file is part of edgeUtils.
 * 
 * edgeUtils is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * edgeUtils is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with edgeUtils.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author Ekkart Kleinod
 * @version 0.1
 * @since 0.1
 */
public class JAXBFiles {

	/**
	 * Returns the xml data object saved in the supplied file.
	 * 
	 * @param theFileName the filename of the file to unmarshal
	 * @param theClass class of return type (needed for package information)
	 * @return xml data object
	 * 
	 * @throws EdgeUtilsException if some JAXB-error happened
	 * 
	 * @version 0.1
	 * @since 0.1
	 */
	public static <T> T unmarshal(String theFileName, Class<T> theClass) throws EdgeUtilsException {
		
		try {
			
			if (theFileName.isEmpty()) {
				return null;
			}
			
			Unmarshaller u = JAXBContext.newInstance(theClass.getPackage().getName()).createUnmarshaller();
			
			JAXBElement<T> doc = (JAXBElement<T>) u.unmarshal(new File(theFileName));
			return doc.getValue();
			
		} catch (JAXBException e) {
			throw new EdgeUtilsException(MessageFormat.format("Error reading data: {0}", e.getMessage()));
		}
	}
	
	/**
	 * Returns the xml data object saved in the supplied reader.
	 * 
	 * In order to unmarshal a String, use a StringReader:
	 * 
	 *   String sXML = ...;
	 *   JAXBFiles.unmarshal(new StringReader(sXML), XAZ.class);
	 *   
	 * @param theReader the filename of the file to unmarshal
	 * @param theClass class of return type (needed for package information)
	 * @return xml data object
	 * 
	 * @throws EdgeUtilsException if some JAXB-error happened
	 * 
	 * @version 0.1
	 * @since 0.1
	 */
	public static <T> T unmarshal(Reader theReader, Class<T> theClass) throws EdgeUtilsException {
		
		try {
			
			Unmarshaller u = JAXBContext.newInstance(theClass.getPackage().getName()).createUnmarshaller();
			
			JAXBElement<T> doc = (JAXBElement<T>) u.unmarshal(theReader);
			return doc.getValue();
			
		} catch (JAXBException e) {
			throw new EdgeUtilsException(MessageFormat.format("Error reading data: {0}", e.getMessage()));
		}
	}
	
	/**
	 * Writes an XML file from the given xml data object to a file.
	 * 
	 * Call: marshal(new ObjectFactory().create<T>(the<T>), file, schema)
	 * 
	 * Example (<T> = IssuesType):
	 *   IssuesType theIssues = new IssuesType();
	 *   ...
	 *   JAXBFiles.marshal(new ObjectFactory().createIssues(theIssues), "test.xml", null);
	 * 
	 * @param theDataElement data model
	 * @param theFileName filename of the file to write to
	 * @param theSchema schema location (null allowed)
	 * 
	 * @throws EdgeUtilsException if some JAXB-error happened
	 * 
	 * @version 0.1
	 * @since 0.1
	 */
	public static <T> void marshal(JAXBElement<T> theDataElement, String theFileName, String theSchema) throws EdgeUtilsException {
		
		try {
			
			Marshaller m = JAXBContext.newInstance(theDataElement.getDeclaredType().getPackage().getName()).createMarshaller();
			m.setProperty(Marshaller.JAXB_ENCODING, StandardCharsets.UTF_8.name());
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			if (theSchema != null) {
				m.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, theSchema);
			}
			
			m.marshal(theDataElement, new FileOutputStream(theFileName));
			
		} catch (JAXBException|FileNotFoundException e) {
			throw new EdgeUtilsException(MessageFormat.format("Error writing data: {0}", e.getMessage()));
		}
	}
	
	/**
	 * Writes a given xml data object to a string. 
	 * 
	 * Call: marshal(new ObjectFactory().create<T>(the<T>), file, schema)
	 * 
	 * Example (<T> = IssuesType):
	 *   IssuesType theIssues = new IssuesType();
	 *   ...
	 *   String sXML = JAXBFiles.marshal(new ObjectFactory().createIssues(theIssues), "test.xml", null);
	 *   
	 * @param theDataElement data model
	 * @param theSchema schema location (null allowed)
	 * @return string representation
	 * 
	 * @throws EdgeUtilsException if some JAXB-error happened
	 * 
	 * @version 0.1
	 * @since 0.1
	 */
	public static <T> String marshalToString(JAXBElement<T> theDataElement, String theSchema) throws EdgeUtilsException {
		
		try {
			
			Marshaller m = JAXBContext.newInstance(theDataElement.getDeclaredType().getPackage().getName()).createMarshaller();
			m.setProperty(Marshaller.JAXB_ENCODING, StandardCharsets.UTF_8.name());
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			if (theSchema != null) {
				m.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, theSchema);
			}
			
			StringWriter sWriter = new StringWriter();
			m.marshal(theDataElement, sWriter);
			
			return sWriter.toString();
			
		} catch (JAXBException e) {
			throw new EdgeUtilsException(MessageFormat.format("Error writing data: {0}", e.getMessage()));
		}
		
	}
	
}

/* EOF */
