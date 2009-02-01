package net.cheney.oakland.net;

import java.io.IOException;

import net.cheney.oakland.io.Closeable;
import net.cheney.oakland.libc.AddressFamily;
import net.cheney.oakland.libc.FileDescriptor;
import net.cheney.oakland.libc.LibC;
import net.cheney.oakland.libc.ProtocolType;
import net.cheney.oakland.libc.SocketType;

public abstract class Socket implements Closeable {

	static final LibC LIBC = LibC.getLibc();
	
	private final FileDescriptor fd;

	Socket(FileDescriptor fd) {
		this.fd = fd;
	}
	
	final FileDescriptor fd() {
		return this.fd;
	}
	
	Socket(AddressFamily af, SocketType st, ProtocolType pt) throws IOException {
		this(LIBC.socket(af, st, pt));
	}
	
	public void close() {
		fd.close();		
	}

}
