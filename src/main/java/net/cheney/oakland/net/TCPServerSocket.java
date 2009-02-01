package net.cheney.oakland.net;

import java.io.IOException;
import java.net.InetSocketAddress;

public final class TCPServerSocket extends TCPSocket {

	TCPServerSocket() throws IOException {
		super();
	}

	public static TCPServerSocket listen(InetSocketAddress addr) throws IOException {
		TCPServerSocket socket = new TCPServerSocket();
		socket.socketBind(addr);
		socket.socketListen(16);
		return socket;
	}
}
