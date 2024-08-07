package hobby.internetms52.robotxtgen;

import hobby.internetms52.robotxtgen.exception.FileWriterException;
import hobby.internetms52.robotxtgen.util.RichCustomLogger;

import java.nio.file.Files;
import java.nio.file.Path;

public class RobotTextFileWriter {
    RichCustomLogger logger;

    public RobotTextFileWriter(RichCustomLogger logger) {
        this.logger = logger;
    }

    public void write(Path filePath, String content) throws FileWriterException {
        try {
            Files.writeString(filePath, content);
            logger.info(
                    filePath.toString(),
                    " has been successfully written. "
            );
        } catch (Exception e) {
            logger.error(
                    "An error occurred while writing to the file: ",
                    filePath.toString(),
                    ", exception:",
                    e.getMessage()
            );
            throw new FileWriterException(e);
        }
    }
}
