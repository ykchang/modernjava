package insightbook.newjava.ch07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemporaryFile {
	public static void main(String[] args) {
		try {
			Path tempDirectory = Files.createTempDirectory("java9");
			System.out.format("임시 디렉토리 : %s%n", tempDirectory);
			
		    Path tempFile = Files.createTempFile(tempDirectory, 
		    		null, ".tempdata");
		    System.out.format("임시 파일 : %s%n", tempFile);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
