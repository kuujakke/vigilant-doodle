package logiikka;
import java.util.*;

/**
 * 
 */
public class Worker extends Role {

    /**
     * Default constructor
     */
    public Worker() {
    }

    /**
     * 
     */
    public Task task;

    /**
     * 
     */
    public ArrayList<Job> jobs;


    /**
     * @param task
     */
    public void Slave(Task task) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Job getNextJob() {
        // TODO implement here
        return null;
    }

    /**
     * @param job
     */
    public void setJobCompleted(Job job) {
        // TODO implement here
    }

}