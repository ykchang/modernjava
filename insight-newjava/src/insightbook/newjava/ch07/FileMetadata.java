package insightbook.newjava.ch07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;

/**
 * 파일의 속성 정보를 조회하는 예제
 * java.nio.file.Files에서 제공하는 정보를 이용한다.
 */
public class FileMetadata {
	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("Usage : java FileMetadata <path>");
			return;
		}

		Path file = Paths.get(args[0]);
		if(Files.exists(file)) {
    		try {
    			// 기본 파일 속성
    			BasicFileAttributes attr = 
    					Files.readAttributes(file, BasicFileAttributes.class);
    	
    			System.out.println("creationTime: " + attr.creationTime());
    			System.out.println("lastAccessTime: " + attr.lastAccessTime());
    			System.out.println("lastModifiedTime: " + attr.lastModifiedTime());
    	
    			System.out.println("isDirectory: " + attr.isDirectory());
    			System.out.println("isOther: " + attr.isOther());
    			System.out.println("isRegularFile: " + attr.isRegularFile());
    			System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
    			System.out.println("size: " + attr.size());
    
    			// MS Windows 파일 속성
    			DosFileAttributes dosAttr = 
    					Files.readAttributes(file, DosFileAttributes.class);
    		    System.out.println("isReadOnly is " + dosAttr.isReadOnly());
    		    System.out.println("isHidden is " + dosAttr.isHidden());
    		    System.out.println("isArchive is " + dosAttr.isArchive());
    		    System.out.println("isSystem is " + dosAttr.isSystem());
    		}
    		catch(IOException e) {
    			e.printStackTrace();
    		}
		}
	}
}