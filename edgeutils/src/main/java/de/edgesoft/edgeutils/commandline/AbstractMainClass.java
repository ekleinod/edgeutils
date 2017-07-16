package de.edgesoft.edgeutils.commandline;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import de.edgesoft.edgeutils.Messages;



/**
 * Basic abstract class for classes with command line interface and a `main` method.
 * 
 * For a sample implementation see {@link TestClass}.
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
 * @since 0.1
 */
public abstract class AbstractMainClass {
	
	/** Options. */
	private Options optOptions = null;
	
	/** Command line values. */
	private CommandLine cliCommandLine = null;
	
	/** Description of class. */
	private String sDescription = null;

	/**
	 * Programmatic entry point, initializing and executing main functionality.
	 * 
	 * - set description setDescription("...");
	 * - add options addOption("short", "long", "description", argument?, required?);
	 * - call init(args);
	 * - call operation execution with arguments
	 * 
	 * @param args command line arguments
	 * 
	 * @version 0.10.0
	 * @since 0.4.0
	 */
	public abstract void executeOperation(String[] args);
		
	/**
	 * Initialization with and parsing of arguments.
	 * 
	 * This method initializes the parser with the given options and parses the options.
	 * If parsing fails, init prints the error message and usage information, and exits with error code `1`. 
	 * 
	 * @param args command line arguments
	 * 
	 * @version 0.10.0
	 * @since 0.1
	 */
	public void init(String[] args) {
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
	 * @version 0.10.0
	 * @since 0.1
	 */
	public void addOption(String theShortName, String theLongName, String theDescription, boolean hasArgument, boolean isRequired) {
		getOptions().addOption(Option.builder(theShortName).longOpt(theLongName).desc(theDescription).hasArg(hasArgument).required(isRequired).build());
	}
	
	/**
	 * Returns the options.
	 * 
	 * @return options
	 *  
	 * @version 0.10.0
	 * @since 0.1
	 */
	public Options getOptions() {
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
	 * @version 0.10.0
	 * @since 0.1
	 */
	public String getOptionValue(String theShortName) {
		return cliCommandLine.getOptionValue(theShortName);
	}

	/**
	 * Returns if option was stated.
	 * 
	 * @param theShortName option
	 * @return if option in command line?
	 *  
	 * @version 0.10.0
	 * @since 0.1
	 */
	public boolean hasOption(String theShortName) {
		return cliCommandLine.hasOption(theShortName);
	}

	/**
	 * Returns the description.
	 * 
	 * @return the description (empty if not set)
	 * 
	 * @version 0.10.0
	 * @since 0.4.0
	 */
	public String getDescription() {
		return (sDescription == null) ? "" : sDescription;
	}

	/**
	 * Sets the description.
	 * 
	 * @param theDescription the description to set
	 * 
	 * @version 0.10.0
	 * @since 0.4.0
	 */
	public void setDescription(String theDescription) {
		sDescription = theDescription;
	}

	/**
	 * Returns the usage message.
	 * 
	 * @return usage message
	 * 
	 * @version 0.10.0
	 * @since 0.1
	 */
	public String getUsage() {
		return getUsage(null);
	}
	
	/**
	 * Returns the usage message with exception message.
	 * 
	 * The default implementation of {@link HelpFormatter#printHelp(String, String, Options, String)}
	 * prints to {@link System#out}, I want to get the usage String by its own, then
	 * deciding what to do with it.
	 * 
	 * Thus, I set the default values as in the original class and use
	 * a {@link StringWriter} as output of the {@link PrintWriter}.
	 * 
	 * Complicated but I did not see another good solution.
	 * 
	 * @return usage message
	 * 
	 * @version 0.10.0
	 * @since 0.4.0
	 */
	public String getUsage(Exception e) {
		
		HelpFormatter hFormatter = new HelpFormatter();
		StringWriter sWriter = new StringWriter();
        PrintWriter pWriter = new PrintWriter(sWriter);

		hFormatter.printHelp(pWriter, 
				hFormatter.getWidth(), 
				this.getClass().getSimpleName(), 
				getDescription(), 
				getOptions(), 
				hFormatter.getLeftPadding(), 
				hFormatter.getDescPadding(), 
				((e == null) ? "" : e.getMessage()),
				true);
		
        pWriter.flush();
		return sWriter.toString();
	}
	
}

/* EOF */
