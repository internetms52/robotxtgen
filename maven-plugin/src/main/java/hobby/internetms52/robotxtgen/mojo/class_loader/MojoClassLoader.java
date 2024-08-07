package hobby.internetms52.robotxtgen.mojo.class_loader;

public interface MojoClassLoader {
    Class<?> load(String outputDirectory, String fullClassPath) throws ClassNotFoundException;
}
