package minaccess;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrivateArray {
	private static final int capacity = 16;
	private static final String[] PRIVARE_VALUE = new String[capacity];
	public static final List<String> VALUES =
			Collections.unmodifiableList(Arrays.asList(PRIVARE_VALUE));
	public static final String[] values() {
		return PRIVARE_VALUE.clone();
	}
	
}
