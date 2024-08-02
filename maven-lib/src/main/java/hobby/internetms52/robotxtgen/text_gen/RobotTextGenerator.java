package hobby.internetms52.robotxtgen.text_gen;

import hobby.internetms52.robotxtgen.Robotxt;

public class RobotTextGenerator implements TextGen<Robotxt> {
    private final UserAgentSectionTextGenerator userAgentSectionTextGenerator = new UserAgentSectionTextGenerator();

    @Override
    public String gen(Robotxt object) {
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
