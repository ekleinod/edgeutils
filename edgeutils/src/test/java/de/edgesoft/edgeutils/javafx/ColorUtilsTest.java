package de.edgesoft.edgeutils.javafx;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import javafx.scene.paint.Color;

/**
 * Unit test for {@link ColorUtils}.
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
 * @since 0.9.3
 */
@SuppressWarnings("static-method")
public class ColorUtilsTest {

	/**
	 * Tests formatWebHex.
	 */
	@Test
	public void testFormatWebHex() {

		assertEquals("#F0FFFF", ColorUtils.formatWebHex(Color.AZURE));
		assertEquals("#000000", ColorUtils.formatWebHex(Color.BLACK));
		assertEquals("#FDF5E6", ColorUtils.formatWebHex(Color.OLDLACE));
		assertEquals("#FFFFFF", ColorUtils.formatWebHex(Color.WHITE));

	}
	
}

/* EOF */
