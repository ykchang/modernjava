module insightbook.newjava.first {
    requires java.base;
    requires transitive java.sql;
    exports insightbook.newjava.module.dao;
}