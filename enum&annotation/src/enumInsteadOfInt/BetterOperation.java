package enumInsteadOfInt;

import java.util.HashMap;
import java.util.Map;

// Enum type with constant-specific method implementations
public enum BetterOperation {
	PLUS("+")		{ double apply(double x, double y) { return x + y; } },
	MINUS("-")	{ double apply(double x, double y) { return x - y; } },
	TIMES("*") 	{ double apply(double x, double y) { return x * y; }},
	DIVIDE("/")	{ double apply(double x, double y) { return x / y; }};
	
	private final String symbol;
	BetterOperation(String symbol) { this.symbol = symbol; }
	@Override public String toString() { return symbol; }
	
	abstract double apply(double x, double y);
	
	// Implementing a fromString method in an enum type
	private static final Map<String,BetterOperation> stringToEnum =
			new HashMap<String,BetterOperation>();
	static {	// Initialize map from constant name to enum constant
		for (BetterOperation op : values())
			stringToEnum.put(op.toString(), op);
	}
	// Returns Operation for string, or null if string is invalid
	public static BetterOperation fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
	
	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		for (BetterOperation op : BetterOperation.values())
			System.out.printf("%f %s %f = %f%n",
					x, op, y, op.apply(x, y));
		System.out.println(fromString("+").getClass());
	}
}
