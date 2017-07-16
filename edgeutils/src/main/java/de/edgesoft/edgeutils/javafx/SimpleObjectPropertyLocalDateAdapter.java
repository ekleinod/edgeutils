package de.edgesoft.edgeutils.javafx;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import de.edgesoft.edgeutils.commons.ext.LocalDateAdapter;
import javafx.beans.property.SimpleObjectProperty;



/**
 * Adapter for {@link SimpleObjectProperty}.
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
 * @since 0.9.4
 */
public class SimpleObjectPropertyLocalDateAdapter extends XmlAdapter<String, SimpleObjectProperty<LocalDate>> {
	
	/**
	 * Marshal local date property.
	 * 
	 * @param theProperty local date property
	 * @return marshaled string
	 * 
	 * @version 0.10.0
	 * @since 0.9.4
	 */
	@Override
	public String marshal(final SimpleObjectProperty<LocalDate> theProperty) throws Exception {
		return (theProperty == null) ? null : new LocalDateAdapter().marshal(theProperty.getValue());
	}
	
	/**
	 * Unmarshal local date property.
	 * 
	 * @param theString string
	 * @return local date property
	 * 
	 * @version 0.10.0
	 * @since 0.9.4
	 */
	@Override
	public SimpleObjectProperty<LocalDate> unmarshal(final String theString) throws Exception {
		return (theString == null) ? null : new SimpleObjectProperty<>(new LocalDateAdapter().unmarshal(theString));
    }
	
}

/* EOF */
