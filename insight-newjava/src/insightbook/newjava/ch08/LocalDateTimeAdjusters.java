package insightbook.newjava.ch08;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.Temporal;

public class LocalDateTimeAdjusters {
	public static void main(String[] args) {
		// 1. 동일형의 변환
        LocalDateTime beforeDate = LocalDateTime.of(2018, Month.APRIL, 10, 8, 40);
        LocalDateTime afterDate = LocalDateTime.now();
        
        // afterDate를 beforeDate 값으로 변환해서 리턴한다.
        Temporal temporalDate = beforeDate.adjustInto(afterDate);
        
        System.out.printf("Before Date : %s%n", beforeDate);
        System.out.printf("After Date : %s%n", afterDate);
        System.out.printf("Temporal Date : %s%n", temporalDate);
        System.out.printf("Before Date : %s%n", beforeDate);
        System.out.printf("After Date : %s%n", afterDate);

        // 2. 다른형의 변환
        LocalDate localDate = LocalDate.of(2018, Month.APRIL, 10);
        ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/Los_Angeles"));
        Temporal tempralObject = localDate.adjustInto(zdt);
        
        if(tempralObject instanceof LocalDate) {
        	System.out.println("temporalObject is LocalDate");
        }
        
        if(tempralObject instanceof ZonedDateTime) {
        	System.out.println("temporalObject is ZonedDateTime");
        }
	}
}