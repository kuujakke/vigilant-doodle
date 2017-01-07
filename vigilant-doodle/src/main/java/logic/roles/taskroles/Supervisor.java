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
        super.task.addWorker(worker);
    }

    /**
     * Removes worker from the supervised task, if worker exists in it.
     *
     * @param worker Worker to be removed.
     */
    public void removeWorker(Worker worker) {
        if (super.task.hasWorker(worker)) {
            super.task.removeWorker(worker);
        }
    }

    /**
     * @param name
     */
    public void addJob(String name) {
        // TODO implement here
    }

    /**
     * @param job 
     * @param descpription
     */
    public void setJobDescription(Job job, String descpription) {
        // TODO implement here
    }

    /**
     * @param task 
     * @return
     */
    public ArrayList<Job> getJobs(Task task) {
        // TODO implement here
        return null;
    }

}