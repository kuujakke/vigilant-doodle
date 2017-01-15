package logic.roles.taskroles;

import config.Configuration;
import logic.DefaultFactory;
import logic.login.User;
import logic.schemes.job.Job;
import logic.schemes.task.Task;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by kuujakke on 30.12.2016.
 */
public class SupervisorTest {
    private DefaultFactory defaultFactory;
    private Task task;
    private Configuration configuration;
    private Supervisor supervisor;
    private User user;

    @Before
    public void setUp() throws Exception {
        this.configuration = new Configuration();
        this.defaultFactory = new DefaultFactory(this.configuration);
        this.user = this.defaultFactory.createUser();
        this.task = this.defaultFactory.createTask();
        this.supervisor = this.defaultFactory.createSupervisor(this.defaultFactory.createUser(), this.task);
    }

    @Test
    public void addRemoveWorkerWorkingAsIntended() throws Exception {
        this.supervisor.addWorker(this.user);
        assertThat(this.user.hasScheme(this.task));
        Worker worker = this.task.getWorkers().get(0);
        this.supervisor.removeWorker(worker);
        assertThat(this.task.hasWorker(worker)).isFalse();
        assertThat(worker.getUser().hasRole(worker)).isFalse();
    }

    @Test
    public void addJob() throws Exception {
        this.supervisor.addJob("Test");
        assertThat(this.supervisor.getJobs().size()).isEqualTo(1);
    }

    @Test
    public void setJobDescription() throws Exception {
        Job job = new Job("Test");
        this.supervisor.setJobDescription(job, "Description");
        assertThat("Test\nDescription").isEqualTo(job.toString());
    }

    @Test
    public void getJobs() throws Exception {
        assertThat(this.supervisor.getJobs().size()).isEqualTo(0);
        this.supervisor.addJob("Test");
        assertThat(this.supervisor.getJobs().size()).isEqualTo(1);
    }

}