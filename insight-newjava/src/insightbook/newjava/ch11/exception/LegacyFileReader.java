package insightbook.newjava.ch11.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LegacyFileReader {
	private static final String FILENAME = "E:\\test\\filename.txt";

	public static void main(String[] args) {
		BufferedReader br = null;

		try {
			// Reader를 생성한다.
			br = new BufferedReader(new FileReader(FILENAME));

			String sCurrentLine;

			// 라인별로 읽어들이고 출력한다.
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			if (br != null) try { br.close(); } catch(IOException e) {}
		}
	}
}