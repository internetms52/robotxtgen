package hobby.internetms52.robotxtgen.util;

import java.util.List;

public class RichCustomLogger implements CustomLogger {
    CustomLogger customLogger;

    public RichCustomLogger(CustomLogger customLogger) {
        this.customLogger = customLogger;
    }

    private String[] insertAtBeginning(String[] original, String newElement) {
        String[] newArray = new String[original.length + 1];
        newArray[0] = newElement;
        System.arraycopy(original, 0, newArray, 1, original.length);
        return newArray;
    }

    public void error(Exception ex, String... msg) {
        List<String> msgList = new java.util.ArrayList<>(List.of(msg));
        msgList.add(0, ex.getClass().getName());
        customLogger.error(msgList.toArray(new String[]{}));
    }

    @Override
    public void debug(String... msg) {
        customLogger.debug(msg);
    }

    @Override
    public void info(String... msg) {
        customLogger.info(msg);
    }

    @Override
    public void error(String... msg) {
        customLogger.error(msg);
    }
}
