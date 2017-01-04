import config.Configuration;
import logic.schemes.task.Task;
import logic.roles.taskroles.Supervisor;
import logic.login.User;

/**
 * Loads some default settings
 */
public class Main {
    public static void main(String[]args) {
        Configuration conf = new Configuration();
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
        conf.writeProperties();
        System.out.println(conf);
    }
}

