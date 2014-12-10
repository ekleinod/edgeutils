package de.edgesoft.edgeutils.markup.latex;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * LaTeX markup constants and methods.
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
 * @version 0.3
 * @since 0.1
 */
public class LaTeXMarkup {
	
	/** bold text. */
	public final static String BOLD = "\\textbf{%s}";
	
	/** minisec. */
	public final static String MINISEC = "\\minisec{%s}\n\n";
	
	/** colored text (named). */
	public final static String TEXTCOLOR_NAMED = "\\textcolor{%s}{%s}";
	
	/** colored background (named). */
	public final static String BGCOLOR_NAMED = "\\colorbox{%s}{%s}";
	
	/** colored text (RGB). */
	public final static String TEXTCOLOR_RGB = "\\textcolor[rgb]{%.2f,%.2f,%.2f}{%%s}";
	
	/** colored background (RGB). */
	public final static String BGCOLOR_RGB = "\\colorbox[rgb]{%.2f,%.2f,%.2f}{%%s}";
	
	/** tabbing start. */
	public final static String TABBING_START = "\\begin{tabbing}\n\t%s\\=\\kill\n";
	
	/** tabbing line. */
	public final static String TABBING_LINE = "\t%s\\>%s\\\\\n";
	
	/** tabbing end. */
	public final static String TABBING_END = "\\end{tabbing}\n\n";
	
	/** table start. */
	public final static String TABLE_START = "\n\\begin{%s}\n\t{@{}%s@{}}\n%s\n\n";
	
	/** table line. */
	public final static String TABLE_LINE = "\t%s\\\\\n";
	
	/** table separator. */
	public final static String TABLE_SEP = " & ";
	
	/** table line. */
	public final static String TABLE_RULE = "\t%s\n";
	
	/** table end. */
	public final static String TABLE_END = "\n\\end{%s}\n\n";
	
	/**
	 * Returns token for colored text/background (RGB).
	 * 
	 * @param theToken color token
	 * @param theColor color
	 * @return color token
	 * 
	 * @version 0.1
	 * @since 0.1
	 */
	public static String getRGBColorToken(String theToken, Color theColor) {
		return String.format(Locale.ENGLISH, theToken, theColor.getRGBComponents(null)[0], theColor.getRGBComponents(null)[1], theColor.getRGBComponents(null)[2]);
	}
	
	/**
	 * Returns table start token.
	 * 
	 * @param theTableName name of the table (null = longtable)
	 * @param theHeadings heading (null or empty allowed)
	 * @param theColWidths column widths
	 * @param isHeadingBold format heading as bold text?
	 * @param theRule rule to print after heading (null = no rule)
	 * @return table start token
	 * 
	 * @version 0.1
	 * @since 0.1
	 */
	public static String getTableStartToken(String theTableName, List<String> theHeadings, List<Double> theColWidths, boolean isHeadingBold, String theRule) {
		
		String sTableName = (theTableName == null) ? "longtable" : theTableName;
		
		StringBuilder sbCols = new StringBuilder();
		boolean bMore = false;
		for (Double theColWidth : theColWidths) {
			if (bMore) {
				sbCols.append("@{\\hspace{.02\\textwidth}}");
			}
			bMore = true;
			sbCols.append(String.format(Locale.ENGLISH, ">{\\RaggedRight}p{%.2f\\textwidth}", theColWidth));
		}
		
		StringBuilder sbHead = new StringBuilder();
		if ((theHeadings != null) && (!theHeadings.isEmpty())) {
			
			List<String> lstHeadings = new ArrayList<>();
			for (String theHeading : theHeadings) {
				lstHeadings.add((isHeadingBold) ? String.format(BOLD, theHeading) : theHeading);
			}
			sbHead.append(getTableLineToken(lstHeadings, theRule));
			
			sbHead.append("\\endhead");
		}

		return String.format(TABLE_START, sTableName, sbCols.toString(), sbHead.toString());
	}
	
	/**
	 * Returns table line token.
	 * 
	 * @param theContent heading (null or empty allowed)
	 * @param theRule rule to print after line (null = no rule)
	 * @return table line token
	 * 
	 * @version 0.1
	 * @since 0.1
	 */
	public static String getTableLineToken(List<String> theContent, String theRule) {
		
		StringBuilder sbContent = new StringBuilder();
		if ((theContent != null) && (!theContent.isEmpty())) {
			boolean bMore = false;
			for (String theCellContent : theContent) {
				if (bMore) {
					sbContent.append(TABLE_SEP);
				}
				sbContent.append(theCellContent);
				bMore = true;
			}
		}
		
		StringBuilder sbReturn = new StringBuilder();
		
		sbReturn.append(String.format(TABLE_LINE, sbContent.toString()));
		
		if (theRule != null) {
			sbReturn.append(String.format(TABLE_RULE, theRule));
		}
		
		return sbReturn.toString();
	}
	
	/**
	 * Returns table end token.
	 * 
	 * @param theTableName name of the table (null = longtable)
	 * 
	 * @version 0.1
	 * @since 0.1
	 */
	public static String getTableEndToken(String theTableName) {
		return String.format(TABLE_END, (theTableName == null) ? "longtable" : theTableName);
	}
	
}

/* EOF */
