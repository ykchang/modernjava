package insightbook.newjava.ch02;

public interface Male extends Human {
	public static String SEX = "male";

	@Override
	default public String getSex() {
		return Male.SEX;
	}
}
