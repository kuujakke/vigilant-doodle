package config;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 4.1.2017.
 */

public class ConfigurationTest {

    Configuration config;

    @Before
    public void setUp() throws Exception {
        this.config = new Configuration();
        this.config.clear();
        this.config.load();
    }

    @Test
    public void loadDefaults() {
        Properties defaults = this.config.loadDefaults();
        assertEquals(DefaultSettings.PROJECT_NAME.toString(), defaults.getProperty("project-name"));
        assertEquals(DefaultSettings.PROJECT_DESCRIPTION.toString(), defaults.getProperty("project-description"));
        assertEquals(DefaultSettings.TASK_NAME.toString(), defaults.getProperty("task-name"));
        assertEquals(DefaultSettings.TASK_DESCRIPTION.toString(), defaults.getProperty("task-description"));
        assertEquals(DefaultSettings.JOB_NAME.toString(), defaults.getProperty("job-name"));
        assertEquals(DefaultSettings.JOB_DESCRIPTION.toString(), defaults.getProperty("job-description"));
        assertEquals(DefaultSettings.CONFIG_FILE.toString(), defaults.getProperty("config-file"));
        assertEquals(DefaultSettings.ROLE_DESCRIPTION.toString(), defaults.getProperty("role-description"));
        assertEquals(DefaultSettings.UI_TITLE.toString(), defaults.getProperty("ui-title"));
        assertEquals(DefaultSettings.UI_HEIGHT.toString(), defaults.getProperty("ui-height"));
        assertEquals(DefaultSettings.UI_WIDTH.toString(), defaults.getProperty("ui-width"));
    }

    @Test
    public void loadSaveWorkingAsIntended() throws Exception {
        this.config.clear();
        this.config.setProjectName("Test");
        this.config.save();
        this.config.load();
        assertEquals("Test", config.getProjectName());
        this.config.setProjectDescription("A project for testing purposes.");
        this.config.save();
        this.config.load();
        assertEquals("A project for testing purposes.", config.getProjectDescription());
        File f = new File(DefaultSettings.CONFIG_FILE.toString());
        assertTrue(f.exists());
    }
    @Test
    public void getPropertyTest() {
        assertEquals(DefaultSettings.PROJECT_NAME.toString(), config.getProjectName());
        assertEquals(DefaultSettings.PROJECT_DESCRIPTION.toString(), config.getProjectDescription());
        assertEquals(DefaultSettings.TASK_NAME.toString(), config.getTaskName());
        assertEquals(DefaultSettings.TASK_DESCRIPTION.toString(), config.getTaskDescription());
        assertEquals(DefaultSettings.JOB_NAME.toString(), config.getJobName());
        assertEquals(DefaultSettings.JOB_DESCRIPTION.toString(), config.getJobDescription());
        assertEquals(DefaultSettings.CONFIG_FILE.toString(), config.getConfigFile());
        assertEquals(DefaultSettings.ROLE_DESCRIPTION.toString(), config.getRoleDescription());
        assertEquals(DefaultSettings.UI_TITLE.toString(), config.getUITitle());
        assertEquals(Integer.parseInt(DefaultSettings.UI_HEIGHT.toString()), config.getUIHeight());
        assertEquals(Integer.parseInt(DefaultSettings.UI_WIDTH.toString()), config.getUIWidth());
    }
     @Test
    public void clear() {
        this.config.clear();
        File config = new File(DefaultSettings.CONFIG_FILE.toString());
        assertFalse(config.exists());
     }

}