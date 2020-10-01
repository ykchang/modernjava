package insightbook.newjava.ch07;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesChecker {
	public static void main(String[] args) {
		if(args.length < 1) {
			printUsage();
			return;
		}
		
		Path path = Paths.get(args[0]);
		
		// Path 정보가 실제로 존재하는지 여부 확인
		if( Files.exists(path) && !Files.notExists(path)) {
			System.out.println("Path가 존재합니다.");
		}
		else {
			System.out.println("Path가 존재하지 않거나 문제가 있습니다.");
		}
		
		// 파일과 디렉토리 구분
		if(Files.isDirectory(path)) {
			System.out.println("디렉토리");
		}
		else {
			System.out.println("파일");
		}
		
		// 파일 권한 확인
		if(Files.isReadable(path)) {
			System.out.println("읽기 가능");
		}
		
		if(Files.isWritable(path)) {
			System.out.println("쓰기 가능");
		}
		
		if(Files.isExecutable(path)) {
			System.out.println("실행 가능");
		}
		
		// 일반 파일인지 확인
		System.out.println("Regular Files : " + Files.isRegularFile(path));
	}
	
	public static void printUsage() {
		System.out.println("java insightbook.newjava.file.FilesChecker <path information>");
		System.out.println("<path information> : file or directory path");
	}
}