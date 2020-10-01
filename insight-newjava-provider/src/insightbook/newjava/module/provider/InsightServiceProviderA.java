package insightbook.newjava.module.provider;

import insightbook.newjava.module.service.InsightService;

public class InsightServiceProviderA implements InsightService {
    @Override
    public String echo(String messages) {
        return "Hello A : " + messages;
    }
}