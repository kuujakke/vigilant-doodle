package logiikka;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 30.12.2016.
 */
public class TaskTest {

    private Task task;

    @Before
    public void setUp() throws Exception {
        this.task = new Task("TestTask", new Supervisor(new User("TestUser", "password")));
    }

    @Test
    public void getSetDescriptionWorkingAsIntended() throws Exception {
        assertNull(this.task.getDescription());
        this.task.setDescription("TestDescription");
        assertEquals("TestDescription", this.task.getDescription());
    }

    @Test
    public void getSetSupervisorWorkingAsIntended() throws Exception {
        assertNotNull(this.task.getSupervisor());
        assertEquals("TestUser", this.task.getSupervisor().getUser().getName());
        Supervisor original = this.task.getSupervisor();
        this.task.setSupervisor(new Supervisor(new User("Test", "password")));
        assertNotEquals(this.task.getSupervisor().getName(), original);
    }

    @Test
    public void getAddRemoveWorkersWorkingAsIntended() throws Exception {
        assertNotNull(this.task.getWorkers());
        assertEquals(0, this.task.getWorkers().size());
        Worker worker = new Worker(new User("Tester", "password"));
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