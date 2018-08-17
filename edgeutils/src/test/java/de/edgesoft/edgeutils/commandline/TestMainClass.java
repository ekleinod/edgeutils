package de.edgesoft.edgeutils.commandline;

/**
 * Test class for AbstractMainClass.
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
 * @since 0.4.0
 */
public class TestMainClass extends AbstractMainClass {
	
	/**
	 * Dummy public field for field getting test.
	 */
	public String sDummy1 = null;
	
	/**
	 * Dummy public field for field getting test.
	 */
	public String sDummy2 = null;
	
	/**
	 * Command line entry point.
	 * 
	 * @param args command line arguments
	 * 
	 * @version 0.10.1
	 * @since 0.4.0
	 */
	public static void main(String[] args) {
		new TestMainClass().executeOperation(args);
	}

	/**
	 * Programmatic entry point, initializing and executing main functionality.
	 * 
	 * - set description setDescription("...");
	 * - add options addOption("short", "long", "description", argument?, required?);
	 * - call init(args);
	 * - call operation execution with arguments
	 * 
	 * @version 0.10.1
	 * @since 0.4.0
	 */
	@Override
	public void executeOperation(String[] args) {
		
		setDescription("JUnit test class.");
		
		addOption("n", "non-argument", "optional parameter without argument", false, false);
		addOption("a", "argument", "optional parameter with argument", true, false);
		addOption("r", "required", "required parameter without argument", false, true);
		addOption("t", "true", "required parameter with argument", true, true);
		
		init(args);
		
		executeOperation(hasOption("n"), getOptionValue("a"), hasOption("r"), getOptionValue("t"));
	}

	/**
	 * Programmatic entry point for executing main functionality.
	 * 
	 * @param theN n argument
	 * @param theA a argument
	 * @param theR r argument
	 * @param theT t argument
	 * 
	 * @version 0.10.1
	 * @since 0.4.0
	 */
	@SuppressWarnings("unused")
	public void executeOperation(boolean theN, String theA, boolean theR, String theT) {
		// not important for tests
	}
		
}

/* EOF */
