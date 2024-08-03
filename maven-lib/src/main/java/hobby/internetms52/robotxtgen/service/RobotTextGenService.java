package hobby.internetms52.robotxtgen.service;

import hobby.internetms52.robotxtgen.RobotTextFileWriter;
import hobby.internetms52.robotxtgen.config.RobotTextGenConfig;
import hobby.internetms52.robotxtgen.exception.FileWriterException;
import hobby.internetms52.robotxtgen.exception.InvalidOutputDirectoryException;
import hobby.internetms52.robotxtgen.text_gen.RobotTextContentGenerator;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RobotTextGenService {
    private final RobotTextContentGenerator robotTextContentGenerator = new RobotTextContentGenerator();
    private final RobotTextFileWriter robotTextFileWriter = new RobotTextFileWriter();

    public void execute(RobotTextGenConfig robotTextGenConfig) throws InvalidOutputDirectoryException, FileWriterException {
        String content = robotTextContentGenerator.gen(robotTextGenConfig.getRobotTextDataInstance());
        Path filePath = Paths.get(robotTextGenConfig.getTxtGenPath());
        if (!robotTextGenConfig.getTxtGenPath().isEmpty()) {
            robotTextFileWriter.write(filePath, content);
        } else {
            throw new InvalidOutputDirectoryException();
        }
    }
}
