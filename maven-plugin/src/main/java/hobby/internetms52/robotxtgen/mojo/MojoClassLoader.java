package hobby.internetms52.robotxtgen.mojo;

import hobby.internetms52.robotxtgen.util.NativeLogger;
import org.apache.maven.plugin.MojoExecutionException;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MojoClassLoader {
    private final NativeLogger nativeLogger = new NativeLogger(MojoClassLoader.class);

    private Optional<Class<?>> load(String classPath, String className) throws MojoExecutionException {
        Optional<Class<?>> resultOpt = Optional.empty();
        try {
            List<URL> classpathURLs = new ArrayList<>();

            try {
                classpathURLs.add(new File(classPath).toURI().toURL());
            } catch (MalformedURLException e) {
                throw new MojoExecutionException("Error converting classpath element to URL: " + classPath, e);
            }

            URLClassLoader classLoader = new URLClassLoader(classpathURLs.toArray(new URL[0]));
            List<Class<?>> classes = findClasses(classLoader);

            for (Class<?> clazz : classes) {
                if (clazz.getName().contains(className)) {
                    nativeLogger.info("Found test class: ", clazz.getName());
                    resultOpt = Optional.of(clazz);
                    break;
                }
            }
        } catch (Exception e) {
            throw new MojoExecutionException("Error scanning classes", e);
        }
        return resultOpt;
    }

    public Optional<Class<?>> load(List<String> classpathElements, String className) throws MojoExecutionException {
        Optional<Class<?>> resultOpt = Optional.empty();
        try {
            for (String classpathElement : classpathElements) {
//                resultOpt = load(classpathElement, className);
                System.out.println(classpathElement);
                if (resultOpt.isPresent()) {
                    break;
                }
            }
        } catch (Exception e) {
            throw new MojoExecutionException("Error scanning classes", e);
        }
        return resultOpt;
    }

    private List<Class<?>> findClasses(URLClassLoader classLoader) throws Exception {
        List<Class<?>> classes = new ArrayList<>();

        for (URL url : classLoader.getURLs()) {
            File file = new File(url.toURI());
            if (file.isDirectory()) {
                classes.addAll(findClassesInDirectory(file, "", classLoader));
            }
        }

        return classes;
    }

    private List<Class<?>> findClassesInDirectory(File directory, String packageName, URLClassLoader classLoader) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }

        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                classes.addAll(findClassesInDirectory(file, packageName + file.getName() + ".", classLoader));
            } else if (file.getName().endsWith(".class")) {
                String className = packageName + file.getName().substring(0, file.getName().length() - 6);
                Class<?> clazz = classLoader.loadClass(className);
                classes.add(clazz);
            }
        }

        return classes;
    }

}
