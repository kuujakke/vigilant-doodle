package logic.schemes.job;

import config.Configuration;
import jdk.nashorn.internal.runtime.JSONListAdapter;
import logic.DefaultFactory;
import logic.schemes.task.Task;
import logic.schemes.task.TaskFactory;
import org.junit.Before;
import org.junit.Test;
import logic.roles.RoleFactory;
import logic.login.User;
import logic.roles.taskroles.Worker;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by kuujakke on 30.12.2016.
 */
public class JobTest {

    private Task task;
    private User user;
    private Configuration configuration;
    private DefaultFactory defaultFactory;

    @Before
    public void setUp() throws Exception {
        this.configuration = new Configuration();
        this.defaultFactory = new DefaultFactory(this.configuration);
        this.task = this.defaultFactory.createTask();
        this.user = this.defaultFactory.createUser();
    }

    @Test
    public void isDoneAndSetDoneWorkingAsIntended() throws Exception {
        Job job = this.defaultFactory.createJob();
        assertThat(job.isDone()).isFalse();
        job.setDone();
        Thread.sleep(1);
        assertThat(job.isDone()).isTrue();
    }

    @Test
    public void getAndSetNameWorkingAsIntended() throws Exception {
        Job job = this.defaultFactory.createJob();
        assertThat(job.getName().equals(this.defaultFactory.getConfig().getJobName())).isTrue();
        job.setName("TestName");
        assertThat(this.defaultFactory.getConfig().getJobName()).isNotEqualTo(job.getName());
        assertThat(job.getName()).isEqualTo("TestName");
    }

    @Test
    public void getAndSetDescriptionWorkingAsIntended() throws Exception {
        Job job = this.defaultFactory.createJob();
        assertThat(job.getDescription()).isEqualTo(this.configuration.getJobDescription());
        job.setDescription("TestDescription");
        assertThat(job.getDescription()).isEqualTo("TestDescription");
    }

    @Test
    public void getAndSetWorkerWorkingAsIntended() throws Exception {
        Job job = this.defaultFactory.createJob();
        Task task = this.defaultFactory.createTask();
        assertThat(job.getWorker()).isNull();
        Worker worker = defaultFactory.createWorker(task);
        job.setWorker(worker);
        assertThat(job.getWorker()).isNotNull();
        assertThat(job.getWorker().equals(worker)).isTrue();
    }

    @Test
    public void emptyJob() throws Exception {
        assertThat(new Job()).isNotNull();
    }

    @Test
    public void hasScheme() throws Exception {
        Job job = new Job();
        assertThat(job.hasScheme(job)).isTrue();
        assertThat(job.hasScheme(new Job()));
    }

}