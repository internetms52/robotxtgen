package hobby.internetms52.robotxtgen.service;

import hobby.internetms52.robotxtgen.RobotTextDataInstance;
import hobby.internetms52.robotxtgen.config.RobotTextConfigProvider;
import hobby.internetms52.robotxtgen.exception.ConfigClassNotFoundException;
import hobby.internetms52.robotxtgen.exception.RobotTextConfigProviderFetchException;
import hobby.internetms52.robotxtgen.util.NativeLogger;

public class RobotTextDataInstanceExtractService {
    private final NativeLogger nativeLogger = new NativeLogger(RobotTextDataInstanceExtractService.class);

    public RobotTextDataInstance execute(Class<?> configClazz) throws RobotTextConfigProviderFetchException {
        // 確認是否實現了特定接口
        if (RobotTextConfigProvider.class.isAssignableFrom(configClazz)) {
            RobotTextConfigProvider robotTextConfigProvider = getRobotTextConfigProviderInstance(configClazz);
            return robotTextConfigProvider.robotTextDataInstance();
        } else {
            // 類沒有實現 RobotsTxtConfigProvider 接口
            throw new IllegalArgumentException("The specified class does not implement RobotTextConfigProvider");
        }
    }

    public RobotTextConfigProvider getRobotTextConfigProviderInstance(Class<?> configClazz) throws RobotTextConfigProviderFetchException {
        try {
            return (RobotTextConfigProvider) configClazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            nativeLogger.error("getRobotTextConfigProviderInstance:", e.getMessage());
            throw new RobotTextConfigProviderFetchException(e);
        }
    }

    public Class<?> getConfigClass(String className) throws ConfigClassNotFoundException {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new ConfigClassNotFoundException();
        }
    }
}
