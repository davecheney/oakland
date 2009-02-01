package net.cheney.oakland;

import java.io.File;
import java.io.IOException;
import java.util.List;

import net.cheney.oakland.libc.LibC;

public final class UnixFilesystem extends Filesystem {

	private static UnixFilesystem INSTANCE = new UnixFilesystem();
	private static final LibC LIBC = LibC.getLibc();
	
	private UnixFilesystem() {
		
	}

	public static UnixFilesystem create() {
		return INSTANCE;
	}

	@Override
	public Path getPath(String path) {
		// TODO Auto-generated method stubi8iutbg
		return null;
	}
	
	public static byte[] getExtendedAttributes(File file, String name) throws IOException {
		return LIBC.getExtendedAttributes(file, name);
	}
	
	public static void setExtendedAttributes(File file, String name, byte[] value) throws IOException {
		LIBC.setExtendedAttributes(file, name, value);
	}
	
	public static List<String> listExtendedAttributes(File file) throws IOException {
		return LIBC.listExtendedAttributes(file);
	}
	
}
