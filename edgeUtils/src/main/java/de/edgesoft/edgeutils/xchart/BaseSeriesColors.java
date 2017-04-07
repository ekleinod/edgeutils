package de.edgesoft.edgeutils.xchart;

import java.awt.Color;

import org.knowm.xchart.style.colors.SeriesColors;

/**
 * Class providing base xchart {@link SeriesColors}.
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
public class BaseSeriesColors implements SeriesColors {

	private final Color[] seriesColors;

	/**
	* Constructor
	*/
	public BaseSeriesColors() {
		seriesColors = new Color[] {
				new Color(145, 207, 96),
				new Color(252, 141, 89)
		};
	}

	/**
	 * Returns array of used colors.
	 *
	 * @version 0.14.0
	 * @since 0.14.0
	 */
	@Override
	public Color[] getSeriesColors() {
		return seriesColors;
	}

}

/* EOF */
