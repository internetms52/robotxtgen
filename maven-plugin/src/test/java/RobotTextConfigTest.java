import hobby.internetms52.robotxtgen.RobotTextDataInstance;
import hobby.internetms52.robotxtgen.UserAgentSection;
import hobby.internetms52.robotxtgen.config.RobotTextConfigProvider;

import java.util.ArrayList;
import java.util.List;

public class RobotTextConfigTest implements RobotTextConfigProvider {
    @Override
    public RobotTextDataInstance robotTextDataInstance() {
        List<UserAgentSection> userAgentSectionList = new ArrayList<>();
        userAgentSectionList.add(UserAgentSetup.setupCase1());
        userAgentSectionList.add(UserAgentSetup.setupCase2());
        userAgentSectionList.add(UserAgentSetup.setupCase3());
        List<String> sitemaps = new ArrayList<>();
        sitemaps.add("https://www.example.com/sitemap.xml");
        return new RobotTextDataInstance(
                userAgentSectionList,
                sitemaps,
                "www.example.com"
        );
    }
}
