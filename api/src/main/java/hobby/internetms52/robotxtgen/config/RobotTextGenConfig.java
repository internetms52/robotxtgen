package hobby.internetms52.robotxtgen.config;

import hobby.internetms52.robotxtgen.RobotTextDataInstance;

/**
 * robotxtgen configuration object.
 */
public class RobotTextGenConfig {
    String txtGenPath;
    RobotTextDataInstance robotTextDataInstance;

    /**
     * default constructor
     *
     * @param txtGenPath            generate path.
     * @param robotTextDataInstance data instance.
     */

    public RobotTextGenConfig(String txtGenPath, RobotTextDataInstance robotTextDataInstance) {
        this.txtGenPath = txtGenPath;
        this.robotTextDataInstance = robotTextDataInstance;
    }

    public String getTxtGenPath() {
        return txtGenPath;
    }

    public void setTxtGenPath(String txtGenPath) {
        this.txtGenPath = txtGenPath;
    }

    public RobotTextDataInstance getRobotTextDataInstance() {
        return robotTextDataInstance;
    }

    public void setRobotTextDataInstance(RobotTextDataInstance robotTextDataInstance) {
        this.robotTextDataInstance = robotTextDataInstance;
    }
}