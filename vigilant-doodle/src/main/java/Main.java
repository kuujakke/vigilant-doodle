import config.Configuration;
import graphic.GUI;
import graphic.Login;
import logic.database.Database;

import java.awt.*;
import java.util.Properties;

/**
 * Loads settings and validates the user before it launches the GUI.
 */
public class Main {

    private static Configuration conf;

    /**
     * Main program that starts by loading application configurations.
     * It catches an Exception if the configuration file is not found and
     * prints the error message.
     *
     * After loading it continues by popping up a login dialog window to
     * authenticate the user and to make a new Database connection.
     *
     * When a database is available the program continues by loading
     * users view from the database.
     *
     * @param args Nothing implemented here.
     */
    public static void main(String[] args) {
        try {
            conf = new Configuration();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (authenticateUser()) {
            GUI gui = new GUI(conf);
            gui.setVisible(true);
        }
    }

    /**
     * Authenticates the user by asking for login information using the Login class.
     * @return Whether the user is authenticated and logged in succesfully.
     */
    private static boolean authenticateUser() {
        Login login = new Login();
        Properties props = login.getLoginInformation();
        System.out.println(props);
        if (login.validateProps(props)) {
            Database database = new Database(props);
            return true;
        }
        return false;
    }
}

