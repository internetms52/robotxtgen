package hobby.internetms52.robotxtgen.mojo.class_loader;

import hobby.internetms52.robotxtgen.util.NativeLogger;
import hobby.internetms52.robotxtgen.util.RichCustomLogger;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * load file from file system.
 */
public class FileSystemFileLoader {
    private final RichCustomLogger logger = new RichCustomLogger(new NativeLogger(FileSystemFileLoader.class));

    /**
     * load file from file path
     *
     * @param filePath String
     * @return File instance
     * @throws FileNotFoundException file not found in path.
     */
    public File load(String filePath) throws FileNotFoundException {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return file;
            }
        } catch (Exception ex) {
            logger.error(ex, "FileSystemFileLoader.load()");
        }
        throw new FileNotFoundException();
    }
}
