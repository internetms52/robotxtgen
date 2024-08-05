package hobby.internetms52.robotxtgen.text_gen;

import hobby.internetms52.robotxtgen.UserAgentSection;

import static hobby.internetms52.robotxtgen.text_gen.InputValidationUtil.isValidInput;

public class UserAgentSectionTextGenerator implements TextGen<UserAgentSection> {
    @Override
    public String gen(UserAgentSection object) {
        StringBuilder stringBuilder = new StringBuilder();
        if (isValidInput(object.getComments())) {
            object.getComments().forEach(comment -> {
                stringBuilder.append(commentGenText(comment));
            });
        }
        if (isValidInput(object.getUserAgent())) {
            stringBuilder.append(
                    keyValuePairGenText(RobotTextFields.UserAgent.value, object.getUserAgent())
            );
        }
        if (isValidInput(object.getDisallows())) {
            object.getDisallows().forEach(disallow -> {
                stringBuilder.append(
                        keyValuePairGenText(RobotTextFields.Disallow.value, disallow)
                );
            });
        }
        if (isValidInput(object.getAllows())) {
            object.getAllows().forEach(allow -> {
                stringBuilder.append(
                        keyValuePairGenText(RobotTextFields.Allow.value, allow)
                );
            });
        }
        if (isValidInput(object.getCrawlDelay())) {
            stringBuilder.append(
                    keyValuePairGenText(
                            RobotTextFields.CrawDelay.value, String.valueOf(object.getCrawlDelay())
                    )
            );
        }
        if (isValidInput(object.getRequestRate())) {
            stringBuilder.append(
                    keyValuePairGenText(
                            RobotTextFields.RequestRate.value, object.getRequestRate()
                    )
            );
        }
        if (!stringBuilder.toString().isEmpty()) {
            stringBuilder.append(LINE_SEPARATOR);
        }
        return stringBuilder.toString();
    }
}
