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

    Project project;
    RoleFactory roleFactory;
    User user;

    @Before
    public void setUp() throws Exception {
        this.roleFactory = new RoleFactory();
        this.user = new User("TestUser", "password");
        this.project = new Project("Tehtävienhallintajärjestelmä", this.roleFactory.createLeader(this.user));
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
        assertEquals(0, this.project.members.size());
        assertNotNull(this.project.members);
        Member member1 = new Member(new User("Test-user", "password"));
        this.project.addMember(member1);
        assertEquals(1, this.project.members.size());
        assertTrue(this.project.members.contains(member1));
        Member member2 = new Member(new User("Test-user", "password"));
        this.project.members.add(member2);
        assertTrue(this.project.members.contains(member2));
        assertTrue(this.project.members.contains(member1));
        this.project.removeMember(member1);
        assertEquals(1, this.project.members.size());
        assertTrue(this.project.members.contains(member2));
        assertFalse(this.project.members.contains(member1));
    }

    @Test
    public void getAddRemoveLeaderWorkingAsIntended() throws Exception {
        assertNotNull(this.project.leaders);
        assertEquals(1, this.project.leaders.size());
        Leader leader1 = new Leader(new User("Test-user", "password"));
        assertTrue(this.project.leaders.add(leader1));
        assertTrue(this.project.leaders.contains(leader1));
        assertEquals(2, this.project.leaders.size());
        Leader leader2 = new Leader(new User("Test-user", "password"));
        assertTrue(this.project.leaders.add(leader2));
        assertTrue(this.project.leaders.remove(leader1));
        assertFalse(this.project.leaders.contains(leader1));
        assertEquals(2, this.project.leaders.size());
        assertTrue(this.project.leaders.contains(leader2));
    }

    public Task generateTask() {
        return new Task(Integer.toString(new Random().nextInt(Integer.MAX_VALUE)),  new Supervisor(new User("TestUser", "password")));
    }

}