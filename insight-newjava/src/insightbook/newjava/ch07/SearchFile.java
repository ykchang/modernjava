package insightbook.newjava.ch07;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public class SearchFile {
	public static class FilesFinder extends SimpleFileVisitor<Path> {
		private final PathMatcher matcher;

		FilesFinder(String pattern) {
			matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
		}

		public boolean isMatched(Path file) {
			Path name = file.getFileName();
			if (name != null && matcher.matches(name)) {
				return true;
			}
			else {
				return false;
			}
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
			isMatched(file);
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
			isMatched(dir);
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFileFailed(Path file, IOException e) {
			e.printStackTrace();
			return FileVisitResult.CONTINUE;
		}
	}

	public static void main(String[] args) throws IOException {
        Path startingDir = Paths.get("C:/Windows");

        EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        
        FilesFinder filesFinder = new FilesFinder("w*.{exe,bat}");
        Files.walkFileTree(startingDir, opts, Integer.MAX_VALUE, filesFinder);
	}
}