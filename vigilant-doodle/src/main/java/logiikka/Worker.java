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