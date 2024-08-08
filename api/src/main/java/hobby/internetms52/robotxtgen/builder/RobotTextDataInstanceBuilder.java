package hobby.internetms52.robotxtgen.builder;

import hobby.internetms52.robotxtgen.RobotTextDataInstance;
import hobby.internetms52.robotxtgen.UserAgentSection;

import java.util.ArrayList;
import java.util.List;

public class RobotTextDataInstanceBuilder {
    private List<UserAgentSection> userAgentSections = new ArrayList<>();
    private List<String> sitemaps = new ArrayList<>();
    private String host;

    public RobotTextDataInstanceBuilder addUserAgentSection(UserAgentSection userAgentSection) {
        this.userAgentSections.add(userAgentSection);
        return this;
    }

    public RobotTextDataInstanceBuilder addSiteMap(String sitemap) {
        this.sitemaps.add(sitemap);
        return this;
    }

    public RobotTextDataInstanceBuilder host(String host) {
        this.host = host;
        return this;
    }

    public RobotTextDataInstance build() {
        return new RobotTextDataInstance(
                userAgentSections,
                sitemaps,
                host
        );
    }

}
