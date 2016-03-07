package effectivejava.chapter10;

import java.util.concurrent.TimeUnit;

public class Item066StopThread2 {

	private static volatile boolean stopRequested = false;

	public static synchronized boolean getRequest() {
		return stopRequested;
	}

	public static synchronized void setRequest(boolean aa) {
		stopRequested = aa;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				System.out.println(i);
				while (!getRequest()) {
					i++;
					System.out.println(i);
				}
			}
		});
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		setRequest(true);
	}

}
