package de.edgesoft.edgeutils.files;

/**
 * Class file utilities.
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
 * @version 0.10.0
 * @since 0.9.7
 */
public class FileUtils {

	/**
	 * Returns a clean, special character free filename.
	 *
	 * @param theFilename the file name
	 * @return cleaned filename
	 *
	 * @version 0.10.0
	 * @since 0.9.7
	 */
	public static String cleanFilename(final String theFilename) {
		return theFilename
				.replace("ä", "ae")
				.replace("Ä", "Ae")
				.replace("ö", "oe")
				.replace("Ö", "Oe")
				.replace("ü", "ue")
				.replace("Ü", "Ue")
				.replace("ß", "ss")
				.replace(" ", "_")
				.replace("?", "_")
				.replace(":", "_")
				.replace(";", "_")
				.replace(",", "_")
				.replace(".", "_")
				.replace("/", "_")
				.replace("\\", "_")
				;
	}

}

/* EOF */
