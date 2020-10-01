package insightbook.newjava.ch07;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class PrintAllFiles {
	
	public static void main(String[] args) {
		Path dirPath = Paths.get("C:/windows");
		try {
			Files.walkFileTree(dirPath, new FileVisitor<Path>() {
				// 디렉토리에 진입하기 전에 호출된다.
				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
						throws IOException {
					return FileVisitResult.CONTINUE;
				}
				
				// 디렉토리에 진입한 후에 호출된다.
				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) 
						throws IOException {
					System.out.format("디렉토리 : %s%n", dir);
					return FileVisitResult.CONTINUE;
				}

				// 파일에 접근하면서 호출된다.
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attr) 
						throws IOException {
					if (attr.isSymbolicLink()) {
						System.out.format("심볼릭 링크 : %s ", file);
					} 
					else if (attr.isRegularFile()) {
						System.out.format("일반 파일 : %s ", file);
					} 
					else {
						System.out.format("기타 파일 : %s ", file);
					}
					
					System.out.println("(" + attr.size() + "바이트)");
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
					System.err.println(exc);
					return FileVisitResult.CONTINUE;
				}
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}