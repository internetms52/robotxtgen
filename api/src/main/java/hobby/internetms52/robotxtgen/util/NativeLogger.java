package hobby.internetms52.robotxtgen.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * java.util.logging custom logger implementation.
 */
public class NativeLogger implements CustomLogger {
    private final Logger logger;

    /**
     * target logging class.
     *
     * @param clazz class.
     */
    public NativeLogger(Class<?> clazz) {
        logger = Logger.getLogger(clazz.getName());
    }

    /**
     * proxy of debug function.
     * @param msg message
     */
    public void debug(String... msg) {
        logger.log(Level.FINE, strBinder(msg));
    }

    /**
     * proxy of info function.
     * @param msg message
     */
    public void info(String... msg) {
        logger.info(strBinder(msg));
    }

    /**
     * expanded of error function.
     * @param ex
     */
    public void error(Exception ex) {
        error(ex.getClass().getName(), "|", ex.getMessage());
    }

    /**
     * proxy of error function.
     * @param msg message
     */
    public void error(String... msg) {
        logger.warning(strBinder(msg));
    }


}
