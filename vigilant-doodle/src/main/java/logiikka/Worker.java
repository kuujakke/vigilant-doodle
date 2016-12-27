package logiikka;
import java.util.*;

/**
 * 
 */
public class Worker implements Role {

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

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public Role getRole() {
        return null;
    }

    @Override
    public String getRoleName() {
        return null;
    }

    @Override
    public String getRoleDescription() {
        return null;
    }

    @Override
    public void setRoleName(String name) {

    }

    @Override
    public void setRoleDescription(String description) {

    }
}