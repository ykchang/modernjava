package insightbook.newjava.ch08;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FlightTimeSimulator {
    public static void main(String[] args) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");

        // 서울발 로스앤젤레스 국제 공항(LAX)행 출발
        LocalDateTime leaving = LocalDateTime.of(2018, Month.MAY, 9, 17, 20);
        ZoneId leavingZone = ZoneId.of("Asia/Seoul");
        ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);

        try {
            String out1 = departure.format(format);
            System.out.printf("출발 : %s (%s)%n", out1, leavingZone);
        } 
        catch (DateTimeException e) {
            throw e;
        }

        // 12시간 후 LAX 도착
        ZoneId arrivingZone = ZoneId.of("America/Los_Angeles");
        // 현지 기준 도착 시간 계산
        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone).plusMinutes(720);

        try {
            String out2 = arrival.format(format);
            System.out.printf("도착 : %s (%s)%n", out2, arrivingZone);
        } 
        catch (DateTimeException e) {
            throw e;
        }

        // 써머타임 사용 여부 확인
        if (arrivingZone.getRules().isDaylightSavings(arrival.toInstant())) {
            System.out.printf("  (%s 서머타임 시간 적용.)%n", arrivingZone);
        }
        else {
            System.out.printf("  (%s 표준 시간 적용.)%n", arrivingZone);
        }
    }
}