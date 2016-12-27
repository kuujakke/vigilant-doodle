package logiikka;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 27.12.2016.
 */
public class LeaderTest {
    private Project project;
    private Leader leader;

    @Before
    public void setUp() throws Exception {
        this.project = new Project("Test-project");
        this.project.addTask(new Task("Test-task"));
        this.leader = new Leader("Test-leader");
        this.project.leaders.add(this.leader);
    }

    @Test
    public void addMemberWorkingAsIntended() throws Exception {
        this.leader.addMember(new Member("Timo"));
        assertEquals(1, this.project.members.size());
    }

    @Test
    public void removeMemberWorkingAsIntended() throws Exception {
        Member member = new Member("Test-member");
        this.project.members.add(member);
        this.leader.removeMember(member);
        assertFalse(this.project.members.contains(member));
        assertFalse(member.project == this.project);
    }

    @Test
    public void promoteToLeaderWorkingAsIntended() throws Exception {

    }

    @Test
    public void assignTaskMasterWorkingAsIntended() throws Exception {

    }
}