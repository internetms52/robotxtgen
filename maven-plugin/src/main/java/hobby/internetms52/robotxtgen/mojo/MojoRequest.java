package hobby.internetms52.robotxtgen.mojo;

import org.apache.maven.project.MavenProject;

public class MojoRequest {
    MavenProject mavenProject;
    String configClass;
    String scanScope;

    public MojoRequest(MavenProject mavenProject, String configClass, String scanScope) {
        this.mavenProject = mavenProject;
        this.configClass = configClass;
        this.scanScope = scanScope;
    }

    public MavenProject getMavenProject() {
        return mavenProject;
    }

    public void setMavenProject(MavenProject mavenProject) {
        this.mavenProject = mavenProject;
    }

    public String getConfigClass() {
        return configClass;
    }

    public void setConfigClass(String configClass) {
        this.configClass = configClass;
    }

    public String getScanScope() {
        return scanScope;
    }

    public void setScanScope(String scanScope) {
        this.scanScope = scanScope;
    }
}
