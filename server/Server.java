import java.io.*;
import java.net.*;

class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(7070); // Se não ser, 6060
		while (true) {
			Socket socket = server.accept();
			new DataOutputStream(socket.getOutputStream()).writeBytes(
				new BufferedReader(new InputStreamReader(
					socket.getInputStream())
				).readLine().toUpperCase() + "\n"
			);
		}
	}
}
