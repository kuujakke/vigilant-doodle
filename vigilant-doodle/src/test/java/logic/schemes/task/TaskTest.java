package logic.schemes.task;

import config.Configuration;
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
    private TaskFactory taskFactory;
    private User user;
    private RoleFactory roleFactory;
    private Configuration configuration;

    @Before
    public void setUp() throws Exception {
        this.configuration = new Configuration();
        this.taskFactory = new TaskFactory(this.configuration);
        this.roleFactory = new RoleFactory(this.configuration);
        this.user = new User(
                this.configuration.getUserName(),
                this.configuration.getUserPassword());
        this.task = this.taskFactory.createTask();
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
        Supervisor supervisor = this.roleFactory.createSupervisor(this.user, this.task);
        this.task.setSupervisor(supervisor);
        assertEquals(supervisor.getName(), this.task.getSupervisor().getName());
        assertEquals(this.configuration.getUserName(), this.task.getSupervisor().getUser().getName());
    }

    @Test
    public void getAddRemoveWorkersWorkingAsIntended() throws Exception {
        assertNotNull(this.task.getWorkers());
        assertEquals(0, this.task.getWorkers().size());
        Worker worker = this.roleFactory.createWorker(this.user, this.task);
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