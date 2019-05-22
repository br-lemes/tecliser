public class Main {
	public static void main(String[] args) {
		new Thread(new PingPong("*** Ping ***",  33)).start();
		new Thread(new PingPong("=== Pong ===", 100)).start();
	}
}
