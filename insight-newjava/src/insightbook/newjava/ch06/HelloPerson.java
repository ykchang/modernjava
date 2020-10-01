package insightbook.newjava.ch06;

import java.util.ArrayList;
import java.util.List;

public class HelloPerson {
	private String firstName;
	private String lastName;
	private String country;

	public HelloPerson(String firstName, String lastName, String country) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return this.getFirstName() + " " + this.getLastName() + " from " + this.getCountry();
	}
	
	public static List<HelloPerson> getSampleDate() {
		// List 객체를 생성한다.
    	List<HelloPerson> person = new ArrayList<HelloPerson>();
    	
    	// 테스트 데이터를 추가한다. 
    	person.add(new HelloPerson("윤기", "장", "대한민국")); 
    	person.add(new HelloPerson("해라", "장", "미국")); 
    	person.add(new HelloPerson("해윤", "장", "중국")); 
    	person.add(new HelloPerson("애리", "노", "일본")); 
    	person.add(new HelloPerson("크롱", "장", "남극")); 
    	
    	return person;
	}
}
