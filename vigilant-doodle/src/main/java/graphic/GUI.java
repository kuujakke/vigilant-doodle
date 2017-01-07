package graphic;

import config.Configuration;

import javax.swing.*;
import javax.swing.JFrame;
import java.util.Properties;

/**
 * Graphical User Interface for the application.
 */
public class GUI extends JFrame {

    private final JPanel panel;
    Configuration config;

    /**
     * Initializes the configuration variable with the configuration passed in.
     *
     * @param config Configuration to be used in the object.
     */
    public GUI(Configuration config) {
        this.config = config;
        this.panel = new JPanel();
        initUI();
    }

    /**
     * Initializes the GUI window.
     */
    private void initUI() {
        setTitle(config.getUITitle());
        setSize(this.config.getUIWidth(), this.config.getUIHeight());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
