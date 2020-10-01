package insightbook.newjava.ch06;

import java.util.Iterator;
import java.util.List;

public class IteratorExample {
	public static void main(String[] args) {
		// List 객체를 생성한다.
    	List<HelloPerson> personList = HelloPerson.getSampleDate();

    	// Iterator로 데이터를 처리한다. 
    	Iterator<HelloPerson> peopleIterator = personList.iterator();
    	
    	while(peopleIterator.hasNext()) { 
    		HelloPerson person = peopleIterator.next(); 
    		System.out.printf("안녕~~ %s\n", person); 
    	}
	}
}