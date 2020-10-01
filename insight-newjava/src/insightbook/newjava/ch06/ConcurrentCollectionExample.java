package insightbook.newjava.ch06;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConcurrentCollectionExample {
	private BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);

	// 항목을 생성하는 클래스로 Queue에 데이터를 추가하는 역할을 한다.
	Runnable producer = () -> {
		Random random = new Random();

		try {
			TimeUnit.SECONDS.sleep(1);

			int num = random.nextInt(100);
			queue.put(num);
			System.out.println("생성한 항목 값 : " + num + " 큐(Queue) 크기 : " + queue.size());
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	};

	// 항목을 소비하는 클래스. Queue에 쌓여 이는 항목을 처리한다.
	Runnable consumer = () -> {
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("소비한 항목 값 : " + queue.take() + " 큐(Queue) 크기 : " + queue.size());
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	};
	
	public void execute(int producersSize, int consumersSize) {
		// 생성자 쓰레드 생성
		for (int i = 0 ; i < producersSize; i++) {
			new Thread(producer, "생성자 " + (i+1)).start();
		}
		
		// 소비자 쓰레드 생성
		for (int i = 0; i < consumersSize; i++) {
			new Thread(consumer, "소비자 " + (i+1)).start();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ConcurrentCollectionExample example = new ConcurrentCollectionExample();
		example.execute(7,  9);
	}
}