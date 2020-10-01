package insightbook.newjava.ch04;

public class ThreadExample {

	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
    				System.out.println("Hello World");
    				try {
    					Thread.sleep(1000);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
				}
			}
		});
		
		thread.start();
	}
}