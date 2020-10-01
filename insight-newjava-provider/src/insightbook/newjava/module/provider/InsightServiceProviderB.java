package insightbook.newjava.module.provider;

import insightbook.newjava.module.service.InsightService;

public class InsightServiceProviderB implements InsightService {
    @Override
    public String echo(String messages) {
        return "Hello B : " + messages;
    }
}