package logiikka;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 28.12.2016.
 */
public class JobStatusTest {
    @Test
    public void isDone() throws Exception {

    }

    private JobStatus jobStatus;

    @Before
    public void setUp() throws Exception {
        this.jobStatus = new JobStatus("Test-job");
    }

    @Test
    public void isNotCompletedWhenNew() throws Exception {
        assertFalse(this.jobStatus.isDone());
    }

    @Test
    public void returnsDoneIfJobIsDone() throws Exception {
        this.jobStatus.setDone();
        assertTrue(this.jobStatus.isDone());
    }

    @Test
    public void toStringWorkingAsIntended() throws Exception {
        String string = this.jobStatus.toString();
        assertTrue(string.contains("name='" + this.jobStatus.getName()));
        assertTrue(string.contains("startTime=" + this.jobStatus.getStartTime()));
    }

}