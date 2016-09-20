package de.edgesoft.edgeutils.javafx;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Unit test for {@link PropertyUtils}.
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
public class PropertyUtilsTest {

	/**
	 * Tests marshalString.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testMarshalString() {
		
		Assert.assertNull(PropertyUtils.marshalString(null));
		Assert.assertNull(PropertyUtils.marshalString(new SimpleStringProperty()));
		
		Assert.assertEquals("", PropertyUtils.marshalString(new SimpleStringProperty("")));
		Assert.assertEquals("äöü", PropertyUtils.marshalString(new SimpleStringProperty("äöü")));
		Assert.assertEquals("foo", PropertyUtils.marshalString(new SimpleStringProperty("foo")));
		
	}

	/**
	 * Tests unmarshalString.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testUnmarshalString() {
		
		Assert.assertNull(PropertyUtils.unmarshalString(null));
		
		Assert.assertEquals("", PropertyUtils.unmarshalString("").getValue());
		Assert.assertEquals("äöü", PropertyUtils.unmarshalString("äöü").getValue());
		Assert.assertEquals("foo", PropertyUtils.unmarshalString("foo").getValue());
		
	}

	/**
	 * Tests marshalLocalDate.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testMarshalLocalDate() {
		
		Assert.assertNull(PropertyUtils.marshalLocalDate(null));
		Assert.assertNull(PropertyUtils.marshalLocalDate(new SimpleObjectProperty<LocalDate>()));

		Assert.assertEquals("2016-05-24", PropertyUtils.marshalLocalDate(new SimpleObjectProperty<>(LocalDate.parse("2016-05-24"))));
		
	}

	/**
	 * Tests unmarshalLocalDate.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testUnmarshalLocalDate() {
		
		Assert.assertNull(PropertyUtils.unmarshalLocalDate(null));
		Assert.assertNull(PropertyUtils.unmarshalLocalDate(""));

		Assert.assertEquals(LocalDate.parse("2016-05-24"), PropertyUtils.unmarshalLocalDate("2016-05-24").getValue());
		
	}

}

/* EOF */
