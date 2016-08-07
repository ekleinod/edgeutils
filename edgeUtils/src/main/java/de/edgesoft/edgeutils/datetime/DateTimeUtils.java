package de.edgesoft.edgeutils.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;



/**
 * Utility methods for date, time, and datetime.
 * 
 * ## Legal stuff
 * 
 * Copyright 2010-2016 Ekkart Kleinod <ekleinod@edgesoft.de>
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
 * @version 0.9.0
 * @since 0.9.0
 */
public class DateTimeUtils {
	
	/**
	 * Convert {@link LocalDateTime} to {@link Date}.
	 * 
	 * @param theDateTime datetime
	 * 
	 * @return date
	 *  
	 * @version 0.9.0
	 * @since 0.9.0
	 */
	public static Date toDate(final LocalDateTime theDateTime) {
		return Date.from(theDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	/**
	 * Convert text to {@link LocalDateTime}.
	 * 
	 * @todo this is hacked really badly, because I can't grasp formatters fully.
	 * 
	 * @param theString string representation
	 * 
	 * @return datetime
	 * @retval null if conversion was not successful
	 *  
	 * @version 0.9.1
	 * @since 0.9.1
	 */
	public static LocalDateTime fromString(final String theString) {
		
		LocalDateTime dtReturn = null;
		
		try {
			dtReturn = LocalDateTime.parse(theString);
		} catch (DateTimeParseException e) {
			// ignore
		}
		
		if (dtReturn == null) {
			try {
				dtReturn = LocalDateTime.parse(theString, DateTimeFormatter.ofPattern("d.M.uuuu HH:mm:ss"));
			} catch (DateTimeParseException e) {
				// ignore
			}
		}
		
		if (dtReturn == null) {
			try {
				dtReturn = LocalDateTime.parse(theString + " 00:00:00", DateTimeFormatter.ofPattern("d.M.uuuu HH:mm:ss"));
			} catch (DateTimeParseException e) {
				// ignore
			}
		}
		
		if (dtReturn == null) {
			try {
				dtReturn = LocalDateTime.parse("1.1.2000 " + theString, DateTimeFormatter.ofPattern("d.M.uuuu HH:mm:ss"));
			} catch (DateTimeParseException e) {
				// ignore
			}
		}
		
		return dtReturn;
	}
	
}

/* EOF */
