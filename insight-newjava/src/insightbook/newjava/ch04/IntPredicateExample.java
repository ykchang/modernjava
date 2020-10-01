package insightbook.newjava.ch04;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class IntPredicateExample {
	public static boolean isPositive(int i, IntPredicate intPredicate) {
		return intPredicate.test(i);
	}

	public static boolean isPositiveByInteger(int i, Predicate<Integer> intPredicate) {
		return intPredicate.test(i);
	}

	public static void main(String[] args) {
		for(int i = 0 ; i < 1_000_000 ; i++) {
			IntPredicateExample.isPositive(i, (int integerValue) -> integerValue > 0);
		}

		for(int i = 0 ; i < 1_000_000 ; i++) {
			IntPredicateExample.isPositiveByInteger(i, (Integer integerValue) -> integerValue > 0);
		}
	}
}