package logic.login;

import logic.roles.Role;
import logic.roles.projectroles.Leader;
import logic.roles.projectroles.Member;
import logic.roles.taskroles.Supervisor;
import logic.roles.taskroles.Worker;
import logic.schemes.Scheme;
import logic.schemes.project.Project;
import logic.schemes.task.Task;

import java.util.*;

/**
 * Basic user for the application.
 * User has many roles in many projects, tasks and jobs.
 */
public class User {

    private String realName;
    private String userName;
    private String password;
    private ArrayList<Role> roles;

    /**
     * User needs a name and a password to authenticate.
     *
     * @param name String name os the user.
     * @param password String password of the user.
     */
    public User(String name, String password) {
        this.userName = name;
        this.password = password;
        this.roles = new ArrayList<>();
    }

    /**
     * Lists all current projects where user has a role in it.
     *
     * @return ArrayList<Project> containing all the projects user has a role in.
     */
    public ArrayList<Project> allProjects() {
        ArrayList<Project> projects = new ArrayList<>();
        for (Role role : this.roles) {
            if (role instanceof Member) {
                projects.add(((Member) role).getProject());
            } else if (role instanceof Leader) {
                projects.add(((Member) role).getProject());
            }
        }
        return projects;
    }

    /**
     * Lists all current tasks where user has a role in it.
     *
     * @return ArrayList<Task> containing all the tasks user has a role in.
     */
    public ArrayList<Task> allTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        for (Role role : this.roles) {
            if (role instanceof Worker) {
                tasks.add(((Worker) role).getTask());
            } else if (role instanceof Supervisor) {
                tasks.add(((Worker) role).getTask());
            }
        }
        return tasks;
    }

    /**
     * Removes the task role if user has that role listed.
     *
     * @param task Task where the user has a role in.
     */
    public void removeTask(Task task) {
        if (this.allTasks().contains(task)) {
            for (Role role : this.roles) {
                if (role.hasResponsibility(task)) {
                    this.roles.remove(role);
                }
            }
        }
    }

    /**
     * 
     * @return
     */
    public ArrayList<Role> allRoles() {
        return this.roles;
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

    public void removeRole(Role role) {
        if (this.roles.contains(role)) {
            this.roles.remove(role);
        }
    }

    public boolean hasRole(Role role) {
        return this.roles.contains(role);
    }
}