package hobby.internetms52.robotxtgen.mojo.class_loader;

import hobby.internetms52.robotxtgen.util.NativeLogger;
import hobby.internetms52.robotxtgen.util.RichCustomLogger;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.annotation.Native;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Loads a compiled class from a specified output directory.
 */
public class GeneralMojoClassLoader implements MojoClassLoader {
    private final RichCustomLogger logger = new RichCustomLogger(new NativeLogger(GeneralMojoClassLoader.class));
    private final FileSystemFileLoader fileSystemFileLoader = new FileSystemFileLoader();

    /**
     * Loads a compiled class from a specified output directory.
     *
     * @param outputDirectory The directory containing the compiled classes
     * @param fullClassPath   The fully qualified name of the class to load
     * @return The loaded Class object
     * @throws ClassNotFoundException If the specified class cannot be found
     */
    @Override
    public Class<?> load(String outputDirectory, String fullClassPath) throws ClassNotFoundException {
        try {
            File classesDirectory = fileSystemFileLoader.load(outputDirectory);
            // 創建 URL 類加載器
            URL[] urls = new URL[]{classesDirectory.toURI().toURL()};
            try (URLClassLoader classLoader = new URLClassLoader(urls, this.getClass().getClassLoader())) {
                // 使用類加載器加載特定的類
                Class<?> loadedClass = classLoader.loadClass(fullClassPath);
                logger.debug("Classes directory: ", outputDirectory);
                return loadedClass;
            } catch (Exception ex) {
                logger.error(ex, "GeneralMojoClassLoader.load()");
            }
        } catch (FileNotFoundException fileNotFoundException) {
            logger.error(fileNotFoundException, outputDirectory);
        } catch (Exception ex) {
            logger.error(ex, "GeneralMojoClassLoader.load()");
        }
        logger.error("Class Not Found in directory: ", outputDirectory, ",full class path:", fullClassPath);
        throw new ClassNotFoundException();
    }
}
