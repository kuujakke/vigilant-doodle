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

    @Before
    public void setUp() throws Exception {
        this.user = new User("TestUser");
        this.project = new Project("TestProject", this.leader);
        this.leader = new Leader(this.user.getName(), this.user);
        this.member = new Member(this.user.getName(), this.user);
    }

    @Test
    public void getTasks() throws Exception {
        Task task = generateTask();
        this.member.tasks.add(task);
        ArrayList<Task> tasks = this.member.getTasks();
        assertEquals(1, tasks.size());
        assertTrue(tasks.contains(task));
    }

    public Task generateTask() {
        return new Task(Integer.toString(new Random().nextInt(Integer.MAX_VALUE)), "TestStatus",new Supervisor("TestSupervisor", new User("TestUser")));
    }

}