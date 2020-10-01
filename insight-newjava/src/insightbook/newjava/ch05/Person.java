package insightbook.newjava.ch05;

public class Person implements Comparable<Person> {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Name : " + name + ", Age : " + age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		if(obj instanceof Person) {
			Person p1 = (Person)obj;
			
			if(p1.getName().equals(this.getName()) && p1.getAge() ==this.getAge()) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return (name + age).hashCode();
	}

	@Override
	public int compareTo(Person person) {
		return (name + age).compareTo(person.getName() + person.getAge());
	}
}