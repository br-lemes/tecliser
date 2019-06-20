import java.io.*; // classes para entrada e saída de dados
import java.net.*; // classes para socket, servidorsocket e clientesocket

public class Client {
	public static void main(String argv[]) throws Exception {
		// cria o stream do teclado
		BufferedReader cadeiaUsuario = new BufferedReader(new InputStreamReader(System.in));
		// declara socket cliente
		DatagramSocket clienteSocket = new DatagramSocket();

		// obtem endereço IP do servidor com o DNS
		InetAddress enderecoIP = InetAddress.getByName("localhost");

		byte[] enviaDados = new byte[1024];
		byte[] recebeDados = new byte[1024];

		// lê uma linha do teclado
		String sentenca = cadeiaUsuario.readLine();
		enviaDados = sentenca.getBytes();

		// cria pacote com o dado, o endereço do server e porta do servidor
		DatagramPacket enviaPacote = new DatagramPacket(enviaDados,
		enviaDados.length, enderecoIP, 9876);

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
