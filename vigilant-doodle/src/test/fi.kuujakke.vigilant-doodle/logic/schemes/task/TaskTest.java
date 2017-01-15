package logic.schemes.task;

import config.Configuration;
import logic.DefaultFactory;
import logic.schemes.job.Job;
import org.junit.Before;
import org.junit.Test;
import logic.roles.RoleFactory;
import logic.roles.taskroles.Supervisor;
import logic.login.User;
import logic.roles.taskroles.Worker;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by kuujakke on 30.12.2016.
 */
public class TaskTest {

    private Task task;
    private User user;
    private Configuration configuration;
    private DefaultFactory defaultFactory;

    @Before
    public void setUp() throws Exception {
        this.configuration = new Configuration();
        this.defaultFactory = new DefaultFactory(this.configuration);
        this.user = this.defaultFactory.createUser();
        this.task = this.defaultFactory.createTask();
    }

    @Test
    public void getSetDescriptionWorkingAsIntended() throws Exception {
        assertThat(this.task.getDescription()).isEqualTo(this.configuration.getTaskDescription());
        this.task.setDescription("TestDescription");
        assertThat(this.task.getDescription()).isEqualTo("TestDescription");
    }

    @Test
    public void getSetSupervisorWorkingAsIntended() throws Exception {
        assertThat(this.task.getSupervisor()).isNull();
        Supervisor supervisor = this.defaultFactory.createSupervisor(this.user, this.task);
        this.task.setSupervisor(supervisor);
        assertThat(this.task.getSupervisor().equals(supervisor)).isTrue();
    }

    @Test
    public void getAddRemoveWorkersWorkingAsIntended() throws Exception {
        assertThat(this.task.getWorkers()).isNotNull();
        assertThat(this.task.getWorkers()).isEmpty();
        Worker worker = this.defaultFactory.createWorker(this.task);
        this.task.addWorker(worker);
        assertThat(this.task.getWorkers()).hasSize(1);
        assertThat(this.task.getWorkers().contains(worker)).isTrue();
        assertThat(worker.hasResponsibility(this.task)).isTrue();
        this.task.removeWorker(worker);
        assertThat(this.task.getWorkers()).isEmpty();
        assertThat(this.task.getWorkers().contains(worker)).isFalse();
        assertThat(worker.getUser().hasRole(worker)).isFalse();
    }

    @Test
    public void getAddRemoveJobsWorkingAsIntended() throws Exception {
        assertThat(this.task.getJobs()).isNotNull();
        assertThat(this.task.getJobs()).isEmpty();
        Job job = new Job("TestJob");
        this.task.addJob(job);
        assertThat(this.task.getJobs().contains(job)).isTrue();
        assertThat(this.task.getJobs()).hasSize(1);
        this.task.removeJob(job);
        assertThat(this.task.getJobs().contains(job)).isFalse();
        assertThat(this.task.getJobs()).isEmpty();
    }

    @Test
    public void isDoneWorkingAsIntended() throws Exception {
        assertThat(this.task.isDone()).isTrue();
        this.task.addJob(new Job("TestJob"));
        assertThat(this.task.isDone()).isFalse();
    }

}