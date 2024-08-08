package hobby.internetms52.robotxtgen.util;

import java.util.List;

/**
 * A proxy implementation of CustomLogger that allows injection of custom logger implementations.
 * This class implements the Proxy pattern, providing additional functionality
 * while maintaining the original CustomLogger interface.
 */
public class RichCustomLogger implements CustomLogger {
    CustomLogger customLogger;

    /**
     * for inject custom logger.
     * NativeLogger or MavenPluginLogger
     *
     * @param customLogger class implement CustomLogger interface.
     */
    public RichCustomLogger(CustomLogger customLogger) {
        this.customLogger = customLogger;
    }

    /**
     * insert element to the first position of a original array.
     *
     * @param original
     * @param newElement
     * @return
     */
//    private String[] insertAtBeginning(String[] original, String newElement) {
//        String[] newArray = new String[original.length + 1];
//        newArray[0] = newElement;
//        System.arraycopy(original, 0, newArray, 1, original.length);
//        return newArray;
//    }

    /**
     * Enhanced error logging function that includes exception class name.
     * This method extends the functionality of the original logger's error method.
     *
     * @param ex  The exception to be logged
     * @param msg Additional message strings to be logged
     */
    public void error(Exception ex, String... msg) {
        List<String> msgList = new java.util.ArrayList<>(List.of(msg));
        msgList.add(0, ex.getClass().getName());
        customLogger.error(msgList.toArray(new String[]{}));
    }

    /**
     * Proxy for the original logger's debug function.
     *
     * @param msg message
     */
    @Override
    public void debug(String... msg) {
        customLogger.debug(msg);
    }

    /**
     * Proxy for the original logger's info function.
     *
     * @param msg message
     */
    @Override
    public void info(String... msg) {
        customLogger.info(msg);
    }

    /**
     * Proxy for the original logger's error function.
     *
     * @param msg message
     */
    @Override
    public void error(String... msg) {
        customLogger.error(msg);
    }
}
