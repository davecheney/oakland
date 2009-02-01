/**
 * 
 */
package net.cheney.oakland.libc;

public enum AddressFamily {
	
	INET(2);
	
	private final byte value;

	private AddressFamily(int value) {
		this.value = (byte) value;
	}
	
	public byte value() { return value; }
}