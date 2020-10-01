package insightbook.newjava.ch05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReduceDebugging {
	public static int debugArguments(int x, int y) {
		System.out.printf("x = %s, y = %s, sum = %s\n", x, y, x+y);
		return x + y;
	}

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6,7 ,8 ,9, 10);
		
		// 메소드 참조로 정의
		int sum = intList.stream()
				.reduce(0, ReduceDebugging::debugArguments);
		System.out.printf("Final sum : %s\n", sum);
		
		intList.stream().collect(Collectors.toList());
	}
}