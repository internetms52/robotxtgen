package hobby.internetms52.robotxtgen.builder;

import hobby.internetms52.robotxtgen.UserAgentSection;

import java.util.ArrayList;
import java.util.List;

public class UserAgentSectionBuilder {
    private String userAgent;
    private List<String> disallows = new ArrayList<>();
    private List<String> allows = new ArrayList<>();
    private Integer crawlDelay;
    private String requestRate;
    private List<String> comments = new ArrayList<>();

    public UserAgentSectionBuilder userAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public UserAgentSectionBuilder addDisallow(String disallow) {
        this.disallows.add(disallow);
        return this;
    }

    public UserAgentSectionBuilder addAllow(String allow) {
        this.allows.add(allow);
        return this;
    }

    public UserAgentSectionBuilder crawlDelay(Integer crawlDelay) {
        this.crawlDelay = crawlDelay;
        return this;
    }

    public UserAgentSectionBuilder requestRate(String requestRate) {
        this.requestRate = requestRate;
        return this;
    }

    public UserAgentSectionBuilder addComment(String comment) {
        this.comments.add(comment);
        return this;
    }

    public UserAgentSection build() {
        return new UserAgentSection(
                userAgent,
                disallows,
                allows,
                crawlDelay,
                requestRate,
                comments
        );
    }
}
