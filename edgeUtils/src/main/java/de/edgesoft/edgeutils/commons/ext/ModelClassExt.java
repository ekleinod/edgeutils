package de.edgesoft.edgeutils.commons.ext;

import de.edgesoft.edgeutils.commons.ModelClass;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Helper and convenience methods for {@link ModelClass}.
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
 * @version 0.14.0
 * @since 0.14.0
 */
public class ModelClassExt extends ModelClass {

	/**
	 * Default {@link #getDisplayText()} method for all model classes.
	 *
	 * This allows to use this method in all instances of {@link ModelClass}.
	 *
	 * @version 0.14.0
	 * @since 0.14.0
	 */
	public StringProperty getDisplayText() {
		return new SimpleStringProperty(toString());
	}

}

/* EOF */
