package insightbook.newjava.ch11;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.LinkedHashMap;
import java.util.Map;

public class HttpPostExample {
	
	public static void main(String[] args) throws Exception {
		String json = "...";

        Map<String,Object> params = new LinkedHashMap<>();
        params.put("title", "Email Test");
        params.put("email", "id@seamail.example.com");
        params.put("reply_to_thread", 10394);
        params.put("message", "Hello, friends. ~~~");

        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
        }		
		
		// HttpRequest를 정의한다.
		HttpRequest httpRequest = HttpRequest.newBuilder()
		        .uri(URI.create("http://someurl.com"))
		        .header("Content-Type", "application/json")
		        .POST(BodyPublishers.ofString(postData.toString()))
		        .build();

		// HttpClient 객체를 생성한다.
		HttpClient httpClient = HttpClient.newHttpClient();
	
		// 요청을 호출한다.
		try {
    		HttpResponse<String> httpResponse = 
    				httpClient.send(httpRequest, BodyHandlers.ofString());
    		System.out.println("Response Code : " + httpResponse.statusCode());
    		System.out.println("Response Header : " + httpResponse.headers());
    		System.out.println("Response Body : " + httpResponse.body());
    	} 
    	catch (IOException | InterruptedException e) {
    		e.printStackTrace();
    	}
	}
}
