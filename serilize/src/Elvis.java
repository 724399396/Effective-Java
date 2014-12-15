

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

// Broken singleton - has nontransient object reference field!
public class Elvis implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8870240565519414478L;
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
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(new File("elvis.out")));
		out.writeObject(new Elvis());
		InputStream in = new FileInputStream("elvis.out");
		byte[] array = new byte[8];
		int len;
		while ((len = in.read(array) )!= -1) {
			for(int i = 0; i < len ; i++)
				System.out.printf("0x%02x, ", array[i]);
			System.out.println();
		}
	}
}
