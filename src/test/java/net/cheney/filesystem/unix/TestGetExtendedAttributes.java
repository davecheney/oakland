package net.cheney.filesystem.unix;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TestGetExtendedAttributes {

	private static File testFile;
	
	@BeforeClass public static void setup() throws IOException {
		testFile = File.createTempFile("getxattr", "tmp");
	}
	
	@AfterClass public static void destroy() {
		testFile.delete();
	}
	
	
}
