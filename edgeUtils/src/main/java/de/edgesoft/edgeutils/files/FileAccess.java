package de.edgesoft.edgeutils.files;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;



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
 * @version 0.5.0
 * @since 0.1
 */
public class FileAccess {
	
	/** Standard encoding to use: UTF-8. */
	private static Charset theEncoding = StandardCharsets.UTF_8;
	
	/**
	 * Sets the file encoding.
	 * 
	 * For the standard encodings see java.nio.charsets.StandardCharsets.
	 * 
	 * Use them as follows, example: UTF-8:
	 * 
	 *   JAXBFiles.setEncoding(StandardCharsets.UTF_8);
	 * 
	 * @param newEncoding the file encoding
	 * 
	 * @version 0.5.0
	 * @since 0.1
	 */
	public static void setEncoding(Charset newEncoding) {
		theEncoding = newEncoding;
	}
	
	/**
	 * Read content of a file.
	 * 
	 * @param theFileName filename
	 * @return file content
	 * 
	 * @throws Exception if one occurs, just delegates thrown exceptions
	 *  
	 * @version 0.5.0
	 * @since 0.1
	 */
	public static StringBuilder readFile(String theFileName) throws Exception {
		
		StringBuilder sbReturn = new StringBuilder();
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(theFileName), theEncoding))) {
		
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
	 * This method creates the whole path to the file, if it does not exist.
	 * 
	 * @param theFileName filename
	 * @param theContent file content
	 *  
	 * @throws Exception if one occurs, just delegates thrown exceptions; throws own exceptions
	 *  
	 * @version 0.5.0
	 * @since 0.1
	 */
	public static void writeFile(final String theFileName, final String theContent) throws IOException {
		
		Objects.requireNonNull(theFileName, "filename must not be null");
		Objects.requireNonNull(theContent, "content must not be null");
		
		Path outFilePath = Paths.get(theFileName);
	        
		if (outFilePath.getParent() != null) {
			Files.createDirectories(outFilePath.getParent());
		}
		
		Files.write(outFilePath, Arrays.asList(theContent), theEncoding);

	}
	
}

/* EOF */
