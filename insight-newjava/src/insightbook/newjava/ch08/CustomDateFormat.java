package insightbook.newjava.ch08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class CustomDateFormat {
    public static final DateTimeFormatter KR_LOCAL_DATE;
    static {
    	KR_LOCAL_DATE = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .append(DateTimeFormatter.ISO_LOCAL_DATE)
            .toFormatter();
    }
    
    public static final DateTimeFormatter KR_LOCAL_TIME;
    static {
    	KR_LOCAL_TIME = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
    	    .appendValue(ChronoField.HOUR_OF_DAY)
    	    .appendLiteral(":")
            .appendText(ChronoField.MINUTE_OF_HOUR)
    	    .appendLiteral(":")
            .appendText(ChronoField.SECOND_OF_MINUTE)
            .toFormatter();
    }

	public static final DateTimeFormatter KR_LOCAL_DATE_TIME;
    static {
    	KR_LOCAL_DATE_TIME = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .append(KR_LOCAL_DATE)
            .appendLiteral(' ')
            .append(KR_LOCAL_TIME)
            .toFormatter();
    }
    
	public static void main(String[] args) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.printf("날짜 : %s\n", currentDateTime.format(CustomDateFormat.KR_LOCAL_DATE));
		System.out.printf("시간 : %s\n", currentDateTime.format(CustomDateFormat.KR_LOCAL_TIME));
		System.out.printf("날짜/시간 : %s\n", currentDateTime.format(CustomDateFormat.KR_LOCAL_DATE_TIME));
	}
}