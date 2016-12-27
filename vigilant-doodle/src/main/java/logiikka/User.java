package logiikka;

import java.util.*;

/**
 * 
 */
public class User implements Role {

    private String userName;
    private String password;

    /**
     * Default constructor
     */
    public User(String name) {
        this.userName = name;
    }

    /**
     * 
     */
    public ArrayList<Role> roles;


    /**
     * @return
     */
    public ArrayList<Project> allProjects() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public ArrayList<Task> allTasks() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public ArrayList<Role> allRoles() {
        // TODO implement here
        return null;
    }

    /**
     * @param name
     */
    public void createProject(String name) {
        // TODO implement here
    }

    /**
     * @param project
     */
    public void joinProject(Project project) {
        // TODO implement here
    }

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public Role getRole() {
        return null;
    }

    @Override
    public String getRoleName() {
        return null;
    }

    @Override
    public String getRoleDescription() {
        return null;
    }

    @Override
    public void setRoleName(String name) {

    }

    @Override
    public void setRoleDescription(String description) {

    }
}