package insightbook.newjava.ch11.optional;

import java.util.Optional;

public class FlatMapExample {
	private String name;
	private Optional<String> age;

	public FlatMapExample(String name, String age) {
		this.name = name;
		this.age = Optional.ofNullable(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Optional<String> getAge() {
		return age;
	}

	public void setAge(Optional<String> age) {
		this.age = age;
	}

	public static void main(String[] args) {
		FlatMapExample example = new FlatMapExample("YK Chang", "45");
		Optional<FlatMapExample> optExample = Optional.of(example);
		
		// map 이용
		Optional<Optional<String>> age = optExample.map(entity -> entity.getAge());
		System.out.printf("map 결과 : %s\n", age.get().get());
		
		// flatMap 이용
		Optional<String> flatAge = optExample.flatMap(entity -> entity.getAge());
		System.out.printf("map 결과 : %s\n", flatAge.get());
	}
}