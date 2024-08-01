package hobby.internetms52.robotxtgen;

import java.util.List;

/**
 * A robot.txt object
 *
 * @author Eugene Lu.
 * @version 1.0
 */
public class Robotxt {
    private List<UserAgentSection> sections;
    private List<String> sitemaps;
    private String host;


    /**
     * default constructor
     * @param sections UserAgentSection
     * @param sitemaps sitemaps in robot.txt
     * @param host host in robot.txt
     */
    public Robotxt(List<UserAgentSection> sections, List<String> sitemaps, String host) {
        this.sections = sections;
        this.sitemaps = sitemaps;
        this.host = host;
    }

    public List<UserAgentSection> getSections() {
        return sections;
    }

    public void setSections(List<UserAgentSection> sections) {
        this.sections = sections;
    }

    //getter
    public List<String> getSitemaps() {
        return sitemaps;
    }

    public void setSitemaps(List<String> sitemaps) {
        this.sitemaps = sitemaps;
    }

    /**
     * Host: www.example.com
     * @return
     */
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}