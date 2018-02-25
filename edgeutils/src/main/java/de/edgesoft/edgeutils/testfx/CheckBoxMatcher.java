package de.edgesoft.edgeutils.testfx;

import static org.testfx.matcher.base.GeneralMatchers.typeSafeMatcher;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

import javafx.scene.control.CheckBox;


/**
 * Matcher for {@link CheckBox}.
 *
 * This class is needed, until testfx contains an according matcher.
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
public class CheckBoxMatcher {

    /**
     * Creates a matcher that matches all {@link CheckBox}es that are selected (checked).
     */
    @Factory
    public static Matcher<CheckBox> isSelected() {
        return typeSafeMatcher(
        		CheckBox.class, 
        		"is selected",
        		checkBox -> String.format("CheckBox '%s' is selected: %b.", checkBox.getText(), checkBox.isSelected()),
        		checkBox -> checkBox.isSelected()
        		);
    }

    /**
     * Creates a matcher that matches all {@link CheckBox}es that are not selected (checked).
     */
    @Factory
    public static Matcher<CheckBox> isNotSelected() {
        return typeSafeMatcher(
        		CheckBox.class, 
        		"is not selected",
        		checkBox -> String.format("CheckBox '%s' is selected: %b.", checkBox.getText(), checkBox.isSelected()),
        		checkBox -> !checkBox.isSelected()
        		);
    }

}

/* EOF */
