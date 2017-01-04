package logic.schemes.task;
import logic.schemes.job.Job;
import logic.schemes.Scheme;
import logic.roles.taskroles.Supervisor;
import logic.roles.Role;
import logic.roles.taskroles.Worker;

import java.util.*;
/**
 * A Class to manage tasks jobs and roles.
 */
public class Task extends Scheme {

    private Supervisor supervisor;
    private ArrayList<Worker> workers;
    private ArrayList<Job> jobs;

    public Task(String name) {
        super(name);
        this.workers = new ArrayList<>();
        this.jobs = new ArrayList<>();
    }

    public String toString() {
        // TODO implement here
        return "";
    }

    public Supervisor getSupervisor() {
        return this.supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public ArrayList<Worker> getWorkers() {
        return this.workers;
    }

    public void addWorker(Worker worker) {
        this.workers.add(worker);
    }

    public void removeWorker(Role worker) {
        this.workers.remove(worker);
    }

    public ArrayList<Job> getJobs() {
        return this.jobs;
    }

    public void addJob(Job job) {
        this.jobs.add(job);
    }

    public void removeJob(Job job) {
        this.jobs.remove(job);
    }

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

    public void setDone() {
        int jobsDone = 0;
        for (Job job : this.getJobs()) {
            if (job.isDone()) {
                jobsDone++;
            }
        }
        if (jobsDone == this.getJobs().size()) {
            super.getStatus().setDone();
        }
    }
}