package insightbook.newjava.ch08;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * TemporalQueries 크래스를 이용한 날짜와 시간 정밀도 조회 예제
 */
public class TemporalQueriesExample {

	public static void main(String[] args) {
		// 날짜와 시간 클래스의 가장 정밀한 단위를 조회
		TemporalQuery<TemporalUnit> chronoUnitQuery = TemporalQueries.precision();
		System.out.printf("LocalDate 정밀도 : %s%n", LocalDate.now().query(chronoUnitQuery));
		System.out.printf("LocalDateTime 정밀도 : %s%n", LocalDateTime.now().query(chronoUnitQuery));
		System.out.printf("YearMonth 정밀도 : %s%n", YearMonth.now().query(chronoUnitQuery));
		System.out.printf("Instant 정밀도 : %s%n", Instant.now().query(chronoUnitQuery));
		
		// Zone ID 조회
		TemporalQuery<ZoneId> zoneIdQuery = TemporalQueries.zoneId();
		System.out.printf("ZonedDateTime의 Zond Id : %s%n", 
				ZonedDateTime.now().query(zoneIdQuery));
		
		// ZonedDateTime에서 현재 LocalTime 값 구하기
		TemporalQuery<LocalTime> localQuery = TemporalQueries.localTime();
		System.out.printf("ZonedDateTime의 시간 : %s%n", 
				ZonedDateTime.now(ZoneId.of("America/Los_Angeles")).query(localQuery));
	}
}