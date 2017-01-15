package logic.schemes;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by kuujakke on 2.1.2017.
 */
public class StatusTest {

    private Status status;
    private LocalDateTime testStartTime;

    @Before
    public void setUp() throws Exception {
        this.testStartTime = LocalDateTime.now();
        this.status = new Status(this.testStartTime);
    }

    @Test
    public void setGetNameWorkingAsIntended() throws Exception {
        assertThat(this.status.getName()).isNull();
        this.status.setName("Test");
        assertThat(this.status.getName()).isEqualTo("Test");
    }

    @Test
    public void setGetDescriptionWorkingAsIntended() throws Exception {
        assertThat(this.status.getDescription()).isNull();
        this.status.setDescription("Test");
        assertThat(this.status.getDescription()).isEqualTo("Test");
    }

    @Test
    public void toStringWorkingAsIntended() throws Exception {
        this.status.setName("Test");
        this.status.setDescription("Test");
        assertThat(this.status.toString()).isEqualTo("Nimi: Test\nKuvaus: Test");
    }

    @Test
    public void getSetDeadlineWorkingAsIntended() throws Exception {
        assertThat(this.status.getDeadline()).isNull();
        LocalDateTime testDeadline = LocalDateTime.now().plusHours(1);
        this.status.setDeadline(testDeadline);
        assertThat(this.status.getDeadline()).isEqualTo(testDeadline);
    }

    @Test
    public void isSetDoneWorkingAsIntended() throws Exception {
        assertThat(this.status.isDone()).isFalse();
        LocalDateTime testTime = LocalDateTime.now();
        this.status.setDone();
        assertThat(this.status.getCompleted()).isNotNull();
        assertThat(this.status.getCompleted()).isGreaterThanOrEqualTo(testTime);
    }

    @Test
    public void getSetExpectedDoneWorkingAsIntended() throws Exception {
        assertThat(this.status.getExpectedDone()).isNull();
        LocalDateTime testTime = LocalDateTime.now();
        this.status.setExpectedDone(testTime);
        assertThat(this.status.getExpectedDone()).isEqualTo(testTime);
    }

    @Test
    public void getStartTimeTest() {
        assertThat(this.status.getStartTime()).isEqualTo(this.testStartTime);
    }

    @Test
    public void isSetCompleted() throws Exception {
        assertThat(this.status.getCompleted()).isNull();
        Thread.sleep(1);
        assertThat(this.status.isCompleted()).isFalse();
        LocalDateTime now = LocalDateTime.now();
        this.status.setCompleted();
        Thread.sleep(1);
        assertThat(this.status.isCompleted()).isTrue();
        assertThat(this.status.getCompleted()).isNotNull();
        assertThat(this.status.getCompleted()).isEqualTo(now);
    }

    @Test
    public void emptyStatus() throws Exception {
        Status status = new Status();
        assertThat(status).isNotNull();
        assertThat(status.getStartTime()).isNull();
        assertThat(status.getCompleted()).isNull();
    }
}