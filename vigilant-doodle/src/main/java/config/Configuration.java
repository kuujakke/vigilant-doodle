package config;

import java.io.*;
import java.util.Properties;

/**
 * Class for managing application settings.
 * Features include loading, writing and deleting
 * config.properties -file in the application root folder.
 *
 * You can set and get properties after a new instance is created.
 * If a property is not present in the configuration file,
 * this should return a value from the DefaultSettings.
 */
public class Configuration {

    private Properties properties;

    /**
     * Constructor calls the load function to initialize the properties variable.
     *
     * If reading of the configuration file fails, it throws a FileNotFoundException.
     *
     * @throws Exception FileNotFoundException
     */
    public Configuration() throws Exception {
        try {
            load();
        } catch (Exception e) {
            throw new FileNotFoundException(DefaultSettings.CONFIG_FILE + " file not found!");
        }
    }

    /**
     * Constructor calls the load function with filename to initialize the properties variable.
     *
     * If reading of the configuration file fails, it throws a FileNotFoundException.
     *
     * @param filename String containing the filename.
     *
     * @throws Exception FileNotFoundException
     */
    public Configuration(String filename) throws Exception {
        try {
            load(filename);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(filename + " not found!");
        }
    }

    /**
     * A method loads application settings file from the application root folder
     * into a new Properties object. If settings file is not found the method loads
     * default settings and writes a new configuration file with the hard-coded default
     * values. This is useful when running this application on a new computer for the first time.
     *
     * @throws Exception FileNotFoundException if the config file was not found.
     */
    public void load() throws Exception {
        Properties loadedProperties = new Properties();
        InputStream input = null;
        File config = new File(DefaultSettings.CONFIG_FILE.toString());
        if (config.exists()) {
            try {
                input = new FileInputStream(DefaultSettings.CONFIG_FILE.toString());
                loadedProperties.load(input);
            } catch (IOException e) {
                throw new FileNotFoundException(e.getLocalizedMessage());
            }
        } else {
            loadedProperties = loadDefaults();
            this.properties = loadedProperties;
            save();
        }
        this.properties = loadedProperties;
    }
    /**
     * A method loads application settings file from the application root folder
     * into a new Properties object. If settings file is not found the method loads
     * default settings and writes a new configuration file with the hard-coded default
     * values. This is useful when running this application on a new computer for the first time.
     *
     * @param filename String containing the filename.
     *
     * @throws Exception FileNotFoundException if the config file was not found.
     */
    public void load(String filename) throws Exception {
        Properties loadedProperties = new Properties();
        InputStream input = null;
        File config = new File(filename);
        if (config.exists()) {
            try {
                input = new FileInputStream(filename);
                loadedProperties.load(input);
            } catch (IOException e) {
                throw new FileNotFoundException(e.getLocalizedMessage());
            }
        } else {
            loadedProperties = loadDefaults();
            this.properties = loadedProperties;
            save();
        }
        this.properties = loadedProperties;
    }

    /**
     * A private method for the load() method to make a new Properties object from the
     * DefaultSettings enumeration.
     *
     * @return Properties object loaded with default properties.
     */
    public Properties loadDefaults() {
        Properties props = new Properties();
        props.setProperty("project-name", DefaultSettings.PROJECT_NAME.toString());
        props.setProperty("project-description", DefaultSettings.PROJECT_DESCRIPTION.toString());
        props.setProperty("task-name", DefaultSettings.TASK_NAME.toString());
        props.setProperty("task-description", DefaultSettings.TASK_DESCRIPTION.toString());
        props.setProperty("job-name", DefaultSettings.JOB_NAME.toString());
        props.setProperty("job-description", DefaultSettings.JOB_DESCRIPTION.toString());
        props.setProperty("role-description", DefaultSettings.ROLE_DESCRIPTION.toString());
        props.setProperty("config-file", DefaultSettings.CONFIG_FILE.toString());
        props.setProperty("ui-title", DefaultSettings.UI_TITLE.toString());
        props.setProperty("ui-width", DefaultSettings.UI_WIDTH.toString());
        props.setProperty("ui-height", DefaultSettings.UI_HEIGHT.toString());
        return props;
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

    /**
     * Removes the configuration file and clears any current configuration.
     */
    public void clear() {
        File config = new File(this.getConfigFile());
        if (config.exists()) {
            try {
                config.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.properties.clear();
    }

    /**
     * Returns the property value. If the property is not set, returns DefaultSettings.VALUE
     *
     * @return String containing property value.
     */
    public String getProjectName() {
        return this.properties.getProperty("project-name", DefaultSettings.PROJECT_NAME.toString());
    }

    /**
     * Sets the property value to the param string.
     *
     * @param projectName String containing property value.
     */
    public void setProjectName(String projectName) {
        this.properties.setProperty("project-name", projectName);
    }

    /**
     * Returns the property value. If the property is not set, returns DefaultSettings.VALUE
     *
     * @return String containing property value.
     */
    public String getProjectDescription() {
        return this.properties.getProperty("project-description", DefaultSettings.PROJECT_DESCRIPTION.toString());
    }

    /**
     * Sets the property value to the param string.
     *
     * @param projectDescription String containing property value.
     */
    public void setProjectDescription(String projectDescription) {
        this.properties.setProperty("project-description", projectDescription);
    }

    /**
     * Returns the property value. If the property is not set, returns DefaultSettings.VALUE
     *
     * @return String containing property value.
     */
    public String getTaskName() {
        return this.properties.getProperty("task-name", DefaultSettings.TASK_NAME.toString());
    }

    /**
     * Sets the property value to the param string.
     *
     * @param taskName String containing property value.
     */
    public void setTaskName(String taskName) {
        this.properties.setProperty("task-name", taskName);
    }

    /**
     * Returns the property value. If the property is not set, returns DefaultSettings.VALUE
     *
     * @return String containing property value.
     */
    public String getTaskDescription() {
        return this.properties.getProperty("task-description", DefaultSettings.TASK_DESCRIPTION.toString());
    }

    /**
     * Sets the property value to the param string.
     *
     * @param taskDescription String containing property value.
     */
    public void setTaskDescription(String taskDescription) {
        this.properties.setProperty("task-description", taskDescription);
    }

    /**
     * Returns the property value. If the property is not set, returns DefaultSettings.VALUE
     *
     * @return String containing property value.
     */
    public String getJobName() {
        return this.properties.getProperty("job-name", DefaultSettings.JOB_NAME.toString());
    }

    /**
     * Sets the property value to the param string.
     *
     * @param jobName String containing property value.
     */
    public void setJobName(String jobName) {
        this.properties.setProperty("job-name", jobName);
    }

    /**
     * Returns the property value. If the property is not set, returns DefaultSettings.VALUE
     *
     * @return String containing property value.
     */
    public String getJobDescription() {
        return this.properties.getProperty("job-description", DefaultSettings.JOB_DESCRIPTION.toString());
    }

    /**
     * Sets the property value to the param string.
     *
     * @param jobDescription String containing property value.
     */
    public void setJobDescription(String jobDescription) {
        this.properties.setProperty("job-description", jobDescription);
    }

    /**
     * Returns the property value. If the property is not set, returns DefaultSettings.VALUE
     *
     * @return String containing property value.
     */
    public String getUserName() {
        return this.properties.getProperty("user-name", DefaultSettings.USER_NAME.toString());
    }

    /**
     * Sets the property value to the param string.
     *
     * @param userName String containing property value.
     */
    public void setUserName(String userName) {
        this.properties.setProperty("user-name", userName);
    }

    /**
     * Returns the property value. If the property is not set, returns DefaultSettings.VALUE
     *
     * @return String containing property value.
     */
    public String getUserPassword() {
        return this.properties.getProperty("user-password", DefaultSettings.USER_PASSWORD.toString());
    }

    /**
     * Sets the property value to the param string.
     *
     * @param userPassword String containing property value.
     */
    public void setUserPassword(String userPassword) {
        this.properties.setProperty("user-password", userPassword);
    }

    /**
     * Returns the property value. If the property is not set, returns DefaultSettings.VALUE
     *
     * @return String containing property value.
     */
    public String getRoleDescription() {
        return this.properties.getProperty("role-description", DefaultSettings.ROLE_DESCRIPTION.toString());
    }

    /**
     * Sets the property value to the param string.
     *
     * @param roleDescription String containing property value.
     */
    public void setRoleDescription(String roleDescription) {
        this.properties.setProperty("role-description", roleDescription);
    }

    /**
     * Returns the property value. If the property is not set, returns DefaultSettings.VALUE
     *
     * @return String containing property value.
     */
    public String getDBUser() {
        return this.properties.getProperty("db-user");
    }

    /**
     * Sets the property value to the param string.
     *
     * @param dbUser String containing property value.
     */
    public void setDBUser(String dbUser) {
        this.properties.setProperty("db-user", dbUser);
    }

    /**
     * Returns the property value. If the property is not set, returns DefaultSettings.VALUE
     *
     * @return String containing property value.
     */
    public String getDBpassword() {
        return this.properties.getProperty("db-password");
    }

    /**
     * Sets the property value to the param string.
     *
     * @param dbPassword String containing property value.
     */
    public void setDBPassword(String dbPassword) {
        this.properties.setProperty("db-password", dbPassword);
    }

    /**
     * Returns the property value. If the property is not set, returns DefaultSettings.VALUE
     *
     * @return String containing property value.
     */
    public String getDBName() {
        return this.properties.getProperty("db-name");
    }

    /**
     * Sets the property value to the param string.
     *
     * @param dbName String containing property value.
     */
    public void setDBName(String dbName) {
        this.properties.setProperty("db-name", dbName);
    }

    /**
     * Returns the property value. If the property is not set, returns DefaultSettings.VALUE
     *
     * @return String containing property value.
     */
    public String getDBHostname() {
        return this.properties.getProperty("db-hostname");
    }

    /**
     * Sets the property value to the param string.
     *
     * @param dbHostname String containing property value.
     */
    public void setDBHostname(String dbHostname) {
        this.properties.setProperty("db-hostname", dbHostname);
    }

    /**
     * Returns the property value. If the property is not set, returns DefaultSettings.VALUE
     *
     * @return String containing property value.
     */
    public String getDBPort() {
        return this.properties.getProperty("db-port");
    }

    /**
     * Sets the property value to the param string.
     *
     * @param dbPort String containing property value.
     */
    public void setDBPort(int dbPort) {
        this.properties.setProperty("db-port", String.valueOf(dbPort));
    }

    /**
     * Returns the property value. If the property is not set, returns DefaultSettings.VALUE
     *
     * @return String containing property value.
     */
    public String getConfigFile() {
        return this.properties.getProperty("config-file", DefaultSettings.CONFIG_FILE.toString());
    }

    /**
     * Sets the property value to the param string.
     *
     * @param title String containing property value.
     */
    public void setUITitle(String title) {
        this.properties.setProperty("ui-title", title);
    }

    /**
     * Returns the property value. If the property is not set, returns DefaultSettings.VALUE
     *
     * @return String containing property value.
     */
    public String getUITitle() {
        return this.properties.getProperty("ui-title", DefaultSettings.UI_TITLE.toString());
    }

    /**
     * Returns the property value. If the property is not set, returns DefaultSettings.VALUE
     *
     * @return String containing property value.
     */
    public int getUIWidth() {
        return Integer.parseInt(this.properties.getProperty("ui-width", DefaultSettings.UI_WIDTH.toString()));
    }

    /**
     * Sets the property value to the param string.
     *
     * @param width String containing property value.
     */
    public void setUIWidth(int width) {
        this.properties.setProperty("ui-width", String.valueOf(width));
    }

    /**
     * Returns the property value. If the property is not set, returns DefaultSettings.VALUE
     *
     * @return String containing property value.
     */
    public int getUIHeight() {
        return Integer.parseInt(this.properties.getProperty("ui-height", DefaultSettings.UI_HEIGHT.toString()));
    }

    /**
     * Sets the property value to the param string.
     *
     * @param height String containing property value.
     */
    public void setUIHeight(int height) {
        this.properties.setProperty("ui-height", String.valueOf(height));
    }

    /**
     * Gets the current Properties object.
     *
     * @return Currently loaded Properties object.
     */
    public Properties getProperties() {
        return this.properties;
    }
}
