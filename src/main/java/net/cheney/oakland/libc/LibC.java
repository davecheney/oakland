package net.cheney.oakland.libc;

import static com.sun.jna.Native.getLastError;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class LibC {

	private static final LibC INSTANCE = new LibC();
	
	private static final JNACLibrary JNA_CLIBRARY = JNACLibrary.LIBC;
	
	private LibC() {
		
	}
	
	public static final LibC getLibc() {
		return INSTANCE;
	}
	
	public final byte[] getExtendedAttributes(String path, String name) throws IOException {
		int size = JNA_CLIBRARY.getxattr(path, name, null, 0, 0, 0);
		byte[] value = new byte[size];
		size = JNA_CLIBRARY.getxattr(path, "foo", value, value.length, 0, 0);
		if(size < 0) {
			throw new IOException(String.format("Unable to retrieve extended attribute[%s], %s, %d", name, path, getLastError()));
		} else {
			return value;
		}
	}
	
	public final void setExtendedAttributes(String path, String name, byte[] value) throws IOException {
		if (0 != JNA_CLIBRARY.setxattr(path, name, value, value.length, 0, 0)) {
			throw new IOException(String.format("Unable to set extended attribute[%s], %s, %d", name, path, getLastError()));
		}
	}
	
	public final List<String> listExtendedAttributes(String path) throws IOException {
		int size = JNA_CLIBRARY.listxattr(path, null, 0, 0);
		byte[] names = new byte[size];
		size = JNA_CLIBRARY.listxattr(path, names, names.length, 0);
		if(size < 0) {
			throw new IOException(String.format("Unable to list extended %s, %d", path, getLastError()));
		} else {
			return unpackStringZArray(names);
		}
		
	}

	private final List<String> unpackStringZArray(byte[] names) {
		ArrayList<String> strings = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		for(byte b : names) {
			if(b == 0) {
				strings.add(sb.toString());
				sb = new StringBuilder();
			} else {
				sb.append((char)b);
			}
		}
		return strings;
	}

	public FileDescriptor socket(AddressFamily af, SocketType st, ProtocolType pt) throws IOException {
		int fd = JNA_CLIBRARY.socket(af.value(), st.value(), pt.value());
		if (fd == -1) {
			throw new SocketException(String.format("Unable to create socket; %s", getLastError()));
		} else {
			return new FileDescriptor(fd);
		}
	}

	public void close(int fd) {
		// TODO deal with EINTR
		JNA_CLIBRARY.close(fd);
	}

	public void bind(FileDescriptor fd, InetSocketAddress address) throws IOException {
		SockAddrIn addr = new SockAddrIn();
		addr.sin_family = AddressFamily.INET.value();
		addr.sin_port = JNA_CLIBRARY.htons((short) address.getPort());
		addr.sin_addr = JNA_CLIBRARY.inet_addr(address.getAddress().getHostAddress());
		if (0 !=JNA_CLIBRARY.bind(fd.value, addr, addr.size())) {
			throw new IOException(String.format("Unable to bind to %s: %s", address, getLastError()));
		}
	}

	public void listen(FileDescriptor fd, int backlog) throws IOException {
		if (0 !=JNA_CLIBRARY.listen(fd.value, backlog)) {
			throw new IOException(String.format("Unable to listen to %d: %s", fd, getLastError()));
		}
	}
	
	public int accept(FileDescriptor fd) throws IOException {
		int s = JNA_CLIBRARY.accept(fd.value, null, 0);
		if(s == -1) {
			throw new IOException(String.format("Unable to accept to %d: %s", fd, getLastError()));
		} else {
			return s;
		}
	}

	public void connect(FileDescriptor fd, InetSocketAddress address) throws IOException {
		SockAddrIn addr = new SockAddrIn();
		addr.sin_family = AddressFamily.INET.value();
		addr.sin_port = JNA_CLIBRARY.htons((short) address.getPort());
		addr.sin_addr = JNA_CLIBRARY.inet_addr(address.getAddress().getHostAddress());
		int res = JNA_CLIBRARY.connect(fd.value, addr, addr.size()); 
		if (0 != res ) {
			throw new IOException(String.format("Unable to connect to %s: %s", address, getLastError()));
		}
	}

	public int send(FileDescriptor fd, Buffer b) {
		return JNA_CLIBRARY.send(fd.value, b, b.remaining(), 0);
	}
	
	public void setBlocking(FileDescriptor fd, boolean block) throws IOException {
		int x = JNA_CLIBRARY.fcntl(fd.value, Fcntl.F_GETFL, 0);
		if(-1 == x) {
			throw new IOException(String.format("Unable to get socket current blocking status: %d", getLastError()));
		}

		if(block) {
			x &= ~Fcntl.O_NONBLOCK;
		} else {
			x |= Fcntl.O_NONBLOCK;
		}

		if(-1 == JNA_CLIBRARY.fcntl(fd.value, Fcntl.F_SETFL, x)) {
			throw new IOException(String.format("Unable to set blocking status: %d", getLastError()));
		}
	}

	public int recv(FileDescriptor fd, ByteBuffer b) {
		return JNA_CLIBRARY.recv(fd.value, b, b.remaining(), 0);
	}
}
