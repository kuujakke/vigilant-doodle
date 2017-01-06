package graphic;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

/**
 * This class is used to popup a window to ask for user login information.
 */

public class Login extends JPanel {

    Properties loginInformation;

    /**
     * Initiates the Properties object to be used later on.
     */
    public Login() {
        this.loginInformation = new Properties();
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
    public Properties getLoginInformation() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        int width = 10;
        int gridy = 0;
        int gridx = 0;

        JLabel userLabel = new JLabel("Username: ");
        setConstraints(c, gridx % 2, gridy);
        add(userLabel, c);
        gridx++;

        JTextField userText = new JTextField(20);
        setConstraints(c, gridx % 2, gridy);
        add(userText, c);
        gridx++;

        gridy++;
        horisontalStrut(2, gridy, c);
        gridy++;

        JLabel passwordLabel = new JLabel("Password: ");
        setConstraints(c, gridx % 2, gridy);
        add(passwordLabel, c);
        gridx++;

        JPasswordField passwordText = new JPasswordField(20);
        setConstraints(c, gridx % 2, gridy);
        add(passwordText, c);
        gridx++;

        gridy++;
        horisontalStrut(width, gridy, c);
        gridy++;

        JLabel dbNameLabel = new JLabel("Database name: ");
        setConstraints(c, gridx % 2, gridy);
        add(dbNameLabel, c);
        gridx++;

        JTextField dbName = new JTextField(20);
        setConstraints(c, gridx % 2, gridy);
        add(dbName, c);
        gridx++;

        gridy++;
        horisontalStrut(2, gridy, c);
        gridy++;

        JLabel dbHostnameLabel = new JLabel("Database hostname: ");
        setConstraints(c, gridx % 2, gridy);
        add(dbHostnameLabel, c);
        gridx++;

        JTextField dbHostname = new JTextField(20);
        setConstraints(c, gridx % 2, gridy);
        add(dbHostname, c);
        gridx++;

        gridy++;
        horisontalStrut(2, gridy, c);
        gridy++;

        JLabel dbPortLabel = new JLabel("Database port: ");
        setConstraints(c, gridx % 2, gridy);
        add(dbPortLabel, c);
        gridx++;

        JTextField dbPort = new JTextField(20);
        setConstraints(c, gridx % 2, gridy);
        add(dbPort, c);
        gridx++;

        gridy++;
        horisontalStrut(2, gridy, c);
        gridy++;

        int result = JOptionPane.showConfirmDialog(null, this, "Please login to proceed", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            this.loginInformation.setProperty("canceled", "0");
            this.loginInformation.setProperty("user-name", userText.getText());
            char[] password = passwordText.getPassword();
            this.loginInformation.setProperty("password", String.valueOf(password));
            this.loginInformation.setProperty("db-name", dbName.getText());
            this.loginInformation.setProperty("db-hostname", dbHostname.getText());
            this.loginInformation.setProperty("db-port", dbPort.getText());
            return this.loginInformation;
        } else if (result == JOptionPane.CANCEL_OPTION) {
            Properties props = new Properties();
            props.setProperty("canceled", "1");
            return props;
        }
        return null;
    }

    /**
     * Sets basic constraints for given position in the GridBagLayout.
     * @param c GridBagConstraints
     * @param gridx Grid X coordinate
     * @param gridy Grid Y coordinate
     */
    private void setConstraints(GridBagConstraints c, int gridx, int gridy) {
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.gridx = gridx;
        c.gridy = gridy;
    }

    /**
     * Validates the information that user has given.
     * Checks that properties doesn't have "canceled" set to true before continuing
     * the validation by checking that each property has a minimum length of 3 characters.
     *
     * @param props The Properties object which has the users input stored.
     * @return a truth value whether the input is valid or not.
     */
    public boolean validateProps(Properties props) {
        int validStrings = 0;
        for (String prop : props.stringPropertyNames()) {
            if (props.getProperty("canceled").equals("1")) {
                return false;
            } else if (props.getProperty(prop).length() > 2) {
                validStrings++;
            }
        }
        if (validStrings == 5) {
            return true;
        }
        return false;
    }

    /**
     * Creates horisontal strut to the grid at given gridy value.
     *
     * @param width Set width of the strut.
     * @param gridy Set the grid position of the strut.
     * @param c     GridBagConstraints
     */
    private void horisontalStrut(int width, int gridy, GridBagConstraints c) {
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = gridy;
        add(Box.createVerticalStrut(width), c);
    }
}