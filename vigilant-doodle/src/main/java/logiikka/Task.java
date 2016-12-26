package logiikka;
import java.util.*;

/**
 * 
 */
public class Task {

    /**
     * Default constructor
     */
    public Task() {
    }

    /**
     * 
     */
    public TaskStatus taskStatus;

    /**
     * 
     */
    public Supervisor taskSupervisor;

    /**
     * 
     */
    public ArrayList<Worker> workers;

    /**
     * 
     */
    public ArrayList<Job> jobs;





    /**
     * @param name 
     * @param status
     */
    public void Task(String name, Status status) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "";
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        // TODO implement here
    }

    /**
     * @param datetime
     */
    public void setDeadline(LocalDateTIme datetime) {
        // TODO implement here
    }

    /**
     * @param supervisor
     */
    public void setSupervisor(Supervisor supervisor) {
        // TODO implement here
    }

    /**
     * @return
     */
    public ArrayList<Worker> getWorkers() {
        // TODO implement here
        return null;
    }

    /**
     * @param worker
     */
    public void addWorker(Worker worker) {
        // TODO implement here
    }

    /**
     * @param worker
     */
    public void removeWorker(Worker worker) {
        // TODO implement here
    }

    /**
     * @param job
     */
    public void addJob(Job job) {
        // TODO implement here
    }

    /**
     * @param job
     */
    public void removeJob(Job job) {
        // TODO implement here
    }

    /**
     * @return
     */
    public ArrayList<Job> getJobs() {
        // TODO implement here
        return null;
    }

}