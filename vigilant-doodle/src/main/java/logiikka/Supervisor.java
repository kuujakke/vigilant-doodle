package logiikka;
import java.util.*;

/**
 * 
 */
public class Supervisor extends Worker {

    /**
     * Default constructor
     */
    public Supervisor(User user, Task task) {
        super(user, task);
    }

    /**
     * 
     */
    public Task task;


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