package logic.schemes.task;
import logic.schemes.job.Job;
import logic.schemes.Scheme;
import logic.roles.taskroles.Supervisor;
import logic.roles.Role;
import logic.roles.taskroles.Worker;

import java.util.*;
/**
 * A Class to manage tasks jobs and roles.
 * Needs a name to be set when creating the object.
 * Holds and maintains the supervisor, workers and jobs variables.
 */
public class Task extends Scheme {

    private Supervisor supervisor;
    private ArrayList<Worker> workers;
    private ArrayList<Job> jobs;

    /**
     * Passes the name param to the superclass constructor.
     * Initializes worker list and job list with empty ArrayLists.
     *
     * @param name String containing the tasks name
     */
    public Task(String name) {
        super(name);
        this.workers = new ArrayList<>();
        this.jobs = new ArrayList<>();
    }

    /**
     * Return the string representation of the task.
     *
     * @return String containing task name and description.
     */
    public String toString() {
        return super.toString();
    }

    /**
     * Gets the assigned supervisor of the task.
     *
     * @return Supervisor which has been assigned to the project.
     */
    public Supervisor getSupervisor() {
        return this.supervisor;
    }

    /**
     * Sets a supervisor to the task.
     *
     * @param supervisor Supervisor to be assigned to the task.
     */
    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    /**
     * Gets a list of worker assigned to the task.
     *
     * @return ArrayList<Worker> containing assigned to the task
     */
    public ArrayList<Worker> getWorkers() {
        return this.workers;
    }

    /**
     * Adds worker to the task.
     *
     * @param worker Worker to be added into the task.
     */
    public void addWorker(Worker worker) {
        this.workers.add(worker);
    }

    /**
     * Removes the worker from the task and then relieves the worker
     * of the responsibility.
     *
     * @param worker Worker to be removed from the task.
     */
    public void removeWorker(Role worker) {
        this.workers.remove(worker);
        worker.getUser().removeRole(worker);
    }

    /**
     * Returns all the jobs associated with the task.
     *
     * @return ArrayList<Job> containing jobs of the task.
     */
    public ArrayList<Job> getJobs() {
        return this.jobs;
    }

    /**
     * Adds job to the task.
     *
     * @param job Job to be added into the task.
     */
    public void addJob(Job job) {
        this.jobs.add(job);
    }

    /**
     * Removes a job from the task.
     *
     * @param job Job to be removed
     */
    public void removeJob(Job job) {
        this.jobs.remove(job);
    }

    /**
     * Returns true if all the jobs in the task are marked as done.
     *
      * @return boolean signaling whether the task is done.
     */
    public boolean isDone() {
        int jobsDone = 0;
        for (Job job : this.jobs) {
            if (job.isDone()) {
                jobsDone++;
            }
        }
        if (jobsDone == this.jobs.size()) {
            return true;
        }
        return false;
    }

    /**
     * Sets the task done only if all the jobs in the task are marked done.
     */
    public void setDone() {
        if (isDone()) {
            super.getStatus().setDone();
        }
    }

    /**
     * Returns true if the task has given worker assigned to it.
     *
     * @param worker Worker used to check if exists in tasks workers
     * @return boolean value signalling whether task has worker or not.
     */
    public boolean hasWorker(Worker worker) {
        return this.getWorkers().contains(worker);
    }
}