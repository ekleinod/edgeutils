package de.edgesoft.edgeutils.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for DateTimeUtils.
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
public class DateTimeUtilsTest {

	/**
	 * Before each test: reset date pattern.
	 */
	@SuppressWarnings("static-method")
	@Before
	public void resetPattern() {
		DateTimeUtils.setDatePattern(DateTimeUtils.DATE_PATTERN);
	}

	/**
	 * Tests formatDate.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testFormatDate() {
		
		LocalDate dteIn = LocalDate.parse("2016-05-24");
		
		Assert.assertEquals("24.05.2016", DateTimeUtils.formatDate(dteIn));
		Assert.assertNull(DateTimeUtils.formatDate(null));
		
		DateTimeUtils.setDatePattern("MM-yyyy+dd");
		Assert.assertEquals("05-2016+24", DateTimeUtils.formatDate(dteIn));
		
	}

	/**
	 * Tests formatAsDate.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testFormatAsDate() {
		
		LocalDateTime dteIn = LocalDateTime.parse("2016-05-24T19:34");
		
		Assert.assertEquals("24.05.2016", DateTimeUtils.formatAsDate(dteIn));
		Assert.assertNull(DateTimeUtils.formatAsDate(null));
		
		DateTimeUtils.setDatePattern("MM-yyyy+dd");
		Assert.assertEquals("05-2016+24", DateTimeUtils.formatAsDate(dteIn));
		
	}

	/**
	 * Tests formatAsTime.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testFormatAsTime() {
		
		LocalDateTime dteIn = LocalDateTime.parse("2016-05-24T19:34");
		
		Assert.assertEquals("19:34", DateTimeUtils.formatAsTime(dteIn));
		Assert.assertNull(DateTimeUtils.formatAsTime(null));
		
		DateTimeUtils.setTimePattern("mm-mm/HH");
		Assert.assertEquals("34-34/19", DateTimeUtils.formatAsTime(dteIn));
		
	}

	/**
	 * Tests parseDate.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testParseDate() {
		
		LocalDate dteExpected = LocalDate.parse("2016-05-24");
		
		Assert.assertEquals(dteExpected, DateTimeUtils.parseDate("24.05.2016"));
		Assert.assertNull(DateTimeUtils.parseDate(null));
		Assert.assertNull(DateTimeUtils.parseDate(""));
		Assert.assertNull(DateTimeUtils.parseDate("abcde"));
		
		DateTimeUtils.setDatePattern("MM-yyyy+dd");
		Assert.assertEquals(dteExpected, DateTimeUtils.parseDate("05-2016+24"));
		
	}

	/**
	 * Tests isValidDate.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testIsValidDate() {
		
		Assert.assertTrue(DateTimeUtils.isValidDate("24.05.2016"));
		Assert.assertFalse(DateTimeUtils.isValidDate(null));
		Assert.assertFalse(DateTimeUtils.isValidDate(""));
		Assert.assertFalse(DateTimeUtils.isValidDate("abcde"));
		
		DateTimeUtils.setDatePattern("MM-yyyy+dd");
		Assert.assertTrue(DateTimeUtils.isValidDate("05-2016+24"));
		
	}

	/**
	 * Tests toDate.
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

	/**
	 * Tests fromString.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testFromString() {
		
		LocalDateTime dteReturn = null;
				
		dteReturn = DateTimeUtils.fromString("2016-05-24T12:34:56.789");
		Assert.assertEquals(LocalDateTime.parse("2016-05-24T12:34:56.789"), dteReturn);
		
		dteReturn = DateTimeUtils.fromString("24.05.2016 12:34:56");
		Assert.assertEquals(LocalDateTime.parse("2016-05-24T12:34:56.000"), dteReturn);
		
		dteReturn = DateTimeUtils.fromString("4.5.2016 12:34:56");
		Assert.assertEquals(LocalDateTime.parse("2016-05-04T12:34:56.000"), dteReturn);
		
		dteReturn = DateTimeUtils.fromString("24.05.2016");
		Assert.assertEquals(LocalDateTime.parse("2016-05-24T00:00:00.000"), dteReturn);
		
		dteReturn = DateTimeUtils.fromString("12:34:56");
		Assert.assertEquals(LocalDateTime.parse("2000-01-01T12:34:56.000"), dteReturn);
		
	}

}

/* EOF */
