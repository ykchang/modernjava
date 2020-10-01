package insightbook.newjava.ch06;

public class HelloLambda {

	public static void main(String[] args) throws Exception {
		Thread myThread = new Thread(() -> System.out.println("Hello from a thread!"));
		myThread.start();
	}
}