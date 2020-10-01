package insightbook.newjava.ch05;

import java.util.stream.Stream;

public class StreamBuilderExample2 {
	public static void main(String[] args) {
		Stream.Builder<String> builder = Stream.builder();
		builder.add("1").add("2").add("3").add("4").add("5")
			.add("6").add("7").add("8").add("9").add("0")
			.build()
		    .forEach(System.out::println);
	}
}