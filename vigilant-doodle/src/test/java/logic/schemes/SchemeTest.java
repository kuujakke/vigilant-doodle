package logic.schemes;

import logic.schemes.project.Project;
import logic.schemes.task.Task;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;


/**
 * Created by kuujakke on 15.1.2017.
 */
public class SchemeTest {

    private Scheme scheme;

    @Before
    public void setUp() throws Exception {
        this.scheme = new Project("Test");
    }

    @Test
    public void getSetName() throws Exception {
        this.scheme.setName("Foo");
        assertThat(this.scheme.getName()).isEqualTo("Foo");
        this.scheme.setName(null);
        assertThat(this.scheme.getName()).isNullOrEmpty();
    }

    @Test
    public void getSetDescription() throws Exception {
        this.scheme.setDescription("Bar");
        assertThat(this.scheme.getDescription()).isEqualTo("Bar");
        this.scheme.setDescription(null);
        assertThat(this.scheme.getDescription()).isNullOrEmpty();
    }

    @Test
    public void getStatus() throws Exception {
        assertThat(this.scheme.getStatus()).isNotNull();
        assertThat(this.scheme.getStatus() instanceof Status);
    }

    @Test
    public void getSetDeadline() throws Exception {
        assertThat(this.scheme.getDeadline()).isNull();
        this.scheme.setDeadline(LocalDateTime.MAX);
        assertThat(LocalDateTime.MAX).isEqualTo(this.scheme.getDeadline());
    }

    @Test
    public void getSetExpectedDone() throws Exception {
        assertThat(this.scheme.getExpectedDone()).isNull();
        this.scheme.setExpectedDone(LocalDateTime.MAX);
        assertThat(LocalDateTime.MAX).isEqualTo(this.scheme.getExpectedDone());
    }

    @Test
    public void isSetDone() throws Exception {
        assertThat(this.scheme.isDone()).isFalse();
        this.scheme.setDone();
        Thread.sleep(1);
        assertThat(this.scheme.isDone()).isTrue();
    }

    @Test
    public void isSetDone2() throws Exception {
        assertThat(this.scheme.isDone()).isFalse();
        ((Project) this.scheme).addTask(new Task());
        this.scheme.setDone();
        Thread.sleep(1);
        assertThat(this.scheme.isDone()).isEqualTo(this.scheme.getStatus().isDone());
    }

    @Test
    public void hasScheme() throws Exception {
        Task task = new Task();
        assertThat(this.scheme.hasScheme(task)).isFalse();
        ((Project) this.scheme).addTask(task);
        assertThat(this.scheme.hasScheme(task)).isTrue();
    }

    @Test
    public void toStringTest() throws Exception {
        assertThat(scheme.toString()).isNotNull();
        assertThat(scheme.toString()).isEqualTo(scheme.getName());
    }

}