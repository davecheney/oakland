package net.cheney.oakland.net;

import java.io.IOException;

import net.cheney.oakland.libc.AddressFamily;
import net.cheney.oakland.libc.ProtocolType;
import net.cheney.oakland.libc.SocketType;

abstract class IPSocket extends Socket {

	IPSocket(SocketType st, ProtocolType pt) throws IOException {
		super(AddressFamily.INET, st, pt);
	}

	IPSocket(int fd) {
		super(fd);
	}

}
