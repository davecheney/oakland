package net.cheney.filesystem.unix;


import java.io.File;
import java.io.IOException;

import net.cheney.oakland.UnixFilesystem;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSetExtendedAttributes {

	private static File testFile;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testFile = File.createTempFile("getxattr", "tmp");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		testFile.delete();
	}

	@Test public void testSetExtendedAttributes() throws IOException {
		byte[] value = "bar".getBytes();
		UnixFilesystem.setExtendedAttributes(testFile, "foo", value);
		Assert.assertArrayEquals(value, UnixFilesystem.getExtendedAttributes(testFile, "foo"));
	}
	

}
