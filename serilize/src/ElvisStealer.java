

import java.io.Serializable;


public class ElvisStealer implements Serializable {
	static Elvis impersonator;
	static Elvis payload;
	
	private Object readResolve() {
		// Save a reference to the "unresolved" Elvis instance
		impersonator = payload;
		
		// Return an object of correct type for favorites field
		return new String[] { "A Fool Such as I" };
	}
	private static final long serialVersionUID = 0;
}
