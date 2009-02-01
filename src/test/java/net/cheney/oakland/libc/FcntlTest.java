package net.cheney.oakland.libc;

import java.io.IOException;


import org.junit.Test;


public class FcntlTest {
	
	
	@Test public void testSetBlocking() throws IOException {
		int fd = LibC.getLibc().socket(AddressFamily.INET, SocketType.STREAM, ProtocolType.TCP);
		LibC.getLibc().setBlocking(fd, true);
		LibC.getLibc().setBlocking(fd, false);
		LibC.getLibc().close(fd);
	}

}
