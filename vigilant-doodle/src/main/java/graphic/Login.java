package graphic;

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

    /**
     * Initiates the Properties object to be used later on.
     *
     * @param properties object containing the login information.
     */
    public Login(Properties properties) {
        this.loginInformation = properties;
    }

    /**
     * Used to popup a JOptionPane to ask user for login information.
     * Sets up a jPanel layout and adds labels, text boxes and a login button.
     * It asks for Username, password, database name and database address.
     * Next it casts a JOptionPane to get user input and returns the Propeties
     * object containing the login information.
     *
     * @return Properties object containing users login information.
     */
/*    public Properties getLoginInformation() {
        HashMap<String, JComponent> components = makeLayout();
        int result = JOptionPane.showConfirmDialog(null, this, "Please login to proceed", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            this.loginInformation.setProperty("canceled", "0");
            this.loginInformation.setProperty("user-name", ((JTextField) components.get("username")).getText());
            char[] password = ((JPasswordField) components.get("password")).getPassword();
            this.loginInformation.setProperty("password", String.valueOf(password));
            this.loginInformation.setProperty("db-name", ((JTextField) components.get("db-name")).getText());
            this.loginInformation.setProperty("db-hostname", ((JTextField) components.get("db-hostname")).getText());
            this.loginInformation.setProperty("db-port", ((JTextField) components.get("db-port")).getText());
            return this.loginInformation;
        } else if (result == JOptionPane.CANCEL_OPTION) {
            Properties props = new Properties();
            props.setProperty("canceled", "1");
            return props;
        }
        return null;
    }*/




    /**
     * Validates the information that user has given.
     * Checks that properties doesn't have "canceled" set to true before continuing
     * the validation by checking that each property has a minimum length of 3 characters.
     *
     * @param props The Properties object which has the users input stored.
     *
     * @return a truth value whether the input is valid or not.
     */
    public boolean validateCredentials(Properties props) {
        int validStrings = 0;
        for (String prop : props.stringPropertyNames()) {
            if (props.getProperty(prop).length() > 2) {
                validStrings++;
            }
        }
        if (validStrings == props.size()) {
            try {
                this.db = new Database(props).getDatabase();
                System.out.println(db.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    public Datastore getDatabase() {
        return this.db;
    }


}