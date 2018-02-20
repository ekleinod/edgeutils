package de.edgesoft.edgeutils.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit test for DateTimeUtils.
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
@SuppressWarnings("static-method")
public class DateTimeUtilsTest {

	/**
	 * Tests {@link DateTimeUtils#formatTemporalAccessor(java.time.temporal.TemporalAccessor, String)}.
	 */
	@Test
	public void testFormatTemporalAccessor() {

		LocalDateTime dteIn = LocalDateTime.parse("2016-05-24T19:34");

		assertNull(DateTimeUtils.formatTemporalAccessor(null, null));
		assertNull(DateTimeUtils.formatTemporalAccessor(dteIn, null));
		assertNull(DateTimeUtils.formatTemporalAccessor(null, "MM-yyyy+dd"));

		assertEquals("05-2016+24", DateTimeUtils.formatTemporalAccessor(dteIn, "MM-yyyy+dd"));
		assertEquals("34-34/19", DateTimeUtils.formatTemporalAccessor(dteIn, "mm-mm/HH"));

	}

	/**
	 * Tests {@link DateTimeUtils#formatDate(LocalDate)} and {@link DateTimeUtils#formatDate(LocalDate, String)}.
	 */
	@Test
	public void testFormatDate() {

		LocalDate dteIn = LocalDate.parse("2016-05-24");

		assertEquals("24.05.2016", DateTimeUtils.formatDate(dteIn));
		assertNull(DateTimeUtils.formatDate(null));

		assertEquals("05-2016+24", DateTimeUtils.formatDate(dteIn, "MM-yyyy+dd"));

	}

	/**
	 * Tests {@link DateTimeUtils#formatDateTimeAsDate(LocalDateTime)}.
	 */
	@Test
	public void testFormatDateTimeAsDate() {

		LocalDateTime dteIn = LocalDateTime.parse("2016-05-24T19:34");

		assertEquals("24.05.2016", DateTimeUtils.formatDateTimeAsDate(dteIn));
		assertNull(DateTimeUtils.formatDateTimeAsDate(null));

	}

	/**
	 * Tests {@link DateTimeUtils#formatDateTimeAsTime(LocalDateTime)}.
	 */
	@Test
	public void testFormatDateTimeAsTime() {

		LocalDateTime dteIn = LocalDateTime.parse("2016-05-24T19:34");

		assertEquals("19:34", DateTimeUtils.formatDateTimeAsTime(dteIn));
		assertNull(DateTimeUtils.formatDateTimeAsTime(null));

	}

	/**
	 * Tests {@link DateTimeUtils#parseDate(String)} and {@link DateTimeUtils#parseDate(String, String)}.
	 */
	@Test
	public void testParseDate() {

		LocalDate dteExpected = LocalDate.parse("2016-05-24");

		assertNull(DateTimeUtils.parseDate(null));
		assertNull(DateTimeUtils.parseDate(""));
		assertNull(DateTimeUtils.parseDate("abcde"));

		assertEquals(dteExpected, DateTimeUtils.parseDate("24.05.2016"));
		assertEquals(dteExpected, DateTimeUtils.parseDate("05-2016+24", "MM-yyyy+dd"));

	}

	/**
	 * Tests {@link DateTimeUtils#isValidDate(String)} and {@link DateTimeUtils#isValidDate(String, String)}.
	 */
	@Test
	public void testIsValidDate() {

		assertTrue(DateTimeUtils.isValidDate("24.05.2016"));
		assertTrue(DateTimeUtils.isValidDate("05-2016+24", "MM-yyyy+dd"));

		assertFalse(DateTimeUtils.isValidDate(null));
		assertFalse(DateTimeUtils.isValidDate(""));
		assertFalse(DateTimeUtils.isValidDate("abcde"));

	}

	/**
	 * Tests {@link DateTimeUtils#parseDateTime(String)} and {@link DateTimeUtils#parseDateTime(String, String)}.
	 */
	@Test
	public void testParseDateTime() {

		assertNull(DateTimeUtils.parseDateTime(null));
		assertNull(DateTimeUtils.parseDateTime(""));
		assertNull(DateTimeUtils.parseDateTime("abcde"));
		assertNull(DateTimeUtils.parseDateTime("2016-05-24T12:34:56.789", "yyyy"));

		LocalDateTime dteReturn = null;

		dteReturn = DateTimeUtils.parseDateTime("2016-05-24T12:34:56.789");
		assertEquals(LocalDateTime.parse("2016-05-24T12:34:56.789"), dteReturn);

		dteReturn = DateTimeUtils.parseDateTime("24.05.2016 12:34:56");
		assertEquals(LocalDateTime.parse("2016-05-24T12:34:56.000"), dteReturn);

		dteReturn = DateTimeUtils.parseDateTime("4.5.2016 12:34:56");
		assertEquals(LocalDateTime.parse("2016-05-04T12:34:56.000"), dteReturn);

		dteReturn = DateTimeUtils.parseDateTime("24.05.2016");
		assertEquals(LocalDateTime.parse("2016-05-24T00:00:00.000"), dteReturn);

		dteReturn = DateTimeUtils.parseDateTime("12:34:56");
		assertEquals(LocalDateTime.parse("2000-01-01T12:34:56.000"), dteReturn);

		dteReturn = DateTimeUtils.parseDateTime("05-2016+24 12:34", "MM-yyyy+dd HH:mm");
		assertEquals(LocalDateTime.parse("2016-05-24T12:34:00.000"), dteReturn);

	}

	/**
	 * Tests {@link DateTimeUtils#toDate(LocalDateTime)}.
	 */
	@Test
	public void testToDate() {

		LocalDateTime dteIn = LocalDateTime.parse("2016-05-24T00:00:00.000");

		Date dteTest = null;
		try {
			dteTest = new SimpleDateFormat("yyyy-MM-dd").parse("2016-05-24");
		} catch (ParseException e) {
			fail(e.getMessage());
		}

		Date dteOut = DateTimeUtils.toDate(dteIn);

		assertEquals(dteTest, dteOut);

	}

}

/* EOF */
