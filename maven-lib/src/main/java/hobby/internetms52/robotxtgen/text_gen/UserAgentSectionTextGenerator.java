package hobby.internetms52.robotxtgen.text_gen;

import hobby.internetms52.robotxtgen.UserAgentSection;

public class UserAgentSectionTextGenerator implements TextGen<UserAgentSection> {
    @Override
    public String gen(UserAgentSection object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(
                keyValuePairGenText(UserAgentSectionFields.UserAgent.value, object.getUserAgent())
        );
        object.getDisallows().forEach(disallow -> {
            stringBuilder.append(
                    keyValuePairGenText(UserAgentSectionFields.Disallow.value, disallow)
            );
        });
        return null;
    }
}
