package insightbook.newjava.ch11.optional;

public class House {
	// country 속성은 필수 값임.
	private String country;
	private String city;
	private String address;
	private String detailAddress;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(country);
		sb.append(" ");
		
		if (city != null && !city.equals("")) {
			sb.append(city);
			sb.append(" ");
		}

		if (address != null && !address.equals("")) {
			sb.append(address);
			sb.append(" ");
		}

		if (detailAddress != null && !detailAddress.equals("")) {
			sb.append(detailAddress);
		}
		return sb.toString();
	}
}