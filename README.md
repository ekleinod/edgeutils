# edgeUtils

This project contains utilities for my projects.

- edgeUtils
	- java classes
- jaxb
	- schemata
	- bindings

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

## Released Versions

### Version 0.6.1

- hotfix: tests run under windows now (German windows)

### Version 0.6.0

- XML bindings of date, time, and datetime to LocalDate, LocalTime, and LocalDateTime
- version class with toString
- call of xjc always with three bindings

### Version 0.5.1

- hotfix: filenames are paths now instead of strings

### Version 0.5.0

- file access based on Java 8
- property file class
- started with unit tests

### Version 0.4.0

- using maven
- no jars anymore, deployment via maven

### Version 0.3.1

- Hotfix: timestamp not abstract

### Version 0.3

- containing package for markup
- new `commons.xsd` containing common xml schema structures/types
- new `commons.xjb` containing common jaxb bindings
- readme for jaxb file usage

### Version 0.2

- binary export to jar (for use of edgeutils in submodules)
- reveal markup
- bugfixes: license, error printing
- jaxb unmarshall with includes

### Version 0.1

Classes for easing the use of

- command line parameters
- file access
- LaTeX output
- multimarkdown output

## Copyright

Copyright 2010-2016 Ekkart Kleinod <ekleinod@edgesoft.de>

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

