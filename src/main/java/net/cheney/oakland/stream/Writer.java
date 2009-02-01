package net.cheney.oakland.stream;


public abstract class Writer implements Flushable<Writer> {

	public abstract Writer write(char c);
	
	public abstract Writer write(char[] c);
	
	public abstract Writer write(char[] c, int offset, int length);
	
}
