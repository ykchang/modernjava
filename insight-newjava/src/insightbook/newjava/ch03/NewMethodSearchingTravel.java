package insightbook.newjava.ch03;

import java.util.ArrayList;
import java.util.List;

public class NewMethodSearchingTravel {
	public static final String COUNTRY_VIETNAM = "vietnam";
	public static final String COUNTRY_PHILLIPHINE = "philliphine";
	public static final String COUNTRY_TAILAND = "tailand";
	
	private List<TravelInfo> travelInfoList = new ArrayList<>();
	
	public NewMethodSearchingTravel() {
		initializeProduct();
	}
	
	private void initializeProduct() {
		TravelInfo cebu = new TravelInfo();
		cebu.setName("Cebu Travel");
		cebu.setCountry(COUNTRY_PHILLIPHINE);
		cebu.setCity("cebu");
		cebu.setDays(5);
		cebu.setNights(3);
		travelInfoList.add(cebu);
		
		TravelInfo boracay = new TravelInfo();
		boracay.setName("Boracay Travel");
		boracay.setCountry(COUNTRY_PHILLIPHINE);
		boracay.setCity("boracay");
		boracay.setDays(5);
		boracay.setNights(3);
		travelInfoList.add(boracay);
		
		TravelInfo hanoi = new TravelInfo();
		hanoi.setName("Hanoi Travel");
		hanoi.setCountry(COUNTRY_VIETNAM);
		hanoi.setCity("hanoi");
		hanoi.setDays(3);
		hanoi.setNights(2);
		travelInfoList.add(hanoi);

		TravelInfo danang = new TravelInfo();
		danang.setName("Danang Travel");
		danang.setCountry(COUNTRY_VIETNAM);
		danang.setCity("danang");
		danang.setDays(6);
		danang.setNights(4);
		travelInfoList.add(danang);

		TravelInfo bankok = new TravelInfo();
		bankok.setName("Bankok Travel");
		bankok.setCountry(COUNTRY_TAILAND);
		bankok.setCity("bankok");
		bankok.setDays(5);
		bankok.setNights(3);
		travelInfoList.add(bankok);
	}
	
	/**
	 * 국가 코드로 조회한다.
	 * @param country
	 * @return
	 */
	public List<TravelInfo> searchTravelInfoByCountry(String country) {
		List<TravelInfo> returnValue = new ArrayList<>();
		
		for(TravelInfo travelInfo : travelInfoList) {
			if(country.equals(travelInfo.getCountry()) ) {
				returnValue.add(travelInfo);
			}
		}
		
		return returnValue;
	}

	/**
	 * 도시 코드로 조회한다.
	 * @param city
	 * @return
	 */
	public List<TravelInfo> searchTravelInfoByCity(String city) {
		List<TravelInfo> returnValue = new ArrayList<>();
		
		for(TravelInfo travelInfo : travelInfoList) {
			if(city.equals(travelInfo.getCity()) ) {
				returnValue.add(travelInfo);
			}
		}
		
		return returnValue;
	}

	/**
	 * 국가와 도시 코드로 조회한다.
	 * @param country
	 * @param city
	 * @return
	 */
	public List<TravelInfo> searchTravelInfoByCountryAndCity(String country, String city) {
		List<TravelInfo> returnValue = new ArrayList<>();
		
		for(TravelInfo travelInfo : travelInfoList) {
			if(country.equals(travelInfo.getCountry()) && city.equals(travelInfo.getCity())) {
				returnValue.add(travelInfo);
			}
		}
		
		return returnValue;
	}

	public static void main(String[] args) {
		NewMethodSearchingTravel travelSearch = new NewMethodSearchingTravel();
		List<TravelInfo> searchListByCountry = travelSearch.searchTravelInfoByCountry(NewMethodSearchingTravel.COUNTRY_VIETNAM); 
		
		for(TravelInfo searchTravel : searchListByCountry) {
			System.out.println(searchTravel);
		}

		List<TravelInfo> searchListByCity = travelSearch.searchTravelInfoByCity("cebu"); 
		
		for(TravelInfo searchTravel : searchListByCity) {
			System.out.println(searchTravel);
		}
	}
}