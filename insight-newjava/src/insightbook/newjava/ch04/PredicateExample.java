package insightbook.newjava.ch04;

import java.util.function.Predicate;

public class PredicateExample {
	public static boolean isValid(String name, Predicate<String> predicate) {
		return predicate.test(name);
	}
	
	public static void main(String[] args) {
		PredicateExample.isValid("", (String name) -> !name.isEmpty());
	}
}
