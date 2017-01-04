package logic.roles.projectroles;

import logic.roles.Role;
import logic.login.User;
import logic.schemes.project.Project;
import logic.schemes.task.Task;

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
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    public Project getProject() {
        return this.project;
    }
}