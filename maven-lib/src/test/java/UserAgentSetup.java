import hobby.internetms52.robotxtgen.UserAgentSection;

import java.util.ArrayList;
import java.util.List;

public class UserAgentSetup {
    static UserAgentSection setupCase1() {
        List<String> disallow = new ArrayList<>();
        disallow.add("/private/");
        List<String> allow = new ArrayList<>();
        allow.add("/public/");
        return new UserAgentSection(
                "*",
                disallow,
                allow,
                null,
                null,
                null
        );
    }

    static UserAgentSection setupCase2() {
        List<String> disallow = new ArrayList<>();
        disallow.add("/google-specific/");
        return new UserAgentSection(
                "Googlebot",
                disallow,
                null,
                null,
                null,
                null
        );
    }

    static UserAgentSection setupCase3() {
        List<String> disallow = new ArrayList<>();
        disallow.add("/bing-specific/");
        return new UserAgentSection(
                "Bingbot",
                disallow,
                null,
                null,
                null,
                null
        );
    }

}
