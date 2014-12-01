package protectedCopy;

import java.util.Date;

// Broken "immutable" time period class
public class Period {
	private final Date start;
	private final Date end;
	
	/**
	 * 
	 * @param start the beginning of the period
	 * @param end the end of the period; must not precede start
	 * @throws IllegalArgumentException if start is after end
	 * @throws NullPointerException if start or end is null
	 */
	public Period(Date start, Date end) {
		// Repaired constructor - makes defensive copies of parameters
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		
		if (this.start.compareTo(this.end) > 0)
			throw new IllegalArgumentException(start + " after "  + end);
	}
	
	// Repaired accessors - make defensive copies of internal fields
	public Date start() {
		return new Date(start.getTime());
	}
	
	public Date end() {
		return new Date(end.getTime());
	}
	
	public static void main(String[] args) {
		// Attack the internals of a Period instance
		Date start = new Date();
		Date end = new Date();
		Period p = new Period(start, end);
		end.setYear(78);  // Modifies internals of p!
		
		// Second attack on the internals of a Period instance
		p.end().setYear(78); // Modifies internals of p!
		
		
	}
}
