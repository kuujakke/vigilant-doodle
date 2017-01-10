package logic.roles;

import config.Configuration;
import logic.DefaultFactory;
import logic.roles.projectroles.Member;
import logic.roles.taskroles.Supervisor;
import logic.roles.taskroles.Worker;
import logic.schemes.project.Project;
import logic.schemes.task.Task;
import org.junit.Before;
import org.junit.Test;
import logic.roles.projectroles.Leader;
import logic.login.User;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by kuujakke on 4.1.2017.
 */
public class RoleFactoryTest {

    private DefaultFactory defaultFactory;
    private User user;
    private Project project;
    private Task task;
    private RoleFactory roleFactory;

    @Before
    public void setUp() throws Exception {
        this.defaultFactory = new DefaultFactory();
        this.roleFactory = new RoleFactory(new Configuration());
        this.user = this.defaultFactory.createUser();
        this.project = this.defaultFactory.createProject();
        this.task = this.defaultFactory.createTask();
    }

    @Test
    public void createLeader() throws Exception {
        Leader leader = roleFactory.createLeader(this.user, this.project);
        assertThat(leader.getUser()).isSameAs(this.user);
        assertThat(leader.getProject()).isSameAs(this.project);
    }

    @Test
    public void createMember() throws Exception {
        Member member = roleFactory.createMember(this.user, this.project);
        assertThat(this.user).isSameAs(member.getUser());
        assertThat(this.project).isSameAs(member.getProject());
    }

    @Test
    public void createWorker() throws Exception {
        Worker worker = roleFactory.createWorker(this.user, this.task);
        assertThat(this.user).isSameAs(worker.getUser());
        assertThat(this.task).isSameAs(worker.getTask());
        assertThat(this.task.getWorkers()).contains(worker);
    }

    @Test
    public void createSupervisor() throws Exception {
        Supervisor supervisor = roleFactory.createSupervisor(this.user, this.task);
        assertThat(this.user).isSameAs(supervisor.getUser());
        assertThat(this.task).isSameAs(supervisor.getTask());
        assertThat(this.task.getSupervisor()).isSameAs(supervisor);
    }

}