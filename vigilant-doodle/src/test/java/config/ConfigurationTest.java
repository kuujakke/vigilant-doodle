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
        this.config.clear();
        this.config.setProjectName("Test");
        this.config.save();
        this.config.load();
        assertThat(config.getProjectName()).isEqualTo("Test");
        this.config.setProjectDescription("A project for testing purposes.");
        this.config.save();
        this.config.load();
        assertThat(config.getProjectDescription()).isEqualTo("A project for testing purposes.");
        File f = new File(DefaultSettings.CONFIG_FILE.toString());
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
    public void clear() {
        this.config.clear();
        File config = new File(DefaultSettings.CONFIG_FILE.toString());
        assertThat(config.exists()).isFalse();
     }

}