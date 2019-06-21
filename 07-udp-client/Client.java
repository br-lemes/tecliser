import java.io.*;
import java.net.*;
import java.util.Scanner;

class Client {
	static final int PORT = 7070; // Se não der, 6060
	static final String SERVER = "localhost";
	public static void main(String[] arg) throws Exception {
		DatagramSocket client = new DatagramSocket();
		byte[] data;
		if (arg.length > 0) {
			data = arg[0].getBytes();
		} else {
			System.out.print("Digite uma mensagem: ");
			data = new Scanner(System.in).nextLine().getBytes();
		}
		client.send(new DatagramPacket(data, data.length, InetAddress.getByName(SERVER), PORT));
		DatagramPacket pkg = new DatagramPacket(new byte[1024], 1024);
		client.receive(pkg);
		String sentencaModificada = new String(pkg.getData());
		System.out.println("Datagrama UDP enviado com sucesso" +
		sentencaModificada);
		client.close();
	}
}
