package learnLibarary;

import java.util.Random;

public class RandomInteger {
	private static final Random rnd = new Random();
	
	// Common but deeply flawed!
	static int random(int n) {
		return Math.abs(rnd.nextInt()) % n;
	}
	
	public static void main(String[] args) {
		int n = 2 * (Integer.MAX_VALUE / 3);
		int low = 0;
		for (int i = 0; i < 1000000; i++)
			if (random(n) < n/2)
				low++;
		
		System.out.println(low  );
	}
}
