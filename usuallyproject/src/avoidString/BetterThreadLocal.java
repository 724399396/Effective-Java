package avoidString;

public class BetterThreadLocal {
	private BetterThreadLocal() {} // Noninstantiable
	
	public static class Key {	// (Capability)
		Key() {}
	}
	
	// Generates a unique, unforgeable key
	public static Key getKey() {
		return new Key();
	}
	
	public void set(Key key, Object value) {}
	public static Object get(Key key) {return null; }
}
