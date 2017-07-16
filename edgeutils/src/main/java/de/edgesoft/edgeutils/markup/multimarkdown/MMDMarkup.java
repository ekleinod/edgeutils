package de.edgesoft.edgeutils.markup.multimarkdown;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.edgesoft.edgeutils.markup.latex.LaTeXMarkup;


/**
 * MMD (multimarkdown) markup constants and methods.
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
 * @version 0.10.1
 * @since 0.1
 */
public class MMDMarkup {
	
	/** direct LaTeX. */
	public final static String LATEX = "<!--%s-->";
	
	/** LaTeX content. */
	public final static String LATEX_CONTENT = "-->%s<!--";
	
	/** heading token. */
	public final static String HEADING_TOKEN = "#";
	
	/** heading. */
	public final static String HEADING = "%s %%s [%%s]\n\n";
	
	/** minisec. */
	public final static String MINISEC = String.format("%s\n\n", String.format(LATEX, String.format(LaTeXMarkup.MINISEC, LATEX_CONTENT)));
	
	/** emphasized text. */
	public final static String EMPH = "*%s*";
	
	/** bold text. */
	public final static String BOLD = "**%s**";
	
	/** colored text (named). */
	public final static String TEXTCOLOR_NAMED = String.format(LATEX, String.format(LaTeXMarkup.TEXTCOLOR_NAMED, "%s", LATEX_CONTENT));
	
	/** colored background (named). */
	public final static String BGCOLOR_NAMED = String.format(LATEX, String.format(LaTeXMarkup.BGCOLOR_NAMED, "%s", LATEX_CONTENT));
	
	/** colored text (RGB). */
	public final static String TEXTCOLOR_RGB = String.format(LATEX, LaTeXMarkup.TEXTCOLOR_RGB);
	
	/** colored background (RGB). */
	public final static String BGCOLOR_RGB = String.format(LATEX, LaTeXMarkup.BGCOLOR_RGB);
	
	/** footnote reference. */
	public final static String FOOTNOTE_REFERENCE = "[%s]";
	
	/** footnote definition. */
	public final static String FOOTNOTE_DEFINITION = "[%s]: %s\n\n";
	
	/** text reference. */
	public final static String TEXT_REFERENCE = "[%s][%s]";
	
	/** tabbing start. */
	public final static String TABBING_START = String.format("%s\n", String.format(LATEX, String.format(LaTeXMarkup.TABBING_START, LATEX_CONTENT)));
	
	/** tabbing line. */
	public final static String TABBING_LINE = String.format("%s\n", String.format(LATEX, String.format(LaTeXMarkup.TABBING_LINE, LATEX_CONTENT, LATEX_CONTENT)));
	
	/** tabbing end. */
	public final static String TABBING_END = String.format("%s\n\n", String.format(LATEX, LaTeXMarkup.TABBING_END, LATEX_CONTENT));
	
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
	 * 
	 * @version 0.10.1
	 * @since 0.1
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
	 * 
	 * @version 0.10.1
	 * @since 0.1
	 */
	public static String getRGBColorToken(String theToken, Color theColor) {
		return String.format(LaTeXMarkup.getRGBColorToken(theToken, theColor), LATEX_CONTENT);
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
	 * @version 0.10.1
	 * @since 0.1
	 */
	public static String getTableStartToken(String theTableName, List<String> theHeadings, List<Double> theColWidths, boolean isHeadingBold, String theRule) {
		List<String> lstHeadings = new ArrayList<>();
		if (theHeadings != null) {
			for (String theHeading : theHeadings) {
				lstHeadings.add(String.format(LATEX_CONTENT, (isHeadingBold) ? String.format(BOLD, theHeading) : theHeading));
			}
		}
		
		return String.format(LATEX, LaTeXMarkup.getTableStartToken(theTableName, lstHeadings, theColWidths, false, theRule));
	}
	
	/**
	 * Returns table line token.
	 * 
	 * @param theContent heading (null or empty allowed)
	 * @param theRule rule to print after line (null = no rule)
	 * @return table line token
	 * 
	 * @version 0.10.1
	 * @since 0.1
	 */
	public static String getTableLineToken(List<String> theContent, String theRule) {
		List<String> lstContent = new ArrayList<>();
		if (theContent != null) {
			for (String theCellContent : theContent) {
				lstContent.add(String.format(LATEX_CONTENT, theCellContent));
			}
		}
		
		return String.format(LATEX, LaTeXMarkup.getTableLineToken(lstContent, theRule));
	}
	
	/**
	 * Returns table end token.
	 * 
	 * @param theTableName name of the table (null = longtable)
	 * 
	 * @version 0.10.1
	 * @since 0.1
	 */
	public static String getTableEndToken(String theTableName) {
		return String.format(LATEX, LaTeXMarkup.getTableEndToken(theTableName));
	}
	
}

/* EOF */
