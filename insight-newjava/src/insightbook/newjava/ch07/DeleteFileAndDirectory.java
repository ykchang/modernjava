package insightbook.newjava.ch07;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteFileAndDirectory {
	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("Usage : java DeleteFileAndDirectory <path>");
			return;
		}
		
		Path path = Paths.get(args[0]);
		
		try {
			Files.delete(path);
		} 
		catch (NoSuchFileException e) {
			System.err.format("%s : 파일 혹은 디렉토리가 없습니다. %n", path);
			e.printStackTrace();
		} 
		catch (DirectoryNotEmptyException e) {
			System.err.format("%s : 디렉토리가 비어 있지 않습니다.%n", path);
			
			try {
				// 심볼릭 링크가 아닐 경우만 삭제
				if(!Files.isSymbolicLink(path)) {
					deleteNotEmptyDirectory(path);
				}
			}
			catch(IOException e1) {
				System.err.println(e1);
			}
		} 
		catch (IOException x) {
			System.err.println(x);
		}
		
	}

	// 디렉토리에 포함되어 있는 모든 파일을 삭제한다.
	// 하위에 디렉토리가 포함되어 있을 경우 재귀호출한다.
	public static void deleteNotEmptyDirectory(Path path) throws IOException {
        if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
        	try (DirectoryStream<Path> entries = Files.newDirectoryStream(path)) {
                for (Path entry : entries) {
                    deleteNotEmptyDirectory(entry);
                }
            }
        }
        Files.delete(path);
    }
}
