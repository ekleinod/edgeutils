# edgeUtils - Jaxb Files

I try to use jaxb regularly, it immensly eases the use of xml files.
There are some issues that, if you know how to work around, are not difficult to master.

This readme file contains some of the points I found out using jaxb.

- `ant-commons.xml` ant targets for all deriving projects
- `build.xml` ant file for creating common model classes
- `commons.xsd` common xsd structures/types
- `commons.xjb` common jaxb bindings (data types)

## Using commons.xsd

`commons.xsd` contains some common *xsd* types for all my projects.
To use the file, include it in your *xsd* file and use the structures as if they were written in your *xsd* file.

Example: use `InfoType` in `yourdoc.xsd`:

	<?xml version="1.0" encoding="UTF-8"?>
	<xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema"
							xmlns:jxb="http://java.sun.com/xml/ns/jaxb"
							jxb:version="2.0">

		<!-- allow xml:base attribute in order to avoid include errors -->
		<xsd:import namespace="http://www.w3.org/XML/1998/namespace" schemaLocation="http://www.w3.org/2005/08/xml.xsd"/>

		<xsd:include schemaLocation="edgeutils/jaxb/commons.xsd"/>

		<xsd:element name="rootelement" type="RootElementType"/>

		<xsd:complexType name="RootElementType">
			<xsd:sequence>
				<xsd:element name="info" type="InfoType" minOccurs="1" maxOccurs="1" />
				<xsd:element name="content" type="ContentType" minOccurs="1" maxOccurs="unbounded" />
			</xsd:sequence>
			<xsd:attribute ref="xml:base" />
		</xsd:complexType>

	</xsd:schema>

The line importing `xml.xsd` is important as it provides the means to include a schema.

## Using commons.xjb

`commons.xjb` contains some default bindings that should be applied to your xsd schema.

- `dateTime`, `time`, and `date` are mapped to `Calendar` instead of `XMLGregorianCalendar` which is a mess to cope with in code
- `integer` is mapped to `Integer` instead of `BigInteger`

To use the common bindings, declare them in the call of your jaxb compiler (example: *xjc*):

	xjc -npa -no-header -encoding UTF-8 -d src -p de.yourdoc -b edgeutils/jaxb/commons.xjb yourdoc.xsd

I included useful options as well:

- *npa*
	- suppress generation of package level annotations (`**/package-info.java`)
- *no-header*
	- suppress generation of a file header with timestamp
- *encoding*
	- specify character encoding for generated source files
- *d*
	- generated files will go into this directory
- *p*
	- specifies the target package
- *b*
	- specify external bindings files (each file must have its own -b)

It is possible to use several binding files, thus you don't have to merge `commons.xjb`:

	xjc -npa -no-header -encoding UTF-8 -d src -p de.yourdoc -b edgeutils/jaxb/commons.xjb -b yourbindings.xjb yourdoc.xsd

