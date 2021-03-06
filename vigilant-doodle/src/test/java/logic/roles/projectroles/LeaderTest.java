package logic.roles.projectroles;

import config.Configuration;
import logic.schemes.project.Project;
import logic.schemes.project.ProjectFactory;
import org.junit.Before;
import logic.roles.RoleFactory;
import logic.login.User;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kuujakke on 27.12.2016.
 */
public class LeaderTest {

    private Project project;
    private Leader leader;
    private User user;
    private RoleFactory roleFactory;
    private Configuration configuration;
    private ProjectFactory projectFactory;

    @Before
    public void setUp() throws Exception {
        this.configuration = new Configuration();
        this.roleFactory = new RoleFactory(this.configuration);
        this.projectFactory = new ProjectFactory(this.configuration);
        this.project = this.projectFactory.createScheme();
        this.user = new User(
                this.configuration.getUserName(),
                this.configuration.getUserPassword());
        this.leader = this.roleFactory.createLeader(this.user, this.project);
    }

    @Test
    public void setProject() {
        assertThat(this.leader.getProject()).isSameAs(this.project);
        Project project = this.projectFactory.createScheme();
        this.leader.setProject(project);
        assertThat(this.leader.getProject()).isSameAs(project);
    }

}