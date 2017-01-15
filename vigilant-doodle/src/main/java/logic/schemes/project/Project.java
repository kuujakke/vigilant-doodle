package logic.schemes.project;

import logic.roles.Role;
import logic.roles.projectroles.Leader;
import logic.roles.projectroles.Member;
import logic.schemes.Scheme;
import logic.schemes.task.Task;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;
import java.util.ArrayList;

/**
 * Base object for managing tasks.
 */
@Entity("projects")
public class Project extends Scheme {
    @Reference("tasks")
    public ArrayList<Task> tasks;
    @Reference("roles")
    public ArrayList<Role> roles;

    /**
     * Zero-arg constructor for morphia.
     */
    public Project() {
    }

    /**
     * Needs a name to be set when creating new instance.
     * @param name String the name to be set to the new instance
     */
    public Project(String name) {
        super(name);
        this.tasks = new ArrayList<>();
        this.roles = new ArrayList<>();
    }

    /**
     * Sets a new project name.
     * @param name String new name for the project
     */
    public void setProjectName(String name) {
        super.setName(name);
    }

    /**
     * Returns a string representation of the Project.
     * @return String the project info.
     */
    public String toString() {
        return super.toString();
    }

    /**
     * Adds a task to the project.
     * @param task Task to be added to the project.
     */
    public void addTask(Task task) {
        if (!this.tasks.contains(task)) {
            this.tasks.add(task);
        }
    }

    /**
     * Gets all the tasks associated with the project.
     * @return ArrayList list containing all the tasks of the project.
     */
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Deletes the given task from the project if existing.
     * @param task Task to be removed.
     */
    public void deleteTask(Task task) {
        if (this.tasks.contains(task)) {
            this.tasks.remove(task);
        }
    }

    /**
     * Gets a list of members associated with project.
     * @return ArrayList list containing all the members of the project.
     */
    public ArrayList<Role> getMembers() {
        ArrayList<Role> members = new ArrayList<>();
        for (Role role : this.roles) {
            if (role instanceof Member) {
                members.add(role);
            }
        }
        return members;
    }

    /**
     * Gets a list of leaders associated with project.
     * @return ArrayList list containing all the leaders of the project.
     */
    public ArrayList<Role> getLeaders() {
        ArrayList<Role> leaders = new ArrayList<>();
        for (Role role : this.roles) {
            if (role instanceof Leader) {
                leaders.add(role);
            }
        }
        return leaders;
    }

    /**
     * Associates a member with project.
     * @param member Member to be added into project.
     */
    public void addMember(Member member) {
        if (!hasMember(member)) {
            this.roles.add(member);
        }
    }

    /**
     * Removes member from the project.
     * @param member Member to be removed from the project.
     */
    public void removeMember(Member member) {
        if (this.hasMember(member)) {
            this.roles.remove(member);
        }
    }

    /**
     * Promotes a new leader to the project from existing member of the project.
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
     * @param leader Leader to be added into project
     */
    public void addLeader(Leader leader) {
        if (!hasLeader(leader)) {
            this.roles.add(leader);
        }
    }

    /**
     * Returns true if the project has the given leader.
     * @param leader Leader to be searched for
     * @return true if leader exists
     */
    public boolean hasLeader(Leader leader) {
        return this.getLeaders().contains(leader);
    }

    /**
     * Returns true if the project has the given member.
     * @param member Member to be searched for
     * @return true if member exists
     */
    public boolean hasMember(Member member) {
        return this.getMembers().contains(member);
    }

    /**
     * Removes the given leader from the project.
     * @param leader Leader to be removed from the project
     */
    public void removeLeader(Leader leader) {
        this.roles.remove(leader);
    }

    /**
     * Sets the project description.
     * @param description String to be set as new description of the project
     */
    public void setDescription(String description) {
        super.setDescription(description);
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