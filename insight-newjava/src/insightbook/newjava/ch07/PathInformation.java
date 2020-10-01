package insightbook.newjava.ch07;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInformation {
	public static void main(String[] args) {
		// 마이크로소프트 윈도우 형태
		Path path = Paths.get("C:\\windows\\system32\\drivers");

		System.out.format("toString: %s%n", path.toString());
		System.out.format("getFileName: %s%n", path.getFileName());
		System.out.format("getName(0): %s%n", path.getName(0));
		System.out.format("getNameCount: %d%n", path.getNameCount());
		System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
		System.out.format("getParent: %s%n", path.getParent());
		System.out.format("getRoot: %s%n", path.getRoot());
	}
}