package overridequlas;

public class NonPublic {
	@Override public boolean equals(Object o) {
		throw new AssertionError();
	}
}
