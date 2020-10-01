package insightbook.newjava.ch11.exception;

public class AutoCloseableImplB implements AutoCloseable {
	private AutoCloseableImplA a;
	
	public AutoCloseableImplB(AutoCloseableImplA a) {
		this.a = a;
	}
	
	@Override
	public void close() throws Exception {
		System.out.println(this.getClass().getName() + "는 종료되었습니다.");
		a.close();
	}
	
	public static void main(String[] args) {
		// 1번 실행 결과
		try (AutoCloseableImplB b = new AutoCloseableImplB(new AutoCloseableImplA())) {
			System.out.println("try with resource 테스트 종료");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		// 2번 실행 결과
		try (AutoCloseableImplA a = new AutoCloseableImplA();
				AutoCloseableImplB b = new AutoCloseableImplB(a);) {
			System.out.println("try with resource 테스트 종료");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
