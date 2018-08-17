package de.edgesoft.edgeutils.javafx;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleStringProperty;

/**
 * Unit test for {@link SimpleStringPropertyAdapter}.
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
 * @since 0.9.4
 */
@SuppressWarnings("static-method")
public class SimpleStringPropertyAdapterTest {

	/**
	 * Tests marshal.
	 */
	@Test
	public void testMarshal() {
		
		try {
			
			assertNull(new SimpleStringPropertyAdapter().marshal(null));
			assertNull(new SimpleStringPropertyAdapter().marshal(new SimpleStringProperty()));
			
			assertEquals("", new SimpleStringPropertyAdapter().marshal(new SimpleStringProperty("")));
			assertEquals("äöü", new SimpleStringPropertyAdapter().marshal(new SimpleStringProperty("äöü")));
			assertEquals("foo", new SimpleStringPropertyAdapter().marshal(new SimpleStringProperty("foo")));
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}

	/**
	 * Tests unmarshal.
	 */
	@Test
	public void testUnmarshal() {
		
		try {
			
			assertNull(new SimpleStringPropertyAdapter().unmarshal(null));
			
			assertEquals("", new SimpleStringPropertyAdapter().unmarshal("").getValue());
			assertEquals("äöü", new SimpleStringPropertyAdapter().unmarshal("äöü").getValue());
			assertEquals("foo", new SimpleStringPropertyAdapter().unmarshal("foo").getValue());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}

}

/* EOF */
