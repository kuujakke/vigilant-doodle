package graphic;

import config.Configuration;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;

/**
 * Created by kuujakke on 5.1.2017.
 */
public class UI extends JFrame {

    private final JPanel panel;
    Configuration config;

    public UI(Configuration config) {
        this.config = config;
        this.panel = new JPanel();
        initUI();
    }

    private void initUI() {
        setTitle(config.getUITitle());
        setSize(this.config.getUIWidth(), this.config.getUIHeight());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LoginView login = new LoginView(config);
        JPanel loginPanel = new JPanel();
        login.placeLoginComponents(loginPanel);
        add(loginPanel);
        setSize(350, 150);
    }

}
