package hobby.internetms52.robotxtgen.mojo;

import hobby.internetms52.robotxtgen.RobotTextDataInstance;
import hobby.internetms52.robotxtgen.config.RobotTextGenConfig;
import hobby.internetms52.robotxtgen.exception.InvalidOutputDirectoryException;
import hobby.internetms52.robotxtgen.service.RobotTextGenService;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name = "generate-robotstxt", defaultPhase = LifecyclePhase.GENERATE_RESOURCES)
public class RobotTextGenMojo extends AbstractMojo {
    public final Log log = getLog();
    private final RobotTextGenService robotTextGenService = new RobotTextGenService();
    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            String sourceDirectory = project.getBuild().getSourceDirectory();
            String outputDirectory = project.getBuild().getOutputDirectory();
            RobotTextGenConfig robotTextGenConfig = new RobotTextGenConfig(outputDirectory);
            robotTextGenService.execute(robotTextGenConfig, new RobotTextDataInstance());
            log.info("Source Directory:" + sourceDirectory);
        } catch (InvalidOutputDirectoryException ex) {
            log.error("invalid output directory:" + project.getBuild().getOutputDirectory());
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}
