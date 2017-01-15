package logic.schemes.project;

import logic.DefaultFactory;
import logic.schemes.task.Task;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import logic.roles.projectroles.Leader;
import logic.roles.projectroles.Member;
import logic.login.User;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by kuujakke on 27.12.2016.
 */
public class ProjectTest {

    private Project project;
    private DefaultFactory defaultFactory;

    @Before
    public void setUp() throws Exception {
        this.defaultFactory = new DefaultFactory();
        this.project = this.defaultFactory.createProject();
    }

    @After
    public void tearDown() throws Exception {
        this.project = this.defaultFactory.createProject();
    }

    @Test
    public void toStringWorkingAsIntended() throws Exception {
        assertThat(this.project.toString()).isNotNull();
    }

    @Test
    public void addGetRemoveTaskWorkingAsIntended() throws Exception {
        Task task = this.defaultFactory.createTask();
        this.project.addTask(task);
        assertThat(this.project.getTasks()).hasSize(1);
        assertThat(this.project.getTasks().contains(task)).isTrue();
        this.project.addTask(this.defaultFactory.createTask());
        this.project.addTask(this.defaultFactory.createTask());
        assertThat(this.project.getTasks()).hasSize(3);
        this.project.addTask(task);
        assertThat(this.project.getTasks()).hasSize(3);
        this.project.deleteTask(task);
        assertThat(this.project.tasks).hasSize(2);
        assertThat(this.project.tasks.contains(task)).isFalse();
    }

    @Test
    public void getAddRemoveMemberWorkingAsIntended() throws Exception {
        assertThat(this.project.getMembers()).isEmpty();
        assertThat(this.project.getMembers()).isNotNull();
        User user1 = this.defaultFactory.createUser();
        User user2 = this.defaultFactory.createUser();
        Member member1 = this.defaultFactory.createMember(user1, this.project);
        Member member2 = this.defaultFactory.createMember(user2, this.project);

        assertThat(this.project.getMembers()).hasSize(2);
        assertThat(this.project.hasMember(member1)).isTrue();
        assertThat(this.project.hasMember(member2)).isTrue();

        this.project.removeMember(member1);
        assertThat(this.project.getMembers()).hasSize(1);
        assertThat(this.project.hasMember(member2)).isTrue();
        assertThat(this.project.hasMember(member1)).isFalse();
    }

    @Test
    public void getAddRemoveLeaderWorkingAsIntended() throws Exception {
        assertThat(this.project.getLeaders()).isNotNull();
        assertThat(this.project.getLeaders()).isEmpty();

        User user1 = this.defaultFactory.createUser();
        User user2 = this.defaultFactory.createUser();
        Leader leader1 = this.defaultFactory.createLeader(user1, this.project);
        Leader leader2 = this.defaultFactory.createLeader(user2, this.project);

        assertThat(this.project.hasLeader(leader1)).isTrue();
        assertThat(this.project.hasLeader(leader2)).isTrue();
        assertThat(this.project.getLeaders()).hasSize(2);

        this.project.removeLeader(leader1);
        assertThat(this.project.hasLeader(leader1)).isFalse();
        assertThat(this.project.getLeaders()).hasSize(1);
        assertThat(this.project.hasLeader(leader2)).isTrue();
    }

    @Test
    public void getSetProjectName() {
        assertThat(this.project.getName()).isNotNull();
        this.project.setProjectName("TestName");
        assertThat(this.project.getName()).isEqualTo("TestName");
    }

    @Test
    public void promoteToLeaderWorking() {
        User user = this.defaultFactory.createUser();
        Member member = this.defaultFactory.createMember(user, this.project);
        assertThat(this.project.hasMember(member)).isTrue();
        assertThat(this.project.getMembers().contains(member)).isTrue();
        assertThat(this.project.getMembers().size()).isEqualTo(1).isNotNull();
        assertThat(this.project.getLeaders().size()).isEqualTo(0).isNotNull();
        this.project.promoteToLeader(member);
        assertThat(this.project.hasMember(member)).isFalse();
        assertThat(this.project.getMembers().contains(member)).isFalse();
        assertThat(this.project.getLeaders().size()).isEqualTo(1).isNotNull();
    }
}