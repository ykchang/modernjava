package insightbook.newjava.ch07;

import java.io.File;
import java.io.FilenameFilter;

public class OldFileFilter {
	public static void main(String[] args) {
		File file = new File("C:/Windows");
		
		// 인터페이스를 구현하는 방식을 사용한다.
//		String[] filteredFile = file.list(new FilenameFilter() {
//			@Override
//			public boolean accept(File dir, String name) {
//				return name.toLowerCase().endsWith(".exe");
//			}
//		});
		
		// 람다 표현식을 이용한다.
		String[] filteredFile = 
				file.list((File dir, String name) -> name.toLowerCase().endsWith(".exe"));
		
		for(String fileName : filteredFile) {
			System.out.println(fileName);
		}
	}
}
