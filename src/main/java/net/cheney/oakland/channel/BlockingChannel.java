package net.cheney.oakland.channel;

import java.io.IOException;

public interface BlockingChannel {

	void setBlocking(boolean blocking) throws IOException;
	
	boolean isBlocking();
	
}
