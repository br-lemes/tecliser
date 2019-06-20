import java.io.*;
import java.net.*;

class Server {
	static final int PORT = 7070; // Se não der, 6060
	public static void main(String argv[]) throws Exception {
		DatagramSocket server = new DatagramSocket(PORT);
		while(true){
			// declara o pacote a ser recebido
			DatagramPacket pkg = new DatagramPacket(new byte[1024], 1024);
			// recebe o pacote do cliente
			server.receive(pkg);
			// pega os dados, o endereço IP e a porta do cliente
			// para poder mandar a msg de volta
			String msg = new String(pkg.getData());
			int port = pkg.getPort();
			InetAddress address = pkg.getAddress();
			byte[] data = msg.toUpperCase().getBytes();
			// monta o pacote com enderço IP e porta
			DatagramPacket pacoteEnviado = new
			DatagramPacket(data, data.length,
			address, port);
			// envia ao cliente
			server.send(pacoteEnviado);
		}
	}
}
