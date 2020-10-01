package insightbook.newjava.ch02;

public class Worker implements Male, Female {
	public static final String MALE = "male";
	public static final String FEMALE = "female";
	
	private int age;
	private String name;
	private String sex;
	
	public Worker(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	@Override
	public String getSex() {
		String returnValue = null;
		
		if(sex != null && "male".equals(sex)) {
//			returnValue = Worker.MALE;
			returnValue = Male.super.getSex();
		}
		else if(sex != null && "female".equals(sex)) {
//			returnValue = Worker.FEMALE;
			returnValue = Female.super.getSex();
		}
		else {
			returnValue = "N/A";
		}
		return returnValue;
	}
	
	@Override
	public int getAge() {
		return age;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getInformation() {
		return "Name : " + name + " is " + age + " years old";
	}
	
	public static void main(String[] args) {
		Worker worker = new Worker("David", 23, Worker.MALE);
		System.out.println(worker.getInformation() + ", " + worker.getSex());
		
//		Female.super.getSex();
	}
}
