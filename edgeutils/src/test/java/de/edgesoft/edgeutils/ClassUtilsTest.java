package de.edgesoft.edgeutils;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.List;

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
		
		assertFalse(lstTestMainClassFields.isEmpty());
		assertEquals(2, lstTestMainClassFields.size());
		
		assertAll("names",
				() -> assertEquals("sDummy1", lstTestMainClassFields.get(0).getName()),
				() -> assertEquals("sDummy2", lstTestMainClassFields.get(1).getName())
				);

//		assertAll("names stream",
//				lstTestMainClassFields.stream().map(item -> assertEquals("sDummy1", item.getName()))
//				);

	}


}

/* EOF */
