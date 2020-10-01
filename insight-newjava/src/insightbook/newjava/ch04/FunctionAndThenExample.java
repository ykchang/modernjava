package insightbook.newjava.ch04;

import java.util.function.Function;

public class FunctionAndThenExample {
	public static void main(String[] args) {
		Function<String, Integer> parseIntFunction = (String str) -> Integer.parseInt(str) + 1;
		Function<Integer, String> intToStrFunction = (Integer i) -> "String : " + Integer.toString(i);
		
		System.out.println(parseIntFunction.apply("1000"));
		System.out.println(intToStrFunction.apply(1000));		
		System.out.println(parseIntFunction.andThen(intToStrFunction).apply("1000"));
	}
}
