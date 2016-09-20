package de.edgesoft.edgeutils.javafx;

import java.time.LocalDate;

import de.edgesoft.edgeutils.commons.ext.LocalDateAdapter;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



/**
 * Utility methods for date, time, and datetime.
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
 * @version 0.9.4
 * @since 0.9.4
 */
public class PropertyUtils {
	
	/**
	 * Marshal string property.
	 * 
	 * @param theProperty string property
	 * @return marshaled string property
	 * 
	 * @version 0.9.4
	 * @since 0.9.4
	 */
	public static String marshalString(final StringProperty theProperty) {
		return (theProperty == null) ? null : theProperty.getValue();
	}
	
	/**
	 * Unmarshal string property.
	 * 
	 * @param theString string
	 * @return string property
	 * 
	 * @version 0.9.4
	 * @since 0.9.4
	 */
	public static StringProperty unmarshalString(final String theString) {
		return (theString == null) ? null : new SimpleStringProperty(theString);
    }
	
	/**
	 * Marshal string property.
	 * 
	 * @param theProperty string property
	 * @return marshaled string property
	 * 
	 * @version 0.9.4
	 * @since 0.9.4
	 */
	public static String marshalLocalDate(final ObjectProperty<LocalDate> theProperty) {
		try {
			return (theProperty == null) ? null : new LocalDateAdapter().marshal(theProperty.getValue());
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Unmarshal string property.
	 * 
	 * @param theString string
	 * @return string property
	 * 
	 * @version 0.9.4
	 * @since 0.9.4
	 */
	public static ObjectProperty<LocalDate> unmarshalLocalDate(final String theString) {
		try {
			return (theString == null) ? null : new SimpleObjectProperty<>(new LocalDateAdapter().unmarshal(theString));
		} catch (Exception e) {
			return null;
		}
    }
	
}

/* EOF */
