package hobby.internetms52.robotxtgen.text_gen;

import hobby.internetms52.robotxtgen.RobotTextDataInstance;

public class RobotTextContentGenerator implements TextGen<RobotTextDataInstance> {
    private final UserAgentSectionTextGenerator userAgentSectionTextGenerator = new UserAgentSectionTextGenerator();

    @Override
    public String gen(RobotTextDataInstance object) {
        StringBuilder stringBuilder = new StringBuilder();
        object.getSections().forEach(userAgentSection -> {
            stringBuilder.append(
                    userAgentSectionTextGenerator.gen(userAgentSection)
            );
        });
        object.getSitemaps().forEach(sitemap -> {
            stringBuilder.append(keyValuePairGenText(RobotTextFields.Sitemap.value, sitemap));
        });
        stringBuilder.append(keyValuePairGenText(RobotTextFields.Host.value, object.getHost()));
        return stringBuilder.toString();
    }
}
