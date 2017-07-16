package de.edgesoft.edgeutils.javafx;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import javafx.beans.property.SimpleIntegerProperty;



/**
 * Adapter for {@link SimpleIntegerProperty}.
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
 * @since 0.9.6
 */
public class SimpleIntegerPropertyAdapter extends XmlAdapter<String, SimpleIntegerProperty> {

	/**
	 * Marshal property.
	 *
	 * @param theProperty property
	 * @return marshaled string
	 *
	 * @version 0.10.0
	 * @since 0.9.6
	 */
	@Override
	public String marshal(final SimpleIntegerProperty theProperty) throws Exception {
		return (theProperty == null) ? null : theProperty.getValue().toString();
	}

	/**
	 * Unmarshal property.
	 *
	 * @param theString string
	 * @return property
	 *
	 * @version 0.10.0
	 * @since 0.9.6
	 */
	@Override
	public SimpleIntegerProperty unmarshal(final String theString) throws Exception {
		return (theString == null) ? null : new SimpleIntegerProperty(Integer.parseInt(theString));
    }

}

/* EOF */
