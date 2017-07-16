package de.edgesoft.edgeutils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Utilities for {@link Class}.
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
 * @since 0.104.0
 */
public class ClassUtils {

	/**
	 * Returns declared fields including class inheritance up to the last abstract class.
	 *
	 * @param theClass the class to get the fields for
	 * @return list of declared fields
	 *
	 * @version 0.10.1
	 */
	public static List<Field> getDeclaredFieldsFirstAbstraction(final Class<?> theClass) {

		Objects.requireNonNull(theClass);

		List<Field> lstReturn = new ArrayList<>();

        Class<?> clsTemp = theClass;
    	lstReturn.addAll(Arrays.asList(clsTemp.getDeclaredFields()));

        while (Modifier.isAbstract(clsTemp.getSuperclass().getModifiers())) {
        	clsTemp = clsTemp.getSuperclass();
        	lstReturn.addAll(Arrays.asList(clsTemp.getDeclaredFields()));
        }

        return lstReturn;

	}


	/**
	 * Returns declared fields including class inheritance.
	 *
	 * @param theClass the class to get the fields for
	 * @return list of declared fields
	 *
	 * @version 0.10.1
	 */
	public static List<Field> getDeclaredFieldsInheritance(final Class<?> theClass) {

		Objects.requireNonNull(theClass);

		List<Field> lstReturn = new ArrayList<>();

        Class<?> clsTemp = theClass;
    	lstReturn.addAll(Arrays.asList(clsTemp.getDeclaredFields()));

        while (clsTemp.getSuperclass() != null) {
        	clsTemp = clsTemp.getSuperclass();
        	lstReturn.addAll(Arrays.asList(clsTemp.getDeclaredFields()));
        }

        return lstReturn;

	}

}

/* EOF */
