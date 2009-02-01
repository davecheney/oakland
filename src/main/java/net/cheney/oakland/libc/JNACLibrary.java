package net.cheney.oakland.libc;

import static com.sun.jna.Native.loadLibrary;

import java.nio.Buffer;
import java.nio.ByteBuffer;

import com.sun.jna.Library;

interface JNACLibrary extends Library {
	
	static final JNACLibrary LIBC = (JNACLibrary) loadLibrary("c", JNACLibrary.class);

	int setxattr(String path, String name, byte[] value, int size, int position, int options);
	
	int listxattr(String path, byte[] nameBuffer, int size, int options);

	int getxattr(String path, String name, byte[] value, int size, int pos, int options);

	int socket(int af, int st, int pt);

	void close(int fd);

	int bind(int fd, SockAddrIn address, int len);

	short htons(short port);

	int inet_addr(String hostName);

	int listen(int fd, int backlog);

	int accept(int fd, SockAddrIn object, int len);

	int send(int fd, Buffer b, int length, int flags);

	int connect(int fd, SockAddrIn addr, int size);

	int fcntl(int fd, int cmd, int i);

	int recv(int fd, ByteBuffer b, int length, int flags);
}
