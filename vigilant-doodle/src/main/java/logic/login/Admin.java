
package logic.login;

import logic.schemes.project.Project;

/**
 * Admin class to administrate the application.
 */
public class Admin extends User {

    /**
     * Passes the name and password to its superclass.
     *
     * @param name String name of the admin user.
     * @param password String password for admin user.
     */
    public Admin(String name, String password) {
        super(name, password);
    }

    /**
     * Admin has the power to delete projects.
     *
     * @param project Project to be deleted from the application.
     */
    public void deleteProject(Project project) {
        // TODO implement here
    }

    /**
     * Admin method to create new user.
     *
     * @param name String users name
     * @param password String users password.
     */
    public void createUser(String name, String password) {
        // TODO implement here
    }

    /**
     * Method to delete existing user from the application.
     *
     * @param user User to be deleted.
     */
    public void deleteUser(User user) {
        // TODO implement here
    }

}