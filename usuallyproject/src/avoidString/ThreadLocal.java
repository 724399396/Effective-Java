package avoidString;

//Broken - inappropriate use of string as capability!
public class ThreadLocal {
	private ThreadLocal() {}	// Noninstantiable
	
	// Sets the current thread's value for the named variable.
	public static void set(String key, Object value) {}
	
	// Returns the current thread's values for the named variable
	public static Object get(String key) { return null;}
}
