package net.cheney.oakland.libc;

import java.io.IOException;

import org.junit.Test;

public class TestSocketFunctions {

	@Test public void testCreateSocket() throws IOException {
		FileDescriptor fd = LibC.getLibc().socket(AddressFamily.INET, SocketType.STREAM, ProtocolType.TCP);
		fd.close();
	}
	
}
