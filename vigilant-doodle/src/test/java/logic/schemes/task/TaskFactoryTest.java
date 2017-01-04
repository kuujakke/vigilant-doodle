package logic.schemes.task;

import logic.schemes.project.Project;
import logic.schemes.project.ProjectFactory;
import org.junit.Before;

/**
 * Created by kuujakke on 2.1.2017.
 */
public class TaskFactoryTest {

    Project project;

    @Before
    public void TaskFactoryTest() throws Exception {
        this.project = new ProjectFactory().createProject();
    }

}