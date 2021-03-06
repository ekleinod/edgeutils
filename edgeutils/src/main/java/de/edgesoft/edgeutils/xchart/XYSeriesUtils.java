package de.edgesoft.edgeutils.xchart;

import java.util.Date;
import java.util.List;

import org.knowm.xchart.XYSeries;
import org.knowm.xchart.internal.series.Series;

/**
 * Convenience methods for {@link XYSeries}.
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
 * @version 0.10.1
 * @since 0.10.1
 */
public class XYSeriesUtils {

	/**
	 * Returns initialized {@link XYSeries} object.
	 *
	 * @param name
	 * @param xData
	 * @param yData
	 * @param errorBars
	 * @param axisType
	 */
	public static XYSeries getXYSeries(String name, List<? extends Date> xData, List<? extends Integer> yData, List<? extends Integer> errorBars, Series.DataType axisType) {

		return new XYSeries(name,
				(xData == null)
						? null
						: xData.stream().mapToDouble(d -> d.getTime()).toArray(),
				(yData == null)
						? null
						: yData.stream().mapToDouble(d -> d).toArray(),
				(errorBars == null)
						? null
						: errorBars.stream().mapToDouble(d -> d).toArray(),
				axisType);

	}

}

/* EOF */
