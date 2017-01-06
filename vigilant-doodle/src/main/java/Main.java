import config.Configuration;
import graphic.GUI;
import graphic.Login;

import java.awt.*;
import java.util.Properties;

/**
 * Loads settings and validates the user before it launches the GUI.
 */
public class Main {

    private static Configuration conf;

    public static void main(String[] args) {
        conf = new Configuration();
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
            return true;
        }
        return false;
    }
}

