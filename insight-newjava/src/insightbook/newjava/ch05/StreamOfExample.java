package insightbook.newjava.ch05;

import java.util.stream.Stream;

public class StreamOfExample {
	public static void main(String[] args) {
		Stream<Person> stream = Stream.of(new Person("장윤기", 45), 
				new Person("장해라", 18), 
				new Person("장해윤", 14),
		        new Person("장윤기", 45));
		stream.forEach(System.out::println);
	}
}