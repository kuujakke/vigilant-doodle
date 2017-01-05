package graphic;

import config.Configuration;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kuujakke on 5.1.2017.
 */
public class LoginView {

    private final Configuration config;

    public LoginView(Configuration config) {
        this.config = config;
    }

        public void placeLoginComponents(JPanel jPanel) {
            jPanel.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            int frameWidth = this.config.getUIWidth();
            int frameHeight = this.config.getUIHeight();

            int frameCenterWidth = frameWidth / 2;
            int frameCenterHeight = frameHeight / 2;

            int labelWidth = 80;
            int labelHeight = 25;

            int boxWidth = 160;
            int boxHeight = 25;

            int buttonWidth = 20;
            int buttonHeight = 20;

            JLabel userLabel = new JLabel("Username");
            //c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 0.5;
            c.gridx = 0;
            c.gridy = 0;
            jPanel.add(userLabel, c);

            JTextField userText = new JTextField(20);
            //c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 0.5;
            c.gridx = 1;
            c.gridy = 0;
            jPanel.add(userText, c);

            JLabel passwordLabel = new JLabel("Password");
            //c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 0;
            c.gridx = 0;
            c.gridy = 1;
            jPanel.add(passwordLabel, c);

            JPasswordField passwordText = new JPasswordField(20);
            //c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 0.5;
            c.gridx = 1;
            c.gridy = 1;
            jPanel.add(passwordText, c);


            JButton loginButton = new JButton("Login");
            //c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 0.5;
            c.gridx = 1;
            c.gridy = 2;
            c.ipady = buttonWidth;
            c.ipadx = buttonHeight;
            jPanel.add(loginButton, c);

        }

}
