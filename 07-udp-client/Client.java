import java.io.*;
import java.net.*;
import java.util.Scanner;

class Client {
	static final int PORT = 7070; // Se não der, 6060
	static final String SERVER = "localhost";
	public static void main(String[] arg) throws Exception {
		DatagramSocket client = new DatagramSocket();
		byte[] recebeDados = new byte[1024];
		byte[] data = new Scanner(System.in).nextLine().getBytes();
		DatagramPacket enviaPacote = new DatagramPacket(data, data.length, InetAddress.getByName(SERVER), PORT);
		client.send(enviaPacote);
		DatagramPacket recebePacote = new DatagramPacket(recebeDados,
		recebeDados.length);
		client.receive(recebePacote);
		String sentencaModificada = new String(recebePacote.getData());
		System.out.println("Datagrama UDP enviado com sucesso" +
		sentencaModificada);
		client.close();
	}
}
