package insightbook.newjava.ch08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FormattingDateTime {
    public static void main(String[] args) {

    	try {
    		// 현재 날짜, 시간을 구한다.
    		LocalDateTime dateTime = LocalDateTime.now();
    				
    		// 사용자 포맷을 지정한다.
    		DateTimeFormatter formatter =
                              DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatedDate = dateTime.format(formatter);
            System.out.printf("%s%n", formatedDate);
        } 
        catch (DateTimeParseException e) {
        	e.printStackTrace();
        }
    }
}