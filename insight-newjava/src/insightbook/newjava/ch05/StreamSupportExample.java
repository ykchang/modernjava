package insightbook.newjava.ch05;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamSupportExample {
	public static void main(String[] args) {
		Iterable<String> iterable = Arrays.asList("3", "2", "1");

        // Spliterator를 이용한 처리
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Spliterator를 이용한 처리");
        Stream<String> stream1 = StreamSupport.stream(iterable.spliterator(), false);
        stream1.forEach(System.out::println);
        
        // Supplier를 이용한 처리
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Supplier를 이용한 처리");
        Stream<String> stream2 = StreamSupport.stream(() -> iterable.spliterator(), Spliterator.ORDERED, false);
        stream2.forEach(System.out::println);
	}
}