package de.edgesoft.edgeutils.javafx;

import java.time.LocalDate;

import de.edgesoft.edgeutils.datetime.DateTimeUtils;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;


/**
 * Utilities for {@link Label}.
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
public class LabelUtils {

	/**
	 * Sets text from {@link StringProperty}.
	 *
	 * @param theLabel label to set text
	 * @param theText text to set
	 */
	public static void setText(Label theLabel, final StringProperty theText) {

		theLabel.setText(
				(theText == null) ?
						null :
						theText.getValue());

	}

	/**
	 * Sets text from {@link ObjectProperty} with a date.
	 *
	 * @param theLabel label to set text
	 * @param theDate date to set
	 * @param thePattern date pattern
	 */
	public static void setText(Label theLabel, final ObjectProperty<LocalDate> theDate, final String thePattern) {

		theLabel.setText(
				(theDate == null) ?
						null :
						DateTimeUtils.formatDate(theDate.getValue(), thePattern));

	}

}

/* EOF */
