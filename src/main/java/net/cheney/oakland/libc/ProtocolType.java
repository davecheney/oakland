/**
 * 
 */
package net.cheney.oakland.libc;

public enum ProtocolType {
	
	TCP(6);
	
	private final int value;

	private ProtocolType(int value) {
		this.value = value;
	}
	
	public int value() { return value; }
}