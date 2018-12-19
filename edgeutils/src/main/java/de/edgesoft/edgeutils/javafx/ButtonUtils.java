package de.edgesoft.edgeutils.javafx;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;


/**
 * Utilities for {@link Button}.
 *
 * When trying Kotlin, all static methods are candidates for
 * extending the button class.
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
 * @since 0.10.0
 */
public class ButtonUtils {

	/**
	 * Tooltip token.
	 */
	public static final String TOOLTIP_TOKEN = "%s%s";

	/**
	 * Accelerator token.
	 */
	public static final String ACCELERATOR_TOKEN = " (%s)";

	/**
	 * Adapts button to match menu item.
	 *
	 * @todo removing mnemonic markers is clumsy, maybe there is a predefined method
	 *
	 * @param theButton button to adapt
	 * @param theMenuItem menu item to adapt from
	 */
	public static void adaptButton(
			ButtonBase theButton,
			final MenuItem theMenuItem
			) {

		if (theMenuItem.getGraphic() != null) {
			theButton.setGraphic(new ImageView(((ImageView) theMenuItem.getGraphic()).getImage()));
		}

		theButton.setTooltip(new Tooltip(String.format(TOOLTIP_TOKEN,
				theMenuItem.getText().replace("_", ""),
				(theMenuItem.getAccelerator() == null) ? "" : String.format(ACCELERATOR_TOKEN, theMenuItem.getAccelerator().getDisplayText())
				)));

	}

	/**
	 * Binds button disable property to selection of list view.
	 *
	 * @param theButton button to disable
	 * @param theListView list view with items
	 *
	 * @since 0.10.1
	 */
	public static void bindDisable(Button theButton, final ListView<?> theListView) {

		theButton.disableProperty().bind(
				theListView.getSelectionModel().selectedItemProperty().isNull()
		);

	}

	/**
	 * Binds button disable property to selection of combo box.
	 *
	 * @param theButton button to disable
	 * @param theComboBox combo box with items
	 *
	 * @since 0.10.1
	 */
	public static void bindDisable(Button theButton, final ComboBox<?> theComboBox) {

		theButton.disableProperty().bind(
				theComboBox.getSelectionModel().selectedItemProperty().isNull()
		);

	}

	/**
	 * Binds button disable property to emptyness of labeled item.
	 *
	 * @param theButton button to disable
	 * @param theLabeled labeled item
	 *
	 * @since 0.15.0
	 */
	public static void bindDisable(
			Button theButton,
			final Labeled theComboBox
			) {

		theButton.disableProperty().bind(
				theComboBox.textProperty().isEmpty()
		);

	}

}

/* EOF */
