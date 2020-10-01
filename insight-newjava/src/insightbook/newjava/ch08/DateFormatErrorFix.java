package insightbook.newjava.ch08;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DateFormatErrorFix {
	public static void main(String[] args) throws Exception {
	    Callable<Date> task = () -> new SimpleDateFormat("yyyyMMdd").parse("20101022");

	    // 쓰레드 풀 5개 생성
	    ExecutorService exec = Executors.newFixedThreadPool(5);
	    List<Future<Date>> results = new ArrayList<Future<Date>>();

	    // 5개의 스레드에서 동시 처리
	    for(int i = 0 ; i < 100 ; i++){
	        results.add(exec.submit(task));
	    }
	    exec.shutdown();

	    // 에러 발생
	    for(Future<Date> result : results){
	        System.out.println(result.get());
	    }
	}
}