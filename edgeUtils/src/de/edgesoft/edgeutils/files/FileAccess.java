package de.edgesoft.edgeutils.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;



/**
 * Class providing usual file access operations.
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
public class FileAccess {
	
	/** Standard encoding to use: UTF-8. */
	private static String sEncoding = StandardCharsets.UTF_8.name();
	
	/**
	 * Sets the file encoding.
	 * 
	 * Encoding is not checked for validity.
	 * For the standard encodings see java.nio.charsets.StandardCharsets.
	 * 
	 * Use them as follows, example: UTF-8:
	 * 
	 *   JAXBFiles.setEncoding(StandardCharsets.UTF_8.name());
	 * 
	 * @param theEncoding the filename of the file to unmarshal
	 * 
	 * @version 0.1
	 * @since 0.1
	 */
	public static void setEncoding(String theEncoding) {
		sEncoding = theEncoding;
	}
	
	/**
	 * Read content of a file.
	 * 
	 * @param theFileName filename
	 * @return file content
	 * 
	 * @throws Exception if one occurs, just delegates thrown exceptions
	 *  
	 * @version 0.1
	 * @since 0.1
	 */
	public static StringBuilder readFile(String theFileName) throws Exception {
		
		StringBuilder sbReturn = new StringBuilder();
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(theFileName), sEncoding))) {
		
			String sLine = "";
			while ((sLine = reader.readLine()) != null) {
				sbReturn.append(sLine);
				sbReturn.append("\n");
			}
			
		}
		
		return sbReturn;
	}
	        
	/**
	 * Write content to a file.
	 * 
	 * Thie method created the whole path to the file, if it does not exist.
	 * 
	 * @param theFileName filename
	 * @param theContent file content
	 *  
	 * @throws Exception if one occurs, just delegates thrown exceptions; throws own IOExceptions
	 *  
	 * @version 0.1
	 * @since 0.1
	 */
	public static void writeFile(String theFileName, String theContent) throws Exception {
	        
		File fleOutput = new File(theFileName);
		if (fleOutput.getParentFile() != null) {
			fleOutput.getParentFile().mkdirs();
		}

		if (fleOutput.exists() && !fleOutput.isFile()) {
			throw new IOException(MessageFormat.format("File ''{0}'' is no file (maybe a directory?)", theFileName));
		}
		if (fleOutput.exists() && !fleOutput.canWrite()) {
			throw new IOException(MessageFormat.format("File ''{0}'' is not writeable.", theFileName));
		}
		
		try (BufferedWriter wrtOutput = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fleOutput), sEncoding))) {
			wrtOutput.write(theContent);
		}
		
	}
	
}

/* EOF */
