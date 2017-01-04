package logic.schemes.project;

import logic.schemes.project.Project;
import logic.schemes.project.ProjectFactory;
import org.junit.Before;
import org.junit.Test;
import logic.roles.projectroles.Leader;
import logic.roles.projectroles.Member;
import logic.roles.RoleFactory;
import logic.login.User;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 30.12.2016.
 */
public class ProjectFactoryTest {

    private RoleFactory roleFactory;
    private ProjectFactory projectFactory;
    private Project project;
    private User user;

    @Before
    public void setUp() throws Exception {
        this.roleFactory = new RoleFactory();
        this.projectFactory = new ProjectFactory();
        this.project = projectFactory.createProject();
        this.user = new User("TestUser", "password");
    }

    @Test
    public void manufactureMember() throws Exception {
        Member member = this.roleFactory.createMember(this.user, this.project);
        assertEquals(this.user, member.getUser());
    }

    @Test
    public void manufactureLeader() throws Exception {
        Leader leader = this.roleFactory.createLeader(this.user, this.project);
        assertEquals(this.user, leader.getUser());
    }

}