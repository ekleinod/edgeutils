package de.edgesoft.edgeutils.javafx;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

/**
 * Unit test for {@link KeyCodeCombinationUtils}.
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
public class KeyCodeCombinationUtilsTest {

	/**
	 * Tests {@link KeyCodeCombinationUtils#getKeyCodeCombinations(String)} correct case.
	 */
	@Test
	public void testGetKeyCodeCombinationsOK() {

		List<KeyCodeCombination> expected = Arrays.asList(new KeyCodeCombination[] {
						new KeyCodeCombination(KeyCode.A),
						new KeyCodeCombination(KeyCode.B, KeyCombination.SHIFT_DOWN),
						new KeyCodeCombination(KeyCode.PERIOD),
						new KeyCodeCombination(KeyCode.O),
						new KeyCodeCombination(KeyCode.UNDERSCORE),
						new KeyCodeCombination(KeyCode.SPACE),
						new KeyCodeCombination(KeyCode.MINUS),
				});

		List<KeyCodeCombination> actual = KeyCodeCombinationUtils.getKeyCodeCombinations("aB.o_ -");

		assertIterableEquals(expected, actual);

	}

	/**
	 * Tests {@link KeyCodeCombinationUtils#getKeyCodeCombinations(String)} null case.
	 */
	@Test
	public void testGetKeyCodeCombinationsNull() {

		List<KeyCodeCombination> expected = new ArrayList<>();

		List<KeyCodeCombination> actual = KeyCodeCombinationUtils.getKeyCodeCombinations(null);

		assertIterableEquals(expected, actual);

	}

	/**
	 * Tests {@link KeyCodeCombinationUtils#getKeyCodeCombination(char)} correct case.
	 */
	@Test
	public void testGetKeyCodeCombinationOK() {

		assertEquals(new KeyCodeCombination(KeyCode.A), KeyCodeCombinationUtils.getKeyCodeCombination('a'));
		assertEquals(new KeyCodeCombination(KeyCode.P), KeyCodeCombinationUtils.getKeyCodeCombination('p'));
		assertEquals(new KeyCodeCombination(KeyCode.P, KeyCombination.SHIFT_DOWN), KeyCodeCombinationUtils.getKeyCodeCombination('P'));
		assertEquals(new KeyCodeCombination(KeyCode.MINUS), KeyCodeCombinationUtils.getKeyCodeCombination('-'));
		assertEquals(new KeyCodeCombination(KeyCode.PERIOD), KeyCodeCombinationUtils.getKeyCodeCombination('.'));
		assertEquals(new KeyCodeCombination(KeyCode.SPACE), KeyCodeCombinationUtils.getKeyCodeCombination(' '));
		assertEquals(new KeyCodeCombination(KeyCode.UNDERSCORE), KeyCodeCombinationUtils.getKeyCodeCombination('_'));

	}

}

/* EOF */
