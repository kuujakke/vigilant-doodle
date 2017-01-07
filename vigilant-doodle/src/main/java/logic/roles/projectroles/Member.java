package logic.roles.projectroles;

import logic.roles.Role;
import logic.login.User;
import logic.schemes.project.Project;
import logic.schemes.task.Task;

import java.util.*;

/**
 * Basic role for projects.
 */
public class Member extends Role {

    private Project project;
    private ArrayList<Task> tasks;

    /**
     * Passes the user object to abstract superclass and initializes the project
     * variable with given project. Initializes the tasks ArrayList to hold
     * all active tasks of the member.
     *
     * @param user User to be passed on to Role superclass
     * @param project Project to which the member belongs to
     */
    public Member(User user, Project project) {
        super(user);
        this.project = project;
        this.tasks = new ArrayList<>();
    }

    /**
     * Returns a list containing all the members tasks.
     *
     * @return ArrayList<Task> Tasks assosiated with Member
     */
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Getter for members associated project.
     *
     * @return Project where the member belongs to.
     */
    public Project getProject() {
        return this.project;
    }

    /**
     * Setter to set a new Project on a Member.
     *
     * @param project Project to add the member to.
     */
    public void setProject(Project project) {
        project.removeMember(this);
        this.project = project;
        this.project.addMember(this);
    }
}