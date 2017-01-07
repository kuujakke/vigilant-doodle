package logic.roles.taskroles;
import logic.roles.Role;
import logic.login.User;
import logic.schemes.Scheme;
import logic.schemes.job.Job;
import logic.schemes.task.Task;

import java.util.*;

/**
 * Base role for completing jobs. Can only belong to one task
 * at any given time and has many jobs to mark as done.
 */
public class Worker extends Role {

    private Task task;
    private ArrayList<Scheme> jobs;

    /**
     * Passes the user to the superclass and initializes the task with given task.
     * Initializes new ArrayList<Job> to hold workers future jobs.
     *
     * @param user User to be passed on to superclass.
     * @param task Task to be initialized as the workers task.
     */
    public Worker(User user, Task task) {
        super(user);
        this.task = task;
        this.jobs = new ArrayList<>();
    }

    /**
     * Returns the first job in workers list.
     *
     * @return Job that is on the first index of the job list.
     */
    public Scheme getNextJob() {
        if (!this.jobs.isEmpty()) {
            return this.jobs.get(0);
        }
        return null;
    }

    /**
     * Sets the given job to done.
     *
     * @param job Job to be marked as done.
     */
    public void setJobCompleted(Job job) {
        job.setDone();
    }

    /**
     * Adds a job to the workers job listing.
     *
     * @param job Job to add to the workers job list.
     */
    public void addJob(Job job) {
        this.jobs.add(job);
    }

    /**
     * Returns the task assigned to this worker.
     *
     * @return Task assigned to worker.
     */
    public Task getTask() {
        return this.task;
    }

    /**
     * Returns true if the given scheme is the same as the one set to the worker.
     *
     * @param scheme Scheme to compare to workers assigned task against.
     *
     * @return true if scheme is the same as the workers assigned task.
     */
    public boolean hasScheme(Scheme scheme) {
        if (this.task.equals(scheme)) {
            return true;
        }
        return false;
    }

    @Override
    public void addResponsibility(Scheme scheme) {
        this.jobs.add(scheme);
    }

    @Override
    public void removeResponsibility(Scheme scheme) {
        if (this.jobs.contains(scheme)) {
            this.jobs.remove(scheme);
        }
    }

    @Override
    public boolean hasResponsibility(Scheme scheme) {
        if (this.hasScheme(scheme) || this.jobs.contains(scheme)) {
            return true;
        }
        return false;
    }
}