package hobby.internetms52.robotxtgen.text_gen;

import hobby.internetms52.robotxtgen.UserAgentSection;

public class UserAgentSectionTextGenerator implements TextGen<UserAgentSection> {
    @Override
    public String gen(UserAgentSection object) {
        StringBuilder stringBuilder = new StringBuilder();
        object.getComments().forEach(comment -> {
            stringBuilder.append(commentGenText(comment));
        });
        stringBuilder.append(
                keyValuePairGenText(UserAgentSectionFields.UserAgent.value, object.getUserAgent())
        );
        object.getDisallows().forEach(disallow -> {
            stringBuilder.append(
                    keyValuePairGenText(UserAgentSectionFields.Disallow.value, disallow)
            );
        });
        object.getAllows().forEach(allow -> {
            stringBuilder.append(
                    keyValuePairGenText(UserAgentSectionFields.Disallow.value, allow)
            );
        });
        stringBuilder.append(
                keyValuePairGenText(
                        UserAgentSectionFields.CrawDelay.value, String.valueOf(object.getCrawlDelay())
                )
        );
        stringBuilder.append(
                keyValuePairGenText(
                        UserAgentSectionFields.RequestRate.value, object.getRequestRate()
                )
        );
        return stringBuilder.toString();
    }
}
