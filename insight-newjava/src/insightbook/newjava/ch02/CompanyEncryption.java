package insightbook.newjava.ch02;

public interface CompanyEncryption {
	/**
	 * 파라미터 값을 표준 알고리즘으로 인코딩 한다.
	 * @param bytes
	 * @return
	 */
	public byte[] encrypt(byte[] bytes) throws Exception;
	
	/**
	 * 인코딩된 문자를 표준 알고리즘으로 이코딩 한다.
	 * @param bytes
	 * @return
	 */
	public byte[] decrypt(byte[] bytes) throws Exception;
	
	/**
	 * 파라미터 값이 암호화 알고리즘으로 인코딩 되었는지 확인한다.
	 * @param bytes
	 * @return
	 * @throws Exception
	 */
//	public boolean isEncoded(byte[] bytes) throws Exception;
}
