package noninstance;

// Noninstantiable utility class
public class UtilityClass {
	// Suppress default constructor for noinstantiability
	private UtilityClass() {
		throw new AssertionError();
	}
}
