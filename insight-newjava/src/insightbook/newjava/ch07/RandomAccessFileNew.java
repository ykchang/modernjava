package insightbook.newjava.ch07;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RandomAccessFileNew {
	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("Usage : java RandomAccessFileNew <file>");
			return;
		}
		
		Path file = Paths.get(args[0]);
		
		String s = "Java New Features\n";
		byte data[] = s.getBytes();

		ByteBuffer out = ByteBuffer.wrap(data);
		ByteBuffer copy = ByteBuffer.allocate(1024);

		// 데이터를 조회할 파일을 오픈하기 위해 FileChannel을 생서하였다.
		try (FileChannel fileChannel
				= (FileChannel.open(file, StandardOpenOption.READ, StandardOpenOption.WRITE))) {
			
			// 파일에서 1024바이트를 읽어들인다.
			int index;
			do {
				index = fileChannel.read(copy);
			} 
			while (index != -1 && copy.hasRemaining());

			// 1024번째 위치에서 0번째 위치로 이동한 후 데이터를 쓴다.
			fileChannel.position(0);
			while (out.hasRemaining()) {
				fileChannel.write(out);
			}
			out.rewind(); // ByteBuffer를 초기화 한다.

			// 파일의 제일 뒤로 이동한 후 다시 데이터를 쓴다.
			long length = fileChannel.size();
			fileChannel.position(length-1);
			copy.flip();
			while (copy.hasRemaining()) {
				fileChannel.write(copy);
			}
			
			while (out.hasRemaining()) {
				fileChannel.write(out);
			}
		} 
		catch (IOException e) {
			System.out.println("I/O Exception: " + e);
		}
	}
}
