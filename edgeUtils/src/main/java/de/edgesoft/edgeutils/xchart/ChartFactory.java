package de.edgesoft.edgeutils.xchart;

import java.awt.Color;
import java.awt.Font;
import java.util.Optional;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.CategorySeries.CategorySeriesRenderStyle;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.PieSeries.PieSeriesRenderStyle;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
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
	 * @param theHeight height
	 * @param theWidth width
	 * @param theAnnotationType annotation type (optional)
	 * @param theColorscheme color scheme (optional)
	 *
	 * @version 0.14.0
	 */
	public static PieChart createPieChart(final String theTitle, final int theHeight, final int theWidth,
			final Optional<AnnotationType> theAnnotationType, final Optional<Colorschemes> theColorscheme) {

	    PieChart chart = new PieChartBuilder()
	    		.title(theTitle)
	    		.height(theHeight)
	    		.width(theWidth)
	    		.build();

	    chart.getStyler().setTheme(new BaseTheme());
	    chart.getStyler().setAnnotationType(theAnnotationType.orElse(AnnotationType.Value));
	    chart.getStyler().setLegendVisible(false);
	    chart.getStyler().setDefaultSeriesRenderStyle(PieSeriesRenderStyle.Donut);
	    chart.getStyler().setDonutThickness(.45);

	    chart.getStyler().setAnnotationDistance(.75);
	    chart.getStyler().setAnnotationsFont(chart.getStyler().getAnnotationsFont().deriveFont(Font.BOLD));

	    chart.getStyler().setChartFontColor(Color.DARK_GRAY);
	    chart.getStyler().setSeriesColors(new BaseSeriesColors().getSeriesColors(theColorscheme.orElse(Colorschemes.RdBu_diverging_9)));

	    return chart;

	}

	/**
	 * Returns xy chart.
	 *
	 * @param theTitle chart title
	 * @param theHeight height
	 * @param theWidth width
	 * @param theCategorySeriesRenderStyle render style (optional)
	 * @param theColorscheme color scheme (optional)
	 *
	 * @version 0.14.0
	 */
	public static XYChart createXYChart(final String theTitle, final int theHeight, final int theWidth,
			final Optional<Colorschemes> theColorscheme) {

	    XYChart chart = new XYChartBuilder()
	    		.title(theTitle)
	    		.height(theHeight)
	    		.width(theWidth)
	    		.build();

	    chart.getStyler().setTheme(new BaseTheme());
	    chart.getStyler().setLegendVisible(false);

	    chart.getStyler().setChartFontColor(Color.DARK_GRAY);

	    chart.getStyler().setDatePattern("dd.MM.yyyy");
	    chart.getStyler().setDecimalPattern("#");

	    chart.getStyler().setPlotBorderVisible(false);
	    chart.getStyler().setPlotGridHorizontalLinesVisible(true);
	    chart.getStyler().setPlotGridVerticalLinesVisible(false);
	    chart.getStyler().setPlotTicksMarksVisible(false);

	    chart.getStyler().setXAxisTicksVisible(false);

	    chart.getStyler().setYAxisTickMarkSpacingHint(100);

	    chart.getStyler().setSeriesColors(new BaseSeriesColors().getSeriesColors(theColorscheme.orElse(Colorschemes.RdBu_diverging_9)));

	    return chart;

	}

	/**
	 * Returns step chart.
	 *
	 * @param theTitle chart title
	 * @param theHeight height
	 * @param theWidth width
	 * @param theCategorySeriesRenderStyle render style (optional)
	 * @param theColorscheme color scheme (optional)
	 *
	 * @version 0.14.0
	 */
	public static CategoryChart createCategoryChart(final String theTitle, final int theHeight, final int theWidth,
			final Optional<CategorySeriesRenderStyle> theCategorySeriesRenderStyle, final Optional<Colorschemes> theColorscheme) {

	    CategoryChart chart = new CategoryChartBuilder()
	    		.title(theTitle)
	    		.height(theHeight)
	    		.width(theWidth)
	    		.build();

	    chart.getStyler().setTheme(new BaseTheme());
	    chart.getStyler().setLegendVisible(false);
	    chart.getStyler().setChartFontColor(Color.DARK_GRAY);

	    chart.getStyler().setPlotGridVerticalLinesVisible(false);
	    chart.getStyler().setOverlapped(true);

	    if (theCategorySeriesRenderStyle.isPresent()) {
	    	chart.getStyler().setDefaultSeriesRenderStyle(theCategorySeriesRenderStyle.get());
	    }

	    chart.getStyler().setDatePattern("dd.MM.yyyy");
	    chart.getStyler().setDecimalPattern("#");

	    chart.getStyler().setPlotBorderVisible(false);
	    chart.getStyler().setPlotGridHorizontalLinesVisible(true);
	    chart.getStyler().setPlotGridVerticalLinesVisible(false);
	    chart.getStyler().setPlotTicksMarksVisible(false);

	    chart.getStyler().setXAxisTicksVisible(false);

	    chart.getStyler().setYAxisTickMarkSpacingHint(100);

	    chart.getStyler().setSeriesColors(new BaseSeriesColors().getSeriesColors(theColorscheme.orElse(Colorschemes.RdBu_diverging_9)));

	    return chart;

	}

}

/* EOF */
