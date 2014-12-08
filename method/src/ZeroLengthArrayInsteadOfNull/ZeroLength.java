package ZeroLengthArrayInsteadOfNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZeroLength {
	// The right way to return an array from collection
	private final List<Cheese> cheesesInStock = null; // someMethod to get
	
	private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];
	
	/**
	 *	@return an array containing all of the cheeses in the shop. 
	 *
	 */
	public Cheese[] getCheeses() {
		return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
	}
	
	// The right way to return a copy of collection
	public List<Cheese> getCheeseList() {
		if (cheesesInStock.isEmpty())
			return Collections.emptyList();	// Always return same list
		else
			return new ArrayList<Cheese>(cheesesInStock);
	}
	
	private static class Cheese {}
}
