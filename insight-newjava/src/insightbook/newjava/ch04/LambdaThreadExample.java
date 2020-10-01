package insightbook.newjava.ch04;

public class LambdaThreadExample {
	public static void main(String[] args) {
		// 1. 람다 표현식 직접 전달
//		Thread thread = new Thread(() -> System.out.println("Hello World"));
		
		// 2. 람다 표현식 분리
		Runnable r = () -> System.out.println("Hello World");
		Thread thread = new Thread(r);
		
		thread.start();
	}
}