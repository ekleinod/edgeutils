package de.edgesoft.edgeutils.commandline;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import de.edgesoft.edgeutils.Messages;



/**
 * Basic abstract class for classes with command line interface and a `main` method.
 * 
 * ## Legal stuff
 * 
 * Copyright 2010-2016 Ekkart Kleinod <ekleinod@edgesoft.de>
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
 * @version 0.4.0
 * @since 0.1
 */
public abstract class AbstractMainClass {
	
	/** Options. */
	private static Options optOptions = null;
	
	/** Command line values. */
	private static CommandLine cliCommandLine = null;
	
	/** Description of class. */
	private static String sDescription = null;
	
	/** Calling class. */
	private static Class<? extends AbstractMainClass> clsCalling = null;

	/**
	 * Initialization with and parsing of arguments.
	 * 
	 * This method initializes the parser with the given options and parses the options.
	 * If parsing fails, init prints the error message and usage information, and exits with error code `1`. 
	 * 
	 * @param args command line arguments
	 * 
	 * @version 0.4.0
	 * @since 0.1
	 */
	public static void init(String[] args) {
		try {
			// parse options
			cliCommandLine = new DefaultParser().parse(getOptions(), args);
		} catch (Exception e) {
			Messages.printError(getUsage(e));
			System.exit(1);
		}
	}

	/**
	 * Adds an option.
	 * 
	 * @param theShortName short name
	 * @param theLongName long name
	 * @param theDescription description
	 * @param hasArgument does option have an argument?
	 * @param isRequired is option required?
	 *  
	 * @version 0.4.0
	 * @since 0.1
	 */
	public static void addOption(String theShortName, String theLongName, String theDescription, boolean hasArgument, boolean isRequired) {
		getOptions().addOption(Option.builder(theShortName).longOpt(theLongName).desc(theDescription).hasArg(hasArgument).required(isRequired).build());
	}
	
	/**
	 * Returns the options.
	 * 
	 * @return options
	 *  
	 * @version 0.4.0
	 * @since 0.1
	 */
	public static Options getOptions() {
		if (optOptions == null) {
			optOptions = new Options();
		}
		return optOptions;
	}
	
	/**
	 * Returns value of option.
	 * 
	 * @param theShortName option
	 * @return value
	 *  
	 * @version 0.4.0
	 * @since 0.1
	 */
	public static String getOptionValue(String theShortName) {
		return cliCommandLine.getOptionValue(theShortName);
	}

	/**
	 * Returns if option was stated.
	 * 
	 * @param theShortName option
	 * @return if option in command line?
	 *  
	 * @version 0.4.0
	 * @since 0.1
	 */
	public static boolean hasOption(String theShortName) {
		return cliCommandLine.hasOption(theShortName);
	}

	/**
	 * Returns the calling class.
	 * 
	 * @return the calling class (abstract class if empty)
	 * 
	 * @version 0.4.0
	 * @since 0.4.0
	 */
	public static Class<? extends AbstractMainClass> getCallingClass() {
		return (clsCalling == null) ? AbstractMainClass.class : clsCalling;
	}

	/**
	 * Sets calling class (for usage text).
	 * 
	 * @param theCallingClass the calling class
	 * 
	 * @version 0.4.0
	 * @since 0.4.0
	 */
	public static void setCallingClass(Class<? extends AbstractMainClass> theCallingClass) {
		clsCalling = theCallingClass;
	}

	/**
	 * Returns the description.
	 * 
	 * @return the description (empty if not set)
	 * 
	 * @version 0.4.0
	 * @since 0.4.0
	 */
	public static String getDescription() {
		return (sDescription == null) ? "" : sDescription;
	}

	/**
	 * Sets the description.
	 * 
	 * @param theDescription the description to set
	 * 
	 * @version 0.4.0
	 * @since 0.4.0
	 */
	public static void setDescription(String theDescription) {
		sDescription = theDescription;
	}

	/**
	 * Returns the usage message.
	 * 
	 * @return usage message
	 * 
	 * @version 0.4.0
	 * @since 0.1
	 */
	public static String getUsage() {
		return getUsage(null);
	}
	
	/**
	 * Returns the usage message with exception message.
	 * 
	 * @return usage message
	 * 
	 * @version 0.4.0
	 * @since 0.4.0
	 */
	public static String getUsage(Exception e) {
		
		HelpFormatter helpFormatter = new HelpFormatter();
		helpFormatter.printHelp(getCallingClass().getSimpleName(), getDescription(), getOptions(), (e == null) ? "" : e.getMessage(), true);
		
		return "";

	}
	
}

/* EOF */
