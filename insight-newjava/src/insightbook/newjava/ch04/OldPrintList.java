package insightbook.newjava.ch04;

import java.util.ArrayList;
import java.util.List;

public class OldPrintList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		for(String entity : list) {
			System.out.println(entity);
		}
	}
}
