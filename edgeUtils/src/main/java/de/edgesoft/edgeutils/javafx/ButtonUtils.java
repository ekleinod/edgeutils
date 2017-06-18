package de.edgesoft.edgeutils.javafx;

import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;


/**
 * Utilities for {@link Button}.
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
 * @since 0.10.0
 */
public class ButtonUtils {

	/**
	 * Accelerator token.
	 */
	public static final String ACCELERATOR_TOKEN = "%s (%s)";

	/**
	 * Adapts button to match menu item.
	 *
	 * @todo removing mnemonic markers is clumsy, maybe there is a predefined method
	 *
	 * @param theButton button to adapt
	 * @param theMenuItem menu item to adapt from
	 */
	public static void adaptButton(Button theButton, final MenuItem theMenuItem) {

		theButton.setGraphic(theMenuItem.getGraphic());
		theButton.setTooltip(new Tooltip(String.format(ACCELERATOR_TOKEN, theMenuItem.getText().replace("_", ""), theMenuItem.getAccelerator().getDisplayText())));

	}

}

/* EOF */
