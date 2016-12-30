package logiikka;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 30.12.2016.
 */
public class JobTest {

    private Job job;

    @Before
    public void setUp() throws Exception {
        this.job = new Job("TestJob", "Starting");
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
    public void getAndSetStatusWorkingAsIntended() throws Exception {
        assertNotNull(this.job.getStatus());
        this.job.setStatus(new JobStatus("TestStatus"));
        assertEquals("TestStatus", this.job.getStatus().getName());
    }

    @Test
    public void getAndSetWorkerWorkingAsIntended() throws Exception {
        assertNull(this.job.getWorker());
        this.job.setWorker(new Worker("TestWorker", new User("TestUser")));
        assertNotNull(this.job.getWorker());
        assertEquals("TestWorker", this.job.getWorker().getName());
    }

}