package logic.schemes.project;

import config.Configuration;
import logic.schemes.SchemeFactory;

/**
 * A factory for creating projects.
 * Has a Configuration object from where it retrieves the default settings from.
 */
public class ProjectFactory implements SchemeFactory {

    private Configuration configuration;

    /**
     * Initializes a new configuration from the configuration file or loads defaults.
     *
     * @param configuration Configuration to be used with factory.
     */
    public ProjectFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * Creates a new project with the given project name.
     *
     * @param projectName String projects name to be passed to the constructor.
     * @return Project created with the given name.
     */
    @Override
    public Project createScheme(String projectName) {
        return new Project(projectName);
    }

    /**
     * Creates a new project with the given project name and description.
     *
     * @param name String containing the new projects name
     * @param description String containing the new projects description
     *
     * @return Project the created project.
     */
    @Override
    public Project createScheme(String name, String description) {
        Project project = new Project(this.configuration.getProjectName());
        project.setDescription(this.configuration.getProjectDescription());
        return project;
    }

    /**
     * Creates a new project with the default settings got from the configuration object.
     *
     * @return Project with default values as name and description.
     */
    @Override
    public Project createScheme() {
        return createScheme(
                this.configuration.getProjectName(),
                this.configuration.getProjectDescription());
    }
}
