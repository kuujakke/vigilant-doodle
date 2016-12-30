package logiikka;
import java.util.*;

/**
 * 
 */
public class Worker implements Role {

    public String name;
    public User user;

    /**
     * Default constructor
     */
    public Worker(String name, User user) {
        this.name = name;
        this.user = user;
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

    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void setDescription(String description) {

    }
}