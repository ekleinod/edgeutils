package de.edgesoft.edgeutils.files;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Locale;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.edgesoft.edgeutils.EdgeUtilsException;
import de.edgesoft.edgeutils.commons.Info;
import de.edgesoft.edgeutils.commons.ObjectFactory;
import de.edgesoft.edgeutils.commons.ext.VersionExt;

/**
 * Unit test for JAXBFiles.
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
 * @version 0.7.0
 * @since 0.6.0
 */
public class JAXBFilesTest {

	/** File name. */
	private static final String FILENAME = String.format("%s.xml", JAXBFilesTest.class.getSimpleName().toLowerCase());

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
	public void testErrorUnmarshalFileNotFound() throws Exception {

		exception.expect(EdgeUtilsException.class);

		// windows and linux create different exceptions :(
		if (System.getProperty("os.name").equalsIgnoreCase("Windows") && System.getProperty("user.language").equalsIgnoreCase(Locale.GERMAN.getLanguage())) {
			exception.expectMessage(String.format("Error reading data: %s (Das System kann die angegebene Datei nicht finden)", FILENAME));
		} else {
			exception.expectMessage(String.format("Error reading data: %s (No such file or directory)", FILENAME));
		}

		JAXBFiles.unmarshal(FILENAME, Info.class);

	}

	/**
	 * Tests read file exists but is dir.
	 */
	@Test
	public void testErrorUnmarshalFileIsDir() throws Exception {

		Files.createDirectory(Paths.get(FILENAME));

		exception.expect(EdgeUtilsException.class);

		// windows and linux create different exceptions :(
		if (System.getProperty("os.name").equalsIgnoreCase("Windows") && System.getProperty("user.language").equalsIgnoreCase(Locale.GERMAN.getLanguage())) {
			exception.expectMessage(String.format("Error reading data: %s (Zugriff verweigert)", FILENAME));
		} else {
			exception.expectMessage(String.format("Error reading data: %s (Is a directory)", FILENAME));
		}

		JAXBFiles.unmarshal(FILENAME, Info.class);

	}

	/**
	 * Tests write - read cycle.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testWriteRead() {

		try {

			LocalDateTime dteCreation = LocalDateTime.now();
			LocalDateTime dteModification = dteCreation.plusHours(2);

			Info tpeTest = new Info();

			tpeTest.setCreated(dteCreation);
			tpeTest.setModified(dteModification);
			tpeTest.setAppversion(new VersionExt("1.0.1"));
			tpeTest.setDocversion(new VersionExt("1.1.0 alpha 2"));
			tpeTest.setCreator(String.format("äöü - %s", JAXBFilesTest.class.getCanonicalName()));

			JAXBFiles.marshal(new ObjectFactory().createTest(tpeTest), FILENAME, null);

			Assert.assertTrue(String.format("File '%s' does not exist.", Paths.get(FILENAME)), Files.exists(Paths.get(FILENAME)));
			Assert.assertTrue(String.format("File '%s' is no regular file.", Paths.get(FILENAME)), Files.isRegularFile(Paths.get(FILENAME)));
			Assert.assertFalse(String.format("File '%s' is a directory.", Paths.get(FILENAME)), Files.isDirectory(Paths.get(FILENAME)));
			Assert.assertTrue(String.format("File '%s' is not readable.", Paths.get(FILENAME)), Files.isReadable(Paths.get(FILENAME)));
			Assert.assertTrue(String.format("File '%s' is not writeable.", Paths.get(FILENAME)), Files.isWritable(Paths.get(FILENAME)));

			Info tpeResult = JAXBFiles.unmarshal(FILENAME, Info.class);

			Assert.assertEquals(dteCreation, tpeResult.getCreated());
			Assert.assertEquals(dteModification, tpeResult.getModified());
			Assert.assertEquals("1.0.1", tpeResult.getAppversion().toString());
			Assert.assertEquals("1.1.0 alpha 2", tpeResult.getDocversion().toString());
			Assert.assertEquals(String.format("äöü - %s", JAXBFilesTest.class.getCanonicalName()), tpeResult.getCreator());

			JAXBFiles.setEncoding(StandardCharsets.ISO_8859_1);
			JAXBFiles.marshal(new ObjectFactory().createTest(tpeTest), FILENAME, null);

			Assert.assertTrue(String.format("File '%s' does not exist.", Paths.get(FILENAME)), Files.exists(Paths.get(FILENAME)));
			Assert.assertTrue(String.format("File '%s' is no regular file.", Paths.get(FILENAME)), Files.isRegularFile(Paths.get(FILENAME)));
			Assert.assertFalse(String.format("File '%s' is a directory.", Paths.get(FILENAME)), Files.isDirectory(Paths.get(FILENAME)));
			Assert.assertTrue(String.format("File '%s' is not readable.", Paths.get(FILENAME)), Files.isReadable(Paths.get(FILENAME)));
			Assert.assertTrue(String.format("File '%s' is not writeable.", Paths.get(FILENAME)), Files.isWritable(Paths.get(FILENAME)));

			tpeResult = JAXBFiles.unmarshal(FILENAME, Info.class);

			Assert.assertEquals(dteCreation, tpeResult.getCreated());
			Assert.assertEquals(dteModification, tpeResult.getModified());
			Assert.assertEquals("1.0.1", tpeResult.getAppversion().toString());
			Assert.assertEquals("1.1.0 alpha 2", tpeResult.getDocversion().toString());
			Assert.assertEquals(String.format("äöü - %s", JAXBFilesTest.class.getCanonicalName()), tpeResult.getCreator());

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

}

/* EOF */
