
package logic.login;

import logic.schemes.project.Project;

/**
 * Admin class to administrate the application.
 */
public class Admin extends User {

    public Admin(String name, String password) {
        super(name, password);
    }

    public void deleteProject(Project project) {
        // TODO implement here
    }

    public void createUser(String name) {
        // TODO implement here
    }

    public void deleteUser(User user) {
        // TODO implement here
    }

}