package net.cheney.oakland.stream;

import java.io.IOException;

public interface InputStream {

	int read() throws IOException;
	
	int read(byte[] b) throws IOException;
	
	int read(byte[] b, int offset, int length) throws IOException;
}
