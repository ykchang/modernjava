package insightbook.newjava.cha;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {
	
	public static void main(String[] args) {
		List myList = new ArrayList();
		List<String> stringList = new ArrayList<String>();
		List<Integer> integerList = new ArrayList<Integer>();
		
		System.out.println(myList instanceof ArrayList);
		System.out.println(stringList instanceof ArrayList<?>);
		System.out.println(integerList instanceof ArrayList<?>);
	}
}