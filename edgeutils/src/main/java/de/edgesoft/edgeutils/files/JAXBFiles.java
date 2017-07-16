package de.edgesoft.edgeutils.files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Objects;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import de.edgesoft.edgeutils.EdgeUtilsException;


/**
 * Class providing jaxb file operations.
 *
 * ## Legal stuff
 *
 * Copyright 2010-2017 Ekkart Kleinod <ekleinod@edgesoft.de>
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
 * @version 0.10.0
 * @since 0.1
 */
public class JAXBFiles {

	/** Standard encoding to use: UTF-8. */
	private static Charset theEncoding = StandardCharsets.UTF_8;

	/**
	 * Sets the file encoding.
	 *
	 * For the standard encodings see java.nio.charsets.StandardCharsets.
	 *
	 * Use them as follows, example: UTF-8:
	 *
	 *   JAXBFiles.setEncoding(StandardCharsets.UTF_8);
	 *
	 * @param newEncoding the file encoding
	 *
	 * @version 0.10.0
	 * @since 0.1
	 */
	public static void setEncoding(final Charset newEncoding) {
		Objects.requireNonNull(newEncoding, "encoding must not be null");
		theEncoding = newEncoding;
	}


	/**
	 * Returns the xml data object saved in the supplied file.
	 *
	 * @param theFileName the filename of the file to unmarshal
	 * @param theClass class of return type (needed for package information)
	 * @return xml data object
	 *
	 * @throws EdgeUtilsException if some JAXB-error happened
	 *
	 * @version 0.10.0
	 * @since 0.1
	 */
	public static <T> T unmarshal(String theFileName, Class<T> theClass) throws EdgeUtilsException {

		Objects.requireNonNull(theFileName, "file name must not be null");
		Objects.requireNonNull(theClass, "class must not be null");

		try (FileInputStream stmXML = new FileInputStream(theFileName)) {

			if (theFileName.isEmpty()) {
				return null;
			}

			Unmarshaller u = JAXBContext.newInstance(theClass.getPackage().getName()).createUnmarshaller();

			JAXBElement<T> doc = (JAXBElement<T>) u.unmarshal(stmXML);
			return doc.getValue();

		} catch (JAXBException | IOException e) {
			throw new EdgeUtilsException(MessageFormat.format("Error reading data: {0}", e.getMessage()));
		}
	}

	/**
	 * Returns the xml data object saved in the supplied file, uses includes.
	 *
	 * Code from https://stackoverflow.com/questions/10212781/facing-issue-while-parsing-xml-containing-xiincludes-with-jaxb
	 *
	 * @param theFileName the filename of the file to unmarshal
	 * @param theClass class of return type (needed for package information)
	 * @return xml data object
	 *
	 * @throws EdgeUtilsException if some JAXB-error happened
	 *
	 * @version 0.10.0
	 * @since 0.2
	 */
	public static <T> T unmarshalInclude(String theFileName, Class<T> theClass) throws EdgeUtilsException {

		Objects.requireNonNull(theFileName, "file name must not be null");
		Objects.requireNonNull(theClass, "class must not be null");

		try {

			if (theFileName.isEmpty()) {
				return null;
			}

			SAXParserFactory spf = SAXParserFactory.newInstance();
	        spf.setXIncludeAware(true);
	        spf.setNamespaceAware(true);
	        XMLReader xr = spf.newSAXParser().getXMLReader();
	        SAXSource src = new SAXSource(xr, new InputSource(theFileName));

	        return JAXB.unmarshal(src, theClass);

		} catch (SAXException | ParserConfigurationException e) {
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
	 * @version 0.10.0
	 * @since 0.1
	 */
	public static <T> T unmarshal(Reader theReader, Class<T> theClass) throws EdgeUtilsException {

		Objects.requireNonNull(theReader, "reader must not be null");
		Objects.requireNonNull(theClass, "class must not be null");

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
	 * @version 0.10.0
	 * @since 0.1
	 */
	public static <T> void marshal(JAXBElement<T> theDataElement, String theFileName, String theSchema) throws EdgeUtilsException {

		Objects.requireNonNull(theDataElement, "data element must not be null");
		Objects.requireNonNull(theFileName, "file name must not be null");

		try (FileOutputStream stmOut = new FileOutputStream(theFileName)) {

			Marshaller m = JAXBContext.newInstance(theDataElement.getDeclaredType().getPackage().getName()).createMarshaller();
			m.setProperty(Marshaller.JAXB_ENCODING, theEncoding.name());
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			if (theSchema != null) {
				m.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, theSchema);
			}

			m.marshal(theDataElement, stmOut);

		} catch (JAXBException | IOException e) {
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
	 * @version 0.10.0
	 * @since 0.1
	 */
	public static <T> String marshalToString(JAXBElement<T> theDataElement, String theSchema) throws EdgeUtilsException {

		Objects.requireNonNull(theDataElement, "data element must not be null");

		try {

			Marshaller m = JAXBContext.newInstance(theDataElement.getDeclaredType().getPackage().getName()).createMarshaller();
			m.setProperty(Marshaller.JAXB_ENCODING, theEncoding.name());
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
