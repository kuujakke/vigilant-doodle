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

    /**
     * Default constructor
     */
    public Project(String name) {
        this.projectName = name;
        this.projectStatus = new ProjectStatus();
        this.tasks = new ArrayList<>();
        this.leaders = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    /**
     * @return
     */
    public String toString() {
        return this.projectName;
    }

    /**
     * @param task
     */
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /**
     * @return
     */
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    /**
     * @param task
     */
    public void deleteTask(Task task) {
        this.tasks.remove(task);
    }

    /**
     * @param member
     */
    public void addMember(Member member) {
        this.members.add(member);
    }

    /**
     * @param user
     */
    public void removeMember(Member member) {
        this.members.remove(member);
    }

    /**
     * @param user
     */
    public void addLeader(Leader leader) {
        this.leaders.add(leader);
    }

    /**
     * @param user
     */
    public void removeLeader(Leader leader) {
        this.leaders.remove(leader);
    }

    public void setProjectName(String name) {
        this.projectName = name;
    }
}