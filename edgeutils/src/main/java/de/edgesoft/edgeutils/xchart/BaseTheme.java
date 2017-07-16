package de.edgesoft.edgeutils.xchart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Stroke;

import org.knowm.xchart.style.AbstractBaseTheme;
import org.knowm.xchart.style.MatlabTheme;
import org.knowm.xchart.style.PieStyler.AnnotationType;
import org.knowm.xchart.style.Theme;
import org.knowm.xchart.style.colors.ChartColor;

/**
 * Class providing base xchart {@link Theme}.
 *
 * Based on {@link MatlabTheme}.
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
 * @since 0.10.0
 */
public class BaseTheme extends AbstractBaseTheme {

	/**
	 * Preferred font for charts.
	 *
	 * @version 0.10.1
	 */
	private static final String FONTNAME = "Droid Sans";

	@Override
	public Font getBaseFont() {
		return new Font(getFontName(), Font.PLAIN, 10);
	}

	@Override
	public Color[] getSeriesColors() {
		return new BaseSeriesColors().getSeriesColors();
	}

	// Chart Title ///////////////////////////////

	@Override
	public boolean isChartTitleBoxVisible() {
		return false;
	}

	// Chart Axes ///////////////////////////////

	@Override
	public Font getAxisTitleFont() {
		return getBaseFont().deriveFont(12f);
	}

	@Override
	public boolean isAxisTicksLineVisible() {
		return false;
	}

	@Override
	public boolean isAxisTicksMarksVisible() {
		return false;
	}

	@Override
	public Color getPlotBorderColor() {
		return ChartColor.getAWTColor(ChartColor.BLACK);
	}

	@Override
	public boolean isPlotBorderVisible() {
		return false;
	}

	@Override
	public Color getPlotGridLinesColor() {
		return ChartColor.getAWTColor(ChartColor.BLACK);
	}

	@Override
	public Stroke getPlotGridLinesStroke() {
		return new BasicStroke(0.25f, BasicStroke.CAP_BUTT, BasicStroke.CAP_ROUND, 10.0f, new float[] { 1.0f, 2.0f },
				0.0f);
	}

	@Override
	public double getPlotContentSize() {
		return .9;
	}

	// Pie Charts ///////////////////////////////

	@Override
	public double getAnnotationDistance() {
		return .82;
	}

	@Override
	public AnnotationType getAnnotationType() {
		return AnnotationType.Value;
	}

	@Override
	public boolean isSumVisible() {
		return true;
	}

	/**
	 * Returns font name of available font.
	 *
	 * @return font name
	 *
	 * @version 0.10.1
	 */
	public static String getFontName() {

		for (Font font : GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()) {
			if (FONTNAME.equalsIgnoreCase(font.getFontName())) {
				return FONTNAME;
			}
		}

		return "SansSerif";

	}

}

/* EOF */
