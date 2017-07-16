# edgeutils

This project contains utilities for my projects.

- edgeutils
	- java classes
- jaxb
	- schemata
	- bindings
- ant
	- script fragments
- nsis
	- script for simple jar files

Every subdirectory contains its own readme file describing main issues such as usage of the given utilities.

Feel free to use them in your project, I am using a LGPL license, which means:

- you are free to use the classes as you wish
- you can use the classes even in commercial projects
- if you modify the classes, you have to apply LGPL to the modified classes and reveal their source code

I am using other libraries in this project (via maven):

- apache commons cli
	- API for parsing command line options
	- license: Apache License, Version 2.0, see http://www.apache.org/licenses/LICENSE-2.0
- log4j
	- logging framework
	- license: Apache License, Version 2.0, see http://www.apache.org/licenses/LICENSE-2.0
- JUnit
	- unit testing framework
	- license: Eclipse Public License, Version 1.0, see https://www.eclipse.org/legal/epl-v10.html

## Java classes

Use them directly per eclipse project or use them via maven.
The classes are not listed in an official maven repository.
Just import them in eclipse, call maven install launch and use the classes as follows:

	<dependency>
		<groupId>de.edgesoft</groupId>
		<artifactId>edgeutils</artifactId>
		<version>0.10.0</version>
	</dependency>

Replace version number with latest version number.

## Jaxb

### commons.xsd

`commons.xsd` contains some common *xsd* types for all my projects.
To use the file, include it in your *xsd* file and use the structures as if they were written in your *xsd* file.

Example: use `InfoType` in `yourdoc.xsd`:

	<?xml version="1.0" encoding="UTF-8"?>
	<xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema"
							xmlns:jxb="http://java.sun.com/xml/ns/jaxb"
							jxb:version="2.1">

		<!-- allow xml:base attribute in order to avoid include errors -->
		<xsd:import namespace="http://www.w3.org/XML/1998/namespace" schemaLocation="http://www.w3.org/2005/08/xml.xsd"/>

		<xsd:include schemaLocation="<path to edgeutils>/edgeutils/jaxb/commons.xsd"/>

		<xsd:element name="rootelement" type="RootElementType"/>

		<xsd:complexType name="RootElementType">
			<xsd:sequence>
				<xsd:element name="info" type="Info" minOccurs="1" maxOccurs="1" />
				<xsd:element name="content" type="ContentType" minOccurs="1" maxOccurs="unbounded" />
			</xsd:sequence>
			<xsd:attribute ref="xml:base" />
		</xsd:complexType>

	</xsd:schema>

The line importing `xml.xsd` is important as it provides the means to include a schema.
For an example see https://github.com/tt-schiri/refereemanager/blob/master/refereemanager/src/main/jaxb/refereemanager.xsd

### commons.xjb

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


## Ant

I collect useful ant script fragments for inclusion in my own build files.

For an example of using `ant-commons.xml` see https://github.com/tt-schiri/refereemanager/blob/master/refereemanager/src/main/jaxb/build.xml

## NSIS

NSIS is rather hard to manage, thus I try to reuse every bit of information and script I have.

All scripts are parameterized for easy use, for an example see https://github.com/tt-schiri/refereemanager/blob/master/build/win/refereemanager.nsi




## Git repository

Short details about the structure of the git repository:
The branches are constructed regarding the git branching model of http://nvie.com/posts/a-successful-git-branching-model/

This means, there are always at least three branches:

1. `master` - contains released versions
2. `develop` - main synchronisation branch for feature, release, and hotfix branches
3. `feature/work` - main working branch for development

Additionally, the following branches my occur:

- `feature/*` - writing a special feature
- `release/*` - synchronizing release versions between `develop` and `master`
- `hotfix/*` - fast bugfixes

## Copyright

Copyright 2010-2017 Ekkart Kleinod <ekleinod@edgesoft.de>

The program is distributed under the terms of the GNU Lesser General Public License.

See COPYING and COPYING.LESSER for details.

This file is part of edgeUtils.

edgeUtils is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

edgeUtils is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with edgeUtils.  If not, see <http://www.gnu.org/licenses/>.

