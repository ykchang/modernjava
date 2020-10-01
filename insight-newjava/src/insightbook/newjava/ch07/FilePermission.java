package insightbook.newjava.ch07;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Set;

public class FilePermission {
	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("Usage : java FilePermission <file>");
			return;
		}
		
		// 파일을 생성할 때 사용할 옵션을 지정한다.
		// 없으면 생성하고 있으면 파일의 제일 뒷부분에 데이터를 추가하는 어펜드 모드를 사용한다.
		Set<OpenOption> options = new HashSet<OpenOption>();
		options.add(StandardOpenOption.APPEND);
		options.add(StandardOpenOption.CREATE);

		// 파일 생성시 퍼미션을 지정한다. 개인에게는 읽기 쓰기, 그룹에는 읽기 그 외에는 권한을 부여하지 않았다.
		Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-r-----");
		FileAttribute<Set<PosixFilePermission>> attr = 
				PosixFilePermissions.asFileAttribute(perms);

		// 저장할 데이터를 작성한다.
		String s = "안녕하세요. 인사이트 출판사입니다.";
		byte data[] = s.getBytes();
		ByteBuffer bb = ByteBuffer.wrap(data);

		Path file = Paths.get(args[0]);

		try (SeekableByteChannel sbc = 
				Files.newByteChannel(file, options, attr)) {
			sbc.write(bb);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
