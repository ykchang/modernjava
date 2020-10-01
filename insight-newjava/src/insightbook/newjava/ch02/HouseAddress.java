package insightbook.newjava.ch02;

public interface HouseAddress {
	public static final String DefaultCountry = "Korea";
	
	// 우편 번호를 리턴한다.
	public String getPostCode();
	
	// 주소 정보를 리턴한다.
	public String getAddress();

	// 상세 정보를 리턴한다.
	public String getDetailAddress();
	
	// 국가 코드를 리턴한다.
	default public String getCountryCode() {
		return getDefaultCountryCode();
	};
	
	// 기본 국가 코드를 리턴한다.
	private String getDefaultCountryCode() {
		return HouseAddress.DefaultCountry; 
	}
}
