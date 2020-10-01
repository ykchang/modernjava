package insightbook.newjava.ch04;

import java.util.function.Function;

public class FunctionExample {
	public static int executeFunction(String context, 
			Function<String, Integer> function) {
		return function.apply(context);
	}
	
	public static void main(String[] args) {
		FunctionExample.executeFunction("Hello! Welcome to Java World.", 
				(String context) -> context.length());
	}
}
