package logic.schemes;

import config.Configuration;
import logic.roles.projectroles.Member;
import logic.schemes.project.Project;
import logic.schemes.project.ProjectFactory;
import logic.schemes.task.Task;
import logic.schemes.task.TaskFactory;
import logic.roles.projectroles.Leader;
import logic.roles.RoleFactory;
import logic.login.User;

/**
 * A factory for creating default objects.
 * Has a Configuration object from where it retrieves the default settings from.
 */
public class DefaultFactory {

    private final ProjectFactory projectFactory;
    private final TaskFactory taskFactory;
    private final Configuration configuration;
    private final RoleFactory roleFactory;

    public DefaultFactory() throws Exception {
        this.configuration = new Configuration();
        this.projectFactory = new ProjectFactory(this.configuration);
        this.taskFactory = new TaskFactory(this.configuration);
        this.roleFactory = new RoleFactory(this.configuration);
    }

    public Project createProject() {
        return this.projectFactory.createProject(configuration.getProjectName());
    }

    public Task createTask() {
        return this.taskFactory.createTask(configuration.getTaskName());
    }

    public User createUser() {
        return new User(configuration.getUserName(), configuration.getUserPassword());
    }

    public Leader createLeader(User user, Project project) {
        return this.roleFactory.createLeader(user, project);
    }

    public Configuration getConfig() {
        return this.configuration;
    }

    public Member createMember(User user, Project project) {
        return this.roleFactory.createMember(user, project);
    }
}
