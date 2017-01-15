package graphic;

import config.Configuration;
import logic.database.Database;
import org.mongodb.morphia.Datastore;

import javax.swing.*;
import java.util.Properties;

/**
 * This class is used to hold user login information.
 */
public class Login extends JPanel {

    Properties loginInformation;
    private Datastore db;
    private Configuration config;

    /**
     * Initiates the Properties object to be used later on.
     *
     * @param properties object containing the login information.
     */
    public Login(Properties properties) {
        this.loginInformation = properties;
    }

    /**
     * Validates the information that user has given.
     * Checks that properties doesn't have "canceled" set to true before continuing
     * the validation by checking that each property has a minimum length of 3 characters.
     *
     * @param props The Properties object which has the users input stored.
     *
     * @return a truth value whether the input is valid or not.
     *
     * @throws Exception if bad credentials or connection.
     */
    public boolean validateCredentials(Properties props) throws Exception {
        int validStrings = 0;
        for (String prop : props.stringPropertyNames()) {
            if (props.getProperty(prop).length() > 2) {
                validStrings++;
            }
        }
        if (validStrings == props.size()) {
            Database database = new Database(props);
            if (database.connection() != null) {
                this.db = new Database(props).getDatabase();
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the Datastore object.
     *
     * @return Datastore object.
     *
     * @throws Exception if invalid login information or bad connection.
     */
    public Datastore getDatabase() throws Exception {
        if (validateCredentials(this.loginInformation)) {
            return this.db;
        }
        return null;
    }

    /**
     * Sets configuration object.
     *
     * @param config Configuration object.
     */
    public void setConfig(Configuration config) {
        this.config = config;
    }

    /**
     * Gets configuration object or tries to load and return a new configuration.
     *
     * @return Configuration object.
     */
    public Configuration getConfig() throws Exception {
        if (this.config == null) {
            this.config = new Configuration();
        }
        return this.config;
    }
}