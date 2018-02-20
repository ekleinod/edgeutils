package de.edgesoft.edgeutils.files;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Locale;
import java.util.Properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Unit test for AppProperties.
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
 * @since 0.5.0
 */
@SuppressWarnings("static-method")
public class AppPropertiesTest {

	/** File name default property file: */
	private static final String DEFAULT = "default.properties";

	/** File name app property file: */
	private static final String APP = "app.properties";

	/**
	 * Initialize property files.
	 * @throws Exception
	 */
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		FileAccess.setEncoding(StandardCharsets.ISO_8859_1);
		FileAccess.writeFile(Paths.get(DEFAULT), "color=blue\nperson=me\nname=täter");
		FileAccess.writeFile(Paths.get(APP), "color=red");
	}

	/**
	 * Delete property files.
	 * @throws Exception
	 */
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		Files.deleteIfExists(Paths.get(DEFAULT));
		Files.deleteIfExists(Paths.get(APP));
	}

	/**
	 * Tests null null.
	 */
	@Test
	public void testErrorNullNull() {

		try {
			Properties prpTest = AppProperties.getProperties((String) null, null, false);

			assertNotNull(prpTest);
			assertEquals(new Properties(), prpTest);
		} catch (IOException e) {
			fail(e.getMessage());
		}

	}

	/**
	 * Tests missing null.
	 */
	@Test
	public void testErrorMissingNull() {

		String sFilename = "missing.properties";
		
		Throwable exception = assertThrows(FileNotFoundException.class, 
				() -> {
					AppProperties.getProperties(sFilename, null, false);
				});

		if (System.getProperty("os.name").startsWith("Windows") && System.getProperty("user.language").equalsIgnoreCase(Locale.GERMAN.getLanguage())) {
			assertEquals(String.format("%s (%s)", sFilename, "Das System kann die angegebene Datei nicht finden"), exception.getMessage());
		} else {
			assertEquals(String.format("%s (%s)", sFilename, "No such file or directory"), exception.getMessage());
		}

	}

	/**
	 * Tests null missing.
	 */
	@Test
	public void testErrorNullMissing() {

		String sFilename = "missing.properties";
		
		Throwable exception = assertThrows(FileNotFoundException.class, 
				() -> {
					AppProperties.getProperties((String) null, sFilename, false);
				});

		if (System.getProperty("os.name").startsWith("Windows") && System.getProperty("user.language").equalsIgnoreCase(Locale.GERMAN.getLanguage())) {
			assertEquals(String.format("%s (%s)", sFilename, "Das System kann die angegebene Datei nicht finden"), exception.getMessage());
		} else {
			assertEquals(String.format("%s (%s)", sFilename, "No such file or directory"), exception.getMessage());
		}

	}

	/**
	 * Tests missing missing.
	 */
	@Test
	public void testErrorMissingMissing() {

		String sFilename = "missing.properties";
		
		Throwable exception = assertThrows(FileNotFoundException.class, 
				() -> {
					AppProperties.getProperties(sFilename, sFilename, false);
				});

		if (System.getProperty("os.name").startsWith("Windows") && System.getProperty("user.language").equalsIgnoreCase(Locale.GERMAN.getLanguage())) {
			assertEquals(String.format("%s (%s)", sFilename, "Das System kann die angegebene Datei nicht finden"), exception.getMessage());
		} else {
			assertEquals(String.format("%s (%s)", sFilename, "No such file or directory"), exception.getMessage());
		}

	}

	/**
	 * Tests default.
	 */
	@Test
	public void testDefault() {

		Properties prpTest = null;

		try {
			prpTest = AppProperties.getProperties(DEFAULT, null, false);

			assertNotNull(prpTest);
			assertEquals(0, prpTest.size());
			assertArrayEquals(new String[]{"color", "person", "name"}, Collections.list(prpTest.propertyNames()).toArray());

			assertEquals("blue", prpTest.getProperty("color"));
			assertEquals("me", prpTest.getProperty("person"));
			assertEquals("täter", prpTest.getProperty("name"));

			assertNull(prpTest.getProperty("missing"));
			assertNull(prpTest.getProperty(""));

		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Tests app.
	 */
	@Test
	public void testApp() {

		Properties prpTest = null;

		try {
			prpTest = AppProperties.getProperties((String) null, APP, false);

			assertNotNull(prpTest);
			assertEquals(1, prpTest.size());
			assertArrayEquals(new String[]{"color"}, Collections.list(prpTest.propertyNames()).toArray());

			assertEquals("red", prpTest.getProperty("color"));
			assertNull(prpTest.getProperty("person"));
			assertNull(prpTest.getProperty("name"));

			assertNull(prpTest.getProperty("missing"));
			assertNull(prpTest.getProperty(""));

		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Tests both.
	 */
	@Test
	public void testBoth() {

		Properties prpTest = null;

		try {
			prpTest = AppProperties.getProperties(DEFAULT, APP, false);

			assertNotNull(prpTest);
			assertEquals(1, prpTest.size());
			assertArrayEquals(new String[]{"color", "person", "name"}, Collections.list(prpTest.propertyNames()).toArray());

			assertEquals("red", prpTest.getProperty("color"));
			assertEquals("me", prpTest.getProperty("person"));
			assertEquals("täter", prpTest.getProperty("name"));

			assertNull(prpTest.getProperty("missing"));
			assertNull(prpTest.getProperty(""));

		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Tests change.
	 */
	@Test
	public void testChange() {

		Properties prpTest = null;

		try {
			prpTest = AppProperties.getProperties(DEFAULT, APP, false);

			assertNotNull(prpTest);
			assertEquals(1, prpTest.size());
			assertArrayEquals(new String[]{"color", "person", "name"}, Collections.list(prpTest.propertyNames()).toArray());

			assertEquals("red", prpTest.getProperty("color"));
			assertEquals("me", prpTest.getProperty("person"));
			assertEquals("täter", prpTest.getProperty("name"));

			assertNull(prpTest.getProperty("missing"));
			assertNull(prpTest.getProperty(""));

			prpTest.setProperty("color", "grün");
			prpTest.setProperty("person", "Bär");
			prpTest.setProperty("foo", "foo");

			AppProperties.saveProperties(prpTest, APP, "Comment ~~");

			prpTest = AppProperties.getProperties(DEFAULT, APP, false);

			assertNotNull(prpTest);
			assertEquals(3, prpTest.size());
			assertArrayEquals(new String[]{"color", "person", "name", "foo"}, Collections.list(prpTest.propertyNames()).toArray());

			assertEquals("grün", prpTest.getProperty("color"));
			assertEquals("Bär", prpTest.getProperty("person"));
			assertEquals("täter", prpTest.getProperty("name"));
			assertEquals("foo", prpTest.getProperty("foo"));

			assertNull(prpTest.getProperty("missing"));
			assertNull(prpTest.getProperty(""));

		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Tests default (Properties).
	 */
	@Test
	public void testDefaultProperties() {

		Properties prpDefault = new Properties();
		prpDefault.setProperty("color", "blue");
		prpDefault.setProperty("person", "me");
		prpDefault.setProperty("name", "täter");

		try {
			Properties prpTest = AppProperties.getProperties(prpDefault, null, false);

			assertNotNull(prpTest);
			assertEquals(0, prpTest.size());
			assertArrayEquals(new String[]{"color", "person", "name"}, Collections.list(prpTest.propertyNames()).toArray());

			assertEquals("blue", prpTest.getProperty("color"));
			assertEquals("me", prpTest.getProperty("person"));
			assertEquals("täter", prpTest.getProperty("name"));

			assertNull(prpTest.getProperty("missing"));
			assertNull(prpTest.getProperty(""));

		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

}

/* EOF */
