package logiikka;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 27.12.2016.
 */
public class MemberTest {

    Member member;
    Project project;
    User user;
    Leader leader;
    private ProjectFactory projectFactory;

    @Before
    public void setUp() throws Exception {
        this.user = new User("TestUser", "password");
        this.projectFactory = new ProjectFactory();
        this.project = this.projectFactory.createProject("TestProject");
        this.leader = this.projectFactory.createLeader(this.user, this.project);
        this.member = this.projectFactory.createMember(this.user, this.project);
    }

    @Test
    public void getTasks() throws Exception {
        Task task = generateTask();
        this.member.getTasks().add(task);
        ArrayList<Task> tasks = this.member.getTasks();
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