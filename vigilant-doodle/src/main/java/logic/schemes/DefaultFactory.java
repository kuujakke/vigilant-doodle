package logic.schemes;

import config.Configuration;
import logic.schemes.project.Project;
import logic.schemes.project.ProjectFactory;
import logic.schemes.task.Task;
import logic.schemes.task.TaskFactory;
import logic.roles.projectroles.Leader;
import logic.roles.RoleFactory;
import logic.login.User;

/**
 * Created by kuujakke on 2.1.2017.
 */
public class DefaultFactory {

    private final ProjectFactory projectFactory;
    private final TaskFactory taskFactory;
    private final Configuration configuration;
    private final RoleFactory roleFactory;

    public DefaultFactory() {
        this.configuration = new Configuration();
        this.projectFactory = new ProjectFactory();
        this.taskFactory = new TaskFactory();
        this.roleFactory = new RoleFactory();
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
}
