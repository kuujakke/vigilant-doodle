package logic.roles.taskroles;

import config.Configuration;
import logic.login.User;
import logic.roles.RoleFactory;
import logic.schemes.job.Job;
import logic.schemes.job.JobFactory;
import logic.schemes.task.Task;
import logic.schemes.task.TaskFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 7.1.2017.
 */
public class WorkerTest {

    private Configuration configuration;
    private TaskFactory taskFactory;
    private RoleFactory roleFactory;
    private JobFactory jobFactory;
    private User user;

    @Before
    public void setUp() throws Exception {
        this.configuration = new Configuration();
        this.taskFactory = new TaskFactory(this.configuration);
        this.roleFactory = new RoleFactory(this.configuration);
        this.jobFactory = new JobFactory(this.configuration);
        this.user = new User(
                this.configuration.getUserName(),
                this.configuration.getUserPassword()
        );
    }

    @Test
    public void addHasRemoveWorkerWorkingAsIntended() {
        Task task = this.taskFactory.createTask();
        Worker worker = this.roleFactory.createWorker(this.user, task);

        task.addWorker(worker);
        assertTrue(task.hasWorker(worker));
        assertEquals(worker.getTask(), task);

        User user = worker.getUser();
        task.removeWorker(worker);
        assertFalse(task.hasWorker(worker));
        assertFalse(user.allTasks().contains(task));
    }

    @Test
    public void getNextJob() throws Exception {
        Task task = this.taskFactory.createTask();
        Worker worker = this.roleFactory.createWorker(this.user, task);
        Job job = this.jobFactory.createJob();
        task.addJob(job);

        job.setWorker(worker);
        assertTrue(worker.getTask().getJobs().contains(job));
    }

    @Test
    public void setJobCompleted() throws Exception {

    }

}