import config.Configuration;
import graphic.UI;
import logic.schemes.task.Task;
import logic.roles.taskroles.Supervisor;
import logic.login.User;

import java.awt.*;

/**
 * Loads some default settings
 */
public class Main {

    private static Configuration conf;

    public static void main(String[]args) {
        writeAndLoadDefaultConfig();
        EventQueue.invokeLater(() -> {
            UI ui = new UI(conf);
            ui.setVisible(true);
        });
    }

    public static void writeAndLoadDefaultConfig() {
        conf = new Configuration();
        conf.setProjectName("New Project");
        conf.setProjectDescription("No description yet.");
        conf.setTaskName("New Task");
        conf.setTaskDescription("No description yet.");
        conf.setJobName("New Job");
        conf.setJobDescription("No description yet.");
        conf.setUserName("DefaultUser");
        conf.setUserPassword("password1");
        conf.setDBUser("TestUser");
        conf.setDBPassword("TestPassword");
        conf.setDBName("vigilant-doodle");
        conf.setUIHeight(600);
        conf.setUIWidth(1200);
        conf.setUITitle("Vigilant-doodle");
        conf.writeProperties();
        conf.loadProperties();
    }
}

