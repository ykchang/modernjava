package insightbook.newjava.ch08;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateAdjusters {
	public static void main(String[] args) {
        // 현재 일자를 구한다.
        LocalDate localDate = LocalDate.now();
        
        // 요일 객체를 가져온다. 
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        
        System.out.printf("%s 일의 요일은 %s 입니다.%n", localDate, dayOfWeek);
        System.out.printf("이번 달의 첫번째 일 : %s%n",
            localDate.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.printf("이번 달의 첫번째 월요일 : %s%n",
            localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
        System.out.printf("이번 달의 마지막 일 : %s%n",
            localDate.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.printf("다음달의 첫번째 일 : %s%n",
            localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.printf("내년 첫번째 일 : %s%n",
            localDate.with(TemporalAdjusters.firstDayOfNextYear()));
        System.out.printf("올해 첫번째 일 : %s%n",
            localDate.with(TemporalAdjusters.firstDayOfYear()));
    }
}