package hobby.internetms52.robotxtgen.text_gen;

public enum RobotTextFields {
    UserAgent("User-agent"),
    Disallow("Disallow"),
    Allow("Allow"),
    CrawDelay("Crawl-delay"),
    RequestRate("Request-rate"),
    Sitemap("Sitemap"),
    Host("Host");

    final public String value;

    RobotTextFields(String value) {
        this.value = value;
    }
}
