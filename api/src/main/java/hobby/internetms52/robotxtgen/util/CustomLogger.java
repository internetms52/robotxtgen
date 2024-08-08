package hobby.internetms52.robotxtgen.util;

import java.util.Arrays;

/**
 * The design uses a logger interface as a parameter, allowing users to inject their own logger implementation.
 * This achieves dependency inversion.
 */
public interface CustomLogger {

    /**
     * string appender
     * @param msg message
     * @return String
     */
    default String strBinder(String... msg) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(msg).forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    /**
     * original logger's debug function.
     *
     * @param msg message
     */
    void debug(String... msg);

    /**
     * original logger's info function.
     *
     * @param msg message
     */
    void info(String... msg);

    /**
     * original logger's error function.
     *
     * @param msg message
     */
    void error(String... msg);
}
