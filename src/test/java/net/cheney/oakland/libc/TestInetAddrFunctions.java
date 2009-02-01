package net.cheney.oakland.libc;

import org.junit.Test;


public class TestInetAddrFunctions {

	@Test public void testInetAddr() {
		String hostName = "www.google.com";
		int addr = JNACLibrary.LIBC.inet_addr(hostName);
		
	}
}
