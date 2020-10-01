package insightbook.newjava.ch04;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

	public static void main(String[] args) {
		BinaryOperator<Integer> operatorA = (Integer a, Integer b) -> a + b;

		System.out.println(operatorA.apply(1, 2));
		System.out.println(operatorA.apply(2, 3));
		System.out.println(operatorA.apply(3, 4));
		
		// 컴파일 에러가 발생한다.
		//UnaryOperator<Integer> operatorB = (Integer t) -> t * t;
		//UnaryOperator<Integer> operatorAB = operatorA.andThen(operatorB);
	}
}
