package logiikka;
import java.util.*;

public class Worker extends Role {

    public Task task;
    public ArrayList<Job> jobs;

    public Worker(User user) {
        super(user);
    }

    public Job getNextJob() {
        // TODO implement here
        return null;
    }

    public void setJobCompleted(Job job) {
        // TODO implement here
    }

}