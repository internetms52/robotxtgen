package hobby.internetms52.robotxtgen.mojo;

import hobby.internetms52.robotxtgen.util.NativeLogger;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MojoClassLoader {
    private final NativeLogger nativeLogger = new NativeLogger(MojoClassLoader.class);

    public void scanPackages(MavenProject project, String className) throws MojoExecutionException {
        try {
            List<?> classpathElements = project.getCompileClasspathElements();
            List<String> classpathStrings = classpathElements.stream()
                    .filter(Objects::nonNull)
                    .map(Object::toString)
                    .collect(Collectors.toList());
            List<URL> classpathURLs = new ArrayList<>();

            for (String element : classpathStrings) {
                try {
                    classpathURLs.add(new File(element).toURI().toURL());
                } catch (MalformedURLException e) {
                    throw new MojoExecutionException("Error converting classpath element to URL: " + element, e);
                }
            }

            URLClassLoader classLoader = new URLClassLoader(classpathURLs.toArray(new URL[0]));
            List<Class<?>> classes = findClasses(classLoader);

            for (Class<?> clazz : classes) {
                if (clazz.getName().contains("Test")) {
                    nativeLogger.info("Found test class: ", clazz.getName());
                }
            }
        } catch (Exception e) {
            throw new MojoExecutionException("Error scanning classes", e);
        }
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
