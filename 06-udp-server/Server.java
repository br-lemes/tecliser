import java.io.*;
import java.net.*;

class Server {
	static final int PORT = 7070; // Se não der, 6060
	public static void main(String argv[]) throws Exception {

		DatagramSocket servidorSocket = new DatagramSocket(PORT);

		byte[] dadosRecebidos = new byte[1024];
		byte[] dadosEnviados = new byte[1024];
		while(true){

			// declara o pacote a ser recebido
			DatagramPacket pacoteRecebido = new

			DatagramPacket(dadosRecebidos,dadosRecebidos.length);
			// recebe o pacote do cliente
			servidorSocket.receive(pacoteRecebido);

			// pega os dados, o endereço IP e a porta do cliente
			// para poder mandar a msg de volta
			String sentenca = new String(pacoteRecebido.getData());

			int porta = pacoteRecebido.getPort();
			InetAddress enderecoIP = pacoteRecebido.getAddress();

			// transforma em maiúsculas
			String sentencaCapturada = sentenca.toUpperCase();
			dadosEnviados = sentencaCapturada.getBytes();

			// monta o pacote com enderço IP e porta
			DatagramPacket pacoteEnviado = new
			DatagramPacket(dadosEnviados, dadosEnviados.length,
			enderecoIP, porta);

			// envia ao cliente
			servidorSocket.send(pacoteEnviado);
		}
	}
}
