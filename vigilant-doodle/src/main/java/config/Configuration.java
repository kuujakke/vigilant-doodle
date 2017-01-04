package config;

import java.io.*;
import java.util.Properties;

/**
 * Class for loading and writing config.properties -file in the project folder.
 * You can set and get properties after a new instance is created.
 */

public class Configuration {
    private final Properties properties;

    public Configuration() {
        this.properties = loadProperties();
    }

    public Properties loadProperties() {
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

    public void writeProperties() {
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
        return this.properties.getProperty("projectroles-name");
    }

    public void setProjectName(String projectName) {
        this.properties.setProperty("projectroles-name", projectName);
    }

    public String getProjectDescription() {
        return this.properties.getProperty("projectroles-description");
    }

    public void setProjectDescription(String projectDescription) {
        this.properties.setProperty("projectroles-description", projectDescription);
    }

    public String getTaskName() {
        return this.properties.getProperty("taskroles-name");
    }

    public void setTaskName(String taskName) {
        this.properties.setProperty("taskroles-name", taskName);
    }

    public String getTaskDescription() {
        return this.properties.getProperty("taskroles-description");
    }

    public void setTaskDescription(String taskDescription) {
        this.properties.setProperty("taskroles-description", taskDescription);
    }

    public String getJobName() {
        return this.properties.getProperty("job-name");
    }

    public void setJobName(String jobName) {
        this.properties.setProperty("job-name", jobName);
    }

    public String getJobDescription() {
        return this.properties.getProperty("job-description");
    }

    public void setJobDescription(String jobDescription) {
        this.properties.setProperty("job-description", jobDescription);
    }

    public String getUserName() {
        return this.properties.getProperty("user-name");
    }

    public void setUserName(String userName) {
        this.properties.setProperty("user-name", userName);
    }

    public String getUserPassword() {
        return this.properties.getProperty("user-password");
    }

    public void setUserPassword(String userPassword) {
        this.properties.setProperty("user-password", userPassword);
    }

    public String getRoleDescription() {
        return this.properties.getProperty("user-description");
    }

    public void setRoleDescription(String userDescription) {
        this.properties.setProperty("user-description", userDescription);
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
}
