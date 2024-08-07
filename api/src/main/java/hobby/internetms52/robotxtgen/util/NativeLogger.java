package hobby.internetms52.robotxtgen.util;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NativeLogger implements CustomLogger {
    private final Logger logger;

    public NativeLogger(Class<?> clazz) {
        logger = Logger.getLogger(clazz.getName());
    }

    public void debug(String... msg) {
        logger.log(Level.FINE, strBinder(msg));
    }

    public void info(String... msg) {
        logger.info(strBinder(msg));
    }

    public void error(Exception ex) {
        error(ex.getClass().getName(), "|", ex.getMessage());
    }

    public void error(String... msg) {
        logger.warning(strBinder(msg));
    }


}
