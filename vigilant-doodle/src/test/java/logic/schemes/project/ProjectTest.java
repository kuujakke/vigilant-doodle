package logic.schemes.project;

import logic.schemes.DefaultFactory;
import logic.schemes.task.Task;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import logic.roles.projectroles.Leader;
import logic.roles.projectroles.Member;
import logic.login.User;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 27.12.2016.
 */
public class ProjectTest {

    private Project project;
    private User user;
    private Leader leader;
    private DefaultFactory defaultFactory;

    @Before
    public void setUp() throws Exception {
        this.defaultFactory = new DefaultFactory();
        this.user = this.defaultFactory.createUser();
        this.leader = this.defaultFactory.createLeader(this.user, this.project);
        this.project = this.defaultFactory.createProject();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void toStringWorkingAsIntended() throws Exception {
        assertNotNull(this.project.toString());
    }

    @Test
    public void addGetRemoveTaskWorkingAsIntended() throws Exception {
        Task task = this.defaultFactory.createTask();
        this.project.addTask(task);
        assertEquals(1, this.project.getTasks().size());
        assertTrue(this.project.getTasks().contains(task));
        this.project.addTask(this.defaultFactory.createTask());
        this.project.addTask(this.defaultFactory.createTask());
        assertEquals(3, this.project.getTasks().size());
        this.project.addTask(task);
        assertEquals(3, this.project.getTasks().size());
        this.project.deleteTask(task);
        assertEquals(2, this.project.tasks.size());
        assertFalse(this.project.tasks.contains(task));
    }

    @Test
    public void getAddRemoveMemberWorkingAsIntended() throws Exception {
        assertEquals(0, this.project.getMembers().size());
        assertNotNull(this.project.getMembers());
        User user1 = this.defaultFactory.createUser();
        User user2 = this.defaultFactory.createUser();
        Member member1 = this.defaultFactory.createMember(user1, this.project);
        Member member2 = this.defaultFactory.createMember(user2, this.project);

        this.project.addMember(member1);
        assertEquals(1, this.project.getMembers().size());
        assertTrue(this.project.getMembers().contains(member1));

        this.project.addMember(member2);
        assertTrue(this.project.hasMember(member2));
        assertTrue(this.project.hasMember(member1));
        assertEquals(2, this.project.getMembers().size());

        this.project.removeMember(member1);
        assertEquals(1, this.project.getMembers().size());
        assertTrue(this.project.getMembers().contains(member2));
        assertFalse(this.project.getMembers().contains(member1));
    }

    @Test
    public void getAddRemoveLeaderWorkingAsIntended() throws Exception {
        assertNotNull(this.project.getLeaders());
        assertEquals(0, this.project.getLeaders().size());

        User user1 = this.defaultFactory.createUser();
        User user2 = this.defaultFactory.createUser();
        Leader leader1 = this.defaultFactory.createLeader(user1, this.project);
        Leader leader2 = this.defaultFactory.createLeader(user2, this.project);

        this.project.addLeader(leader1);
        assertTrue(this.project.hasLeader(leader1));
        assertEquals(1, this.project.getLeaders().size());

        this.project.addLeader(leader2);
        assertEquals(2, this.project.getLeaders().size());

        this.project.removeLeader(leader1);
        assertFalse(this.project.hasLeader(leader1));
        assertEquals(1, this.project.getLeaders().size());
        assertTrue(this.project.hasLeader(leader2));
    }

}