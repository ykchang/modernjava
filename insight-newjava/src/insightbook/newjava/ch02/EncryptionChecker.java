package insightbook.newjava.ch02;

public interface EncryptionChecker {
	/**
	 * 파라미터 값이 암호화 알고리즘으로 인코딩 되었는지 확인한다.
	 * @param bytes
	 * @return
	 * @throws Exception
	 */
	public boolean isEncoded(byte[] bytes) throws Exception;
}
