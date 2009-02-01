/**
 * 
 */
package net.cheney.oakland.libc;

public enum SocketType {

	STREAM(1);
	
	private final int value;

	private SocketType(int value) {
		this.value = value;
	}
	
	public int value() { return value; }
}