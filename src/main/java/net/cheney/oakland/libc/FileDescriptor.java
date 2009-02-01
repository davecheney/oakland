package net.cheney.oakland.libc;

import net.cheney.oakland.io.Closeable;

public class FileDescriptor implements Closeable {

	private static final LibC LIBC = LibC.getLibc();
	
	final int value;
	
	private volatile boolean closed = false;

	FileDescriptor(int value) {
		this.value = value;
	}
	
	public void close() {
		LIBC.close(value);
		closed = true;
	}

	@Override
	protected final void finalize() {
		if(!closed) {
			System.out.println(String.format("FD %d not closed before GC", value));
			close();
		}
	}
}
