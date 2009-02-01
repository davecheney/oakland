package net.cheney.oakland.libc;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class TestSocketFunctions {

	@Test public void testCreateSocket() throws IOException {
		int fd = LibC.getLibc().socket(AddressFamily.INET, SocketType.STREAM, ProtocolType.TCP);
		Assert.assertFalse(fd == -1);
		LibC.getLibc().close(fd);
	}
	
}
