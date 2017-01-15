package graphic.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

/**
 * Created by kuujakke on 9.1.2017.
 */
public class LoginPanel extends JPanel implements ActionListener {


    private JTextField username;
    private JPasswordField password;
    private JTextField dbName;
    private JTextField dbHostname;
    private JTextField dbPort;
    private JButton button;
    private Properties properties;

    /**
     * Initializes the layout.
     */
    public LoginPanel() {
        makeLayout();
    }
    /**
     * Sets the layout elements to the login window and returns a hash map of the components.
     *
     * @return HashMap containing login window components.
     */
    private void makeLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        int width = 10;
        int gridy = 0;
        int gridx = 0;

        JLabel userLabel = new JLabel("Username: ");
        setConstraints(c, gridx % 2, gridy);
        add(userLabel, c);
        gridx++;

        this.username = new JTextField(20);
        setConstraints(c, gridx % 2, gridy);
        add(username, c);
        gridx++;

        gridy++;
        horisontalStrut(2, gridy, c);
        gridy++;

        JLabel passwordLabel = new JLabel("Password: ");
        setConstraints(c, gridx % 2, gridy);
        add(passwordLabel, c);
        gridx++;

        this.password = new JPasswordField(20);
        setConstraints(c, gridx % 2, gridy);
        add(password, c);
        gridx++;

        gridy++;
        horisontalStrut(width, gridy, c);
        gridy++;

        JLabel dbNameLabel = new JLabel("Database name: ");
        setConstraints(c, gridx % 2, gridy);
        add(dbNameLabel, c);
        gridx++;

        this.dbName = new JTextField(20);
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

        this.dbHostname = new JTextField(20);
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

        this.dbPort = new JTextField(20);
        setConstraints(c, gridx % 2, gridy);
        add(dbPort, c);
        gridx++;

        gridy++;
        horisontalStrut(width, gridy, c);
        gridy++;

        this.button = new JButton("OK");
        setConstraints(c, 1, gridy);
        add(this.button, c);
        this.button.addActionListener(this);


        this.username.setName("db-user");
        this.password.setName("db-password");
        this.dbName.setName("db-name");
        this.dbHostname.setName("db-hostname");
        this.dbPort.setName("db-port");
        this.button.setName("OK");
    }

    /**
     * Sets basic constraints for given position in the GridBagLayout.
     *
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
     * Creates horizontal strut to the grid at given grid row.
     *
     * @param width Set width of the strut.
     * @param gridy Set the grid row position of the strut.
     * @param c     GridBagConstraints
     */
    private void horisontalStrut(int width, int gridy, GridBagConstraints c) {
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = gridy;
        add(Box.createVerticalStrut(width), c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.properties = new Properties();
        properties.setProperty("db-user", this.username.getText());
        String password = String.valueOf(this.password.getPassword());
        properties.setProperty("db-password", password);
        properties.setProperty("db-hostname", this.dbHostname.getText());
        properties.setProperty("db-name", this.dbName.getText());
        properties.setProperty("db-port", this.dbPort.getText());
        this.setVisible(false);
    }

    /**
     * Returns a new Login object if properties and credentials are valid.
     *
     * @return Login object containing validated parameters for database connection.
     *
     * @throws Exception if bad database connection.
     */
    public Login getLogin() throws Exception {
        if (!this.properties.isEmpty() && this.properties != null) {
            Login login = new Login(this.properties);
            if (login.validateCredentials(this.properties)) {
                return login;
            }
        }
        return null;
    }
}
