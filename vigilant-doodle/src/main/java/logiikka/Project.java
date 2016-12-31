package logiikka;

import java.util.*;

/**
 * 
 */
public class Project {

    private String projectName;
    private ProjectStatus projectStatus;
    public ArrayList<Task> tasks;
    public ArrayList<Leader> leaders;
    public ArrayList<Member> members;

    public Project(String name, Leader leader) {
        this.projectName = name;
        this.projectStatus = new ProjectStatus();
        this.tasks = new ArrayList<>();
        this.leaders = new ArrayList<>();
        this.members = new ArrayList<>();
        this.leaders.add(leader);
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
        this.members.remove(member);
    }

    public void addLeader(Leader leader) {
        this.leaders.add(leader);
    }

    public void removeLeader(Leader leader) {
        this.leaders.remove(leader);
    }
}