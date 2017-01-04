package logic.schemes.project;

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
public class Project {

    private String projectName;
    private Status status;
    public ArrayList<Task> tasks;
    public HashMap<User, Role> roles;
    private String description;

    public Project(String name) {
        this.projectName = name;
        this.status = new Status();
        this.tasks = new ArrayList<>();
        this.roles = new HashMap<>();
    }

    public void setProjectName(String name) {
        this.projectName = name;
    }

    public String toString() {
        return this.projectName;
    }

    public void addTask(Task task) {
        if (!this.tasks.contains(task)) {
            this.tasks.add(task);
        }
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    public void deleteTask(Task task) {
        this.tasks.remove(task);
    }

    public ArrayList<Role> getMembers() {
        ArrayList<Role> members = new ArrayList<>();
        for (Role role : this.roles.values()) {
            if (role instanceof Member) {
                members.add(role);
            }
        }
        return members;
    }

    public ArrayList<Role> getLeaders() {
        ArrayList<Role> leaders = new ArrayList<>();
        for (Role role : this.roles.values()) {
            if (role instanceof Leader) {
                leaders.add(role);
            }
        }
        return leaders;
    }

    public void addMember(Member member) {
        this.roles.put(member.getUser(), member);
    }

    public void removeMember(Member member) {
        if (this.hasMember(member)) {
            this.roles.remove(member.getUser(), member);
        }
    }

    public void promoteToLeader(Member member) {
        removeMember(member);
        Leader leader = new Leader(member.getUser(), this);
        addLeader(leader);
    }

    public void addLeader(Leader leader) {
        this.roles.put(leader.getUser(), leader);
    }

    public boolean hasLeader(Leader leader) {
        return this.roles.containsValue(leader);
    }

    public boolean hasMember(Member member) {
        return this.roles.containsValue(member);
    }

    public void removeLeader(Leader leader) {
        this.roles.remove(leader.getUser(), leader);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.projectName;
    }
}