package logiikka;

import java.util.*;

/**
 * 
 */
public class Member implements Role {

    String name;
    Project project;
    ArrayList<Task> tasks;
    User user;

    /**
     * Default constructor
     * @param name
     */
    public Member(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }


    /**
     * @return
     */
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    @Override
    public User getUser() {
        return this.user;
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