package hobby.internetms52.robotxtgen.text_gen;

import java.util.List;

public class HostTextGenerator implements TextGen<List<String>> {
    @Override
    public String gen(List<String> hosts) {
        StringBuilder stringBuilder = new StringBuilder();
        hosts.forEach(host -> {
            stringBuilder.append(keyValuePairGenText(RobotTextFields.Host.value, host));
        });
        return stringBuilder.toString();
    }
}
