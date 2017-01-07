package logic.roles;

import config.Configuration;
import logic.login.User;
import logic.roles.projectroles.Leader;
import logic.roles.projectroles.Member;
import logic.roles.taskroles.Supervisor;
import logic.roles.taskroles.Worker;
import logic.schemes.project.Project;
import logic.schemes.task.Task;

/**
 * A class for creating various roles for projects, tasks and job.
 */
public class RoleFactory {

    private Configuration configuration;

    /**
     * Initializes the configuration variable with the passed Configuration.
     *
     * @param configuration Configuration containing the application settings.
     */
    public RoleFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * Creates a new leader role to the project with the given user account.
     *
     * @param user User account to which the leader role is associated with
     * @param project Project to which the new leader is added to.
     *
     * @return Leader containing associations to user and project.
     */
    public Leader createLeader(User user, Project project) {
        Leader leader = new Leader(user, project);
        return leader;
    }

    /**
     * Creates a new member role to the project with the given user account.
     *
     * @param user User account to which the member role is associated with.
     * @param project Project to which the new member is added to.
     *
     * @return Member containing associations to user and project.
     */
    public Member createMember(User user, Project project) {
        return new Member(user, project);
    }

    /**
     * Creates a new Worker role to the task with the given user account.
     *
     * @param user User account to which the worker role is associated with.
     * @param task Task to which the new worker is added to.
     *
     * @return Worker containing associations to user and task.
     */
    public Worker createWorker(User user, Task task) {
        return new Worker(user, task);
    }

    /**
     * Creates a new Supervisor to the task with the given user account.
     *
     * @param user User account to which the supervisor is associated with.
     * @param task Task to which the new Supervisor is added to.
     *
     * @return Supervisor containing associations to user and task.
     */
    public Supervisor createSupervisor(User user, Task task) {
        return new Supervisor(user, task);
    }


}
