package logic;

import config.Configuration;
import logic.roles.projectroles.Member;
import logic.roles.taskroles.Supervisor;
import logic.roles.taskroles.Worker;
import logic.schemes.job.Job;
import logic.schemes.job.JobFactory;
import logic.schemes.project.Project;
import logic.schemes.project.ProjectFactory;
import logic.schemes.task.Task;
import logic.schemes.task.TaskFactory;
import logic.roles.projectroles.Leader;
import logic.roles.RoleFactory;
import logic.login.User;

import javax.jws.soap.SOAPBinding;

/**
 * A factory for creating default objects.
 * Has a Configuration object from where it retrieves the default settings from.
 */
public class DefaultFactory {

    private final ProjectFactory projectFactory;
    private final TaskFactory taskFactory;
    private final Configuration configuration;
    private final RoleFactory roleFactory;
    private JobFactory jobFactory;

    /**
     * With no passed in parameters the default factory uses a new Configuration object.
     *
     * @throws Exception if there was a problem loading the configuration file.
     */
    public DefaultFactory() throws Exception {
        this.configuration = new Configuration();
        this.projectFactory = new ProjectFactory(this.configuration);
        this.taskFactory = new TaskFactory(this.configuration);
        this.roleFactory = new RoleFactory(this.configuration);
        this.jobFactory = new JobFactory(this.configuration);
    }

    /**
     * Initializes the factory with existing configuration.
     *
     * @param configuration Configuration to be used in the factory.
     */
    public DefaultFactory(Configuration configuration) {
        this.configuration = configuration;
        this.projectFactory = new ProjectFactory(this.configuration);
        this.taskFactory = new TaskFactory(this.configuration);
        this.roleFactory = new RoleFactory(this.configuration);
        this.jobFactory = new JobFactory(this.configuration);
    }

    /**
     * Gets configuration object.
     *
     * @return Configuration the factory currently holds.
     */
    public Configuration getConfig() {
        return this.configuration;
    }

    /**
     * Creates a new project with default values.
     *
     * @return Project with default values.
     */
    public Project createProject() {
        return this.projectFactory.createScheme();
    }

    /**
     * Creates a new project with given name and default values.
     *
     * @param name String containing a name.
     *
     * @return Project with name.
     */
    public Project createProject(String name) {
        return this.projectFactory.createScheme(name);
    }

    /**
     * Creates a new task with default values.
     *
     * @return Task with default values.
     */
    public Task createTask() {
        return this.taskFactory.createScheme();
    }

    /**
     * Creates a new job with default values.
     *
     * @return Job with default values.
     */
    public Job createJob() {
        return this.jobFactory.createScheme();
    }

    /**
     * Creates a new user with default values loaded from configuration.
     *
     * @return User with default values.
     */
    public User createUser() {
        User user = new User(configuration.getUserName(), configuration.getUserPassword());
        return user;
    }

    /**
     * Creates a new leader with default values loaded from configuration.
     *
     * @param user User to be associated with the new Leader role.
     * @param project Project to be associated with the new Leader role.
     *
     * @return Leader with default values.
     */
    public Leader createLeader(User user, Project project) {
        return this.roleFactory.createLeader(user, project);
    }

    /**
     * Creates a member with new default user and associates it with the given project.
     *
     * @param project Project to be associated with the new Member role.
     *
     * @return Member with new default user.
     */
    public Member createMember(Project project) {
        User user = createUser();
        return createMember(user, project);
    }

    /**
     * Creates a new member with default values loaded from configuration.
     *
     * @param user User to be associated with the new Member role.
     * @param project Project to be associated with the new Member role.
     *
     * @return Member with default values.
     */
    public Member createMember(User user, Project project) {
        return this.roleFactory.createMember(user, project);
    }

    /**
     * Creates a new Supervisor with default values loaded from configuration.
     *
     * @param user User to be associated with the new Supervisor role.
     * @param task Task to be associated with the new Supervisor role.
     *
     * @return Supervisor with default values.
     */
    public Supervisor createSupervisor(User user, Task task) {
        return this.roleFactory.createSupervisor(user, task);
    }

    /**
     * Creates a worker with new default user and associates it with the given task.
     *
     * @param task Task to be associated with.
     *
     * @return Worker loaded with default user and associated with given task.
     */
    public Worker createWorker(Task task) {
        return this.roleFactory.createWorker(createUser(), task);
    }

    /**
     * Creates a worker with user associated with the given task.
     *
     * @param user User associated with the worker.
     * @param task Task to be associated with worker.
     *
     * @return Worker loaded with default user and associated with given task.
     */
    public Worker createWorker(User user, Task task) {
        return this.roleFactory.createWorker(user, task);
    }
}
