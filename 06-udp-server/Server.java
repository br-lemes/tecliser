import java.io.*;
import java.net.*;

class Server {
	static final int PORT = 7070; // Se não der, 6060
	public static void main(String argv[]) throws Exception {
		DatagramSocket server = new DatagramSocket(PORT);
		while(true){
			DatagramPacket pkg = new DatagramPacket(new byte[1024], 1024);
			server.receive(pkg);
			String msg = new String(pkg.getData());
			InetAddress address = pkg.getAddress();
			byte[] data = msg.toUpperCase().getBytes();
			server.send(new DatagramPacket(data, data.length, address, pkg.getPort()));
		}
	}
}
