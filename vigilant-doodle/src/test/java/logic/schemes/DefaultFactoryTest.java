package logic.schemes;

import config.Configuration;
import logic.DefaultFactory;
import logic.schemes.project.Project;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 4.1.2017.
 */
public class DefaultFactoryTest {

    private DefaultFactory defaultFactory;
    private Configuration config;

    @Before
    public void setUp() throws Exception {
        this.defaultFactory = new DefaultFactory();
        this.config = this.defaultFactory.getConfig();
    }

    @Test
    public void createProject() throws Exception {
        Project project = this.defaultFactory.createProject();
        assertEquals(this.config.getProjectName(), project.getName());
    }

    @Test
    public void createTask() throws Exception {

    }

    @Test
    public void createUser() throws Exception {

    }

    @Test
    public void createLeader() throws Exception {

    }

}