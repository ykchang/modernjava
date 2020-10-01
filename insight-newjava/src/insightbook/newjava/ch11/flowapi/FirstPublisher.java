package insightbook.newjava.ch11.flowapi;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;

public class FirstPublisher<T> implements Flow.Publisher<String> {
	class MySubscription implements Flow.Subscription {
		private Subscriber<? super String> subscriber;

		public MySubscription(Subscriber<? super String> subscriber) {
			this.subscriber = subscriber;
		}		
		
		@Override
		public void request(long n) {
			publishItems(n);
		}
		
		@Override
		public void cancel() {
			System.out.println("Canceled");
		}

		private void publishItems(long n) {
			// n번 반복해서 메시지를 전송한다.
			for (var i = 0; i < n; i++) {
	    		subscriber.onNext("Hello Subscriber!! " + n);
			}
		}
	}
	
	@Override
	public void subscribe(Subscriber<? super String> subscriber) {
		subscriber.onSubscribe(new MySubscription(subscriber));
	}
	
	public static void main(String[] args) throws Exception {
		FirstPublisher<String> publisher = new FirstPublisher<>();
		publisher.subscribe(new FirstSubscriber<>("Subscriber 1", 10));
		publisher.subscribe(new FirstSubscriber<>("Subscriber 2", 10));
	}
}