package graphic;

import config.Configuration;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

/**
 * Graphical User Interface for the application.
 */
public class GUI implements Runnable, ComponentListener {

    private Configuration config;
    private Login login;
    private LoginPanel loginPanel;
    private JFrame frame;
    private ProjectManagement projectManagement;
    private JPanel mainPanel;

    /**
     * Initializes the configuration variable with the configuration passed in.
     */
    @Override
    public void run() {
        this.frame = new JFrame();
        this.frame.setName("MainFrame");
        try {
            this.config = new Configuration();
        } catch (Exception e) {
            e.printStackTrace();
        }
        initUI(this.frame);
        this.mainPanel = new JPanel();
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

    private void initProjectManagement() {
        System.out.println("Initializing Project Management...");
        SwingUtilities.invokeLater(() -> {
            this.frame.getContentPane().remove(this.loginPanel);
            GridBagConstraints c = new GridBagConstraints();
            c.weighty = 1;
            c.weightx = 1;
            c.fill = GridBagConstraints.CENTER;
            frame.setSize(this.config.getUIWidth(), this.config.getUIHeight());
            projectManagement = new ProjectManagement(this.login);
            projectManagement.setSize(this.config.getUIWidth(), this.config.getUIHeight());
            this.frame.getContentPane().add(projectManagement);
            this.frame.invalidate();
            this.frame.validate();
            this.frame.revalidate();
            this.frame.repaint();
            this.frame.setVisible(true);
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
            if (this.login != null && !this.login.loginInformation.isEmpty()) {
                initProjectManagement();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
