package net.cheney.oakland.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

import net.cheney.oakland.channel.Channel;
import net.cheney.oakland.libc.FileDescriptor;

public final class TCPClientSocket extends TCPSocket {

	TCPClientSocket() throws IOException {
		super();
	}
	
	TCPClientSocket(FileDescriptor fd) throws IOException {
		super(fd);
	}
	
	public static TCPClientSocket connect(InetSocketAddress addr) throws IOException {
		TCPClientSocket socket = new TCPClientSocket();
		socket.socketConnect(addr);
		return socket;
	}
	
	int send(byte[] b) throws IOException {
		return LIBC.send(fd(), ByteBuffer.wrap(b));
	}
	
	int recv(ByteBuffer b) throws IOException {
		int count = LIBC.recv(fd(), b);
		if(count > -1) {
			b.position(b.position() + count);
		}
		return count;
	}
	
	int send(ByteBuffer b) throws IOException {
		int count = LIBC.send(fd(), b);
		if(count > -1) {
			b.position(b.position() + count);
		}
		return count;
	}
	
	public Channel channel() {
		return new SocketChannel(this);
	}

}
