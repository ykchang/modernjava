package insightbook.newjava.ch11.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HouseExample {
	private List<House> housePool = new ArrayList<>();

	// 데이터를 초기화 하였다.
	private void initialize() {
		House house1 = new House();
		house1.setCountry(HouseAttributes.COUNTRY_KOREA);
		house1.setCity(HouseAttributes.CITY_SEOUL);
		house1.setAddress("강남구 신사동");
		house1.setDetailAddress("장자울길 123-1 ");
		housePool.add(house1);

		House house2 = new House();
		house2.setCountry(HouseAttributes.COUNTRY_KOREA);
		house2.setCity(HouseAttributes.CITY_SEOUL);
		house2.setAddress("강남구 대치동");
		housePool.add(house2);

		House house3 = new House();
		house3.setCountry(HouseAttributes.COUNTRY_KOREA);
		house3.setCity(HouseAttributes.CITY_SEONGNAM);
		house3.setAddress("분당구 미금로 77길");
		house3.setDetailAddress("13-25");
		housePool.add(house3);

		House house4 = new House();
		house4.setCountry(HouseAttributes.COUNTRY_KOREA);
		house4.setCity(HouseAttributes.CITY_SUWON);
		housePool.add(house4);
	}

	public HouseExample() {
		initialize();
	}

	public List<House> getApartments(String city) {
		// 도시 이름으로 필터링 한다.
		List<House> filteredList = housePool.stream()
		        .filter((house) -> house.getCity() != null && house.getCity().equals(city))
		        .collect(Collectors.toList());
		return filteredList;
	}

	public static void main(String[] args) {
		HouseExample example = new HouseExample();
		List<House> resultList = example.getApartments(HouseAttributes.CITY_SEOUL);
		resultList.forEach(System.out::println);
	}
}