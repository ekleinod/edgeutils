package de.edgesoft.edgeutils.multimarkdown;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


/**
 * MMD (multimarkdown) markup constants and methods.
 * 
 * ## Legal stuff
 * 
 * Copyright 2010-2014 Ekkart Kleinod <ekleinod@edgesoft.de>
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
 * @version 0.1
 * @since 0.1
 */
public class MMDMarkup {
	
	/** heading token. */
	public final static String HEADING_TOKEN = "#";
	
	/** heading. */
	public final static String HEADING = "%s %%s [%%s]\n\n";
	
	/** minisec. */
	public final static String MINISEC = "<!-- \\minisec{-->%s<!--} -->\n\n";
	
	/** emphasized text. */
	public final static String EMPH = "*%s*";
	
	/** bold text. */
	public final static String BOLD = "**%s**";
	
	/** colored text (named). */
	public final static String TEXTCOLOR_NAMED = "<!--\\textcolor{%s}{-->%s<!--}-->";
	
	/** colored background (named). */
	public final static String BGCOLOR_NAMED = "<!--\\colorbox{%s}{-->%s<!--}-->";
	
	/** colored text (RGB). */
	public final static String TEXTCOLOR_RGB = "<!--\\textcolor[rgb]{%.2f,%.2f,%.2f}{-->%%s<!--}-->";
	
	/** colored background (RGB). */
	public final static String BGCOLOR_RGB = "<!--\\colorbox[rgb]{%.2f,%.2f,%.2f}{-->%%s<!--}-->";
	
	/** footnote reference. */
	public final static String FOOTNOTE_REFERENCE = "[%s]";
	
	/** footnote definition. */
	public final static String FOOTNOTE_DEFINITION = "[%s]: %s\n\n";
	
	/** text reference. */
	public final static String TEXT_REFERENCE = "[%s][%s]";
	
	/** tabbing start. */
	public final static String TABBING_START = "<!--\\begin{tabbing}%s\\=\\kill-->\n";
	
	/** tabbing line. */
	public final static String TABBING_LINE = "%s<!--\\>-->%s<!--\\\\-->\n";
	
	/** tabbing end. */
	public final static String TABBING_END = "<!--\\end{tabbing}-->\n\n";
	
	/** table start. */
	public final static String TABLE_START = "<!--\n\\begin{smalltable}[%snoautoline=true]\n\t" +
			"{@{}%s@{}}\n\n";
	
	/** table line. */
	public final static String TABLE_LINE = "\t%s\\\\%s\n";
	
	/** table end. */
	public final static String TABLE_END = "\n\\end{smalltable}\n-->\n\n";
	
	/** Replacement token (not mmd directly, but helpful to define here). */
	public final static String REPLACEMENT_TOKEN = String.format(BOLD, "generated %s");
	

	/**
	 * Returns heading token for given level.
	 * 
	 * @param iLevel level of heading
	 * @return heading token
	 */
	public static String getHeadingToken(int iLevel) {
		
		if (iLevel >= 4) {
			return MINISEC;
		}
		
		char[] arrFilled = new char[iLevel];
		Arrays.fill(arrFilled, '#');
		return String.format(HEADING, new String(arrFilled));		
	}
	
	/**
	 * Returns token for colored text/background (RGB).
	 * 
	 * @param theToken color token
	 * @param theColor color
	 * @return color token
	 */
	public static String getRGBColorToken(String theToken, Color theColor) {
		return String.format(Locale.ENGLISH, theToken, theColor.getRGBComponents(null)[0], theColor.getRGBComponents(null)[1], theColor.getRGBComponents(null)[2]);
	}
	
	/**
	 * Returns table start token.
	 * 
	 * @param iColCount number of columns
	 * @param theHeadings heading (null or empty allowed)
	 * @param theColWidths column widths
	 * @return table start token
	 */
	public static String getTableStartToken(int iColCount, List<String> theHeadings, List<Double> theColWidths) {
		
		StringBuilder sbHead = new StringBuilder();
		if ((theHeadings != null) && (!theHeadings.isEmpty())) {
			sbHead.append("head={");
			boolean bMore = false;
			for (String theHeading : theHeadings) {
				if (bMore) {
					sbHead.append(" & ");
				}
				sbHead.append(String.format("\\textbf{%s}", theHeading));
				bMore = true;
			}
			sbHead.append("\\\\},");
		}

		StringBuilder sbCols = new StringBuilder();
		boolean bMore = false;
		for (Double theColWidth : theColWidths) {
			if (bMore) {
				sbCols.append("@{\\hspace{.02\\textwidth}}");
			}
			sbCols.append(String.format(Locale.ENGLISH, "p{%.2f\\textwidth}", theColWidth));
			bMore = true;
		}
		
		return String.format(TABLE_START, sbHead.toString(), sbCols.toString());
	}
	
	/**
	 * Returns table line token.
	 * 
	 * @param iColCount number of columns
	 * @param theContents heading (null or empty allowed)
	 * @param isAutoline set autoline?
	 * @return table line token
	 */
	public static String getTableLineToken(int iColCount, List<String> theContents, boolean isAutoline) {
		
		StringBuilder sbContent = new StringBuilder();
		if ((theContents != null) && (!theContents.isEmpty())) {
			boolean bMore = false;
			for (String theContent : theContents) {
				if (bMore) {
					sbContent.append("&");
				}
				sbContent.append(String.format(" -->%s<!-- ", theContent));
				bMore = true;
			}
		}
		
		return String.format(TABLE_LINE, sbContent.toString(), (isAutoline) ? "\n\t\\fhgmidline" : "");
	}
	
}

/* EOF */
