package insightbook.newjava.ch06;

import java.util.concurrent.TimeUnit;

public class MyTask implements Runnable {
	private String id;

	// for 루프를 이용해서 메시지를 10번 출력한다.
	@Override
	public void run() {
		for (int i = 0 ; i < 5 ; i++) {
			System.out.println("Task ID : " + id + ", running ... " + i);
			
			try {
				// 1초간 대기한다.
				TimeUnit.SECONDS.sleep(1);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public MyTask(String id) {
		this.id = id;
	}
}