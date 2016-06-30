package de.edgesoft.edgeutils.files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test for AppProperties.
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
 * @version 0.5.0
 * @since 0.5.0
 */
public class AppPropertiesTest {
	
	/** File name default property file: */
	private static final String DEFAULT = "default.properties";
	
	/** File name app property file: */
	private static final String APP = "app.properties";
	
	/**
	 * Initialize property files.
	 * @throws Exception 
	 */
	@BeforeClass
	public static void savePropfiles() throws Exception {
		FileAccess.setEncoding(StandardCharsets.ISO_8859_1);
		FileAccess.writeFile(DEFAULT, "color=blue\nperson=me\nname=täter");
		FileAccess.writeFile(APP, "color=red");
	}
	
	/**
	 * Delete property files.
	 * @throws Exception 
	 */
	@AfterClass
	public static void deletePropfiles() throws Exception {
		Files.deleteIfExists(Paths.get(DEFAULT));
		Files.deleteIfExists(Paths.get(APP));
	}
	
	/**
	 * Rule for expected exception
	 */
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	/**
	 * Tests null null.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testErrorNullNull() {
		
		try {
			Properties prpTest = AppProperties.getProperties(null, null);
			
			Assert.assertNotNull(prpTest);
			Assert.assertEquals(new Properties(), prpTest);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}

	}
	
	/**
	 * Tests missing null.
	 */
	@Test
	public void testErrorMissingNull() throws IOException {
		
		exception.expect(FileNotFoundException.class);
		exception.expectMessage("missing.properties (No such file or directory)");
		AppProperties.getProperties("missing.properties", null);
		
	}
	
	/**
	 * Tests null missing.
	 */
	@Test
	public void testErrorNullMissing() throws IOException {
		
		exception.expect(FileNotFoundException.class);
		exception.expectMessage("missing.properties (No such file or directory)");
		AppProperties.getProperties(null, "missing.properties");
		
	}
	
	/**
	 * Tests missing missing.
	 */
	@Test
	public void testErrorMissingMissing() throws IOException {
		
		exception.expect(FileNotFoundException.class);
		exception.expectMessage("missing.properties (No such file or directory)");
		AppProperties.getProperties("missing.properties", "missing.properties");
		
	}
	
	/**
	 * Tests default.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testDefault() {
		
		Properties prpTest = null;
		
		try {
			prpTest = AppProperties.getProperties(DEFAULT, null);
			
			Assert.assertNotNull(prpTest);
			Assert.assertEquals(0, prpTest.size());
			Assert.assertArrayEquals(new String[]{"color", "person", "name"}, Collections.list(prpTest.propertyNames()).toArray());
			
			Assert.assertEquals("blue", prpTest.getProperty("color"));
			Assert.assertEquals("me", prpTest.getProperty("person"));
			Assert.assertEquals("täter", prpTest.getProperty("name"));
			
			Assert.assertNull(prpTest.getProperty("missing"));
			Assert.assertNull(prpTest.getProperty(""));
			
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * Tests app.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testApp() {
		
		Properties prpTest = null;
		
		try {
			prpTest = AppProperties.getProperties(null, APP);
			
			Assert.assertNotNull(prpTest);
			Assert.assertEquals(1, prpTest.size());
			Assert.assertArrayEquals(new String[]{"color"}, Collections.list(prpTest.propertyNames()).toArray());
			
			Assert.assertEquals("red", prpTest.getProperty("color"));
			Assert.assertNull(prpTest.getProperty("person"));
			Assert.assertNull(prpTest.getProperty("name"));
			
			Assert.assertNull(prpTest.getProperty("missing"));
			Assert.assertNull(prpTest.getProperty(""));
			
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * Tests both.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testBoth() {
		
		Properties prpTest = null;
		
		try {
			prpTest = AppProperties.getProperties(DEFAULT, APP);
			
			Assert.assertNotNull(prpTest);
			Assert.assertEquals(1, prpTest.size());
			Assert.assertArrayEquals(new String[]{"color", "person", "name"}, Collections.list(prpTest.propertyNames()).toArray());
			
			Assert.assertEquals("red", prpTest.getProperty("color"));
			Assert.assertEquals("me", prpTest.getProperty("person"));
			Assert.assertEquals("täter", prpTest.getProperty("name"));
			
			Assert.assertNull(prpTest.getProperty("missing"));
			Assert.assertNull(prpTest.getProperty(""));
			
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * Tests change.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testChange() {
		
		Properties prpTest = null;
		
		try {
			prpTest = AppProperties.getProperties(DEFAULT, APP);
			
			Assert.assertNotNull(prpTest);
			Assert.assertEquals(1, prpTest.size());
			Assert.assertArrayEquals(new String[]{"color", "person", "name"}, Collections.list(prpTest.propertyNames()).toArray());
			
			Assert.assertEquals("red", prpTest.getProperty("color"));
			Assert.assertEquals("me", prpTest.getProperty("person"));
			Assert.assertEquals("täter", prpTest.getProperty("name"));
			
			Assert.assertNull(prpTest.getProperty("missing"));
			Assert.assertNull(prpTest.getProperty(""));
			
			prpTest.setProperty("color", "grün");
			prpTest.setProperty("person", "Bär");
			prpTest.setProperty("foo", "foo");
			
			AppProperties.saveProperties(prpTest, APP, "Comment ~~");
			
			prpTest = AppProperties.getProperties(DEFAULT, APP);
			
			Assert.assertNotNull(prpTest);
			Assert.assertEquals(3, prpTest.size());
			Assert.assertArrayEquals(new String[]{"color", "person", "name", "foo"}, Collections.list(prpTest.propertyNames()).toArray());
			
			Assert.assertEquals("grün", prpTest.getProperty("color"));
			Assert.assertEquals("Bär", prpTest.getProperty("person"));
			Assert.assertEquals("täter", prpTest.getProperty("name"));
			Assert.assertEquals("foo", prpTest.getProperty("foo"));
			
			Assert.assertNull(prpTest.getProperty("missing"));
			Assert.assertNull(prpTest.getProperty(""));
			
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
	}

}

/* EOF */
