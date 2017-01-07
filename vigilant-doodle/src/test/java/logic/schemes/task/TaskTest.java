package logic.schemes.task;

import config.Configuration;
import logic.DefaultFactory;
import logic.schemes.job.Job;
import org.junit.Before;
import org.junit.Test;
import logic.roles.RoleFactory;
import logic.roles.taskroles.Supervisor;
import logic.login.User;
import logic.roles.taskroles.Worker;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 30.12.2016.
 */
public class TaskTest {

    private Task task;
    private User user;
    private Configuration configuration;
    private DefaultFactory defaultFactory;

    @Before
    public void setUp() throws Exception {
        this.configuration = new Configuration();
        this.defaultFactory = new DefaultFactory(this.configuration);
        this.user = this.defaultFactory.createUser();
        this.task = this.defaultFactory.createTask();
    }

    @Test
    public void getSetDescriptionWorkingAsIntended() throws Exception {
        assertEquals(this.configuration.getTaskDescription(), this.task.getDescription());
        this.task.setDescription("TestDescription");
        assertEquals("TestDescription", this.task.getDescription());
    }

    @Test
    public void getSetSupervisorWorkingAsIntended() throws Exception {
        assertNull(this.task.getSupervisor());
        Supervisor supervisor = this.defaultFactory.createSupervisor(this.user, this.task);
        this.task.setSupervisor(supervisor);
        assertTrue(this.task.getSupervisor().equals(supervisor));
    }

    @Test
    public void getAddRemoveWorkersWorkingAsIntended() throws Exception {
        assertNotNull(this.task.getWorkers());
        assertEquals(0, this.task.getWorkers().size());
        Worker worker = this.defaultFactory.createWorker(this.task);
        this.task.addWorker(worker);
        assertEquals(1, this.task.getWorkers().size());
        assertTrue(this.task.getWorkers().contains(worker));
        assertTrue(worker.hasScheme(this.task));
        this.task.removeWorker(worker);
        assertEquals(0, this.task.getWorkers().size());
        assertFalse(this.task.getWorkers().contains(worker));
        assertFalse(worker.getUser().hasRole(worker));
    }

    @Test
    public void getAddRemoveJobsWorkingAsIntended() throws Exception {
        assertNotNull(this.task.getJobs());
        assertEquals(0, this.task.getJobs().size());
        Job job = new Job("TestJob");
        this.task.addJob(job);
        assertTrue(this.task.getJobs().contains(job));
        assertEquals(1, this.task.getJobs().size());
        this.task.removeJob(job);
        assertFalse(this.task.getJobs().contains(job));
        assertEquals(0, this.task.getJobs().size());
    }

    @Test
    public void isDoneWorkingAsIntended() throws Exception {
        assertTrue(this.task.isDone());
        this.task.addJob(new Job("TestJob"));
        assertFalse(this.task.isDone());
    }

}