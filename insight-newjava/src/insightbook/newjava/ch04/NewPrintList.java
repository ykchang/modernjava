package insightbook.newjava.ch04;

import java.util.ArrayList;
import java.util.List;

public class NewPrintList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");

		// 1. 람다 표현식
		list.stream().forEach((String entity) -> System.out.println(entity));
		
		// 2. 메소드 레퍼런스		
		list.stream().forEach(System.out::println);
	}
}
