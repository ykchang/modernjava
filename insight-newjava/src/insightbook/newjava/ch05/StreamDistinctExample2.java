package insightbook.newjava.ch05;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamDistinctExample2 {
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> key) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return new Predicate<T>() {
			@Override
			public boolean test(T t) {
				return seen.putIfAbsent(key.apply(t), Boolean.TRUE) == null;
			}
		};
	}
	
	public void test() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("장윤기", 45));
		personList.add(new Person("장해라", 18));
		personList.add(new Person("장해윤", 14));
		personList.add(new Person("장윤기", 45));
		
		personList.stream().filter(distinctByKey(b -> (b.getName() + b.getAge())))
			.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		new StreamDistinctExample2().test();
	}
}