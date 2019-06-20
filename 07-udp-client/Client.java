import java.io.*;
import java.net.*;
import java.util.Scanner;

class Client {
	static final int PORT = 7070; // Se não der, 6060
	static final String SERVER = "localhost";
	public static void main(String[] arg) throws Exception {
		// declara socket cliente
		DatagramSocket clienteSocket = new DatagramSocket();

		// obtem endereço IP do servidor com o DNS
		InetAddress enderecoIP = InetAddress.getByName(SERVER);

		byte[] enviaDados = new byte[1024];
		byte[] recebeDados = new byte[1024];

		// lê uma linha do teclado
		String sentenca = new Scanner(System.in).nextLine();
		enviaDados = sentenca.getBytes();

		// cria pacote com o dado, o endereço do server e porta do servidor
		DatagramPacket enviaPacote = new DatagramPacket(enviaDados,
		enviaDados.length, enderecoIP, PORT);

		//envia o pacote
		clienteSocket.send(enviaPacote);

		// declara o pacote a ser recebido
		DatagramPacket recebePacote = new DatagramPacket(recebeDados,
		recebeDados.length);

		// recebe pacote do servidor
		clienteSocket.receive(recebePacote);

		// separa somente o dado recebido
		String sentencaModificada = new String(recebePacote.getData());
		// mostra no vídeo
		System.out.println("Datagrama UDP enviado com sucesso" +
		sentencaModificada);

		// fecha o cliente
		clienteSocket.close();

	}
}
