package de.edgesoft.edgeutils.xchart;

import java.util.Optional;
import java.util.OptionalInt;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.PieSeries.PieSeriesRenderStyle;
import org.knowm.xchart.style.PieStyler.AnnotationType;



/**
 * Class providing methods for creating xcharts.
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
 * @version 0.14.0
 * @since 0.14.0
 */
public class ChartFactory {

	/**
	 * Returns pie chart.
	 *
	 * @param theTitle chart title
	 *
	 * @version 0.14.0
	 * @since 0.14.0
	 */
	public static PieChart createPieChart(final String theTitle, final OptionalInt theHeight, final OptionalInt theWidth, final Optional<AnnotationType> theAnnotation) {

	    PieChart chart = new PieChartBuilder()
	    		.title(theTitle)
	    		.build();

	    if (theHeight.isPresent()) {
	    	chart.setHeight(theHeight.getAsInt());
	    }
	    if (theWidth.isPresent()) {
	    	chart.setWidth(theWidth.getAsInt());
	    }

	    chart.getStyler().setTheme(new BaseTheme());
	    chart.getStyler().setLegendVisible(false);
	    chart.getStyler().setAnnotationType(theAnnotation.orElse(AnnotationType.Label));
	    chart.getStyler().setDefaultSeriesRenderStyle(PieSeriesRenderStyle.Donut);

	    return chart;

	}

}

/* EOF */
