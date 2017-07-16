package de.edgesoft.edgeutils.files;

import org.junit.Assert;
import org.junit.Test;

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
 * @version 0.10.0
 * @since 0.9.7
 */
public class FileUtilsTest {

	/**
	 * Tests {@link FileUtils#cleanFilename(String)}.
	 *
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testCleanFilename() {

		Assert.assertEquals("abc", FileUtils.cleanFilename("abc"));
		Assert.assertEquals("aeoeue", FileUtils.cleanFilename("äöü"));
		Assert.assertEquals("ss_lou", FileUtils.cleanFilename("ß lou"));
		Assert.assertEquals("_l____", FileUtils.cleanFilename("_l;.._"));
		Assert.assertEquals("_____", FileUtils.cleanFilename("?:;.,"));
		Assert.assertEquals("__", FileUtils.cleanFilename("/\\"));

	}

}

/* EOF */
