package synchronizereaddata;

import java.util.concurrent.TimeUnit;

// Properly synchronized cooperative thread termination 正确同步协作线程终止
public class StopThread {
	private static boolean stopRequested;
	private static synchronized void requestStop() {
		stopRequested = true;
	}
	private static synchronized boolean stopRequested() {
		return stopRequested;
	}
	
	public static void main(String[] args) 
			throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				@SuppressWarnings("unused")
				int i = 0;
				while (!stopRequested())
					i++;
			}
		});
		backgroundThread.start();
		
		TimeUnit.SECONDS.sleep(1);
		requestStop();
	}
}
