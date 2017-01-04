package logic.roles.taskroles;
import logic.roles.Role;
import logic.login.User;
import logic.schemes.Job;
import logic.schemes.task.Task;

import java.util.*;

/**
 * Base role for task.
 */

public class Worker extends Role {

    public Task task;
    public ArrayList<Job> jobs;

    public Worker(User user, Task task) {
        super(user);
        this.task = task;
    }

    public Job getNextJob() {
        if (!this.jobs.isEmpty()) {
            return this.jobs.get(0);
        }
        return null;
    }

    public void setJobCompleted(Job job) {
        job.setDone();
    }

}