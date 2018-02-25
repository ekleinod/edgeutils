package de.edgesoft.edgeutils.javafx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;


/**
 * Utilities for {@link KeyCodeCombination}.
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
public class KeyCodeCombinationUtils {

	/**
	 * Returns list of {@link KeyCodeCombination}s for given string.
	 *
	 * @param theText text to convert to {@link KeyCodeCombination}s
	 *
	 * @return list of {@link KeyCodeCombination}s
	 */
	public static List<KeyCodeCombination> getKeyCodeCombinations(
			final String theText
			) {
		
		
		if (theText == null) {
			return Collections.emptyList();
		}
		
		List<KeyCodeCombination> lstReturn = new ArrayList<>();
		
		for (char theChar : theText.toCharArray()) {
			
			String theCode = Character.toString(theChar).toUpperCase();
			
			switch (theChar) {
				case '.':
					theCode = "Period";
					break;
				case '_':
					theCode = "Underscore";
					break;
			}
			
			KeyCode theKeyCode = KeyCode.getKeyCode(theCode);
			
			if (Character.isAlphabetic(theChar) && Character.isUpperCase(theChar)) {
				lstReturn.add(new KeyCodeCombination(theKeyCode, KeyCombination.SHIFT_DOWN));
			} else {
				lstReturn.add(new KeyCodeCombination(theKeyCode));
			}
			
		}
		
		return lstReturn;
		
	}

}

/* EOF */
