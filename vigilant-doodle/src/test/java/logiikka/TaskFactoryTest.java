package logiikka;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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