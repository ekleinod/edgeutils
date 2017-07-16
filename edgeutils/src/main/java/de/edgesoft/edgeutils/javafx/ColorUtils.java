package de.edgesoft.edgeutils.javafx;

import javafx.scene.paint.Color;


/**
 * Class providing color operations.
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
 * @version 0.9.3
 * @since 0.9.3
 */
public class ColorUtils {

	/**
	 * Formats color as web hex string (e.g. #FFFFFF) that can be read with {@link Color#web(String)}.
	 *
	 * @param theColor color
	 * @return web hex string
	 *
	 * @version 0.9.3
	 * @since 0.9.3
	 */
	public static String formatWebHex(final Color theColor) {
		return String.format( "#%02X%02X%02X",
	            (int)( theColor.getRed() * 255 ),
	            (int)( theColor.getGreen() * 255 ),
	            (int)( theColor.getBlue() * 255 ) );
	}
	
}

/* EOF */
