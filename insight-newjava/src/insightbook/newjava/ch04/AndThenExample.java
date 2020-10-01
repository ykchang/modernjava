package insightbook.newjava.ch04;

import java.util.function.Consumer;

public class AndThenExample {

	public static void main(String[] args) {
        Consumer<String> consumer = 
        		(String text) -> System.out.println("Hello : " + text);
        Consumer<String> consumerAndThen = 
        		(String text) -> System.out.println("Text Length is " + text.length());

        Consumer<String> consumerAB = consumer.andThen(consumerAndThen);
        consumerAB.accept("Java");
        
        if(true || false) {
        	
        }
	}
}