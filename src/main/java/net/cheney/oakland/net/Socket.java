package net.cheney.oakland.net;

import java.io.IOException;

import net.cheney.oakland.io.Closeable;
import net.cheney.oakland.libc.AddressFamily;
import net.cheney.oakland.libc.LibC;
import net.cheney.oakland.libc.ProtocolType;
import net.cheney.oakland.libc.SocketType;

public abstract class Socket implements Closeable {

	static final LibC LIBC = LibC.getLibc();
	
	private volatile boolean closed = false;
	
	private final int fd;

	Socket(int fd) {
		this.fd = fd;
	}
	
	final int fd() {
		return this.fd;
	}
	
	Socket(AddressFamily af, SocketType st, ProtocolType pt) throws IOException {
		this(LIBC.socket(af, st, pt));
	}
	
	public final void close() {
		LIBC.close(fd);
		closed = true;
	}
	
	@Override
	protected final void finalize() {
		if(!closed) {
			System.out.println("Socket not closed before GC");
			close();
		}
	}
}
