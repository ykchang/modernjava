package insightbook.newjava.ch07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamPrintAllFiles {
	
	public static void main(String[] args) {
		Path dirPath = Paths.get("C:/windows");
		
		// Path 기반의 스트림 객체를 얻는다.
		try(Stream<Path> streamPath = Files.walk(dirPath)) {
			// Path 정보를 출력한다.
			streamPath.forEach((Path path) -> {
				if(Files.isDirectory(path)) {
					System.out.format("디렉토리 : %s%n", path);
				}
				else if(Files.isRegularFile(path)) {
					System.out.format("일반 파일 : %s ", path);
				}
				else if(Files.isSymbolicLink(path)) {
					System.out.format("심볼릭 링크 : %s ", path);
				}
				else {
					System.out.format("기타 파일 : %s ", path);
				}
			});
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}