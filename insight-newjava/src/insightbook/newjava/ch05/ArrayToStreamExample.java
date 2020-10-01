package insightbook.newjava.ch05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArrayToStreamExample {
	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6,7 ,8 ,9, 10);
		
		Person[] personList 
			= { new Person("장윤기", 45), 
				new Person("장해라", 18), 
				new Person("장해윤", 14),
		        new Person("장윤기", 45) };
		Stream<Person> stream = Arrays.stream(personList);
		stream.forEach(System.out::println);
	}
}