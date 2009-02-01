package net.cheney.oakland.net;

import java.io.IOException;
import java.nio.ByteBuffer;

import net.cheney.oakland.channel.Channel;
import net.cheney.oakland.libc.LibC;

public class SocketChannel extends Channel {
	
	private static final LibC LIBC = LibC.getLibc();
	
	private final TCPClientSocket socket;

	SocketChannel(TCPClientSocket socket) {
		this.socket = socket;
	}

	public int read(ByteBuffer b) throws IOException {
		return socket.recv(b);
	}

	public void close() {
		socket.close();
	}

	public int write(ByteBuffer buff) throws IOException {
		return socket.send(buff);
	}

	public boolean isBlocking() {
		return socket.isBlocking();
	}

	public void setBlocking(boolean block) throws IOException {
		socket.setBlocking(block);
	}

}
