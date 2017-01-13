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

    private Configuration config;
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
        initLogin();
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

    private void initLogin() {
        System.out.println("Initializing login...");
        SwingUtilities.invokeLater(() -> {
            loginPanel = new LoginPanel();
            frame.add(loginPanel);
            frame.setSize(600, 200);
            frame.setVisible(true);
            frame.getContentPane().add(loginPanel);
            frame.invalidate();
            frame.validate();
            this.loginPanel.addComponentListener(this);
        });
    }

    private void initUser() {
        System.out.println("Initializing user view...");
        SwingUtilities.invokeLater(() -> {
            this.frame.getContentPane().remove(this.loginPanel);
            this.frame.getContentPane().add(this.userPanel);
            frame.setSize(this.config.getUIWidth(), this.config.getUIHeight());
            this.frame.invalidate();
            this.frame.validate();
            this.frame.revalidate();
            this.frame.repaint();
        });
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
        try {
            this.login = this.loginPanel.getLogin();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        if (this.login != null && !this.login.loginInformation.isEmpty()) {
            try {
                this.userPanel = new UserPanel(this.login.getDatabase());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        initUser();
    }
}
