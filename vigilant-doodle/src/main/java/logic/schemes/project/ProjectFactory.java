package logic.schemes.project;

import config.Configuration;

/**
 * Created by kuujakke on 30.12.2016.
 */
public class ProjectFactory {

    private Configuration configuration = new Configuration();

    public Project createProject(String projectName) {
        return new Project(projectName);
    }

    public Project createProject(String name, String description) {
        Project project = new Project(this.configuration.getProjectName());
        project.setDescription(this.configuration.getProjectDescription());
        return project;
    }

    public Project createProject() {
        return new Project(this.configuration.getProjectName());
    }
}
