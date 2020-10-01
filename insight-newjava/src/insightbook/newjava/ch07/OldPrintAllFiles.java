package insightbook.newjava.ch07;

import java.io.File;
import java.io.IOException;

public class OldPrintAllFiles {
	public static void displayDirectoryContents(File dir) {
		File[] files = dir.listFiles();

		for (File file : files) {
			try {
				if (file.isDirectory()) {
					System.out.println("디렉토리 :" + file.getCanonicalPath());
					displayDirectoryContents(file);
				} 
				else {
					System.out.println("일반파일 :" + file.getCanonicalPath());
				}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		File currentDir = new File("C:/windows");
		displayDirectoryContents(currentDir);
	}
}