package net.cheney.oakland.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.junit.Test;


public class TCPSocketTest {

	@Test public void testCreateTCPSocket() throws IOException {
		TCPSocket socket = new TCPSocket() { };
		socket.close();
	}
	
	@Test public void testCreateTCPSocketAndBind() throws IOException {
		TCPSocket socket = new TCPSocket() { };
		socket.socketBind(new InetSocketAddress(InetAddress.getLocalHost(), 0));
		socket.close();
	}
	
	@Test public void testCreateTCPSocketAndBindAndListen() throws IOException {
		TCPSocket socket = new TCPSocket() { };
		socket.socketBind(new InetSocketAddress(InetAddress.getLocalHost(), 0));
		socket.socketListen(16);
		socket.close();
	}
	
}
