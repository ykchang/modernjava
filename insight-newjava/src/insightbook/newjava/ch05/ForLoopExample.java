package insightbook.newjava.ch05;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ForLoopExample {
	public static void main(String[] args) {
		Integer[] intArray = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		List<Integer> numberList = Arrays.asList(intArray);
		
		// index 이용
		for(int i = 0 ; i < numberList.size() ; i++) {
			System.out.println(numberList.get(i));
		}

		// Iterator 인터페이스 이용
		for(Iterator iter = numberList.iterator() ; iter.hasNext() ; ) {
			System.out.println((Integer)iter.next());
		}

		// for each 이용
		for(Integer intValue : numberList) {
			System.out.println(intValue);
		}

		// Stream API 이용
		numberList.forEach(System.out::println);
	}
}
