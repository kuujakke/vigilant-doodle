package logic.schemes.job;

import config.Configuration;
import logic.DefaultFactory;
import logic.schemes.task.Task;
import logic.schemes.task.TaskFactory;
import org.junit.Before;
import org.junit.Test;
import logic.roles.RoleFactory;
import logic.login.User;
import logic.roles.taskroles.Worker;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 30.12.2016.
 */
public class JobTest {

    private Task task;
    private User user;
    private Configuration configuration;
    private DefaultFactory defaultFactory;

    @Before
    public void setUp() throws Exception {
        this.configuration = new Configuration();
        this.defaultFactory = new DefaultFactory(this.configuration);
        this.task = this.defaultFactory.createTask();
        this.user = this.defaultFactory.createUser();
    }

    @Test
    public void isDoneAndSetDoneWorkingAsIntended() throws Exception {
        Job job = this.defaultFactory.createJob();
        assertFalse(job.isDone());
        job.setDone();
        Thread.sleep(1);
        assertTrue(job.isDone());
    }

    @Test
    public void getAndSetNameWorkingAsIntended() throws Exception {
        Job job = this.defaultFactory.createJob();
        assertTrue(job.getName().equals(this.defaultFactory.getConfig().getJobName()));
        job.setName("TestName");
        assertNotEquals(this.defaultFactory.getConfig().getJobName(), job.getName());
        assertEquals("TestName", job.getName());
    }

    @Test
    public void getAndSetDescriptionWorkingAsIntended() throws Exception {
        Job job = this.defaultFactory.createJob();
        assertEquals(this.configuration.getJobDescription(), job.getDescription());
        job.setDescription("TestDescription");
        assertEquals("TestDescription", job.getDescription());
    }

    @Test
    public void getAndSetWorkerWorkingAsIntended() throws Exception {
        Job job = this.defaultFactory.createJob();
        Task task = this.defaultFactory.createTask();
        assertNull(job.getWorker());
        Worker worker = defaultFactory.createWorker(task);
        job.setWorker(worker);
        assertNotNull(job.getWorker());
        assertTrue(job.getWorker().equals(worker));
    }

}