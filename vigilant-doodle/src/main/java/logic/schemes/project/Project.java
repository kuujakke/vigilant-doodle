package logic.schemes.project;

import logic.schemes.Scheme;
import logic.schemes.Status;
import logic.schemes.task.Task;
import logic.roles.projectroles.Leader;
import logic.roles.projectroles.Member;
import logic.roles.Role;
import logic.login.User;

import java.util.*;

/**
 * Base object for managing tasks.
 */
public class Project extends Scheme {

    private Status status;
    public ArrayList<Task> tasks;
    public HashMap<User, Role> roles;
    private String description;

    /**
     * Needs a name to be set when creating new instance.
     *
     * @param name String the name to be set to the new instance
     */
    public Project(String name) {
        super(name);
        this.status = new Status();
        this.tasks = new ArrayList<>();
        this.roles = new HashMap<>();
    }

    /**
     * Sets a new project name.
     *
     * @param name String new name for the project
     */
    public void setProjectName(String name) {
        super.setName(name);
    }

    /**
     * Returns a string representation of the Project.
     *
     * @return String the project info.
     */
    public String toString() {
        return super.toString();
    }

    /**
     * Adds a task to the project.
     *
     * @param task Task to be added to the project.
     */
    public void addTask(Task task) {
        if (!this.tasks.contains(task)) {
            this.tasks.add(task);
        }
    }

    /**
     * Gets all the tasks associated with the project.
     *
     * @return ArrayList<Task> list containing all the tasks of the project.
     */
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Deletes the given task from the project if existing.
     *
     * @param task Task to be removed.
     */
    public void deleteTask(Task task) {
        if (this.tasks.contains(task)) {
            this.tasks.remove(task);
        }
    }

    /**
     * Gets a list of members associated with project.
     *
     * @return ArrayList<Role> list containing all the members of the project.
     */
    public ArrayList<Role> getMembers() {
        ArrayList<Role> members = new ArrayList<>();
        for (Role role : this.roles.values()) {
            if (role instanceof Member) {
                members.add(role);
            }
        }
        return members;
    }

    /**
     * Gets a list of leaders associated with project.
     *
     * @return ArrayList<Role> list containing all the leaders of the project.
     */
    public ArrayList<Role> getLeaders() {
        ArrayList<Role> leaders = new ArrayList<>();
        for (Role role : this.roles.values()) {
            if (role instanceof Leader) {
                leaders.add(role);
            }
        }
        return leaders;
    }

    /**
     * Associates a member with project.
     *
     * @param member Member to be added into project.
     */
    public void addMember(Member member) {
        this.roles.put(member.getUser(), member);
    }

    /**
     * Removes member from the project.
     *
     * @param member Member to be removed from the project.
     */
    public void removeMember(Member member) {
        if (this.hasMember(member)) {
            this.roles.remove(member.getUser(), member);
        }
    }

    /**
     * Promotes a new leader to the project from existing member of the project.
     *
     * @param member Member to be promoted to a leader.
     */
    public void promoteToLeader(Member member) {
        if (this.hasMember(member)) {
            removeMember(member);
            Leader leader = new Leader(member.getUser(), this);
            addLeader(leader);
        }
    }

    /**
     * Adds a leader to the project.
     *
     * @param leader Leader to be added into project
     */
    public void addLeader(Leader leader) {
        this.roles.put(leader.getUser(), leader);
    }

    /**
     * Returns true if the project has the given leader.
     *
     * @param leader Leader to be searched for
     * @return true if leader exists
     */
    public boolean hasLeader(Leader leader) {
        return this.getLeaders().contains(leader);
    }

    /**
     * Returns true if the project has the given member.
     *
     * @param member Member to be searched for
     * @return true if member exists
     */
    public boolean hasMember(Member member) {
        return this.getMembers().contains(member);
    }

    /**
     * Removes the given leader from the project.
     *
     * @param leader Leader to be removed from the project
     */
    public void removeLeader(Leader leader) {
        this.roles.remove(leader.getUser(), leader);
    }

    /**
     * Sets the project description.
     *
     * @param description String to be set as new description of the project
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the project name.
     *
     * @return String containing the projects name
     */
    public String getName() {
        return super.getName();
    }

    @Override
    public boolean hasScheme(Scheme scheme) {
        return this.tasks.contains(scheme);
    }
}