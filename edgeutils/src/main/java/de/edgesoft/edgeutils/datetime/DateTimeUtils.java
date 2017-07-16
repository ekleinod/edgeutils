package de.edgesoft.edgeutils.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

import javafx.util.StringConverter;



/**
 * Utility methods for date, time, and datetime.
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
 * @since 0.9.0
 */
public class DateTimeUtils {

	/**
	 * Standard pattern for dates.
	 *
	 * @version 0.10.1
	 * @since 0.9.2
	 */
	public static final String DATE_PATTERN = "dd.MM.yyyy";

	/**
	 * Standard pattern for times.
	 *
	 * @version 0.10.1
	 * @since 0.9.7
	 */
	public static final String TIME_PATTERN = "HH:mm";

	/**
	 * Standard pattern for datetimes.
	 *
	 * @version 0.10.1
	 * @since 0.9.7
	 */
	public static final String DATETIME_PATTERN = String.format("%s, %s", DATE_PATTERN, TIME_PATTERN);

	/**
	 * Format {@link TemporalAccessor} with given pattern.
	 *
	 * @param theAccessor accessor
	 * @param thePattern pattern
	 * @return formatted accessor
	 *
	 * @version 0.10.1
	 * @since 0.9.7
	 */
	public static String formatTemporalAccessor(final TemporalAccessor theAccessor, final String thePattern) {
		return ((theAccessor == null) || (thePattern == null)) ? null : DateTimeFormatter.ofPattern(thePattern).format(theAccessor);
	}

	/**
	 * Format {@link LocalDate} with given pattern.
	 *
	 * @param theDate date
	 * @param thePattern pattern (null = standard pattern)
	 * @return formatted date
	 *
	 * @version 0.10.1
	 * @since 0.9.7
	 */
	public static String formatDate(final LocalDate theDate, final String thePattern) {
		return formatTemporalAccessor(theDate, (thePattern == null) ? DATE_PATTERN : thePattern);
	}

	/**
	 * Format date.
	 *
	 * @param theDate date
	 * @return formatted date
	 *
	 * @version 0.10.1
	 * @since 0.9.2
	 */
	public static String formatDate(final LocalDate theDate) {
		return formatDate(theDate, null);
	}

	/**
	 * Format {@link LocalDateTime} with given pattern.
	 *
	 * @param theDateTime datetime
	 * @param thePattern pattern (null = standard pattern)
	 * @return formatted datetime
	 *
	 * @version 0.10.1
	 * @since 0.9.7
	 */
	public static String formatDateTime(final LocalDateTime theDateTime, final String thePattern) {
		return formatTemporalAccessor(theDateTime, (thePattern == null) ? DATETIME_PATTERN : thePattern);
	}

	/**
	 * Format datetime.
	 *
	 * @param theDateTime datetime
	 * @return formatted datetime
	 *
	 * @version 0.10.1
	 * @since 0.9.7
	 */
	public static String formatDateTime(final LocalDateTime theDateTime) {
		return formatDateTime(theDateTime, null);
	}

	/**
	 * Format {@link LocalTime} with given pattern.
	 *
	 * @param theTime datetime
	 * @param thePattern pattern (null = standard pattern)
	 * @return formatted time
	 *
	 * @version 0.10.1
	 * @since 0.9.7
	 */
	public static String formatTime(final LocalTime theTime, final String thePattern) {
		return formatTemporalAccessor(theTime, (thePattern == null) ? TIME_PATTERN : thePattern);
	}

	/**
	 * Format time.
	 *
	 * @param theTime time
	 * @return formatted time
	 *
	 * @version 0.10.1
	 * @since 0.9.7
	 */
	public static String formatTime(final LocalTime theTime) {
		return formatTime(theTime, null);
	}

	/**
	 * Format datetime as date.
	 *
	 * @param theDateTime date
	 * @return formatted date
	 *
	 * @version 0.10.1
	 * @since 0.9.7
	 */
	public static String formatDateTimeAsDate(final LocalDateTime theDateTime) {
		return formatDateTime(theDateTime, DATE_PATTERN);
	}

	/**
	 * Format datetime as time.
	 *
	 * @param theDateTime date
	 * @return formatted time
	 *
	 * @version 0.10.1
	 * @since 0.9.7
	 */
	public static String formatDateTimeAsTime(final LocalDateTime theDateTime) {
		return formatDateTime(theDateTime, TIME_PATTERN);
	}

	/**
	 * Parse date.
	 *
	 * @param theString date string
	 * @param thePattern pattern (null = standard pattern)
	 * @return date
	 *
	 * @version 0.10.1
	 * @since 0.9.7
	 */
	public static LocalDate parseDate(final String theString, final String thePattern) {
		if (theString == null) {
			return null;
		}

        try {
            return LocalDate.parse(theString, DateTimeFormatter.ofPattern((thePattern == null) ? DATE_PATTERN : thePattern));
        } catch (DateTimeParseException e) {
            return null;
        }
    }

	/**
	 * Parse date.
	 *
	 * @param theString date string
	 * @return date
	 *
	 * @version 0.10.1
	 * @since 0.9.2
	 */
	public static LocalDate parseDate(final String theString) {
		return parseDate(theString, null);
    }

	/**
	 * Is string valid date?
	 *
	 * @param theString date string
	 * @param thePattern pattern (null = standard pattern)
	 * @return valid date?
	 *
	 * @version 0.10.1
	 * @since 0.9.7
	 */
	public static boolean isValidDate(final String theString, final String thePattern) {
        return parseDate(theString, thePattern) != null;
    }

	/**
	 * Is string valid date?
	 *
	 * @param theString date string
	 * @return valid date?
	 *
	 * @version 0.10.1
	 * @since 0.9.2
	 */
	public static boolean isValidDate(final String theString) {
        return isValidDate(theString, null);
    }

	/**
	 * Convert text to {@link LocalDateTime}.
	 *
	 * @todo this is hacked really badly, because I can't grasp formatters fully.
	 *
	 * @param theString datetime string
	 * @param thePattern pattern (null = standard pattern)
	 * @return datetime
	 * 	@retval null if conversion was not successful
	 *
	 * @version 0.10.1
	 * @since 0.9.7
	 */
	public static LocalDateTime parseDateTime(final String theString, final String thePattern) {
		if (theString == null) {
			return null;
		}

		if (thePattern != null) {
			try {
				return LocalDateTime.parse(theString, DateTimeFormatter.ofPattern(thePattern));
			} catch (DateTimeParseException e) {
				return null;
			}
		}

		try {
			return LocalDateTime.parse(theString);
		} catch (DateTimeParseException e) {
			// ignore
		}

		try {
			return LocalDateTime.parse(theString, DateTimeFormatter.ofPattern("d.M.yyyy HH:mm:ss"));
		} catch (DateTimeParseException e) {
			// ignore
		}

		try {
			return LocalDateTime.parse(theString + " 00:00:00", DateTimeFormatter.ofPattern("d.M.yyyy HH:mm:ss"));
		} catch (DateTimeParseException e) {
			// ignore
		}

		try {
			return LocalDateTime.parse("1.1.2000 " + theString, DateTimeFormatter.ofPattern("d.M.yyyy HH:mm:ss"));
		} catch (DateTimeParseException e) {
			// ignore
		}

		return null;
	}

	/**
	 * Convert text to {@link LocalDateTime}.
	 *
	 * @return datetime
	 * 	@retval null if conversion was not successful
	 *
	 * @version 0.10.1
	 * @since 0.9.1
	 */
	public static LocalDateTime parseDateTime(final String theString) {
		return parseDateTime(theString, null);
	}

	/**
	 * Convert {@link LocalDateTime} to {@link Date}.
	 *
	 * @param theDateTime datetime
	 *
	 * @return date
	 *
	 * @version 0.10.1
	 * @since 0.9.0
	 */
	public static Date toDate(final LocalDateTime theDateTime) {
		return Date.from(theDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Convert {@link LocalDate} to {@link Date}.
	 *
	 * @param theDate date
	 *
	 * @return date
	 *
	 * @version 0.10.1
	 * @since 0.14.0
	 */
	public static Date toDate(final LocalDate theDate) {
		return Date.from(theDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Returns date converter e.g. for date pickers.
	 *
	 * @param thePattern pattern (null = standard pattern)
	 *
	 * @return date converter
	 *
	 * @version 0.10.1
	 * @since 0.14.0
	 */
	public static StringConverter<LocalDate> getDateConverter(final String thePattern) {

		return new StringConverter<LocalDate>() {

			@Override
			public String toString(LocalDate date) {
				if (date == null) {
					return "";
				}
				return DateTimeUtils.formatDate(date, thePattern);
			}

			@Override
			public LocalDate fromString(String string) {
				return DateTimeUtils.parseDate(string, thePattern);
			}

		};

	}

	/**
	 * Returns date converter e.g. for date pickers.
	 *
	 * @return date converter
	 *
	 * @version 0.10.1
	 * @since 0.14.0
	 */
	public static StringConverter<LocalDate> getDateConverter() {
		return getDateConverter(null);
	}

}

/* EOF */
