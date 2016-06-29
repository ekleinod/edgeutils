package de.edgesoft.edgeutils.files;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test for FileAccess.
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
public class FileAccessTest {
	
	/** File name default property file: */
	private static final String FILENAME = String.format("%s.txt", FileAccessTest.class.getSimpleName().toLowerCase());
	
	/**
	 * Delete files.
	 * @throws Exception 
	 */
	@SuppressWarnings("static-method")
	@Before
	@After
	public void deleteFiles() {
		try {
			Files.deleteIfExists(Paths.get(FILENAME));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	/**
	 * Rule for expected exception
	 */
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	/**
	 * Tests read file not found.
	 */
	@Test
	public void testErrorReadFileNotFound() throws Exception {

		exception.expect(FileNotFoundException.class);
		exception.expectMessage(String.format("%s (No such file or directory)", FILENAME));
		FileAccess.readFile(FILENAME);
		
	}
	
	/**
	 * Tests read file exists but is dir.
	 */
	@Test
	public void testErrorReadFileIsDir() throws Exception {

		Files.createDirectory(Paths.get(FILENAME));
		
		exception.expect(FileNotFoundException.class);
		exception.expectMessage(String.format("%s (Is a directory)", FILENAME));
		FileAccess.readFile(FILENAME);
		
	}
	
	/**
	 * Tests write file exists but is dir.
	 */
	@Test
	public void testErrorWriteFileIsDir() throws Exception {

		Files.createDirectory(Paths.get(FILENAME));
		
		exception.expect(FileSystemException.class);
		exception.expectMessage(String.format("%s: Is a directory", FILENAME));
		FileAccess.writeFile(FILENAME, "");
		
	}
	
	/**
	 * Tests write file exists but is write protected.
	 */
	@Test
	public void testErrorWriteFileIsProtected() throws Exception {

		Files.createFile(Paths.get(FILENAME), PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("r--r--r--")));
		
		exception.expect(AccessDeniedException.class);
		exception.expectMessage(FILENAME);
		FileAccess.writeFile(FILENAME, "");
		
	}
	
	/**
	 * Tests write params null, null.
	 */
	@Test
	public void testErrorWriteParamsNullNull() throws Exception {

		exception.expect(NullPointerException.class);
		exception.expectMessage("filename must not be null");
		FileAccess.writeFile(null, null);
		
	}
	
	/**
	 * Tests write params null, empty.
	 */
	@Test
	public void testErrorWriteParamsNullEmpty() throws Exception {

		exception.expect(NullPointerException.class);
		exception.expectMessage("filename must not be null");
		FileAccess.writeFile(null, "");
		
	}
	
	/**
	 * Tests write params empty, null.
	 */
	@Test
	public void testErrorWriteParamsEmptyNull() throws Exception {

		exception.expect(NullPointerException.class);
		exception.expectMessage("content must not be null");
		FileAccess.writeFile("", null);
		
	}
	
	/**
	 * Tests write params empty, empty.
	 */
	@Test
	public void testErrorWriteParamsEmptyEmpty() throws Exception {

		exception.expect(FileSystemException.class);
		exception.expectMessage(": Is a directory");
		FileAccess.writeFile("", "");
		
	}
	
	/**
	 * Tests write - read cycle.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testWriteRead() {
		
		try {
			
			FileAccess.writeFile(FILENAME, "Testtext\nLore ipsum.\n\t  mehr Test mit Leerzeichen  .   \t\nUnd Umlaute: äöüÄÖÜß");
			
			Assert.assertTrue(String.format("File '%s' does not exist.", Paths.get(FILENAME)), Files.exists(Paths.get(FILENAME)));
			Assert.assertTrue(String.format("File '%s' is no regular file.", Paths.get(FILENAME)), Files.isRegularFile(Paths.get(FILENAME)));
			Assert.assertFalse(String.format("File '%s' is a directory.", Paths.get(FILENAME)), Files.isDirectory(Paths.get(FILENAME)));
			Assert.assertTrue(String.format("File '%s' is not readable.", Paths.get(FILENAME)), Files.isReadable(Paths.get(FILENAME)));
			Assert.assertTrue(String.format("File '%s' is not writeable.", Paths.get(FILENAME)), Files.isWritable(Paths.get(FILENAME)));
			
			Assert.assertEquals(4, Files.readAllLines(Paths.get(FILENAME)).size());
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		
	}

}

/* EOF */
