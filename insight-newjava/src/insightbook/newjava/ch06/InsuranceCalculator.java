package insightbook.newjava.ch06;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class InsuranceCalculator {
	public int calculatePrice(Map condition) {
		// 기본 가격
		int price = 10000;
		
		// 보험료 계산하는 로직 대신 10초 대기하는 것으로 대체한다.
		try {
			TimeUnit.SECONDS.sleep(10);
		}
		catch(Exception e) {}
		
		// 임의의 가격을 리턴한다.
		return price;
	}

	public Future<Integer> calculatePriceAsync(Map condition) {
		CompletableFuture<Integer> future = new CompletableFuture<>();
		// 쓰레드를 생성하고 실행할 작업을 CompletableFuture에 등록한다.
		new Thread( () -> {
			int price = calculatePrice(condition);
			future.complete(price);
		}).start();
		return future;
	}


	public static void main(String[] args) {
		InsuranceCalculator cal = new InsuranceCalculator();
		
		// 동기 방식 처리
		System.out.println("동기 방식 호출");
		
		for(int i = 0 ; i < 5 ; i++) {
			System.out.printf("계산 결과 : %s\n", cal.calculatePrice(null));
		}
		
		// 비동기 방식 처리 1
		System.out.println("비동기 방식 호출 1");

		List<Future<Integer>> futureList = new ArrayList<>();
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		for(int i = 0 ; i < 5 ; i++) {
			Future<Integer> future = service.submit(() -> {
				return new InsuranceCalculator().calculatePrice(null);
			});
			futureList.add(future);
		}

		futureList.forEach((future) -> {
			try {
				System.out.printf("계산 결과 : %s\n", future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
		
		// 비동기 처리 방식 2
		System.out.println("비동기 방식 호출 2");

		futureList.clear();
		
		for(int i = 0 ; i < 5 ; i++) {
			Future<Integer> future = cal.calculatePriceAsync(null);
			futureList.add(future);
		}

		futureList.forEach((future) -> {
			try {
				System.out.printf("계산 결과 : %s\n", future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
	}
}