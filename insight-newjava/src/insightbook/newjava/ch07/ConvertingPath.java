package insightbook.newjava.ch07;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ConvertingPath {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("usage: FileTest file");
			System.exit(-1);
		}

		// Converts the input string to a Path object.
		Path inputPath = Paths.get(args[0]);
		Path fullPath = inputPath.toAbsolutePath();
		
		System.out.println(fullPath);
	}
}
