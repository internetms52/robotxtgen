package hobby.internetms52.robotxtgen.config;

import hobby.internetms52.robotxtgen.RobotTextDataInstance;

public class RobotTextGenConfig {
    String txtGenPath;
    RobotTextDataInstance robotTextDataInstance;

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