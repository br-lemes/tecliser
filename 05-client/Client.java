import java.io.*;
import java.net.*;
import java.util.Scanner;

class Client {
	static final int PORT = 7070; // Se não der, 6060
	static final String SERVER = "localhost";
	public static void main(String[] arg) throws Exception {
		Socket socket = new Socket(SERVER, PORT);
		System.out.println("Conectado em " + SERVER + ":" + PORT);
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		if (arg.length > 0) {
			out.writeBytes(arg[0] + "\n");
		} else {
			System.out.print("Digite uma mensagem: ");
			out.writeBytes(new Scanner(System.in).nextLine() + "\n");
		}
		System.out.println("Resposta: " +
			new BufferedReader(new InputStreamReader(
				socket.getInputStream())
			).readLine()
		);
		socket.close();
	}
}
