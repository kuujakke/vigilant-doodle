package logic.schemes.project;

import config.Configuration;

/**
 * A factory for creating projects.
 * Has a Configuration object from where it retrieves the default settings from.
 */
public class ProjectFactory {

    private Configuration configuration;

    public ProjectFactory() throws Exception {
        this.configuration =new Configuration();
    }

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
