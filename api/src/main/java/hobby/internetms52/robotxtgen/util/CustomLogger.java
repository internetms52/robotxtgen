package hobby.internetms52.robotxtgen.util;

import java.util.Arrays;

public interface CustomLogger {
    default String strBinder(String... msg) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(msg).forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    void debug(String... msg);

    void info(String... msg);

    void error(String... msg);
}
