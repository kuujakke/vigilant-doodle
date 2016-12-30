package logiikka;
import java.time.LocalDateTime;
import java.util.*;
/**
 * 
 */
public class Task {
    private String name;
    private String description;
    private TaskStatus status;
    private Supervisor supervisor;
    private ArrayList<Worker> workers;
    private ArrayList<Job> jobs;

    /**
     * Default constructor
     */
    public Task(String name, String statusName, Supervisor supervisor) {
        this.name = name;
        this.status = new TaskStatus("Testing", this);
        this.supervisor = supervisor;
        this.workers = new ArrayList<>();
        this.jobs = new ArrayList<>();
    }


    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "";
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(LocalDateTime datetime) {
        this.status.setDeadline(datetime);
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

    public void removeWorker(Worker worker) {
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
}