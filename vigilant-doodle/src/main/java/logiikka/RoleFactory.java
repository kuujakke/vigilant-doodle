package logiikka;

/**
 * Created by kuujakke on 30.12.2016.
 */
public class RoleFactory {

    public Leader createLeader(User user) {
        return new Leader(user);
    }

    public Member createMember(User user) {
        return new Member(user);
    }

    public Worker createWorker(User user ) {
        return new Worker(user);
    }

    public Supervisor createSupervisor(User user) {
        return new Supervisor(user);
    }
}
