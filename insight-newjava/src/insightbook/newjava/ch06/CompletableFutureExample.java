package insightbook.newjava.ch06;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {

	public static void main(String[] args) {
		Runnable mainTask = () -> {
	        try {
				TimeUnit.SECONDS.sleep(2);
	        } catch (Exception e) { }

	        System.out.println("Main Task : " + Thread.currentThread().getName());
        };
        
        Runnable subTask = 
        	() -> System.out.println("Next Task : " + Thread.currentThread().getName());
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		CompletableFuture.runAsync(mainTask, executor).thenRun(subTask);
		CompletableFuture.runAsync(mainTask, executor).thenRun(subTask);
		CompletableFuture.runAsync(mainTask, executor).thenRun(subTask);
		CompletableFuture.runAsync(mainTask, executor).thenRun(subTask);
	}
}
