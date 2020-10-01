package insightbook.newjava.ch06;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InsideParallelStream {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// 스트림 내부의 쓰레드 값을 구함.
		intList.parallelStream().forEach(value -> {
			// 현재 쓰레드 이름을 구함.
			String threadName = Thread.currentThread().getName();
			
			LocalDateTime currentTime = LocalDateTime.now();
			System.out.printf(currentTime.format(formatter) + " -> Thread Name : %s, Stream Value : %s\n", threadName, value);
			
			// 시간 확인을 위해 2초간 sleep 함
			try {
				TimeUnit.SECONDS.sleep(2);
			} 
			catch (InterruptedException e) {}
		});
	}
}