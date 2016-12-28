package logiikka;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 28.12.2016.
 */
public class JobStatusTest {
    private JobStatus jobStatus;

    @Before
    public void setUp() throws Exception {
        this.jobStatus = new JobStatus("Test-job");
    }

    @Test
    public void isNotCompletedWhenNew() throws Exception {
        assertFalse(this.jobStatus.isCompleted());
    }

    @Test
    public void setCompleted() throws Exception {

    }

}