package hobby.internetms52.robotxtgen.mojo.class_loader;

/**
 * Defines a loader for loading classes from a specific compiled directory.
 * <p>
 * Implementations of this interface should provide concrete methods for
 * loading compiled classes using the Maven output directory and the full class path.
 * They should also handle how the loaded classes are instantiated.
 * </p>
 *
 * @since 1.0
 */
public interface MojoClassLoader {
    /**
     * Loads a class from the specified output directory.
     *
     * @param outputDirectory The Maven output directory containing the compiled classes
     * @param fullClassPath The fully qualified name of the class to load
     * @return The loaded Class object
     * @throws ClassNotFoundException If the specified class cannot be found or loaded
     */
    Class<?> load(String outputDirectory, String fullClassPath) throws ClassNotFoundException;
}
