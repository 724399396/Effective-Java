package varargs;

import java.util.Arrays;

public class VariableArityMethod {
	// Simple use of varargs
	static int sum(int... args) {
		int sum = 0;
		for (int arg : args)
			sum += arg;
		return sum;
	}
	
	// The WRONG way to use varargs to pass one or more arguments!
	static int min(int... args) {
		if (args.length == 0)
			throw new IllegalArgumentException("Too few arguments");
		int min = args[0];
		for (int i = 1; i < args.length; i++)
			if (args[i] < min)
				min = args[i];
		return min;
	}
	// The right way to use varargs to pass one or more arguments
	static int min(int firstArg, int... remainingArgs) {
		int min = firstArg;
		for (int arg : remainingArgs)
			if (arg < min)
				min = arg;
		return min;
	}
	
	public static void main(String[] args) {
		System.out.println(sum(1, 2, 3));
		int[] digits = { 3, 1, 4, 1, 5, 9, 6, 5, 4 };
		System.out.println(Arrays.asList(digits));
		// The right way to print an array
		System.out.println(Arrays.toString(digits));
	}
}
