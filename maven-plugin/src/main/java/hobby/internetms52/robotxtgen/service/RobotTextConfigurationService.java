package hobby.internetms52.robotxtgen.service;

import hobby.internetms52.robotxtgen.RobotTextDataInstance;
import hobby.internetms52.robotxtgen.config.RobotTextGenConfig;
import hobby.internetms52.robotxtgen.exception.ConfigClassNotFoundException;
import hobby.internetms52.robotxtgen.exception.InvalidRobotTextGenConfiguration;
import hobby.internetms52.robotxtgen.exception.RobotTextConfigProviderFetchException;
import hobby.internetms52.robotxtgen.mojo.MojoRequest;
import hobby.internetms52.robotxtgen.mojo.class_loader.GeneralMojoClassLoader;
import hobby.internetms52.robotxtgen.mojo.class_loader.MojoClassLoader;
import hobby.internetms52.robotxtgen.util.ListUtil;
import org.apache.maven.artifact.DependencyResolutionRequiredException;

public class RobotTextConfigurationService {
    private final String FILE_NAME = "robots.txt";
    private final RobotTextDataInstanceExtractService robotTextDataInstanceExtractService = new RobotTextDataInstanceExtractService();
    private final MojoClassLoader mojoClassLoader = new GeneralMojoClassLoader();

    public RobotTextGenConfig execute(MojoRequest mojoRequest) throws ConfigClassNotFoundException, RobotTextConfigProviderFetchException, InvalidRobotTextGenConfiguration, DependencyResolutionRequiredException, ClassNotFoundException {
        Class<?> clazz;
        if (mojoRequest.getScanScope().equalsIgnoreCase("test")) {
            ListUtil.nullFilter(mojoRequest.getMavenProject().getTestClasspathElements()).forEach(System.out::println);
            clazz = mojoClassLoader.load(
                    mojoRequest.getMavenProject().getTestClasspathElements().get(0),
                    mojoRequest.getConfigClass()
            );
        } else {
            ListUtil.nullFilter(mojoRequest.getMavenProject().getCompileClasspathElements()).forEach(System.out::println);
            clazz = mojoClassLoader.load(
                    mojoRequest.getMavenProject().getCompileClasspathElements().get(0),
                    mojoRequest.getConfigClass()
            );
        }
        RobotTextDataInstance robotTextDataInstance = robotTextDataInstanceExtractService.execute(clazz);
        String robotTextGenPath = mojoRequest.getMavenProject().getBuild().getDirectory() + "/" + FILE_NAME;
        return new RobotTextGenConfig(robotTextGenPath, robotTextDataInstance);
    }
}
