package composition.inheritance;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

// Reusable forwarding class
public class ForwardingSet<E> implements Set<E> {
	private final Set<E> s;
	public ForwardingSet(Set<E> s) { this.s = s; }
	
	public void clear()				  { s.clear(); }
	public boolean contains(Object o) { return s.contains(o); }	
	public boolean add(E e) {
		return s.add(e);
	}
	public boolean addAll(Collection<? extends E> c) {
		return s.addAll(c);
	}
	public boolean containsAll(Collection<?> c) {
		return s.containsAll(c);
	}
	public boolean isEmpty() {
		return s.isEmpty();
	}
	public Iterator<E> iterator() {
		return s.iterator();
	}
	public boolean remove(Object arg0) {
		return s.remove(arg0);
	}
	public boolean removeAll(Collection<?> arg0) {
		return s.removeAll(arg0);
	}
	public boolean retainAll(Collection<?> arg0) {
		return s.retainAll(arg0);
	}
	public int size() {
		return s.size();
	}
	public Object[] toArray() {
		return s.toArray();
	}
	public <T> T[] toArray(T[] arg0) {
		return s.toArray(arg0);
	}
}
