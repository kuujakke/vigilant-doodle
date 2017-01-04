package logiikka;

import config.Configuration;

/**
 * Created by kuujakke on 30.12.2016.
 */
public class ProjectFactory {

    private Configuration configuration = new Configuration();

    public Project createProject(String projectName) {
        if (projectName.isEmpty() || projectName.length() > 0) {
            return new Project(this.configuration.getProjectName());
        }
        return new Project(projectName);
    }

    public Project createProject() {
        return new Project(this.configuration.getProjectName());
    }
}
