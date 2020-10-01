package insightbook.newjava.ch07;

import java.nio.file.Path;
import java.nio.file.Paths;

public class JoinPath {
	public static void main(String[] args) {
		// 기존 경로를 구한다.
		Path path = Paths.get("c:\\windows\\system32");
		System.out.println(path);
		
		// drivers 경로를 추가한다.
		Path resolvedPath = path.resolve("drivers");
		System.out.println(resolvedPath);

		// 앞의 경로를 제거한다.
		Path anotherPath = resolvedPath.resolve("c:\\windows");
		System.out.println(anotherPath);
	}
}