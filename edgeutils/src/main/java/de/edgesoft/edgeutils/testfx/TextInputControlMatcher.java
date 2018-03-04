package de.edgesoft.edgeutils.testfx;

import static org.testfx.matcher.base.GeneralMatchers.typeSafeMatcher;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

import javafx.scene.control.TextInputControl;


/**
 * Matcher for {@link TextInputControl}s.
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
public class TextInputControlMatcher {

    /**
     * Creates a matcher that matches all {@link TextInputControl}s that are empty.
     */
    @Factory
    public static Matcher<TextInputControl> isEmpty() {
        return typeSafeMatcher(
        		TextInputControl.class,
        		"is empty",
        		textControl -> String.format("TextInputControl's content: %s.", textControl.getText()),
        		textControl -> ((textControl.getText() == null) || textControl.getText().isEmpty())
        		);
    }

}

/* EOF */
