package logiikka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 27.12.2016.
 */
public class ProjectTest {

    Project project;

    @Before
    public void setUp() throws Exception {
        this.project = new Project("Tehtävienhallintajärjestelmä");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void toStringWorkingAsIntended() throws Exception {
        String projectToString = this.project.toString();
        assertEquals("Tehtävienhallintajärjestelmä", projectToString);
    }

    @Test
    public void addTaskWorkingAsIntended() throws Exception {
        this.project.addTask(generateTask());
        assertEquals(1, this.project.getTasks().size());
    }

    @Test
    public void getTasksWorkingAsIntended() throws Exception {
        this.project.addTask(generateTask());
        this.project.addTask(generateTask());
        ArrayList<Task> tasks = this.project.getTasks();
        assertEquals(2, tasks.size());
    }

    @Test
    public void deleteTaskWorkingAsIntended() throws Exception {
        Task task = generateTask();
        this.project.addTask(task);
        this.project.deleteTask(task);
        assertEquals(0, this.project.tasks.size());
        assertFalse(this.project.tasks.contains(task));
    }

    @Test
    public void addMemberWorkingAsIntended() throws Exception {
        Member member = new Member("Teuvo", this.project);
        this.project.addMember(member);
        assertEquals(1, this.project.members.size());
        assertTrue(this.project.members.contains(member));
    }

    @Test
    public void removeMemberWorkingAsIntended() throws Exception {
        Member member = new Member("Topias", this.project);
        this.project.members.add(member);
        this.project.removeMember(member);
        assertEquals(0, this.project.members.size());
        assertFalse(this.project.members.contains(member));
    }

    @Test
    public void addLeaderWorkingAsIntended() throws Exception {
        Leader leader = new Leader("Hjallis", this.project);
        this.project.leaders.add(leader);
        assertTrue(this.project.leaders.contains(leader));
        assertEquals(1, this.project.leaders.size());
    }

    @Test
    public void removeLeaderWorkingAsIntended() throws Exception {
        Leader leader = new Leader("Harri", this.project);
        this.project.leaders.remove(leader);
        assertFalse(this.project.leaders.contains(leader));
        assertEquals(0, this.project.leaders.size());
    }

    public Task generateTask() {
        return new Task(Integer.toString(new Random().nextInt(Integer.MAX_VALUE)));
    }

}