package logiikka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 27.12.2016.
 */
public class ProjectTest {

    private Project project;
    private ProjectFactory projectFactory;
    private User user;
    private Leader leader;
    private RoleFactory roleFactory;

    @Before
    public void setUp() throws Exception {
        this.roleFactory = new RoleFactory();
        this.projectFactory = new ProjectFactory();
        this.user = new User("TestUser", "password");
        this.leader = this.roleFactory.createLeader(this.user, this.project);
        this.project = new Project("Tehtävienhallintajärjestelmä");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void toStringWorkingAsIntended() throws Exception {
        assertNotNull(this.project.toString());
        String projectToString = this.project.toString();
        assertEquals("Tehtävienhallintajärjestelmä", projectToString);
    }

    @Test
    public void addGetRemoveTaskWorkingAsIntended() throws Exception {
        Task task = generateTask();
        this.project.addTask(task);
        assertEquals(1, this.project.getTasks().size());
        assertTrue(this.project.getTasks().contains(task));
        this.project.addTask(generateTask());
        this.project.addTask(generateTask());
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
        Member member1 = new Member(new User("Test-user", "password"), this.project);
        this.project.addMember(member1);
        assertEquals(1, this.project.getMembers().size());
        assertTrue(this.project.getMembers().contains(member1));
        Member member2 = new Member(new User("Test-user", "password"), this.project);
        this.project.getMembers().add(member2);
        assertTrue(this.project.getMembers().contains(member2));
        assertTrue(this.project.getMembers().contains(member1));
        this.project.removeMember(member1);
        assertEquals(1, this.project.getMembers().size());
        assertTrue(this.project.getMembers().contains(member2));
        assertFalse(this.project.getMembers().contains(member1));
    }

    @Test
    public void getAddRemoveLeaderWorkingAsIntended() throws Exception {
        assertNotNull(this.project.getLeaders());
        assertEquals(0, this.project.getLeaders().size());
        Leader leader1 = new Leader(new User("Test-user", "password"), this.project);
        this.project.addLeader(leader1);
        assertTrue(this.project.getLeaders().contains(leader1));
        assertEquals(1, this.project.getLeaders().size());
        Leader leader2 = new Leader(new User("Test-user", "password"), this.project);
        assertTrue(this.project.getLeaders().add(leader2));
        assertTrue(this.project.getLeaders().remove(leader1));
        assertFalse(this.project.getLeaders().contains(leader1));
        assertEquals(1, this.project.getLeaders().size());
        assertTrue(this.project.getLeaders().contains(leader2));
    }

    public Task generateTask() {
        return new Task(Integer.toString(new Random().nextInt(Integer.MAX_VALUE)));
    }

}