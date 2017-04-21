package de.edgesoft.edgeutils.xchart;

import java.util.HashMap;
import java.util.Map;

import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.VectorGraphicsEncoder.VectorGraphicsFormat;

/**
 * Class providing encoder formats.
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
public class EncoderFormats {

	/**
	 * Map of bitmap formats.
	 *
	 * @version 0.10.0
	 * @since 0.10.0
	 */
	private static Map<String, BitmapFormat> mapBitmapFormats = null;

	/**
	 * Map of vector formats.
	 *
	 * @version 0.10.0
	 * @since 0.10.0
	 */
	private static Map<String, VectorGraphicsFormat> mapVectorFormats = null;

	/**
	 * Returns bitmap formats.
	 *
	 * @return map of bitmap formats
	 *
	 * @version 0.10.0
	 * @since 0.10.0
	 */
	public static Map<String, BitmapFormat> BitmapFormats() {

		if (mapBitmapFormats == null) {

			mapBitmapFormats = new HashMap<>();

			for (BitmapFormat format : BitmapFormat.values()) {
				mapBitmapFormats.put(format.toString().toLowerCase(), format);
			}

		}

		return mapBitmapFormats;

	}

	/**
	 * Returns vector formats.
	 *
	 * @return map of vector formats
	 *
	 * @version 0.10.0
	 * @since 0.10.0
	 */
	public static Map<String, VectorGraphicsFormat> VectorFormats() {

		if (mapVectorFormats == null) {

			mapVectorFormats = new HashMap<>();

			for (VectorGraphicsFormat format : VectorGraphicsFormat.values()) {
				mapVectorFormats.put(format.toString().toLowerCase(), format);
			}

		}

		return mapVectorFormats;

	}

}

/* EOF */
