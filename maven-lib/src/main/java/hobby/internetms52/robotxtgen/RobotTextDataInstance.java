package hobby.internetms52.robotxtgen;

import java.util.List;

/**
 * A robot.txt object
 *
 * @author Eugene Lu.
 * @version 1.0
 */
public class RobotTextDataInstance {
    private List<UserAgentSection> sections;
    private List<String> sitemaps;
    private String host;


    /**
     * default constructor
     *
     * @param sections UserAgentSection
     * @param sitemaps sitemaps in robot.txt
     * @param host     host in robot.txt
     */
    public RobotTextDataInstance(List<UserAgentSection> sections, List<String> sitemaps, String host) {
        this.sections = sections;
        this.sitemaps = sitemaps;
        this.host = host;
    }

    /**
     * defined in UserAgentSection Class
     *
     * @return List of UserAgentSection
     */
    public List<UserAgentSection> getSections() {
        return sections;
    }

    /**
     * default UserAgentSection Setter
     *
     * @param sections List of UserAgentSection
     */
    public void setSections(List<UserAgentSection> sections) {
        this.sections = sections;
    }

    /**
     * default sitemaps getter
     *
     * @return List of String
     */
    public List<String> getSitemaps() {
        return sitemaps;
    }

    /**
     * default sitemaps setter
     *
     * @param sitemaps List of String
     */
    public void setSitemaps(List<String> sitemaps) {
        this.sitemaps = sitemaps;
    }

    /**
     * Host: www.example.com
     *
     * @return String
     */
    public String getHost() {
        return host;
    }

    /**
     * default host setter
     *
     * @param host String
     */
    public void setHost(String host) {
        this.host = host;
    }
}