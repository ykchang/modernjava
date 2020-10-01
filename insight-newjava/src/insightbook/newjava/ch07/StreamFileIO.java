package insightbook.newjava.ch07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StreamFileIO {
	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("Usage : java StreamFileIO <source> <target>");
			return;
		}
		
		Path sourcePath = Paths.get(args[0]);
		Path targetPath = Paths.get(args[1]);
		
		// InputStream, OutputStream을 이용해서 파일 처리를 한다.
		try (InputStream input = Files.newInputStream(sourcePath);
				BufferedReader reader = new BufferedReader(new InputStreamReader(input));
				OutputStream out = Files.newOutputStream(targetPath);
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))) {
		    String line = null;

		    // 파일에서 데이터를 읽어들인다. 한줄씩 읽어들이는 예제이다.
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		        
				// 특정한 비즈니스 로직을 구현한다.
		        // ...
		        
		        // 데이터를 파일에 저장한다.
			    writer.write(line, 0, line.length());
		    }
		}
		catch (IOException e) {
		    System.err.format("IOException: %s%n", e);
		}
	}
	
	// byte 배열로 처리하는 방식이다.
	public void temp(String source, String target) {
		Path sourcePath = Paths.get(source);
		Path targetPath = Paths.get(target);
		
		try (InputStream input = Files.newInputStream(sourcePath);
				BufferedInputStream binput = new BufferedInputStream(input);
				OutputStream out = Files.newOutputStream(targetPath);
				BufferedOutputStream bout = new BufferedOutputStream(out)) {

			int index = 0;
			byte[] buffer = new byte[1024];
					
		    // 파일에서 데이터를 읽어들인다.
			// 한줄씩 읽지 않고 일정 크기의 버퍼 만큼 읽어들인다.
		    while ((index = binput.read(buffer)) != -1) {
			    bout.write(buffer, 0, index);
		    }
		}
		catch (IOException e) {
		    System.err.format("IOException: %s%n", e);
		}
	}
}
