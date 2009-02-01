package net.cheney.filesystem.unix;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import net.cheney.oakland.UnixFilesystem;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestListExtendedAttrbitutes {

	private static File testFile;
	
	@BeforeClass public static void setup() throws IOException {
		testFile = File.createTempFile("getxattr", "tmp");
	}
	
	@AfterClass public static void destroy() {
		testFile.delete();
	}
	
	@Test public void testSetAndListOneAttribute() throws IOException {
		byte[] value = "value1".getBytes();
		UnixFilesystem.setExtendedAttributes(testFile, "user.key1", value);
		Assert.assertEquals(Arrays.asList("user.key1"), UnixFilesystem.listExtendedAttributes(testFile));
	}

}
