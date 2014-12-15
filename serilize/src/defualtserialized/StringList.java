package defualtserialized;

import java.io.Serializable;

// Awful candidate for default serialized from
public class StringList implements Serializable {
	private int size = 0;
	private Entry head = null;
	
	private static class Entry implements Serializable {
		String date;
		Entry next;
		Entry previous;
	}
	
	// Remainder omitted
}
