package insightbook.newjava.ch07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedFileIO {
	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("Usage : java BufferedFileIO <source file> <target file>");
			return;
		}
		
		Path sourcePath = Paths.get(args[0]);
		Path targetPath = Paths.get(args[1]);
		
		Charset charset = Charset.forName("EUC-KR");

		try (BufferedReader reader = Files.newBufferedReader(sourcePath, charset);
				BufferedWriter writer = Files.newBufferedWriter(targetPath, charset)) {
		    String line = null;

		    // 파일에서 데이터를 한줄씩 읽는다.
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
				// 특정한 비즈니스 로직을 구현한다.
		        // ...
		        
		        // 데이터를 파일에 한줄식 저장한다.
			    writer.write(line, 0, line.length());
		    }
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
