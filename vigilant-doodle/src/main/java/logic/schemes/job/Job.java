package logic.schemes.job;

import logic.schemes.Scheme;
import logic.roles.Role;

/**
 * Base object to keep track of a job being done in a task.
 * Holds one worker that is responsible for completing the job.
 */
public class Job extends Scheme {

    private Role worker;

    /**
     * Passes the name to the superclass.
     *
     * @param name String containing the name of the job.
     */
    public Job(String name) {
        super(name);
    }

    /**
     * Returns the worker responsible on the completion of the job.
     *
     * @return Role that is assigned to the job.
     */
    public Role getWorker() {
        return this.worker;
    }

    /**
     * Sets the given worker to be responsible on the completion of the job.
     *
     * @param worker Role that is to be assigned to the job.
     */
    public void setWorker(Role worker) {
        this.worker = worker;
        this.worker.addResponsibility(this);
    }
}