package de.edgesoft.edgeutils;



/**
 * Print messages for the user.
 * 
 * This class prints messages for the user, I just wrap system out/err here.
 * Maybe later I can switch output to log or files if I want to.
 * Change of style is possible too.
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
public class Messages {
	
	/**
	 * Prints a message.
	 * 
	 * @param theMessage the message
	 *  
	 * @version 0.10.1
	 * @since 0.1
	 */
	public static void printMessage(String theMessage) {
		System.out.println(theMessage);
	}
	
	/**
	 * Prints an error message.
	 * 
	 * @param theError the error message
	 *  
	 * @version 0.10.1
	 * @since 0.1
	 */
	public static void printError(String theError) {
		System.err.println(theError);
	}
	
	/**
	 * Prints an exception.
	 * 
	 * @param theException the exception
	 *  
	 * @version 0.10.1
	 * @since 0.1
	 */
	public static void printError(Exception theException) {
		theException.printStackTrace();
	}
	
}

/* EOF */
