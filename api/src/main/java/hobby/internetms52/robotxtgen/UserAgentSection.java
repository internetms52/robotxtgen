package hobby.internetms52.robotxtgen;

import hobby.internetms52.robotxtgen.builder.UserAgentSectionBuilder;

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

    public static UserAgentSectionBuilder builder() {
        return new UserAgentSectionBuilder();
    }

    /**
     * default constructor
     *
     * @param userAgent   String
     * @param disallows   List of String
     * @param allows      String
     * @param crawlDelay  Integer
     * @param requestRate String
     * @param comments    List of String
     */
    public UserAgentSection(String userAgent, List<String> disallows, List<String> allows, Integer crawlDelay, String requestRate, List<String> comments) {
        this.userAgent = userAgent;
        this.disallows = disallows;
        this.allows = allows;
        this.crawlDelay = crawlDelay;
        this.requestRate = requestRate;
        this.comments = comments;
    }

    /**
     * default UserAgent getter
     *
     * @return String
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * default UserAgentSetter
     *
     * @param userAgent String
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    /**
     * default Disallows getter
     *
     * @return List of String
     */
    public List<String> getDisallows() {
        return disallows;
    }

    /**
     * default disallows setter
     *
     * @param disallows List of String
     */
    public void setDisallows(List<String> disallows) {
        this.disallows = disallows;
    }

    /**
     * default allow path setter
     *
     * @return List of String
     */
    public List<String> getAllows() {
        return allows;
    }

    /**
     * default allows setter
     *
     * @param allows List of String
     */
    public void setAllows(List<String> allows) {
        this.allows = allows;
    }

    /**
     * "Crawl-delay is a directive in the robots.txt file that specifies the number of seconds a web crawler should wait between consecutive requests to the server. For example, a Crawl-delay of 10 means the crawler should pause for 10 seconds after each request before making the next one. This helps to reduce the load on the server by spacing out the requests from search engine bots."
     *
     * @return Integer
     */
    public Integer getCrawlDelay() {
        return crawlDelay;
    }

    /**
     * default crawlDelay setter
     *
     * @param crawlDelay Integer
     */
    public void setCrawlDelay(Integer crawlDelay) {
        this.crawlDelay = crawlDelay;
    }

    /**
     * "Request-rate is a more precise directive used in robots.txt to control the rate at which a web crawler can make requests. It specifies the number of requests allowed within a given time period. For instance, a Request-rate of 1/10s means the crawler is allowed to make one request every 10 seconds. This provides finer control over the crawler's behavior compared to Crawl-delay, allowing website owners to balance between server load and crawling efficiency."
     *
     * @return String
     */
    public String getRequestRate() {
        return requestRate;
    }

    /**
     * default request-rate setter
     *
     * @param requestRate String
     */
    public void setRequestRate(String requestRate) {
        this.requestRate = requestRate;
    }

    /**
     * default comments getter
     *
     * @return List of String
     */
    public List<String> getComments() {
        return comments;
    }

    /**
     * default comments setter
     *
     * @param comments List of String
     */
    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
