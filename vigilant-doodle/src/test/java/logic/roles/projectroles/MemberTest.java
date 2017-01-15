package logic.roles.projectroles;

import config.Configuration;
import logic.DefaultFactory;
import logic.schemes.Scheme;
import logic.schemes.project.Project;
import logic.schemes.task.Task;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by kuujakke on 27.12.2016.
 */
public class MemberTest {

    private Configuration configuration;
    private DefaultFactory defaultFactory;
    private Project project;

    @Before
    public void setUp() throws Exception {
        this.configuration = new Configuration();
        this.defaultFactory = new DefaultFactory(this.configuration);
        this.project = this.defaultFactory.createProject();
    }

    @Test
    public void getTasks() throws Exception {
        Task task = this.defaultFactory.createTask();
        Member member = this.defaultFactory.createMember(this.project);
        assertThat(member.getTasks()).isEmpty();

        member.addResponsibility(task);
        assertThat(member.getTasks().contains(task)).isTrue();
    }

    @Test
    public void getProjectWorkingAsIntended() throws Exception {
        Member member = this.defaultFactory.createMember(this.project);
        assertThat(member.getProject()).isEqualTo(this.project);
    }

    @Test
    public void setProjectWorkingAsIntended() {
        Member member = this.defaultFactory.createMember(this.project);
        Project project = this.defaultFactory.createProject();
        member.setProject(project);
        assertThat(member.getProject()).isSameAs(project);
        assertThat(this.project.hasMember(member)).isFalse();
        assertThat(project.hasMember(member)).isTrue();
    }

    @Test
    public void removeResponsibilityWorkingAsIntended() {
        Member member = this.defaultFactory.createMember(this.project);
        Task task = this.defaultFactory.createTask();
        member.addResponsibility(task);
        assertThat(member.hasResponsibility(task)).isTrue();
        member.removeResponsibility(task);
        assertThat(member.hasResponsibility(task)).isFalse();
    }

}