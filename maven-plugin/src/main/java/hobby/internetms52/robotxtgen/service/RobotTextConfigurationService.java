package hobby.internetms52.robotxtgen.service;

import hobby.internetms52.robotxtgen.RobotTextDataInstance;
import hobby.internetms52.robotxtgen.config.RobotTextGenConfig;
import hobby.internetms52.robotxtgen.exception.ConfigClassNotFoundException;
import hobby.internetms52.robotxtgen.exception.InvalidRobotTextGenConfiguration;
import hobby.internetms52.robotxtgen.exception.RobotTextConfigProviderFetchException;
import hobby.internetms52.robotxtgen.mojo.MojoClassLoader;
import hobby.internetms52.robotxtgen.mojo.MojoRequest;
import hobby.internetms52.robotxtgen.util.ListUtil;
import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.plugin.MojoExecutionException;

import java.util.Optional;

public class RobotTextConfigurationService {
    private final RobotTextDataInstanceExtractService robotTextDataInstanceExtractService = new RobotTextDataInstanceExtractService();
    private final MojoClassLoader mojoClassLoader = new MojoClassLoader();

    public RobotTextGenConfig execute(MojoRequest mojoRequest) throws ConfigClassNotFoundException, RobotTextConfigProviderFetchException, MojoExecutionException, InvalidRobotTextGenConfiguration, DependencyResolutionRequiredException {
        String outputDirectory = mojoRequest.getMavenProject().getBuild().getOutputDirectory();
        Optional<Class<?>> resultClazzOpt = Optional.empty();
        if (mojoRequest.getScanScope().equalsIgnoreCase("test")) {
            resultClazzOpt = mojoClassLoader.load(
                    ListUtil.nullFilter(mojoRequest.getMavenProject().getTestClasspathElements()),
                    mojoRequest.getConfigClass()
            );
        } else {
            resultClazzOpt = mojoClassLoader.load(
                    ListUtil.nullFilter(mojoRequest.getMavenProject().getCompileClasspathElements()),
                    mojoRequest.getConfigClass()
            );
        }
        if (resultClazzOpt.isPresent()) {
            RobotTextDataInstance robotTextDataInstance = robotTextDataInstanceExtractService.execute(resultClazzOpt.get());
            return new RobotTextGenConfig(outputDirectory, robotTextDataInstance);
        } else {
            throw new InvalidRobotTextGenConfiguration();
        }
    }

}
