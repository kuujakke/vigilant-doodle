package config;

import java.io.*;
import java.util.Properties;

/**
 * Class for loading and writing config.properties -file in the application root folder.
 * You can set and get properties after a new instance is created.
 * If a property is not present in the configuration file, this should return
 * a value from the DefaultSettings.
 */

public class Configuration {

    private final Properties properties;

    public Configuration() {
        this.properties = load();
    }

    /**
     * A method loads application settings file from the application root folder
     * into a new Properties object.
     *
     * @return a new instance of Properties with config.properties loaded into it.
     */
    public Properties load() {
        Properties loadedProperties = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("config.properties");
            loadedProperties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedProperties;
    }

    /**
     * Saves the current set of Properties into a file on the application root folder,
     * overwriting any existing file.
     */
    public void save() {
        OutputStream output = null;
        try {
            output = new FileOutputStream("config.properties");
            this.properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getProjectName() {
        return this.properties.getProperty("project-name", DefaultSettings.PROJECT_NAME.toString());
    }

    public void setProjectName(String projectName) {
        this.properties.setProperty("project-name", projectName);
    }

    public String getProjectDescription() {
        return this.properties.getProperty("project-description", DefaultSettings.PROJECT_DESCRIPTION.toString());
    }

    public void setProjectDescription(String projectDescription) {
        this.properties.setProperty("project-description", projectDescription);
    }

    public String getTaskName() {
        return this.properties.getProperty("task-name", DefaultSettings.TASK_NAME.toString());
    }

    public void setTaskName(String taskName) {
        this.properties.setProperty("task-name", taskName);
    }

    public String getTaskDescription() {
        return this.properties.getProperty("task-description", DefaultSettings.TASK_DESCRIPTION.toString());
    }

    public void setTaskDescription(String taskDescription) {
        this.properties.setProperty("task-description", taskDescription);
    }

    public String getJobName() {
        return this.properties.getProperty("job-name", DefaultSettings.JOB_NAME.toString());
    }

    public void setJobName(String jobName) {
        this.properties.setProperty("job-name", jobName);
    }

    public String getJobDescription() {
        return this.properties.getProperty("job-description", DefaultSettings.JOB_DESCRIPTION.toString());
    }

    public void setJobDescription(String jobDescription) {
        this.properties.setProperty("job-description", jobDescription);
    }

    public String getUserName() {
        return this.properties.getProperty("user-name", DefaultSettings.USER_NAME.toString());
    }

    public void setUserName(String userName) {
        this.properties.setProperty("user-name", userName);
    }

    public String getUserPassword() {
        return this.properties.getProperty("user-password", DefaultSettings.USER_PASSWORD.toString());
    }

    public void setUserPassword(String userPassword) {
        this.properties.setProperty("user-password", userPassword);
    }

    public String getRoleDescription() {
        return this.properties.getProperty("role-description", DefaultSettings.ROLE_DESCRIPTION.toString());
    }

    public void setRoleDescription(String userDescription) {
        this.properties.setProperty("role-description", userDescription);
    }

    public String getDBUser() {
        return this.properties.getProperty("db-user");
    }

    public void setDBUser(String dbUser) {
        this.properties.setProperty("db-user", dbUser);
    }

    public String getDBpassword() {
        return this.properties.getProperty("db-password");
    }

    public void setDBPassword(String dbPassword) {
        this.properties.setProperty("db-password", dbPassword);
    }

    public String getDBName() {
        return this.properties.getProperty("db-name");
    }

    public void setDBName(String dbName) {
        this.properties.setProperty("db-name", dbName);
    }

    public String getDBHostname() {
        return this.properties.getProperty("db-hostname");
    }

    public void setDBHostname(String dbHostname) {
        this.properties.setProperty("db-hostname", dbHostname);
    }

    public int getDBPort() {
        return Integer.parseInt(this.properties.getProperty("db-port"));
    }

    public void setDBPort(int dbPort) {
        this.properties.setProperty("db-port", String.valueOf(dbPort));
    }

    public void setUITitle(String title) {
        this.properties.setProperty("ui-title", title);
    }

    public String getUITitle() {
        return this.properties.getProperty("ui-title", DefaultSettings.UI_TITLE.toString());
    }

    public int getUIWidth() {
        return Integer.parseInt(this.properties.getProperty("ui-width", DefaultSettings.UI_WIDTH.toString()));
    }

    public void setUIWidth(int width) {
        this.properties.setProperty("ui-width", String.valueOf(width));
    }

    public int getUIHeight() {
        return Integer.parseInt(this.properties.getProperty("ui-height", DefaultSettings.UI_HEIGHT.toString()));
    }

    public void setUIHeight(int height) {
        this.properties.setProperty("ui-height", String.valueOf(height));
    }
}
