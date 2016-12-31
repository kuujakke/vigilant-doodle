package logiikka;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 27.12.2016.
 */
public class LeaderTest {

    private Project project;

    private Leader leader;
    @Before
    public void setUp() throws Exception {
        this.project = new Project("Test-project", this.leader);
        this.project.addTask(new Task("Test-task", "TestStatus", new Supervisor("TestSupervisor", new User("TestUser"))));
        this.leader = new Leader("Test-leader", new User("Test-user"));
        this.project.leaders.add(this.leader);
    }

    @Test
    public void addMemberWorkingAsIntended() throws Exception {
        this.leader.addMember(new Member("Timo", new User("Test-user")));
        assertEquals(1, this.project.members.size());
    }

    @Test
    public void removeMemberWorkingAsIntended() throws Exception {
        Member member = new Member("Test-member", new User("Test-user"));
        this.project.members.add(member);
        this.leader.removeMember(member);
        assertFalse(this.project.members.contains(member));
    }

    @Test
    public void promoteToLeader() throws Exception {
        Member member = new Member("TestMember", new User("TestUser"));
        assertFalse(this.project.leaders.contains(member));
        this.leader.promoteToLeader(member, this.project);
        assertTrue(this.project.leaders.contains(member.getUser().roles.get(0)));
    }

    @Test
    public void assignSupervisor() throws Exception {
        Member member = new Member("TestMember", new User("TestUser"));
        this.leader.assignSupervisor(member, this.project.getTasks().get(0));
    }
}