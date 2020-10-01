package insightbook.newjava.ch06;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class ThreadLocalRandomExample {
	private int high;
	private int low;
	
	public ThreadLocalRandomExample(int low, int high) {
		this.low = low;
		this.high = high;
	}
	
	// 자바 7 일때 ThreadLocalRandom 사용 방법
	public void generateRandome7() {
		System.out.println("# Java 7 방식 #");
		for(int i = 0 ; i < 100 ; i++) {
			System.out.println(
					ThreadLocalRandom.current().nextInt(low, high));
		}
	}

	// 자바 8 이상 일때 Stream을 이용한 ThreadLocalRandom 사용 방법
	public void generateRandome8() {
		System.out.println("# Java 8 방식 #");
		IntStream intStream = 
				ThreadLocalRandom.current().ints(100, low, high);
		intStream.forEach((value) -> System.out.println(value));
	}
	
	public static void main(String[] args) {
		ThreadLocalRandomExample example = 
				new ThreadLocalRandomExample(100, 1000);
		example.generateRandome7();
		example.generateRandome8();
	}
}
