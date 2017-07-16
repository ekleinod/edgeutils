package de.edgesoft.edgeutils.javafx;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import javafx.beans.property.SimpleObjectProperty;

/**
 * Unit test for {@link SimpleObjectPropertyLocalDateAdapter}.
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
public class SimpleObjectPropertyLocalDateAdapterTest {

	/**
	 * Tests marshalLocalDate.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testMarshalLocalDate() {
		
		try {
			
			Assert.assertNull(new SimpleObjectPropertyLocalDateAdapter().marshal(null));
	
			Assert.assertEquals("2016-05-24", new SimpleObjectPropertyLocalDateAdapter().marshal(new SimpleObjectProperty<>(LocalDate.parse("2016-05-24"))));
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		
	}

	/**
	 * Tests unmarshalLocalDate.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testUnmarshalLocalDate() {
		
		try {
			
			Assert.assertNull(new SimpleObjectPropertyLocalDateAdapter().unmarshal(null));
	
			Assert.assertEquals(LocalDate.parse("2016-05-24"), new SimpleObjectPropertyLocalDateAdapter().unmarshal("2016-05-24").getValue());
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		
	}

}

/* EOF */
