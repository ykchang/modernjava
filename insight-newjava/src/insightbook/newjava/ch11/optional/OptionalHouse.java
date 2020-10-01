package insightbook.newjava.ch11.optional;

import java.util.Optional;

public class OptionalHouse {
	// country 속성은 필수 값임.
	private String country;
	// 나머지 속성은 옵션 값임.
	private Optional<String> city = Optional.empty();
	private Optional<String> address = Optional.empty();
	private Optional<String> detailAddress = Optional.empty();

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Optional<String> getCity() {
		return city;
	}

	public void setCity(Optional<String> city) {
		this.city = city;
	}

	public Optional<String> getAddress() {
		return address;
	}

	public void setAddress(Optional<String> address) {
		this.address = address;
	}

	public Optional<String> getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(Optional<String> detailAddress) {
		this.detailAddress = detailAddress;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(country).append(" ");

		city.ifPresent((entity) -> sb.append(entity).append(" "));
		address.ifPresent((entity) -> sb.append(entity).append(" "));
		detailAddress.ifPresent((entity) -> sb.append(entity).append(" "));

		if(city.isPresent()) {
			sb.append(city.get()).append(" ");
		}

		if(address.isPresent()) {
			sb.append(address.get()).append(" ");
		}

		if(detailAddress.isPresent()) {
			sb.append(detailAddress.get()).append(" ");
		}
		
		return sb.toString();
	}
}