package insightbook.newjava.ch11.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NewFileReader {
	private static final String FILENAME = "E:\\test\\filename.txt";

	public static void main(String[] args) {
		try (BufferedReader br = 
			new BufferedReader(new FileReader(FILENAME))) {
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