package logic.schemes.job;

import logic.schemes.Scheme;
import logic.roles.Role;

/**
 * Base object to keep track of a job being done in a task.
 */

public class Job extends Scheme {

    private Role worker;

    public Job(String name) {
        super(name);
    }

    public Role getWorker() {
        return this.worker;
    }

    public void setWorker(Role worker) {
        this.worker = worker;
    }
}