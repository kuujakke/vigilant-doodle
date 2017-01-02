package logiikka;

import java.util.*;

/**
 * 
 */
public class User {

    private String realName;
    private String userName;
    private String password;
    private ArrayList<Role> roles;

    public User(String name, String password) {
        this.userName = name;
        this.password = password;
        this.roles = new ArrayList<>();
    }

    public ArrayList<Project> allProjects() {
        // TODO implement here
        return null;
    }

    public ArrayList<Task> allTasks() {
        // TODO implement here
        return null;
    }

    public ArrayList<Role> allRoles() {
        // TODO implement here
        return null;
    }

    public void createProject(String name) {
        // TODO implement here
    }

    public void joinProject(Project project) {
        // TODO implement here
    }

    public String getRealName() {
        return this.realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return this.userName;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }
}