package insightbook.newjava.ch11.flowapi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ConcurrentPublisher<T> implements Flow.Publisher<String> {
	private final ExecutorService executor = ForkJoinPool.commonPool(); 

	@Override
	public synchronized void subscribe(Subscriber<? super String> subscriber) {
		MySubscription subscription = new MySubscription(subscriber, executor);
		subscriber.onSubscribe(subscription);
	}
	
	class MySubscription implements Flow.Subscription {
		private ExecutorService executor;
		private Subscriber<? super String> subscriber;
		private Future<?> future;

		public MySubscription(Subscriber<? super String> subscriber, ExecutorService executor) {
			this.subscriber = subscriber;
			this.executor = executor;
		}		
		
		public Future<?> getFuture() {
			return future;
		}
		
		@Override
		public void request(long n) {
			future = executor.submit(() -> publishItems(n));
		}
		
		@Override
		public void cancel() {
			if(future != null) future.cancel(false);
			System.out.println("Canceled");
		}

		private void publishItems(long n) {
			// n번 반복해서 메시지를 전송한다.
			for (var i = 0; i < n; i++) {
	    		subscriber.onNext("Hello Subscriber!! " + n);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		ConcurrentPublisher<String> publisher = new ConcurrentPublisher<>();
		publisher.subscribe(new FirstSubscriber<>("Subscriber 1", 10));
		publisher.subscribe(new FirstSubscriber<>("Subscriber 2", 10));
		
		TimeUnit.SECONDS.sleep(10);
	}
}
