package de.edgesoft.edgeutils.files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;



/**
 * Class providing usual file access operations.
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
	 *   FileAccess.setEncoding(StandardCharsets.UTF_8);
	 * 
	 * @param newEncoding the file encoding
	 */
	public static void setEncoding(final Charset newEncoding) {
		Objects.requireNonNull(newEncoding, "encoding must not be null");
		theEncoding = newEncoding;
	}
	
	/**
	 * Returns the current file encoding.
	 * 
	 * @return the file encoding
	 * 
	 * @since 0.11.0
	 */
	public static Charset getEncoding() {
		return theEncoding;
	}
	
	/**
	 * Read content of a file.
	 * 
	 * @param theFileName filename
	 * @return file content
	 * 
	 * @throws Exception if one occurs
	 */
	public static StringBuilder readFile(final Path theFileName) throws Exception {
		
		Objects.requireNonNull(theFileName, "filename must not be null");
		
		StringBuilder sbReturn = new StringBuilder();
		
		readFileInList(theFileName).stream().forEach(
				(String line) -> {
					sbReturn.append(line);
					sbReturn.append(System.lineSeparator());
					}
				);
		
		return sbReturn;
	}
	        
	/**
	 * Read content of a file as list.
	 * 
	 * @param theFileName filename
	 * @return file content as list
	 * 
	 * @throws Exception if one occurs
	 *  
	 * @since 0.5.0
	 */
	public static List<String> readFileInList(final Path theFileName) throws Exception {
		
		Objects.requireNonNull(theFileName, "filename must not be null");
		
		Stream<String> stmFileContent = Files.lines(theFileName, theEncoding);
		
		List<String> lstReturn = stmFileContent.collect(Collectors.toList());
		
		stmFileContent.close();
		
		return lstReturn;
	}
	        
	/**
	 * Write content to a file.
	 * 
	 * This method creates the whole path to the file, if it does not exist.
	 * 
	 * @param theFileName filename
	 * @param theContent file content
	 *  
	 * @throws Exception if one occurs
	 */
	public static void writeFile(final Path theFileName, final String theContent) throws IOException {
		
		Objects.requireNonNull(theFileName, "filename must not be null");
		Objects.requireNonNull(theContent, "content must not be null");
		
		writeFile(theFileName, Arrays.asList(theContent));
	}
	
	/**
	 * Write list content to a file.
	 * 
	 * This method creates the whole path to the file, if it does not exist.
	 * 
	 * @param theFileName filename
	 * @param theContent file content (list)
	 *  
	 * @throws Exception if one occurs
	 *  
	 * @since 0.5.0
	 */
	public static void writeFile(final Path theFileName, final List<String> theContent) throws IOException {
		
		Objects.requireNonNull(theFileName, "filename must not be null");
		Objects.requireNonNull(theContent, "content must not be null");
		
		if (theFileName.getParent() != null) {
			Files.createDirectories(theFileName.getParent());
		}
		
		Files.write(theFileName, theContent, theEncoding);

	}
	
}

/* EOF */
