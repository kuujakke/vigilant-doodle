package logic.roles.projectroles;

import config.Configuration;
import logic.DefaultFactory;
import logic.schemes.Scheme;
import logic.schemes.project.Project;
import logic.schemes.task.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

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
        assertEquals(0, member.getTasks().size());

        member.addResponsibility(task);
        assertTrue(member.getTasks().contains(task));
    }

    @Test
    public void getProjectWorkingAsIntended() throws Exception {
        Member member = this.defaultFactory.createMember(this.project);
        assertEquals(this.project, member.getProject());
    }

}