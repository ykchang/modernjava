package insightbook.newjava.module.consumer;

import java.util.ServiceLoader;

import insightbook.newjava.module.service.InsightService;

public class Consumer {
    public static void main(String[] args) {
        ServiceLoader<InsightService> loader = ServiceLoader.load(InsightService.class);

        for (final InsightService service : loader) {
            System.out.println("서비스명 : " + service.getClass().getSimpleName() + ", 결과 : " + service.echo(service.getClass().getSimpleName()));
        }
    }
}