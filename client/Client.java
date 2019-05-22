import java.io.*;
import java.net.*;

class Client {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 7070);
		new DataOutputStream(socket.getOutputStream()).writeBytes("hello world!\n");
		System.out.println(
			new BufferedReader(new InputStreamReader(
				socket.getInputStream())
			).readLine()
		);
		socket.close();
	}
}
