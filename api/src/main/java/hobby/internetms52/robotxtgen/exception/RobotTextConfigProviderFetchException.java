package hobby.internetms52.robotxtgen.exception;

/**
 * Exception thrown when there is a failure in fetching or initializing a RobotTextConfigProvider.
 * This exception is typically thrown in two scenarios:
 * 1. When the constructor for the RobotTextConfigProvider cannot be found.
 * 2. When the creation of a new instance of RobotTextConfigProvider fails.
 *
 * @see hobby.internetms52.robotxtgen.config.RobotTextConfigProvider
 */
public class RobotTextConfigProviderFetchException extends Exception {
    public RobotTextConfigProviderFetchException(Throwable cause) {
        super(cause);
    }
}
