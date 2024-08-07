package hobby.internetms52.robotxtgen.service;

import hobby.internetms52.robotxtgen.RobotTextFileWriter;
import hobby.internetms52.robotxtgen.config.RobotTextGenConfig;
import hobby.internetms52.robotxtgen.exception.FileWriterException;
import hobby.internetms52.robotxtgen.exception.InvalidOutputDirectoryException;
import hobby.internetms52.robotxtgen.text_gen.RobotTextContentGenerator;
import hobby.internetms52.robotxtgen.util.RichCustomLogger;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RobotTextGenService {
    RichCustomLogger logger;

    public RobotTextGenService(RichCustomLogger logger) {
        this.logger = logger;
    }

    private final RobotTextContentGenerator robotTextContentGenerator = new RobotTextContentGenerator();

    public void execute(RobotTextGenConfig robotTextGenConfig) throws InvalidOutputDirectoryException, FileWriterException {
        RobotTextFileWriter robotTextFileWriter = new RobotTextFileWriter(logger);
        String content = robotTextContentGenerator.gen(robotTextGenConfig.getRobotTextDataInstance());
        logger.info("Robots.txt Content: \n" + content);
        if (!robotTextGenConfig.getTxtGenPath().isEmpty()) {
            Path filePath = Paths.get(robotTextGenConfig.getTxtGenPath());
            robotTextFileWriter.write(filePath, content);
        } else {
            throw new InvalidOutputDirectoryException();
        }
    }
}
