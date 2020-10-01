package insightbook.newjava.ch07;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * JAVA 8에서 파일을 이동하는 예제이다. 
 * Files 클래스를 이용하였다.
 */
public class NewFilesMove {
	public static void moveFile(Path source, Path target, CopyOption[] options) {
		if(Files.isDirectory(source) || Files.notExists(source)) {
			System.out.println("소스 파일이 존재하지 않거나 디렉토리 입니다.");
			return;
		}
		
        try {
        	if(Files.exists(target)) {
            	System.out.println("대상 파일이 존재합니다.");
            }

        	Files.move(source, target, options);
            
        } 
        catch(FileAlreadyExistsException e) {
        	e.printStackTrace();
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
	}

	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("Usage : java NewFilesMove <source file> <target file>");
			return;
		}
		
		Path source = Paths.get(args[0]);
		Path target = Paths.get(args[1]);
		
		CopyOption[] options = {StandardCopyOption.REPLACE_EXISTING};
		
		moveFile(source, target, options);
	}
}
