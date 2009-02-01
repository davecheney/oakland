package net.cheney.oakland.stream;

import java.io.IOException;

public interface Flushable<T extends Flushable<T>> {

	T flush() throws IOException;
}
