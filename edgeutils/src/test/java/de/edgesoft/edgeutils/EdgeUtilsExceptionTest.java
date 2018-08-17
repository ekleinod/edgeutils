package de.edgesoft.edgeutils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link EdgeUtilsException}.
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
public class EdgeUtilsExceptionTest {

	/**
	 * Tests constructor.
	 */
	@Test
	public void testConstructor() {
		
		EdgeUtilsException eNull = new EdgeUtilsException(null);

		assertNull(eNull.getMessage());

		
		EdgeUtilsException eEmpty = new EdgeUtilsException("");

		assertEquals("", eEmpty.getMessage());

		
		EdgeUtilsException eFilled = new EdgeUtilsException("Some text äöüß.");

		assertEquals("Some text äöüß.", eFilled.getMessage());

	}

}

/* EOF */
