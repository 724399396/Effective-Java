package listThanArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UseListNotArrays {
	
	// Reduction without generics, and with concurrency flaw!
	static Object reduce(List list, Function f, Object initVal) {
		synchronized(list) {
			Object result = initVal;
			for (Object o : list)
					result = f.apply(result, o);
			return result;
		}
	}
	// Reduction without generics or concurrency flaw
	static Object reduce2(List list, Function f, Object initVal) {
		Object[] snapshot = list.toArray(); // Locks list internally
		Object result = initVal;
		for (Object e : snapshot)
			result = f.apply(result, e);
		return result;
	}
	
	/*
	//Naive generic version of reduction - won't compile!
	static <E> E reduce(List<E> list, Function<E> f, E initVal) {
		E[] snapshot = list.toArray(); // Locks list
		E result = initVal;
		for (E e : snapshot)
			result = f.apply(result,e);
		return result;
	}
	*/
	
	// List-based generic reduction
	static <E> E bestReduce(List<E> list, Function<E> f, E initVal) {
		List<E> snapshot;
		synchronized(list) {
			snapshot = new ArrayList<E>(list);
		}
		E result = initVal;
		for (E e : snapshot)
			result = f.apply(result, e);
		return result;
	}
	
	interface Function<T> {
		T apply(T arg1, T arg2);
	}
	
	public static void main(String[] args) {
		// Fails at runtime!
		Object[] objectArray = new Long[1];
		objectArray[0] = "I don't fit in";
		
		/*
		// Won't compile
		List<Object> ol = new ArrayList<String>(); // Incompatible types
		ol.add("I don't fit in");
		*/
		
		/*
		// Why generic array creation is illegal - won't compile!
		List<String>[] stringLists = new List<String>[1];
		List<Integer> intList = Arrays.asList(42);
		Object[] objects = stringLists;
		objects[0] = intList;
		*/
		
	}
	
}
