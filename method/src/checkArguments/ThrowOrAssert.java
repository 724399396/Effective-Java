package checkArguments;

import java.math.BigInteger;

public class ThrowOrAssert {
	/**
	 * Returns a BigInteger whose values is (this mod m). This method
	 * differs from the remainder method in that it always return s
	 * non-negative BigInteger.
	 */
	public BigInteger mod (BigInteger m) {
		if (m.signum() <= 0)
			throw new ArithmeticException("Modulus <= 0: " + m);
		// Do the computation
		return null;
	}
	
	// Private helper function for a recursive sort
	@SuppressWarnings("unused")
	private static void sort(long a[], int offset, int length) {
		assert a != null;
		assert offset >= 0 && offset <= a.length;
		assert length >= 0 && length <= a.length - offset;
		// Do the computationhg
	}
}
