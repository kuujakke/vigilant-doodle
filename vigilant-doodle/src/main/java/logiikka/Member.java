package logiikka;

import java.util.*;

/**
 * 
 */
public class Member implements Role {

    private String name;
    private String description;
    private Role role;
    Project project;
    ArrayList<Task> tasks;
    User user;

    /**
     * Default constructor
     * @param name
     */
    public Member(String name, Project project, User user) {
        this.name = name;
        this.tasks = new ArrayList<>();
        this.project = project;
        this.user = user;
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
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}