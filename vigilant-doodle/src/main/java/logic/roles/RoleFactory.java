package logic.roles;

import logic.login.User;
import logic.roles.projectroles.Leader;
import logic.roles.projectroles.Member;
import logic.roles.taskroles.Supervisor;
import logic.roles.taskroles.Worker;
import logic.schemes.project.Project;
import logic.schemes.task.Task;

/**
 * A class for creating roles.
 */
public class RoleFactory {

    public Leader createLeader(User user, Project project) {
        Leader leader = new Leader(user, project);
        return leader;
    }

    public Member createMember(User user, Project project) {
        return new Member(user, project);
    }

    public Worker createWorker(User user, Task task) {
        return new Worker(user, task);
    }

    public Supervisor createSupervisor(User user, Task task) {
        return new Supervisor(user, task);
    }


}
