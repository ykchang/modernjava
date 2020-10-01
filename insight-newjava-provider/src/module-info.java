module insightbook.provider {
	exports insightbook.newjava.module.service;
	
	provides insightbook.newjava.module.service.InsightService with 
		insightbook.newjava.module.provider.InsightServiceProviderA,
        insightbook.newjava.module.provider.InsightServiceProviderB;
}