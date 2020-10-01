package insightbook.newjava.ch11.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 파일을 읽어서 STDOUT으로 출력하는 예제. Java 9 이상이어야 컴파일이 된다.
 * Java 7, 8에서는 컴파일 에러 발생한다.
 */
public class Java9FileReader {
	private static final String FILENAME = "E:\\test\\filename.txt";

	public static void main(String[] args) throws Exception {
		BufferedReader br  = 
				new BufferedReader(new FileReader(FILENAME));
		
		try (br) {
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	}
}