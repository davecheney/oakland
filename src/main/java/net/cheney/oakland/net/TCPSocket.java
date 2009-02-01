package net.cheney.oakland.net;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.cheney.oakland.libc.ProtocolType;
import net.cheney.oakland.libc.SocketType;

public abstract class TCPSocket extends IPSocket {

	private volatile boolean blocking = true;
	
	TCPSocket() throws IOException {
		super(SocketType.STREAM, ProtocolType.TCP);
	}
	
	TCPSocket(int fd) {
		super(fd);
	}

	void socketBind(InetSocketAddress address) throws IOException{
		LIBC.bind(fd(), address);
	}
	
	void socketListen(int backlog) throws IOException {
		LIBC.listen(fd(), backlog);
	}
	
	int socketAccept() throws IOException {
		return LIBC.accept(fd());
	}
	

	void socketConnect(InetSocketAddress addr) throws IOException {
		LIBC.connect(fd(), addr);
	}
	
	public boolean isBlocking() {
		return blocking;
	}
	
	public void setBlocking(boolean blocking) throws IOException {
		LIBC.setBlocking(fd(), blocking);
		this.blocking = blocking;
	}
	
}
