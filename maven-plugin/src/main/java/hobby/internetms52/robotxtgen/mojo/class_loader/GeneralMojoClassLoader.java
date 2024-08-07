package hobby.internetms52.robotxtgen.mojo.class_loader;

import hobby.internetms52.robotxtgen.util.NativeLogger;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class GeneralMojoClassLoader implements MojoClassLoader {
    private final NativeLogger logger = new NativeLogger(GeneralMojoClassLoader.class);

    @Override
    public Class<?> load(String outputDirectory, String fullClassPath) throws ClassNotFoundException {
        try {
            File classesDirectory = new File(outputDirectory);
            // 創建 URL 類加載器
            URL[] urls = new URL[]{classesDirectory.toURI().toURL()};
            URLClassLoader classLoader = new URLClassLoader(urls, this.getClass().getClassLoader());
            // 使用類加載器加載特定的類
            Class<?> loadedClass = classLoader.loadClass(fullClassPath);
            logger.info("Classes directory: ", outputDirectory);
            return loadedClass;
        } catch (Exception e) {
            logger.error("Class Not Found in directory: ", outputDirectory, ",full class path:", fullClassPath);
            throw new ClassNotFoundException();
        }
    }
}
