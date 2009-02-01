package net.cheney.oakland.channel;

import java.io.IOException;
import java.nio.ByteBuffer;

import net.cheney.oakland.io.Closeable;

public interface WriteableChannel extends Closeable, BlockingChannel {

	int write(ByteBuffer b) throws IOException;
}
