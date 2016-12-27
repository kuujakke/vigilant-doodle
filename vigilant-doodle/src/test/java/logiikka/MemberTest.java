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

    @Before
    public void setUp() throws Exception {
        this.member = new Member("Teuvo");
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
        return new Task(Integer.toString(new Random().nextInt(Integer.MAX_VALUE)));
    }

}