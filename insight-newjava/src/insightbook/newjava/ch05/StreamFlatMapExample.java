package insightbook.newjava.ch05;

import java.util.Arrays;
import java.util.List;

public class StreamFlatMapExample {
	public static void main(String[] args) {
		String[][] rawData = new String[][] { 
			{ "a", "b" }, { "c", "d" }, { "e", "a" }, { "a", "h" }, { "i", "j" } 
		};

		List<String[]> rawList = Arrays.asList(rawData);

		rawList.stream()
			// a 캐릭터를 필터링 한다.
			.filter(array -> "a".equals(array[0].toString()) || "a".equals(array[1].toString()))
			// 결과를 출력한다.
			.forEach(array -> System.out.println("{" + array[0] + ", " + array[1] + "}"));
	}
}