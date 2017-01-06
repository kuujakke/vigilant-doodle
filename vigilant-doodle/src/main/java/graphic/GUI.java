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

    public GUI(Configuration config) {
        this.config = config;
        this.panel = new JPanel();
        initUI();
    }

    public void initUI() {
        setTitle(config.getUITitle());
        setSize(this.config.getUIWidth(), this.config.getUIHeight());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
