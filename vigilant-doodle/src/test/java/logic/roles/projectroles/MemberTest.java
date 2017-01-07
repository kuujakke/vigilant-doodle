package logic.roles.projectroles;

import config.Configuration;
import logic.schemes.Scheme;
import logic.schemes.project.Project;
import logic.schemes.project.ProjectFactory;
import logic.schemes.task.Task;
import org.junit.Before;
import org.junit.Test;
import logic.roles.projectroles.Leader;
import logic.roles.projectroles.Member;
import logic.roles.RoleFactory;
import logic.login.User;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 27.12.2016.
 */
public class MemberTest {

    private Member member;
    private Project project;
    private User user;
    private Leader leader;
    private ProjectFactory projectFactory;
    private RoleFactory roleFactory;
    private Configuration configuration;

    @Before
    public void setUp() throws Exception {
        this.configuration = new Configuration();
        this.user = new User(
                this.configuration.getUserName(),
                this.configuration.getUserPassword()
        );
        this.projectFactory = new ProjectFactory(this.configuration);
        this.roleFactory = new RoleFactory(this.configuration);
        this.project = this.projectFactory.createProject();
        this.leader = this.roleFactory.createLeader(this.user, this.project);
        this.member = this.roleFactory.createMember(this.user, this.project);
    }

    @Test
    public void getTasks() throws Exception {
        Task task = generateTask();
        this.member.getTasks().add(task);
        ArrayList<Scheme> tasks = this.member.getTasks();
        assertEquals(1, tasks.size());
        assertTrue(tasks.contains(task));
    }

    @Test
    public void getProjectWorkingAsIntended() throws Exception {
        assertEquals(this.project, this.member.getProject());
    }

    public Task generateTask() {
        return new Task(Integer.toString(new Random().nextInt(Integer.MAX_VALUE)));
    }

}