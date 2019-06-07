import java.io.*;
import java.net.*;

public class Handler extends Thread {
	private Socket client;

	public Handler(Socket c) {
		client = c;
	}

	public void run() {
		try {
			System.out.println("\nConexão de: " + client.getInetAddress().getHostAddress());
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String msg = in.readLine();
			System.out.println("Recebido: " + msg);
			out.writeBytes(msg.toUpperCase() + "\n");
		} catch(IOException e) {
			return;
		}
	}
}
