# edgeUtils

This project contains utilities for my projects.

- java
	- classes
- jaxb
	- schemata
	- bindings

Every subdirectory contains its own readme file describing main issues such as usage of the given utilities.

Feel free to use them in your project, I am using a LGPL license, which means:

- you are free to use the classes as you wish
- you can use the classes even in commercial projects
- if you modify the classes, you have to apply LGPL to the modified classes and reveal their source code

I am using other libraries in this project:

- apache commons cli
	- API for parsing command line options
	- http://commons.apache.org/proper/commons-cli/
	- license: Apache License, Version 2.0, see http://www.apache.org/licenses/LICENSE-2.0



## Git repository

Short details about the structure of the git repository:
The branches are constructed regarding the git branching model of http://nvie.com/posts/a-successful-git-branching-model/

This means, there are always at least three branches:

1. `master` - contains released versions
2. `develop` - main synchronisation branch for feature, release, and hotfix branches
3. `feature-work` - main wirking branch for development

Additionally, the following branches my occur:

- `feature-*` - writing a special feature
- `release-*` - synchronizing release versions between `develop` and `master`
- `hotfix-*` - fast bugfixes

## Released Versions

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

Copyright 2010-2014 Ekkart Kleinod <ekleinod@edgesoft.de>

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

