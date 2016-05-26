package de.edgesoft.edgeutils.files;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



/**
 * Methods and storage for application properties.
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
 * @version 0.5.0
 * @since 0.5.0
 */
public class AppProperties {
	
	/**
	 * Load properties.
	 * 
	 * @param theDefaultPropFile default properties file (null = none)
	 * @param theAppPropFile application properties file (null = none)
	 * 
	 * @return loaded properties
	 *  
	 * @throws IOException if one occurs, just delegates thrown exceptions
	 *  
	 * @version 0.5.0
	 * @since 0.5.0
	 */
	public static Properties getProperties(String theDefaultPropFile, String theAppPropFile) throws IOException {
		
		// load default properties
		Properties defaultProps = new Properties();
		
		if (theDefaultPropFile != null) {
			try (FileInputStream stmIn = new FileInputStream(theDefaultPropFile)) {
				defaultProps.load(stmIn);
			} 
		}
		
		// load specific properties, fill with default if not present
		Properties appProps = new Properties(defaultProps);
		
		if (theAppPropFile != null) {
			try (FileInputStream stmIn = new FileInputStream(theAppPropFile)) {
				appProps.load(stmIn);
			} 
		}
	        
		return appProps;
		
	}
	
}

/* EOF */
