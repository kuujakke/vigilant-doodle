package logiikka;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 30.12.2016.
 */
public class TaskTest {

    private Task task;
    private TaskFactory taskFactory;
    private User user;
    private RoleFactory roleFactory;

    @Before
    public void setUp() throws Exception {
        this.taskFactory = new TaskFactory();
        this.roleFactory = new RoleFactory();
        this.user = new User("TestUser", "pw");
        this.task = this.taskFactory.createTask("TestTask");
    }

    @Test
    public void getSetDescriptionWorkingAsIntended() throws Exception {
        assertNull(this.task.getDescription());
        this.task.setDescription("TestDescription");
        assertEquals("TestDescription", this.task.getDescription());
    }

    @Test
    public void getSetSupervisorWorkingAsIntended() throws Exception {
        assertNull(this.task.getSupervisor());
        Supervisor supervisor = this.roleFactory.createSupervisor(this.user, this.task);
        this.task.setSupervisor(supervisor);
        assertEquals(supervisor.getName(), this.task.getSupervisor().getName());
        assertEquals("TestUser", this.task.getSupervisor().getUser().getName());
    }

    @Test
    public void getAddRemoveWorkersWorkingAsIntended() throws Exception {
        assertNotNull(this.task.getWorkers());
        assertEquals(0, this.task.getWorkers().size());
        Worker worker = this.roleFactory.createWorker(this.user, this.task);
        this.task.addWorker(worker);
        assertEquals(1, this.task.getWorkers().size());
        assertTrue(this.task.getWorkers().contains(worker));
        this.task.getWorkers().remove(worker);
        assertEquals(0, this.task.getWorkers().size());
        assertFalse(this.task.getWorkers().contains(worker));
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