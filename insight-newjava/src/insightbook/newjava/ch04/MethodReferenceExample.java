package insightbook.newjava.ch04;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceExample {
	public static MethodReferenceExample of() {
		return new MethodReferenceExample();
	}
	
	public static void executeMethod(String entity) {
		if(entity != null && !"".equals(entity)) {
			System.out.println("Contents : " + entity);
			System.out.println("Length : " + entity.length());
		}
	}
	
	public void toUpperCase(String entity) {
		System.out.println(entity.toUpperCase());
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");

		// 정적 메소드 참조
		list.stream().forEach(MethodReferenceExample::executeMethod);
		
		// 한정적 메소드 참조
		list.stream().forEach(MethodReferenceExample.of()::toUpperCase);

		// 비한정적 메소드 참조
		list.stream().map(String::toUpperCase).forEach(System.out::println);
	}
}
