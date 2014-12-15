package readresolve;

import java.io.Serializable;
import java.util.Arrays;

// Broken singleton - has nontransient object reference field!
public class Elvis implements Serializable {
	public static final Elvis INSTANCE = new Elvis();
	private Elvis() {}
	
	private String[] favoriteSongs = {
			 "Hound Dog", "Heartbreak Hotel" };
	
	public void printFavorite() {
		System.out.println(Arrays.toString(favoriteSongs));
	} 
	
	// readResolve for instance control - you can do better
	private Object readResolve() {
		// Return the one true Elvis and let the garbage collector
		// tack care of the Elvis impersonator.
		return INSTANCE;
	}
}
