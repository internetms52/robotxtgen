package hobby.internetms52.robotxtgen.mojo;

import hobby.internetms52.robotxtgen.config.RobotTextGenConfig;
import hobby.internetms52.robotxtgen.exception.InvalidOutputDirectoryException;
import hobby.internetms52.robotxtgen.service.RobotTextConfigurationService;
import hobby.internetms52.robotxtgen.service.RobotTextGenService;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name = "generate-robotstxt", defaultPhase = LifecyclePhase.COMPILE)
public class RobotTextGenMojo extends AbstractMojo {
    public final Log log = getLog();
    private final RobotTextGenService robotTextGenService = new RobotTextGenService();
    private final RobotTextConfigurationService robotTextConfigurationService = new RobotTextConfigurationService();
    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    private MavenProject project;
    @Parameter(property = "configClass", required = true, readonly = true)
    private String configClass;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            log.info("mojo executed!");
            if (configClass != null) {
                log.info("configClass:" + configClass);
            }
            String sourceDirectory = project.getBuild().getSourceDirectory();
            RobotTextGenConfig robotTextGenConfig = robotTextConfigurationService.execute(project, configClass);
            robotTextGenService.execute(robotTextGenConfig);
            log.info("Source Directory:" + sourceDirectory);
        } catch (InvalidOutputDirectoryException ex) {
            log.error("invalid output directory:" + project.getBuild().getOutputDirectory());
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}