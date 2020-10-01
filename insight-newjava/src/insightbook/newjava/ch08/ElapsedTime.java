package insightbook.newjava.ch08;

import java.time.Duration;
import java.time.Instant;

public class ElapsedTime {
    public static void main(String[] args) {
    	// 현재 시점을 구한다.
        Instant startInstant = Instant.now();
        
        try {
        	System.out.println("Sleeping...");
        	Thread.sleep(5000);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        
        // 현재 시점을 구한다.
        Instant endInstant = Instant.now();
        
        // 두 시점의 차이를 구한다.
        Duration elapsedTime = Duration.between(startInstant, endInstant);
        System.out.println("Elapsed Time : " + elapsedTime.getSeconds());
    }
}