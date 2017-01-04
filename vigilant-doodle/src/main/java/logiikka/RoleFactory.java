package logiikka;

/**
 * Created by kuujakke on 3.1.2017.
 */
public class RoleFactory {

    public Leader createLeader(User user, Project project) {
        return new Leader(user, project);
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
