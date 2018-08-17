package de.edgesoft.edgeutils;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import de.edgesoft.edgeutils.commandline.TestMainClass;

/**
 * Unit test for {@link ClassUtils}.
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
 * @version 0.11.0
 * @since 0.11.0
 */
@SuppressWarnings("static-method")
public class ClassUtilsTest {

	/**
	 * Tests {@link ClassUtils#getDeclaredFieldsFirstAbstraction(Class)}.
	 */
	@Test
	public void testDeclaredFieldsFirstAbstraction() {

		List<Field> lstClassUtilsFields = ClassUtils.getDeclaredFieldsFirstAbstraction(ClassUtils.class);
		
		assertTrue(lstClassUtilsFields.isEmpty());

		
		List<Field> lstTestMainClassFields = ClassUtils.getDeclaredFieldsFirstAbstraction(TestMainClass.class);
		
		assertEquals(2, lstTestMainClassFields.size());
		
		assertAll("names",
				() -> assertEquals("sDummy1", lstTestMainClassFields.get(0).getName()),
				() -> assertEquals("sDummy2", lstTestMainClassFields.get(1).getName())
				);


		List<Field> lstTestClassUtilsClassFields = ClassUtils.getDeclaredFieldsFirstAbstraction(TestClassUtilsClass.class);
		
		assertEquals(2, lstTestClassUtilsClassFields.size());
		
		assertAll("names",
				() -> assertEquals("sDummy3", lstTestClassUtilsClassFields.get(0).getName()),
				() -> assertEquals("sDummy4", lstTestClassUtilsClassFields.get(1).getName())
				);

	}

	/**
	 * Tests {@link ClassUtils#getDeclaredFieldsInheritance(Class)}.
	 */
	@Test
	public void testDeclaredFieldsInheritance() {

		List<Field> lstClassUtilsFields = ClassUtils.getDeclaredFieldsInheritance(ClassUtils.class);
		
		assertTrue(lstClassUtilsFields.isEmpty());

		
		List<Field> lstTestMainClassFields = ClassUtils.getDeclaredFieldsInheritance(TestMainClass.class);
		
		assertEquals(5, lstTestMainClassFields.size());
		assertIterableEquals(
				Arrays.asList("sDummy1", "sDummy2", "optOptions", "cliCommandLine", "sDescription"), 
				lstTestMainClassFields.stream().map(Field::getName).collect(Collectors.toList())
				);

		
		List<Field> lstTestClassUtilsClassFields = ClassUtils.getDeclaredFieldsInheritance(TestClassUtilsClass.class);
		
		assertEquals(7, lstTestClassUtilsClassFields.size());
		assertIterableEquals(
				Arrays.asList("sDummy3", "sDummy4", "sDummy1", "sDummy2", "optOptions", "cliCommandLine", "sDescription"), 
				lstTestClassUtilsClassFields.stream().map(Field::getName).collect(Collectors.toList())
				);
		
	}

}

/* EOF */
