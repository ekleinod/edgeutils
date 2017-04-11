
package de.edgesoft.edgeutils.xchart;

/**
 * Color schemes based on color brewer schemes (http://colorbrewer2.org/).
 *
 * Colors from www.ColorBrewer.org by Cynthia A. Brewer, Geography, Pennsylvania State University.
 *
 * For enums I use the coding style of jaxb, so there will be no inconsistencies.
 *
 * ## Legal stuff
 *
 * Copyright 2010-2017 Ekkart Kleinod <ekleinod@edgesoft.de>
 *
 * This file is part of edgeUtils.
 *
 * edgeUtils is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * edgeUtils is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with edgeUtils. If not, see <http://www.gnu.org/licenses/>.
 *
 * @author Ekkart Kleinod
 * @version 0.14.0
 * @since 0.14.0
 */
public enum Colorschemes {

	Paired_qualitative_2,
	Paired_qualitative_3,

	PiYG_diverging_2,

	RdBu_diverging_9,

	RdYlGn_diverging_2,

	;

	private final String value;

	Colorschemes() {
			value = name().toLowerCase();
	}

	public String value() {
			return value;
	}

	public static Colorschemes fromValue(String v) {
		for (Colorschemes c: Colorschemes.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}

/* EOF */
