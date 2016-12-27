package logiikka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 27.12.2016.
 */
public class ProjectTest {

    Project project;

    @Before
    public void setUp() throws Exception {
        this.project = new Project("Toiminnanohjausjärjestelmä");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void toStringWorkingAsIntended() throws Exception {
        String projectToString = this.project.toString();
        assertEquals("Toiminnanohjausjärjestelmä", projectToString);
    }

    @Test
    public void addTaskWorkingAsIntended() throws Exception {
        this.project.addTask(new Task());
        assertEquals(1, this.project.getTasks().size());
    }

    @Test
    public void getTasksWorkingAsIntended() throws Exception {
        this.project.addTask(new Task());
        this.project.addTask(new Task());
        ArrayList<Task> tasks = this.project.getTasks();
        assertEquals(2, tasks.size());
    }

    @Test
    public void deleteTaskWorkingAsIntended() throws Exception {
        Task task = new Task();
        this.project.addTask(task);
        this.project.deleteTask(task);
        assertEquals(0, this.project.tasks.size());
    }

    @Test
    public void addMemberWorkingAsIntended() throws Exception {
        Member member = new Member("Teuvo");
        this.project.addMember(member);
        assertEquals(1, this.project.members.size());
        assertTrue(this.project.members.contains(member));
    }

    @Test
    public void removeMemberWorkingAsIntended() throws Exception {
        Member member = new Member("Topias");
        this.project.addMember(member);
        this.project.removeMember(member);
        assertEquals(0, this.project.members.size());
        assertFalse(this.project.members.contains(member));
    }

    @Test
    public void addLeaderWorkingAsIntended() throws Exception {
        Leader leader = new Leader("Hjallis");
        this.project.leaders.add(leader);
        assertTrue(this.project.leaders.contains(leader));
        assertEquals(1, this.project.leaders.size());
    }

    @Test
    public void removeLeaderWorkingAsIntended() throws Exception {
        Leader leader = new Leader("Harri");
        this.project.leaders.remove(leader);
        assertFalse(this.project.leaders.contains(leader));
        assertEquals(0, this.project.leaders.size());
    }

}