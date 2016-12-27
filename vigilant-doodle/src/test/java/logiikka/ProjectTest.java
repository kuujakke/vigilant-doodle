package logiikka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 27.12.2016.
 */
public class ProjectTest {

    Project project;

    @Before
    public void setUp() throws Exception {
        this.project = new Project("Toiminnanohjausjärjestelmä");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void projectToStringWorksCorrectly() throws Exception {
        String projectToString = this.project.toString();
        assertEquals("Toiminnanohjausjärjestelmä", projectToString);
    }

    @Test
    public void addTask() throws Exception {

    }

    @Test
    public void getTasks() throws Exception {

    }

    @Test
    public void deleteTask() throws Exception {

    }

    @Test
    public void addMember() throws Exception {

    }

    @Test
    public void removeMember() throws Exception {

    }

    @Test
    public void addLeader() throws Exception {

    }

    @Test
    public void removeLeader() throws Exception {

    }

}