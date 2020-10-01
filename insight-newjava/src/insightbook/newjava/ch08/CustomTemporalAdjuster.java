package insightbook.newjava.ch08;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class CustomTemporalAdjuster implements TemporalAdjuster {
    public static int TRANSFER_DATE = 25;

    @Override
    public Temporal adjustInto(Temporal inputValue) {
    	// 입력된 값의 날짜 객체를 생성
        LocalDate currentDate = LocalDate.from(inputValue);
        // 입렫뇌 값의 날짜 객체를 기준으로 이체해야 할 날짜를 구함
        LocalDate transferDate = currentDate.withDayOfMonth(TRANSFER_DATE);

        // 만일 오늘 일자가 TRANSFER_DATE 보다 클 경우 다음 달에 이체를 하도록 설정.
        if (currentDate.getDayOfMonth() > TRANSFER_DATE) {
        	transferDate = transferDate.plusMonths(1);
        }

        // 이체해야 하는 일자가 토요일 혹은 일요일 일 경우 그 다음 월요일로 이체 일자 조정
        if (transferDate.getDayOfWeek() == DayOfWeek.SATURDAY || 
            transferDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
        	transferDate = transferDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        }

        // 결과 전달
        return inputValue.with(transferDate);
    }
    
    public static void main(String[] args) {
        CustomTemporalAdjuster adjuser = new CustomTemporalAdjuster();
        // 2018.07.15일 기준 이체 일자
        System.out.printf("2018.07.15 기준 이체 일자 : %s%n", 
            adjuser.adjustInto(LocalDate.of(2018, 7, 15)));
        // 2018.08.21일 기준 이체 일자
        System.out.printf("2018.08.21 기준 이체 일자 : %s%n", 
            adjuser.adjustInto(LocalDate.of(2018, 8, 21)));
        
        LocalDate currentDate = LocalDate.now();
        LocalDate transferDate = currentDate.with(new CustomTemporalAdjuster());
        
        System.out.println(currentDate);
        System.out.println(transferDate);
    }
}