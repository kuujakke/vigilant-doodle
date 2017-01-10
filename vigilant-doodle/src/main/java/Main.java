import graphic.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Loads settings and validates the user before it launches the GUI.
 */
public class Main {

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
        SwingUtilities.invokeLater(new GUI());
    }

}

