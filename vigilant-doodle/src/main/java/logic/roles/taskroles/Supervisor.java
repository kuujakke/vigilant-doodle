package logic.roles.taskroles;
import logic.login.User;
import logic.schemes.job.Job;
import logic.schemes.task.Task;

import java.util.*;

/**
 * Privileged user role for task.
 */
public class Supervisor extends Worker {

    /**
     * Default constructor which passes the user and task to its superclass.
     *
     * @param user User associated with the Supervisor
     * @param task Task associated with the Supervisor
     */
    public Supervisor(User user, Task task) {
        super(user, task);
    }

    /**
     * Adds worker to the supervised task.
     *
     * @param worker Worker to be added to supervised task
     */
    public void addWorker(Worker worker) {
        super.getTask().addWorker(worker);
    }

    /**
     * Removes worker from the supervised task, if worker exists in it.
     *
     * @param worker Worker to be removed.
     */
    public void removeWorker(Worker worker) {
        if (super.getTask().hasWorker(worker)) {
            super.getTask().removeWorker(worker);
        }
    }

    /**
     * Adds a new job to the supervised task with a given name.
     *
     * @param name String containing the jobs name.
     */
    public void addJob(String name) {
        super.getTask().addJob(new Job(name));
    }

    /**
     * Sets the given jobs description to the value of the given string.
     *
     * @param job Job where the change will be made.
     * @param description String containing the new description for the job.
     */
    public void setJobDescription(Job job, String description) {
        job.setDescription(description);
    }

    /**
     * Returns a list containing all the jobs of the supervised task.
     *
     * @return ArrayList<Job> containing all the jobs of the supervised task.
     */
    public ArrayList<Job> getJobs() {
        return super.getTask().getJobs();
    }
}