package insightbook.newjava.ch06;

import java.util.List;
import java.util.Spliterator;

public class SpliteratorExample2 {
	public static void printSize(String name, Spliterator<HelloPerson> spliterator) {
		System.out.printf("Estimated size (%s) : %s\n", name, spliterator.estimateSize());
	}
	
	public static void printSpliterator(Spliterator<HelloPerson> spliterator) {
		spliterator.forEachRemaining((person) -> System.out.printf("안녕~~ %s\n", person));
	}
	
	public static void main(String[] args) {
		// List 객체를 생성한다.
    	List<HelloPerson> personList = HelloPerson.getSampleDate();
    	
    	// Spliterator 객체를 생성한다.
    	Spliterator<HelloPerson> spliterator1 = personList.spliterator();

    	printSize("spliterator1", spliterator1);
    	Spliterator<HelloPerson> spliterator2 = spliterator1.trySplit();
    	
    	System.out.println("첫번째 split 후");
    	printSize("spliterator1", spliterator1);
    	printSize("spliterator2", spliterator2);

    	Spliterator<HelloPerson> spliterator3 = spliterator1.trySplit();

    	System.out.println("두번째 split 후");
    	printSize("spliterator1", spliterator1);
    	printSize("spliterator2", spliterator2);
    	printSize("spliterator3", spliterator3);
    	
    	System.out.println(" ");
    	System.out.println("spliterator1 출력 ~~~");
    	printSpliterator(spliterator1);
    	System.out.println("spliterator2 출력 ~~~");
    	printSpliterator(spliterator2);
    	System.out.println("spliterator3 출력 ~~~");
    	printSpliterator(spliterator3);
	}
}