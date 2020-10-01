package insightbook.newjava.ch11.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalHouseExample {
	private List<OptionalHouse> housePool = new ArrayList<>();

	// 데이터를 초기화 하였다.
	private void initialize() {
		OptionalHouse house1 = new OptionalHouse();
		house1.setCountry(HouseAttributes.COUNTRY_KOREA);
		house1.setCity(Optional.of(HouseAttributes.CITY_SEOUL));
		house1.setAddress(Optional.of("강남구 신사동"));
		house1.setDetailAddress(Optional.of("장자울길 123-1 "));
		housePool.add(house1);

		OptionalHouse house2 = new OptionalHouse();
		house2.setCountry(HouseAttributes.COUNTRY_KOREA);
		house2.setCity(Optional.of(HouseAttributes.CITY_SEOUL));
		house2.setAddress(Optional.of("강남구 대치동"));
		housePool.add(house2);

		OptionalHouse house3 = new OptionalHouse();
		house3.setCountry(HouseAttributes.COUNTRY_KOREA);
		house3.setCity(Optional.of(HouseAttributes.CITY_SEONGNAM));
		house3.setAddress(Optional.of("분당구 미금로 77길"));
		house3.setDetailAddress(Optional.of("13-25"));
		housePool.add(house3);

		OptionalHouse house4 = new OptionalHouse();
		house4.setCountry(HouseAttributes.COUNTRY_KOREA);
		house4.setCity(Optional.of(HouseAttributes.CITY_SUWON));
		housePool.add(house4);
	}

	public OptionalHouseExample() {
		initialize();
	}

	public List<OptionalHouse> getApartments(String city) {
		// 도시 이름으로 필터링 한다.
		List<OptionalHouse> filteredList = housePool.stream()
		        .filter((house) -> house.getCity().equals(Optional.of(city)))
		        .collect(Collectors.toList());
		return filteredList;
	}

	public static void main(String[] args) {
		HouseExample example = new HouseExample();
		List<House> resultList = example.getApartments(HouseAttributes.CITY_SEOUL);
		resultList.forEach(System.out::println);
	}
}