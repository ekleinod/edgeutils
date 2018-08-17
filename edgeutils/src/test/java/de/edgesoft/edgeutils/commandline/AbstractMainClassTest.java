package de.edgesoft.edgeutils.commandline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Unit test for AbstractMainClass.
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
 * @since 0.4.0
 */
@SuppressWarnings("static-method")
public class AbstractMainClassTest {
	
	/** Test class instance. */
	private static TestMainClass clsTest = null;
	
	/**
	 * Create instance of {@link MainClass}.
	 */
	@BeforeAll
	public static void setUpBeforeClass() {
		clsTest = new TestMainClass();
		clsTest.executeOperation(new String[]{"-r", "--true", "argument"});
	}
	
	/**
	 * Tests description.
	 */
	@Test
	public void testDescription() {
		
		String sTest = "JUnit test class.";
		assertEquals(sTest, clsTest.getDescription());
		
		clsTest.setDescription(null);
		assertEquals("", clsTest.getDescription());
		
		clsTest.setDescription("");
		assertEquals("", clsTest.getDescription());
		
		clsTest.setDescription("äöü");
		assertEquals("äöü", clsTest.getDescription());
		
		clsTest.setDescription(sTest);
		
	}
	
	/**
	 * Tests options.
	 */
	@Test
	public void testOptions() {
		
		assertFalse(clsTest.hasOption("n"));
		assertFalse(clsTest.hasOption("a"));
		assertTrue(clsTest.hasOption("r"));
		assertTrue(clsTest.hasOption("t"));

		assertFalse(clsTest.hasOption("x"));

		assertNull(clsTest.getOptionValue("n"));
		assertNull(clsTest.getOptionValue("a"));
		assertNull(clsTest.getOptionValue("r"));
		assertEquals("argument", clsTest.getOptionValue("t"));

		assertNull(clsTest.getOptionValue("x"));
		
	}
	
	/**
	 * Tests usage.
	 */
	@Test
	public void testUsage() {
		
		StringBuilder sbTest = new StringBuilder();
		sbTest.append("usage: TestMainClass [-a <arg>] [-n] -r -t <arg>");
		sbTest.append(System.lineSeparator());
		sbTest.append("JUnit test class.");
		sbTest.append(System.lineSeparator());
		sbTest.append(" -a,--argument <arg>   optional parameter with argument");
		sbTest.append(System.lineSeparator());
		sbTest.append(" -n,--non-argument     optional parameter without argument");
		sbTest.append(System.lineSeparator());
		sbTest.append(" -r,--required         required parameter without argument");
		sbTest.append(System.lineSeparator());
		sbTest.append(" -t,--true <arg>       required parameter with argument");
		sbTest.append(System.lineSeparator());
		
		assertEquals(sbTest.toString(), clsTest.getUsage());

		sbTest.append("null test");
		sbTest.append(System.lineSeparator());
		assertEquals(sbTest.toString(), clsTest.getUsage(new NullPointerException("null test")));

	}
	
}

/* EOF */
