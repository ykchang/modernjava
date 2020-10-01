package insightbook.newjava.module.consumer;

import java.util.ServiceLoader;

import insightbook.newjava.module.service.InsightService;

public class Consumer {
    public static void main(String[] args) {
        ServiceLoader<InsightService> loader = ServiceLoader.load(InsightService.class);

        for (final InsightService service : loader) {
            System.out.println("���񽺸� : " + service.getClass().getSimpleName() + ", ��� : " + service.echo(service.getClass().getSimpleName()));
        }
    }
}