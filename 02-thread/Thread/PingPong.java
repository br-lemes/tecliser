public class PingPong extends Thread {
	private String msg;
	private int delay;

	public PingPong(String m, int d) {
		msg = m;
		delay = d;
	}

	public void run() {
		try {
			for (int i = 0; i <= 10; i++) {
				System.out.println(msg);
				Thread.sleep(delay);
			}
		} catch(InterruptedException e) {
			return;
		}
	}
}
