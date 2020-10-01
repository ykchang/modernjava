package insightbook.newjava.ch08;

import java.time.LocalDate;
import java.time.Period;

public class DatePeriod {
    public static void main(String[] args) {
        // 노무현 남북 정상회담
        LocalDate oldDate = LocalDate.of(2007, 10, 3);
        // 문재인 남북 정상회담
        LocalDate newDate = LocalDate.of(2018, 4, 27);
        
        System.out.println("노무현 남북정상회담 : " + oldDate);
        System.out.println("문재인 남북정상회담 : " + newDate);
        
        // 정상회담 시간차이 계산
        Period period = Period.between(oldDate, newDate);
        
        // 차이 값 출력
        System.out.printf("%s년 %s개월 %s일만에 정상회담 개최", 
        		period.getYears(), period.getMonths(), period.getDays());
    }
}