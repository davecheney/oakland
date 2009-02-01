package net.cheney.oakland.libc;

import com.sun.jna.Structure;

public class SockAddrIn extends Structure {

	public byte sin_len;
	public byte	sin_family;
	public short sin_port;
	public int sin_addr;
	public byte[] sin_zero = new byte[] { 0,0,0,0,0,0,0,0 };
	
}
