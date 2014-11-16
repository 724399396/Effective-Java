package composition.inheritance;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

// Broken - Inappropriate use of inheritance! 不恰当地使用继承
public class BrokenInstrumentedHashSet<E> extends HashSet<E> {
	// The number of attemped element insertions
	private int addCount = 0;
	
	public BrokenInstrumentedHashSet() {
	}
	
	public BrokenInstrumentedHashSet(int initCap, float loadFactor) {
		super(initCap, loadFactor);
	}
	@Override public boolean add(E e) {
		addCount++;
		return super.add(e);
	}
	@Override public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}
	public int getAddCount() {
		return addCount;
	}
	
	public static void main(String[] args) {
		BrokenInstrumentedHashSet<String> s = 
				new BrokenInstrumentedHashSet<>();
		s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
		System.out.println(s.getAddCount());
	}
}
