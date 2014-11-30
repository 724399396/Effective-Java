package enummap;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Herb {
	public enum Type { ANNUAL, PERNNIAL, BIENNIAL }
	
	private final String name;
	private final Type type;
	
	Herb(String name, Type type) {
		this.name = name;
		this.type = type;
	}
	
	@Override public String toString() {
		return name;
	}
	
	public static void main(String[] args) {
		//Using an EnumMap to associate data with an enum
		Map<Herb.Type, Set<Herb>> herbsByType = 
				new EnumMap<Herb.Type, Set<Herb>>(Herb.Type.class);
		for (Herb.Type t : Herb.Type.values())
			herbsByType.put(t, new HashSet<Herb>());
		for (Herb h : garden)
			herbsByType.get(h.type).add(h);
		System.out.println(herbsByType);
	}
	
	private static class Garden implements Iterable<Herb> {
		@Override
		public Iterator<Herb> iterator() {
			return null;
		}		
	}
	private static Garden garden = new Garden();
}
