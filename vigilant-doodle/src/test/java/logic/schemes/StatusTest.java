package logic.schemes;

import logic.schemes.Status;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 2.1.2017.
 */
public class StatusTest {

    private Status status;
    private LocalDateTime testStartTime;

    @Before
    public void setUp() throws Exception {
        this.testStartTime = LocalDateTime.now();
        this.status = new Status();
    }

    @Test
    public void setGetNameWorkingAsIntended() throws Exception {
        assertNull(this.status.getName());
        this.status.setName("Test");
        assertEquals("Test", this.status.getName());
    }

    @Test
    public void setGetDescriptionWorkingAsIntended() throws Exception {
        assertNull(this.status.getDescription());
        this.status.setDescription("Test");
        assertEquals("Test", this.status.getDescription());
    }

    @Test
    public void toStringWorkingAsIntended() throws Exception {
        this.status.setName("Test");
        this.status.setDescription("Test");
        assertEquals("Nimi: Test\nKuvaus: Test", this.status.toString());
    }

    @Test
    public void getStartTimeWorkingAsIntended() throws Exception {
        assertNotNull(this.status.getStartTime());
        assertEquals(this.testStartTime, this.status.getStartTime());
    }

    @Test
    public void getSetDeadlineWorkingAsIntended() throws Exception {
        assertNull(this.status.getDeadline());
        LocalDateTime testDeadline = LocalDateTime.now().plusHours(1);
        this.status.setDeadline(testDeadline);
        assertEquals(testDeadline, this.status.getDeadline());
    }

    @Test
    public void isSetDoneWorkingAsIntended() throws Exception {
        assertFalse(this.status.isDone());
        LocalDateTime testTime = LocalDateTime.now();
        this.status.setDone();
        assertEquals(testTime, this.status.getCompleted());
    }

    @Test
    public void getSetExpectedDoneWorkingAsIntended() throws Exception {
        assertNull(this.status.getExpectedDone());
        LocalDateTime testTime = LocalDateTime.now();
        this.status.setExpectedDone(testTime);
        assertEquals(testTime, this.status.getExpectedDone());
    }

}