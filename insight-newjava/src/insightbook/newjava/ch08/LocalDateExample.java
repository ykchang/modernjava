package insightbook.newjava.ch08;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class LocalDateExample {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);
        
        LocalDate nextBDay = birthday.withYear(today.getYear());

        // 생일이 오늘이거나 지났으면 연도를 1 추가한다.
        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }

        Period p = Period.between(today, nextBDay);
        long p2 = ChronoUnit.DAYS.between(today, nextBDay);
        System.out.println("There are " + p.getMonths() + " months, and " +
                           p.getDays() + " days until your next birthday. (" +
                           p2 + " total)");
    }
}
