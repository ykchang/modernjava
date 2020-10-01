module insightbook.consumer {
    requires insightbook.provider;
    uses insightbook.newjava.module.service.InsightService;
}