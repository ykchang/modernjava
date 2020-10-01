package insightbook.newjava.ch06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
	public static void main(String argc[]) {
		// 객체를 생성한다.
//		ExecutorService execService = Executors.newSingleThreadExecutor();
//		ExecutorService execService = Executors.newFixedThreadPool(2);
		ExecutorService execService = Executors.newCachedThreadPool();
		// 쓰레드를 생성하고 실행시킨다.
		execService.execute(new MyTask("TODO 1"));
		execService.execute(new MyTask("TODO 2"));
		execService.execute(new MyTask("TODO 3"));
		// ExecutorService를 종료한다.
		execService.shutdown();
	}
}