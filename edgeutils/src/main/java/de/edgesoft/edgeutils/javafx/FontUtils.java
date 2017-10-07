package de.edgesoft.edgeutils.javafx;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/**
 * Utilities for {@link Font}.
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
public class FontUtils {

	/**
	 * Returns derived font with given weight.
	 *
	 * @param theFont font
	 * @param theWeight font weight
	 *
	 * @return derived font
	 */
	public static Font getDerived(final Font theFont, final FontWeight theWeight) {
		return getDerived(theFont, theWeight, 0);
	}

	/**
	 * Returns derived font with given weight and relative size.
	 *
	 * @param theFont font
	 * @param theWeight font weight
	 * @param theSize relative font size (+/- int)
	 *
	 * @return derived font
	 */
	public static Font getDerived(final Font theFont, final FontWeight theWeight, final int theSize) {
		return Font.font(theFont.getFamily(), theWeight, theFont.getSize() + theSize);
	}

}

/* EOF */
