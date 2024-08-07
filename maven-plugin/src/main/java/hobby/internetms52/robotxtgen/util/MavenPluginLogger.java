package hobby.internetms52.robotxtgen.util;

import org.apache.maven.plugin.logging.Log;

public class MavenPluginLogger implements CustomLogger {
    Log log;

    public MavenPluginLogger(Log log) {
        this.log = log;
    }

    @Override
    public void debug(String... msg) {
        log.debug(strBinder(msg));
    }

    @Override
    public void info(String... msg) {
        log.info(strBinder(msg));
    }

    @Override
    public void error(String... msg) {
        log.error(strBinder(msg));
    }
}
