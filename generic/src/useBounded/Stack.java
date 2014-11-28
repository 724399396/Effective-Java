package useBounded;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class Stack<E> {
	public Stack() {}
	public void push(E e) {}
	public E pop() { return null;}
	public boolean isEmpty() { return true; }
	// Wildcard type for parameter that serves as an E producer
	public void pushAll(Iterable<? extends E> src) {
		for(E e : src)
			push(e);
	}
	//Wildcard type for parameter that serves as an E consumer
	public void popAll(Collection<? super E> dst) {
		while (!isEmpty())
			dst.add(pop());
	}
	
	//Won't compile - wildcards can require change in method body
	public static <T extends Comparable<? super T>> T max(
			List<? extends T> list) {
		Iterator<? extends T> i = list.iterator();
		T result = i.next();
		while (i.hasNext()) {
			T t = i.next();
			if (t.compareTo(result) > 0)
				result = t;
		}
		return result;
 	}
}
