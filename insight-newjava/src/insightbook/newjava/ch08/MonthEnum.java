package insightbook.newjava.ch08;

import java.time.Month;

public class MonthEnum {
	public static void main(String[] args) {
		System.out.println("Month.FEBRUARY의 값은 " + Month.FEBRUARY);
		
		Month february = Month.of(2);
		System.out.println("Month.of(2)의 값은 " + february);
		
		System.out.println("비교 " + february.equals(Month.FEBRUARY));
	}
}