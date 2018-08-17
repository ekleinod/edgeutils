package de.edgesoft.edgeutils.testfx;

import static org.testfx.matcher.base.GeneralMatchers.typeSafeMatcher;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

import javafx.scene.control.ComboBox;


/**
 * Matcher for {@link ComboBox}es.
 *
 * This class is needed until testfx provides the missing methods of this matcher.
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
public class ComboBoxMatcher {

    /**
     * Creates a matcher that matches all {@link ComboBox}es that are not selected.
     */
    @Factory
    public static Matcher<ComboBox<?>> isNotSelected() {
        return typeSafeMatcher(
        		ComboBox.class,
        		"is not selected",
        		comboBox -> String.format("ComboBox's selection: %s.", comboBox.getSelectionModel().getSelectedItem()),
        		comboBox -> (comboBox.getSelectionModel().getSelectedItem() == null)
        		);
    }

}

/* EOF */
