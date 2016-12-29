package logiikka;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 29.12.2016.
 */
public class TaskStatusTest {

    TaskStatus status;
    String testName;
    String testDescription;
    LocalDateTime testStart;

    @Before
    public void setUp() throws Exception {
        this.testName = "Testauksessa";
        this.testDescription = "Tehtävä on testausvaiheessa";
        this.testStart = LocalDateTime.now();
        this.status = new TaskStatus(this.testName);
    }

    @Test
    public void getAndSetNameWorkingAsIntended() throws Exception {
        this.status.setName("Vaiheessa");
        assertNotEquals(this.testDescription, this.status.getName());
    }

    @Test
    public void getAndSetDescriptionWorkingAsIntended() throws Exception {
        this.status.setDescription("Vähän on kesken ja sillai");
        assertNotEquals(this.testDescription, this.status.getDescription());
    }

    @Test
    public void getStartTimeWorkingAsIntended() throws Exception {
        assertEquals(this.testStart, this.status.getStartTime());
    }

    @Test
    public void getAndSetEndTimeWorkingAsIntended() throws Exception {
        LocalDateTime testDone = LocalDateTime.now();
        this.status.setDone();
        assertEquals(testDone, this.status.getEndTime());
    }

    @Test
    public void getAndSetDeadlineWorkingAsIntended() throws Exception {
        LocalDateTime testDeadline = LocalDateTime.now();
        this.status.setDeadline(testDeadline);
        assertEquals(testDeadline, this.status.getDeadline());
    }

    @Test
    public void setDoneAndIsDoneWorkingAsIntended() throws Exception {
        assertTrue(this.status.setDone());
        LocalDateTime testDone = LocalDateTime.now();
        assertEquals(testDone, this.status.getEndTime());
    }

    @Test
    public void getAndSetExpectedDoneWorkinAsIntended() throws Exception {
        LocalDateTime testExpected = LocalDateTime.now();
        testExpected.plusHours(1);
        this.status.setExpectedDone(testExpected);
        assertTrue(this.status.getExpectedDone().isAfter(LocalDateTime.now()));
    }

}