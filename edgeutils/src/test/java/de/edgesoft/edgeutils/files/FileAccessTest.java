package de.edgesoft.edgeutils.files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

/**
 * Unit test for FileAccess.
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
@SuppressWarnings("static-method")
public class FileAccessTest {

	/** File name. */
	private static final String FILENAME = String.format("%s.txt", FileAccessTest.class.getSimpleName().toLowerCase());

	/** Test text. */
	private static final String TESTTEXT = String.format("Testtext%nLore ipsum.%n\t  mehr Test mit Leerzeichen  .   \t%nUnd Umlauten: äöüÄÖÜß");

	/**
	 * Delete files.
	 * @throws Exception
	 */
	@BeforeEach
	@AfterEach
	public void deleteFiles() {
		try {
			Files.deleteIfExists(Paths.get(FILENAME));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Tests read file not found.
	 */
	@Test
	public void testErrorReadFileNotFound() {

		Throwable exception = assertThrows(NoSuchFileException.class, 
				() -> {
					FileAccess.readFile(Paths.get(FILENAME));
				});

		assertEquals(FILENAME, exception.getMessage());

	}

	/**
	 * Tests read file exists but is dir.
	 * @throws IOException 
	 */
	@Test
	@EnabledOnOs(OS.WINDOWS)
	public void testErrorReadFileIsDirWin() throws IOException {

		Files.createDirectory(Paths.get(FILENAME));

		Throwable exception = assertThrows(AccessDeniedException.class, 
				() -> {
					FileAccess.readFile(Paths.get(FILENAME));
				});

		assertEquals(FILENAME, exception.getMessage());

	}

	/**
	 * Tests read file exists but is dir.
	 * @throws IOException 
	 */
	@Test
	@DisabledOnOs(OS.WINDOWS)
	public void testErrorReadFileIsDirNotWin() throws IOException {

		Files.createDirectory(Paths.get(FILENAME));

		Throwable exception = assertThrows(UncheckedIOException.class, 
				() -> {
					FileAccess.readFile(Paths.get(FILENAME));
				});

		assertEquals(String.format("%s: Is a directory", IOException.class.getCanonicalName()), exception.getMessage());

	}

	/**
	 * Tests write file exists but is dir.
	 * @throws IOException 
	 */
	@Test
	@EnabledOnOs(OS.WINDOWS)
	public void testErrorWriteFileIsDirWin() throws IOException {

		Files.createDirectory(Paths.get(FILENAME));

		Throwable exception = assertThrows(FileSystemException.class, 
				() -> {
					FileAccess.writeFile(Paths.get(FILENAME), "");
				});

		assertEquals(FILENAME, exception.getMessage());

	}

	/**
	 * Tests write file exists but is dir.
	 * @throws IOException 
	 */
	@Test
	@DisabledOnOs(OS.WINDOWS)
	public void testErrorWriteFileIsDirNotWin() throws IOException {

		Files.createDirectory(Paths.get(FILENAME));

		Throwable exception = assertThrows(FileSystemException.class, 
				() -> {
					FileAccess.writeFile(Paths.get(FILENAME), "");
				});

		assertEquals(String.format("%s: Is a directory", FILENAME), exception.getMessage());

	}

	/**
	 * Tests write file exists but is write protected.
	 * 
	 * Windows does not support posix file permissions.
	 * @throws IOException 
	 */
	@Test
	@DisabledOnOs(OS.WINDOWS)
	public void testErrorWriteFileIsProtectedNotWin() throws IOException {

		Files.createFile(Paths.get(FILENAME), PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("r--r--r--")));

		Throwable exception = assertThrows(AccessDeniedException.class, 
				() -> {
					FileAccess.writeFile(Paths.get(FILENAME), "");
				});

		assertEquals(FILENAME, exception.getMessage());

	}

	/**
	 * Tests write params null, null.
	 */
	@Test
	public void testErrorWriteParamsNullNull() {

		Throwable exception = assertThrows(NullPointerException.class, 
				() -> {
					FileAccess.writeFile(null, (String) null);
				});

		assertEquals("filename must not be null", exception.getMessage());

	}

	/**
	 * Tests write params null, empty.
	 */
	@Test
	public void testErrorWriteParamsNullEmpty() {

		Throwable exception = assertThrows(NullPointerException.class, 
				() -> {
					FileAccess.writeFile(null, "");
				});

		assertEquals("filename must not be null", exception.getMessage());

	}

	/**
	 * Tests write params empty, null.
	 */
	@Test
	public void testErrorWriteParamsEmptyNull() {

		Throwable exception = assertThrows(NullPointerException.class, 
				() -> {
					FileAccess.writeFile(Paths.get(""), (String) null);
				});

		assertEquals("content must not be null", exception.getMessage());

	}

	/**
	 * Tests write params empty, empty.
	 */
	@Test
	@EnabledOnOs(OS.WINDOWS)
	public void testErrorWriteParamsEmptyEmptyWin() {

		Throwable exception = assertThrows(FileSystemException.class, 
				() -> {
					FileAccess.writeFile(Paths.get(""), "");
				});

		assertEquals("", exception.getMessage());

	}

	/**
	 * Tests write params empty, empty.
	 */
	@Test
	@DisabledOnOs(OS.WINDOWS)
	public void testErrorWriteParamsEmptyEmptyNotWin() {

		Throwable exception = assertThrows(FileSystemException.class, 
				() -> {
					FileAccess.writeFile(Paths.get(""), "");
				});

		assertEquals(": Is a directory", exception.getMessage());

	}

	/**
	 * Tests encoding params null.
	 */
	@Test
	public void testErrorEncodingParamsNull() {

		Throwable exception = assertThrows(NullPointerException.class, 
				() -> {
					FileAccess.setEncoding(null);
				});

		assertEquals("encoding must not be null", exception.getMessage());

	}

	/**
	 * Tests read params null.
	 */
	@Test
	public void testErrorReadParamsNull() {

		Throwable exception = assertThrows(NullPointerException.class, 
				() -> {
					FileAccess.readFile(null);
				});

		assertEquals("filename must not be null", exception.getMessage());

	}

	/**
	 * Tests read list params null.
	 */
	@Test
	public void testErrorReadListParamsNull() {

		Throwable exception = assertThrows(NullPointerException.class, 
				() -> {
					FileAccess.readFileInList(null);
				});

		assertEquals("filename must not be null", exception.getMessage());

	}

	/**
	 * Tests write - read cycle.
	 */
	@Test
	public void testWriteRead() {

		try {

			FileAccess.writeFile(Paths.get(FILENAME), TESTTEXT);

			assertTrue(Files.exists(Paths.get(FILENAME)), String.format("File '%s' does not exist.", Paths.get(FILENAME)));
			assertTrue(Files.isRegularFile(Paths.get(FILENAME)), String.format("File '%s' is no regular file.", Paths.get(FILENAME)));
			assertFalse(Files.isDirectory(Paths.get(FILENAME)), String.format("File '%s' is a directory.", Paths.get(FILENAME)));
			assertTrue(Files.isReadable(Paths.get(FILENAME)), String.format("File '%s' is not readable.", Paths.get(FILENAME)));
			assertTrue(Files.isWritable(Paths.get(FILENAME)), String.format("File '%s' is not writeable.", Paths.get(FILENAME)));

			assertEquals(4, Files.readAllLines(Paths.get(FILENAME)).size());

			StringBuilder sbTest = FileAccess.readFile(Paths.get(FILENAME));

			assertNotNull(sbTest);

			StringBuilder sbExpected = new StringBuilder(TESTTEXT);
			sbExpected.append(System.lineSeparator());
			assertEquals(sbExpected.toString(), sbTest.toString());

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

}

/* EOF */
