package logic.login;

import logic.roles.Role;
import logic.roles.RoleFactory;
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
     * @return ArrayList containing all the projects user has a role in.
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
     * @return ArrayList containing all the tasks user has a role in.
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
     * Returns the list of all roles the user has.
     *
     * @return ArrayList containing oll of users active roles.
     */
    public ArrayList<Role> allRoles() {
        return this.roles;
    }

    /**
     * Creates a new project and adds a leader role to the user.
     *
     * @param name String contains the name of the new project.
     */
    public void createProject(String name) {

    }

    /**
     * Joins any available project as a member.
     *
     * @param project Project where the user is joined.
     */
    public void joinProject(Project project) {
        if (!this.hasScheme(project)) {
            project.addMember(new Member(this, project));
        }
    }

    /**
     * Returns the users real name.
     *
     * @return String containing the users real name.
     */
    public String getRealName() {
        return this.realName;
    }

    /**
     * Sets the users real name.
     *
     * @param realName String containing the users real name.
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * Sets the username.
     *
     * @param userName String containing the new username.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the username.
     *
     * @return String containing the username.
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Adds a new role users roles list.
     *
     * @param role Role to be added into roles collection.
     */
    public void addRole(Role role) {
        this.roles.add(role);
    }

    /**
     * Removes the role from the roles collection.
     *
     * @param role Role to be removed.
     */
    public void removeRole(Role role) {
        if (this.roles.contains(role)) {
            this.roles.remove(role);
        }
    }

    /**
     * Returns true if the users roles collection contains the passed in role.
     *
     * @param role Role to be checked if contained in roles.
     * @return true if user has the given role in the roles collection.
     */
    public boolean hasRole(Role role) {
        return this.roles.contains(role);
    }

    /**
     * Returns true if the users roles collection contains a role that has
     * any responsibility in the scheme passed in.
     *
     * @param scheme Scheme to check responsibility from.
     *
     * @return true if user has any role associated with scheme.
     */
    public boolean hasScheme(Scheme scheme) {
        for (Role role :this.allRoles()) {
            if (role.hasResponsibility(scheme)) {
                return true;
            }
        }
        return false;
    }
}