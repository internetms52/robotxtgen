package hobby.internetms52.robotxtgen.mojo;

import org.apache.maven.project.MavenProject;

public class MojoRequest {
    MavenProject mavenProject;
    String configClass;
    String scanDirectory;

    public MojoRequest(MavenProject mavenProject, String configClass, String scanDirectory) {
        this.mavenProject = mavenProject;
        this.configClass = configClass;
        this.scanDirectory = scanDirectory;
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

    public String getScanDirectory() {
        return scanDirectory;
    }

    public void setScanDirectory(String scanDirectory) {
        this.scanDirectory = scanDirectory;
    }
}
