package logic.login;

import config.Configuration;
import config.DefaultSettings;
import logic.DefaultFactory;
import logic.roles.projectroles.Member;
import logic.roles.taskroles.Worker;
import logic.schemes.project.Project;
import logic.schemes.task.Task;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kuujakke on 11.1.2017.
 */
public class UserTest {
    private DefaultFactory defaultFactory;
    private User user;
    private Configuration configuration;
    private Project project;
    private Task task;

    @Before
    public void setUp() throws Exception {
        this.configuration = new Configuration();
        this.defaultFactory = new DefaultFactory(this.configuration);
        this.user = this.defaultFactory.createUser();
        this.project = this.defaultFactory.createProject();
        this.task = this.defaultFactory.createTask();
        project.addTask(task);
    }

    @Test
    public void allProjects() throws Exception {
        assertThat(this.user.allProjects()).isNotNull();
        this.project.addMember(this.defaultFactory.createMember(this.user, project));
        assertThat(this.user.allProjects()).contains(project);
    }

    @Test
    public void allTasks() throws Exception {
        assertThat(this.user.allTasks()).isNotNull();
        this.task.addWorker(this.defaultFactory.createWorker(this.user, this.task));
        assertThat(this.user.allTasks()).contains(task);
    }

    @Test
    public void removeTask() throws Exception {
        Worker worker = this.defaultFactory.createWorker(this.user, this.task);
        this.task.addWorker(worker);
        assertThat(this.user.allTasks()).contains(this.task);
        this.user.removeTask(this.task);
        assertThat(this.user.allTasks()).doesNotContain(this.task);
        assertThat(this.task.hasWorker(worker)).isFalse();
    }

    @Test
    public void allRoles() throws Exception {
        assertThat(this.user.allRoles()).isNotNull();
        Worker worker = this.defaultFactory.createWorker(this.user, this.task);
        Member member = this.defaultFactory.createMember(this.user, this.project);
        this.user.addRole(worker);
        this.user.addRole(member);
        assertThat(this.user.allRoles()).isNotEmpty();
        assertThat(this.user.allRoles()).contains(worker);
        assertThat(this.user.allRoles()).contains(member);
    }

    @Test
    public void createProject() throws Exception {
        this.user.createProject("Test");
        assertThat(this.user.allProjects().size()).isEqualTo(1);
        assertThat(this.user.allProjects().get(0).getName()).isEqualTo("Test");
    }

    @Test
    public void joinProject() throws Exception {
        assertThat(this.user.allProjects()).doesNotContain(this.project);
        assertThat(this.user.allProjects().size()).isEqualTo(0);
        assertThat(this.user.allRoles().size()).isEqualTo(0);
        this.user.joinProject(this.project);
        assertThat(this.user.allProjects()).contains(this.project);
        assertThat(this.user.allProjects().size()).isEqualTo(1);
        assertThat(this.user.allRoles().size()).isEqualTo(1);
    }

    @Test
    public void setRealName() throws Exception {
        this.user.setRealName("Test");
        assertThat(this.user.getRealName()).isEqualTo("Test");
    }

    @Test
    public void setUserName() throws Exception {
        this.user.setUserName("Test");
        assertThat(this.user.getUserName()).isEqualTo("Test");
    }

    @Test
    public void hasRole() throws Exception {
        Member member = this.defaultFactory.createMember(this.user, this.project);
        assertThat(this.user.allRoles()).contains(member);
        assertThat(this.user.hasRole(member)).isTrue();
    }

    @Test
    public void hasScheme() throws Exception {
        this.user.allProjects().add(this.project);
        assertThat(this.user.hasScheme(this.project));
    }

}