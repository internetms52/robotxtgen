package hobby.internetms52.robotxtgen;

import java.util.ArrayList;
import java.util.List;

/**
 * User-agent: *
 * Disallow: /private/
 * Allow: /public/
 * Crawl-delay: 10
 * Request-rate: 1/10s
 * Comments: sample
 */
public class UserAgentSection {
    private String userAgent;
    private List<String> disallows = new ArrayList<>();
    private List<String> allows = new ArrayList<>();
    private Integer crawlDelay;
    private String requestRate;
    private List<String> comments = new ArrayList<>();

    public UserAgentSection(String userAgent, List<String> disallows, List<String> allows, Integer crawlDelay, String requestRate, List<String> comments) {
        this.userAgent = userAgent;
        this.disallows = disallows;
        this.allows = allows;
        this.crawlDelay = crawlDelay;
        this.requestRate = requestRate;
        this.comments = comments;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public List<String> getDisallows() {
        return disallows;
    }

    public void setDisallows(List<String> disallows) {
        this.disallows = disallows;
    }

    public List<String> getAllows() {
        return allows;
    }

    public void setAllows(List<String> allows) {
        this.allows = allows;
    }

    public Integer getCrawlDelay() {
        return crawlDelay;
    }

    public void setCrawlDelay(Integer crawlDelay) {
        this.crawlDelay = crawlDelay;
    }

    public String getRequestRate() {
        return requestRate;
    }

    public void setRequestRate(String requestRate) {
        this.requestRate = requestRate;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
