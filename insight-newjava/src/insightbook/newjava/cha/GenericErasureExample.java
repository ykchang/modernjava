package insightbook.newjava.cha;

import java.util.ArrayList;
import java.util.List;

public class GenericErasureExample {
	
	public static void main(String[] args) {
		List<String> myList = new ArrayList<String>();
		myList.add("Hello");
		myList.add("World");
		
		String hello = myList.get(0);
		String world = myList.get(1);
		
		System.out.println(hello + " " + world);
	}
}