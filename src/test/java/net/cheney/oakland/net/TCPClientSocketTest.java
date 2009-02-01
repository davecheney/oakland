package net.cheney.oakland.net;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.junit.Assert;
import org.junit.Test;


public class TCPClientSocketTest {

	@Test public void connect() throws IOException {
		InetSocketAddress google = new InetSocketAddress("www.google.com", 80);
		TCPClientSocket s = TCPClientSocket.connect(google);
		Assert.assertNotNull(s);
		s.close();
	}
	
}