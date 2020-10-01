package insightbook.newjava.ch06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class ForkJoinDirSize extends RecursiveTask<Long> {
	private final Path path;
	
	public ForkJoinDirSize(Path path) {
		this.path = path;
	}
	
	@Override
	protected Long compute() {
		long fileSize = 0;
		
		// 디렉토리 일경우 SUBTASK 생성하고 호출
		if(Files.isDirectory(path) ) {
			try {
    			List<Path> fileList = Files.list(path).collect(Collectors.toList());
    			List<ForkJoinDirSize> subTaskList = new ArrayList<>();
    			
    			for(Path file : fileList) {
    				ForkJoinDirSize subTask = new ForkJoinDirSize(file);
    				subTask.fork();
    				subTaskList.add(subTask);
    			}
    			
    			Long subSize = 0L;
    			
    			for(ForkJoinDirSize subTask : subTaskList) {
    				subSize += subTask.join();
    			}
    			
    			return subSize;
			}
			catch(IOException e) {
    			System.out.println("Error : " + path);
			}
		}
		// 파일일 경우 크기 리턴
		else {
			try {
    			fileSize = Files.size(path);
    		}
    		catch(IOException e) {
    			System.out.println("Error : " + path);
    		}
		}
		
		return fileSize;
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		Path rootPath = Paths.get("c:\\Program Files");
		ForkJoinPool pool = new ForkJoinPool();
		System.out.printf("병렬 처리 크기 : %s\n", pool.getParallelism());
		System.out.printf("합계 : %s\n", pool.invoke(new ForkJoinDirSize(rootPath)));
		
		long endTime = System.currentTimeMillis();
		
		System.out.printf("처리 시간 : " + (endTime - startTime));
	}
}