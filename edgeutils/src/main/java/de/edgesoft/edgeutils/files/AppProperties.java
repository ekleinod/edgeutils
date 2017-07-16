package de.edgesoft.edgeutils.files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;



/**
 * Methods and storage for application properties.
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
 * @since 0.5.0
 */
public class AppProperties {
	
	/**
	 * Load properties.
	 * 
	 * @param theDefaultProperties default properties (null = none)
	 * @param theAppPropFile application properties file (null = none)
	 * @param ignoreExceptions irgnore exceptions?
	 * 
	 * @return loaded properties
	 *  
	 * @throws IOException if one occurs, just delegates thrown exceptions
	 *  
	 * @version 0.10.1
	 * @since 0.8.0
	 */
	public static Properties getProperties(final Properties theDefaultProperties, final String theAppPropFile, final boolean ignoreExceptions) throws IOException {
		
		// load specific properties, fill with default if not present
		Properties appProps = new Properties(theDefaultProperties);
		
		if (theAppPropFile != null) {
			try (FileInputStream stmIn = new FileInputStream(theAppPropFile)) {
				appProps.load(stmIn);
			} catch (IOException e) {
				if (!ignoreExceptions) {
					throw e;
				}
			}
		}
	        
		return appProps;
		
	}
	
	/**
	 * Load properties.
	 * 
	 * @param theDefaultPropFile default properties file (null = none)
	 * @param theAppPropFile application properties file (null = none)
	 * @param ignoreExceptions irgnore exceptions?
	 * 
	 * @return loaded properties
	 *  
	 * @throws IOException if one occurs, just delegates thrown exceptions
	 *  
	 * @version 0.10.1
	 * @since 0.5.0
	 */
	public static Properties getProperties(String theDefaultPropFile, String theAppPropFile, final boolean ignoreExceptions) throws IOException {
		
		// load default properties
		Properties defaultProps = new Properties();
		
		if (theDefaultPropFile != null) {
			try (FileInputStream stmIn = new FileInputStream(theDefaultPropFile)) {
				defaultProps.load(stmIn);
			} catch (IOException e) {
				if (!ignoreExceptions) {
					throw e;
				}
			} 
		}
		
		// load specific properties, fill with default if not present
		Properties appProps = new Properties(defaultProps);
		
		if (theAppPropFile != null) {
			try (FileInputStream stmIn = new FileInputStream(theAppPropFile)) {
				appProps.load(stmIn);
			} catch (IOException e) {
				if (!ignoreExceptions) {
					throw e;
				}
			} 
		}
	        
		return appProps;
		
	}
	
	/**
	 * Save properties.
	 * 
	 * @param theProps properties to save
	 * @param thePropFile properties file
	 * @param theComment comment (null for no comment)
	 * 
	 * @throws IOException if one occurs, just delegates thrown exceptions
	 *  
	 * @version 0.10.1
	 * @since 0.5.0
	 */
	public static void saveProperties(Properties theProps, String thePropFile, String theComment) throws IOException {
		
		try (FileOutputStream stmOut = new FileOutputStream(thePropFile)) {
			theProps.store(stmOut, theComment);
		} 
		
	}
	
}

/* EOF */
