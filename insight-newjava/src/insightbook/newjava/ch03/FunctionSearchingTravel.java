package insightbook.newjava.ch03;

import java.util.ArrayList;
import java.util.List;

public class FunctionSearchingTravel {
	private List<TravelInfo> travelInfoList = new ArrayList<>();
	
	public FunctionSearchingTravel() {
		TravelInfo cebu = new TravelInfo();
		cebu.setName("Cebu Travel");
		cebu.setCountry("philliphine");
		cebu.setCity("cebu");
		cebu.setDays(5);
		cebu.setNights(3);
		travelInfoList.add(cebu);
		
		TravelInfo boracay = new TravelInfo();
		boracay.setName("Boracay Travel");
		boracay.setCountry("philliphine");
		boracay.setCity("boracay");
		boracay.setDays(5);
		boracay.setNights(3);
		travelInfoList.add(boracay);
		
		TravelInfo hanoi = new TravelInfo();
		hanoi.setName("Hanoi Travel");
		hanoi.setCountry("vietnam");
		hanoi.setCity("hanoi");
		hanoi.setDays(3);
		hanoi.setNights(2);
		travelInfoList.add(hanoi);

		TravelInfo danang = new TravelInfo();
		danang.setName("Danang Travel");
		danang.setCountry("vietnam");
		danang.setCity("danang");
		danang.setDays(6);
		danang.setNights(4);
		travelInfoList.add(danang);

		TravelInfo bankok = new TravelInfo();
		bankok.setName("Bankok Travel");
		bankok.setCountry("tailand");
		bankok.setCity("bankok");
		bankok.setDays(5);
		bankok.setNights(3);
		travelInfoList.add(bankok);
	}
	
	public List<TravelInfo> searchTravelInfo(TravelInfoFilter searchCondition) {
		List<TravelInfo> returnValue = new ArrayList<>();
		
		for(TravelInfo travelInfo : travelInfoList) {
			if(searchCondition.isMatched(travelInfo)) {
				returnValue.add(travelInfo);
			}
		}
		return returnValue;
	}
	
	public static boolean isVietnam(TravelInfo travelInfo) {
		if(travelInfo.getCountry().equals("vietnam")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		FunctionSearchingTravel travelSearch = new FunctionSearchingTravel();
		List<TravelInfo> searchTravel = travelSearch.searchTravelInfo(FunctionSearchingTravel::isVietnam); 
		
		for(TravelInfo travelInfo : searchTravel) {
			System.out.println(travelInfo);
		}
	}
}