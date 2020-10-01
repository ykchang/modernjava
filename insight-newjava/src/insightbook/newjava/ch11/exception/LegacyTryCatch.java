package insightbook.newjava.ch11.exception;

public class LegacyTryCatch {
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Usage : java LegacyTryCatch number1 nubmer2");
			return;
		}
		
		// 2개의 값을 파싱해서 계산한다.
		try {
			int number1 = Integer.parseInt(args[0]);
			int number2 = Integer.parseInt(args[1]);
			int result = number1 / number2;
			System.out.println("Result : " + result);
		}
		catch(NumberFormatException e1) {
			e1.printStackTrace();
			System.out.println("Exception : " + e1.getMessage());
		}
		catch(ArithmeticException e2) {
			e2.printStackTrace();
			System.out.println("Exception : " + e2.getMessage());
		}
	}
}