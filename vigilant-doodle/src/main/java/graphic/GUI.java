package graphic;

import config.Configuration;
import config.DefaultSettings;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.util.Properties;

/**
 * Graphical User Interface for the application.
 */
public class GUI implements Runnable, ComponentListener {

    Configuration config;
    private Login login;
    private LoginPanel loginPanel;
    private UserPanel userPanel;
    private JFrame frame;

    /**
     * Initializes the configuration variable with the configuration passed in.
     */
    @Override
    public void run() {
        this.frame = new JFrame();
        try {
            this.config = new Configuration();
        } catch (Exception e) {
            e.printStackTrace();
        }
        initUI(this.frame);

        this.loginPanel = new LoginPanel();
        frame.add(this.loginPanel);
        frame.setVisible(true);

        this.loginPanel.addComponentListener(this);
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
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {
        this.login = this.loginPanel.getLogin();
        System.out.println(login);
        this.userPanel = new UserPanel(this.login.getDatabase());
        userPanel.makeLayout();
        this.frame.add(this.userPanel);
        this.frame.setVisible(true);
    }
}
