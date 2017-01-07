package logic.schemes.project;

import config.Configuration;
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
    private Configuration configuration;

    @Before
    public void setUp() throws Exception {
        this.configuration = new Configuration();
        this.roleFactory = new RoleFactory(this.configuration);
        this.projectFactory = new ProjectFactory(this.configuration);
        this.project = projectFactory.createProject();
        this.user = new User(
                this.configuration.getUserName(),
                this.configuration.getUserPassword()
        );
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