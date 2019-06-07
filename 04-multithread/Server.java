import java.io.*;
import java.net.*;

class Server {
	static final int PORT = 7070; // Se não der, 6060
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(PORT);
		System.out.println("Servidor Java multithread escutando na porta: " + PORT);
		while (true) {
			Socket client = server.accept();
			new Handler(client).start();
		}
	}
}
