package de.edgesoft.edgeutils.commons.ext;

import java.time.LocalTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Adapter for LocalTime.
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
 * @since 0.6.0
 */
public class LocalTimeAdapter extends XmlAdapter<String, LocalTime> {

	@Override
    public LocalTime unmarshal(String value) throws Exception {
        return LocalTime.parse(value);
    }
	
	@Override
    public String marshal(LocalTime value) throws Exception {
        return value.toString();
    }
	
}

/* EOF */
