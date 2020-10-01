package insightbook.newjava.ch07;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamFilter {
	public static void main(String[] args) {
		Path dir = Paths.get("C:/Windows");

		// DirectoryStream.Filer 인터페이스를 구현해서 필터링 한다.
//		DirectoryStream.Filter<Path> filter = 
//				new DirectoryStream.Filter<Path>() {
//			public boolean accept(Path file) {
//				return (Files.isDirectory(file));
//			}
//		};

		// 람다 표현식을 이용해서 필터링 한다.
		try (DirectoryStream<Path> stream 
				= Files.newDirectoryStream(dir, (Path file) -> Files.isDirectory(file))) {
			for (Path file : stream) {
				System.out.println(file.getFileName());
			}
		} catch (IOException | DirectoryIteratorException x) {
			System.err.println(x);
		}
	}
}
