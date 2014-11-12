package singleton;

import java.io.Serializable;

// Singleton with public final field
/**
public class Elvis {
	public static final Elvis INSTANCE = new Elvis();
	private Elvis() {}
	
	public void leaveTheBuilding() {}
}
*/

// Singleton withe static factory
public class Elvis implements Serializable {
	private static final Elvis INSTANCE = new Elvis();
	private Elvis() {}
	public static Elvis getInstance() { return INSTANCE; }
	
	public void leaveTheBuilding() {}
	
	// readResolve method to preserve singleton property
	private Object readResolve() {
		// Return the one true Elvis and let the garbage collection
		// take care of the Elvis impersonator.
		return INSTANCE;
	}
}

// Enum singleton - the preferred approach
enum Elviss {
	INSTANCE;
	
	public void leaveTheBuilding() {}	
}
