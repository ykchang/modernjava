package insightbook.newjava.ch05;

import java.util.ArrayList;
import java.util.List;

public class StreamDistinctExample {
	public void test() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("장윤기", 45));
		personList.add(new Person("장해라", 18));
		personList.add(new Person("장해윤", 14));
		personList.add(new Person("장윤기", 45));
		
		personList.stream().distinct().forEach(System.out::println);
	}

	public static void main(String[] args) {
		new StreamDistinctExample().test();
	}
}