package logic.roles.taskroles;

import config.Configuration;
import logic.DefaultFactory;
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
    private DefaultFactory defaultFactory;

    @Before
    public void setUp() throws Exception {
        this.configuration = new Configuration();
        this.defaultFactory = new DefaultFactory(this.configuration);
    }

    @Test
    public void addHasRemoveWorkerWorkingAsIntended() {
        Task task = this.defaultFactory.createTask();
        Worker worker = this.defaultFactory.createWorker(task);

        assertTrue(task.hasWorker(worker));
        assertEquals(worker.getTask(), task);

        User user = worker.getUser();
        task.removeWorker(worker);

        assertFalse(task.hasWorker(worker));
        assertFalse(user.allTasks().contains(task));
    }

    @Test
    public void getNextJob() throws Exception {
        Task task = this.defaultFactory.createTask();
        Worker worker = this.defaultFactory.createWorker(task);
        Job job = this.defaultFactory.createJob();
        task.addJob(job);

        job.setWorker(worker);
        assertTrue(worker.getTask().getJobs().contains(job));
    }

    @Test
    public void setJobCompleted() throws Exception {
        Worker worker = this.defaultFactory.createWorker(this.defaultFactory.createTask());
        Job job = this.defaultFactory.createJob();
        worker.addJob(job);
        worker.setJobCompleted(job);
        Thread.sleep(1);
        assertTrue(job.isDone());
    }

}