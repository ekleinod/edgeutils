package de.edgesoft.edgeutils.javafx;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import de.edgesoft.edgeutils.commons.ext.LocalDateTimeAdapter;
import javafx.beans.property.SimpleObjectProperty;



/**
 * Adapter for {@link SimpleObjectProperty}.
 *
 * ## Legal stuff
 *
 * Copyright 2010-2016 Ekkart Kleinod <ekleinod@edgesoft.de>
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
 * @version 0.9.6
 * @since 0.9.6
 */
public class SimpleObjectPropertyLocalDateTimeAdapter extends XmlAdapter<String, SimpleObjectProperty<LocalDateTime>> {

	/**
	 * Marshal property.
	 *
	 * @param theProperty property
	 * @return marshaled string
	 *
	 * @version 0.9.6
	 * @since 0.9.6
	 */
	@Override
	public String marshal(final SimpleObjectProperty<LocalDateTime> theProperty) throws Exception {
		return (theProperty == null) ? null : new LocalDateTimeAdapter().marshal(theProperty.getValue());
	}

	/**
	 * Unmarshal property.
	 *
	 * @param theString string
	 * @return property
	 *
	 * @version 0.9.6
	 * @since 0.9.6
	 */
	@Override
	public SimpleObjectProperty<LocalDateTime> unmarshal(final String theString) throws Exception {
		return (theString == null) ? null : new SimpleObjectProperty<>(new LocalDateTimeAdapter().unmarshal(theString));
    }

}

/* EOF */
