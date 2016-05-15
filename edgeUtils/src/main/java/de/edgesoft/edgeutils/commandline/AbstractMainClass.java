package de.edgesoft.edgeutils.commandline;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;

import de.edgesoft.edgeutils.Messages;



/**
 * Basic abstract class for classes with command line interface and a `main` method.
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
public abstract class AbstractMainClass {
	
	/** Storage for options. */
	private static List<CommandOption> lstCommandOptions = null;
	
	/** Command line values. */
	private static CommandLine theCommandLine = null;
	
	/** Calling class. */
	private static Class<? extends AbstractMainClass> theCallingClass = null;

	/**
	 * Initialization with and parsing of arguments.
	 * 
	 * This method initializes the parser with the given options and parses the options.
	 * If parsing fails, init prints the error message and usage information, and exits with error code `1`. 
	 * 
	 * @param args command line arguments
	 * @param theClass calling class (needed for printing usage information)
	 * 
	 * @version 0.1
	 * @since 0.1
	 */
	public static void init(String[] args, Class<? extends AbstractMainClass> theClass) {
		try {
			// store calling class
			theCallingClass = theClass;
			
			// handle commandline options with apache commons cli
			Options theOptions = new Options();
			for (CommandOption theCommandOption : lstCommandOptions) {
				theOptions.addOption(theCommandOption);
			}
			
			// parse options
			theCommandLine = new PosixParser().parse(theOptions, args);
		} catch (Exception e) {
			Messages.printError("");
			Messages.printError(getUsage());
			Messages.printError("");
			Messages.printError(e);
			System.exit(1);
		}
	}

	/**
	 * Adds a command option.
	 * 
	 * @param theCommandOption new command option
	 *  
	 * @version 0.1
	 * @since 0.1
	 */
	public static void addCommandOption(CommandOption theCommandOption) {
		getCommandOptions().add(theCommandOption);
	}
	
	/**
	 * Returns the command options.
	 * 
	 * @return command options (empty list if there are none)
	 *  
	 * @version 0.1
	 * @since 0.1
	 */
	public static List<CommandOption> getCommandOptions() {
		if (lstCommandOptions == null) {
			lstCommandOptions = new ArrayList<>();
		}
		return lstCommandOptions;
	}
	
	/**
	 * Returns value of given option.
	 * 
	 * @param theCommandOption option
	 * @return value
	 *  
	 * @version 0.1
	 * @since 0.1
	 */
	public static String getOptionValue(CommandOption theCommandOption) {
		return theCommandLine.getOptionValue(theCommandOption.getOpt());
	}

	/**
	 * Returns if given option was stated.
	 * 
	 * @param theCommandOption option
	 * @return if option in command line?
	 *  
	 * @version 0.1
	 * @since 0.1
	 */
	public static boolean hasOption(CommandOption theCommandOption) {
		return theCommandLine.hasOption(theCommandOption.getOpt());
	}

	/**
	 * Returns the usage message.
	 * 
	 * @return usage message
	 * 
	 * @version 0.1
	 * @since 0.1
	 */
	public static String getUsage() {
		StringBuffer sbReturn = new StringBuffer();

		sbReturn.append(MessageFormat.format("Call: java -jar {0}.jar{1}",
				theCallingClass.getSimpleName().toLowerCase(),
				System.getProperty("line.separator")));

		for (CommandOption theCommandOption : lstCommandOptions) {
			sbReturn.append(MessageFormat.format("\t{0}{1}",
					theCommandOption.getUsage(),
					System.getProperty("line.separator")));
		}

		return sbReturn.toString();
	}
	
}

/* EOF */
