package insightbook.newjava.ch07;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NewFileFilter {
	public static void main(String[] args) {
		Path dir = Paths.get("C:/Windows");
		
		// DirectoryStream을 이용해서 조회한다.
		// Glob 문자열 패턴을 이용해서 필터링 한다.
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{exe}")) {
		    for (Path file: stream) {
		        System.out.println(file.getFileName());
		    }
		} 
		catch (IOException | DirectoryIteratorException e) {
		    e.printStackTrace();
		}
	}
}
