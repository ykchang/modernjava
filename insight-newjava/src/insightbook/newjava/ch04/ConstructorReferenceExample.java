package insightbook.newjava.ch04;

import java.util.ArrayList;
import java.util.List;

public class ConstructorReferenceExample {
	private String name;
	
	public ConstructorReferenceExample(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Laptop brand name : " + name;
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Applet");
		list.add("Samsung");
		list.add("LG");
		list.add("Lenovo");

		System.out.println("Lambda Expression ~~~~~~~~");
		// 람다 표현식
		list.stream().map((String name) -> new ConstructorReferenceExample(name))
			.forEach((ConstructorReferenceExample data) -> System.out.println(data));
		
		System.out.println("Constructor Reference ~~~~~~~~");
		// 생성자 참조로 변환
		list.stream().map(ConstructorReferenceExample::new)
			.forEach((ConstructorReferenceExample data) -> System.out.println(data));

		System.out.println("Method Reference ~~~~~~~~");
		// 생성자 참조, 메소드 차조로 변환
		list.stream().map(ConstructorReferenceExample::new)
			.forEach(System.out::println);
	}
}