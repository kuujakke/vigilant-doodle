package logiikka;

import java.util.*;

/**
 * 
 */
public class Member extends Role {

    private Project project;
    private ArrayList<Task> tasks;

    public Member(User user, Project project) {
        super(user);
        this.project = project;
        this.tasks = new ArrayList<>();
        user.addRole(this);
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    public Project getProject() {
        return this.project;
    }
}