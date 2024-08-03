package hobby.internetms52.robotxtgen.service;

import hobby.internetms52.robotxtgen.RobotTextDataInstance;
import hobby.internetms52.robotxtgen.config.RobotTextGenConfig;
import hobby.internetms52.robotxtgen.exception.ConfigClassNotFoundException;
import hobby.internetms52.robotxtgen.exception.RobotTextConfigProviderFetchException;
import org.apache.maven.project.MavenProject;

public class RobotTextConfigurationService {
    private final RobotTextDataInstanceExtractService robotTextDataInstanceExtractService = new RobotTextDataInstanceExtractService();

    public RobotTextGenConfig execute(MavenProject project, String configClass) throws ConfigClassNotFoundException, RobotTextConfigProviderFetchException {
        String outputDirectory = project.getBuild().getOutputDirectory();
        RobotTextDataInstance robotTextDataInstance = robotTextDataInstanceExtractService.execute(configClass);
        return new RobotTextGenConfig(outputDirectory, robotTextDataInstance);
    }

}
