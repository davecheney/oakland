package net.cheney.oakland.channel;

import java.io.IOException;
import java.nio.ByteBuffer;

import net.cheney.oakland.io.Closeable;

public interface ReadableChannel extends Closeable {

	int read(ByteBuffer b) throws IOException;
	
}
