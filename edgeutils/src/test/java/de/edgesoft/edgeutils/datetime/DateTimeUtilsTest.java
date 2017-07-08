package de.edgesoft.edgeutils.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

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
 * @version 0.9.7
 * @since 0.9.0
 */
public class DateTimeUtilsTest {

	/**
	 * Tests {@link DateTimeUtils#formatTemporalAccessor(java.time.temporal.TemporalAccessor, String)}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testFormatTemporalAccessor() {

		LocalDateTime dteIn = LocalDateTime.parse("2016-05-24T19:34");

		Assert.assertNull(DateTimeUtils.formatTemporalAccessor(null, null));
		Assert.assertNull(DateTimeUtils.formatTemporalAccessor(dteIn, null));
		Assert.assertNull(DateTimeUtils.formatTemporalAccessor(null, "MM-yyyy+dd"));

		Assert.assertEquals("05-2016+24", DateTimeUtils.formatTemporalAccessor(dteIn, "MM-yyyy+dd"));
		Assert.assertEquals("34-34/19", DateTimeUtils.formatTemporalAccessor(dteIn, "mm-mm/HH"));

	}

	/**
	 * Tests {@link DateTimeUtils#formatDate(LocalDate)} and {@link DateTimeUtils#formatDate(LocalDate, String)}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testFormatDate() {

		LocalDate dteIn = LocalDate.parse("2016-05-24");

		Assert.assertEquals("24.05.2016", DateTimeUtils.formatDate(dteIn));
		Assert.assertNull(DateTimeUtils.formatDate(null));

		Assert.assertEquals("05-2016+24", DateTimeUtils.formatDate(dteIn, "MM-yyyy+dd"));

	}

	/**
	 * Tests {@link DateTimeUtils#formatDateTimeAsDate(LocalDateTime)}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testFormatDateTimeAsDate() {

		LocalDateTime dteIn = LocalDateTime.parse("2016-05-24T19:34");

		Assert.assertEquals("24.05.2016", DateTimeUtils.formatDateTimeAsDate(dteIn));
		Assert.assertNull(DateTimeUtils.formatDateTimeAsDate(null));

	}

	/**
	 * Tests {@link DateTimeUtils#formatDateTimeAsTime(LocalDateTime)}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testFormatDateTimeAsTime() {

		LocalDateTime dteIn = LocalDateTime.parse("2016-05-24T19:34");

		Assert.assertEquals("19:34", DateTimeUtils.formatDateTimeAsTime(dteIn));
		Assert.assertNull(DateTimeUtils.formatDateTimeAsTime(null));

	}

	/**
	 * Tests {@link DateTimeUtils#parseDate(String)} and {@link DateTimeUtils#parseDate(String, String)}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testParseDate() {

		LocalDate dteExpected = LocalDate.parse("2016-05-24");

		Assert.assertNull(DateTimeUtils.parseDate(null));
		Assert.assertNull(DateTimeUtils.parseDate(""));
		Assert.assertNull(DateTimeUtils.parseDate("abcde"));

		Assert.assertEquals(dteExpected, DateTimeUtils.parseDate("24.05.2016"));
		Assert.assertEquals(dteExpected, DateTimeUtils.parseDate("05-2016+24", "MM-yyyy+dd"));

	}

	/**
	 * Tests {@link DateTimeUtils#isValidDate(String)} and {@link DateTimeUtils#isValidDate(String, String)}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testIsValidDate() {

		Assert.assertTrue(DateTimeUtils.isValidDate("24.05.2016"));
		Assert.assertTrue(DateTimeUtils.isValidDate("05-2016+24", "MM-yyyy+dd"));

		Assert.assertFalse(DateTimeUtils.isValidDate(null));
		Assert.assertFalse(DateTimeUtils.isValidDate(""));
		Assert.assertFalse(DateTimeUtils.isValidDate("abcde"));

	}

	/**
	 * Tests {@link DateTimeUtils#parseDateTime(String)} and {@link DateTimeUtils#parseDateTime(String, String)}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testParseDateTime() {

		Assert.assertNull(DateTimeUtils.parseDateTime(null));
		Assert.assertNull(DateTimeUtils.parseDateTime(""));
		Assert.assertNull(DateTimeUtils.parseDateTime("abcde"));
		Assert.assertNull(DateTimeUtils.parseDateTime("2016-05-24T12:34:56.789", "yyyy"));

		LocalDateTime dteReturn = null;

		dteReturn = DateTimeUtils.parseDateTime("2016-05-24T12:34:56.789");
		Assert.assertEquals(LocalDateTime.parse("2016-05-24T12:34:56.789"), dteReturn);

		dteReturn = DateTimeUtils.parseDateTime("24.05.2016 12:34:56");
		Assert.assertEquals(LocalDateTime.parse("2016-05-24T12:34:56.000"), dteReturn);

		dteReturn = DateTimeUtils.parseDateTime("4.5.2016 12:34:56");
		Assert.assertEquals(LocalDateTime.parse("2016-05-04T12:34:56.000"), dteReturn);

		dteReturn = DateTimeUtils.parseDateTime("24.05.2016");
		Assert.assertEquals(LocalDateTime.parse("2016-05-24T00:00:00.000"), dteReturn);

		dteReturn = DateTimeUtils.parseDateTime("12:34:56");
		Assert.assertEquals(LocalDateTime.parse("2000-01-01T12:34:56.000"), dteReturn);

		dteReturn = DateTimeUtils.parseDateTime("05-2016+24 12:34", "MM-yyyy+dd HH:mm");
		Assert.assertEquals(LocalDateTime.parse("2016-05-24T12:34:00.000"), dteReturn);

	}

	/**
	 * Tests {@link DateTimeUtils#toDate(LocalDateTime)}.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testToDate() {

		LocalDateTime dteIn = LocalDateTime.parse("2016-05-24T00:00:00.000");

		Date dteTest = null;
		try {
			dteTest = new SimpleDateFormat("yyyy-MM-dd").parse("2016-05-24");
		} catch (ParseException e) {
			Assert.fail(e.getMessage());
		}

		Date dteOut = DateTimeUtils.toDate(dteIn);

		Assert.assertEquals(dteTest, dteOut);

	}

}

/* EOF */
