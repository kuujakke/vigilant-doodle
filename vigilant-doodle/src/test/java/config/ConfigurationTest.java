package config;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

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
        assertThat(defaults.getProperty("project-name")).isEqualTo(DefaultSettings.PROJECT_NAME.toString());
        assertThat(defaults.getProperty("project-description")).isEqualTo(DefaultSettings.PROJECT_DESCRIPTION.toString());
        assertThat(defaults.getProperty("task-name")).isEqualTo(DefaultSettings.TASK_NAME.toString());
        assertThat(defaults.getProperty("task-description")).isEqualTo(DefaultSettings.TASK_DESCRIPTION.toString());
        assertThat(defaults.getProperty("job-name")).isEqualTo(DefaultSettings.JOB_NAME.toString());
        assertThat(defaults.getProperty("job-description")).isEqualTo(DefaultSettings.JOB_DESCRIPTION.toString());
        assertThat(defaults.getProperty("config-file")).isEqualTo(DefaultSettings.CONFIG_FILE.toString());
        assertThat(defaults.getProperty("role-description")).isEqualTo(DefaultSettings.ROLE_DESCRIPTION.toString());
        assertThat(defaults.getProperty("ui-title")).isEqualTo(DefaultSettings.UI_TITLE.toString());
        assertThat(defaults.getProperty("ui-height")).isEqualTo(DefaultSettings.UI_HEIGHT.toString());
        assertThat(defaults.getProperty("ui-width")).isEqualTo(DefaultSettings.UI_WIDTH.toString());
    }

    @Test
    public void loadSaveWorkingAsIntended() throws Exception {
        File f = new File(DefaultSettings.CONFIG_FILE.toString());
        this.config.clear();
        assertThat(f.exists()).isFalse();
        this.config.setProjectName("Test");
        this.config.save();
        assertThat(f.exists()).isTrue();
        this.config.load();
        assertThat(config.getProjectName()).isEqualTo("Test");
        this.config.setProjectDescription("A project for testing purposes.");
        this.config.save();
        assertThat(f.exists()).isTrue();
        this.config.load();
        assertThat(this.config.getProjectName()).isEqualTo("Test");
        assertThat(config.getProjectDescription()).isEqualTo("A project for testing purposes.");
        assertThat(f.exists()).isTrue();
    }
    @Test
    public void getPropertyTest() {
        assertThat(config.getProjectName()).isEqualTo(DefaultSettings.PROJECT_NAME.toString());
        assertThat(config.getProjectDescription()).isEqualTo(DefaultSettings.PROJECT_DESCRIPTION.toString());
        assertThat(config.getTaskName()).isEqualTo(DefaultSettings.TASK_NAME.toString());
        assertThat(config.getTaskDescription()).isEqualTo(DefaultSettings.TASK_DESCRIPTION.toString());
        assertThat(config.getJobName()).isEqualTo(DefaultSettings.JOB_NAME.toString());
        assertThat(config.getJobDescription()).isEqualTo(DefaultSettings.JOB_DESCRIPTION.toString());
        assertThat(config.getConfigFile()).isEqualTo(DefaultSettings.CONFIG_FILE.toString());
        assertThat(config.getRoleDescription()).isEqualTo(DefaultSettings.ROLE_DESCRIPTION.toString());
        assertThat(config.getUITitle()).isEqualTo(DefaultSettings.UI_TITLE.toString());
        assertThat(config.getUIHeight()).isEqualTo(Integer.parseInt(DefaultSettings.UI_HEIGHT.toString()));
        assertThat(config.getUIWidth()).isEqualTo(Integer.parseInt(DefaultSettings.UI_WIDTH.toString()));
    }

    @Test
    public void setPropertyTest() {
        config.setProjectName("Test");
        assertThat(config.getProjectName()).isEqualTo("Test");
        config.setProjectDescription("Test");
        assertThat(config.getProjectDescription()).isEqualTo("Test");
        config.setTaskName("Test");
        assertThat(config.getTaskName()).isEqualTo("Test");
        config.setTaskDescription("Test");
        assertThat(config.getTaskDescription()).isEqualTo("Test");
        config.setJobName("Test");
        assertThat(config.getJobName()).isEqualTo("Test");
        config.setJobDescription("Test");
        assertThat(config.getJobDescription()).isEqualTo("Test");
        config.setUserName("Test");
        assertThat(config.getUserName()).isEqualTo("Test");
        config.setUserPassword("Test");
        assertThat(config.getUserPassword()).isEqualTo("Test");
        config.setRoleDescription("Test");
        assertThat(config.getRoleDescription()).isEqualTo("Test");
        config.setDBUser("Test");
        assertThat(config.getDBUser()).isEqualTo("Test");
        config.setDBName("Test");
        assertThat(config.getDBName()).isEqualTo("Test");
        config.setDBHostname("Test");
        assertThat(config.getDBHostname()).isEqualTo("Test");
        config.setDBPassword("Test");
        assertThat(config.getDBpassword()).isEqualTo("Test");
        config.setDBPort(123);
        assertThat(config.getDBPort()).isEqualTo("123");
        config.setUITitle("Test");
        assertThat(config.getUITitle()).isEqualTo("Test");
        config.setUIHeight(123);
        assertThat(config.getUIHeight()).isEqualTo(123);
        config.setUIWidth(123);
        assertThat(config.getUIWidth()).isEqualTo(123);
        config.clear();
        assertThat(config.getProjectName()).isEqualTo(DefaultSettings.PROJECT_NAME.toString());
    }
     @Test
    public void clear() {
        this.config.clear();
        File config = new File(DefaultSettings.CONFIG_FILE.toString());
        assertThat(config.exists()).isFalse();
        assertThat(this.config.getProperties()).isEmpty();
     }

     @Test
    public void wrongFilename() throws Exception {
        try {
            assertThat(new Configuration("not-a-filename")).isNotNull();
        } catch (Exception e) {
            assertThat(e).isNull();
        }
     }

}