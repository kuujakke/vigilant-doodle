package logiikka;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 30.12.2016.
 */
public class JobTest {

    private Job job;
    private Task task;
    private TaskFactory taskFactory;
    private User user;

    @Before
    public void setUp() throws Exception {
        this.job = new Job("TestJob");
        this.taskFactory = new TaskFactory();
        this.task = this.taskFactory.createTask("TestTask");
        this.user = new User("Test", "password");
    }

    @Test
    public void isDoneAndSetDoneWorkingAsIntended() throws Exception {
        assertFalse(this.job.isDone());
        this.job.setDone();
        Thread.sleep(1);
        assertTrue(this.job.isDone());
    }

    @Test
    public void getAndSetNameWorkingAsIntended() throws Exception {
        String name = this.job.getName();
        this.job.setName("TestName");
        assertNotEquals(name, this.job.getName());
    }

    @Test
    public void getAndSetDescriptionWorkingAsIntended() throws Exception {
        assertNull(this.job.getDescription());
        this.job.setDescription("TestDescription");
        assertEquals("TestDescription",this.job.getDescription());
    }

    @Test
    public void getAndSetWorkerWorkingAsIntended() throws Exception {
        assertNull(this.job.getWorker());
        Worker worker = taskFactory.createWorker(this.user, this.task);
        worker.setRealName("Test");
        this.job.setWorker(worker);
        assertNotNull(this.job.getWorker());
        assertEquals("Test", this.job.getWorker().getName());
    }

}