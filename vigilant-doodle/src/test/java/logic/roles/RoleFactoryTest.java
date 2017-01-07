package logic.roles;

import logic.DefaultFactory;
import logic.schemes.project.Project;
import org.junit.Before;
import org.junit.Test;
import logic.roles.projectroles.Leader;
import logic.login.User;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 4.1.2017.
 */
public class RoleFactoryTest {

    private DefaultFactory defaultFactory;
    private User user;
    private Project project;

    @Before
    public void setUp() throws Exception {
        this.defaultFactory = new DefaultFactory();
        this.user = this.defaultFactory.createUser();
        this.project = this.defaultFactory.createProject();
    }

    @Test
    public void createLeader() throws Exception {
        Leader leader = defaultFactory.createLeader(this.user, this.project);
        assertTrue(this.user == leader.getUser());
    }

    @Test
    public void createMember() throws Exception {

    }

    @Test
    public void createWorker() throws Exception {

    }

    @Test
    public void createSupervisor() throws Exception {

    }

}