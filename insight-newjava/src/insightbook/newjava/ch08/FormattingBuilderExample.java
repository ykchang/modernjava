package insightbook.newjava.ch08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class FormattingBuilderExample {
    public static void main(String[] args) {
    	// Builder를 생성한다.
    	DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
    	// Builder를 이용해서 포맷을 formatter를 생성한다.
    	DateTimeFormatter formatter = builder.appendLiteral("## 오늘 일자 : ##\n")
    	    .appendLiteral("- 연 -> ")
    	    .appendValue(ChronoField.MONTH_OF_YEAR)
    	    .appendLiteral("\n- 월 -> ")
    	    .appendValue(ChronoField.DAY_OF_MONTH)
    	    .appendLiteral("\n- 시간 -> ")
    	    .appendPattern("HH")
    	    .appendLiteral(":")
    	    .appendText(ChronoField.MINUTE_OF_HOUR)
            .toFormatter(); 
    	    	
        LocalDateTime dateTime  = LocalDateTime.now();
        // 변환한다.
        String str =  dateTime.format(formatter); 
        System.out.println(str);
	}
}
