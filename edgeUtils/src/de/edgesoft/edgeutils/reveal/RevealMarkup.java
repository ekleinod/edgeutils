package de.edgesoft.edgeutils.reveal;




/**
 * Reveal (reveal.js) markup constants and methods.
 * 
 * ## Legal stuff
 * 
 * Copyright 2014-2014 Ekkart Kleinod <ekleinod@edgesoft.de>
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
 * @version 0.2
 * @since 0.2
 */
public class RevealMarkup {
	
	/** slide start. */
	public final static String SLIDE_START = "<section>\n";
	
	/** slide end. */
	public final static String SLIDE_END = "</section>\n";
	
	/** heading token. */
	public final static String HEADING_TOKEN = "<h%1$d>%%s</h%1$d>\n\n";
	
	/** paragraph. */
	public final static String PARAGRAPH = "<p class=\"%s\">%s</p>\n";
	
	/** list start. */
	public final static String LIST_START = "<ol class=\"%s\">\n";
	
	/** list item start. */
	public final static String LIST_ITEM_START = "<li class=\"%s\">";
	
	/** list item end. */
	public final static String LIST_ITEM_END = "</li>\n";
	
	/** list end. */
	public final static String LIST_END = "</ol>\n";
	
	/** blockquote start. */
	public final static String BLOCKQUOTE_START = "<blockquote>\n";
	
	/** blockquote end. */
	public final static String BLOCKQUOTE_END = "</blockquote>\n";
	
	/**
	 * Returns heading token for given level.
	 * 
	 * @param iLevel level of heading
	 * @return heading token
	 * 
	 * @version 0.2
	 * @since 0.2
	 */
	public static String getHeadingToken(int iLevel) {
		return String.format(HEADING_TOKEN, iLevel);		
	}
	
}

/* EOF */
