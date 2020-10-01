package insightbook.newjava.ch02;

public class KoreaHouseAddress implements HouseAddress {
	private String postCode;
	private String address;
	private String detailAddress;

	public KoreaHouseAddress(String postCode, String address, String detailAddress) {
		this.postCode = postCode;
		this.address = address;
		this.detailAddress = detailAddress;
		
		System.out.println(postCode + " " + address + " " + detailAddress);
	}

	@Override
	public String getPostCode() {
		return postCode;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public String getDetailAddress() {
		return detailAddress;
	}
	
	@Override
	public String getCountryCode() {
		System.out.println("클래스에서 호출");
		return HouseAddress.super.getCountryCode();
	}

	public static void main(String[] args) {
		HouseAddress address = new KoreaHouseAddress("06164", "서울특별시 강남구 영동대로 517", "아셈타워 12층");
		System.out.println(address.getCountryCode());
	}
}