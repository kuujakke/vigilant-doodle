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

    }

    @Test
    public void getAndSetDescriptionWorkingAsIntended() throws Exception {

    }

    @Test
    public void getAndSetStatusWorkingAsIntended() throws Exception {

    }

    @Test
    public void getAndSetWorkerWorkingAsIntended() throws Exception {

    }

}