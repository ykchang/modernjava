package insightbook.newjava.ch02;

public interface Female extends Human {
	public static String SEX = "female";

	@Override
	default String getSex() {
		return Female.SEX;
	}
}