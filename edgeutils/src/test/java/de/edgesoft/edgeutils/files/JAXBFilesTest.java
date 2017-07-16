package de.edgesoft.edgeutils.files;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.edgesoft.edgeutils.EdgeUtilsException;
import de.edgesoft.edgeutils.commons.Info;
import de.edgesoft.edgeutils.commons.RefType;
import de.edgesoft.edgeutils.commons.ext.VersionExt;
import de.edgesoft.edgeutils.jaxb.Content;
import de.edgesoft.edgeutils.jaxb.IDElement;
import de.edgesoft.edgeutils.jaxb.ObjectFactory;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Unit test for JAXBFiles.
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
 * @version 0.10.0
 * @since 0.6.0
 */
public class JAXBFilesTest {

	/** File name. */
	private static final String FILENAME = String.format("%s.xml", JAXBFilesTest.class.getSimpleName().toLowerCase());

	/**
	 * Returns test model.
	 */
	private static de.edgesoft.edgeutils.jaxb.Test getModel() {

		ObjectFactory factory = new ObjectFactory();

		de.edgesoft.edgeutils.jaxb.Test jxbTest = factory.createTest();

		Info jxbInfo = new de.edgesoft.edgeutils.commons.ObjectFactory().createInfo();

		jxbInfo.setCreated(LocalDateTime.now());
		jxbInfo.setModified(LocalDateTime.now().plusHours(2));
		jxbInfo.setAppversion(new VersionExt("1.0.1"));
		jxbInfo.setDocversion(new VersionExt("1.1.0 alpha 2"));
		jxbInfo.setCreator(String.format("äöü - %s", JAXBFilesTest.class.getCanonicalName()));

		jxbTest.setInfo(jxbInfo);


		Content jxbContent = factory.createContent();

		jxbContent.setBoolprop(new SimpleBooleanProperty(true));
		jxbContent.setIntprop(new SimpleIntegerProperty(42));
		jxbContent.setDateprop(new SimpleObjectProperty<>(LocalDate.now()));
		jxbContent.setDatetimeprop(new SimpleObjectProperty<>(LocalDateTime.now()));
		jxbContent.setTimeprop(new SimpleObjectProperty<>(LocalTime.now()));
		jxbContent.setStringprop(new SimpleStringProperty("äöü proptest"));

		IDElement jxbIDElement = factory.createIDElement();
		jxbIDElement.setId("myid");
		jxbIDElement.setTitle("ID element myid");
		jxbContent.setIdelement(jxbIDElement);

		RefType jxbRefType = new de.edgesoft.edgeutils.commons.ObjectFactory().createRefType();
		jxbRefType.setIdref(jxbIDElement);
		jxbContent.setIdrefelement(jxbRefType);

		jxbTest.setContent(jxbContent);

		return jxbTest;

	}

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
		if (System.getProperty("os.name").startsWith("Windows") && System.getProperty("user.language").equalsIgnoreCase(Locale.GERMAN.getLanguage())) {
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
		if (System.getProperty("os.name").startsWith("Windows") && System.getProperty("user.language").equalsIgnoreCase(Locale.GERMAN.getLanguage())) {
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
	public void testWriteReadUTF8() {
		executeTestWriteRead(StandardCharsets.UTF_8);
	}

	/**
	 * Tests write - read cycle.
	 */
	@SuppressWarnings("static-method")
	@Test
	public void testWriteReadISO88951() {
		executeTestWriteRead(StandardCharsets.ISO_8859_1);
	}

	/**
	 * Executes write - read cycle.
	 */
	private static void executeTestWriteRead(final Charset theCharSet) {

		try {

			de.edgesoft.edgeutils.jaxb.Test jxbTest = getModel();

			JAXBFiles.setEncoding(theCharSet);
			JAXBFiles.marshal(new ObjectFactory().createTest(jxbTest), FILENAME, null);

			Assert.assertTrue(String.format("File '%s' does not exist.", Paths.get(FILENAME)), Files.exists(Paths.get(FILENAME)));
			Assert.assertTrue(String.format("File '%s' is no regular file.", Paths.get(FILENAME)), Files.isRegularFile(Paths.get(FILENAME)));
			Assert.assertFalse(String.format("File '%s' is a directory.", Paths.get(FILENAME)), Files.isDirectory(Paths.get(FILENAME)));
			Assert.assertTrue(String.format("File '%s' is not readable.", Paths.get(FILENAME)), Files.isReadable(Paths.get(FILENAME)));
			Assert.assertTrue(String.format("File '%s' is not writeable.", Paths.get(FILENAME)), Files.isWritable(Paths.get(FILENAME)));

			de.edgesoft.edgeutils.jaxb.Test readTest = JAXBFiles.unmarshal(FILENAME, de.edgesoft.edgeutils.jaxb.Test.class);

			Assert.assertEquals(jxbTest.getInfo().getCreated(), readTest.getInfo().getCreated());
			Assert.assertEquals(jxbTest.getInfo().getModified(), readTest.getInfo().getModified());
			Assert.assertEquals(jxbTest.getInfo().getAppversion().toString(), readTest.getInfo().getAppversion().toString());
			Assert.assertEquals(jxbTest.getInfo().getDocversion().toString(), readTest.getInfo().getDocversion().toString());
			Assert.assertEquals(jxbTest.getInfo().getCreator(), readTest.getInfo().getCreator());

			Assert.assertEquals(jxbTest.getContent().getBoolprop().get(), readTest.getContent().getBoolprop().get());
			Assert.assertEquals(jxbTest.getContent().getIntprop().get(), readTest.getContent().getIntprop().get());
			Assert.assertEquals(jxbTest.getContent().getDateprop().get(), readTest.getContent().getDateprop().get());
			Assert.assertEquals(jxbTest.getContent().getDatetimeprop().get(), readTest.getContent().getDatetimeprop().get());
			Assert.assertEquals(jxbTest.getContent().getTimeprop().get(), readTest.getContent().getTimeprop().get());
			Assert.assertEquals(jxbTest.getContent().getStringprop().get(), readTest.getContent().getStringprop().get());

			Assert.assertEquals(jxbTest.getContent().getIdelement().getId(), readTest.getContent().getIdelement().getId());
			Assert.assertEquals(jxbTest.getContent().getIdelement().getTitle(), readTest.getContent().getIdelement().getTitle());

			Assert.assertEquals(jxbTest.getContent().getIdelement().getId(), readTest.getContent().getIdrefelement().getIdref().getId());
			Assert.assertEquals(jxbTest.getContent().getIdelement().getTitle(), ((IDElement) readTest.getContent().getIdrefelement().getIdref()).getTitle());

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

}

/* EOF */
