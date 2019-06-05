import java.io.*;
import java.net.*;

class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(7070); // Se não der, 6060
		while (true) {
			Socket client = server.accept();
			System.out.println("\nConnection from: " + client.getInetAddress().getHostAddress());
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String msg = in.readLine();
			System.out.println("Received: " + msg);
			out.writeBytes(msg.toUpperCase() + "\n");
		}
	}
}
