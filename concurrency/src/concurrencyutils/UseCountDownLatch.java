package concurrencyutils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public class UseCountDownLatch {
	// Simple framework for timing concurrent execution
	public static long time(Executor executor, int concurrency,
			final Runnable action) throws InterruptedException {
		final CountDownLatch ready = new CountDownLatch(concurrency);
		final CountDownLatch start = new CountDownLatch(1);
		final CountDownLatch done = new CountDownLatch(concurrency);
		for (int i = 0; i < concurrency; i++) {
			executor.execute(new Runnable() {
				public void run() {
					ready.countDown(); 	 //Tell timer we're ready
					try {
						start.await();
						action.run();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					} finally {
						done.countDown();
					}
				}
			});
		}
		ready.await();	// Wait for all workers to be ready
		long startNanos = System.nanoTime();
		start.countDown();
		done.await();
		return System.nanoTime() - startNanos;
	}
}
