package net.cheney.oakland.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

import junit.framework.Assert;

import net.cheney.oakland.channel.Channel;

import org.junit.Test;


public class ChannelTest {

	@Test public void testChannel() throws IOException {
		TCPClientSocket socket = TCPClientSocket.connect(new InetSocketAddress("www.google.com", 80));
		Channel channel = socket.channel();
		ByteBuffer request = ByteBuffer.wrap("GET / HTTP/1.1\r\nHost: www.google.com\r\n\r\n".getBytes());
		Assert.assertTrue(channel.write(request) == request.capacity());
		ByteBuffer response = ByteBuffer.allocate(4096);
		int read = channel.read(response);
		response.flip();
		System.out.println(new String(response.array(), 0, response.remaining()));
		channel.close();
	}
}
