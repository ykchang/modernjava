package insightbook.newjava.ch08;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ParsingDate {
    public static void main(String[] args) {
    	String year = "2019";
    	String month = "03";
    	String day = "14";
        String input = year + ' ' + month + ' ' + day;
        
        try {
        	// 포맷팅 패턴 지정
            DateTimeFormatter formatter =
                              DateTimeFormatter.ofPattern("yyyy MM dd");
            // 파싱
            LocalDate date = LocalDate.parse(input, formatter);
            System.out.printf("%s%n", date.toString());
        } 
        catch (DateTimeParseException e) {
        	e.printStackTrace();
        }
    }
}