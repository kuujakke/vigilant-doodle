package logiikka;

import org.junit.Before;

/**
 * Created by kuujakke on 27.12.2016.
 */
public class LeaderTest {

    private Project project;
    private Leader leader;
    private User user;
    private RoleFactory roleFactory;

    @Before
    public void setUp() throws Exception {
        this.roleFactory = new RoleFactory();
        this.user = new User("Test-user", "password");
        this.leader = this.roleFactory.createLeader(this.user, this.project);
        this.leader.setProject(this.project);
        this.project = new Project("Test-project");
        this.project.addLeader(this.leader);
    }

}