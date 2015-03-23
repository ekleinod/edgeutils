package de.edgesoft.edgeutils.commons.ext;

import de.edgesoft.edgeutils.commons.VersionType;

/**
 * Helper and convenience methods for {@link VersionType}.
 * 
 * ## Legal stuff
 * 
 * Copyright 2010-2015 Ekkart Kleinod <ekleinod@edgesoft.de>
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
 * @version 0.4
 * @since 0.4
 */
public class VersionTypeExt extends VersionType {

	/**
	 * Default constructor.
	 * 
	 * @version 0.4
	 * @since 0.4
	 */
	public VersionTypeExt() {
		super();
	}

	/**
	 * Constructor, setting version in one call.
	 * 
	 * @param theMajor major
	 * @param theMinor minor
	 * @param thePatch patch
	 * 
	 * @version 0.4
	 * @since 0.4
	 */
	public VersionTypeExt(Integer theMajor, Integer theMinor, Integer thePatch) {
		super();
		
		setMajor(theMajor);
		setMinor(theMinor);
		setPatch(thePatch);
	}
	
}

/* EOF */
