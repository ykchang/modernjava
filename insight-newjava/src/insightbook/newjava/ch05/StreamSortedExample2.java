package insightbook.newjava.ch05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamSortedExample2 {

	public static void main(String[] args) {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("장윤기", 45));
		personList.add(new Person("장해라", 18));
		personList.add(new Person("장해윤", 14));
		personList.add(new Person("장윤기", 45));
		
		// 역방향으로 정렬한다 (Comparable 해야 한다.)
		personList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		// 나이순으로 정렬한다.
		personList.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		// 이름순으로 정렬한다.
		personList.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
	}
}
