package de.edgesoft.edgeutils.datetime;

import java.time.LocalDate;
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
 * @version 0.9.7
 * @since 0.9.0
 */
public class DateTimeUtils {

	/**
	 * Standard pattern for dates.
	 *
	 * @version 0.9.2
	 * @since 0.9.2
	 */
	public static final String DATE_PATTERN = "dd.MM.yyyy";

	/**
	 * Standard pattern for times.
	 *
	 * @version 0.9.7
	 * @since 0.9.7
	 */
	public static final String TIME_PATTERN = "HH:mm";

	/**
	 * Date formatter.
	 *
	 * @version 0.9.2
	 * @since 0.9.2
	 */
	public static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

	/**
	 * Time formatter.
	 *
	 * @version 0.9.7
	 * @since 0.9.7
	 */
	public static DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_PATTERN);

	/**
	 * Set individual date pattern.
	 *
	 * @param thePattern pattern
	 *
	 * @version 0.9.2
	 * @since 0.9.2
	 */
	public static void setDatePattern(final String thePattern) {
		DATE_FORMATTER = DateTimeFormatter.ofPattern(thePattern);
	}

	/**
	 * Set individual time pattern.
	 *
	 * @param thePattern pattern
	 *
	 * @version 0.9.7
	 * @since 0.9.7
	 */
	public static void setTimePattern(final String thePattern) {
		TIME_FORMATTER = DateTimeFormatter.ofPattern(thePattern);
	}

	/**
	 * Format date.
	 *
	 * @param theDate date
	 * @return formatted date
	 *
	 * @version 0.9.2
	 * @since 0.9.2
	 */
	public static String formatDate(final LocalDate theDate) {
		return (theDate == null) ? null : DATE_FORMATTER.format(theDate);
	}

	/**
	 * Format date with given pattern.
	 *
	 * @param theDate date
	 * @param thePattern pattern
	 * @return formatted date
	 *
	 * @version 0.9.7
	 * @since 0.9.7
	 */
	public static String formatDate(final LocalDate theDate, final String thePattern) {
		return (theDate == null) ? null : DateTimeFormatter.ofPattern(thePattern).format(theDate);
	}

	/**
	 * Format datetime as date.
	 *
	 * @param theDateTime date
	 * @return formatted date
	 *
	 * @version 0.9.7
	 * @since 0.9.7
	 */
	public static String formatAsDate(final LocalDateTime theDateTime) {
		return (theDateTime == null) ? null : DATE_FORMATTER.format(theDateTime);
	}

	/**
	 * Format datetime as time.
	 *
	 * @param theDateTime date
	 * @return formatted time
	 *
	 * @version 0.9.7
	 * @since 0.9.7
	 */
	public static String formatAsTime(final LocalDateTime theDateTime) {
		return (theDateTime == null) ? null : TIME_FORMATTER.format(theDateTime);
	}

	/**
	 * Parse date.
	 *
	 * @param theString date string
	 * @return date
	 *
	 * @version 0.9.2
	 * @since 0.9.2
	 */
	public static LocalDate parseDate(final String theString) {
		if (theString == null) {
			return null;
		}

        try {
            return LocalDate.parse(theString, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

	/**
	 * Is string valid date?
	 *
	 * @param theString date string
	 * @return valid date?
	 *
	 * @version 0.9.2
	 * @since 0.9.2
	 */
	public static boolean isValidDate(final String theString) {
        return DateTimeUtils.parseDate(theString) != null;
    }


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
