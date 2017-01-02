package logiikka;

import org.junit.Before;

/**
 * Created by kuujakke on 27.12.2016.
 */
public class LeaderTest {

    private Project project;
    private Leader leader;
    private User user;
    private ProjectFactory projectFactory;

    @Before
    public void setUp() throws Exception {
        this.projectFactory = new ProjectFactory();
        this.user = new User("Test-user", "password");
        this.leader = this.projectFactory.createLeader(this.user, this.project);
        this.leader.setProject(this.project);
        this.project = new Project("Test-project");
        this.project.leaders.add(this.leader);
    }

}