package de.edgesoft.edgeutils.javafx;

import org.junit.Assert;
import org.junit.Test;

import javafx.beans.property.SimpleStringProperty;

/**
 * Unit test for {@link SimpleStringPropertyAdapter}.
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
public class SimpleStringPropertyAdapterTest {

	/**
	 * Tests marshal.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testMarshal() {
		
		try {
			
			Assert.assertNull(new SimpleStringPropertyAdapter().marshal(null));
			Assert.assertNull(new SimpleStringPropertyAdapter().marshal(new SimpleStringProperty()));
			
			Assert.assertEquals("", new SimpleStringPropertyAdapter().marshal(new SimpleStringProperty("")));
			Assert.assertEquals("äöü", new SimpleStringPropertyAdapter().marshal(new SimpleStringProperty("äöü")));
			Assert.assertEquals("foo", new SimpleStringPropertyAdapter().marshal(new SimpleStringProperty("foo")));
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		
	}

	/**
	 * Tests unmarshal.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testUnmarshal() {
		
		try {
			
			Assert.assertNull(new SimpleStringPropertyAdapter().unmarshal(null));
			
			Assert.assertEquals("", new SimpleStringPropertyAdapter().unmarshal("").getValue());
			Assert.assertEquals("äöü", new SimpleStringPropertyAdapter().unmarshal("äöü").getValue());
			Assert.assertEquals("foo", new SimpleStringPropertyAdapter().unmarshal("foo").getValue());
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		
	}

}

/* EOF */
