package interfaceNoabstract;

import java.util.AbstractList;
import java.util.List;

public class SkeletalImplementation {
	// Concrete implementation built atop skeletal implementation
	static List<Integer> intArrayAsList(final int[] a) {
		if (a == null)
			throw new NullPointerException();
		return new AbstractList<Integer>() {
			public Integer get(int i) {
				return a[i];	// Autoboxing
			}
			
			@Override public Integer set(int i, Integer val) {
				int oldVal = a[i];
				a[i] = val;
				return oldVal;
			}
			
			public int size() {
				return a.length;
			}
		};
	}
}
