package hobby.internetms52.robotxtgen.text_gen;

public enum UserAgentSectionFields {
    UserAgent("User-agent"),
    Disallow("Disallow"),
    CrawDelay("Crawl-delay"),
    RequestRate("Request-rate");

    final public String value;

    UserAgentSectionFields(String value) {
        this.value = value;
    }
}
