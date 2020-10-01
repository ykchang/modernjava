package insightbook.newjava.ch04;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
	public static void main(String[] args) {
		UnaryOperator<Integer> operatorA = (Integer t) -> t * 2;

		System.out.println(operatorA.apply(1));
		System.out.println(operatorA.apply(2));
		System.out.println(operatorA.apply(3));
		
		// 컴파일 에러가 발생한다.
		//UnaryOperator<Integer> operatorB = (Integer t) -> t * t;
		//UnaryOperator<Integer> operatorAB = operatorA.andThen(operatorB);
	}
}