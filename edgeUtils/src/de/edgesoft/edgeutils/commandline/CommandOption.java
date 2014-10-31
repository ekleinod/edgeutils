package de.edgesoft.edgeutils.commandline;

import java.text.MessageFormat;

import org.apache.commons.cli.Option;



/**
 * Command line option with constructor to set if option is required.
 * 
 * The apache option class misses a constructor to set if an option is required.
 * This is a wrapper class for just this purpose.
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
public class CommandOption extends Option {

	/** Default serialization id. */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor, initializing the apache option object
	 *  
	 * @version 0.1
	 * @since 0.1
	 */
	public CommandOption(String opt, String longOpt, boolean hasArg, String description, boolean isRequired) {
		super(opt, longOpt, hasArg, description);
		setRequired(isRequired);
	}
	
	/**
	 * Returns formatted usage string.
	 * 
	 * @return formatted usage string
	 *  
	 * @version 0.1
	 * @since 0.1
	 */
	public String getUsage() {
		return MessageFormat.format((isRequired()) ? "{0}" : "[{0}]", 
				MessageFormat.format("[-{0}|--{1}] {2}",
						getOpt(),
						getLongOpt(),
						getDescription()));
	}
	
}

/* EOF */
