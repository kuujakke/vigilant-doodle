package graphic;

import config.Configuration;
import config.DefaultSettings;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

/**
 * Graphical User Interface for the application.
 */
public class GUI implements Runnable, ActionListener {

    Configuration config;
    private Login login;

    /**
     * Initializes the configuration variable with the configuration passed in.
     */
    @Override
    public void run() {
        JFrame frame = new JFrame();
        try {
            this.config = new Configuration();
        } catch (Exception e) {
            e.printStackTrace();
        }
        initUI(frame);

        LoginPanel loginPanel = new LoginPanel();
        frame.add(loginPanel);
        frame.setVisible(true);

        this.login = loginPanel.getLogin();

        /*
        EventQueue.invokeLater(this.login = new Login());
        Properties credentials = login.getLoginInformation();
        if (login.validateCredentials(credentials)) {
            setVisible(true);
            initUI();
        }*/
    }

    /**
     * Initializes the GUI window.
     */
    private void initUI(JFrame frame) {
        frame.setTitle(config.getUITitle());
        frame.setSize(this.config.getUIWidth(), this.config.getUIHeight());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
