package hobby.internetms52.robotxtgen.mojo;

import hobby.internetms52.robotxtgen.config.RobotTextGenConfig;
import hobby.internetms52.robotxtgen.exception.*;
import hobby.internetms52.robotxtgen.service.RobotTextConfigurationService;
import hobby.internetms52.robotxtgen.service.RobotTextGenService;
import hobby.internetms52.robotxtgen.util.MavenPluginLogger;
import hobby.internetms52.robotxtgen.util.RichCustomLogger;
import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name = "generate-robotstxt", defaultPhase = LifecyclePhase.COMPILE)
public class RobotTextGenMojo extends AbstractMojo {
    private final RichCustomLogger logger = new RichCustomLogger(new MavenPluginLogger(getLog()));
    private final RobotTextConfigurationService robotTextConfigurationService = new RobotTextConfigurationService();
    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    private MavenProject project;
    @Parameter(property = "configClass", required = true, readonly = true)
    private String configClass;
    @Parameter(property = "scanScope", readonly = true, defaultValue = "main")
    private String scanScope;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            RobotTextGenService robotTextGenService = new RobotTextGenService(logger);
            MojoRequest mojoRequest = new MojoRequest(project, configClass, scanScope);
            logger.info("Config Class: ", configClass, ", scanScope: ", scanScope);
            RobotTextGenConfig robotTextGenConfig = robotTextConfigurationService.execute(mojoRequest);
            robotTextGenService.execute(robotTextGenConfig);
        } catch (ClassNotFoundException e) {
            logger.error("ClassNotFoundException:" + configClass);
        } catch (DependencyResolutionRequiredException e) {
            logger.error("DependencyResolutionRequiredException:" + configClass);
        } catch (InvalidRobotTextGenConfiguration e) {
            logger.error("InvalidRobotTextGenConfiguration:" + configClass);
        } catch (RobotTextConfigProviderFetchException e) {
            logger.error("RobotTextConfigProviderFetchException:" + configClass);
        } catch (ConfigClassNotFoundException e) {
            logger.error("ConfigClassNotFoundException:" + configClass);
        } catch (FileWriterException e) {
            logger.error("FileWriterException:" + project.getBuild().getOutputDirectory());
        } catch (InvalidOutputDirectoryException ex) {
            logger.error("invalid output directory:" + project.getBuild().getOutputDirectory());
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }
}
