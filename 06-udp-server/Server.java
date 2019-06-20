import java.io.*;
import java.net.*;

class Server {
	static final int PORT = 7070; // Se não der, 6060
	public static void main(String[] arg) throws Exception {
		DatagramSocket server = new DatagramSocket(PORT);
		System.out.println("Servidor UDP Java escutando na porta: " + PORT);
		while(true){
			DatagramPacket pkg = new DatagramPacket(new byte[1024], 1024);
			server.receive(pkg);
			String msg = new String(pkg.getData());
			System.out.println("Recebido de " + pkg.getAddress().getHostAddress() + ": " + msg);
			byte[] data = msg.toUpperCase().getBytes();
			server.send(new DatagramPacket(data, data.length, pkg.getAddress(), pkg.getPort()));
		}
	}
}
