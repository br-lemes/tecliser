import java.io.*;
import java.net.*;
import java.util.Scanner;

class Client {
	static final int PORT = 7070; // Se não der, 6060
	static final String SERVER = "localhost";
	public static void main(String[] arg) throws Exception {
		// declara socket cliente
		DatagramSocket client = new DatagramSocket();

		// obtem endereço IP do servidor com o DNS
		InetAddress enderecoIP = InetAddress.getByName(SERVER);

		byte[] recebeDados = new byte[1024];

		// lê uma linha do teclado
		byte[] data = new Scanner(System.in).nextLine().getBytes();

		// cria pacote com o dado, o endereço do server e porta do servidor
		DatagramPacket enviaPacote = new DatagramPacket(data,
		data.length, enderecoIP, PORT);

		//envia o pacote
		client.send(enviaPacote);

		// declara o pacote a ser recebido
		DatagramPacket recebePacote = new DatagramPacket(recebeDados,
		recebeDados.length);

		// recebe pacote do servidor
		client.receive(recebePacote);

		// separa somente o dado recebido
		String sentencaModificada = new String(recebePacote.getData());
		// mostra no vídeo
		System.out.println("Datagrama UDP enviado com sucesso" +
		sentencaModificada);

		// fecha o cliente
		client.close();

	}
}
