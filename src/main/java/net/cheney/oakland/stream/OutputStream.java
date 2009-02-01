package net.cheney.oakland.stream;

import java.io.IOException;

public interface OutputStream extends Flushable<OutputStream> {

	public void write(byte b) throws IOException;
	
	public int write(byte[] b) throws IOException;
	
	public int write(byte[] b, int offset, int length) throws IOException;
	
	public Writer newWriter();
}
