package de.edgesoft.edgeutils.xchart;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

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
 * @version 0.10.0
 * @since 0.10.0
 */
public class BaseSeriesColors implements SeriesColors {

	/**
	 * Map of color schemes.
	 *
	 * @version 0.10.0
	 */
	private Map<Colorschemes, Color[]> mapColors = null;

	/**
	 * Constructor, setting all schemes.
	 *
	 * @version 0.10.0
	 */
	public BaseSeriesColors() {
		mapColors = new HashMap<>();

		mapColors.put(Colorschemes.Paired_qualitative_3, new Color[] {
				new Color(166,206,227),
				new Color(31,120,180),
				new Color(178,223,138)
		});

		mapColors.put(Colorschemes.Paired_qualitative_2, new Color[] {
				new Color(166,206,227),
				new Color(178,223,138)
		});

		mapColors.put(Colorschemes.PiYG_diverging_2, new Color[] {
				new Color(161,215,106),
				new Color(233,163,201)
		});

		mapColors.put(Colorschemes.RdBu_diverging_9, new Color[] {
				new Color(178, 24, 43),
				new Color(214, 96, 77),
				new Color(244, 165, 130),
				new Color(253, 219, 199),
				new Color(247, 247, 247),
				new Color(209, 229, 240),
				new Color(146, 197, 222),
				new Color(67, 147, 195),
				new Color(33, 102, 172)
		});

		mapColors.put(Colorschemes.RdYlGn_diverging_2, new Color[] {
				new Color(145, 207, 96),
				new Color(252, 141, 89)
		});

	}

	/**
	 * Returns default array of colors (.
	 *
	 * @version 0.10.0
	 */
	@Override
	public Color[] getSeriesColors() {
		return getSeriesColors(null);
	}

	/**
	 * Returns colors for given color scheme.
	 *
	 * @version 0.10.0
	 */
	public Color[] getSeriesColors(final Colorschemes theColorscheme) {
		return mapColors.getOrDefault(theColorscheme, mapColors.get(Colorschemes.RdBu_diverging_9));
	}

}

/* EOF */
