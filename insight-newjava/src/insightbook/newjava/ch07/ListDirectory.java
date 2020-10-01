package insightbook.newjava.ch07;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListDirectory {
	public static void main(String[] args) {
		Path dir = Paths.get("c:/windows");

		// for loop를 이용한 처리
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
		    for (Path file: stream) {
		        System.out.println(file.getFileName());
		    }
		} 
		catch (IOException | DirectoryIteratorException e) {
		    e.printStackTrace();
		}
	}
}
