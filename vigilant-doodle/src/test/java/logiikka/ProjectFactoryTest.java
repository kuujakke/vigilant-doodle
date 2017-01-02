package logiikka;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 30.12.2016.
 */
public class ProjectFactoryTest {

    private ProjectFactory projectFactory;
    private Project project;
    private User user;

    @Before
    public void setUp() throws Exception {
        this.projectFactory = new ProjectFactory();
        this.project = new Project("TestProject");
        this.user = new User("TestUser", "password");
    }

    @Test
    public void manufactureMember() throws Exception {
        Member member = this.projectFactory.createMember(this.user, this.project);
        assertEquals(this.user, member.getUser());
    }

    @Test
    public void manufactureLeader() throws Exception {
        Leader leader = this.projectFactory.createLeader(this.user, this.project);
        assertEquals(this.user, leader.getUser());
    }

}