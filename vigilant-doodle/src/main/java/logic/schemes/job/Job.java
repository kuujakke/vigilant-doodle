package logic.schemes.job;

import logic.schemes.Scheme;
import logic.roles.Role;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 * Base object to keep track of a job being done in a task.
 * Holds one worker that is responsible for completing the job.
 */
@Entity("jobs")
public class Job extends Scheme {

    @Reference
    private Role worker;

    /**
     * Passes the name to the superclass.
     *
     * @param name String containing the name of the job.
     */
    public Job(String name) {
        super(name);
    }

    @Override
    public boolean hasScheme(Scheme scheme) {
        return this.equals(scheme);
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

    /**
     * Sets worker to null.
     */
    public void clearWorker() {
        this.worker = null;
    }
}