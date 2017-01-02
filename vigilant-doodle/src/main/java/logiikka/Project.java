package logiikka;

import java.util.*;

/**
 * 
 */
public class Project {

    private String projectName;
    private Status status;
    public ArrayList<Task> tasks;
    public ArrayList<Leader> leaders;
    public ArrayList<Member> members;

    public Project(String name) {
        this.projectName = name;
        this.status = new Status();
        this.tasks = new ArrayList<>();
        this.leaders = new ArrayList<>();
        this.members = new ArrayList<>();
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

    public void addMember(Member member) {
        this.members.add(member);
    }

    public void removeMember(Member member) {
        if (this.members.contains(member)) {
            this.members.remove(member);
        }
    }

    public void promoteToLeader(Member member) {
        removeMember(member);
        Leader leader = new Leader(member.getUser(), this);
        addLeader(leader);
    }

    public void addLeader(Leader leader) {
        this.leaders.add(leader);
    }

    public void removeLeader(Leader leader) {
        this.leaders.remove(leader);
    }
}