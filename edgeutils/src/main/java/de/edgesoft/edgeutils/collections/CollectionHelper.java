package de.edgesoft.edgeutils.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Helpful methods for collections.
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
 * @since 0.2
 */
public class CollectionHelper {

	/**
	 * Returns a csv string of the given values.
	 * 
	 * @param theCollection collection to stringify
	 * @param theSeparator separator string
	 * @return csv string
	 * 	@retval empty if collection is empty or any parameter is null
	 * 
	 * @version 0.10.0
	 * @since 0.2
	 */
	public static <T> String toCSVString(Collection<T> theCollection, String theSeparator) {
		
		if ((theCollection == null) || (theSeparator == null)) {
			return "";
		}
		
		StringBuffer sbReturn = new StringBuffer();
		
		boolean isFurther = false;
		for (T theElement : theCollection) {
			if (isFurther) {
				sbReturn.append(theSeparator);
			}
			if (theElement == null) {
				sbReturn.append(theElement);
			} else {
				sbReturn.append(theElement.toString().trim());
			}
			isFurther = true;
		}
		
		return sbReturn.toString();
	}
	
	/**
	 * Creates a list from the line with the given separator character.
	 * 
	 * The method returns a list with as many entries as are expected,
	 * i.e. it fills the list with empty strings if needed.
	 * 
	 * @param theLine line to split
	 * @param theSeparator separator between entries
	 * @return list with splitted, trimmed entries
	 * 
	 * @version 0.10.0
	 * @since 0.2
	 */
	public static List<String> fromCSVString(String theLine, String theSeparator) {
		
		List<String> lstReturn = new ArrayList<>();
		String sSeparator = (theSeparator.equals(".")) ? "\\." : theSeparator; 
		
		for (String theEntry : Arrays.asList(theLine.split(sSeparator))) {
			lstReturn.add(theEntry.trim());
		}
		
		// fill if separator is one character only
		if (theSeparator.length() == 1) {
			int iSepCount = countOccurrences(theLine, theSeparator.charAt(0));
			for (int i = lstReturn.size(); (i <= iSepCount); i++) {
				lstReturn.add("");
			}
		}
		
		return lstReturn;
	}

	/**
	 * Returns the number of occurrences of needle in haystack.
	 * 
	 * @param haystack string to search through
	 * @param needle character to find
	 * @return number of occurences of needle in haystack
	 * 
	 * @version 0.10.0
	 * @since 0.2
	 */
	public static int countOccurrences(String haystack, char needle) {
		int iCount = 0;
		for (char c : haystack.toCharArray()) {
			if (c == needle) {
				iCount++;
			}
		}
		return iCount;
	}

	/**
	 * Returns if the collection contains only empty objects (i.e. every contained object.toString returns "").
	 * 
	 * @param theCollection collection to check
	 * @return does collection contain only empty objects
	 *  @retval true only empty objects
	 *  @retval false at least one nonempty object
	 * 
	 * @version 0.10.0
	 * @since 0.2
	 */
	public static <T> boolean isEmptyString(Collection<T> theCollection) {
		if (theCollection == null) {
			return false;
		}
		
		boolean bReturn = true;
		
		for (T theObject : theCollection) {
			if (!theObject.toString().isEmpty()) {
				bReturn = false;
			}
		}
		
		return bReturn;
	}

	/**
	 * Returns a list of the given size containing value.
	 * 
	 * @param theValue value to be filled with
	 * @param theSize size of the collection
	 * @return list containing value
	 * 
	 * @version 0.10.0
	 * @since 0.2
	 */
	public static <T> List<T> getFilledList(T theValue, int theSize) {
		if (theSize < 0) {
			return Collections.emptyList();
		}
		
		List<T> lstReturn = new ArrayList<>();
		for (int i = 0; i < theSize; i++) {
			lstReturn.add(theValue);
		}
		
		return lstReturn;
	}
	
}

/* EOF */
