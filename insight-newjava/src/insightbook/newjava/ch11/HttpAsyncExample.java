package insightbook.newjava.ch11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpAsyncExample {

	public static void main(String[] args) {
		// HttpRequest를 정의한다.
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(URI.create("http://www.insightbook.co.kr/"))
				.GET()
		        .build();

		// HttpClient 객체를 생성한다.
		HttpClient httpClient = HttpClient.newHttpClient();
		
		// Async로 HTTP 호출을 수행한다.
		httpClient.sendAsync(httpRequest, BodyHandlers.ofString())
				.thenApply(httpResponse -> { 
					System.out.println(httpResponse.statusCode());
					return httpResponse;
				})
        		.thenAccept(httpResponse -> {
        			System.out.println("Response Header : " + httpResponse.headers());
        			System.out.println("Response Body : " + httpResponse.body());
        		})
        		.join(); // 실제 사용시에는 join 메소드를 제거해야 한다.
	}
}