package de.edgesoft.edgeutils.commons.ext;

import java.util.List;

import de.edgesoft.edgeutils.collections.CollectionHelper;
import de.edgesoft.edgeutils.commons.Additional;
import de.edgesoft.edgeutils.commons.AdditionalType;
import de.edgesoft.edgeutils.commons.ObjectFactory;
import de.edgesoft.edgeutils.commons.Version;

/**
 * Helper and convenience methods for {@link VersionType}.
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
 * @version 0.10.1
 * @since 0.4
 */
public class VersionExt extends Version {

	/**
	 * Default constructor.
	 * 
	 * @version 0.10.1
	 * @since 0.4
	 */
	public VersionExt() {
		super();
	}

	/**
	 * Constructor, setting version in one call, version as string.
	 * 
	 * - "2"
	 * - "2.0"
	 * - "2.0.1"
	 * - "2 pre 2"
	 * - "2.0 alpha 1"
	 * - "2.0.1 beta 5"
	 * 
	 * @param theVersion version
	 * 
	 * @version 0.10.1
	 * @since 0.4
	 */
	public VersionExt(String theVersion) {
		super();
		
		setMajor(0);
		
		if ((theVersion == null) || theVersion.trim().isEmpty()) {
			return;
		}

		String sVersion = theVersion.trim();
		
		int index = 1;
		for (AdditionalType theAdditionalType : AdditionalType.values()) {
			List<String> lstTemp = CollectionHelper.fromCSVString(sVersion, theAdditionalType.value());
			if (lstTemp.size() > index) {
				Additional addType = new ObjectFactory().createAdditional();
				addType.setType(theAdditionalType);
				addType.setValue(Integer.parseInt(lstTemp.get(index)));
				setAdditional(addType);
				sVersion = lstTemp.get(0);
			}
		}
		
		List<String> lstTemp = CollectionHelper.fromCSVString(sVersion, ".");
		
		index = 0;
		if (lstTemp.size() > index) {
			setMajor(Integer.parseInt(lstTemp.get(index)));
		}
		
		index = 1;
		if (lstTemp.size() > index) {
			setMinor(Integer.parseInt(lstTemp.get(index)));
		}
		
		index = 2;
		if (lstTemp.size() > index) {
			setPatch(Integer.parseInt(lstTemp.get(index)));
		}
		
	}
	
	/**
	 * Creates string representation of version.
	 * 
	 * @return string representation of version
	 * 
	 * @version 0.10.1
	 * @since 0.6.0
	 */
	@Override
	public String toString() {
		StringBuilder sbReturn = new StringBuilder();
		
		sbReturn.append(getMajor());
		
		if (getMinor() != null) {
			sbReturn.append(".");
			sbReturn.append(getMinor());
			
			if (getPatch() != null) {
				sbReturn.append(".");
				sbReturn.append(getPatch());
			}
		}
		
		if (getAdditional() != null) {
			sbReturn.append(" ");
			sbReturn.append(getAdditional().getType().value());
			sbReturn.append(" ");
			sbReturn.append(getAdditional().getValue());
		}
		
		return sbReturn.toString();
	}
	
}

/* EOF */
