package insightbook.newjava.ch05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import insightbook.newjava.ch03.TravelInfoDAO;
import insightbook.newjava.ch03.TravelInfo;

public class StreamFilterExample {
	public static void main(String[] args) {
		List<TravelInfo> travelList = TravelInfoDAO.createTravelList();
		Stream<TravelInfo> travelStream = travelList.stream();

		// 익명 클래스 이용
//		travelStream.filter(new Predicate<TravelInfoVO>() {
//			@Override
//			public boolean test(TravelInfoVO t) {
//				return TravelInfoDAO.COUNTRY_PHILLIPHINE.equals(t.getCountry());
//			}
//		})
//		.forEach(System.out::println);

		// 람다 표현식 이용
		travelStream.filter((TravelInfo t) -> TravelInfoDAO.COUNTRY_PHILLIPHINE.equals(t.getCountry()))
		.forEach(System.out::println);
	}
}