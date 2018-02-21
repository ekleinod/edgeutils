package de.edgesoft.edgeutils.files;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link FileUtils}.
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
 * @since 0.9.7
 */
@SuppressWarnings("static-method")
public class FileUtilsTest {

	/**
	 * Tests {@link FileUtils#cleanFilename(String)}.
	 *
	 */
	@Test
	public void testCleanFilename() {

		assertEquals("abc", FileUtils.cleanFilename("abc"));
		assertEquals("aeoeue", FileUtils.cleanFilename("äöü"));
		assertEquals("ss_lou", FileUtils.cleanFilename("ß lou"));
		assertEquals("_l_.._", FileUtils.cleanFilename("_l;.._"));
		assertEquals("___._", FileUtils.cleanFilename("?:;.,"));
		assertEquals("__", FileUtils.cleanFilename("/\\"));

	}

}

/* EOF */
