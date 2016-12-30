package logiikka;

import java.util.*;

/**
 * 
 */
public class Job {

    private String name;
    private String description;
    private JobStatus status;
    private Worker worker;

    /**
     * Default constructor requires at least a name for the Job.
     */

    public Job(String name, String statusName) {
        this.name = name;
        this.status = new JobStatus(statusName);
    }

    public boolean isDone() {
        return this.status.isDone();
    }

    public void setDone() {
        this.status.setDone();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JobStatus getStatus() {
        return this.status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public Worker getWorker() {
        return this.worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}