import hobby.internetms52.robotxtgen.Robotxt;
import hobby.internetms52.robotxtgen.UserAgentSection;
import hobby.internetms52.robotxtgen.text_gen.RobotTextGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RobotTextGeneratorTest {
    private Robotxt robotxt;
    private final RobotTextGenerator robotTextGenerator = new RobotTextGenerator();

    @BeforeEach
    public void setUp() {
        List<UserAgentSection> userAgentSectionList = new ArrayList<>();
        userAgentSectionList.add(UserAgentSetup.setupCase1());
        userAgentSectionList.add(UserAgentSetup.setupCase2());
        userAgentSectionList.add(UserAgentSetup.setupCase3());
        List<String> sitemaps = new ArrayList<>();
        sitemaps.add("https://www.example.com/sitemap.xml");
        robotxt = new Robotxt(
                userAgentSectionList,
                sitemaps,
                "www.example.com"
        );
    }

    @Test
    public void testGenerator() {
        String result = robotTextGenerator.gen(robotxt);
        String expectedAnswer = "User-agent: *\n" +
                "Disallow: /private/\n" +
                "Allow: /public/\n" +
                "Crawl-delay: 10\n" +
                "\n" +
                "User-agent: Googlebot\n" +
                "Disallow: /google-specific/\n" +
                "\n" +
                "User-agent: Bingbot\n" +
                "Disallow: /bing-specific/\n" +
                "\n" +
                "Sitemap: https://www.example.com/sitemap.xml\n" +
                "Host: www.example.com";
        String resultWithoutLineSeparator = result.replace("\n", "").replace("\r", "");
        String expectedAnswerWithoutLineSeparator = expectedAnswer.replace("\n", "").replace("\r", "");
        Assertions.assertEquals(expectedAnswerWithoutLineSeparator, resultWithoutLineSeparator);
    }

}
