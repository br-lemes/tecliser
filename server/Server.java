import java.io.*;
import java.net.*;

class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(7070); // Se não ser, 6060
		while (true) {
			Socket socket = server.accept();
			System.out.println("\nConnection from: " + socket.getInetAddress().getHostAddress());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg = in.readLine();
			System.out.println("Received: " + msg);
			out.writeBytes(msg.toUpperCase() + "\n");
		}
	}
}
