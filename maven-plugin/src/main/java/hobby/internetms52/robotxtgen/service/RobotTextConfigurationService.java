package hobby.internetms52.robotxtgen.service;

import hobby.internetms52.robotxtgen.RobotTextDataInstance;
import hobby.internetms52.robotxtgen.config.RobotTextGenConfig;
import hobby.internetms52.robotxtgen.exception.ConfigClassNotFoundException;
import hobby.internetms52.robotxtgen.exception.RobotTextConfigProviderFetchException;
import hobby.internetms52.robotxtgen.mojo.MojoRequest;

public class RobotTextConfigurationService {
    private final RobotTextDataInstanceExtractService robotTextDataInstanceExtractService = new RobotTextDataInstanceExtractService();

    public RobotTextGenConfig execute(MojoRequest mojoRequest) throws ConfigClassNotFoundException, RobotTextConfigProviderFetchException {
        String outputDirectory = mojoRequest.getMavenProject().getBuild().getOutputDirectory();
        RobotTextDataInstance robotTextDataInstance = robotTextDataInstanceExtractService.execute(mojoRequest.getConfigClass());
        return new RobotTextGenConfig(outputDirectory, robotTextDataInstance);
    }

}
