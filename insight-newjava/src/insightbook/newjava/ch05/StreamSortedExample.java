package insightbook.newjava.ch05;

import java.util.ArrayList;
import java.util.List;

public class StreamSortedExample {

	public static void main(String[] args) {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("장윤기", 45));
		personList.add(new Person("장해라", 18));
		personList.add(new Person("장해윤", 14));
		personList.add(new Person("장윤기", 45));
		
		// 데이터를 정렬 한다 - 에러 발생
		personList.stream().sorted().forEach(System.out::println);
	}
}
