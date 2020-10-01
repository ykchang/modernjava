package insightbook.newjava.ch05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamCollectExample {

	public static void main(String[] args) {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("장윤기", 45));
		personList.add(new Person("장해라", 18));
		personList.add(new Person("장해윤", 14));
		personList.add(new Person("장윤기", 45));
		
		List<Person> sortedList = personList.stream().sorted().collect(Collectors.toList());
		
		for(Person person : sortedList) {
			System.out.println(person);
		}
	}
}
