package insightbook.newjava.ch06;

public class HelloAnonymous {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			public void run() {
				System.out.println("Hello from a thread!");
			}
		});
	}
}